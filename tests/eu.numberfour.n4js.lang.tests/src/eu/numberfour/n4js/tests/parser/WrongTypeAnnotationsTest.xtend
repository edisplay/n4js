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
package eu.numberfour.n4js.tests.parser

import org.junit.Test

/**
 */
class WrongTypeAnnotationsTest extends AbstractParserTest {

	/**
	 * This test failed during smoke tests due to a problem when resolving proxies.
	 * Error message:
	 * <pre>
	 * java.lang.Error: forward reference only allowed to identifiable subtrees;
	 * but was:
	 * eu.numberfour.n4js.n4JS.impl.N4InterfaceDeclarationImpl@6beef8bc (declaredModifiers: [public], name: null) (typingStrategy: ?~)
	 * in ...
	 * at eu.numberfour.n4js.postprocessing.AbstractProcessor.assertTrueIfRigid(AbstractProcessor.java:177)
	 * </pre>
	 * <p>Explanation of the problem:</p>
	 * <pre>
	 * ... foo(union{A,B} p) ...
	 * </pre>
	 * is a correct declaration with the old syntax. So no problems there.
	 * Now with the colon seperated type annotations, the parser completely messes up:
	 * It interprets the code as follows:
	 * <pre>
	 * ... foo(union) { A,B } ...
	 * </pre>
	 * The parser generates errors, so this is the "recovered" state. Actually an interesting solution...
	 * Anyway. It interprets "A,B" as comma expression in a body. Since everything is messed up, I'm absolutely not sure where to really fix the problem.
	 *
	 * <p>
	 * Due to this problem, and possible other problems, exceptions are swallowed in case of corrupt ASTs. See
	 * eu.numberfour.n4js.scoping.N4JSScopeProvider.getScope(EObject, EReference)
	 * and
	 * eu.numberfour.n4js.resource.N4JSPostProcessor.performPostProcessing(PostProcessingAwareResource, CancelIndicator)
	 */
	@Test
	def void testTypeAnnotationMayBeInterpretedAsBody() {
		'''
			public interface <T extends A> {
				<S> foo(union{A,C} p)
				abstract bar()
				baz(p: A?)
			}
		'''.parseWithError
	// assertTrue(script.eResource.errors.toString, script.eResource.errors.empty)
	}

}
