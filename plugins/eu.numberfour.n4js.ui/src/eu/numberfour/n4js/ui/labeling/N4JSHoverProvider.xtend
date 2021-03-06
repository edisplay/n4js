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
package eu.numberfour.n4js.ui.labeling

import com.google.inject.Inject
import eu.numberfour.n4js.n4JS.ExportedVariableDeclaration
import eu.numberfour.n4js.n4JS.FormalParameter
import eu.numberfour.n4js.n4JS.FunctionExpression
import eu.numberfour.n4js.n4JS.PropertyNameValuePair
import eu.numberfour.n4js.n4JS.VariableDeclaration
import eu.numberfour.n4js.ts.types.TypableElement
import eu.numberfour.n4js.ts.ui.labeling.TypesHoverProvider
import eu.numberfour.n4js.typesystem.N4JSTypeSystem
import eu.numberfour.n4js.validation.N4JSElementKeywordProvider
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider

import static eu.numberfour.n4js.ts.ui.labeling.TypesHoverProvider.composeFirstLine
import static eu.numberfour.n4js.utils.UtilN4.sanitizeForHTML

import static extension eu.numberfour.n4js.n4JS.N4JSASTUtils.getCorrespondingTypeModelElement
import static extension eu.numberfour.n4js.typesystem.RuleEnvironmentExtensions.newRuleEnvironment

/**
 */
class N4JSHoverProvider extends DefaultEObjectHoverProvider {

	@Inject
	private extension N4JSTypeSystem;

	@Inject
	private extension N4JSElementKeywordProvider;

	@Inject
	private TypesHoverProvider typesHoverProvider;

	@Override
	override protected getFirstLine(EObject o) {
		return composeFirstLine(o.keyword, o.label);
	}

	@Override
	override protected getLabel(EObject o) {
		sanitizeForHTML(doGetLabel(o));
	}

	def private dispatch doGetLabel(EObject o) {
		val tElem = o.getCorrespondingTypeModelElement;
		return if (null === tElem) super.getLabel(o) else typesHoverProvider.getLabel(tElem);
	}

	def private dispatch doGetLabel(VariableDeclaration vd) {
		if (vd instanceof ExportedVariableDeclaration) _doGetLabel(vd as EObject) else vd.labelFromTypeSystem;
	}

	def private dispatch doGetLabel(PropertyNameValuePair nameValuePair) {
		nameValuePair.labelFromTypeSystem;
	}

	def private dispatch doGetLabel(FormalParameter fp) {
		val String optinonalMarker = if (fp.hasInitializerAssignment) "=…" else "";
		fp.labelFromTypeSystem + optinonalMarker;
	}

	def private dispatch doGetLabel(FunctionExpression fe) {
		fe.labelFromTypeSystem;
	}

	def private getLabelFromTypeSystem(TypableElement o) {
		if (null ===  o || null === o.eResource) {
			return null;
		}
		val typeRef = o.newRuleEnvironment.type(o).value;
		return if (null === typeRef) null else '''«getName(o)»: «typeRef.typeRefAsString»''';
	}

	def private dispatch getName(EObject o) {
		'';
	}

	def private dispatch getName(VariableDeclaration vd) {
		''' «vd.name»''';
	}

	def private dispatch getName(PropertyNameValuePair nameValuePair) {
		''' «nameValuePair.name»''';
	}

	def private dispatch getName(FormalParameter fp) {
		''' «fp.name»''';
	}

	def private dispatch getName(FunctionExpression fe) {
		''' «fe.name»''';
	}

	@Override
	override protected hasHover(EObject o) {
		doHasHover(o);
	}

	def private dispatch doHasHover(EObject o) {
		val tElem = o.getCorrespondingTypeModelElement;
		return if (null === tElem) super.hasHover(o) else typesHoverProvider.hasHover(tElem);
	}

	def private dispatch doHasHover(VariableDeclaration vd) {
		true;
	}

	def private dispatch doHasHover(PropertyNameValuePair nameValuePair) {
		true;
	}

	def private dispatch doHasHover(FormalParameter fp) {
		true;
	}

	def private dispatch doHasHover(FunctionExpression fe) {
		true;
	}

//
// the following code can be used to show images in hovers
// (but is not used yet because this would also be required in
// TypesHoverProvider, but no access to the images from that class/bundle!)
//

// private String getImageTag(EObject obj) {
// final URL url = getImageURL(obj);
// if (url != null)
// return "<image align='middle' src=\"" + url.toExternalForm() + "\"/>";
// return null;
// }
//
// @Inject
// private ImageFileNameCalculationHelper h;
//
// private URL getImageURL(EObject obj) {
// final String fn = h.getImageFileName(obj);
// if (fn != null) {
// final URL url = FileLocator.find(N4JSActivator.getInstance().getBundle(), new Path("icons/" + fn), null);
// if (url != null) {
// try {
// return FileLocator.toFileURL(url);
// } catch (IOException e) {
// //
// }
// }
// }
// return null;
// }

}
