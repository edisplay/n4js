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
package eu.numberfour.n4js.ui.resource;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.xtext.resource.IResourceDescriptions;

import com.google.inject.Injector;
import com.google.inject.PrivateModule;

import eu.numberfour.n4js.ui.internal.ContributingResourceDescriptionPersister;

/**
 * {@link IResourceDescriptions Resource descriptions} (Xtext index) persister contribution that are invoked from the
 * {@link ContributingResourceDescriptionPersister N4JS index persister}.
 */
public interface IResourceDescriptionPersisterContribution {

	/**
	 * Unique ID of the extension point.
	 */
	String EXTENSION_POINT_ID = "eu.numberfour.n4js.ui.resourceDescriptionsPersisterContribution";

	/**
	 * The {@link IConfigurationElement configuration element} property name that will be used to instantiate the
	 * concrete implementation.
	 */
	String CLAZZ_PROPERTY_NAME = "class";

	/**
	 * Called before the base persisted state provider service (registered to the builder state) schedules a recovery
	 * build in case of missing or corrupted {@link IResourceDescriptions resource descriptions} (Xtext index).
	 */
	void scheduleRecoveryBuild();

	/**
	 * Returns with the injector instance for the persister contribution.
	 *
	 * <p>
	 * Providing the {@link Injector injector} is necessary to workaround the {@link PrivateModule private module}
	 * issues in the Xtext shared module. Basically due to the visibility issues in the overriding module no application
	 * specific instances can be injected without having the proper injector instance.
	 *
	 * @return the injector to initialize the current persister contribution.
	 */
	Injector getInjector();

}
