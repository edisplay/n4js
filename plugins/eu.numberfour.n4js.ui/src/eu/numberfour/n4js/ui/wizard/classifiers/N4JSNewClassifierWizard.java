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
package eu.numberfour.n4js.ui.wizard.classifiers;

import java.lang.reflect.InvocationTargetException;
import java.nio.file.FileSystemException;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.xtext.ui.editor.LanguageSpecificURIEditorOpener;
import org.eclipse.xtext.xbase.lib.StringExtensions;

import com.google.inject.Inject;

import eu.numberfour.n4js.projectModel.IN4JSCore;
import eu.numberfour.n4js.ui.wizard.generator.WorkspaceWizardGenerator;
import eu.numberfour.n4js.ui.wizard.workspace.WorkspaceWizardModel;

/**
 * Generic interface for creating new N4JS classifiers. For instance classes and interfaces.
 */
public abstract class N4JSNewClassifierWizard<M extends N4JSClassifierWizardModel> extends Wizard
		implements INewWizard {

	@Inject
	private IN4JSCore n4jsCore;

	@Inject
	private LanguageSpecificURIEditorOpener uriOpener;

	@Override
	public final void init(IWorkbench workbench, IStructuredSelection selection) {
		init(workbench, selection, false);
	}

	/**
	 * Initiates the classifier wizard with given workbench, selection and nested option.
	 *
	 * The nested option specifies if the initial selection should try to infer the module file or just use its
	 * container.
	 *
	 * @param workbench
	 *            The workbench
	 * @param selection
	 *            The selection
	 * @param nested
	 *            The nested option
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection, boolean nested) {
		this.setNeedsProgressMonitor(false);
		this.setWindowTitle("New N4JS " + StringExtensions.toFirstUpper(getModel().getClassifierName()));
		this.setNeedsProgressMonitor(true);
		parseIntialSelection(selection, nested);
	}

	private void parseIntialSelection(IStructuredSelection selection, boolean nested) {
		WorkspaceWizardModel.populateModelFromInitialSelection(getModel(), selection, nested, n4jsCore);
		getPage().setModel(getModel());
	}

	@Override
	public boolean performFinish() {

		final IPath fileLocation = getModel().computeFileLocation();

		IRunnableWithProgress createClassifierRunnable = new IRunnableWithProgress() {

			@Override
			public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
				// Create missing module folders
				IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();

				if (!workspaceRoot.getFile(fileLocation).exists()) {

					IContainer parent = workspaceRoot.getProject(getModel().getProject().toString());

					try { // Iterate through remaining segments but the file segment
						for (String segment : fileLocation.makeRelativeTo(getModel().getProject()).removeLastSegments(1)
								.segments()) {
							IFolder subfolder = parent.getFolder(new Path(segment));
							if (!subfolder.exists()) {
								subfolder.create(true, true, null);
							}
							parent = subfolder;
						}
					} catch (CoreException e) {
						throw new InvocationTargetException(new Throwable("Failed to create module folders"));
					}
				}
				SubMonitor subMonitor = SubMonitor.convert(monitor);

				doGenerateClassifier(subMonitor);

				monitor.done();
			}
		};

		try {
			getContainer().run(true, false, createClassifierRunnable);
		} catch (InvocationTargetException e) {
			e.getTargetException().printStackTrace();
			getPage().setErrorMessage(e.getTargetException().getMessage());
			return false;
		} catch (InterruptedException e) {
			// Interruption isn't handled.
			return false;
		}

		// Open the written file
		uriOpener.open(URI.createPlatformResourceURI(fileLocation.toString(), true), true);

		return true;
	}

	@Override
	public void addPages() {
		this.addPage(getPage());
	}

	/**
	 * Returns with the model used for data binding purposes during the life of the wizard.
	 */
	protected abstract M getModel();

	/**
	 * Performs the actual generation of {@link #performFinish()} call.
	 *
	 */
	protected void doGenerateClassifier(IProgressMonitor monitor) throws InvocationTargetException {
		monitor = SubMonitor.convert(monitor, 2);

		// Perform manifest changes
		if (!getGenerator().performManifestChanges(getModel(), monitor)) {
			throw new InvocationTargetException(
					new FileSystemException("Failed to create the new " + getModel().getClassifierName()
							+ ": Couldn't perform manifest changes"));
		}
		monitor.worked(1);

		// Write the class to file
		if (!getGenerator().writeToFile(getModel(), monitor)) {
			throw new InvocationTargetException(
					new FileSystemException("Failed to create the new " + getModel().getClassifierName()
							+ ": Couldn't write the " + getModel().getClassifierName() + " file."));
		}
		monitor.worked(1);
	}

	/**
	 * Returns the wizard's generator.
	 */
	protected abstract WorkspaceWizardGenerator<M> getGenerator();

	/**
	 * Returns with the one single {@link N4JSNewClassifierWizardPage classifier wizard page}.
	 */
	protected abstract N4JSNewClassifierWizardPage<M> getPage();
}
