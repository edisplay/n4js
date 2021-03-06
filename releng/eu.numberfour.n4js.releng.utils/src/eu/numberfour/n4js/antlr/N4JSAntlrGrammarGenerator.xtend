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
package eu.numberfour.n4js.antlr

import com.google.common.base.Charsets
import com.google.common.io.Files
import com.google.inject.Inject
import eu.numberfour.n4js.antlr.CodeIntoGrammarInjector
import eu.numberfour.n4js.antlr.UnicodeKeywordHelper
import eu.numberfour.n4js.antlr.n4js.AutomaticSemicolonInjector
import eu.numberfour.n4js.antlr.n4js.NoLineTerminatorHandlingInjector
import eu.numberfour.n4js.antlr.n4js.RegExDisambiguationInjector
import eu.numberfour.n4js.antlr.n4js.TemplateLiteralDisambiguationInjector
import java.io.File
import java.io.IOException
import java.util.List
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammarGenerator
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrOptions

/**
 * Customized production ANTLR grammar generator.
 */
class N4JSAntlrGrammarGenerator extends AntlrGrammarGenerator {
	
	@Inject
	AutomaticSemicolonInjector semicolonInjector
	
	@Inject
	RegExDisambiguationInjector regExDisambiguationInjector
	
	@Inject
	TemplateLiteralDisambiguationInjector templateLiteralDisambiguationInjector
	
	@Inject
	NoLineTerminatorHandlingInjector noLineTerminatorHandlingInjector
	
	List<CodeIntoGrammarInjector> steps
	
	@Inject
	def initialize() {
		steps = #[
			semicolonInjector,
			regExDisambiguationInjector,
			templateLiteralDisambiguationInjector,
			noLineTerminatorHandlingInjector
		]
	}
		
	/**
	 * Replace specified extensions with custom implementation for unicode keyword lexer rules
	 */
	override protected toAntlrKeywordRule(String keyword, AntlrOptions options) {
		UnicodeKeywordHelper.toUnicodeKeyword(keyword)
	}
		
	override generate(Grammar it, AntlrOptions options, IXtextGeneratorFileSystemAccess fsa) {
		super.generate(it, options, fsa)
		injectCode(fsa)
	}
	
	def public void injectCode(Grammar it, IXtextGeneratorFileSystemAccess fsa) {
		val outletPath = fsa.path + '/'
		val lexerGrammarFileName = outletPath + grammarNaming.getLexerGrammar(it).grammarFileName
		val parserGrammarFileName = outletPath + grammarNaming.getParserGrammar(it).grammarFileName
		injectCode(lexerGrammarFileName, parserGrammarFileName)
	}
	
	def public void injectCode(String lexerGrammarFileName, String parserGrammarFileName) {
		if (lexerGrammarFileName !== null) {
			try {
				var String lexerGrammarContent = Files.toString(new File(lexerGrammarFileName), Charsets.UTF_8);
				lexerGrammarContent = processLexerGrammar(lexerGrammarContent);
				Files.write(lexerGrammarContent, new File(lexerGrammarFileName), Charsets.UTF_8);
			} catch (IOException e) {
				throw new RuntimeException();
			}
		}

		if (parserGrammarFileName !== null) {
			try {
				var String parserGrammarContent = Files.toString(new File(parserGrammarFileName), Charsets.UTF_8);
				parserGrammarContent = processParserGrammar(parserGrammarContent);
				Files.write(parserGrammarContent, new File(parserGrammarFileName), Charsets.UTF_8);
			} catch (IOException e) {
				throw new RuntimeException();
			}
		}
	}

	def private String processParserGrammar(String grammarContent) {
		var String result = grammarContent;
		for (CodeIntoGrammarInjector step : steps) {
			result = step.processParserGrammar(result);
		}
		return result;
	}

	def private String processLexerGrammar(String grammarContent) {
		var String result = grammarContent;
		for (CodeIntoGrammarInjector step : steps) {
			result = step.processLexerGrammar(result);
		}
		return result;
	}
}
