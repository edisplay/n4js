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
package eu.numberfour.n4js.validation

import com.google.common.collect.Sets
import com.google.inject.Inject
import eu.numberfour.n4js.n4JS.AbstractCaseClause
import eu.numberfour.n4js.n4JS.ArrayElement
import eu.numberfour.n4js.n4JS.ArrayLiteral
import eu.numberfour.n4js.n4JS.AssignmentExpression
import eu.numberfour.n4js.n4JS.AssignmentOperator
import eu.numberfour.n4js.n4JS.BindingElement
import eu.numberfour.n4js.n4JS.BindingPattern
import eu.numberfour.n4js.n4JS.Block
import eu.numberfour.n4js.n4JS.BreakStatement
import eu.numberfour.n4js.n4JS.CatchBlock
import eu.numberfour.n4js.n4JS.ContinueStatement
import eu.numberfour.n4js.n4JS.ExportDeclaration
import eu.numberfour.n4js.n4JS.Expression
import eu.numberfour.n4js.n4JS.ExpressionStatement
import eu.numberfour.n4js.n4JS.FieldAccessor
import eu.numberfour.n4js.n4JS.ForStatement
import eu.numberfour.n4js.n4JS.FormalParameter
import eu.numberfour.n4js.n4JS.FunctionDeclaration
import eu.numberfour.n4js.n4JS.FunctionDefinition
import eu.numberfour.n4js.n4JS.FunctionExpression
import eu.numberfour.n4js.n4JS.IdentifierRef
import eu.numberfour.n4js.n4JS.IfStatement
import eu.numberfour.n4js.n4JS.IndexedAccessExpression
import eu.numberfour.n4js.n4JS.IterationStatement
import eu.numberfour.n4js.n4JS.LabelledStatement
import eu.numberfour.n4js.n4JS.LegacyOctalIntLiteral
import eu.numberfour.n4js.n4JS.LocalArgumentsVariable
import eu.numberfour.n4js.n4JS.MethodDeclaration
import eu.numberfour.n4js.n4JS.N4ClassDefinition
import eu.numberfour.n4js.n4JS.N4ClassifierDeclaration
import eu.numberfour.n4js.n4JS.N4ClassifierDefinition
import eu.numberfour.n4js.n4JS.N4EnumDeclaration
import eu.numberfour.n4js.n4JS.N4FieldAccessor
import eu.numberfour.n4js.n4JS.N4InterfaceDeclaration
import eu.numberfour.n4js.n4JS.N4JSASTUtils
import eu.numberfour.n4js.n4JS.N4JSPackage
import eu.numberfour.n4js.n4JS.N4MethodDeclaration
import eu.numberfour.n4js.n4JS.N4SetterDeclaration
import eu.numberfour.n4js.n4JS.NewTarget
import eu.numberfour.n4js.n4JS.ObjectLiteral
import eu.numberfour.n4js.n4JS.ParameterizedCallExpression
import eu.numberfour.n4js.n4JS.ParameterizedPropertyAccessExpression
import eu.numberfour.n4js.n4JS.PostfixExpression
import eu.numberfour.n4js.n4JS.PostfixOperator
import eu.numberfour.n4js.n4JS.PropertyAssignment
import eu.numberfour.n4js.n4JS.PropertyMethodDeclaration
import eu.numberfour.n4js.n4JS.PropertyNameOwner
import eu.numberfour.n4js.n4JS.PropertyNameValuePair
import eu.numberfour.n4js.n4JS.PropertyNameValuePairSingleName
import eu.numberfour.n4js.n4JS.ReturnStatement
import eu.numberfour.n4js.n4JS.Script
import eu.numberfour.n4js.n4JS.Statement
import eu.numberfour.n4js.n4JS.StrictModeRelevant
import eu.numberfour.n4js.n4JS.StringLiteral
import eu.numberfour.n4js.n4JS.SuperLiteral
import eu.numberfour.n4js.n4JS.UnaryExpression
import eu.numberfour.n4js.n4JS.UnaryOperator
import eu.numberfour.n4js.n4JS.Variable
import eu.numberfour.n4js.n4JS.VariableDeclaration
import eu.numberfour.n4js.n4JS.VariableStatement
import eu.numberfour.n4js.n4JS.VariableStatementKeyword
import eu.numberfour.n4js.n4JS.WithStatement
import eu.numberfour.n4js.n4JS.YieldExpression
import eu.numberfour.n4js.parser.InternalSemicolonInjectingParser
import eu.numberfour.n4js.projectModel.IN4JSCore
import eu.numberfour.n4js.services.N4JSGrammarAccess
import eu.numberfour.n4js.validation.helper.N4JSLanguageConstants
import eu.numberfour.n4js.ts.typeRefs.ClassifierTypeRef
import eu.numberfour.n4js.ts.typeRefs.ConstructorTypeRef
import eu.numberfour.n4js.ts.typeRefs.FunctionTypeExpression
import eu.numberfour.n4js.ts.typeRefs.ParameterizedTypeRef
import eu.numberfour.n4js.ts.typeRefs.ThisTypeRef
import eu.numberfour.n4js.ts.typeRefs.Wildcard
import eu.numberfour.n4js.ts.types.TypesPackage
import java.util.Set
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.xtend.lib.annotations.ToString
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.diagnostics.DiagnosticMessage
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.nodemodel.util.NodeModelUtils

import static extension eu.numberfour.n4js.conversion.AbstractN4JSStringValueConverter.*
import static extension eu.numberfour.n4js.n4JS.N4JSASTUtils.isDestructuringAssignment
import static extension eu.numberfour.n4js.n4JS.N4JSASTUtils.isDestructuringForStatement

/**
 * A utility that validates the structure of the AST in one pass.
 */
class ASTStructureValidator {

	@Inject
	private IN4JSCore n4jsCore;

	@Inject
	private N4JSGrammarAccess grammarAccess;

	@Inject
	private ValidatorMessageHelper messageHelper;
	@ToString
	protected static class Constraints {
		static val STRICT = 1
		static val N4JS = STRICT << 1
		static val EXTERNAL = N4JS << 1
		static val ALLOW_NESTED_FUNCTION_DECLARATION = EXTERNAL << 1
		static val ALLOW_RETURN = ALLOW_NESTED_FUNCTION_DECLARATION << 1
		static val ALLOW_CONTINUE = ALLOW_RETURN << 1
		static val ALLOW_BREAK = ALLOW_CONTINUE << 1
		static val ALLOW_VAR_WITHOUT_INITIALIZER = ALLOW_BREAK << 1
		static val ALLOW_YIELD_EXPRESSION = ALLOW_VAR_WITHOUT_INITIALIZER << 1
		static val ALLOW_SUPER = ALLOW_YIELD_EXPRESSION << 1
		static val ALLOW_SUPER_CALL = ALLOW_SUPER << 1
		static val IN_FUNCTION_DECLARATION = ALLOW_SUPER_CALL << 1

		val int bits

		def private static getIf(int value, boolean b) {
			if (b) value else 0
		}

		new(boolean n4js, boolean external) {
			this(N4JS.getIf(n4js).bitwiseOr(EXTERNAL.getIf(external)).bitwiseOr(ALLOW_VAR_WITHOUT_INITIALIZER).bitwiseOr(ALLOW_YIELD_EXPRESSION))
		}

		new(int bits) {
			this.bits = bits
		}

		private def is(int bit) {
			return this.bits.bitwiseAnd(bit) !== 0
		}

		def boolean isN4JS() {
			return is(N4JS)
		}

		def boolean isStrict() {
			return is(N4JS) || is(STRICT)
		}

		def boolean isExternal() {
			return is(EXTERNAL)
		}

		def boolean isNestedFunctionAllowed() {
			return is(ALLOW_NESTED_FUNCTION_DECLARATION)
		}

		def boolean isInFunctionDeclaration() {
			return is(IN_FUNCTION_DECLARATION)
		}

		def boolean isReturnAllowed() {
			return is(ALLOW_RETURN)
		}

		def boolean isBreakAllowed() {
			return is(ALLOW_BREAK)
		}

		def boolean isContinueAllowed() {
			return is(ALLOW_CONTINUE)
		}

		def boolean isVarInitializerRequired() {
			return !is(ALLOW_VAR_WITHOUT_INITIALIZER)
		}

		def boolean isYieldExpressionAllowed() {
			return is(ALLOW_YIELD_EXPRESSION)
		}

		def boolean isSuperLiteralAllowed() {
			return is(ALLOW_SUPER)
		}

		def boolean isSuperCallAllowed() {
			return is(ALLOW_SUPER_CALL)
		}

		def Constraints with(int bit, boolean set) {
			val newBits = if (set) {
				this.bits.bitwiseOr(bit)
			} else {
				this.bits.bitwiseAnd(bit.bitwiseNot)
			}
			if (newBits === this.bits) {
				return this
			}
			return new Constraints(newBits)
		}

		def Constraints strict(boolean strict) {
			with(STRICT, strict)
		}

		def Constraints allowNestedFunctions(boolean allow) {
			with(ALLOW_NESTED_FUNCTION_DECLARATION, allow)
		}

		def Constraints allowBreak(boolean allow) {
			with(ALLOW_BREAK, allow)
		}

		def Constraints allowContinue(boolean allow) {
			with(ALLOW_CONTINUE, allow)
		}

		def Constraints allowReturn(boolean allow) {
			with(ALLOW_RETURN, allow)
		}

		def Constraints allowVarWithoutInitializer(boolean allow) {
			with(ALLOW_VAR_WITHOUT_INITIALIZER, allow)
		}

		def Constraints allowYieldExpression(boolean allow) {
			with(ALLOW_YIELD_EXPRESSION, allow)
		}

		def Constraints allowSuperLiteral(boolean allow) {
			if (!allow) {
				allowSuperCall(false).with(ALLOW_SUPER, allow)
			} else {
				with(ALLOW_SUPER, allow)
			}
		}

		def Constraints allowSuperCall(boolean allow) {
			with(ALLOW_SUPER_CALL, allow)
		}

		def Constraints enterFunctionDeclaration() {
			with(IN_FUNCTION_DECLARATION, true)
		}
	}

	def void validate(EObject model, IDiagnosticConsumer consumer) {
		if(model?.eResource !== null && !n4jsCore.isNoValidate(model.eResource.getURI())) {
			val producer = new ASTStructureDiagnosticProducer(consumer);
			validateASTStructure(model, producer, Sets.newHashSetWithExpectedSize(2),
				new Constraints(JavaScriptVariant.n4js.isActive(model), JavaScriptVariant.external.isActive(model))
			);
		}
	}

	def protected void recursiveValidateASTStructure(
		EObject model,
		ASTStructureDiagnosticProducer producer,
		Set<LabelledStatement> validLabels,
		Constraints constraints
	) {
		val content = model.eContents.iterator
		var newStrict = constraints.isStrict
		var first = true
		while (content.hasNext()) {
			val next = content.next();

			// TODO this looks wrong: "strict mode" must be defined as first statement only!
			// see IDE-163, also see JavaScriptVariant
			// SZ: "use strict" must not be the first entry in the prolog, see test/language/directive-prologue/14.1-5gs.js
			newStrict = newStrict || (first && isUseStrictProlog(model, next))
			first = first && isProlog(next)
			if (next instanceof StrictModeRelevant) {
				next.setStrictMode(newStrict)
			}
			validateASTStructure(
				next,
				producer,
				validLabels,
				constraints.strict(newStrict)
			)
		}
	}

	private def isProlog(EObject object) {
		if (object instanceof ExpressionStatement) {
			return object.expression instanceof StringLiteral
		}
		return false
	}

	def protected isUseStrictProlog(EObject model, EObject next) {
		if (model instanceof Script || model instanceof Block && model.eContainer instanceof FunctionDefinition) {
			switch (next) {
				ExpressionStatement: {
					switch it: next.expression {
						StringLiteral: {

							// TODO may this be defined everywhere?
							return "use strict" == value
						}
					}
				}
			}
		}
		return false
	}

	def dispatch void validateASTStructure(
		Script model,
		ASTStructureDiagnosticProducer producer,
		Set<LabelledStatement> validLabels,
		Constraints constraints
	) {
		recursiveValidateASTStructure(
			model,
			producer,
			validLabels,
			constraints.strict(false).allowNestedFunctions(true).allowReturn(false).allowContinue(false).allowBreak(false)
		);
	}

	def dispatch void validateASTStructure(
		N4ClassifierDefinition model,
		ASTStructureDiagnosticProducer producer,
		Set<LabelledStatement> validLabels,
		Constraints constraints
	) {
		if (model instanceof N4ClassifierDeclaration) {
			if(model.name===null && !model.isExportedAsDefault) {
				val target = NodeModelUtils.findActualNodeFor(model)
				producer.node = target
				producer.addDiagnostic(
					new DiagnosticMessage(IssueCodes.messageForAST_TYPE_DECL_MISSING_NAME,
						IssueCodes.getDefaultSeverity(IssueCodes.AST_TYPE_DECL_MISSING_NAME), IssueCodes.AST_TYPE_DECL_MISSING_NAME))
			}
		}

		recursiveValidateASTStructure(
			model,
			producer,
			validLabels,
			// according to ecma6 spec, class bodies are always strict
			constraints.strict(true).allowNestedFunctions(true).allowReturn(false).allowContinue(false).allowBreak(false)
		)
	}

	def dispatch void validateASTStructure(
		N4EnumDeclaration model,
		ASTStructureDiagnosticProducer producer,
		Set<LabelledStatement> validLabels,
		Constraints constraints
	) {
		if(model.name===null && !model.isExportedAsDefault) {
			val target = NodeModelUtils.findActualNodeFor(model)
			producer.node = target
			producer.addDiagnostic(
				new DiagnosticMessage(IssueCodes.messageForAST_TYPE_DECL_MISSING_NAME,
					IssueCodes.getDefaultSeverity(IssueCodes.AST_TYPE_DECL_MISSING_NAME), IssueCodes.AST_TYPE_DECL_MISSING_NAME))
		}

		if (model.literals.isEmpty) {
			val target = NodeModelUtils.findActualNodeFor(model)
			producer.node = target
			producer.addDiagnostic(
				new DiagnosticMessage(IssueCodes.messageForENM_WITHOUT_LITERALS,
					IssueCodes.getDefaultSeverity(IssueCodes.ENM_WITHOUT_LITERALS), IssueCodes.ENM_WITHOUT_LITERALS))
		}
		recursiveValidateASTStructure(
			model,
			producer,
			validLabels,
			// according to ecma6 spec, class bodies are always strict
			constraints.strict(true).allowNestedFunctions(true).allowReturn(false).allowContinue(false).allowBreak(false)
		)
	}

	def dispatch void validateASTStructure(
		EObject model,
		ASTStructureDiagnosticProducer producer,
		Set<LabelledStatement> validLabels,
		Constraints constraints
	) {
		recursiveValidateASTStructure(
			model,
			producer,
			validLabels,
			constraints
		)
	}

	def dispatch void validateASTStructure(
		LegacyOctalIntLiteral model,
		ASTStructureDiagnosticProducer producer,
		Set<LabelledStatement> validLabels,
		Constraints constraints
	) {
		if (constraints.isStrict) {
			val target = NodeModelUtils.findActualNodeFor(model)
			producer.node = target
			producer.addDiagnostic(
				new DiagnosticMessage(IssueCodes.messageForAST_STR_NO_OCTALS,
					IssueCodes.getDefaultSeverity(IssueCodes.AST_STR_NO_OCTALS), IssueCodes.AST_STR_NO_OCTALS))
		}
		recursiveValidateASTStructure(
			model,
			producer,
			validLabels,
			constraints
		)
	}

	def dispatch void validateASTStructure(
		StringLiteral model,
		ASTStructureDiagnosticProducer producer,
		Set<LabelledStatement> validLabels,
		Constraints constraints
	) {
		if (constraints.isStrict) {
			val nodes = NodeModelUtils.findNodesForFeature(model, N4JSPackage.Literals.STRING_LITERAL__VALUE)
			val target = nodes.head
			val syntaxError = target.syntaxErrorMessage
			if ((syntaxError === null || syntaxError.issueCode == WARN_ISSUE_CODE || syntaxError.issueCode == InternalSemicolonInjectingParser.SEMICOLON_INSERTED) && target.text.hasOctalEscapeSequence) {
				producer.node = target
				producer.addDiagnostic(
					new DiagnosticMessage(IssueCodes.messageForAST_STR_NO_OCTALS,
						IssueCodes.getDefaultSeverity(IssueCodes.AST_STR_NO_OCTALS), IssueCodes.AST_STR_NO_OCTALS))
			}
		}
		recursiveValidateASTStructure(
			model,
			producer,
			validLabels,
			constraints
		)
	}

	def dispatch void validateASTStructure(
		PostfixExpression model,
		ASTStructureDiagnosticProducer producer,
		Set<LabelledStatement> validLabels,
		Constraints constraints
	) {
		recursiveValidateASTStructure(
			model,
			producer,
			validLabels,
			constraints
		)
		val child = model.expression
		if (!child.isValidSimpleAssignmentTarget) {
			val nodes = NodeModelUtils.findNodesForFeature(model, N4JSPackage.Literals.POSTFIX_EXPRESSION__EXPRESSION)
			val target = nodes.head
			producer.node = target
			val operand = if (model.op == PostfixOperator.DEC) 'decrement' else 'increment'
			producer.addDiagnostic(
				new DiagnosticMessage(IssueCodes.getMessageForAST_INVALID_OPERAND(operand),
					IssueCodes.getDefaultSeverity(IssueCodes.AST_INVALID_OPERAND), IssueCodes.AST_INVALID_OPERAND))
		}
	}

	def dispatch void validateASTStructure(
		UnaryExpression model,
		ASTStructureDiagnosticProducer producer,
		Set<LabelledStatement> validLabels,
		Constraints constraints
	) {
		recursiveValidateASTStructure(
			model,
			producer,
			validLabels,
			constraints
		)
		if (model.op == UnaryOperator.DEC || model.op == UnaryOperator.INC) {
			val child = model.expression
			if (child!==null && !child.isValidSimpleAssignmentTarget) {
				val nodes = NodeModelUtils.findNodesForFeature(model,
					N4JSPackage.Literals.POSTFIX_EXPRESSION__EXPRESSION)
				val target = nodes.head
				producer.node = target
				val operand = if (model.op == UnaryOperator.DEC) 'decrement' else 'increment'
				producer.addDiagnostic(
					new DiagnosticMessage(IssueCodes.getMessageForAST_INVALID_OPERAND(operand),
						IssueCodes.getDefaultSeverity(IssueCodes.AST_INVALID_OPERAND), IssueCodes.AST_INVALID_OPERAND))
			}
		}
	}

	def dispatch void validateASTStructure(
		YieldExpression model,
		ASTStructureDiagnosticProducer producer,
		Set<LabelledStatement> validLabels,
		Constraints constraints
	) {
		if (!constraints.isYieldExpressionAllowed) {
			val target = NodeModelUtils.findActualNodeFor(model)
			producer.node = target
			producer.addDiagnostic(
				new DiagnosticMessage(IssueCodes.messageForAST_INVALID_YIELD_EXPRESSION,
					IssueCodes.getDefaultSeverity(IssueCodes.AST_INVALID_YIELD_EXPRESSION), IssueCodes.AST_INVALID_YIELD_EXPRESSION))
		}
		recursiveValidateASTStructure(
			model,
			producer,
			validLabels,
			constraints
		)
	}

	def dispatch void validateASTStructure(
		AssignmentExpression model,
		ASTStructureDiagnosticProducer producer,
		Set<LabelledStatement> validLabels,
		Constraints constraints
	) {
		// first validate the children to make sure strictMode flag was set
		recursiveValidateASTStructure(
			model,
			producer,
			validLabels,
			constraints
		)
		val lhs = model.lhs
		if (lhs !== null && !lhs.isValidSimpleAssignmentTarget) {
			if (model.op !== AssignmentOperator.ASSIGN || !model.isDestructuringAssignment) {
				val nodes = NodeModelUtils.findNodesForFeature(model, N4JSPackage.Literals.ASSIGNMENT_EXPRESSION__LHS)
				val target = nodes.head
				producer.node = target
				producer.addDiagnostic(
					new DiagnosticMessage(IssueCodes.getMessageForAST_EXP_INVALID_LHS_ASS,
						IssueCodes.getDefaultSeverity(IssueCodes.AST_EXP_INVALID_LHS_ASS),
						IssueCodes.AST_EXP_INVALID_LHS_ASS))
			}
		}
	}

	static val reservedWordInStrictMode = newImmutableSet(
		// implements, interface, let, package, private, protected, public, static
		'implements',
		'interface',
		'let',
		'package',
		'private',
		'protected',
		'public',
		'static',
		'yield'
	)

	static val arguments = 'arguments'
	static val eval = 'eval'

	def dispatch void validateASTStructure(
		IdentifierRef model,
		ASTStructureDiagnosticProducer producer,
		Set<LabelledStatement> validLabels,
		Constraints constraints
	) {
		val name = model.idAsText
		if (name !== null) {
			if (constraints.isStrict && (reservedWordInStrictMode.contains(name))) {
				issueNameDiagnostic(model, producer, name, N4JSPackage.Literals.IDENTIFIER_REF__ID, Severity.ERROR)
			}
		}
		recursiveValidateASTStructure(
			model,
			producer,
			validLabels,
			constraints
		)
	}

	def dispatch void validateASTStructure(
		Variable model,
		ASTStructureDiagnosticProducer producer,
		Set<LabelledStatement> validLabels,
		Constraints constraints
	) {
		val name = model.name
		if (name !== null) {
			if (arguments == name && !(model instanceof LocalArgumentsVariable)) {
				issueArgumentsError(model, name, constraints.isStrict, producer)
			} else {
				if (name != 'yield' && (N4JSLanguageConstants.KEYWORDS.contains(name)
					|| 'enum'.equals(name) || 'await'.equals(name) || 'let'.equals(name)
					|| 'true'.equals(name) || 'false'.equals(name) || 'null'.equals(name))) {
					issueNameDiagnostic(model, producer, name)
				} else if (constraints.isStrict) {
					if (reservedWordInStrictMode.contains(name) || eval == name) {
						issueNameDiagnostic(model, producer, name)
					}
				}
			}
		}
		recursiveValidateASTStructure(
			model,
			producer,
			validLabels,
			constraints
		)
	}

	def dispatch void validateASTStructure(
		WithStatement model,
		ASTStructureDiagnosticProducer producer,
		Set<LabelledStatement> validLabels,
		Constraints constraints
	) {
		if (constraints.isStrict) {
			val node = NodeModelUtils.findActualNodeFor(model).leafNodes.findFirst[ grammarElement == grammarAccess.withStatementAccess.withKeyword_0 ]
			producer.node = node
			if(node !== null) {
				producer.addDiagnostic(
					new DiagnosticMessage(IssueCodes.messageForAST_STR_NO_WITH_STMT,
						IssueCodes.getDefaultSeverity(IssueCodes.AST_STR_NO_WITH_STMT),
						IssueCodes.AST_STR_NO_WITH_STMT))
			}
		}
		recursiveValidateASTStructure(
			model,
			producer,
			validLabels,
			constraints
		)
	}

	def dispatch void validateASTStructure(
		LabelledStatement model,
		ASTStructureDiagnosticProducer producer,
		Set<LabelledStatement> validLabels,
		Constraints constraints
	) {
		val name = model.name
		if (name !== null) {
			if (constraints.isStrict && (reservedWordInStrictMode.contains(name))) {
				issueNameDiagnostic(model, producer, name)
			}
		}
		try {
			validLabels.add(model)
			recursiveValidateASTStructure(
				model,
				producer,
				validLabels,
				constraints.allowNestedFunctions(!constraints.isStrict).allowBreak(true)
			)
		} finally {
			validLabels.remove(model)
		}
	}

	def dispatch void validateASTStructure(
		Block model,
		ASTStructureDiagnosticProducer producer,
		Set<LabelledStatement> validLabels,
		Constraints constraints
	) {
		validateBlockStructure(
			model.eContainer,
			model,
			producer,
			validLabels,
			constraints
		)
	}

	def dispatch void validateBlockStructure(
		IfStatement container,
		Block model,
		ASTStructureDiagnosticProducer producer,
		Set<LabelledStatement> validLabels,
		Constraints constraints
	) {
		recursiveValidateASTStructure(
			model,
			producer,
			validLabels,
			constraints
		)
	}

	def dispatch void validateBlockStructure(
		IterationStatement container,
		Block model,
		ASTStructureDiagnosticProducer producer,
		Set<LabelledStatement> validLabels,
		Constraints constraints
	) {
		recursiveValidateASTStructure(
			model,
			producer,
			validLabels,
			constraints.allowNestedFunctions(!constraints.isStrict && !constraints.isInFunctionDeclaration)
		)
	}

	def dispatch void validateBlockStructure(
		FunctionDefinition container,
		Block model,
		ASTStructureDiagnosticProducer producer,
		Set<LabelledStatement> validLabels,
		Constraints constraints
	) {
		recursiveValidateASTStructure(
			model,
			producer,
			validLabels,
			constraints.allowNestedFunctions(true)
		)
	}

	def dispatch void validateBlockStructure(
		CatchBlock container,
		Block model,
		ASTStructureDiagnosticProducer producer,
		Set<LabelledStatement> validLabels,
		Constraints constraints
	) {
		recursiveValidateASTStructure(
			model,
			producer,
			validLabels,
			constraints.allowNestedFunctions(true)
		)
	}

	def dispatch void validateBlockStructure(
		EObject container,
		Block model,
		ASTStructureDiagnosticProducer producer,
		Set<LabelledStatement> validLabels,
		Constraints constraints
	) {
		recursiveValidateASTStructure(
			model,
			producer,
			validLabels,
			constraints.allowNestedFunctions(!constraints.isStrict)
		)
	}

	def dispatch void validateASTStructure(
		IfStatement model,
		ASTStructureDiagnosticProducer producer,
		Set<LabelledStatement> validLabels,
		Constraints constraints
	) {
		recursiveValidateASTStructure(
			model,
			producer,
			validLabels,
			constraints.allowNestedFunctions(!constraints.isStrict && !constraints.isInFunctionDeclaration)
		)
	}

	def dispatch void validateASTStructure(
		AbstractCaseClause model,
		ASTStructureDiagnosticProducer producer,
		Set<LabelledStatement> validLabels,
		Constraints constraints
	) {
		recursiveValidateASTStructure(
			model,
			producer,
			validLabels,
			constraints.allowBreak(true)
		)
	}

	def dispatch void validateASTStructure(
		ForStatement model,
		ASTStructureDiagnosticProducer producer,
		Set<LabelledStatement> validLabels,
		Constraints constraints
	) {
		if (!model.isForPlain) {
			if (! model.varDeclsOrBindings.empty) {
				model.varDecl.forEach[ varDecl |
					if (varDecl.expression !== null && !(varDecl.eContainer instanceof BindingElement) && (constraints.isStrict || model.varStmtKeyword === VariableStatementKeyword.LET)) {
						val nodes = NodeModelUtils.findNodesForFeature(varDecl, N4JSPackage.Literals.VARIABLE_DECLARATION__EXPRESSION)
						val target = nodes.head ?: NodeModelUtils.findActualNodeFor(varDecl)
						producer.node = target
						if(target !== null) {
							producer.addDiagnostic(
								new DiagnosticMessage(IssueCodes.messageForAST_VAR_DECL_IN_FOR_INVALID_INIT,
									if (constraints.isStrict || model.isForIn) IssueCodes.getDefaultSeverity(IssueCodes.AST_VAR_DECL_IN_FOR_INVALID_INIT) else Severity.WARNING,
									IssueCodes.AST_VAR_DECL_IN_FOR_INVALID_INIT))
						}
					} else if (model.varStmtKeyword === VariableStatementKeyword.LET && varDecl.name == 'let') {
						val nodes = NodeModelUtils.findNodesForFeature(varDecl, TypesPackage.Literals.IDENTIFIABLE_ELEMENT__NAME)
						val target = nodes.head ?: NodeModelUtils.findActualNodeFor(varDecl)
						producer.node = target
						if(target !== null) {
							producer.addDiagnostic(
								new DiagnosticMessage(IssueCodes.getMessageForAST_RESERVED_IDENTIFIER(varDecl.name),
									IssueCodes.getDefaultSeverity(IssueCodes.AST_RESERVED_IDENTIFIER),
									IssueCodes.AST_RESERVED_IDENTIFIER))
						}
					}
				]
			} else if (model.initExpr!==null) {
				val initExpr = model.initExpr;
				if (initExpr instanceof AssignmentExpression) {
					val nodes = NodeModelUtils.findNodesForFeature(initExpr,
						TypesPackage.Literals.IDENTIFIABLE_ELEMENT__NAME)
					val target = nodes.head ?: NodeModelUtils.findActualNodeFor(initExpr)
					producer.node = target
					if (target !== null) {
						producer.addDiagnostic(
							new DiagnosticMessage(
								IssueCodes.getMessageForAST_VAR_DECL_IN_FOR_INVALID_INIT(),
								IssueCodes.getDefaultSeverity(IssueCodes.AST_VAR_DECL_IN_FOR_INVALID_INIT),
								IssueCodes.AST_VAR_DECL_IN_FOR_INVALID_INIT))
					}
				} else if(!initExpr.isValidSimpleAssignmentTarget && !model.isDestructuringForStatement) {
					val nodes = NodeModelUtils.findNodesForFeature(model,
						N4JSPackage.Literals.FOR_STATEMENT__INIT_EXPR)
					val target = nodes.head ?: NodeModelUtils.findActualNodeFor(initExpr)
					producer.node = target
					if (target !== null) {
						producer.addDiagnostic(
							new DiagnosticMessage(
								IssueCodes.getMessageForAST_EXP_INVALID_LHS_ASS,
								IssueCodes.getDefaultSeverity(IssueCodes.AST_EXP_INVALID_LHS_ASS),
								IssueCodes.AST_EXP_INVALID_LHS_ASS))
					}
				}
			}
		}
		recursiveValidateASTStructure(
			model,
			producer,
			validLabels,
			constraints.allowNestedFunctions(!constraints.isStrict && !constraints.isInFunctionDeclaration).allowBreak(true).allowContinue(true)
		)
	}

	def dispatch void validateASTStructure(
		IterationStatement model,
		ASTStructureDiagnosticProducer producer,
		Set<LabelledStatement> validLabels,
		Constraints constraints
	) {
		recursiveValidateASTStructure(
			model,
			producer,
			validLabels,
			constraints.allowNestedFunctions(!constraints.isStrict && !constraints.isInFunctionDeclaration).allowBreak(true).allowContinue(true)
		)
	}

	def dispatch void validateASTStructure(
		FormalParameter model,
		ASTStructureDiagnosticProducer producer,
		Set<LabelledStatement> validLabels,
		Constraints constraints
	) {
		val container = model.eContainer
		var allowYieldInInit = false
		if (container instanceof FunctionDefinition) {
			if (model.isVariadic) {
				if (container.fpars.last !== model) {
					val nodes = NodeModelUtils.findNodesForFeature(model, N4JSPackage.Literals.FORMAL_PARAMETER__VARIADIC)
					val target = nodes.head ?: NodeModelUtils.findActualNodeFor(model)
					if(target !== null) {
						producer.node = target
						producer.addDiagnostic(
							new DiagnosticMessage(IssueCodes.messageForFUN_PARAM_VARIADIC_ONLY_LAST,
								IssueCodes.getDefaultSeverity(IssueCodes.FUN_PARAM_VARIADIC_ONLY_LAST),
								IssueCodes.FUN_PARAM_VARIADIC_ONLY_LAST))
					}
				} else if (model.initializer !== null) {
					val nodes = NodeModelUtils.findNodesForFeature(model, N4JSPackage.Literals.FORMAL_PARAMETER__INITIALIZER)
					val target = nodes.head ?: NodeModelUtils.findActualNodeFor(model)
					if(target !== null) {
						producer.node = target
						producer.addDiagnostic(
							new DiagnosticMessage(IssueCodes.messageForFUN_PARAM_VARIADIC_WITH_INITIALIZER,
								IssueCodes.getDefaultSeverity(IssueCodes.FUN_PARAM_VARIADIC_WITH_INITIALIZER),
								IssueCodes.FUN_PARAM_VARIADIC_WITH_INITIALIZER))
					}
				}
			}
			allowYieldInInit = !container.isGenerator
		}
		_validateASTStructure(
			model as Variable,
			producer,
			validLabels,
			constraints.allowYieldExpression(allowYieldInInit)
		)
	}

	def dispatch void validateASTStructure(
		NewTarget model,
		ASTStructureDiagnosticProducer producer,
		Set<LabelledStatement> validLabels,
		Constraints constraints
	) {
		if (EcoreUtil2.getContainerOfType(model, FunctionDefinition) === null) {
			val target = NodeModelUtils.findActualNodeFor(model)
			if(target !== null) {
				producer.node = target
				producer.addDiagnostic(
					new DiagnosticMessage(IssueCodes.messageForAST_INVALID_NEW_TARGET,
						IssueCodes.getDefaultSeverity(IssueCodes.AST_INVALID_NEW_TARGET),
						IssueCodes.AST_INVALID_NEW_TARGET))
			}
		}
		recursiveValidateASTStructure(
			model,
			producer,
			validLabels,
			constraints
		)
	}

	def dispatch void validateASTStructure(
		SuperLiteral model,
		ASTStructureDiagnosticProducer producer,
		Set<LabelledStatement> validLabels,
		Constraints constraints
	) {
		if (model.isInvalidSuperLiteral(constraints)) {

			val target = NodeModelUtils.findActualNodeFor(model)
			if(target !== null) {
				producer.node = target
				if (model.eContainingFeature === N4JSPackage.Literals.PARAMETERIZED_CALL_EXPRESSION__TARGET) {
					producer.addDiagnostic(
						new DiagnosticMessage(IssueCodes.messageForKEY_SUP_CTOR_INVALID_LOC,
							IssueCodes.getDefaultSeverity(IssueCodes.KEY_SUP_CTOR_INVALID_LOC),
							IssueCodes.KEY_SUP_CTOR_INVALID_LOC))
				} else if (EcoreUtil2.getContainerOfType(model, N4MethodDeclaration) === null) {
					producer.addDiagnostic(
						new DiagnosticMessage(IssueCodes.messageForKEY_SUP_ACCESS_INVALID_LOC,
							IssueCodes.getDefaultSeverity(IssueCodes.KEY_SUP_ACCESS_INVALID_LOC),
							IssueCodes.KEY_SUP_ACCESS_INVALID_LOC))
				} else {
					val containingClass = EcoreUtil2.getContainerOfType(model, N4ClassifierDeclaration)
					if (containingClass instanceof N4InterfaceDeclaration) {
						producer.addDiagnostic(
							new DiagnosticMessage(IssueCodes.messageForKEY_SUP_ACCESS_INVALID_LOC_INTERFACE,
								IssueCodes.getDefaultSeverity(IssueCodes.KEY_SUP_ACCESS_INVALID_LOC_INTERFACE),
								IssueCodes.KEY_SUP_ACCESS_INVALID_LOC_INTERFACE))
					} else if (containingClass !== null) {
						if (!constraints.isN4JS) { // implicit super type only available in n4js
							producer.addDiagnostic(
								new DiagnosticMessage(IssueCodes.messageForKEY_SUP_ACCESS_NO_EXTENDS,
									IssueCodes.getDefaultSeverity(IssueCodes.KEY_SUP_ACCESS_NO_EXTENDS),
									IssueCodes.KEY_SUP_ACCESS_NO_EXTENDS))
						}
					} else {
						throw new IllegalStateException('a')
					}
				}
			}

		}
		recursiveValidateASTStructure(
			model,
			producer,
			validLabels,
			constraints
		)
	}

	def boolean isInvalidSuperLiteral(SuperLiteral model, Constraints constraints) {
		if (!model.isValidContainment) {
			return true
		}
		if (!constraints.isSuperLiteralAllowed) {
			return true
		}
		if (!constraints.isSuperCallAllowed) {
			return model.eContainer instanceof ParameterizedCallExpression
		}
		return false
	}

	def boolean isValidContainment(SuperLiteral literal) {
		val container = literal.eContainer
		return container instanceof IndexedAccessExpression || container instanceof ParameterizedCallExpression || container instanceof ParameterizedPropertyAccessExpression
	}

	def dispatch void validateASTStructure(
		FunctionDeclaration model,
		ASTStructureDiagnosticProducer producer,
		Set<LabelledStatement> validLabels,
		Constraints constraints
	) {
		validateFunctionDefinition(
			model,
			N4JSPackage.Literals.FUNCTION_DECLARATION__NAME,
			constraints.enterFunctionDeclaration,
			model.name,
			producer,
			validLabels
		)
	}

	def dispatch void validateASTStructure(
		FunctionExpression model,
		ASTStructureDiagnosticProducer producer,
		Set<LabelledStatement> validLabels,
		Constraints constraints
	) {
		val name = model.name
		if (name !== null) {
			if (arguments == name) {
				issueArgumentsError(model, name, constraints.isStrict, producer)
			} else if (constraints.isStrict()) {
				if (reservedWordInStrictMode.contains(name) || eval == name) {
					issueNameDiagnostic(model, producer, name)
				}
			}
		}
		recursiveValidateASTStructure(
			model,
			producer,
			Sets.newHashSetWithExpectedSize(2),
			constraints.allowNestedFunctions(true).allowReturn(true).allowBreak(false).allowContinue(false)
		)
	}

	private def issueArgumentsError(EObject model, String name, boolean strict, ASTStructureDiagnosticProducer producer) {
		val nodes = NodeModelUtils.findNodesForFeature(model, model.eClass.getEStructuralFeature('name'))
		val target = nodes.head ?: NodeModelUtils.findActualNodeFor(model)
		producer.node = target
		if(target !== null) {
			producer.addDiagnostic(
				new DiagnosticMessage(IssueCodes.getMessageForAST_IMPL_PARAM_SHADOW_ERR(
						StringExtensions.toFirstUpper(messageHelper.description(model, name))),
					if (strict) Severity.ERROR else Severity.WARNING,
					IssueCodes.AST_IMPL_PARAM_SHADOW_ERR))
		}
	}

	def void validateFunctionDefinition(
		FunctionDefinition model,
		EAttribute attribute,
		Constraints constraints,
		String name,
		ASTStructureDiagnosticProducer producer,
		Set<LabelledStatement> validLabels
	) {
		if (!constraints.isNestedFunctionAllowed) {
			val nodes = NodeModelUtils.findNodesForFeature(model, attribute)
			val target = nodes.head ?: NodeModelUtils.findActualNodeFor(model)
			producer.node = target

			// TODO improve error message
			producer.addDiagnostic(
				new DiagnosticMessage(IssueCodes.getMessageForAST_STR_FUN_NOT_NESTED(),
					IssueCodes.getDefaultSeverity(IssueCodes.AST_STR_FUN_NOT_NESTED), IssueCodes.AST_STR_FUN_NOT_NESTED))
		} else if (name !== null) {
			if (arguments == name) {
				issueArgumentsError(model, name, constraints.isStrict, producer)
			} else if (constraints.isStrict()) {
				if (reservedWordInStrictMode.contains(name) || eval == name) {
					issueNameDiagnostic(model, producer, name)
				}
			}
		}
		recursiveValidateASTStructure(
			model,
			producer,
			Sets.newHashSetWithExpectedSize(2),
			constraints.allowNestedFunctions(true).allowReturn(true).allowContinue(false).allowBreak(false).allowYieldExpression(true)
		)
	}

	private def void validateName(PropertyNameOwner model, Constraints constraints, ASTStructureDiagnosticProducer producer) {
		val name = model.name
		if (name !== null) {
			if (!model.isValidName) {
				issueNameDiagnostic(model, producer, name)
			} else {
				if (constraints.isN4JS) {
					if (reservedWordInStrictMode.contains(name)) {
						issueNameDiagnostic(model, producer, name)
					}
				} else if (constraints.isStrict) {
					if (reservedWordInStrictMode.contains(name)) {
						issueNameDiagnostic(model, producer, name, model.eClass.getEStructuralFeature('name'), Severity.WARNING)
					}
				}
			}
		}
	}

	private def issueNameDiagnostic(EObject model, ASTStructureDiagnosticProducer producer, String name) {
		issueNameDiagnostic(model, producer, name, model.eClass.getEStructuralFeature('name'), IssueCodes.getDefaultSeverity(IssueCodes.AST_RESERVED_IDENTIFIER))
	}

	private def issueNameDiagnostic(EObject model, ASTStructureDiagnosticProducer producer, String name, EStructuralFeature feature, Severity severity) {
		val nodes = NodeModelUtils.findNodesForFeature(model, feature)
		val target = nodes.head ?: NodeModelUtils.findActualNodeFor(model)
		producer.node = target
		if(target !== null) {
			producer.addDiagnostic(
				new DiagnosticMessage(IssueCodes.getMessageForAST_RESERVED_IDENTIFIER(name),
					severity,
					IssueCodes.AST_RESERVED_IDENTIFIER))
		}
	}

	def dispatch void validateASTStructure(
		N4FieldAccessor model,
		ASTStructureDiagnosticProducer producer,
		Set<LabelledStatement> validLabels,
		Constraints constraints
	) {
		model.validateName(constraints, producer)
		recursiveValidateASTStructure(
			model,
			producer,
			Sets.newHashSetWithExpectedSize(2),
			constraints.allowReturn(true).allowSuperLiteral(true).allowSuperCall(false)
		)
	}

	def dispatch void validateASTStructure(
		MethodDeclaration model,
		ASTStructureDiagnosticProducer producer,
		Set<LabelledStatement> validLabels,
		Constraints constraints
	) {
		model.validateName(constraints, producer)
		recursiveValidateASTStructure(
			model,
			producer,
			Sets.newHashSetWithExpectedSize(2),
			constraints.allowReturn(true).allowSuperLiteral(true).allowSuperCall(model.name == 'constructor' && !model.isStatic && model.canCallSuperConstructor(constraints))
		)
	}

	private def boolean canCallSuperConstructor(MethodDeclaration declaration, Constraints constraints) {
		val container = declaration.eContainer
		if (container instanceof N4ClassDefinition) {
			if (constraints.isN4JS) {
				return true
			}
			return container.superClassRef !== null || container.superClassExpression !== null
		}
		return false
	}

	def dispatch void validateASTStructure(
		FieldAccessor model,
		ASTStructureDiagnosticProducer producer,
		Set<LabelledStatement> validLabels,
		Constraints constraints
	) {
		model.validateName(constraints, producer)
		recursiveValidateASTStructure(
			model,
			producer,
			Sets.newHashSetWithExpectedSize(2),
			constraints.allowReturn(true).allowSuperLiteral(true).allowSuperCall(false)
		)
	}

	def dispatch void validateASTStructure(
		PropertyAssignment model,
		ASTStructureDiagnosticProducer producer,
		Set<LabelledStatement> validLabels,
		Constraints constraints
	) {
		recursiveValidateASTStructure(
			model,
			producer,
			Sets.newHashSetWithExpectedSize(2),
			constraints.allowNestedFunctions(false).allowReturn(true).allowContinue(false).allowBreak(false).allowYieldExpression(true)
		)
	}

	def dispatch void validateASTStructure(
		ReturnStatement model,
		ASTStructureDiagnosticProducer producer,
		Set<LabelledStatement> validLabels,
		Constraints constraints
	) {
		if (!constraints.isReturnAllowed) {
			val target = NodeModelUtils.findActualNodeFor(model)
			producer.node = target
			producer.addDiagnostic(
				new DiagnosticMessage(IssueCodes.getMessageForAST_INVALID_RETURN,
					IssueCodes.getDefaultSeverity(IssueCodes.AST_INVALID_RETURN), IssueCodes.AST_INVALID_RETURN))
		}
		recursiveValidateASTStructure(
			model,
			producer,
			validLabels,
			constraints
		)
	}

	def dispatch void validateASTStructure(
		ContinueStatement model,
		ASTStructureDiagnosticProducer producer,
		Set<LabelledStatement> validLabels,
		Constraints constraints
	) {
		if (!constraints.isContinueAllowed) {
			val target = NodeModelUtils.findActualNodeFor(model)
			producer.node = target
			producer.addDiagnostic(
				new DiagnosticMessage(IssueCodes.getMessageForAST_INVALID_CONTINUE,
					IssueCodes.getDefaultSeverity(IssueCodes.AST_INVALID_CONTINUE), IssueCodes.AST_INVALID_CONTINUE))
		} else {
			validateLabel(model, model.label, producer, validLabels)
		}
		recursiveValidateASTStructure(
			model,
			producer,
			validLabels,
			constraints
		)
	}

	def dispatch void validateASTStructure(
		BreakStatement model,
		ASTStructureDiagnosticProducer producer,
		Set<LabelledStatement> validLabels,
		Constraints constraints
	) {
		if (!constraints.isBreakAllowed) {
			val target = NodeModelUtils.findActualNodeFor(model)
			producer.node = target
			producer.addDiagnostic(
				new DiagnosticMessage(IssueCodes.getMessageForAST_INVALID_BREAK,
					IssueCodes.getDefaultSeverity(IssueCodes.AST_INVALID_BREAK), IssueCodes.AST_INVALID_BREAK))
		} else {
			validateLabel(model, model.label, producer, validLabels)
		}
		recursiveValidateASTStructure(
			model,
			producer,
			validLabels,
			constraints
		)
	}

	def private void validateLabel(Statement model, LabelledStatement label, ASTStructureDiagnosticProducer producer,
		Set<LabelledStatement> validLabels) {
		if (label !== null && !label.eIsProxy && !validLabels.contains(label)) {
			val target = NodeModelUtils.findActualNodeFor(model)
			producer.node = target
			producer.addDiagnostic(
				new DiagnosticMessage(IssueCodes.getMessageForAST_INVALID_LABEL,
					IssueCodes.getDefaultSeverity(IssueCodes.AST_INVALID_LABEL), IssueCodes.AST_INVALID_LABEL))
		}
	}

	def dispatch void validateASTStructure(
		Expression model,
		ASTStructureDiagnosticProducer producer,
		Set<LabelledStatement> validLabels,
		Constraints constraints
	) {
		recursiveValidateASTStructure(
			model,
			producer,
			validLabels,
			constraints
		)
	}

	def dispatch void validateASTStructure(
		ArrayElement model,
		ASTStructureDiagnosticProducer producer,
		Set<LabelledStatement> validLabels,
		Constraints constraints
	) {
		recursiveValidateASTStructure(
			model,
			producer,
			validLabels,
			constraints
		)

		validateExpressionInArrayOrObjectLiteral(model, constraints, producer);
		validateSpreadInArrayLiteral(model, producer);
	}

	/** @param elem must be an ArrayElement or PropertyNameValuePair. */
	def private void validateExpressionInArrayOrObjectLiteral(EObject elem, Constraints constraints, ASTStructureDiagnosticProducer producer) {
		if(!(elem instanceof ArrayElement || elem instanceof PropertyNameValuePair || elem instanceof PropertyMethodDeclaration)) {
			throw new IllegalArgumentException();
		}
		if(elem instanceof PropertyNameValuePairSingleName) {
			val identifier = elem.identifierRef
			if (identifier !== null && !identifier.isValidSimpleAssignmentTarget) {
				producer.node = NodeModelUtils.findActualNodeFor(identifier)
				producer.addDiagnostic(
					new DiagnosticMessage(IssueCodes.getMessageForAST_INVALID_EXPR_IN_LHS_DESTRUCTURING_PATTERN,
						IssueCodes.getDefaultSeverity(IssueCodes.AST_INVALID_EXPR_IN_LHS_DESTRUCTURING_PATTERN), IssueCodes.AST_INVALID_EXPR_IN_LHS_DESTRUCTURING_PATTERN))
			}
			// more validation not required in this case, because expression has a different meaning and problem cannot occur
			return;
		}
		if(elem!==null && N4JSASTUtils.isArrayOrObjectLiteralUsedAsDestructuringPattern(elem.eContainer)) {
			if(elem instanceof PropertyMethodDeclaration) {
				// methods are not allowed at all in a destructuring pattern
				producer.node = NodeModelUtils.findActualNodeFor(elem)
				producer.addDiagnostic(
					new DiagnosticMessage(IssueCodes.getMessageForAST_INVALID_PROPERTY_METHOD_IN_LHS_DESTRUCTURING_PATTERN,
						IssueCodes.getDefaultSeverity(IssueCodes.AST_INVALID_PROPERTY_METHOD_IN_LHS_DESTRUCTURING_PATTERN), IssueCodes.AST_INVALID_PROPERTY_METHOD_IN_LHS_DESTRUCTURING_PATTERN))
			} else {
				val expr = switch(elem) {
					ArrayElement: elem.expression
					PropertyNameValuePair: elem.expression
				};
				if(expr!==null && !expr.isValidBindingElement(constraints)) {
					producer.node = NodeModelUtils.findActualNodeFor(expr)
					producer.addDiagnostic(
						new DiagnosticMessage(IssueCodes.getMessageForAST_INVALID_EXPR_IN_LHS_DESTRUCTURING_PATTERN,
							IssueCodes.getDefaultSeverity(IssueCodes.AST_INVALID_EXPR_IN_LHS_DESTRUCTURING_PATTERN), IssueCodes.AST_INVALID_EXPR_IN_LHS_DESTRUCTURING_PATTERN))
				}
			}
		}
	}

	private def isValidBindingElement(Expression expr, Constraints constraints) {
		if (constraints.isN4JS) {
			return (expr.isValidSimpleAssignmentTarget && expr instanceof IdentifierRef)
				|| expr instanceof AssignmentExpression
				|| expr instanceof ArrayLiteral
				|| expr instanceof ObjectLiteral
		} else {
			return expr.isValidSimpleAssignmentTarget
				|| expr instanceof AssignmentExpression
				|| expr instanceof ArrayLiteral
				|| expr instanceof ObjectLiteral
		}
	}

	def private void validateSpreadInArrayLiteral(ArrayElement elem, ASTStructureDiagnosticProducer producer) {
		if(elem!==null && elem.spread) {
			if(!N4JSASTUtils.isArrayOrObjectLiteralUsedAsDestructuringPattern(elem.eContainer)) {
				// use of spread in an array literal that is *not* used as a destructuring pattern
				// --> always error (legal in ES6 but not yet supported; might be supported later)
				val nodes = NodeModelUtils.findNodesForFeature(elem, N4JSPackage.eINSTANCE.arrayElement_Spread);
				producer.node = nodes.head ?: NodeModelUtils.findActualNodeFor(elem)
				producer.addDiagnostic(
					new DiagnosticMessage(IssueCodes.getMessageForAST_SPREAD_IN_ARRAY_LITERAL_UNSUPPORTED,
						IssueCodes.getDefaultSeverity(IssueCodes.AST_SPREAD_IN_ARRAY_LITERAL_UNSUPPORTED), IssueCodes.AST_SPREAD_IN_ARRAY_LITERAL_UNSUPPORTED))
			}
			else {
				// use of spread in an array literal that *is* used as a destructuring pattern
				// --> error if not at end of array literal
				val lit = elem.eContainer;
				if(lit instanceof ArrayLiteral) {
					if(lit.elements.last!==elem || lit.trailingComma) {
						val nodes = NodeModelUtils.findNodesForFeature(elem, N4JSPackage.eINSTANCE.arrayElement_Spread);
						producer.node = nodes.head ?: NodeModelUtils.findActualNodeFor(elem)
						producer.addDiagnostic(
							new DiagnosticMessage(IssueCodes.getMessageForAST_REST_MUST_APPEAR_AT_END,
								IssueCodes.getDefaultSeverity(IssueCodes.AST_REST_MUST_APPEAR_AT_END), IssueCodes.AST_REST_MUST_APPEAR_AT_END))
					}

					if (elem.expression instanceof AssignmentExpression) {
						val nodes = NodeModelUtils.findNodesForFeature(elem.expression, N4JSPackage.eINSTANCE.assignmentExpression_Rhs);
						producer.node = nodes.head ?: NodeModelUtils.findActualNodeFor(elem.expression)
						producer.addDiagnostic(
							new DiagnosticMessage(IssueCodes.getMessageForAST_REST_WITH_INITIALIZER,
								IssueCodes.getDefaultSeverity(IssueCodes.AST_REST_WITH_INITIALIZER), IssueCodes.AST_REST_WITH_INITIALIZER))
					}
				}
			}
		}
	}

	def dispatch void validateASTStructure(
		PropertyNameValuePair model,
		ASTStructureDiagnosticProducer producer,
		Set<LabelledStatement> validLabels,
		Constraints constraints
	) {
		recursiveValidateASTStructure(
			model,
			producer,
			validLabels,
			constraints.allowYieldExpression(true)
		)

		validateExpressionInArrayOrObjectLiteral(model, constraints, producer);
		validateSingleNameInObjectLiteral(model, producer);
	}

	def dispatch void validateASTStructure(
		PropertyMethodDeclaration model,
		ASTStructureDiagnosticProducer producer,
		Set<LabelledStatement> validLabels,
		Constraints constraints
	) {
		recursiveValidateASTStructure(
			model,
			producer,
			validLabels,
			constraints.allowReturn(true).allowSuperLiteral(true).allowSuperCall(false).allowYieldExpression(true)
		)

		validateExpressionInArrayOrObjectLiteral(model, constraints, producer);
	}

	def private void validateSingleNameInObjectLiteral(PropertyNameValuePair elem, ASTStructureDiagnosticProducer producer) {
		if(elem instanceof PropertyNameValuePairSingleName && !N4JSASTUtils.isArrayOrObjectLiteralUsedAsDestructuringPattern(elem.eContainer)) {
			producer.node = NodeModelUtils.findActualNodeFor(elem)
			producer.addDiagnostic(
				new DiagnosticMessage(IssueCodes.getMessageForAST_SINGLE_NAME_IN_OBJECT_LITERAL_UNSUPPORTED,
					IssueCodes.getDefaultSeverity(IssueCodes.AST_SINGLE_NAME_IN_OBJECT_LITERAL_UNSUPPORTED), IssueCodes.AST_SINGLE_NAME_IN_OBJECT_LITERAL_UNSUPPORTED))
		}
	}

	def dispatch void validateASTStructure(
		VariableStatement model,
		ASTStructureDiagnosticProducer producer,
		Set<LabelledStatement> validLabels,
		Constraints constraints
	) {
		if (model.varStmtKeyword === VariableStatementKeyword.CONST) {
			if (!model.isValidConstOrLetPosition) {
				val nodes = NodeModelUtils.findNodesForFeature(model, N4JSPackage.Literals.VARIABLE_DECLARATION_CONTAINER__VAR_STMT_KEYWORD)
				producer.node = nodes.head ?: NodeModelUtils.findActualNodeFor(model)
				producer.addDiagnostic(
					new DiagnosticMessage(IssueCodes.messageForAST_CONST_IN_STATEMENT_POSITION,
						IssueCodes.getDefaultSeverity(IssueCodes.AST_CONST_IN_STATEMENT_POSITION),
						IssueCodes.AST_CONST_IN_STATEMENT_POSITION))
			}
		} else if (model.varStmtKeyword === VariableStatementKeyword.LET) {
			if (!model.isValidConstOrLetPosition) {
				val nodes = NodeModelUtils.findNodesForFeature(model, N4JSPackage.Literals.VARIABLE_DECLARATION_CONTAINER__VAR_STMT_KEYWORD)
				producer.node = nodes.head ?: NodeModelUtils.findActualNodeFor(model)
				producer.addDiagnostic(
					new DiagnosticMessage(IssueCodes.messageForAST_LET_IN_STATEMENT_POSITION,
						IssueCodes.getDefaultSeverity(IssueCodes.AST_LET_IN_STATEMENT_POSITION),
						IssueCodes.AST_LET_IN_STATEMENT_POSITION))
			}
		}
		recursiveValidateASTStructure(
			model,
			producer,
			validLabels,
			constraints.allowVarWithoutInitializer(model.varStmtKeyword === VariableStatementKeyword.VAR || model.varStmtKeyword === VariableStatementKeyword.LET &&
				(model.eContainer instanceof Block || model.eContainer instanceof Script || model.eContainer instanceof AbstractCaseClause)
			)
		)
	}

	private def boolean isValidConstOrLetPosition(EObject model) {
		if (model.eContainer instanceof Block || model.eContainer instanceof Script || model.eContainer instanceof AbstractCaseClause) {
			return true
		}
		if (model.eContainer instanceof ExportDeclaration) {
			return model.eContainer.isValidConstOrLetPosition
		}
		return false
	}

	def dispatch void validateASTStructure(
		VariableDeclaration model,
		ASTStructureDiagnosticProducer producer,
		Set<LabelledStatement> validLabels,
		Constraints constraints
	) {
		if (model.expression === null && constraints.isVarInitializerRequired && !constraints.external) {
			val nodes = NodeModelUtils.findNodesForFeature(model, TypesPackage.Literals.IDENTIFIABLE_ELEMENT__NAME);
			producer.node = nodes.head ?: NodeModelUtils.findActualNodeFor(model)
			producer.addDiagnostic(
				new DiagnosticMessage(IssueCodes.getMessageForAST_CONST_HAS_NO_INITIALIZER(model.getName()),
					IssueCodes.getDefaultSeverity(IssueCodes.AST_CONST_HAS_NO_INITIALIZER), IssueCodes.AST_CONST_HAS_NO_INITIALIZER))
		}
		_validateASTStructure(model as Variable, producer, validLabels, constraints.allowVarWithoutInitializer(true))
	}

	def dispatch void validateASTStructure(
		ThisTypeRef thisTypeRef,
		ASTStructureDiagnosticProducer producer,
		Set<LabelledStatement> validLabels,
		Constraints constraints
	) {
		if (!(thisTypeRef.isUsedStructurallyAsFormalParametersInTheConstructor ||
			thisTypeRef.isUsedAsReturnTypeInMethod ||
			thisTypeRef.isUsedAsExistentialTypeArgInReturnTypeInMethod ||
			thisTypeRef.isUsedAsFormalParameterInFunctionExpression ||
			thisTypeRef.isUsedInVariableWithSyntaxError
			 )) {
			val node = NodeModelUtils.findActualNodeFor(thisTypeRef)
			val target = node.leafNodes.filter[!hidden].head
			producer.node = target
			producer.addDiagnostic(
				new DiagnosticMessage(IssueCodes.getMessageForAST_THIS_WRONG_PLACE,
					IssueCodes.getDefaultSeverity(IssueCodes.AST_THIS_WRONG_PLACE), IssueCodes.AST_THIS_WRONG_PLACE))
		}

		recursiveValidateASTStructure(
			thisTypeRef,
			producer,
			validLabels,
			constraints
		)
	}

	private def boolean isUsedInVariableWithSyntaxError(ThisTypeRef ref) {
		val container = ref.eContainer
		if (container instanceof VariableDeclaration) {
			return container.name === null
		}
		return false
	}

	def dispatch void validateASTStructure(
		BindingElement model,
		ASTStructureDiagnosticProducer producer,
		Set<LabelledStatement> validLabels,
		Constraints constraints
	) {
		validateRestInBindingPattern(model, producer);

		recursiveValidateASTStructure(
			model,
			producer,
			validLabels,
			constraints
		)
	}

	def private void validateRestInBindingPattern(BindingElement elem, ASTStructureDiagnosticProducer producer) {
		if(elem!==null && elem.rest) {
			val pattern = elem.eContainer;
			if(pattern instanceof BindingPattern) {
				// note: the grammar ensures that BindingElement with rest===true will only appear
				// within an array binding pattern; we only have to assert that it appears at the end
				if(pattern.elements.last!==elem) {
					val nodes = NodeModelUtils.findNodesForFeature(elem, N4JSPackage.eINSTANCE.bindingElement_Rest);
					producer.node = nodes.head ?: NodeModelUtils.findActualNodeFor(elem)
					producer.addDiagnostic(
						new DiagnosticMessage(IssueCodes.getMessageForAST_REST_MUST_APPEAR_AT_END,
							IssueCodes.getDefaultSeverity(IssueCodes.AST_REST_MUST_APPEAR_AT_END), IssueCodes.AST_REST_MUST_APPEAR_AT_END))
				}
			}
			if (elem.expression !== null) {
				val nodes = NodeModelUtils.findNodesForFeature(elem, N4JSPackage.eINSTANCE.bindingElement_Expression);
				producer.node = nodes.head ?: NodeModelUtils.findActualNodeFor(elem)
				producer.addDiagnostic(
					new DiagnosticMessage(IssueCodes.getMessageForAST_REST_WITH_INITIALIZER,
						IssueCodes.getDefaultSeverity(IssueCodes.AST_REST_WITH_INITIALIZER), IssueCodes.AST_REST_WITH_INITIALIZER))
			}
		}
	}

	/**
	 * - use as return type in instance methods
	 * IDE-785: - use as return type in static methods, but not in constructor-expression
	 */
	def private isUsedAsReturnTypeInMethod(EObject eObject) {
		var parent = eObject.eContainer
		var boolean isReturnFeature = false
		var valid = true;
		if( parent instanceof ClassifierTypeRef ){ // if X - part of "type{ X }"
		  if (parent.eContainer instanceof N4MethodDeclaration) {
			 isReturnFeature = parent.eContainingFeature == N4JSPackage.Literals.FUNCTION_DEFINITION__RETURN_TYPE_REF
			 if( isReturnFeature ) {
			 	// not allowed: constructor{this}.
			 	if( parent instanceof ConstructorTypeRef) {
			 		valid = false;
			 	}
			 }
		  }
		} else if (parent instanceof N4MethodDeclaration) { // normal return-type decl.
		  isReturnFeature = eObject.eContainingFeature == N4JSPackage.Literals.FUNCTION_DEFINITION__RETURN_TYPE_REF
		  // not alllowed in static methods of interfaces:
		  if( parent.isStatic && parent.eContainer instanceof N4InterfaceDeclaration ) {
		  	valid = false
		  }
		}
		return /* !parent.isStatic && */  isReturnFeature && valid
	}

	/**
	 * IDE-785: - use as existential type-arg in return type in static methods, but not in constructor-expression
	 * Super-special allowance for N4Enums:   "Array<? extends this> getLiterals()" in n4jsd files.
	 */
	def private isUsedAsExistentialTypeArgInReturnTypeInMethod(EObject eObject) {
		val parentWC = eObject.eContainer
		// In WildCard
		if( parentWC instanceof Wildcard) {
			// declared upper bound: "? extends eObject"
			if( parentWC.declaredUpperBound == eObject) {
				val parentPTR = parentWC.eContainer
				// In WildCard of ParamterizedTypeRef
				if(parentPTR instanceof ParameterizedTypeRef){
					// In WildCard of ParamterizedTypeRef of return-type
				 	if (parentPTR.eContainer instanceof N4MethodDeclaration) {
					  if( parentPTR.eContainingFeature == N4JSPackage.Literals.FUNCTION_DEFINITION__RETURN_TYPE_REF )
						{
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	def private isUsedStructurallyAsFormalParametersInTheConstructor(ThisTypeRef thisTypeRef) {
		if (thisTypeRef.useSiteStructuralTyping) {
			val methodOrConstructor = thisTypeRef?.eContainer?.eContainer;
			if (methodOrConstructor instanceof N4MethodDeclaration) {
				if (methodOrConstructor !== null && methodOrConstructor.isConstructor) {
					return true
				}
			}
		}
		return false
	}
	/* IDEBUG-228 use thisTypeRef inside a MethodSignature:
	 * - in FPars of FunctionTypeExpressions or
	 * - as return type of FTE - depending of usage
	 */
	def private boolean isUsedAsFormalParameterInFunctionExpression(ThisTypeRef thisTypeRef) {
		val fte = thisTypeRef?.eContainer?.eContainer;
		if (fte instanceof FunctionTypeExpression) {
			// thisTypeRef as formal parameter in FTE
			val fteContainer = fte.eContainer;
			if(
				(fteContainer instanceof FormalParameter && fteContainer.eContainer instanceof N4MethodDeclaration)
				||
				(fteContainer instanceof FormalParameter && fteContainer.eContainer instanceof N4SetterDeclaration)
			) {
				return true;
			}
		}

// not possible yet, since we cannot construct a function(expression) with a corresponding return type.
//		val retFTE = thisTypeRef?.eContainer;
//		if( retFTE instanceof FunctionTypeExpression && thisTypeRef ===(retFTE as FunctionTypeExpression).returnTypeRef) {
//			// THISTYPEREF as return
//			val fteContainer = retFTE.eContainer;
//
//			if(
//				(fteContainer instanceof N4MethodDeclaration && retFTE===(fteContainer as N4MethodDeclaration).returnTypeRef)
//				||
//				(fteContainer instanceof N4GetterDeclaration && retFTE===(fteContainer as N4GetterDeclaration).declaredTypeRef)
//			) {
//				return true;
//			}
//		}
		return false;
	}
}