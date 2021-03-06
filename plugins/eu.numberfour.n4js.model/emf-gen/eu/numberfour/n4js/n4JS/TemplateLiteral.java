/**
 * Copyright (c) 2016 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package eu.numberfour.n4js.n4JS;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * A template expression as defined for ECMA6
 * http://people.mozilla.org/~jorendorff/es6-draft.html#sec-template-literals
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.numberfour.n4js.n4JS.TemplateLiteral#getSegments <em>Segments</em>}</li>
 * </ul>
 *
 * @see eu.numberfour.n4js.n4JS.N4JSPackage#getTemplateLiteral()
 * @model
 * @generated
 */
public interface TemplateLiteral extends PrimaryExpression {
	/**
	 * Returns the value of the '<em><b>Segments</b></em>' containment reference list.
	 * The list contents are of type {@link eu.numberfour.n4js.n4JS.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Segments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Segments</em>' containment reference list.
	 * @see eu.numberfour.n4js.n4JS.N4JSPackage#getTemplateLiteral_Segments()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getSegments();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final <%java.lang.StringBuilder%> result = new <%java.lang.StringBuilder%>(\"`\");\nfinal <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%eu.numberfour.n4js.n4JS.Expression%>, <%java.lang.StringBuilder%>> _function = new <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%eu.numberfour.n4js.n4JS.Expression%>, <%java.lang.StringBuilder%>>()\n{\n\tpublic <%java.lang.StringBuilder%> apply(final <%eu.numberfour.n4js.n4JS.Expression%> expr)\n\t{\n\t\t<%java.lang.StringBuilder%> _switchResult = null;\n\t\tboolean _matched = false;\n\t\tif (expr instanceof <%eu.numberfour.n4js.n4JS.Literal%>)\n\t\t{\n\t\t\t_matched=true;\n\t\t\t<%java.lang.String%> _valueAsString = <%this%>.getValueAsString();\n\t\t\t_switchResult = result.append(_valueAsString);\n\t\t}\n\t\tif (!_matched)\n\t\t{\n\t\t\t<%java.lang.StringBuilder%> _append = result.append(\"<<\");\n\t\t\t<%org.eclipse.emf.ecore.EClass%> _eClass = <%this%>.eClass();\n\t\t\t<%java.lang.String%> _name = _eClass.getName();\n\t\t\t<%java.lang.StringBuilder%> _append_1 = _append.append(_name);\n\t\t\t_switchResult = _append_1.append(\">>\");\n\t\t}\n\t\treturn _switchResult;\n\t}\n};\nfinal <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%eu.numberfour.n4js.n4JS.Expression%>, <%java.lang.StringBuilder%>> appender = _function;\n<%org.eclipse.emf.common.util.EList%><<%eu.numberfour.n4js.n4JS.Expression%>> _segments = this.getSegments();\nfinal <%org.eclipse.xtext.xbase.lib.Functions.Function2%><<%java.lang.Boolean%>, <%eu.numberfour.n4js.n4JS.Expression%>, <%java.lang.Boolean%>> _function_1 = new <%org.eclipse.xtext.xbase.lib.Functions.Function2%><<%java.lang.Boolean%>, <%eu.numberfour.n4js.n4JS.Expression%>, <%java.lang.Boolean%>>()\n{\n\tpublic <%java.lang.Boolean%> apply(final <%java.lang.Boolean%> isRaw, final <%eu.numberfour.n4js.n4JS.Expression%> expression)\n\t{\n\t\tif ((!(isRaw).booleanValue()))\n\t\t{\n\t\t\tresult.append(\"${\");\n\t\t\tappender.apply(expression);\n\t\t\tresult.append(\"}\");\n\t\t}\n\t\telse\n\t\t{\n\t\t\tappender.apply(expression);\n\t\t}\n\t\treturn <%java.lang.Boolean%>.valueOf((!(isRaw).booleanValue()));\n\t}\n};\n<%org.eclipse.xtext.xbase.lib.IterableExtensions%>.<<%eu.numberfour.n4js.n4JS.Expression%>, <%java.lang.Boolean%>>fold(_segments, <%java.lang.Boolean%>.valueOf(true), _function_1);\nresult.append(\"`\");\nreturn result.toString();'"
	 * @generated
	 */
	String getValueAsString();

} // TemplateLiteral
