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
package eu.numberfour.n4js.tester.tests

import java.util.Map
import com.google.inject.Inject
import eu.numberfour.n4js.tester.server.HttpServerManager
import eu.numberfour.n4js.tester.server.JettyManager
import com.google.common.collect.ImmutableMap

import static eu.numberfour.n4js.tester.server.HttpServerManager.HTTP_PORT;
import static eu.numberfour.n4js.tester.tests.TesterConstants.*
/**
 *
 */
class TesterTestsConfiguration {
	
	@Inject
	private HttpServerManager serverManager;
	
	// the actual port for the testServer, will be computed in #before()
	private int port;
	private Map<String,Object> valid_config;	
	
	/** computes available port and stores the value into #port, also create a minimal valid map for tests -stored in valid_config */
	public def Map<String,Object> computePortAndValidConfig() {
		port = (serverManager as JettyManager).ensurePortIsAvailable(8080);
		/** A valid configuration for the server. */
		valid_config = ImmutableMap.<String, Object> builder()
			.put(HTTP_PORT, port)
		 	.build();
		return valid_config; 	
	}
	
	def int getPORT() { return port; }
	
	def Map<String, Object> getVALID_CONFIG() { return valid_config; }
	
	def String getURL() {
		HOST_AND_PORT + CONTEXT_ROOT + CONTEXT_PATH;
	}
	
	def String HOST_AND_PORT() {
		"http://" + HOST + ":" + PORT
	}
}