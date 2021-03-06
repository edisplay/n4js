/**
 * Copyright (c) 2016 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package eu.numberfour.n4js.ts.types;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TModule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * The TModule is the representation of the script on the type level.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.numberfour.n4js.ts.types.TModule#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link eu.numberfour.n4js.ts.types.TModule#getProjectId <em>Project Id</em>}</li>
 *   <li>{@link eu.numberfour.n4js.ts.types.TModule#getVendorID <em>Vendor ID</em>}</li>
 *   <li>{@link eu.numberfour.n4js.ts.types.TModule#getModuleLoader <em>Module Loader</em>}</li>
 *   <li>{@link eu.numberfour.n4js.ts.types.TModule#isN4jsdModule <em>N4jsd Module</em>}</li>
 *   <li>{@link eu.numberfour.n4js.ts.types.TModule#isStaticPolyfillModule <em>Static Polyfill Module</em>}</li>
 *   <li>{@link eu.numberfour.n4js.ts.types.TModule#isStaticPolyfillAware <em>Static Polyfill Aware</em>}</li>
 *   <li>{@link eu.numberfour.n4js.ts.types.TModule#isMainModule <em>Main Module</em>}</li>
 *   <li>{@link eu.numberfour.n4js.ts.types.TModule#isPreLinkingPhase <em>Pre Linking Phase</em>}</li>
 *   <li>{@link eu.numberfour.n4js.ts.types.TModule#getTopLevelTypes <em>Top Level Types</em>}</li>
 *   <li>{@link eu.numberfour.n4js.ts.types.TModule#getVariables <em>Variables</em>}</li>
 *   <li>{@link eu.numberfour.n4js.ts.types.TModule#getInternalTypes <em>Internal Types</em>}</li>
 *   <li>{@link eu.numberfour.n4js.ts.types.TModule#getExposedInternalTypes <em>Exposed Internal Types</em>}</li>
 *   <li>{@link eu.numberfour.n4js.ts.types.TModule#getModuleSpecifier <em>Module Specifier</em>}</li>
 * </ul>
 *
 * @see eu.numberfour.n4js.ts.types.TypesPackage#getTModule()
 * @model
 * @generated
 */
public interface TModule extends SyntaxRelatedTElement, TAnnotableElement {
	/**
	 * Returns the value of the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * The qualified name of the module, which is derived from the file name.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Qualified Name</em>' attribute.
	 * @see #setQualifiedName(String)
	 * @see eu.numberfour.n4js.ts.types.TypesPackage#getTModule_QualifiedName()
	 * @model unique="false"
	 * @generated
	 */
	String getQualifiedName();

	/**
	 * Sets the value of the '{@link eu.numberfour.n4js.ts.types.TModule#getQualifiedName <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qualified Name</em>' attribute.
	 * @see #getQualifiedName()
	 * @generated
	 */
	void setQualifiedName(String value);

	/**
	 * Returns the value of the '<em><b>Project Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * The projectId of the project containing this module.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Project Id</em>' attribute.
	 * @see #setProjectId(String)
	 * @see eu.numberfour.n4js.ts.types.TypesPackage#getTModule_ProjectId()
	 * @model unique="false"
	 * @generated
	 */
	String getProjectId();

	/**
	 * Sets the value of the '{@link eu.numberfour.n4js.ts.types.TModule#getProjectId <em>Project Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project Id</em>' attribute.
	 * @see #getProjectId()
	 * @generated
	 */
	void setProjectId(String value);

	/**
	 * Returns the value of the '<em><b>Vendor ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * The vendorId of the project containing this module.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Vendor ID</em>' attribute.
	 * @see #setVendorID(String)
	 * @see eu.numberfour.n4js.ts.types.TypesPackage#getTModule_VendorID()
	 * @model unique="false"
	 * @generated
	 */
	String getVendorID();

	/**
	 * Sets the value of the '{@link eu.numberfour.n4js.ts.types.TModule#getVendorID <em>Vendor ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vendor ID</em>' attribute.
	 * @see #getVendorID()
	 * @generated
	 */
	void setVendorID(String value);

	/**
	 * Returns the value of the '<em><b>Module Loader</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * The module loader supported by this module as defined in the containing project's manifest.
	 * Value will be an EMF enum literal, i.e. something like <code>eu.numberfour.n4js.n4mf.ModuleLoader.COMMONJS.getLiteral()</code>.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Module Loader</em>' attribute.
	 * @see #setModuleLoader(String)
	 * @see eu.numberfour.n4js.ts.types.TypesPackage#getTModule_ModuleLoader()
	 * @model unique="false"
	 * @generated
	 */
	String getModuleLoader();

	/**
	 * Sets the value of the '{@link eu.numberfour.n4js.ts.types.TModule#getModuleLoader <em>Module Loader</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Module Loader</em>' attribute.
	 * @see #getModuleLoader()
	 * @generated
	 */
	void setModuleLoader(String value);

	/**
	 * Returns the value of the '<em><b>N4jsd Module</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Flag indicating a module defined in an <code>.n4jsd</code> file.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>N4jsd Module</em>' attribute.
	 * @see #setN4jsdModule(boolean)
	 * @see eu.numberfour.n4js.ts.types.TypesPackage#getTModule_N4jsdModule()
	 * @model unique="false"
	 * @generated
	 */
	boolean isN4jsdModule();

	/**
	 * Sets the value of the '{@link eu.numberfour.n4js.ts.types.TModule#isN4jsdModule <em>N4jsd Module</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>N4jsd Module</em>' attribute.
	 * @see #isN4jsdModule()
	 * @generated
	 */
	void setN4jsdModule(boolean value);

	/**
	 * Returns the value of the '<em><b>Static Polyfill Module</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Flag indicating a static-polyfilling (not a standalone) module.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Static Polyfill Module</em>' attribute.
	 * @see #setStaticPolyfillModule(boolean)
	 * @see eu.numberfour.n4js.ts.types.TypesPackage#getTModule_StaticPolyfillModule()
	 * @model unique="false"
	 * @generated
	 */
	boolean isStaticPolyfillModule();

	/**
	 * Sets the value of the '{@link eu.numberfour.n4js.ts.types.TModule#isStaticPolyfillModule <em>Static Polyfill Module</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Static Polyfill Module</em>' attribute.
	 * @see #isStaticPolyfillModule()
	 * @generated
	 */
	void setStaticPolyfillModule(boolean value);

	/**
	 * Returns the value of the '<em><b>Static Polyfill Aware</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Flag indicating a target of static-polyfilling (possibly a generated) module.
	 * Only one of {@code #staticPolyfillModule} of {@code staticPolyfillAware} can be {@code true}
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Static Polyfill Aware</em>' attribute.
	 * @see #setStaticPolyfillAware(boolean)
	 * @see eu.numberfour.n4js.ts.types.TypesPackage#getTModule_StaticPolyfillAware()
	 * @model unique="false"
	 * @generated
	 */
	boolean isStaticPolyfillAware();

	/**
	 * Sets the value of the '{@link eu.numberfour.n4js.ts.types.TModule#isStaticPolyfillAware <em>Static Polyfill Aware</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Static Polyfill Aware</em>' attribute.
	 * @see #isStaticPolyfillAware()
	 * @generated
	 */
	void setStaticPolyfillAware(boolean value);

	/**
	 * Returns the value of the '<em><b>Main Module</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Flag indicating a MainModule (see eu.numberfour.n4js.n4mf.ProjectDescription#mainModule)
	 * Used in scoping to adjust shadowing rules for the project imports (see eu.numberfour.n4js.scoping.utils.ProjectImportEnablingScope).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Main Module</em>' attribute.
	 * @see #setMainModule(boolean)
	 * @see eu.numberfour.n4js.ts.types.TypesPackage#getTModule_MainModule()
	 * @model unique="false"
	 * @generated
	 */
	boolean isMainModule();

	/**
	 * Sets the value of the '{@link eu.numberfour.n4js.ts.types.TModule#isMainModule <em>Main Module</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Main Module</em>' attribute.
	 * @see #isMainModule()
	 * @generated
	 */
	void setMainModule(boolean value);

	/**
	 * Returns the value of the '<em><b>Pre Linking Phase</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * True iff this TModule was created during pre-linking phase.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Pre Linking Phase</em>' attribute.
	 * @see #setPreLinkingPhase(boolean)
	 * @see eu.numberfour.n4js.ts.types.TypesPackage#getTModule_PreLinkingPhase()
	 * @model unique="false" transient="true"
	 * @generated
	 */
	boolean isPreLinkingPhase();

	/**
	 * Sets the value of the '{@link eu.numberfour.n4js.ts.types.TModule#isPreLinkingPhase <em>Pre Linking Phase</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pre Linking Phase</em>' attribute.
	 * @see #isPreLinkingPhase()
	 * @generated
	 */
	void setPreLinkingPhase(boolean value);

	/**
	 * Returns the value of the '<em><b>Top Level Types</b></em>' containment reference list.
	 * The list contents are of type {@link eu.numberfour.n4js.ts.types.Type}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A list of all types declarations in the script on the top level.
	 * These include the exported classes, interfaces, function as well
	 * as the types inferred from type defining elements that are not marked as exported.
	 * This allows for better validation messages and diagnostics in later stages
	 * of the processing.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Top Level Types</em>' containment reference list.
	 * @see eu.numberfour.n4js.ts.types.TypesPackage#getTModule_TopLevelTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Type> getTopLevelTypes();

	/**
	 * Returns the value of the '<em><b>Variables</b></em>' containment reference list.
	 * The list contents are of type {@link eu.numberfour.n4js.ts.types.TVariable}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A list of all top level variables in the script.
	 * These include the exported variables as well as the internal variables.
	 * Similar to #topLevelTypes, this allows for better validation messages and diagnostics.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Variables</em>' containment reference list.
	 * @see eu.numberfour.n4js.ts.types.TypesPackage#getTModule_Variables()
	 * @model containment="true"
	 * @generated
	 */
	EList<TVariable> getVariables();

	/**
	 * Returns the value of the '<em><b>Internal Types</b></em>' containment reference list.
	 * The list contents are of type {@link eu.numberfour.n4js.ts.types.Type}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Internal types may be populated incrementally by the type checker. Typically these
	 * are types derived from nested structures of the AST.
	 * <p>
	 * An anonymous, internal function may be assigned to a variable and we have
	 * to compute the type of that variable. Therefore the type has to be contained somewhere in
	 * the resource. Even worse, a named internal function can be called by name, thus it would
	 * have to become an IdentifiableElement which opens another can of worms. To avoid that, the
	 * internal function defines a type which in turn is the identifiable element. EMF constrains
	 * us to provide a container for that type, which is this containment reference.
	 * It is not persisted in the index.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Internal Types</em>' containment reference list.
	 * @see eu.numberfour.n4js.ts.types.TypesPackage#getTModule_InternalTypes()
	 * @model containment="true" transient="true"
	 * @generated
	 */
	EList<Type> getInternalTypes();

	/**
	 * Returns the value of the '<em><b>Exposed Internal Types</b></em>' containment reference list.
	 * The list contents are of type {@link eu.numberfour.n4js.ts.types.Type}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Sometimes, internal types are referenced by exported types, e.g. as the type of an exported
	 * variable or a field of a class. The fact that internal types are not serialized would
	 * lead to unresolved reference exceptions upon deserialization. Therefore, these internal
	 * types are serialized by moving them from 'internalTypes' to this containment reference.
	 * <p>
	 * These are not directly referable from the outside but may specify the types of exported
	 * variables, etc. Anonymous types of a script 'A' do not become visible to a script 'B' that
	 * imports 'A'. To access those, the referring {@link #variables variable} has to be used.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Exposed Internal Types</em>' containment reference list.
	 * @see eu.numberfour.n4js.ts.types.TypesPackage#getTModule_ExposedInternalTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Type> getExposedInternalTypes();

	/**
	 * Returns the value of the '<em><b>Module Specifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Returns the qualified module name as a file path, using '/' as a segment delimiter. No file extension is added,
	 * though.
	 * <p>
	 * TODO Since we changed the delimiter for our internal qualified names from '.' to '/', this is no longer required.
	 * However, qualified names will soon be revisited in IDE-2227 and this might change again, so we keep this method.
	 * Also see method <code>QualifiedNameComputer#getFullyQualifiedTypeName_WITH_LEGACY_SUPPORT(Type)</code>.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Module Specifier</em>' attribute.
	 * @see eu.numberfour.n4js.ts.types.TypesPackage#getTModule_ModuleSpecifier()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='return this.getQualifiedName();'"
	 * @generated
	 */
	String getModuleSpecifier();

} // TModule
