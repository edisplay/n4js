/**
 * Copyright (c) 2016 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package eu.numberfour.n4js.ts.types;

import eu.numberfour.n4js.ts.typeRefs.ParameterizedTypeRef;

import java.lang.Iterable;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TInterface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.numberfour.n4js.ts.types.TInterface#isExternal <em>External</em>}</li>
 *   <li>{@link eu.numberfour.n4js.ts.types.TInterface#getSuperInterfaceRefs <em>Super Interface Refs</em>}</li>
 * </ul>
 *
 * @see eu.numberfour.n4js.ts.types.TypesPackage#getTInterface()
 * @model
 * @generated
 */
public interface TInterface extends TN4Classifier {
	/**
	 * Returns the value of the '<em><b>External</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>External</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>External</em>' attribute.
	 * @see #setExternal(boolean)
	 * @see eu.numberfour.n4js.ts.types.TypesPackage#getTInterface_External()
	 * @model unique="false"
	 * @generated
	 */
	boolean isExternal();

	/**
	 * Sets the value of the '{@link eu.numberfour.n4js.ts.types.TInterface#isExternal <em>External</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>External</em>' attribute.
	 * @see #isExternal()
	 * @generated
	 */
	void setExternal(boolean value);

	/**
	 * Returns the value of the '<em><b>Super Interface Refs</b></em>' containment reference list.
	 * The list contents are of type {@link eu.numberfour.n4js.ts.typeRefs.ParameterizedTypeRef}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Interface Refs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Interface Refs</em>' containment reference list.
	 * @see eu.numberfour.n4js.ts.types.TypesPackage#getTInterface_SuperInterfaceRefs()
	 * @model containment="true"
	 * @generated
	 */
	EList<ParameterizedTypeRef> getSuperInterfaceRefs();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return true;'"
	 * @generated
	 */
	boolean isAbstract();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Convenience method, returns all super classes, consumed roles and implemented or extend interfaces
	 * <!-- end-model-doc -->
	 * @model kind="operation" dataType="eu.numberfour.n4js.ts.typeRefs.ParameterizedTypeRefIterable" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getSuperInterfaceRefs();'"
	 * @generated
	 */
	Iterable<ParameterizedTypeRef> getSuperClassifiers();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Convenience method, returns all implemented (or extended) interfaces
	 * <!-- end-model-doc -->
	 * @model kind="operation" dataType="eu.numberfour.n4js.ts.typeRefs.ParameterizedTypeRefIterable" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return this.getSuperInterfaceRefs();'"
	 * @generated
	 */
	Iterable<ParameterizedTypeRef> getImplementedOrExtendedInterfaceRefs();

} // TInterface