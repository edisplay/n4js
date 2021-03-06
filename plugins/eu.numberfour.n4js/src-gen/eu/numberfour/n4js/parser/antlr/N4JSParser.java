/*
 * generated by Xtext 2.10.0
 */
package eu.numberfour.n4js.parser.antlr;

import com.google.inject.Inject;
import eu.numberfour.n4js.parser.antlr.internal.InternalN4JSParser;
import eu.numberfour.n4js.services.N4JSGrammarAccess;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;

public class N4JSParser extends AbstractAntlrParser {

	@Inject
	private N4JSGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_EOL");
	}
	

	@Override
	protected InternalN4JSParser createParser(XtextTokenStream stream) {
		return new InternalN4JSParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "Script";
	}

	public N4JSGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(N4JSGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
