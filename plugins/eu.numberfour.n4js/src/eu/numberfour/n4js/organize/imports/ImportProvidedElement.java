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
package eu.numberfour.n4js.organize.imports;

import java.util.ArrayList;
import java.util.List;

import eu.numberfour.n4js.n4JS.ImportDeclaration;
import eu.numberfour.n4js.n4JS.ImportSpecifier;
import eu.numberfour.n4js.n4JS.NamedImportSpecifier;
import eu.numberfour.n4js.ts.types.IdentifiableElement;
import eu.numberfour.n4js.ts.types.TModule;

/**
 * Describing Elements provided by import statement and marking some state about visibility and usage.
 */
public class ImportProvidedElement {

	/** name as used in script (can be alias) */
	public String localname;

	/** name as provided by TModule */
	public String actualName;
	/** Prefix to be used when creating IPE for namespace itself */
	public final static String NAMESPACE_PREFIX = "NAMESPACE_";

	/** import specifier which imports the name. */
	public ImportSpecifier importSpec;

	/** imported module, providing this named element. */
	public TModule tmodule;

	/** usage-flag in script (statements & expressions) */
	public boolean used;

	/**
	 * In case of ambiguous imports the scoping gives a List imported things from other modules (variables, functions,
	 * classes,...). The instances carry the ref to those modules.
	 */
	public ArrayList<IdentifiableElement> ambiguityList = new ArrayList<>();

	/**
	 * List of other Imports which provided ambiguous imports
	 */
	public List<ImportSpecifier> ambiguousImports = new ArrayList<>();

	/**
	 * @param usedName
	 *            localName, aliased name for the imported entity
	 * @param actualName
	 *            name as exported be TModule
	 * @param importer
	 *            import-specifier, referencing the import-declaration.
	 *
	 */
	public ImportProvidedElement(String usedName, String actualName, ImportSpecifier importer) {
		this.localname = usedName;
		this.actualName = actualName;
		this.importSpec = importer;
		this.tmodule = ((ImportDeclaration) importer.eContainer()).getModule();
	}

	/** set the used flag to true */
	public void markUsed() {
		used = true;
	}

	/**
	 * {@code localname[actualname]<Module+øA} with
	 * <ul>
	 * <li>+ / - : used / unused
	 * <li>A : ambiguityList has entries.
	 * </ul>
	 */
	@Override
	public String toString() {
		return localname + (localname != actualName ? "[" + actualName + "]" : "") +
				(importSpec instanceof NamedImportSpecifier ? "-" : "*") + "<" + tmodule.getQualifiedName()
				+ "" + (used ? "+" : "-") + (ambiguityList != null ? "A" : "");
	}
}
