/**
 * Copyright (c) 2016 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   NumberFour AG - Initial API and implementation
 */
package eu.numberfour.n4js.validation.validators

import com.google.inject.Inject
import eu.numberfour.n4js.n4JS.FormalParameter
import eu.numberfour.n4js.n4JS.IdentifierRef
import eu.numberfour.n4js.n4JS.N4ClassDeclaration
import eu.numberfour.n4js.n4JS.N4JSPackage
import eu.numberfour.n4js.n4JS.N4MethodDeclaration
import eu.numberfour.n4js.n4JS.NewExpression
import eu.numberfour.n4js.n4JS.ObjectLiteral
import eu.numberfour.n4js.resource.N4JSResource
import eu.numberfour.n4js.ts.typeRefs.StructuralTypeRef
import eu.numberfour.n4js.ts.typeRefs.ThisTypeRef
import eu.numberfour.n4js.ts.typeRefs.ThisTypeRefStructural
import eu.numberfour.n4js.ts.types.ContainerType
import eu.numberfour.n4js.ts.types.PrimitiveType
import eu.numberfour.n4js.ts.types.TClass
import eu.numberfour.n4js.ts.types.TClassifier
import eu.numberfour.n4js.ts.types.TField
import eu.numberfour.n4js.ts.types.TFormalParameter
import eu.numberfour.n4js.ts.types.TFunction
import eu.numberfour.n4js.ts.types.TInterface
import eu.numberfour.n4js.ts.types.TMethod
import eu.numberfour.n4js.ts.types.TObjectPrototype
import eu.numberfour.n4js.ts.types.TSetter
import eu.numberfour.n4js.typesystem.N4JSTypeSystem
import eu.numberfour.n4js.typesystem.RuleEnvironmentExtensions
import eu.numberfour.n4js.typesystem.TypingStrategyFilter
import eu.numberfour.n4js.utils.ContainerTypesHelper
import eu.numberfour.n4js.validation.AbstractN4JSDeclarativeValidator
import eu.numberfour.n4js.validation.IssueCodes
import eu.numberfour.n4js.validation.IssueUserDataKeys
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.EValidatorRegistrar

import static com.google.common.collect.Iterables.getOnlyElement
import static eu.numberfour.n4js.AnnotationDefinition.*
import static eu.numberfour.n4js.n4JS.N4JSPackage.Literals.*
import static eu.numberfour.n4js.ts.types.TypingStrategy.*
import static eu.numberfour.n4js.validation.IssueCodes.*
import static eu.numberfour.n4js.validation.validators.StaticPolyfillValidatorExtension.*
import eu.numberfour.n4js.ts.utils.TypeUtils

/**
 * superfluous properties in {@code @Spec} constructor.
 */
class N4JSClassValidator extends AbstractN4JSDeclarativeValidator {

	@Inject N4JSTypeSystem ts;

	@Inject PolyfillValidatorFragment polyfillValidatorFragment;

	@Inject extension ContainerTypesHelper containerTypesHelper;

	/**
	 * NEEEDED
	 *
	 * when removed check methods will be called twice once by N4JSValidator, and once by
	 * AbstractDeclarativeN4JSValidator
	 */
	override register(EValidatorRegistrar registrar) {
		// nop
	}

	/**
	 * Non abstract test classes have to exported: IDEBUG-572.
	 */
	@Check
	def void checkTestClassExported(N4ClassDeclaration classDecl) {
		if (classDecl?.definedType instanceof TClass) {
			var clazz = classDecl.definedType as TClass;
			if (!clazz.abstract && !clazz.exported && clazz.hasTestMethods) {
				addIssue(getMessageForCLF_TEST_CLASS_NOT_EXPORTED, classDecl,
					N4_TYPE_DECLARATION__NAME, CLF_TEST_CLASS_NOT_EXPORTED
				);
			}
		}
	}

	// Get all transitive methods and checks if any of them has @Test annotation
	private def hasTestMethods(TClass clazz) {
		if (null !== clazz?.eResource) {
			val module = N4JSResource.getModule(clazz.eResource);
			if (null !== module) {
				return containerTypesHelper.fromContext(module).allMembers(clazz, false, false)
					.filter(TMethod).exists[TEST_METHOD.hasAnnotation(it)];
			}
		}
		return false;
	}

	/**
	 * Method for checking if an object literal in {@code @Spec} constructor provides any superfluous properties.
	 * If so, validation warning will be raised for each violating properties.
	 * IDE-1014.
	 */
	@Check
	def void checkSuperfluousPropertiesForSpecConstructor(NewExpression newExpression) {

		if (!(newExpression.callee instanceof IdentifierRef)) {
			return;
		}
		val identifierRef = newExpression.callee as IdentifierRef;

		if (!(identifierRef.id instanceof TClass)) {
			return;
		}
		val tclass = identifierRef.id as TClass;
		val ctor = newExpression.fromContext.findConstructor(tclass);

		// ctor might be null if class has a super class that cannot be resolved
		if (null === ctor || ctor.fpars.isNullOrEmpty) {
			return;
		}

		// Collect constructor parameters with @Spec annotation.
		// Probably finding the first parameter with @Spec annotation would be
		// fine enough since using more than one is not allowed anyway.
		val fparsWithSpecAnnotation = ctor.fpars.filter[null !== SPEC.getAnnotation(it)].toList;

		if (fparsWithSpecAnnotation.isNullOrEmpty) {
			return;
		}

		if (fparsWithSpecAnnotation.size > 1) {
			return;
		}

		val fparWithSpecAnnotation = getOnlyElement(fparsWithSpecAnnotation);
		val typeRef = fparWithSpecAnnotation.typeRef;

		// Not a field structural 'this' reference, nothing to validate.
		if (!(typeRef instanceof ThisTypeRefStructural) || STRUCTURAL_FIELD_INITIALIZER !== typeRef.typingStrategy) {
			return;
		}

		val indexOfTheSpecFpar = ctor.fpars.indexOf(fparWithSpecAnnotation);

		// Possible broken AST or optional formal parameters. Abort validation process.
		if (0 > indexOfTheSpecFpar || newExpression.arguments.size <= indexOfTheSpecFpar) {
			return;
		}

		if (!(newExpression.arguments.get(indexOfTheSpecFpar)?.expression instanceof ObjectLiteral)) {
			return;
		}
		val objectLiteral = newExpression.arguments.get(indexOfTheSpecFpar)?.expression as ObjectLiteral;
		if (!(objectLiteral.definedType instanceof ContainerType<?>)) {
			return;
		}

		val strategy = new TypingStrategyFilter(STRUCTURAL)
		val publicWritableFields = newExpression.fromContext.allMembers(tclass).filter(TField).filter[strategy.apply(it)].map[
			name].toList;

		// These are available via the 'with' keyword add them to the accepted ones
		publicWritableFields.addAll((typeRef as ThisTypeRefStructural).structuralMembers.filter(TField).map[name]);

		// Public setters should be accepted as well.
		publicWritableFields.addAll(
			newExpression.fromContext.allMembers(tclass).filter(TSetter).filter[setter|
				strategy.apply(setter)].map[name]);

		val inputMembers = (objectLiteral.definedType as ContainerType<?>).ownedMembers
		inputMembers.forEach [
			if (!publicWritableFields.contains(name)) {
				val message = getMessageForCLF_SPEC_SUPERFLUOUS_PROPERTIES(name);
				addIssue(message, astElement, PROPERTY_NAME_OWNER__DECLARED_NAME, CLF_SPEC_SUPERFLUOUS_PROPERTIES);
			}
		];

	}

	@Check
	def void checkN4ClassDeclaration(N4ClassDeclaration n4Class) {

		// wrong parsed
		if (!(n4Class.definedType instanceof TClass)) {
			return;
		}

		if (polyfillValidatorFragment.holdsPolyfill(this, n4Class)) {
			val tClass = n4Class.definedType as TClass;
			internalCheckAbstractFinal(tClass);

			if (holdsSuperClass(n4Class)) { // avoid consequential errors
				holdsNoCyclicInheritance(n4Class);
			}
			
			internalCheckPolyFilledClassWithAdditionalInterface(n4Class,this);
			internalCheckImplementedInterfaces(n4Class);
			internalCheckSpecAnnotation(n4Class);
		}
	}

	/**
	 * Overridden to be accessible from PolyfillValidatorFragment
	 */
	override void addIssue(String message, EObject source, EStructuralFeature feature, String issueCode,
		String... issueData) {
		super.addIssue(message, source, feature, issueCode, issueData);
	}

	def private internalCheckAbstractFinal(TClass tClass) {
		if (tClass.abstract && tClass.final) {
			val message = getMessageForCLF_ABSTRACT_FINAL("class");
			addIssue(message, tClass.astElement, N4_TYPE_DECLARATION__NAME, CLF_ABSTRACT_FINAL);
		}
	}

	def private boolean holdsSuperClass(N4ClassDeclaration n4Class) {
		val superType = n4Class.superClassRef?.declaredType;
		if (superType !== null && superType.name !== null) { // note: in case superType.name===null, the type reference is completely invalid and other, more appropriate error messages have been created elsewhere

			if (superType instanceof PrimitiveType) {
				val message = getMessageForCLF_EXTENDS_PRIMITIVE_GENERIC_TYPE(superType.name);
				addIssue(message, n4Class.superClassRef, null, CLF_EXTENDS_PRIMITIVE_GENERIC_TYPE);
			} else if (!(superType instanceof TClass) && !(superType instanceof TObjectPrototype)) {
				if (superType instanceof TInterface) {
					val message = getMessageForSYN_KW_EXTENDS_IMPLEMENTS_MIXED_UP(n4Class.description, "extend",
						superType.description, "implements");
					addIssue(message, n4Class.superClassRef, null, SYN_KW_EXTENDS_IMPLEMENTS_MIXED_UP);
				} else {
					val message = getMessageForCLF_WRONG_META_TYPE(n4Class.description, "extend", superType.description);
					addIssue(message, n4Class.superClassRef, null, CLF_WRONG_META_TYPE);
					return false;
				}
			} else if (superType instanceof TClass) {



				// (got a super class; now validate it ...)
				// super class must not be final
				if (superType.final) {
					val message = getMessageForCLF_EXTEND_FINAL(superType.name);

					val superClassUri = EcoreUtil.getURI(superType.astElement).toString;

					addIssue(message, n4Class.superClassRef, null, CLF_EXTEND_FINAL,IssueUserDataKeys.CLF_EXTEND_FINAL.SUPER_TYPE_DECLARATION_URI,superClassUri);
					return false;
				}

				// if super class is observable, then this class must be observable as well
				if (superType.observable && !(n4Class.definedType as TClass).observable) {
					val message = getMessageForCLF_OBSERVABLE_MISSING(n4Class.name, superType.name);
					addIssue(message, n4Class, N4_TYPE_DECLARATION__NAME, CLF_OBSERVABLE_MISSING);
					return false;
				}
			}
		}
		return true;
	}

	def private internalCheckImplementedInterfaces(N4ClassDeclaration n4Class) {
		n4Class.implementedInterfaceRefs.forEach [
			val consumedType = it.declaredType;
			if (consumedType !== null && consumedType.name !== null) { // note: in case consumedType.name===null, the type reference is completely invalid and other, more appropriate error messages have been created elsewhere

				// consumed type must be an interface
				if (!(consumedType instanceof TInterface)) {
					if ((consumedType instanceof TClass || consumedType instanceof TObjectPrototype) &&
						n4Class.superClassRef === null) {
						val message = getMessageForSYN_KW_EXTENDS_IMPLEMENTS_MIXED_UP(n4Class.description, "implement",
							consumedType.description, "extends");
						addIssue(message, it, null, SYN_KW_EXTENDS_IMPLEMENTS_MIXED_UP);
					} else {
						val message = getMessageForCLF_WRONG_META_TYPE(n4Class.description, "implement",
							consumedType.description);
						addIssue(message, it, null, CLF_WRONG_META_TYPE);
					}
				}
			}
		]
	}

	def private internalCheckSpecAnnotation(N4ClassDeclaration n4ClassDeclaration) {
		val N4MethodDeclaration ctor = n4ClassDeclaration.ownedCtor;
		if (ctor !== null) {
			var specAnnotations = newArrayList;
			var int i = 0;
			for (FormalParameter currFPar : ctor.fpars) {
				val annSpec = SPEC.getAnnotation(currFPar);
				if (annSpec !== null) {
					specAnnotations.add(annSpec);
					if (!(currFPar.declaredTypeRef instanceof ThisTypeRef &&
						(STRUCTURAL_FIELD_INITIALIZER === currFPar.declaredTypeRef.typingStrategy
							|| STRUCTURAL === currFPar.declaredTypeRef.typingStrategy
						))) {
						val message = messageForCLF_SPEC_WRONG_TYPE;
						addIssue(message, annSpec, null, CLF_SPEC_WRONG_TYPE);
					} else { // prevent consequential errors
						holdsAdditionalSpecFieldMatchesOwnedFields(
							n4ClassDeclaration,
							ctor,
							i
						);
					}
				}
				i = i + 1;
			}
			if (specAnnotations.size >= 2) {
				for (currAnnSpec : specAnnotations) {
					val message = messageForCLF_SPEC_MULTIPLE;
					addIssue(message, currAnnSpec, null, CLF_SPEC_MULTIPLE);
				}
			}
		}
	}

	def holdsAdditionalSpecFieldMatchesOwnedFields(
		N4ClassDeclaration n4ClassDeclaration,
		N4MethodDeclaration ctor,
		int parIndex
	) {
		val TClass tclass = n4ClassDeclaration.definedType as TClass;
		val fpars = (ctor.definedType as TFunction).fpars;
		if (parIndex >= fpars.size) return; //broken AST
		val TFormalParameter fpar = fpars.get(parIndex);
		val fparType = fpar.typeRef;
		val G = RuleEnvironmentExtensions.newRuleEnvironment(n4ClassDeclaration);

		var int memberIndex = 0;
		for (smember : fparType.structuralMembers) {
			val tfield = tclass.ownedMembers.findFirst[name == smember.name];
			if (tfield !== null && (tfield.isField || tfield.isSetter)) {
				val fieldType = ts.tau(tfield, TypeUtils.createTypeRef(tclass));
				val smemberType = ts.tau(smember, TypeUtils.createTypeRef(tclass));
				val subtypeRes = ts.subtype(G, smemberType, fieldType);
				if (subtypeRes.failed) {
					val message = getMessageForCLF_SPEC_WRONG_ADD_MEMBERTYPE(smember.name, description(tfield),
						trimTypesystemMessage(subtypeRes));
					val errMember = (ctor.fpars.get(parIndex).declaredTypeRef as StructuralTypeRef).structuralMembers.
						get(memberIndex);
					val sourceObject = (if (errMember.astElement !== null) errMember.astElement else errMember);
					addIssue(
						message,
						sourceObject,
						CLF_SPEC_WRONG_ADD_MEMBERTYPE
					);
				}

			}
			memberIndex = memberIndex + 1;

		}

	}

	def private boolean holdsNoCyclicInheritance(N4ClassDeclaration n4ClassDeclaration) {
		val cls = n4ClassDeclaration.definedType as TClassifier;
		val cycle = findCyclicInheritance(cls);
		if(cycle!==null) {
			val message = IssueCodes.getMessageForCLF_INHERITANCE_CYCLE(cycle.map[name].join(", "));
			addIssue(message, n4ClassDeclaration, N4JSPackage.Literals.N4_CLASS_DEFINITION__SUPER_CLASS_REF,
				IssueCodes.CLF_INHERITANCE_CYCLE);
			return false;
		}
		return true;
	}
}
