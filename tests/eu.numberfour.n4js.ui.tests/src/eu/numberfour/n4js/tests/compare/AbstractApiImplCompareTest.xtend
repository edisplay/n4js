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
package eu.numberfour.n4js.tests.compare

import com.google.inject.Inject
import eu.numberfour.n4js.ApiImplCompareTestHelper
import eu.numberfour.n4js.compare.ProjectCompareHelper
import eu.numberfour.n4js.compare.ProjectCompareResult.Status
import org.junit.Assert
import org.junit.Test

abstract class AbstractApiImplCompareTest extends Assert {

	protected static val PROJECT_ID_API = "eu.numberfour.sample.api"
	protected static val PROJECT_ID_IMPL = "eu.numberfour.sample.n4js"
	protected static val PROJECT_ID_UTILS = "eu.numberfour.sample.utils"


	@Inject
	private ProjectCompareHelper projectCompareHelper;
	@Inject
	private extension ApiImplCompareTestHelper;


	@Test
	public def testBasicCases() {
		val errMsgs = newArrayList
		val comparison = projectCompareHelper.createComparison(true,errMsgs)
		assertEquals(0, errMsgs.size)

		// checking class Clazz

		comparison.assertCorrectChildEntries("x/y/M","Clazz",

			// format:
			// childName  ->  expected comparison status  ->  expected comparison description

			"fieldOK" -> Status.EQUAL -> null,
			"fieldOK_ClazzOther" -> Status.EQUAL -> null,
			"fieldOK_B" -> Status.EQUAL -> null,
			"fieldGONE" -> Status.ERROR -> "missing implementation",
			"fieldWrongType" -> Status.ERROR -> "failed: number is not a subtype of string",
			"fieldOnlyInImplementation" -> Status.COMPLIANT -> null,
			"fieldVisibilityReduced" -> Status.ERROR -> "reduced visibility",

			"methodOK" -> Status.EQUAL -> null,
			"methodImplicitVoid" -> Status.EQUAL -> null,
			"methodFewerPars" -> Status.COMPLIANT -> null,
			"methodCompliant" -> Status.COMPLIANT -> null,
			"methodOnlyInImplementation" -> Status.COMPLIANT -> null,
			"methodGetType" -> Status.EQUAL -> null,
			"methodReducedVisibility" -> Status.ERROR -> "reduced visibility",
			"methodWithSurplusOptionalFparsOnApiSide" -> Status.COMPLIANT -> null,
			"methodWithSurplusOptionalFparsOnImplSide" -> Status.COMPLIANT -> null
		)

		// checking enum Color

		comparison.assertCorrectChildEntries("x/y/M", "Color",

			// format:
			// childName  ->  expected comparison status  ->  expected comparison description

			"RED" -> Status.EQUAL -> null,
			"BLACK" -> Status.COMPLIANT -> null,
			"GREEN" -> Status.EQUAL -> null,
			"BLUE" -> Status.EQUAL -> null
		)

		// checking interface I

		comparison.assertCorrectChildEntries("x/y/M", "I",
			"methodOK" -> Status.EQUAL -> null,
			"methodDefaultImpl" -> Status.EQUAL -> null,
			"methodMissingDefaultImpl" -> Status.ERROR -> "no body in implementation but @ProvidesDefaultImplementation in API"
		)

		comparison.assertCorrectChildEntries("x/y/M", "DB",
			"method" -> Status.COMPLIANT -> null,
			"mFromSuperClassInImpl" -> Status.EQUAL -> null,
			"mFromInterfaceInImpl" -> Status.EQUAL -> null
		)

		comparison.assertCorrectChildEntries("x/y/M", "DC",
			"method" -> Status.COMPLIANT -> null
		)

		comparison.assertCorrectChildEntries("x/y/M", "DD",
			"method" -> Status.EQUAL -> null
		)
		
		comparison.assertCorrectTypeEntry("x/y/M", 
			"TypeVariableTest1" -> Status.ERROR -> "the number of type variables doesn't match",
			"TypeVariableTest2" -> Status.EQUAL -> null,
			"TypeVariableTest21" -> Status.ERROR -> "the upper bound of type variable Other isn't compatible with the API",
			"TypeVariableTest3" -> Status.EQUAL -> null
		)
	}
}
