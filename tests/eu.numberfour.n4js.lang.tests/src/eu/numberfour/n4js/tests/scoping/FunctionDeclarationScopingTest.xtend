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
package eu.numberfour.n4js.tests.scoping

import com.google.inject.Inject
import eu.numberfour.n4js.N4JSInjectorProvider
import eu.numberfour.n4js.n4JS.FunctionDeclaration
import eu.numberfour.n4js.n4JS.Script
import eu.numberfour.n4js.n4JS.VariableDeclaration
import eu.numberfour.n4js.ts.types.TFunction
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*

/**
 * Tests function declaration specific functionality, such as type variables.
 *
 * @see IDE-346
 */
@InjectWith(N4JSInjectorProvider)
@RunWith(XtextRunner)
class FunctionDeclarationScopingTest {

	@Inject extension ParseHelper<Script>
	@Inject extension ValidationTestHelper

	@Test
	def void testTypeVariableBindingLocalVars() {
		val script = '''
			function <T> f1() {
			    var t: T;
			}
		'''.parse
		script.assertNoErrors
		val tfunc = script.eAllContents.filter(FunctionDeclaration).head.definedType as TFunction
		val t = script.eAllContents.filter(VariableDeclaration).head
		assertEquals(t.declaredTypeRef.declaredType, tfunc.typeVars.head)
	}

	@Test
	def void testTypeVariableBindingParameters() {
		val script = '''
			function <T> f1(t: T, u: U): T {
			    return null;
			}
		'''.parse
		// script.assertNoErrors // we expect errors, U cannot be bound
		val funcDecl = script.eAllContents.filter(FunctionDeclaration).head;
		val tfunc = funcDecl.definedType as TFunction
		val typeVar = tfunc.typeVars.head
		assertEquals(funcDecl.returnTypeRef.declaredType, typeVar)
		assertEquals(funcDecl.fpars.get(0).declaredTypeRef.declaredType, typeVar)
		// ensure that we do not compare nonsense:
		assertNotEquals(funcDecl.fpars.get(1).declaredTypeRef.declaredType, typeVar)
	}

}
