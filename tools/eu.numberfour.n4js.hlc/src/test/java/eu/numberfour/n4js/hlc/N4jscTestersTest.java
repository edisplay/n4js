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
package eu.numberfour.n4js.hlc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableSet;
import com.google.common.io.Files;

import eu.numberfour.n4js.hlc.N4jsc.ExitCodeException;

/**
 * Tests for launching N4JS tests via the command line.
 */
public class N4jscTestersTest extends AbstractN4jscTest {

	private static Collection<String> REQUIRED_LIBS = ImmutableSet.<String> builder()
			.add("eu.numberfour.mangelhaft")
			.add("eu.numberfour.mangelhaft.assert")
			.add("n4js-runtime-n4")
			.add("n4js-runtime-v8")
			.add("n4js-runtime-es2015")
			.add("n4js.lang")
			.build();

	/**
	 * Prepare tests.
	 */
	@Before
	public void setupWorkspace() throws IOException {
		setupWorkspace(TEST_DATA_SET__TESTERS, Predicates.in(REQUIRED_LIBS));
	}

	/**
	 * Simple test of compiling a project and launching <u>a single test file</u>.
	 *
	 * @throws ExitCodeException
	 *             in error cases ( not expected )
	 */
	@Test
	public void testCompile_And_LaunchSingleTestFile() throws ExitCodeException {
		System.out.println(logMethodname());

		String proot = TARGET + "/" + WSP;

		// Project
		String projectDemoTest = "DemoTest";
		String pathToDemoTest = proot + "/" + projectDemoTest;

		// absolute src filename
		String fileFooTest = pathToDemoTest + "/test/FooTest.n4js";

		String[] args = { "-pl", proot,
				"-t", "allprojects",
				"-tw", "nodejs",
				"--test", fileFooTest,
				"-v"
		};

		new N4jsc().doMain(args);

		// TODO add proper assertion that test was actually executed properly!!!
	}

	/**
	 * Gathers all tests from the workspace and generates a test catalog (given as absolute path).
	 */
	@Test
	public void testCompileAllProjectsGenerateTestCatalog_absolutePath()
			throws ExitCodeException, FileNotFoundException, IOException {
		System.out.println(logMethodname());
		final File tempDir = Files.createTempDir();
		tempDir.deleteOnExit();
		final String proot = TARGET + "/" + WSP;
		final String[] args = { "-pl", proot,
				"-t", "allprojects",
				"-tc", tempDir + "/test-catalog.json",
				"-v"
		};

		new N4jsc().doMain(args);
		final File file = new File(tempDir + "/test-catalog.json");
		file.deleteOnExit();
		final String actual = new String(
				java.nio.file.Files.readAllBytes(Paths.get(file.toURI())));
		final String expected = "[{\"origin\":\"DemoTest\",\"fqn\":\"BarTest.OsInspectorTest2\",\"testMethods\":[\"testFail\"]},{\"origin\":\"DemoTest\",\"fqn\":\"FooTest.OsInspectorTest\",\"testMethods\":[\"testPass\"]},{\"origin\":\"SysProjectA\",\"fqn\":\"T.T\",\"testMethods\":[\"t\"]},{\"origin\":\"TestProjectA\",\"fqn\":\"A.A\",\"testMethods\":[\"a\"]},{\"origin\":\"TestProjectA\",\"fqn\":\"B.B\",\"testMethods\":[\"b1\",\"b2\"]},{\"origin\":\"TestProjectB\",\"fqn\":\"CSub1.CSub1\",\"testMethods\":[\"c1\",\"c2\"]},{\"origin\":\"TestProjectB\",\"fqn\":\"CSub2.CSub2\",\"testMethods\":[\"c1\",\"c2\",\"c3\"]}]";
		assertEquals(expected, actual);
	}

	/**
	 * Gathers all tests from the workspace and generates a test catalog (given as relative path).
	 */
	@Test
	public void testCompileAllProjectsGenerateTestCatalog_relativePath()
			throws ExitCodeException, FileNotFoundException, IOException {
		System.out.println(logMethodname());
		final String proot = TARGET + "/" + WSP;
		final String[] args = { "-pl", proot,
				"-t", "allprojects",
				"-tc", "test-catalog.json",
				"-v"
		};

		new N4jsc().doMain(args);
		final File file = new File("test-catalog.json");
		file.deleteOnExit();
		final String actual = new String(
				java.nio.file.Files.readAllBytes(Paths.get(file.toURI())));
		final String expected = "[{\"origin\":\"DemoTest\",\"fqn\":\"BarTest.OsInspectorTest2\",\"testMethods\":[\"testFail\"]},{\"origin\":\"DemoTest\",\"fqn\":\"FooTest.OsInspectorTest\",\"testMethods\":[\"testPass\"]},{\"origin\":\"SysProjectA\",\"fqn\":\"T.T\",\"testMethods\":[\"t\"]},{\"origin\":\"TestProjectA\",\"fqn\":\"A.A\",\"testMethods\":[\"a\"]},{\"origin\":\"TestProjectA\",\"fqn\":\"B.B\",\"testMethods\":[\"b1\",\"b2\"]},{\"origin\":\"TestProjectB\",\"fqn\":\"CSub1.CSub1\",\"testMethods\":[\"c1\",\"c2\"]},{\"origin\":\"TestProjectB\",\"fqn\":\"CSub2.CSub2\",\"testMethods\":[\"c1\",\"c2\",\"c3\"]}]";
		assertEquals(expected, actual);
	}

	/**
	 * Gathers all tests from the workspace and generates a test catalog into an existing file (given as relative path).
	 */
	@Test
	public void testCompileAllProjectsGenerateTestCatalog_existingRelativePath()
			throws ExitCodeException, FileNotFoundException, IOException {
		System.out.println(logMethodname());

		final File existingFile = new File("test-catalog.json");
		existingFile.createNewFile();
		existingFile.deleteOnExit();

		final String proot = TARGET + "/" + WSP;
		final String[] args = { "-pl", proot,
				"-t", "allprojects",
				"-tc", "test-catalog.json",
				"-v"
		};

		new N4jsc().doMain(args);
		final File file = new File("test-catalog.json");
		file.deleteOnExit();
		final String actual = new String(
				java.nio.file.Files.readAllBytes(Paths.get(file.toURI())));
		final String expected = "[{\"origin\":\"DemoTest\",\"fqn\":\"BarTest.OsInspectorTest2\",\"testMethods\":[\"testFail\"]},{\"origin\":\"DemoTest\",\"fqn\":\"FooTest.OsInspectorTest\",\"testMethods\":[\"testPass\"]},{\"origin\":\"SysProjectA\",\"fqn\":\"T.T\",\"testMethods\":[\"t\"]},{\"origin\":\"TestProjectA\",\"fqn\":\"A.A\",\"testMethods\":[\"a\"]},{\"origin\":\"TestProjectA\",\"fqn\":\"B.B\",\"testMethods\":[\"b1\",\"b2\"]},{\"origin\":\"TestProjectB\",\"fqn\":\"CSub1.CSub1\",\"testMethods\":[\"c1\",\"c2\"]},{\"origin\":\"TestProjectB\",\"fqn\":\"CSub2.CSub2\",\"testMethods\":[\"c1\",\"c2\",\"c3\"]}]";
		assertEquals(expected, actual);
	}

	/**
	 * Tests invalid file catalog location
	 */
	@Test
	public void testInvalidTestCatalogLocation() {
		System.out.println(logMethodname());
		final String proot = TARGET + "/" + WSP;
		final String[] args = { "-pl", proot,
				"-t", "allprojects",
				"-tc", "some/fake/folder/test-catalog.json",
				"-v"
		};

		try {
			new N4jsc().doMain(args);
			fail("Expecting exit code: " + N4jsc.EXITCODE_TEST_CATALOG_ASSEMBLATION_ERROR);
		} catch (final ExitCodeException e) {
			assertEquals(N4jsc.EXITCODE_TEST_CATALOG_ASSEMBLATION_ERROR, e.getExitCode());
		}
	}

	/**
	 * Tests case when catalog location is a directory instead of a file.
	 */
	@Test
	public void testDirectoryTestCatalogLocation() {
		System.out.println(logMethodname());
		final File tempDir = Files.createTempDir();
		tempDir.deleteOnExit();
		final String proot = TARGET + "/" + WSP;
		final String[] args = { "-pl", proot,
				"-t", "allprojects",
				"-tc", tempDir.toString(),
				"-v"
		};

		try {
			new N4jsc().doMain(args);
			fail("Expecting exit code: " + N4jsc.EXITCODE_TEST_CATALOG_ASSEMBLATION_ERROR);
		} catch (final ExitCodeException e) {
			assertEquals(N4jsc.EXITCODE_TEST_CATALOG_ASSEMBLATION_ERROR, e.getExitCode());
		}
	}

	/*
	 * TODO more tests for launching testers from command-line
	 *
	 * Some ideas:
	 *
	 * - simple tests for launching a folder or project containing tests (instead of a file)
	 *
	 * - negative tests (e.g. launch folder that contains no tests, launch tests without compiling first, ...)
	 */
}
