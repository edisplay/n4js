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
package eu.numberfour.n4js.xpect.ui.tests;

import org.junit.runner.RunWith;
import org.xpect.XpectImport;
import org.xpect.runner.XpectRunner;
import org.xpect.runner.XpectSuiteClasses;
import org.xpect.runner.XpectTestFiles;
import org.xpect.runner.XpectTestFiles.FileRoot;
import org.xpect.xtext.lib.tests.LinkingTest;
import org.xpect.xtext.lib.tests.ResourceDescriptionTest;
import org.xpect.xtext.lib.tests.ValidationTest;

import eu.numberfour.n4js.xpect.methods.FindReferencesXpectMethod;
import eu.numberfour.n4js.xpect.methods.NoerrorsXpectMethod;
import eu.numberfour.n4js.xpect.methods.TypeXpectMethod;
import eu.numberfour.n4js.xpect.methods.scoping.ScopeXpectMethod;
import eu.numberfour.n4js.xpect.ui.methods.OutputXpectMethod;
import eu.numberfour.n4js.xpect.validation.suppression.SuppressIssuesSetup;

/**
 * Plugin linking test
 */
@XpectSuiteClasses({
		LinkingTest.class,
		TypeXpectMethod.class,
		NoerrorsXpectMethod.class,
		ScopeXpectMethod.class,
		ResourceDescriptionTest.class,
		ValidationTest.class,
		OutputXpectMethod.class,
		FindReferencesXpectMethod.class
})
@RunWith(XpectRunner.class)
@XpectTestFiles(relativeTo = FileRoot.PROJECT, baseDir = "model", fileExtensions = "xt")
@XpectImport(SuppressIssuesSetup.class)
public class N4JSXpectPluginTest {
	//
}