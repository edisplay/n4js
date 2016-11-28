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
package eu.numberfour.n4js.validation;

import org.eclipse.emf.ecore.EObject;

/**
 * This class defines the JavaScriptVariant features
 */
public interface JavaScriptVariantHelper {

	/**
	 * Return true if dynamic pseudo scope should be activated
	 */
	public boolean activateDynamicPseudoScope(EObject eobj);

	/**
	 * Return true if missing implementation is allowed, for instance in external mode
	 */
	public boolean allowMissingImplementation(EObject eobj);

	/**
	 * Return true if override annotation should be checked, e.g. if mode is N4JS
	 */
	public boolean checkOverrideAnnotation(EObject eobj);

	/**
	 * Return true if type declaration should be checked, e.g. if the mode is N4JS
	 */
	public boolean checkTypeDeclaration(EObject eobj);

	/**
	 * Return true if type declaration should be checked, e.g. if the mode is N4JS
	 */
	public boolean checkMemberDeclaration(EObject eobj);

	/**
	 * Return true if variable declaration should be checked, e.g. if the mode is N4JS
	 */
	public boolean checkVariable(EObject eobj);

	/**
	 * Return true if method reference should be checked
	 */
	public boolean checkMethodReference(EObject eobj);

	/**
	 * Return true if call expression should be checked
	 */
	public boolean checkCallExpression(EObject eobj);

	/**
	 * Return true if new expression should be checked
	 */
	public boolean requireCheckNewExpression(EObject eobj);

	/**
	 * Return true if indexed access expression should be checked, only in N4JS mode
	 */
	public boolean requireCheckIndexedAccessExpression(EObject eobj);

	/**
	 * Return true if function name should be checked
	 */
	public boolean requireCheckFunctionName(EObject eobj);

	/**
	 * Return true if function return should be checked
	 */
	public boolean requireCheckFunctionReturn(EObject eobj);

	/**
	 * Return true if function expression in expression statement should be checked
	 */
	public boolean requireCheckFunctionExpressionInExpressionStatement(EObject eobj);

	/**
	 * Return true if a constant declaration has an initializer
	 */
	public boolean constantHasInitializer(EObject eobj);

	/**
	 * Return true if it should be check that no N4JS in runtime environment or lib
	 */
	public boolean requirecheckNoN4jsInRuntimeEnvOrLib(EObject eobj);

	/**
	 * Return true if it should be check that no N4JS in runtime environment or lib
	 */
	public boolean allowWrongReadWrite(EObject eobj);

	/**
	 * Return true if type inference should be doomed
	 */
	public boolean doomTypeInference(EObject eobj);

	/**
	 * Return true if annotation should be allowed
	 */
	public boolean allowAnnotation(EObject eobj);

	/**
	 * Return true if it must be checked that a final field is initialized
	 */
	public boolean requireCheckFinalFieldIsInitialized(EObject eobj);

	/**
	 * Return true if it must be checked if a name starts with dollar
	 */
	public boolean requireCheckNameStartsWithDollar(EObject eobj);

	/**
	 * Return true if it is required to check if body of a member is missing
	 */
	public boolean requireCheckForMissingBody(EObject eobj);

	/**
	 * Return true if it is required to check type matches
	 */
	public boolean requireCheckTypeMatchesExpectedType(EObject eobj);

	/**
	 * Enforce dynamic types in call cases even without explicit modifier. This is usually the case for plain ECMAScript
	 */
	public boolean enforceDynamicTypes(EObject eobj);

	/**
	 * Returns true if the variant is type aware
	 */
	public boolean isTypeAware(EObject eobj);

	/**
	 * Returns true if the variant has global object
	 */
	public boolean hasGlobalObject(EObject eobj);

	/**
	 * Returns true if the mode is unrestricted
	 */
	public boolean isUnrestrictedMode(EObject eobj);

	/**
	 * Returns true if the script is defined in a N4JSD module (external mode)
	 */
	public boolean isExternalMode(EObject eobj);

	/**
	 * Returns true if the script is defined in a N4JS module
	 */
	public boolean isN4JSMode(EObject eobj);

	/**
	 * Returns the variant mode
	 */
	public String variantMode(EObject eobj);

}
