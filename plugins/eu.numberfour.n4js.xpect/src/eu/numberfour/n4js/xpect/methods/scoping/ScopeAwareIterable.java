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
package eu.numberfour.n4js.xpect.methods.scoping;

import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.scoping.IScope;

import com.google.common.collect.Iterators;

/**
 */
class ScopeAwareIterable implements Iterable<String> {
	private final IScope scope;
	private final URI currentURI;
	public final boolean withLineNumber;

	public ScopeAwareIterable(URI currentURI, boolean withLineNumber, IScope scope) {
		super();
		this.currentURI = currentURI;
		this.scope = scope;
		this.withLineNumber = withLineNumber;
	}

	/**
	 * Returns the current resource URI, or null if it is unknown
	 */
	public URI getCurrentURI() {
		return currentURI;
	}

	@Override
	public Iterator<String> iterator() {
		return Iterators
				.transform(scope.getAllElements().iterator(), new EObjectDescriptionToNameWithPositionMapper(
						getCurrentURI(), withLineNumber));
	}

	/**
	 * Returns the scope on which elements the iterator works on.
	 */
	public IScope getScope() {
		return scope;
	}
}
