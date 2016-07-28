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
package eu.numberfour.n4js.typesystem

import eu.numberfour.n4js.N4JSInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Before
import eu.numberfour.n4js.validation.IssueCodes

/*
 * Tests for {@link TypeSystemHelper#join(RuleEnvironment, TypeRef...)} method with union types.
 */
@RunWith(XtextRunner)
@InjectWith(N4JSInjectorProvider)
class JoinComputer_UnionTypesTest extends AbstractTypeSystemHelperTests {

	@Before
	def void prepareTypeDefs() {
		setDefaultTypeDefinitions()
	}

	/*
	 * Test some assumptions.
	 */
	@Test
	def void testJoinAsumptions() {
		assertJoin("G<? extends A>", "G<A>", "G<B>");
		assertJoin("A", "A", "B");

		// G is instanceof of N4OBject ;-)
		assertJoin("N4Object", "G<A>", "A");
	}

	@Test
	def void testJoinSimpleWithUnions() {
		assertJoin(#[IssueCodes.UNI_UNNECESSARY_SUBTYPE], "union{A,B}", "A", "union{A,B}");
		assertJoin(#[IssueCodes.UNI_UNNECESSARY_SUBTYPE], "union{A,B}", "union{A,B}", "A");
		assertJoin(#[IssueCodes.UNI_UNNECESSARY_SUBTYPE], "union{A,B}", "A", "union{B,A}");
	}

	@Test
	def void testJoinUnionWithUnions() {
		assertJoin(#[IssueCodes.UNI_UNNECESSARY_SUBTYPE,IssueCodes.UNI_UNNECESSARY_SUBTYPE], "union{A,B,C}", "union{A,B}", "union{B,C}");
		assertJoin(#[IssueCodes.UNI_UNNECESSARY_SUBTYPE], "union{B,C}", "C", "union{B,C}");
	}



	@Test
	def void testJoinWithUnionsAndGenerics() {

		// this is not G<? extends A>: G<union{A,B}> != union{G<A>, G<B>} !!!!!
		// upper A v union{A,B} = union{A,B}
		// lower A ^ union{A,B} = B
		// union{A,B} ... B
		// TODO: why not G<A>?
		assertJoin(#[IssueCodes.UNI_UNNECESSARY_SUBTYPE], "G<? extends union{A,B}>", "G<A>", "G<union{A,B}>");

		assertJoin(#[IssueCodes.UNI_UNNECESSARY_SUBTYPE], "union{A,B,G<A>}", "G<A>", "union{A,B}");
	}

}
