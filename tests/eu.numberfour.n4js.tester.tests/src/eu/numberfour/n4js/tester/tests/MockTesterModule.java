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
package eu.numberfour.n4js.tester.tests;

import static com.google.inject.name.Names.named;
import static eu.numberfour.n4js.tester.TesterModuleDefaults.DEFAULT_FSM_TIMEOUT_KEY;
import static eu.numberfour.n4js.tester.TesterModuleDefaults.SETUP_FSM_TIMEOUT_KEY;
import static java.util.concurrent.TimeUnit.SECONDS;

import com.google.inject.AbstractModule;

import eu.numberfour.n4js.tester.internal.InternalTestTreeRegistry;

/**
 * Customized module used for testing.
 * <p>
 * This module was mainly introduced to modify timeout properties to speed up test.
 */
public class MockTesterModule extends AbstractModule {

	private static final long TEST_SETUP_FSM_TIMEOUT_VALUE = SECONDS.toMillis(1L);
	private static final long TEST_DEFAULT_FSM_TIMEOUT_VALUE = SECONDS.toMillis(1L);

	@Override
	protected void configure() {
		bind(InternalTestTreeRegistry.class).to(NoopTestTreeRegistry.class);
		bind(Long.class).annotatedWith(named(DEFAULT_FSM_TIMEOUT_KEY)).toInstance(TEST_DEFAULT_FSM_TIMEOUT_VALUE);
		bind(Long.class).annotatedWith(named(SETUP_FSM_TIMEOUT_KEY)).toInstance(TEST_SETUP_FSM_TIMEOUT_VALUE);
	}

}
