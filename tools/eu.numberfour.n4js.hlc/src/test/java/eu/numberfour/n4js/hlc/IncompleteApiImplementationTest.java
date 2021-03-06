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

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import eu.numberfour.n4js.hlc.N4jsc.ExitCodeException;
import eu.numberfour.n4js.hlc.helper.N4CliHelper;

/**
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IncompleteApiImplementationTest extends AbstractN4jscTest {

	private static final String TEST_DATA_SET__API_IMPL = "api-impl--stubs-if-incomplete";
	private static String proot;
	private static String project_one_api_execution;
	private static String pathTo_one_api_execution;

	/**
	 * Output-log-file of external Process. The file will be assigned given on the current test-method by calling
	 * {@link #logFile()} as first statement in each test-method.
	 */
	protected File outputLogFile = null;

	/**
	 * Setup workspace with api & api-impl & compile
	 *
	 */
	@BeforeClass
	public static void setupWorkspace() throws IOException, ExitCodeException {
		setupWorkspace(TEST_DATA_SET__API_IMPL);

		compileAPI_And_API_Impl();
	}

	/**
	 * Upfront compilation when loading this test-class.
	 */
	public static void compileAPI_And_API_Impl() throws ExitCodeException {

		proot = TARGET + "/" + WSP;

		project_one_api_execution = "one.api.execution";
		pathTo_one_api_execution = proot + "/" + project_one_api_execution;

		String[] args = { "-pl", proot,
				"-t", "allprojects",
				"-v"
		};

		new N4jsc().doMain(args);
	}

	String fileToExecute_direct(String filename) {
		return pathTo_one_api_execution + "/src/direct/" + filename;
	}

	String fileToExecute_fields(String filename) {
		return pathTo_one_api_execution + "/src/fields/" + filename;
	}

	String fileToExecute_if(String filename) {
		return pathTo_one_api_execution + "/src/if/" + filename;
	}

	String fileToExecute_routing(String filename) {
		return pathTo_one_api_execution + "/src/routing/" + filename;
	}

	String fileToExecute_var_and_fun(String filename) {
		return pathTo_one_api_execution + "/src/var_and_fun/" + filename;
	}

	String[] runArgs(String execPath) {
		return new String[] { "-pl", proot,
				"-t", "dontcompile",
				"-rw", "nodejs",
				"-r", execPath,
				"--debug",
				"-v"
		};
	}

	void run(String[] args) throws ExitCodeException {
		new N4jsc().doMain(args);
	}

	static String runCaptureOut(String[] args) throws ExitCodeException, IOException {

		boolean keepOutputForDebug = true;

		File errorFile = File.createTempFile("run_err", null);
		File outputFile = File.createTempFile("run_out", null);

		if (!keepOutputForDebug) {
			errorFile.deleteOnExit();
			outputFile.deleteOnExit();
		} else {
			System.out.println("Errors: " + errorFile + "    Ouput: " + outputFile);
		}

		setOutputfileSystemProperties(errorFile.getAbsolutePath(), outputFile.getAbsolutePath());

		new N4jsc().doMain(args);

		// cleanup properties.
		setOutputfileSystemProperties("", "");

		// read the files, concat & return string.
		return N4CliHelper.readLogfile(errorFile) + N4CliHelper.readLogfile(outputFile);
	}

	/**
	 * Set system-properties for the Runner.
	 *
	 * @param errorFile
	 *            File to write errror-stream to
	 * @param outputFile
	 *            File to write output-stream to
	 */
	private static void setOutputfileSystemProperties(String errorFile, String outputFile) {
		System.setProperty("eu.numberfour.n4js.runner.RunnerFrontEnd.ERRORFILE", errorFile);
		System.setProperty("eu.numberfour.n4js.runner.RunnerFrontEnd.OUTPUTFILE", outputFile);
	}

	/**
	 * Should be called as first line in test-mehtods.
	 *
	 * Creates an log-file in the {@link #TARGET}-folder based on the callers Class/Methodname. something like
	 * "target/eu.numberfour.n4js.hlc.test.N4jscSingleFileCompileIT.testHelp.log"
	 */
	protected void logFile() {
		StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[2];
		String name = stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ".log";
		outputLogFile = new File(TARGET, name);
	}

	/** testing correct behavior of untouched elements. */
	@Test
	public void testImplemented_members() throws ExitCodeException, IOException {
		System.out.println(logMethodname());

		String out = runCaptureOut(runArgs(fileToExecute_direct("Exec_implemented_members.n4js")));

		String expectedString = "Loaded Implementation one.x.impl::p.A.n4js"
				+ "\n"
				+ "OK: holds not undefined"
				+ "\n"
				+ "OK: holds not undefined";
		N4CliHelper.assertExpectedOutput(expectedString, out);
	}

	/**  */
	@Test
	public void testMissing_field_in_class() throws ExitCodeException, IOException {
		System.out.println(logMethodname());
		String out = runCaptureOut(runArgs(fileToExecute_direct("Exec_missing_field_in_class.n4js")));
		String expectedString = "Loaded Implementation one.x.impl::p.A.n4js";
		N4CliHelper.assertExpectedOutput(expectedString, out);
	}

	/**  */
	@Test
	public void testMissing_getter_in_class() throws ExitCodeException, IOException {
		System.out.println(logMethodname());
		String out = runCaptureOut(runArgs(fileToExecute_direct("Exec_missing_getter_in_class.n4js")));
		String expectedString = "Loaded Implementation one.x.impl::p.A.n4js";
		N4CliHelper.assertExpectedOutput(expectedString, out);
	}

	/**  */
	@Test
	public void testMissing_method_in_class() throws ExitCodeException, IOException {
		System.out.println(logMethodname());
		String out = runCaptureOut(runArgs(fileToExecute_direct("Exec_missing_method_in_class.n4js")));
		String expectedString = "Loaded Implementation one.x.impl::p.A.n4js";
		N4CliHelper.assertExpectedOutput(expectedString, out);
	}

	/**  */
	@Test
	public void testMissing_method2_in_class() throws ExitCodeException, IOException {
		System.out.println(logMethodname());
		String out = runCaptureOut(runArgs(fileToExecute_direct("Exec_missing_method2_in_class.n4js")));
		String expectedString = "Loaded Implementation one.x.impl::p.A.n4js";
		N4CliHelper.assertExpectedOutput(expectedString, out);
	}

	/**  */
	@Test
	public void testMissing_setter_in_class() throws ExitCodeException, IOException {
		System.out.println(logMethodname());
		String out = runCaptureOut(runArgs(fileToExecute_direct("Exec_missing_setter_in_class.n4js")));
		String expectedString = "Loaded Implementation one.x.impl::p.A.n4js";
		N4CliHelper.assertExpectedOutput(expectedString, out);
	}

	// ++ ++ ++++++++ + + ++++ +++ + ++ +
	// Enums
	// ++ ++ ++++++++ + + ++++ +++ + ++ +

	/**  */
	@Test
	public void testEnums_Literal_in_existing_Enum() throws ExitCodeException, IOException {
		System.out.println(logMethodname());
		String out = runCaptureOut(
				runArgs(fileToExecute_direct("Exec_AT_IDE_1510_Enums_Literal_in_existing_Enum.n4js")));
		String expectedString = "Loaded Implementation one.x.impl::p.A.n4js" + "\n" +
				"OK: holds not undefined" + "\n" +
				"OK: holds not undefined" + "\n" +
				"OK: holds not undefined";
		N4CliHelper.assertExpectedOutput(expectedString, out);
	}

	/**  */
	@Test
	@Ignore("IDE-1574 decide on Enum-strategy.")
	public void testEnums_literal_in_missing_Enum() throws ExitCodeException, IOException {
		System.out.println(logMethodname());
		String out = runCaptureOut(
				runArgs(fileToExecute_direct("Exec_AT_IDE_1510_Enums_literal_in_missing_Enum.n4js")));
		String expectedString = "Loaded Implementation one.x.impl::p.A.n4js";
		N4CliHelper.assertExpectedOutput(expectedString, out);
	}

	/**  */
	@Test
	@Ignore("IDE-1574 decide on Enum-strategy.")
	public void testEnums_literal_in_missing_EnumSB() throws ExitCodeException, IOException {
		System.out.println(logMethodname());
		String out = runCaptureOut(
				runArgs(fileToExecute_direct("Exec_AT_IDE_1510_Enums_literal_in_missing_EnumSB.n4js")));
		String expectedString = "Loaded Implementation one.x.impl::p.A.n4js";
		N4CliHelper.assertExpectedOutput(expectedString, out);
	}

	/**  */
	@Test
	@Ignore("IDE-1574 decide on Enum-strategy.")
	public void testEnums_missing_Literal_in_existing_Enum() throws ExitCodeException, IOException {
		System.out.println(logMethodname());
		String out = runCaptureOut(
				runArgs(fileToExecute_direct("Exec_AT_IDE_1510_Enums_missing_Literal_in_existing_Enum.n4js")));
		String expectedString = "Loaded Implementation one.x.impl::p.A.n4js";
		N4CliHelper.assertExpectedOutput(expectedString, out);
	}

	/**  */
	@Test
	@Ignore("IDE-1574 decide on Enum-strategy.")
	public void testEnums_missing_Literal_in_existing_EnumSB() throws ExitCodeException, IOException {
		System.out.println(logMethodname());
		String out = runCaptureOut(
				runArgs(fileToExecute_direct("Exec_AT_IDE_1510_Enums_missing_Literal_in_existing_EnumSB.n4js")));
		String expectedString = "Loaded Implementation one.x.impl::p.A.n4js";
		N4CliHelper.assertExpectedOutput(expectedString, out);
	}

	/**  */
	@Test
	public void testEnums_normal_existing_EnumSB() throws ExitCodeException, IOException {
		System.out.println(logMethodname());
		String out = runCaptureOut(runArgs(fileToExecute_direct("Exec_AT_IDE_1510_Enums_normal_existing_EnumSB.n4js")));
		String expectedString = "Loaded Implementation one.x.impl::p.A.n4js" + "\n" +
				"OK: holds not undefined" + "\n" +
				"OK: holds not undefined" + "\n" +
				"OK: holds not undefined";
		N4CliHelper.assertExpectedOutput(expectedString, out);
	}

	// ++ ++ ++++++++ + + ++++ +++ + ++ +
	// Intefaces
	// ++ ++ ++++++++ + + ++++ +++ + ++ +

	/**  */
	@Test
	// @Ignore("IDE-1576 requires mix-in of stub")
	public void testInterfaces_provided_get_missing() throws ExitCodeException, IOException {
		System.out.println(logMethodname());
		String out = runCaptureOut(
				runArgs(fileToExecute_direct("Exec_AT_IDE-1510_Interfaces_provided_get_missing.n4js")));
		String expectedString = "Loaded Implementation one.x.impl::p.A.n4js";
		N4CliHelper.assertExpectedOutput(expectedString, out);
	}

	/**  */
	@Test
	public void testInterfaces_provided_get() throws ExitCodeException, IOException {
		System.out.println(logMethodname());
		String out = runCaptureOut(runArgs(fileToExecute_direct("Exec_AT_IDE-1510_Interfaces_provided_get.n4js")));
		String expectedString = "Loaded Implementation one.x.impl::p.A.n4js" + "\n" +
				"OK: holds not undefined";
		N4CliHelper.assertExpectedOutput(expectedString, out);
	}

	/**  */
	@Test
	// @Ignore("IDE-1576 requires mix-in of stub")
	public void testInterfaces_provided_method_missing() throws ExitCodeException, IOException {
		System.out.println(logMethodname());
		String out = runCaptureOut(
				runArgs(fileToExecute_direct("Exec_AT_IDE-1510_Interfaces_provided_method_missing.n4js")));
		String expectedString = "Loaded Implementation one.x.impl::p.A.n4js";
		N4CliHelper.assertExpectedOutput(expectedString, out);
	}

	/**  */
	@Test
	public void testInterfaces_provided_method() throws ExitCodeException, IOException {
		System.out.println(logMethodname());
		String out = runCaptureOut(runArgs(fileToExecute_direct("Exec_AT_IDE-1510_Interfaces_provided_method.n4js")));
		String expectedString = "Loaded Implementation one.x.impl::p.A.n4js" + "\n" +
				"OK: holds not undefined";
		N4CliHelper.assertExpectedOutput(expectedString, out);
	}

	/**  */
	@Test
	public void testInterfaces_provided_set_missing() throws ExitCodeException, IOException {
		System.out.println(logMethodname());
		String out = runCaptureOut(
				runArgs(fileToExecute_direct("Exec_AT_IDE-1510_Interfaces_provided_set_missing.n4js")));
		String expectedString = "Loaded Implementation one.x.impl::p.A.n4js";
		N4CliHelper.assertExpectedOutput(expectedString, out);
	}

	/**  */
	@Test
	public void testInterfaces_provided_set() throws ExitCodeException, IOException {
		System.out.println(logMethodname());
		String out = runCaptureOut(runArgs(fileToExecute_direct("Exec_AT_IDE-1510_Interfaces_provided_set.n4js")));
		String expectedString = "Loaded Implementation one.x.impl::p.A.n4js";
		N4CliHelper.assertExpectedOutput(expectedString, out);
	}

	/**  */
	@Test
	public void testInterfaces_static_method_missing() throws ExitCodeException, IOException {
		System.out.println(logMethodname());
		String out = runCaptureOut(
				runArgs(fileToExecute_direct("Exec_AT_IDE-1510_Interfaces_static_method_missing.n4js")));
		String expectedString = "Loaded Implementation one.x.impl::p.A.n4js";
		N4CliHelper.assertExpectedOutput(expectedString, out);
	}

	/**  */
	@Test
	public void testInterfaces_static_method() throws ExitCodeException, IOException {
		System.out.println(logMethodname());
		String out = runCaptureOut(runArgs(fileToExecute_direct("Exec_AT_IDE-1510_Interfaces_static_method.n4js")));
		String expectedString = "Loaded Implementation one.x.impl::p.A.n4js" + "\n" +
				"OK: holds not undefined";
		N4CliHelper.assertExpectedOutput(expectedString, out);
	}

	/**  */
	@Test
	public void testInterfaces_static_getter_missing() throws ExitCodeException, IOException {
		System.out.println(logMethodname());
		String out = runCaptureOut(
				runArgs(fileToExecute_direct("Exec_AT_IDE-1510_Interfaces_static_getter_missing.n4js")));
		String expectedString = "Loaded Implementation one.x.impl::p.A.n4js";
		N4CliHelper.assertExpectedOutput(expectedString, out);
	}

	/**  */
	@Test
	public void testInterfaces_static_setter_missing() throws ExitCodeException, IOException {
		System.out.println(logMethodname());
		String out = runCaptureOut(
				runArgs(fileToExecute_direct("Exec_AT_IDE-1510_Interfaces_static_setter_missing.n4js")));
		String expectedString = "Loaded Implementation one.x.impl::p.A.n4js";
		N4CliHelper.assertExpectedOutput(expectedString, out);
	}

	// ++ ++ ++++++++ + + ++++ +++ + ++ +
	// Interfaces - mixed in member stubs
	// ++ ++ ++++++++ + + ++++ +++ + ++ +
	/** accumulative testing of combinations. */
	@Test
	public void testConsumed_Members_of_Missing_Inteface() throws ExitCodeException, IOException {
		System.out.println(logMethodname());
		String out = runCaptureOut(
				runArgs(fileToExecute_if("Exec_AT_IDE-1510_Consumed_Members_of_Missing_Inteface.n4js")));
		String expectedString = "Loaded Implementation one.x.impl::p.IF.n4js";
		N4CliHelper.assertExpectedOutput(expectedString, out);
	}

	/**
	 * Testing the most simple case where client-code extends an API-interface with an default-initialized field (IA.f)
	 * which is actually missing from the concrete implementation. Unfortunately fields behave very different form
	 * getter/setter/methods, hence, in client code the generated get/set stub cannot be known and a raw-property access
	 * on the JS-Object will be obtained. This results in access to 'undefined'
	 */
	@Ignore("Client side access to missing mixed-in-fields cannot be detected.")
	@Test
	public void testConsumed_Members_of_Missing_Inteface_single_case() throws ExitCodeException, IOException {
		System.out.println(logMethodname());
		String out = runCaptureOut(
				runArgs(fileToExecute_if("Exec_AT_IDE-1510_Consumed_Members_of_Missing_Inteface_single_case.n4js")));
		String expectedString = "Loaded Implementation one.x.impl::p.IF.n4js";
		N4CliHelper.assertExpectedOutput(expectedString, out);
	}

	// ++ ++ ++++++++ + + ++++ +++ + ++ +
	// global function
	// ++ ++ ++++++++ + + ++++ +++ + ++ +
	/**  */
	@Test
	public void testFunction_test_function() throws ExitCodeException, IOException {
		System.out.println(logMethodname());
		String out = runCaptureOut(
				runArgs(fileToExecute_var_and_fun("Exec_AT_IDE-1510_Variable_And_Function_test_function.n4js")));
		String expectedString = "Loaded Implementation one.x.impl::p.VarFun.n4js";
		N4CliHelper.assertExpectedOutput(expectedString, out);
	}

	// ++ ++ ++++++++ + + ++++ +++ + ++ +
	// global variable
	// ++ ++ ++++++++ + + ++++ +++ + ++ +
	/**  */
	@Ignore("Variables not yet supported by Projectcomparison. Results in 'module cannot be loaded.'")
	@Test
	public void testVariable_global_variable() throws ExitCodeException, IOException {
		System.out.println(logMethodname());
		String out = runCaptureOut(
				runArgs(fileToExecute_var_and_fun("Exec_AT_IDE-1510_Variable_And_Function_test_global_variable.n4js")));
		String expectedString = "Loaded Implementation one.x.impl::p.VarFun.n4js";
		N4CliHelper.assertExpectedOutput(expectedString, out);
	}

	// ++ ++ ++++++++ + + ++++ +++ + ++ +
	// routing
	// ++ ++ ++++++++ + + ++++ +++ + ++ +
	/**  */
	@Test
	public void testSubclass_missing_inherited() throws ExitCodeException, IOException {
		System.out.println(logMethodname());
		String out = runCaptureOut(runArgs(fileToExecute_routing("Exec_AT_IDE-1510_Subclass_missing_inherited.n4js")));
		String expectedString = "Loaded Implementation one.x.impl::p.StubRoute.n4js";
		N4CliHelper.assertExpectedOutput(expectedString, out);
	}

	/** */
	@Test
	public void testSubclass_normal_inherited() throws ExitCodeException, IOException {
		System.out.println(logMethodname());
		String out = runCaptureOut(runArgs(fileToExecute_routing("Exec_AT_IDE-1510_Subclass_normal_inherited.n4js")));
		String expectedString = "Loaded Implementation one.x.impl::p.StubRoute.n4js";
		N4CliHelper.assertExpectedOutput(expectedString, out);
	}

	/** */
	@Test
	public void testInternal_impl_Subclass_UsingDirectImplementation() throws ExitCodeException, IOException {
		System.out.println(logMethodname());
		String out = runCaptureOut(runArgs(
				fileToExecute_routing("Exec_AT_IDE-1510_Internal_impl_Subclass_UsingDirectImplementation.n4js")));
		String expectedString = "Loaded Implementation one.x.impl::p.IF.n4js" + "\n"
				+ "Loaded Implementation one.x.impl::p.IFuser.n4js" + "\n"
				+ "OK: holds not undefined";
		N4CliHelper.assertExpectedOutput(expectedString, out);
	}

	/** */
	@Test
	public void testInternal_impl_Subclass_UsingIndirectImplementation() throws ExitCodeException, IOException {
		System.out.println(logMethodname());
		String out = runCaptureOut(runArgs(
				fileToExecute_routing("Exec_AT_IDE-1510_Internal_impl_Subclass_UsingIndirectImplementation.n4js")));
		String expectedString = "Loaded Implementation one.x.impl::p.IF.n4js" + "\n"
				+ "Loaded Implementation one.x.impl::p.IFuser.n4js" + "\n"
				+ "OK: holds not undefined";
		N4CliHelper.assertExpectedOutput(expectedString, out);
	}

	// ++ ++ ++++++++ + + ++++ +++ + ++ +
	// field versus get/set from supertype.
	// ++ ++ ++++++++ + + ++++ +++ + ++ +
	/**  */
	@Test
	public void testfield_vs_getset_1() throws ExitCodeException, IOException {
		System.out.println(logMethodname());
		String out = runCaptureOut(runArgs(fileToExecute_fields("Exec_AT_IDEBUG-505_field_vs_getset_2.n4js")));
		String expectedString = "Loaded Implementation one.x.impl::fields.F.n4js";
		N4CliHelper.assertExpectedOutput(expectedString, out);
	}

	/**  */
	@Test
	public void testfield_vs_getset_2() throws ExitCodeException, IOException {
		System.out.println(logMethodname());
		String out = runCaptureOut(runArgs(fileToExecute_fields("Exec_AT_IDEBUG-505_field_vs_getset_3.n4js")));
		String expectedString = "Loaded Implementation one.x.impl::fields.F.n4js";
		N4CliHelper.assertExpectedOutput(expectedString, out);
	}

	/**  */
	@Test
	public void testfield_vs_getset_3() throws ExitCodeException, IOException {
		System.out.println(logMethodname());
		String out = runCaptureOut(runArgs(fileToExecute_fields("Exec_AT_IDEBUG-505_field_vs_getset_4.n4js")));
		String expectedString = "Loaded Implementation one.x.impl::fields.F.n4js";
		N4CliHelper.assertExpectedOutput(expectedString, out);
	}

	/**  */
	@Test
	public void testfield_vs_getset_4() throws ExitCodeException, IOException {
		System.out.println(logMethodname());
		String out = runCaptureOut(runArgs(fileToExecute_fields("Exec_AT_IDEBUG-505_field_vs_getset_5.n4js")));
		String expectedString = "Loaded Implementation one.x.impl::fields.F.n4js";
		N4CliHelper.assertExpectedOutput(expectedString, out);
	}

	/**  */
	@Test
	public void testfield_vs_getset_5() throws ExitCodeException, IOException {
		System.out.println(logMethodname());
		String out = runCaptureOut(runArgs(fileToExecute_fields("Exec_AT_IDEBUG-505_field_vs_getset_1.n4js")));
		String expectedString = "Loaded Implementation one.x.impl::fields.F.n4js";
		N4CliHelper.assertExpectedOutput(expectedString, out);
	}

	/**  */
	@Test
	public void testfield_vs_getset_6() throws ExitCodeException, IOException {
		System.out.println(logMethodname());
		String out = runCaptureOut(runArgs(fileToExecute_fields("Exec_AT_IDEBUG-505_field_vs_getset_6.n4js")));
		String expectedString = "Loaded Implementation one.x.impl::fields.F.n4js";
		N4CliHelper.assertExpectedOutput(expectedString, out);
	}

	/**  */
	@Test
	public void testfield_vs_getset_7() throws ExitCodeException, IOException {
		System.out.println(logMethodname());
		String out = runCaptureOut(runArgs(fileToExecute_fields("Exec_AT_IDEBUG-505_field_vs_getset_7.n4js")));
		String expectedString = "Loaded Implementation one.x.impl::fields.F.n4js";
		N4CliHelper.assertExpectedOutput(expectedString, out);
	}

	/**  */
	@Test
	public void testfield_vs_getset_8() throws ExitCodeException, IOException {
		System.out.println(logMethodname());
		String out = runCaptureOut(runArgs(fileToExecute_fields("Exec_AT_IDEBUG-505_field_vs_getset_8.n4js")));
		String expectedString = "Loaded Implementation one.x.impl::fields.F.n4js";
		N4CliHelper.assertExpectedOutput(expectedString, out);
	}

	/**  */
	@Test
	public void testfield_vs_getset_9() throws ExitCodeException, IOException {
		System.out.println(logMethodname());
		String out = runCaptureOut(runArgs(fileToExecute_fields("Exec_AT_IDEBUG-505_field_vs_getset_9.n4js")));
		String expectedString = "Loaded Implementation one.x.impl::fields.F.n4js";
		N4CliHelper.assertExpectedOutput(expectedString, out);
	}

	/**  */
	@Test
	public void testfield_vs_getset_A() throws ExitCodeException, IOException {
		System.out.println(logMethodname());
		String out = runCaptureOut(runArgs(fileToExecute_fields("Exec_AT_IDEBUG-505_field_vs_getset_A.n4js")));
		String expectedString = "Loaded Implementation one.x.impl::fields.F.n4js";
		N4CliHelper.assertExpectedOutput(expectedString, out);
	}

	/**  */
	@Test
	public void testfield_vs_getset_B() throws ExitCodeException, IOException {
		System.out.println(logMethodname());
		String out = runCaptureOut(runArgs(fileToExecute_fields("Exec_AT_IDEBUG-505_field_vs_getset_B.n4js")));
		String expectedString = "Loaded Implementation one.x.impl::fields.F.n4js";
		N4CliHelper.assertExpectedOutput(expectedString, out);
	}

	/**  */
	@Test
	public void testfield_vs_getset_C() throws ExitCodeException, IOException {
		System.out.println(logMethodname());
		String out = runCaptureOut(runArgs(fileToExecute_fields("Exec_AT_IDEBUG-505_field_vs_getset_C.n4js")));
		String expectedString = "Loaded Implementation one.x.impl::fields.F.n4js";
		N4CliHelper.assertExpectedOutput(expectedString, out);
	}

	/**  */
	@Test
	public void testfield_vs_getset_D() throws ExitCodeException, IOException {
		System.out.println(logMethodname());
		String out = runCaptureOut(runArgs(fileToExecute_fields("Exec_AT_IDEBUG-505_field_vs_getset_D.n4js")));
		String expectedString = "Loaded Implementation one.x.impl::fields.F.n4js";
		N4CliHelper.assertExpectedOutput(expectedString, out);
	}

}
