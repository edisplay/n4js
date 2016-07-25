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
package eu.numberfour.n4js.issues;

import org.eclipse.xtext.validation.Issue;

/**
 * Matches an issue against an expectation for a specific property.
 */
public interface IssuePropertyMatcher {
	/**
	 * Matches this property matcher against the given issue.
	 *
	 * @param issue
	 *            the issue to match against
	 * @return <code>true</code> if this property matcher matches the given issue and <code>false</code> otherwise
	 */
	public boolean matches(Issue issue);
}
