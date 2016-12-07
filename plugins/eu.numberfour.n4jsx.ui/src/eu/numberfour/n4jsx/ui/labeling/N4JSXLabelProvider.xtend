/*
 * generated by Xtext
 */
package eu.numberfour.n4jsx.ui.labeling

import com.google.inject.Inject
import eu.numberfour.n4js.ui.labeling.N4JSLabelProvider
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider

/**
 * Provides labels for EObjects.
 *
 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#label-provider
 */
class N4JSXLabelProvider extends N4JSLabelProvider {

	@Inject
	new(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}
}