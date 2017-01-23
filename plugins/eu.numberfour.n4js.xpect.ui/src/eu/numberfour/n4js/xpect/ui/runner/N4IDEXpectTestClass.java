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
package eu.numberfour.n4js.xpect.ui.runner;

import org.junit.runner.RunWith;
import org.xpect.XpectImport;
import org.xpect.runner.IXpectURIProvider;
import org.xpect.runner.XpectRunner;
import org.xpect.runner.XpectSuiteClasses;
import org.xpect.xtext.lib.tests.ResourceDescriptionTest;
import org.xpect.xtext.lib.tests.ValidationTest;

import eu.numberfour.n4js.xpect.methods.AccessModifierAxpectMethod;
import eu.numberfour.n4js.xpect.methods.FindReferencesXpectMethod;
import eu.numberfour.n4js.xpect.methods.FormatterXpectMethod;
import eu.numberfour.n4js.xpect.methods.LinkingXpectMethod;
import eu.numberfour.n4js.xpect.methods.NoerrorsXpectMethod;
import eu.numberfour.n4js.xpect.methods.ReturnXpectMethod;
import eu.numberfour.n4js.xpect.methods.TypeXpectMethod;
import eu.numberfour.n4js.xpect.methods.scoping.ScopeXpectMethod;
import eu.numberfour.n4js.xpect.ui.methods.HyperlinkXpectMethod;
import eu.numberfour.n4js.xpect.ui.methods.OrganizeImportXpectMethod;
import eu.numberfour.n4js.xpect.ui.methods.OutlineXpectMethod;
import eu.numberfour.n4js.xpect.ui.methods.OutputXpectMethod;
import eu.numberfour.n4js.xpect.ui.methods.ProposalXpectMethod;
import eu.numberfour.n4js.xpect.ui.methods.contentassist.ContentAssistXpectMethod;
import eu.numberfour.n4js.xpect.ui.methods.quickfix.QuickFixXpectMethod;
import eu.numberfour.n4js.xpect.ui.runner.N4IDEXpectTestFilesCollector.N4IDEXpectTestURIProvider;

/**
 * Main and only entry point for executing xpect in the product. Uses custom setup {@link N4IDEXpectFileSetup}.
 * Additionally custom files collector {@link N4IDEXpectTestFilesCollector} configures custom {@link IXpectURIProvider}
 * - {@link N4IDEXpectTestURIProvider} that will be used by {@link XpectRunner}
 */
@XpectSuiteClasses({
		AccessModifierAxpectMethod.class,
		FindReferencesXpectMethod.class,
		FormatterXpectMethod.class,
		LinkingXpectMethod.class,
		NoerrorsXpectMethod.class,
		ReturnXpectMethod.class,
		TypeXpectMethod.class,
		ValidationTest.class,
		ScopeXpectMethod.class,
		HyperlinkXpectMethod.class,
		OrganizeImportXpectMethod.class,
		OutlineXpectMethod.class,
		OutputXpectMethod.class,
		ProposalXpectMethod.class,
		ContentAssistXpectMethod.class,
		QuickFixXpectMethod.class,
		ResourceDescriptionTest.class
})
@RunWith(XpectRunner.class)
@XpectImport({ N4IDEXpectFileSetup.class })
@N4IDEXpectTestFilesCollector
public class N4IDEXpectTestClass {
	// noop
}
