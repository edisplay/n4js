/*
 * generated by Xtext 2.10.0
 */
package eu.numberfour.n4js.n4mf.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class N4MFAntlrTokenFileProvider implements IAntlrTokenFileProvider {

	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream("eu/numberfour/n4js/n4mf/parser/antlr/internal/InternalN4MFParser.tokens");
	}
}
