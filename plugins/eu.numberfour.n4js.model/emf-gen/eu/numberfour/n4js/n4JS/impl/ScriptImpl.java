/**
 * Copyright (c) 2016 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package eu.numberfour.n4js.n4JS.impl;

import eu.numberfour.n4js.n4JS.Annotation;
import eu.numberfour.n4js.n4JS.N4JSPackage;
import eu.numberfour.n4js.n4JS.Script;
import eu.numberfour.n4js.n4JS.ScriptElement;

import eu.numberfour.n4js.ts.types.TModule;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Script</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.numberfour.n4js.n4JS.impl.ScriptImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link eu.numberfour.n4js.n4JS.impl.ScriptImpl#getScriptElements <em>Script Elements</em>}</li>
 *   <li>{@link eu.numberfour.n4js.n4JS.impl.ScriptImpl#getModule <em>Module</em>}</li>
 *   <li>{@link eu.numberfour.n4js.n4JS.impl.ScriptImpl#isFlaggedUsageMarkingFinished <em>Flagged Usage Marking Finished</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ScriptImpl extends VariableEnvironmentElementImpl implements Script {
	/**
	 * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotations()
	 * @generated
	 * @ordered
	 */
	protected EList<Annotation> annotations;

	/**
	 * The cached value of the '{@link #getScriptElements() <em>Script Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScriptElements()
	 * @generated
	 * @ordered
	 */
	protected EList<ScriptElement> scriptElements;

	/**
	 * The cached value of the '{@link #getModule() <em>Module</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModule()
	 * @generated
	 * @ordered
	 */
	protected TModule module;

	/**
	 * The default value of the '{@link #isFlaggedUsageMarkingFinished() <em>Flagged Usage Marking Finished</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFlaggedUsageMarkingFinished()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FLAGGED_USAGE_MARKING_FINISHED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFlaggedUsageMarkingFinished() <em>Flagged Usage Marking Finished</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFlaggedUsageMarkingFinished()
	 * @generated
	 * @ordered
	 */
	protected boolean flaggedUsageMarkingFinished = FLAGGED_USAGE_MARKING_FINISHED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScriptImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return N4JSPackage.Literals.SCRIPT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Annotation> getAnnotations() {
		if (annotations == null) {
			annotations = new EObjectContainmentEList<Annotation>(Annotation.class, this, N4JSPackage.SCRIPT__ANNOTATIONS);
		}
		return annotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ScriptElement> getScriptElements() {
		if (scriptElements == null) {
			scriptElements = new EObjectContainmentEList<ScriptElement>(ScriptElement.class, this, N4JSPackage.SCRIPT__SCRIPT_ELEMENTS);
		}
		return scriptElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TModule getModule() {
		if (module != null && module.eIsProxy()) {
			InternalEObject oldModule = (InternalEObject)module;
			module = (TModule)eResolveProxy(oldModule);
			if (module != oldModule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, N4JSPackage.SCRIPT__MODULE, oldModule, module));
			}
		}
		return module;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TModule basicGetModule() {
		return module;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModule(TModule newModule) {
		TModule oldModule = module;
		module = newModule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, N4JSPackage.SCRIPT__MODULE, oldModule, module));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFlaggedUsageMarkingFinished() {
		return flaggedUsageMarkingFinished;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFlaggedUsageMarkingFinished(boolean newFlaggedUsageMarkingFinished) {
		boolean oldFlaggedUsageMarkingFinished = flaggedUsageMarkingFinished;
		flaggedUsageMarkingFinished = newFlaggedUsageMarkingFinished;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, N4JSPackage.SCRIPT__FLAGGED_USAGE_MARKING_FINISHED, oldFlaggedUsageMarkingFinished, flaggedUsageMarkingFinished));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case N4JSPackage.SCRIPT__ANNOTATIONS:
				return ((InternalEList<?>)getAnnotations()).basicRemove(otherEnd, msgs);
			case N4JSPackage.SCRIPT__SCRIPT_ELEMENTS:
				return ((InternalEList<?>)getScriptElements()).basicRemove(otherEnd, msgs);
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
			case N4JSPackage.SCRIPT__ANNOTATIONS:
				return getAnnotations();
			case N4JSPackage.SCRIPT__SCRIPT_ELEMENTS:
				return getScriptElements();
			case N4JSPackage.SCRIPT__MODULE:
				if (resolve) return getModule();
				return basicGetModule();
			case N4JSPackage.SCRIPT__FLAGGED_USAGE_MARKING_FINISHED:
				return isFlaggedUsageMarkingFinished();
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
			case N4JSPackage.SCRIPT__ANNOTATIONS:
				getAnnotations().clear();
				getAnnotations().addAll((Collection<? extends Annotation>)newValue);
				return;
			case N4JSPackage.SCRIPT__SCRIPT_ELEMENTS:
				getScriptElements().clear();
				getScriptElements().addAll((Collection<? extends ScriptElement>)newValue);
				return;
			case N4JSPackage.SCRIPT__MODULE:
				setModule((TModule)newValue);
				return;
			case N4JSPackage.SCRIPT__FLAGGED_USAGE_MARKING_FINISHED:
				setFlaggedUsageMarkingFinished((Boolean)newValue);
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
			case N4JSPackage.SCRIPT__ANNOTATIONS:
				getAnnotations().clear();
				return;
			case N4JSPackage.SCRIPT__SCRIPT_ELEMENTS:
				getScriptElements().clear();
				return;
			case N4JSPackage.SCRIPT__MODULE:
				setModule((TModule)null);
				return;
			case N4JSPackage.SCRIPT__FLAGGED_USAGE_MARKING_FINISHED:
				setFlaggedUsageMarkingFinished(FLAGGED_USAGE_MARKING_FINISHED_EDEFAULT);
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
			case N4JSPackage.SCRIPT__ANNOTATIONS:
				return annotations != null && !annotations.isEmpty();
			case N4JSPackage.SCRIPT__SCRIPT_ELEMENTS:
				return scriptElements != null && !scriptElements.isEmpty();
			case N4JSPackage.SCRIPT__MODULE:
				return module != null;
			case N4JSPackage.SCRIPT__FLAGGED_USAGE_MARKING_FINISHED:
				return flaggedUsageMarkingFinished != FLAGGED_USAGE_MARKING_FINISHED_EDEFAULT;
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
		result.append(" (flaggedUsageMarkingFinished: ");
		result.append(flaggedUsageMarkingFinished);
		result.append(')');
		return result.toString();
	}

} //ScriptImpl
