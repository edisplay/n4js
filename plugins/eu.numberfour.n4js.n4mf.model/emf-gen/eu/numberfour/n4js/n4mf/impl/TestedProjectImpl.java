/**
 * Copyright (c) 2016 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package eu.numberfour.n4js.n4mf.impl;

import eu.numberfour.n4js.n4mf.N4mfPackage;
import eu.numberfour.n4js.n4mf.ProjectDependencyScope;
import eu.numberfour.n4js.n4mf.TestedProject;
import eu.numberfour.n4js.n4mf.VersionConstraint;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tested Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.numberfour.n4js.n4mf.impl.TestedProjectImpl#getVersionConstraint <em>Version Constraint</em>}</li>
 *   <li>{@link eu.numberfour.n4js.n4mf.impl.TestedProjectImpl#getDeclaredScope <em>Declared Scope</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TestedProjectImpl extends SimpleProjectDependencyImpl implements TestedProject {
	/**
	 * The cached value of the '{@link #getVersionConstraint() <em>Version Constraint</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersionConstraint()
	 * @generated
	 * @ordered
	 */
	protected VersionConstraint versionConstraint;

	/**
	 * The default value of the '{@link #getDeclaredScope() <em>Declared Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclaredScope()
	 * @generated
	 * @ordered
	 */
	protected static final ProjectDependencyScope DECLARED_SCOPE_EDEFAULT = ProjectDependencyScope.COMPILE;

	/**
	 * The cached value of the '{@link #getDeclaredScope() <em>Declared Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclaredScope()
	 * @generated
	 * @ordered
	 */
	protected ProjectDependencyScope declaredScope = DECLARED_SCOPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestedProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return N4mfPackage.Literals.TESTED_PROJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VersionConstraint getVersionConstraint() {
		return versionConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVersionConstraint(VersionConstraint newVersionConstraint, NotificationChain msgs) {
		VersionConstraint oldVersionConstraint = versionConstraint;
		versionConstraint = newVersionConstraint;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, N4mfPackage.TESTED_PROJECT__VERSION_CONSTRAINT, oldVersionConstraint, newVersionConstraint);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersionConstraint(VersionConstraint newVersionConstraint) {
		if (newVersionConstraint != versionConstraint) {
			NotificationChain msgs = null;
			if (versionConstraint != null)
				msgs = ((InternalEObject)versionConstraint).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - N4mfPackage.TESTED_PROJECT__VERSION_CONSTRAINT, null, msgs);
			if (newVersionConstraint != null)
				msgs = ((InternalEObject)newVersionConstraint).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - N4mfPackage.TESTED_PROJECT__VERSION_CONSTRAINT, null, msgs);
			msgs = basicSetVersionConstraint(newVersionConstraint, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, N4mfPackage.TESTED_PROJECT__VERSION_CONSTRAINT, newVersionConstraint, newVersionConstraint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProjectDependencyScope getDeclaredScope() {
		return declaredScope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeclaredScope(ProjectDependencyScope newDeclaredScope) {
		ProjectDependencyScope oldDeclaredScope = declaredScope;
		declaredScope = newDeclaredScope == null ? DECLARED_SCOPE_EDEFAULT : newDeclaredScope;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, N4mfPackage.TESTED_PROJECT__DECLARED_SCOPE, oldDeclaredScope, declaredScope));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case N4mfPackage.TESTED_PROJECT__VERSION_CONSTRAINT:
				return basicSetVersionConstraint(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case N4mfPackage.TESTED_PROJECT__VERSION_CONSTRAINT:
				return getVersionConstraint();
			case N4mfPackage.TESTED_PROJECT__DECLARED_SCOPE:
				return getDeclaredScope();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case N4mfPackage.TESTED_PROJECT__VERSION_CONSTRAINT:
				setVersionConstraint((VersionConstraint)newValue);
				return;
			case N4mfPackage.TESTED_PROJECT__DECLARED_SCOPE:
				setDeclaredScope((ProjectDependencyScope)newValue);
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
			case N4mfPackage.TESTED_PROJECT__VERSION_CONSTRAINT:
				setVersionConstraint((VersionConstraint)null);
				return;
			case N4mfPackage.TESTED_PROJECT__DECLARED_SCOPE:
				setDeclaredScope(DECLARED_SCOPE_EDEFAULT);
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
			case N4mfPackage.TESTED_PROJECT__VERSION_CONSTRAINT:
				return versionConstraint != null;
			case N4mfPackage.TESTED_PROJECT__DECLARED_SCOPE:
				return declaredScope != DECLARED_SCOPE_EDEFAULT;
		}
		return super.eIsSet(featureID);
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
		result.append(" (declaredScope: ");
		result.append(declaredScope);
		result.append(')');
		return result.toString();
	}

} //TestedProjectImpl
