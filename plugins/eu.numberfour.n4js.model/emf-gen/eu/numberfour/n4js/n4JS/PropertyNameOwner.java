/**
 * Copyright (c) 2016 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package eu.numberfour.n4js.n4JS;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Name Owner</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Base for all entities that can have a literal or computed property name (see grammar rule
 * LiteralOrComputedPropertyName).
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.numberfour.n4js.n4JS.PropertyNameOwner#getDeclaredName <em>Declared Name</em>}</li>
 * </ul>
 *
 * @see eu.numberfour.n4js.n4JS.N4JSPackage#getPropertyNameOwner()
 * @model abstract="true"
 * @generated
 */
public interface PropertyNameOwner extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Declared Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declared Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declared Name</em>' containment reference.
	 * @see #setDeclaredName(LiteralOrComputedPropertyName)
	 * @see eu.numberfour.n4js.n4JS.N4JSPackage#getPropertyNameOwner_DeclaredName()
	 * @model containment="true"
	 * @generated
	 */
	LiteralOrComputedPropertyName getDeclaredName();

	/**
	 * Sets the value of the '{@link eu.numberfour.n4js.n4JS.PropertyNameOwner#getDeclaredName <em>Declared Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declared Name</em>' containment reference.
	 * @see #getDeclaredName()
	 * @generated
	 */
	void setDeclaredName(LiteralOrComputedPropertyName value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%eu.numberfour.n4js.n4JS.LiteralOrComputedPropertyName%> _declaredName = this.getDeclaredName();\n<%java.lang.String%> _name = null;\nif (_declaredName!=null)\n{\n\t_name=_declaredName.getName();\n}\nreturn _name;'"
	 * @generated
	 */
	String getName();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Used to detect early errors according the the ES6 spec.
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 * @generated
	 */
	boolean isValidName();

} // PropertyNameOwner
