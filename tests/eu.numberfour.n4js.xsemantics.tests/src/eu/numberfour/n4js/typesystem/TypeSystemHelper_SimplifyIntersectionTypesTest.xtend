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

import eu.numberfour.n4js.ts.typeRefs.IntersectionTypeExpression
import eu.numberfour.n4js.ts.typeRefs.TypeRef
import eu.numberfour.n4js.ts.utils.TypeUtils
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import static org.junit.Assert.*
import eu.numberfour.n4js.N4JSInjectorProviderWithIssueSuppression

/*
 * Tests for {@link eu.numberfour.n4js.typesystem.XsemanticsTypeSystemHelper.createIntersectionType(RuleEnvironment, TypeRef)} method with intersection types.
 */
@RunWith(XtextRunner)
@InjectWith(N4JSInjectorProviderWithIssueSuppression)
class TypeSystemHelper_SimplifyIntersectionTypesTest extends AbstractTypeSystemHelperTests {

	@Before
	def void prepareTypeDefs() {
		setDefaultTypeDefinitions()
	}

	/**
	 * Asserts that join of given type expressions equals a given expected type, for comparison
	 * {@link TypeRef#getTypeRefAsString()} is used.
	 */
	def void assertSimplify(String expectedType, String typeExpressionsToBeSimplified) {
		val G = assembler.prepareScriptAndCreateRuleEnvironment(typeExpressionsToBeSimplified)
		var typeRef = assembler.getTypeRef(typeExpressionsToBeSimplified)
		assertTrue("Error in test setup, expected intersection type", typeRef instanceof IntersectionTypeExpression);
		val simplified = TypeUtils.copy(tsh.simplify(G, typeRef as IntersectionTypeExpression));
		assertEquals(expectedType, simplified.typeRefAsString);
	}



	@Test
	def void testSimplifyDuplicates() {
		assertSimplify("A", "intersection{A}");
		assertSimplify("intersection{I1,I2}", "intersection{I1,I2}");
		assertSimplify("intersection{I1,I2}", "intersection{I1,I2,I1}");
	}

	@Test
	def void testSimplifyNestedIntersections() {
		assertSimplify("intersection{I1,I2}", "intersection{I1,I2,intersection{I1,I2}}");
		assertSimplify("intersection{I1,I2,I3}", "intersection{I1,I2,intersection{I2,I3}}");
	}

	@Test
	def void testSimplifyUndefinedAndNull() {
		assertSimplify("intersection{I1,I2}", "intersection{I1,I2,undefined}");
		assertSimplify("intersection{I1,I2}", "intersection{I1,undefined,I2}");
		assertSimplify("A", "intersection{A,undefined}");
		assertSimplify("A", "intersection{undefined,A}");
		assertSimplify("undefined", "intersection{undefined,undefined}");
	}

}
