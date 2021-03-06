package eu.numberfour.n4jsx.ui.contentassist;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ILeafNode;

import com.google.common.collect.Maps;
import com.google.inject.Singleton;

import eu.numberfour.n4jsx.ui.contentassist.antlr.internal.InternalN4JSXParser;

/**
 * Converts the grammar elements from a leaf node to the CA parsers expected token type.
 *
 * It usually uses the associated grammar element of the leaf node to determine the token type. For error tokens, the
 * text is assumed to be a keyword and therefore the token type is deduced from that value. This happens if a keyword
 * occurs multiple times in the grammar (e.g. the keyword {@code '.'}) but the parse did not decide which path to in
 * case of multiple alternatives combined with broken input.
 */
// copied form eu.numberfour.n4js.ui.contentassist.ContentAssistTokenTypeMapper
@Singleton
public class ContentAssistTokenTypeMapper {

	private final Map<String, Integer> tokenTypes = Maps.newHashMap();
	private final Map<EObject, Integer> grammarElements = Maps.newHashMap();

	/**
	 * Default constructor.
	 */
	public ContentAssistTokenTypeMapper() {
		Map<Integer, String> tokenDefMap = new InternalN4JSXParser(null).getTokenDefMap();
		for (Map.Entry<Integer, String> entry : tokenDefMap.entrySet()) {
			if (tokenTypes.put(entry.getValue(), entry.getKey()) != null) {
				throw new IllegalStateException(String.valueOf(tokenDefMap));
			}
		}
	}

	/**
	 * Converts a leaf node an Antlr token type (int).
	 */
	public int getInternalTokenType(ILeafNode leafNode) {
		EObject grammarElement = leafNode.getGrammarElement();
		if (grammarElement != null) {
			return getInternalTokenType(grammarElement);
		}
		String text = leafNode.getText();
		Integer type = tokenTypes.get("'" + text + "'");
		if (type != null) {
			return type;
		}
		throw new IllegalArgumentException(text);
	}

	/**
	 * Converts a grammar element to an Antlr token type (int).
	 */
	public int getInternalTokenType(EObject grammarElement) {
		Integer type = grammarElements.get(grammarElement);
		if (type == null) {
			if (grammarElement instanceof Keyword) {
				String keyword = ((Keyword) grammarElement).getValue();
				type = tokenTypes.get("'" + keyword + "'");
			} else if (grammarElement instanceof RuleCall) {
				AbstractRule rule = ((RuleCall) grammarElement).getRule();
				type = tokenTypes.get("RULE_" + rule.getName().toUpperCase());
			} else if (grammarElement instanceof AbstractRule) {
				AbstractRule rule = (AbstractRule) grammarElement;
				type = tokenTypes.get("RULE_" + rule.getName().toUpperCase());
			} else if (grammarElement instanceof EnumLiteralDeclaration) {
				String keyword = ((EnumLiteralDeclaration) grammarElement).getLiteral().getValue();
				type = tokenTypes.get("'" + keyword + "'");
			} else if (grammarElement instanceof CrossReference) {
				type = getInternalTokenType(((CrossReference) grammarElement).getTerminal());
			} else {
				throw new IllegalArgumentException(String.valueOf(grammarElement));
			}
			grammarElements.put(grammarElement, type);
		}
		return type;
	}

}
