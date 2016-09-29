/**
 * Copyright (c) 2016 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package eu.numberfour.n4js.ts.typeRefs;

import eu.numberfour.n4js.ts.types.TFormalParameter;
import eu.numberfour.n4js.ts.types.TFunction;
import eu.numberfour.n4js.ts.types.TypeVariable;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Type Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Function type expression for declaring the type of a variable, parameter, etc. as a function.
 * Clients only <em>using</em> these kind of references should probably better use the API of
 * {@link FunctionTypeExprOrRef}.
 * <p>
 * There are the following use cases of FunctionTypeExpressions:
 * <ol>
 * <li>ordinary, self-contained function type expressions, in particular (i) non-generic
 *     <em>and</em> generic function type expressions that were created programmatically and
 *     (ii) AST nodes for non(!)-generic function type expressions (<b>standard use case</b>).
 * <li>those that are created by type system rule 'substTypeVarialbesInFunctionType[ExprOr]Ref'
 *     as a copy of another
 *     <ol type="a">
 *     <li>FunctionTypeRef or
 *     <li>FunctionTypeExpression
 *     </ol>
 *     to represent a particular binding of the original FunctionTypeRef/FunctionTypeExpression
 *     (<b>work-around case</b>).
 * <li>those that represent AST nodes for <em>generic</em> function type expressions
 *     (<b>work-around case</b>).
 * </ol>
 * In standard case 1 the FunctionTypeExpression does *not* have a 'declaredType', because it
 * does not define an actual function (no element like TFunction to be stored in type model).
 * This is why class FunctionTypeExpression does not inherit from BaseTypeRef.
 * <p>
 * Case 2 is only a work-around, because the FunctionTypeRef cannot hold bound references to the
 * function's parameters, and therefore a FunctionTypeExpression is created in the xsemantics rule
 * 'substTypeVarialbesInFunctionType[ExprOr]Ref' to represent the binding. In case 2.a only, the
 * FunctionTypeExpression will have a 'declaredType' pointing to the TFunction of the original
 * FunctionTypeRef.
 * <p>
 * Case 3 is also a work-around, required because resolution of lazy links takes place after the
 * types builder may have copied the FunctionTypeExpression contained in the AST and therefore the
 * lazy references to the type variables will be copied to the types model as well. As a result,
 * it is impossible to let the type variable references point to different type variables in the
 * original and copied function type expressions (which would be required for the "self-contained"
 * use case #1 above). The solution is to create a TFunction from the function type expression
 * contained in the AST and let all type variable references point to the type variables in that
 * TFunction. After this adjustment, the function type expression in the AST can be copied without
 * any special handling.
 * <p>
 * Note: this class is intended for function type(!) expressions and may play the role of an
 * ordinary type reference or an AST node; for function expressions there exists a different
 * class {@link eu.numberfour.n4js.n4JS.FunctionExpression FunctionExpression} that can
 * only be used as an AST node.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.numberfour.n4js.ts.typeRefs.FunctionTypeExpression#isBinding <em>Binding</em>}</li>
 *   <li>{@link eu.numberfour.n4js.ts.typeRefs.FunctionTypeExpression#getDeclaredType <em>Declared Type</em>}</li>
 *   <li>{@link eu.numberfour.n4js.ts.typeRefs.FunctionTypeExpression#getDeclaredThisType <em>Declared This Type</em>}</li>
 *   <li>{@link eu.numberfour.n4js.ts.typeRefs.FunctionTypeExpression#getOwnedTypeVars <em>Owned Type Vars</em>}</li>
 *   <li>{@link eu.numberfour.n4js.ts.typeRefs.FunctionTypeExpression#getUnboundTypeVars <em>Unbound Type Vars</em>}</li>
 *   <li>{@link eu.numberfour.n4js.ts.typeRefs.FunctionTypeExpression#getUnboundTypeVarsUpperBounds <em>Unbound Type Vars Upper Bounds</em>}</li>
 *   <li>{@link eu.numberfour.n4js.ts.typeRefs.FunctionTypeExpression#getFpars <em>Fpars</em>}</li>
 *   <li>{@link eu.numberfour.n4js.ts.typeRefs.FunctionTypeExpression#getReturnTypeRef <em>Return Type Ref</em>}</li>
 * </ul>
 *
 * @see eu.numberfour.n4js.ts.typeRefs.TypeRefsPackage#getFunctionTypeExpression()
 * @model
 * @generated
 */
public interface FunctionTypeExpression extends FunctionTypeExprOrRef {
	/**
	 * Returns the value of the '<em><b>Binding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Tells if this FunctionTypeExpression represents a binding of a TFunction or
	 * another FunctionTypeExpression (use cases 2.a and 2.b, respectively).
	 * Always true in use case 2; always false in use cases 1 and 3.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Binding</em>' attribute.
	 * @see #setBinding(boolean)
	 * @see eu.numberfour.n4js.ts.typeRefs.TypeRefsPackage#getFunctionTypeExpression_Binding()
	 * @model unique="false"
	 * @generated
	 */
	boolean isBinding();

	/**
	 * Sets the value of the '{@link eu.numberfour.n4js.ts.typeRefs.FunctionTypeExpression#isBinding <em>Binding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Binding</em>' attribute.
	 * @see #isBinding()
	 * @generated
	 */
	void setBinding(boolean value);

	/**
	 * Returns the value of the '<em><b>Declared Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Always <code>null</code> in use case 1. In use case 2.a (not 2.b) this refers(!)
	 * to the original TFunction for which this FunctionTypeExpression represents a binding.
	 * For more details on use cases see API doc of {@link FunctionTypeExpression}.
	 * In use case 3 this refers(!) to the TFunction in the type model generated from
	 * the FunctionTypeExpression in the AST.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Declared Type</em>' reference.
	 * @see #setDeclaredType(TFunction)
	 * @see eu.numberfour.n4js.ts.typeRefs.TypeRefsPackage#getFunctionTypeExpression_DeclaredType()
	 * @model
	 * @generated
	 */
	TFunction getDeclaredType();

	/**
	 * Sets the value of the '{@link eu.numberfour.n4js.ts.typeRefs.FunctionTypeExpression#getDeclaredType <em>Declared Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declared Type</em>' reference.
	 * @see #getDeclaredType()
	 * @generated
	 */
	void setDeclaredType(TFunction value);

	/**
	 * Returns the value of the '<em><b>Declared This Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Reference to the declared this-type via @This annotation inside the FunctionTypeExpression.
	 * In use case 2.a this is a copy of <code>declaredType.declaredThisType</code>, in use case
	 * 2.b this is a copy of the original FunctionTypeExperession's declaredThisType.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Declared This Type</em>' containment reference.
	 * @see #setDeclaredThisType(TypeRef)
	 * @see eu.numberfour.n4js.ts.typeRefs.TypeRefsPackage#getFunctionTypeExpression_DeclaredThisType()
	 * @model containment="true"
	 * @generated
	 */
	TypeRef getDeclaredThisType();

	/**
	 * Sets the value of the '{@link eu.numberfour.n4js.ts.typeRefs.FunctionTypeExpression#getDeclaredThisType <em>Declared This Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declared This Type</em>' containment reference.
	 * @see #getDeclaredThisType()
	 * @generated
	 */
	void setDeclaredThisType(TypeRef value);

	/**
	 * Returns the value of the '<em><b>Owned Type Vars</b></em>' containment reference list.
	 * The list contents are of type {@link eu.numberfour.n4js.ts.types.TypeVariable}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Type variables declared in FunctionTypeExpression (programmatically or in the AST).
	 * In use case #2 this is always empty.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Type Vars</em>' containment reference list.
	 * @see eu.numberfour.n4js.ts.typeRefs.TypeRefsPackage#getFunctionTypeExpression_OwnedTypeVars()
	 * @model containment="true"
	 * @generated
	 */
	EList<TypeVariable> getOwnedTypeVars();

	/**
	 * Returns the value of the '<em><b>Unbound Type Vars</b></em>' reference list.
	 * The list contents are of type {@link eu.numberfour.n4js.ts.types.TypeVariable}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Always empty in use cases #1 and #3.
	 * In use case #2 this refers(!) to those type variables of the 'declaredType' (case 2.a)
	 * or original FunctionTypeExpression (case 2.b) that were *not* bound when creating this
	 * FunctionTypeExpression as a representation of a particular type variable binding of the
	 * 'declaredType' / original FunctionTypeExpression.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Unbound Type Vars</em>' reference list.
	 * @see eu.numberfour.n4js.ts.typeRefs.TypeRefsPackage#getFunctionTypeExpression_UnboundTypeVars()
	 * @model
	 * @generated
	 */
	EList<TypeVariable> getUnboundTypeVars();

	/**
	 * Returns the value of the '<em><b>Unbound Type Vars Upper Bounds</b></em>' containment reference list.
	 * The list contents are of type {@link eu.numberfour.n4js.ts.typeRefs.TypeRef}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Property 'unboundTypeVars' refers to type variables contained somewhere else. During type variable substitution,
	 * we would have to substitute type variable in their upper bounds, but we cannot, of course, directly change them.
	 * Thus, for the type variables in unboundTypeVars, rule 'substTypeVarialbesInFunctionType[ExprOr]Ref' will store
	 * the upper bounds here, but only if they are different from the type variables original upper bounds.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Unbound Type Vars Upper Bounds</em>' containment reference list.
	 * @see eu.numberfour.n4js.ts.typeRefs.TypeRefsPackage#getFunctionTypeExpression_UnboundTypeVarsUpperBounds()
	 * @model containment="true"
	 * @generated
	 */
	EList<TypeRef> getUnboundTypeVarsUpperBounds();

	/**
	 * Returns the value of the '<em><b>Fpars</b></em>' containment reference list.
	 * The list contents are of type {@link eu.numberfour.n4js.ts.types.TFormalParameter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Formal parameters declared in the FunctionTypeExpression in the AST or
	 * a copy of the formal parameters of the 'declaredType' or original FunctionTypeExpression.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Fpars</em>' containment reference list.
	 * @see eu.numberfour.n4js.ts.typeRefs.TypeRefsPackage#getFunctionTypeExpression_Fpars()
	 * @model containment="true"
	 * @generated
	 */
	EList<TFormalParameter> getFpars();

	/**
	 * Returns the value of the '<em><b>Return Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Return type declared in the FunctionTypeExpression in the AST or
	 * a copy of the return type of the 'declaredType' or original FunctionTypeExpression.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Return Type Ref</em>' containment reference.
	 * @see #setReturnTypeRef(TypeRef)
	 * @see eu.numberfour.n4js.ts.typeRefs.TypeRefsPackage#getFunctionTypeExpression_ReturnTypeRef()
	 * @model containment="true"
	 * @generated
	 */
	TypeRef getReturnTypeRef();

	/**
	 * Sets the value of the '{@link eu.numberfour.n4js.ts.typeRefs.FunctionTypeExpression#getReturnTypeRef <em>Return Type Ref</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Return Type Ref</em>' containment reference.
	 * @see #getReturnTypeRef()
	 * @generated
	 */
	void setReturnTypeRef(TypeRef value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns 'ownedTypeVars' in use case #1, 'unboundTypeVars' in use case #2 and the type
	 * variables of the TFunction that was generated from the AST node in use case #3.
	 * For more details on use cases see API doc of {@link FunctionTypeExpression}.
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.common.util.EList%><<%eu.numberfour.n4js.ts.types.TypeVariable%>> _xifexpression = null;\nboolean _isBinding = this.isBinding();\nif (_isBinding)\n{\n\t_xifexpression = this.getUnboundTypeVars();\n}\nelse\n{\n\t<%org.eclipse.emf.common.util.EList%><<%eu.numberfour.n4js.ts.types.TypeVariable%>> _xifexpression_1 = null;\n\t<%eu.numberfour.n4js.ts.types.TFunction%> _declaredType = this.getDeclaredType();\n\tboolean _tripleNotEquals = (_declaredType != null);\n\tif (_tripleNotEquals)\n\t{\n\t\t<%eu.numberfour.n4js.ts.types.TFunction%> _declaredType_1 = this.getDeclaredType();\n\t\t_xifexpression_1 = _declaredType_1.getTypeVars();\n\t}\n\telse\n\t{\n\t\t_xifexpression_1 = this.getOwnedTypeVars();\n\t}\n\t_xifexpression = _xifexpression_1;\n}\nreturn _xifexpression;'"
	 * @generated
	 */
	EList<TypeVariable> getTypeVars();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns the upper bounds of the given type variable (which should be one of those returned by
	 * {@link FunctionTypeExprOrRef#getTypeVars()}). Usually, this will just return
	 * {@link TypeVariable#getDeclaredUpperBounds()}, but in case of a FunctionTypeExpression created during type
	 * variable substitution, a different upper bound might be returned (i.e. original upper bound after type variable
	 * substitution).
	 * <p>
	 * See property {@link FunctionTypeExpression#getUnboundTypeVarsUpperBounds() unboundTypeVarsUpperBounds} and
	 * method {@link DerivationComputer#performSubstitutionOnUpperBounds()}.
	 * <!-- end-model-doc -->
	 * @model unique="false" typeVarUnique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if ((typeVar == null))\n{\n\tthrow new <%java.lang.IllegalArgumentException%>(\"given type variable may not be null\");\n}\n<%org.eclipse.emf.common.util.EList%><<%eu.numberfour.n4js.ts.types.TypeVariable%>> _unboundTypeVars = this.getUnboundTypeVars();\nfinal int idx = _unboundTypeVars.indexOf(typeVar);\nif (((idx >= 0) && (idx < this.getUnboundTypeVarsUpperBounds().size())))\n{\n\t<%org.eclipse.emf.common.util.EList%><<%eu.numberfour.n4js.ts.typeRefs.TypeRef%>> _unboundTypeVarsUpperBounds = this.getUnboundTypeVarsUpperBounds();\n\tfinal <%eu.numberfour.n4js.ts.typeRefs.TypeRef%> modifiedUpperBound = _unboundTypeVarsUpperBounds.get(idx);\n\tif ((modifiedUpperBound != null))\n\t{\n\t\treturn <%org.eclipse.emf.ecore.xcore.lib.XcoreCollectionLiterals%>.<<%eu.numberfour.n4js.ts.typeRefs.TypeRef%>>newImmutableEList(modifiedUpperBound);\n\t}\n}\n<%org.eclipse.emf.common.util.EList%><<%eu.numberfour.n4js.ts.typeRefs.TypeRef%>> _declaredUpperBounds = typeVar.getDeclaredUpperBounds();\nreturn <%org.eclipse.emf.ecore.xcore.lib.XcoreCollectionLiterals%>.<<%eu.numberfour.n4js.ts.typeRefs.TypeRef%>>newImmutableEList(((<%eu.numberfour.n4js.ts.typeRefs.TypeRef%>[])org.eclipse.xtext.xbase.lib.Conversions.unwrapArray(_declaredUpperBounds, <%eu.numberfour.n4js.ts.typeRefs.TypeRef%>.class)));'"
	 * @generated
	 */
	EList<TypeRef> getTypeVarUpperBounds(TypeVariable typeVar);

} // FunctionTypeExpression
