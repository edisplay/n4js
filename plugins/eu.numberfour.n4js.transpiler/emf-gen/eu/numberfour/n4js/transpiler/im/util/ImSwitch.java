/**
 * Copyright (c) 2016 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package eu.numberfour.n4js.transpiler.im.util;

import eu.numberfour.n4js.n4JS.AnnotableElement;
import eu.numberfour.n4js.n4JS.AnnotableN4MemberDeclaration;
import eu.numberfour.n4js.n4JS.Expression;
import eu.numberfour.n4js.n4JS.FieldAccessor;
import eu.numberfour.n4js.n4JS.FunctionDefinition;
import eu.numberfour.n4js.n4JS.FunctionOrFieldAccessor;
import eu.numberfour.n4js.n4JS.GenericDeclaration;
import eu.numberfour.n4js.n4JS.GetterDeclaration;
import eu.numberfour.n4js.n4JS.IdentifierRef;
import eu.numberfour.n4js.n4JS.Literal;
import eu.numberfour.n4js.n4JS.MethodDeclaration;
import eu.numberfour.n4js.n4JS.ModifiableElement;
import eu.numberfour.n4js.n4JS.N4FieldAccessor;
import eu.numberfour.n4js.n4JS.N4GetterDeclaration;
import eu.numberfour.n4js.n4JS.N4MemberDeclaration;
import eu.numberfour.n4js.n4JS.N4MethodDeclaration;
import eu.numberfour.n4js.n4JS.N4SetterDeclaration;
import eu.numberfour.n4js.n4JS.NamedElement;
import eu.numberfour.n4js.n4JS.ParameterizedAccess;
import eu.numberfour.n4js.n4JS.ParameterizedPropertyAccessExpression;
import eu.numberfour.n4js.n4JS.PrimaryExpression;
import eu.numberfour.n4js.n4JS.PropertyNameOwner;
import eu.numberfour.n4js.n4JS.Script;
import eu.numberfour.n4js.n4JS.SetterDeclaration;
import eu.numberfour.n4js.n4JS.StrictModeRelevant;
import eu.numberfour.n4js.n4JS.StringLiteral;
import eu.numberfour.n4js.n4JS.ThisArgProvider;
import eu.numberfour.n4js.n4JS.TypeDefiningElement;
import eu.numberfour.n4js.n4JS.TypeProvidingElement;
import eu.numberfour.n4js.n4JS.TypedElement;
import eu.numberfour.n4js.n4JS.VariableEnvironmentElement;

import eu.numberfour.n4js.transpiler.im.*;

import eu.numberfour.n4js.ts.typeRefs.BaseTypeRef;
import eu.numberfour.n4js.ts.typeRefs.ParameterizedTypeRef;
import eu.numberfour.n4js.ts.typeRefs.ParameterizedTypeRefStructural;
import eu.numberfour.n4js.ts.typeRefs.StaticBaseTypeRef;
import eu.numberfour.n4js.ts.typeRefs.StructuralTypeRef;
import eu.numberfour.n4js.ts.typeRefs.TypeArgument;
import eu.numberfour.n4js.ts.typeRefs.TypeRef;
import eu.numberfour.n4js.ts.typeRefs.Versionable;
import eu.numberfour.n4js.ts.types.TypableElement;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see eu.numberfour.n4js.transpiler.im.ImPackage
 * @generated
 */
public class ImSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ImPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImSwitch() {
		if (modelPackage == null) {
			modelPackage = ImPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ImPackage.SCRIPT_IM: {
				Script_IM script_IM = (Script_IM)theEObject;
				T result = caseScript_IM(script_IM);
				if (result == null) result = caseScript(script_IM);
				if (result == null) result = caseVariableEnvironmentElement(script_IM);
				if (result == null) result = caseAnnotableElement(script_IM);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImPackage.SYMBOL_TABLE: {
				SymbolTable symbolTable = (SymbolTable)theEObject;
				T result = caseSymbolTable(symbolTable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImPackage.SYMBOL_TABLE_ENTRY: {
				SymbolTableEntry symbolTableEntry = (SymbolTableEntry)theEObject;
				T result = caseSymbolTableEntry(symbolTableEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImPackage.SYMBOL_TABLE_ENTRY_ORIGINAL: {
				SymbolTableEntryOriginal symbolTableEntryOriginal = (SymbolTableEntryOriginal)theEObject;
				T result = caseSymbolTableEntryOriginal(symbolTableEntryOriginal);
				if (result == null) result = caseSymbolTableEntry(symbolTableEntryOriginal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImPackage.SYMBOL_TABLE_ENTRY_IM_ONLY: {
				SymbolTableEntryIMOnly symbolTableEntryIMOnly = (SymbolTableEntryIMOnly)theEObject;
				T result = caseSymbolTableEntryIMOnly(symbolTableEntryIMOnly);
				if (result == null) result = caseSymbolTableEntry(symbolTableEntryIMOnly);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImPackage.SYMBOL_TABLE_ENTRY_INTERNAL: {
				SymbolTableEntryInternal symbolTableEntryInternal = (SymbolTableEntryInternal)theEObject;
				T result = caseSymbolTableEntryInternal(symbolTableEntryInternal);
				if (result == null) result = caseSymbolTableEntry(symbolTableEntryInternal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImPackage.REFERENCING_ELEMENT_IM: {
				ReferencingElement_IM referencingElement_IM = (ReferencingElement_IM)theEObject;
				T result = caseReferencingElement_IM(referencingElement_IM);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImPackage.REFERENCING_ELEMENT_EXPRESSION_IM: {
				ReferencingElementExpression_IM referencingElementExpression_IM = (ReferencingElementExpression_IM)theEObject;
				T result = caseReferencingElementExpression_IM(referencingElementExpression_IM);
				if (result == null) result = caseReferencingElement_IM(referencingElementExpression_IM);
				if (result == null) result = caseExpression(referencingElementExpression_IM);
				if (result == null) result = caseTypableElement(referencingElementExpression_IM);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImPackage.IDENTIFIER_REF_IM: {
				IdentifierRef_IM identifierRef_IM = (IdentifierRef_IM)theEObject;
				T result = caseIdentifierRef_IM(identifierRef_IM);
				if (result == null) result = caseIdentifierRef(identifierRef_IM);
				if (result == null) result = caseReferencingElementExpression_IM(identifierRef_IM);
				if (result == null) result = casePrimaryExpression(identifierRef_IM);
				if (result == null) result = caseStrictModeRelevant(identifierRef_IM);
				if (result == null) result = caseVersionable(identifierRef_IM);
				if (result == null) result = caseReferencingElement_IM(identifierRef_IM);
				if (result == null) result = caseExpression(identifierRef_IM);
				if (result == null) result = caseTypableElement(identifierRef_IM);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImPackage.PARAMETERIZED_PROPERTY_ACCESS_EXPRESSION_IM: {
				ParameterizedPropertyAccessExpression_IM parameterizedPropertyAccessExpression_IM = (ParameterizedPropertyAccessExpression_IM)theEObject;
				T result = caseParameterizedPropertyAccessExpression_IM(parameterizedPropertyAccessExpression_IM);
				if (result == null) result = caseParameterizedPropertyAccessExpression(parameterizedPropertyAccessExpression_IM);
				if (result == null) result = caseReferencingElementExpression_IM(parameterizedPropertyAccessExpression_IM);
				if (result == null) result = caseExpression(parameterizedPropertyAccessExpression_IM);
				if (result == null) result = caseParameterizedAccess(parameterizedPropertyAccessExpression_IM);
				if (result == null) result = caseReferencingElement_IM(parameterizedPropertyAccessExpression_IM);
				if (result == null) result = caseTypableElement(parameterizedPropertyAccessExpression_IM);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImPackage.PARAMETERIZED_TYPE_REF_IM: {
				ParameterizedTypeRef_IM parameterizedTypeRef_IM = (ParameterizedTypeRef_IM)theEObject;
				T result = caseParameterizedTypeRef_IM(parameterizedTypeRef_IM);
				if (result == null) result = caseParameterizedTypeRef(parameterizedTypeRef_IM);
				if (result == null) result = caseReferencingElement_IM(parameterizedTypeRef_IM);
				if (result == null) result = caseBaseTypeRef(parameterizedTypeRef_IM);
				if (result == null) result = caseStaticBaseTypeRef(parameterizedTypeRef_IM);
				if (result == null) result = caseTypeRef(parameterizedTypeRef_IM);
				if (result == null) result = caseTypeArgument(parameterizedTypeRef_IM);
				if (result == null) result = caseVersionable(parameterizedTypeRef_IM);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImPackage.PARAMETERIZED_TYPE_REF_STRUCTURAL_IM: {
				ParameterizedTypeRefStructural_IM parameterizedTypeRefStructural_IM = (ParameterizedTypeRefStructural_IM)theEObject;
				T result = caseParameterizedTypeRefStructural_IM(parameterizedTypeRefStructural_IM);
				if (result == null) result = caseParameterizedTypeRef_IM(parameterizedTypeRefStructural_IM);
				if (result == null) result = caseParameterizedTypeRefStructural(parameterizedTypeRefStructural_IM);
				if (result == null) result = caseParameterizedTypeRef(parameterizedTypeRefStructural_IM);
				if (result == null) result = caseReferencingElement_IM(parameterizedTypeRefStructural_IM);
				if (result == null) result = caseStructuralTypeRef(parameterizedTypeRefStructural_IM);
				if (result == null) result = caseBaseTypeRef(parameterizedTypeRefStructural_IM);
				if (result == null) result = caseStaticBaseTypeRef(parameterizedTypeRefStructural_IM);
				if (result == null) result = caseTypeRef(parameterizedTypeRefStructural_IM);
				if (result == null) result = caseTypeArgument(parameterizedTypeRefStructural_IM);
				if (result == null) result = caseVersionable(parameterizedTypeRefStructural_IM);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImPackage.SNIPPET: {
				Snippet snippet = (Snippet)theEObject;
				T result = caseSnippet(snippet);
				if (result == null) result = caseExpression(snippet);
				if (result == null) result = caseTypableElement(snippet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImPackage.DELEGATING_MEMBER: {
				DelegatingMember delegatingMember = (DelegatingMember)theEObject;
				T result = caseDelegatingMember(delegatingMember);
				if (result == null) result = caseN4MemberDeclaration(delegatingMember);
				if (result == null) result = caseAnnotableElement(delegatingMember);
				if (result == null) result = caseModifiableElement(delegatingMember);
				if (result == null) result = caseTypeProvidingElement(delegatingMember);
				if (result == null) result = caseTypableElement(delegatingMember);
				if (result == null) result = caseNamedElement(delegatingMember);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImPackage.DELEGATING_GETTER_DECLARATION: {
				DelegatingGetterDeclaration delegatingGetterDeclaration = (DelegatingGetterDeclaration)theEObject;
				T result = caseDelegatingGetterDeclaration(delegatingGetterDeclaration);
				if (result == null) result = caseN4GetterDeclaration(delegatingGetterDeclaration);
				if (result == null) result = caseDelegatingMember(delegatingGetterDeclaration);
				if (result == null) result = caseGetterDeclaration(delegatingGetterDeclaration);
				if (result == null) result = caseN4FieldAccessor(delegatingGetterDeclaration);
				if (result == null) result = caseFieldAccessor(delegatingGetterDeclaration);
				if (result == null) result = caseTypedElement(delegatingGetterDeclaration);
				if (result == null) result = caseAnnotableN4MemberDeclaration(delegatingGetterDeclaration);
				if (result == null) result = caseFunctionOrFieldAccessor(delegatingGetterDeclaration);
				if (result == null) result = casePropertyNameOwner(delegatingGetterDeclaration);
				if (result == null) result = caseN4MemberDeclaration(delegatingGetterDeclaration);
				if (result == null) result = caseAnnotableElement(delegatingGetterDeclaration);
				if (result == null) result = caseVariableEnvironmentElement(delegatingGetterDeclaration);
				if (result == null) result = caseThisArgProvider(delegatingGetterDeclaration);
				if (result == null) result = caseTypableElement(delegatingGetterDeclaration);
				if (result == null) result = caseTypeProvidingElement(delegatingGetterDeclaration);
				if (result == null) result = caseNamedElement(delegatingGetterDeclaration);
				if (result == null) result = caseModifiableElement(delegatingGetterDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImPackage.DELEGATING_SETTER_DECLARATION: {
				DelegatingSetterDeclaration delegatingSetterDeclaration = (DelegatingSetterDeclaration)theEObject;
				T result = caseDelegatingSetterDeclaration(delegatingSetterDeclaration);
				if (result == null) result = caseN4SetterDeclaration(delegatingSetterDeclaration);
				if (result == null) result = caseDelegatingMember(delegatingSetterDeclaration);
				if (result == null) result = caseSetterDeclaration(delegatingSetterDeclaration);
				if (result == null) result = caseN4FieldAccessor(delegatingSetterDeclaration);
				if (result == null) result = caseFieldAccessor(delegatingSetterDeclaration);
				if (result == null) result = caseAnnotableN4MemberDeclaration(delegatingSetterDeclaration);
				if (result == null) result = caseFunctionOrFieldAccessor(delegatingSetterDeclaration);
				if (result == null) result = casePropertyNameOwner(delegatingSetterDeclaration);
				if (result == null) result = caseN4MemberDeclaration(delegatingSetterDeclaration);
				if (result == null) result = caseAnnotableElement(delegatingSetterDeclaration);
				if (result == null) result = caseVariableEnvironmentElement(delegatingSetterDeclaration);
				if (result == null) result = caseThisArgProvider(delegatingSetterDeclaration);
				if (result == null) result = caseTypableElement(delegatingSetterDeclaration);
				if (result == null) result = caseTypeProvidingElement(delegatingSetterDeclaration);
				if (result == null) result = caseNamedElement(delegatingSetterDeclaration);
				if (result == null) result = caseModifiableElement(delegatingSetterDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImPackage.DELEGATING_METHOD_DECLARATION: {
				DelegatingMethodDeclaration delegatingMethodDeclaration = (DelegatingMethodDeclaration)theEObject;
				T result = caseDelegatingMethodDeclaration(delegatingMethodDeclaration);
				if (result == null) result = caseN4MethodDeclaration(delegatingMethodDeclaration);
				if (result == null) result = caseDelegatingMember(delegatingMethodDeclaration);
				if (result == null) result = caseAnnotableN4MemberDeclaration(delegatingMethodDeclaration);
				if (result == null) result = caseMethodDeclaration(delegatingMethodDeclaration);
				if (result == null) result = caseN4MemberDeclaration(delegatingMethodDeclaration);
				if (result == null) result = caseFunctionDefinition(delegatingMethodDeclaration);
				if (result == null) result = caseGenericDeclaration(delegatingMethodDeclaration);
				if (result == null) result = caseTypedElement(delegatingMethodDeclaration);
				if (result == null) result = casePropertyNameOwner(delegatingMethodDeclaration);
				if (result == null) result = caseModifiableElement(delegatingMethodDeclaration);
				if (result == null) result = caseTypeProvidingElement(delegatingMethodDeclaration);
				if (result == null) result = caseNamedElement(delegatingMethodDeclaration);
				if (result == null) result = caseFunctionOrFieldAccessor(delegatingMethodDeclaration);
				if (result == null) result = caseTypeDefiningElement(delegatingMethodDeclaration);
				if (result == null) result = caseAnnotableElement(delegatingMethodDeclaration);
				if (result == null) result = caseTypableElement(delegatingMethodDeclaration);
				if (result == null) result = caseVariableEnvironmentElement(delegatingMethodDeclaration);
				if (result == null) result = caseThisArgProvider(delegatingMethodDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ImPackage.STRING_LITERAL_FOR_STE: {
				StringLiteralForSTE stringLiteralForSTE = (StringLiteralForSTE)theEObject;
				T result = caseStringLiteralForSTE(stringLiteralForSTE);
				if (result == null) result = caseStringLiteral(stringLiteralForSTE);
				if (result == null) result = caseLiteral(stringLiteralForSTE);
				if (result == null) result = casePrimaryExpression(stringLiteralForSTE);
				if (result == null) result = caseExpression(stringLiteralForSTE);
				if (result == null) result = caseTypableElement(stringLiteralForSTE);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Script IM</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Script IM</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScript_IM(Script_IM object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Symbol Table</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Symbol Table</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSymbolTable(SymbolTable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Symbol Table Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Symbol Table Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSymbolTableEntry(SymbolTableEntry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Symbol Table Entry Original</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Symbol Table Entry Original</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSymbolTableEntryOriginal(SymbolTableEntryOriginal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Symbol Table Entry IM Only</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Symbol Table Entry IM Only</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSymbolTableEntryIMOnly(SymbolTableEntryIMOnly object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Symbol Table Entry Internal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Symbol Table Entry Internal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSymbolTableEntryInternal(SymbolTableEntryInternal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Referencing Element IM</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Referencing Element IM</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReferencingElement_IM(ReferencingElement_IM object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Referencing Element Expression IM</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Referencing Element Expression IM</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReferencingElementExpression_IM(ReferencingElementExpression_IM object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identifier Ref IM</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identifier Ref IM</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentifierRef_IM(IdentifierRef_IM object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameterized Property Access Expression IM</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameterized Property Access Expression IM</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterizedPropertyAccessExpression_IM(ParameterizedPropertyAccessExpression_IM object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameterized Type Ref IM</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameterized Type Ref IM</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterizedTypeRef_IM(ParameterizedTypeRef_IM object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameterized Type Ref Structural IM</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameterized Type Ref Structural IM</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterizedTypeRefStructural_IM(ParameterizedTypeRefStructural_IM object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Snippet</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Snippet</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSnippet(Snippet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Delegating Member</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Delegating Member</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDelegatingMember(DelegatingMember object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Delegating Getter Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Delegating Getter Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDelegatingGetterDeclaration(DelegatingGetterDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Delegating Setter Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Delegating Setter Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDelegatingSetterDeclaration(DelegatingSetterDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Delegating Method Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Delegating Method Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDelegatingMethodDeclaration(DelegatingMethodDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Literal For STE</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Literal For STE</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringLiteralForSTE(StringLiteralForSTE object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Environment Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Environment Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableEnvironmentElement(VariableEnvironmentElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Annotable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annotable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnnotableElement(AnnotableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Script</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Script</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScript(Script object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypableElement(TypableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpression(Expression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primary Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimaryExpression(PrimaryExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Strict Mode Relevant</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Strict Mode Relevant</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStrictModeRelevant(StrictModeRelevant object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Versionable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Versionable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVersionable(Versionable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identifier Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identifier Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentifierRef(IdentifierRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameterized Access</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameterized Access</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterizedAccess(ParameterizedAccess object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameterized Property Access Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameterized Property Access Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterizedPropertyAccessExpression(ParameterizedPropertyAccessExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Argument</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Argument</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeArgument(TypeArgument object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeRef(TypeRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Static Base Type Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Static Base Type Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStaticBaseTypeRef(StaticBaseTypeRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Base Type Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Base Type Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBaseTypeRef(BaseTypeRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameterized Type Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameterized Type Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterizedTypeRef(ParameterizedTypeRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Structural Type Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structural Type Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructuralTypeRef(StructuralTypeRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameterized Type Ref Structural</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameterized Type Ref Structural</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterizedTypeRefStructural(ParameterizedTypeRefStructural object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Modifiable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Modifiable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModifiableElement(ModifiableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Providing Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Providing Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeProvidingElement(TypeProvidingElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>N4 Member Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>N4 Member Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseN4MemberDeclaration(N4MemberDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>This Arg Provider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>This Arg Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThisArgProvider(ThisArgProvider object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function Or Field Accessor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function Or Field Accessor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionOrFieldAccessor(FunctionOrFieldAccessor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Name Owner</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Name Owner</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyNameOwner(PropertyNameOwner object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Field Accessor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Field Accessor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFieldAccessor(FieldAccessor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypedElement(TypedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Getter Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Getter Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGetterDeclaration(GetterDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Annotable N4 Member Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annotable N4 Member Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnnotableN4MemberDeclaration(AnnotableN4MemberDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>N4 Field Accessor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>N4 Field Accessor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseN4FieldAccessor(N4FieldAccessor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>N4 Getter Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>N4 Getter Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseN4GetterDeclaration(N4GetterDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Setter Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Setter Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetterDeclaration(SetterDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>N4 Setter Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>N4 Setter Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseN4SetterDeclaration(N4SetterDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Defining Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Defining Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeDefiningElement(TypeDefiningElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionDefinition(FunctionDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Generic Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generic Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGenericDeclaration(GenericDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Method Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Method Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMethodDeclaration(MethodDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>N4 Method Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>N4 Method Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseN4MethodDeclaration(N4MethodDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteral(Literal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringLiteral(StringLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //ImSwitch
