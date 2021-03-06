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
package eu.numberfour.n4js.transpiler.es.tests

import eu.numberfour.n4js.N4JSInjectorProviderWithMockProject
import eu.numberfour.n4js.n4JS.FunctionDeclaration
import eu.numberfour.n4js.n4JS.N4ClassDeclaration
import eu.numberfour.n4js.n4JS.VariableStatement
import eu.numberfour.n4js.ts.types.TClass
import eu.numberfour.n4js.ts.types.TFunction
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

import static eu.numberfour.n4js.transpiler.TranspilerBuilderBlocks.*

import static extension eu.numberfour.n4js.transpiler.operations.TranspilerStateOperations.*

/**
 */
@RunWith(XtextRunner)
@InjectWith(N4JSInjectorProviderWithMockProject)
class OperationReplaceTest extends AbstractTranspilerTest {

	@Test
	def void testReplace_classToFunctionDeclaration() {

		val state = '''

			class C {}

		'''.createTranspilerState;

		val C = state.findFirstInModule(TClass);
		val C_AST = state.findFirstInAST(N4ClassDeclaration);
		val C_IM = state.findFirstInIM(N4ClassDeclaration);

		val replacement = _FunDecl("C");

		assertTracing(state, C_IM, C_AST);
		state.assertSymbolTableEntry("C")
		.originalTarget(C) // pointing to TClass "C"
		.elementsOfThisName(C_IM)

		state.replace(C_IM, replacement);

		assertNoTracing(state, C_IM); // replaced element should no longer have tracing info
		assertTracing(state, replacement, C_AST); // replacement should now have this tracing info

		state.assertSymbolTableEntry("C")
		.originalTarget(C) // still pointing to original TClass "C"
		.elementsOfThisName(replacement) // now pointing to replacement
	}

	@Test
	def void testReplace_functionDeclarationToVariableDeclaration() {

		val state = '''

			function C() {}

		'''.createTranspilerState;

		val C = state.findFirstInModule(TFunction);
		val C_AST = state.findFirstInAST(FunctionDeclaration);
		val C_IM = state.findFirstInIM(FunctionDeclaration);

		val replacementDecl = _VariableDeclaration("C", _FunExpr(false));

		assertTracing(state, C_IM, C_AST);
		state.assertSymbolTableEntry("C")
		.originalTarget(C) // pointing to TClass "C"
		.elementsOfThisName(C_IM)

		state.replace(C_IM, replacementDecl);

		assertNoTracing(state, C_IM); // replaced element should no longer have tracing info

		val replacementStmnt = replacementDecl.eContainer as VariableStatement;
		assertTracing(state, replacementStmnt, C_AST); // replacementStmnt should now have this tracing info

		state.assertSymbolTableEntry("C")
		.originalTarget(C) // still pointing to original TClass "C"
		.elementsOfThisName(replacementDecl) // pointing to replacement
	}
}
