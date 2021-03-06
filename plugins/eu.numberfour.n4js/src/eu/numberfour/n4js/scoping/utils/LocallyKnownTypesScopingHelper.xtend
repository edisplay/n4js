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
package eu.numberfour.n4js.scoping.utils

import com.google.inject.Inject
import eu.numberfour.n4js.n4JS.Script
import eu.numberfour.n4js.scoping.N4JSScopeProvider
import eu.numberfour.n4js.scoping.imports.ImportedElementsScopingHelper
import eu.numberfour.n4js.ts.typeRefs.FunctionTypeExpression
import eu.numberfour.n4js.ts.types.TClassifier
import eu.numberfour.n4js.ts.types.TStructMethod
import eu.numberfour.n4js.ts.types.Type
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.resource.EObjectDescription
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.IScopeProvider
import org.eclipse.xtext.scoping.Scopes
import org.eclipse.xtext.scoping.impl.SingletonScope
import org.eclipse.xtext.util.IResourceScopeCache
import org.eclipse.xtext.scoping.impl.MapBasedScope
import eu.numberfour.n4js.ts.types.TModule

/**
 * Helper for {@link N4JSScopeProvider N4JSScopeProvider} using
 * {@link ImportedElementsScopingHelper ImportedElementsScopingHelper}
 * for providing scope for types provider.
 */
class LocallyKnownTypesScopingHelper {

	@Inject
	IResourceScopeCache cache

	@Inject
	ImportedElementsScopingHelper importedElementsScopingHelper

	/**
	 * Returns the type itself and type variables in case the type is generic.
	 */
	def IScope scopeWithTypeAndItsTypeVariables(IScope parent, Type type, boolean staticAccess) {
		var IScope result = parent;
		if (type !== null) {

			// add the type itself
			if (type.name !== null)
				result = new SingletonScope(EObjectDescription.create(type.name, type), result)

			// add the type variables
			if (type.generic) {
				if (type instanceof TClassifier && staticAccess) {
					// error case: type variables of a classifier cannot be accessed from static members
					// e.g. class C<T> { static x: T; }
					// --> return same scope as in success case, but wrap descriptions with a WrongStaticAccessorDescription
					result = ScopeUtils.scopeFor(type.typeVars, [new WrongStaticAccessDescription(it, staticAccess)],
						result);
				} else {
					// success case: simply add type variables to scope
					result = Scopes.scopeFor(type.typeVars, result);
				}
			}
		}

		return result;
	}

	/**
	 * Returns the type variables if the TStructMethod is generic.
	 */
	def IScope scopeWithTypeVarsOfTStructMethod(IScope parent, TStructMethod m) {
		val mDef = m.definedMember
		if (mDef instanceof TStructMethod) {
			if (mDef.generic) {
				return Scopes.scopeFor(mDef.typeVars, parent)
			}
		}
		return parent;
	}

	/**
	 * Returns the type variables if the function type expression is generic.
	 */
	def IScope scopeWithTypeVarsOfFunctionTypeExpression(IScope parent, FunctionTypeExpression funTypeExpr) {
		if (funTypeExpr !== null && funTypeExpr.generic) {
			return Scopes.scopeFor(funTypeExpr.typeVars, parent);
		}
		return parent;
	}

	/**
	 * Returns scope with locally known types and (as parent) import scope; the result is cached.
	 */
	def IScope scopeWithLocallyKnownTypes(Script script, EReference reference, IScopeProvider delegate) {
		return cache.get(script -> 'locallyKnownTypes', script.eResource) [|
			// all types in the index:
			var parent = delegate.getScope(script, reference)
			// but imported types are preferred (or maybe renamed with aliases):
			val IScope importScope = importedElementsScopingHelper.getImportedTypes(parent, script)
			val TModule local = script.module
			return buildMapBasedScope(importScope, local);
		]
	}

	/**
	 * Creates a map based scope for the locally known types in the given module and with the given import (parent) 
	 * scope. This method may be overridden in sub classes.
	 */
	protected def IScope buildMapBasedScope(IScope importScope, TModule localModule) {
		return MapBasedScope.createScope(importScope, localModule.topLevelTypes.map [ topLevelType |
			EObjectDescription.create(topLevelType.name, topLevelType)
		])
	}

	/**
	 * Returns scope with locally known types specially configured for super reference in case of polyfill definitions.
	 * It is comparable to {@link #getLocallyKnownTypes(Script, EReference, IScopeProvider), but it does not
	 * add the polyfillType itself. Instead, only its type variables are added, which are otherwise hidden in case of polyfills.
	 * The result is not cached as this scope is needed only one time.
	 */
	def IScope scopeWithLocallyKnownTypesForPolyfillSuperRef(Script script, EReference reference,
		IScopeProvider delegate, Type polyfillType) {
		var IScope parent = delegate.getScope(script, reference);

		// imported and locally defined types are preferred (or maybe renamed with aliases):
		val IScope importScope = importedElementsScopingHelper.getImportedTypes(parent, script)

		// locally defined types except polyfillType itself
		val local = script.module
		var IScope localTypesScope = MapBasedScope.createScope(importScope, local.topLevelTypes.filter [
			it !== polyfillType
		].map[EObjectDescription.create(name, it)]);

		// type variables of polyfill
		if (polyfillType.generic) {
			return Scopes.scopeFor(polyfillType.typeVars, localTypesScope)
		}

		// non generic:
		return localTypesScope;

	}

}
