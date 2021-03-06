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
package eu.numberfour.n4js.typesbuilder

import com.google.inject.Inject
import com.google.inject.Singleton
import eu.numberfour.n4js.AnnotationDefinition
import eu.numberfour.n4js.n4JS.Block
import eu.numberfour.n4js.n4JS.FunctionDeclaration
import eu.numberfour.n4js.n4JS.FunctionDefinition
import eu.numberfour.n4js.n4JS.N4MethodDeclaration
import eu.numberfour.n4js.n4JS.SuperLiteral
import eu.numberfour.n4js.n4JS.ThisLiteral
import eu.numberfour.n4js.ts.scoping.builtin.BuiltInTypeScope
import eu.numberfour.n4js.ts.typeRefs.ThisTypeRef
import eu.numberfour.n4js.ts.types.MemberAccessModifier
import eu.numberfour.n4js.ts.types.TMethod
import eu.numberfour.n4js.ts.types.TypesFactory
import eu.numberfour.n4js.ts.utils.TypeUtils
import eu.numberfour.n4js.utils.EcoreUtilN4
import org.eclipse.emf.ecore.EObject

@Singleton
package class N4JSMethodTypesBuilder extends AbstractFunctionDefinitionTypesBuilder {

	@Inject extension N4JSTypesBuilderHelper

	/**
	 * Creates TMethod for the given method declaration (and links it to that method).
	 *
	 * @param methodDecl declaration for which the TMethod is created, must not be linked to a TMethod yet (i.e. its defined type must be null).
	 * @param preLinkingPhase
	 */
	def package createMethod(N4MethodDeclaration methodDecl, boolean preLinkingPhase) {
		if (methodDecl.definedType !== null && ! methodDecl.definedType.eIsProxy) {
			throw new IllegalStateException("TMethod already created for N4MethodDeclaration");
		}
		if (methodDecl.name === null && !methodDecl.callableConstructor) {
			return null
		}
		val methodType = TypesFactory::eINSTANCE.createTMethod();
		methodType.name = methodDecl.name;
		methodType.declaredAbstract = methodDecl.abstract
		methodType.declaredStatic = methodDecl.declaredStatic
		methodType.declaredFinal = methodDecl.declaredFinal
		methodType.declaredOverride = AnnotationDefinition.OVERRIDE.hasAnnotation(methodDecl);
		methodType.constructor = methodDecl.constructor
		methodType.declaredAsync = methodDecl.async // TODO change to declaredAsync one the annotation is gone
		methodType.declaredGenerator = methodDecl.generator

		val providesDefaultImpl = AnnotationDefinition.PROVIDES_DEFAULT_IMPLEMENTATION.hasAnnotation(methodDecl);
		methodType.hasNoBody = methodDecl.body===null && !providesDefaultImpl;

		methodType.lacksThisOrSuperUsage = hasNonNullBody(methodDecl.body) && !containsThisOrSuperUsage(methodDecl.body)

		// TODO if possible, remove, see AbstractFunctionDefinitionTypesBuilder
		val builtInTypeScope = BuiltInTypeScope.get(methodDecl.eResource.resourceSet)

		methodType.setMemberAccessModifier(methodDecl)
		methodType.addTypeVariables(methodDecl, preLinkingPhase)
		methodType.addFormalParameters(methodDecl, builtInTypeScope, preLinkingPhase)
		methodType.setReturnTypeConsideringThis(methodDecl, builtInTypeScope, preLinkingPhase)
		methodType.setDeclaredThisTypeFromAnnotation(methodDecl, preLinkingPhase)

		methodType.copyAnnotations(methodDecl, preLinkingPhase)

		// link
		methodType.astElement = methodDecl
		methodDecl.definedType = methodType

		return methodType;
	}

	def private setMemberAccessModifier(TMethod methodType, N4MethodDeclaration n4Method) {
		setMemberAccessModifier([MemberAccessModifier modifier|methodType.declaredMemberAccessModifier = modifier],
			n4Method.declaredModifiers, n4Method.annotations)
	}

	/**
	 * Sets the return type. If the declared return type is 'this', a ComputedTypeRef will
	 * be created to generate a bound this type.
	 */
	def private setReturnTypeConsideringThis(TMethod methodType, N4MethodDeclaration methodDecl,
		BuiltInTypeScope builtInTypeScope, boolean preLinkingPhase) {
		if (methodDecl.isConstructor || methodDecl.returnTypeRef instanceof ThisTypeRef) {
			// special case: TypeDeferredProcessor will create a BoundThisTypeRef via Xsemantics judgment 'thisTypeRef'
			methodType.returnTypeRef = TypeUtils.createDeferredTypeRef
		} else {
			// standard case
			methodType.setReturnType(methodDecl, builtInTypeScope, preLinkingPhase)
		}
	}

	private def hasNonNullBody(Block body) {
		(null !== body) &&
		(null !== body.allStatements)
	}

	/**
	 * Checks for the presence of 'this' or 'super' usages in the given body,
	 * also including sub-expressions (eg, 'if (sub-expr)'),
	 * without delving inside function definitions or declarations.
	 * <p>
	 * Static methods refer to static members via ThisLiteral.
	 */
	private def containsThisOrSuperUsage(Block body) {
		body.allStatements.exists[ stmt |
			isThisOrSuperUsage(stmt) ||
			EcoreUtilN4.getAllContentsFiltered(stmt, [!isFnDefOrDecl(it)]).exists[isThisOrSuperUsage(it)];
		]
	}

	private def isFnDefOrDecl(EObject ast) {
		ast instanceof FunctionDeclaration || ast instanceof FunctionDefinition
	}

	private def isThisOrSuperUsage(EObject expr) {
		expr instanceof SuperLiteral || expr instanceof ThisLiteral
	}

}
