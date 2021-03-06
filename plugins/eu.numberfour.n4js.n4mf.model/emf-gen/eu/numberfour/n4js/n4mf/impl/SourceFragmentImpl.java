/**
 * Copyright (c) 2016 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package eu.numberfour.n4js.n4mf.impl;

import eu.numberfour.n4js.n4mf.N4mfPackage;
import eu.numberfour.n4js.n4mf.SourceFragment;
import eu.numberfour.n4js.n4mf.SourceFragmentType;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Source Fragment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.numberfour.n4js.n4mf.impl.SourceFragmentImpl#getSourceFragmentType <em>Source Fragment Type</em>}</li>
 *   <li>{@link eu.numberfour.n4js.n4mf.impl.SourceFragmentImpl#getPaths <em>Paths</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SourceFragmentImpl extends MinimalEObjectImpl.Container implements SourceFragment {
	/**
	 * The default value of the '{@link #getSourceFragmentType() <em>Source Fragment Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceFragmentType()
	 * @generated
	 * @ordered
	 */
	protected static final SourceFragmentType SOURCE_FRAGMENT_TYPE_EDEFAULT = SourceFragmentType.SOURCE;

	/**
	 * The cached value of the '{@link #getSourceFragmentType() <em>Source Fragment Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceFragmentType()
	 * @generated
	 * @ordered
	 */
	protected SourceFragmentType sourceFragmentType = SOURCE_FRAGMENT_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPaths() <em>Paths</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPaths()
	 * @generated
	 * @ordered
	 */
	protected EList<String> paths;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SourceFragmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return N4mfPackage.Literals.SOURCE_FRAGMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceFragmentType getSourceFragmentType() {
		return sourceFragmentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceFragmentType(SourceFragmentType newSourceFragmentType) {
		SourceFragmentType oldSourceFragmentType = sourceFragmentType;
		sourceFragmentType = newSourceFragmentType == null ? SOURCE_FRAGMENT_TYPE_EDEFAULT : newSourceFragmentType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, N4mfPackage.SOURCE_FRAGMENT__SOURCE_FRAGMENT_TYPE, oldSourceFragmentType, sourceFragmentType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getPaths() {
		if (paths == null) {
			paths = new EDataTypeEList<String>(String.class, this, N4mfPackage.SOURCE_FRAGMENT__PATHS);
		}
		return paths;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int compareByFragmentType(final SourceFragment other) {
		if ((null == other)) {
			return (-1);
		}
		SourceFragmentType _sourceFragmentType = this.getSourceFragmentType();
		boolean _tripleEquals = (null == _sourceFragmentType);
		if (_tripleEquals) {
			int _xifexpression = (int) 0;
			SourceFragmentType _sourceFragmentType_1 = other.getSourceFragmentType();
			boolean _tripleEquals_1 = (null == _sourceFragmentType_1);
			if (_tripleEquals_1) {
				_xifexpression = 0;
			}
			else {
				_xifexpression = 1;
			}
			return _xifexpression;
		}
		SourceFragmentType _sourceFragmentType_2 = this.getSourceFragmentType();
		SourceFragmentType _sourceFragmentType_3 = other.getSourceFragmentType();
		return _sourceFragmentType_2.compareTo(_sourceFragmentType_3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case N4mfPackage.SOURCE_FRAGMENT__SOURCE_FRAGMENT_TYPE:
				return getSourceFragmentType();
			case N4mfPackage.SOURCE_FRAGMENT__PATHS:
				return getPaths();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case N4mfPackage.SOURCE_FRAGMENT__SOURCE_FRAGMENT_TYPE:
				setSourceFragmentType((SourceFragmentType)newValue);
				return;
			case N4mfPackage.SOURCE_FRAGMENT__PATHS:
				getPaths().clear();
				getPaths().addAll((Collection<? extends String>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case N4mfPackage.SOURCE_FRAGMENT__SOURCE_FRAGMENT_TYPE:
				setSourceFragmentType(SOURCE_FRAGMENT_TYPE_EDEFAULT);
				return;
			case N4mfPackage.SOURCE_FRAGMENT__PATHS:
				getPaths().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case N4mfPackage.SOURCE_FRAGMENT__SOURCE_FRAGMENT_TYPE:
				return sourceFragmentType != SOURCE_FRAGMENT_TYPE_EDEFAULT;
			case N4mfPackage.SOURCE_FRAGMENT__PATHS:
				return paths != null && !paths.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case N4mfPackage.SOURCE_FRAGMENT___COMPARE_BY_FRAGMENT_TYPE__SOURCEFRAGMENT:
				return compareByFragmentType((SourceFragment)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (sourceFragmentType: ");
		result.append(sourceFragmentType);
		result.append(", paths: ");
		result.append(paths);
		result.append(')');
		return result.toString();
	}

} //SourceFragmentImpl
