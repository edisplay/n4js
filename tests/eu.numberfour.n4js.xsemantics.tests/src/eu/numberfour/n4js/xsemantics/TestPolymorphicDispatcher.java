/**
 * Copyright (c) 2017 NumberFour AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   NumberFour AG - Initial API and implementation
 */
package eu.numberfour.n4js.xsemantics;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.eclipse.xtext.util.PolymorphicDispatcher;

import eu.numberfour.n4js.n4JS.AdditiveExpression;
import eu.numberfour.n4js.n4JS.Argument;
import eu.numberfour.n4js.n4JS.ArrayElement;
import eu.numberfour.n4js.n4JS.ArrayLiteral;
import eu.numberfour.n4js.n4JS.ArrayPadding;
import eu.numberfour.n4js.n4JS.AssignmentExpression;
import eu.numberfour.n4js.n4JS.AwaitExpression;
import eu.numberfour.n4js.n4JS.BinaryBitwiseExpression;
import eu.numberfour.n4js.n4JS.BinaryLogicalExpression;
import eu.numberfour.n4js.n4JS.BooleanLiteral;
import eu.numberfour.n4js.n4JS.CastExpression;
import eu.numberfour.n4js.n4JS.CatchVariable;
import eu.numberfour.n4js.n4JS.CommaExpression;
import eu.numberfour.n4js.n4JS.ConditionalExpression;
import eu.numberfour.n4js.n4JS.EqualityExpression;
import eu.numberfour.n4js.n4JS.Expression;
import eu.numberfour.n4js.n4JS.FormalParameter;
import eu.numberfour.n4js.n4JS.FunctionExpression;
import eu.numberfour.n4js.n4JS.GetterDeclaration;
import eu.numberfour.n4js.n4JS.IdentifierRef;
import eu.numberfour.n4js.n4JS.IndexedAccessExpression;
import eu.numberfour.n4js.n4JS.LocalArgumentsVariable;
import eu.numberfour.n4js.n4JS.MultiplicativeExpression;
import eu.numberfour.n4js.n4JS.N4ClassExpression;
import eu.numberfour.n4js.n4JS.N4EnumLiteral;
import eu.numberfour.n4js.n4JS.N4FieldDeclaration;
import eu.numberfour.n4js.n4JS.NewExpression;
import eu.numberfour.n4js.n4JS.NewTarget;
import eu.numberfour.n4js.n4JS.NullLiteral;
import eu.numberfour.n4js.n4JS.NumericLiteral;
import eu.numberfour.n4js.n4JS.ObjectLiteral;
import eu.numberfour.n4js.n4JS.ParameterizedCallExpression;
import eu.numberfour.n4js.n4JS.ParameterizedPropertyAccessExpression;
import eu.numberfour.n4js.n4JS.ParenExpression;
import eu.numberfour.n4js.n4JS.PostfixExpression;
import eu.numberfour.n4js.n4JS.PromisifyExpression;
import eu.numberfour.n4js.n4JS.PropertyNameValuePair;
import eu.numberfour.n4js.n4JS.RegularExpressionLiteral;
import eu.numberfour.n4js.n4JS.RelationalExpression;
import eu.numberfour.n4js.n4JS.SetterDeclaration;
import eu.numberfour.n4js.n4JS.ShiftExpression;
import eu.numberfour.n4js.n4JS.StringLiteral;
import eu.numberfour.n4js.n4JS.SuperLiteral;
import eu.numberfour.n4js.n4JS.TaggedTemplateString;
import eu.numberfour.n4js.n4JS.TemplateLiteral;
import eu.numberfour.n4js.n4JS.TemplateSegment;
import eu.numberfour.n4js.n4JS.ThisLiteral;
import eu.numberfour.n4js.n4JS.TypeDefiningElement;
import eu.numberfour.n4js.n4JS.UnaryExpression;
import eu.numberfour.n4js.n4JS.VariableDeclaration;
import eu.numberfour.n4js.n4JS.YieldExpression;
import eu.numberfour.n4js.ts.types.ModuleNamespaceVirtualType;
import eu.numberfour.n4js.ts.types.TEnumLiteral;
import eu.numberfour.n4js.ts.types.TField;
import eu.numberfour.n4js.ts.types.TGetter;
import eu.numberfour.n4js.ts.types.TSetter;
import eu.numberfour.n4js.ts.types.TVariable;
import eu.numberfour.n4js.ts.types.Type;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.internal.PatchedPolymorphicDispatcher;

/**
 *
 */
public class TestPolymorphicDispatcher extends PolymorphicDispatcher<Object> {

	/**
	 * Main method, uncomment the different method calls in the loop to run different test scenarios.
	 */
	public static void main(String[] args) {
		TestPolymorphicDispatcher test = new TestPolymorphicDispatcher();
		while (true) {
			// test.shuffleAndSortUsingTimSortWithOriginalCompare();
			// test.shuffleAndSortUsingTimSortWithPatchedCompare();
			// test.shuffleAndSortUsingTreeSetWithOriginalCompare();
			test.shuffleAndSortUsingTreeSetWithPatchedCompare();
		}
	}

	private void shuffleAndSortUsingTimSortWithOriginalCompare() {
		shuffleAndSortUsingTimSort(originalCompare());
	}

	private void shuffleAndSortUsingTimSortWithPatchedCompare() {
		shuffleAndSortUsingTimSort(patchedCompare());
	}

	private void shuffleAndSortUsingTreeSetWithOriginalCompare() {
		shuffleAndSortUsingTreeSet(originalCompare());
	}

	private void shuffleAndSortUsingTreeSetWithPatchedCompare() {
		shuffleAndSortUsingTreeSet(patchedCompare());
	}

	private void shuffleAndSortUsingTimSort(Comparator<MethodDesc> compare) {
		List<MethodDesc> copy = new ArrayList<>(methods);
		Collections.shuffle(copy);
		Collections.sort(copy, compare);
	}

	private void shuffleAndSortUsingTreeSet(Comparator<MethodDesc> compare) {
		SortedSet<MethodDesc> cachedDescriptors = new TreeSet<>(compare);

		List<MethodDesc> copy = new ArrayList<>(methods);
		Collections.shuffle(copy);
		cachedDescriptors.addAll(copy);

		if (cachedDescriptors.size() != methods.size()) {
			StringBuilder msg = new StringBuilder();
			msg.append("TreeSet swallowed ").append(methods.size() - cachedDescriptors.size()).append(" methods");
			throw new RuntimeException(msg.toString());
		}
	}

	/**
	 * Returns a comparator that compares method descriptors using {@link PolymorphicDispatcher#compare}.
	 */
	private Comparator<MethodDesc> originalCompare() {
		return new Comparator<MethodDesc>() {
			@Override
			public int compare(MethodDesc o1,
					MethodDesc o2) {
				final List<Class<?>> paramTypes1 = Arrays.asList(o1.getParameterTypes());
				final List<Class<?>> paramTypes2 = Arrays.asList(o2.getParameterTypes());

				// sort by number of parameters
				if (paramTypes1.size() > paramTypes2.size())
					return 1;
				if (paramTypes2.size() > paramTypes1.size())
					return -1;

				// sort by parameter types from left to right
				for (int i = 0; i < paramTypes1.size(); i++) {
					final Class<?> class1 = paramTypes1.get(i);
					final Class<?> class2 = paramTypes2.get(i);

					if (class1.equals(class2))
						continue;
					if (class1.isAssignableFrom(class2) || Void.class.equals(class2))
						return -1;
					if (class2.isAssignableFrom(class1) || Void.class.equals(class1))
						return 1;
				}

				// sort by declaring class (more specific comes first).
				if (!o1.getDeclaringClass().equals(o2.getDeclaringClass())) {
					if (o1.getDeclaringClass().isAssignableFrom(o2.getDeclaringClass()))
						return 1;
					if (o2.getDeclaringClass().isAssignableFrom(o1.getDeclaringClass()))
						return -1;
				}

				// sort by target skipped since we only have one target
				return 0;

				// final int compareTo = ((Integer) targets.indexOf(o2.target)).compareTo(targets.indexOf(o1.target));
				// return compareTo;
			}
		};
	}

	/**
	 * Returns a comparator that compares method descriptors using {@link PatchedPolymorphicDispatcher#compare}.
	 */
	private Comparator<MethodDesc> patchedCompare() {
		return new Comparator<MethodDesc>() {
			private final Comparator<MethodDesc> orig = originalCompare();

			@Override
			public int compare(MethodDesc o1, MethodDesc o2) {
				int compare = orig.compare(o1, o2);
				if (compare != 0) {
					return compare;
				}
				Class<?>[] p1 = o1.getParameterTypes();
				Class<?>[] p2 = o2.getParameterTypes();
				int to = Math.min(p1.length, p2.length);

				for (int i = 0; i < to; i++) {
					final String n1 = p1[i].getName();
					final String n2 = p2[i].getName();
					compare = n1.compareTo(n2);
					if (compare != 0) {
						return compare;
					}
				}
				return compare;
			}
		};
	}

	/*
	 * ===============================================================================================================
	 *
	 * Constructor and initialization of test data.
	 *
	 * ===============================================================================================================
	 */

	private final List<MethodDesc> methods;

	/**
	 * Creates a new instance and initializes the list of methods under consideration.
	 */
	public TestPolymorphicDispatcher() {
		super(Collections.singletonList(new Object()), method -> false);

		this.methods = getMethods();
	}

	private List<MethodDesc> getMethods() {
		List<MethodDesc> result = new ArrayList<>();

		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, AdditiveExpression.class)));
		result.add(createMethodDesc(this,
				findMethod(getClass(), "typeImpl", RuleEnvironment.class, RuleApplicationTrace.class, Argument.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, ArrayElement.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, ArrayLiteral.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, ArrayPadding.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, AssignmentExpression.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, AwaitExpression.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, BinaryBitwiseExpression.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, BinaryLogicalExpression.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, BooleanLiteral.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, CastExpression.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, CatchVariable.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, CommaExpression.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, ConditionalExpression.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, EqualityExpression.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, Expression.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, FormalParameter.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, FunctionExpression.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, GetterDeclaration.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, IdentifierRef.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, IndexedAccessExpression.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, LocalArgumentsVariable.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, ModuleNamespaceVirtualType.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, MultiplicativeExpression.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, N4ClassExpression.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, N4EnumLiteral.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, N4FieldDeclaration.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, NewExpression.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, NewTarget.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, NullLiteral.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, NumericLiteral.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, ObjectLiteral.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, ParameterizedCallExpression.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, ParameterizedPropertyAccessExpression.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, ParenExpression.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, PostfixExpression.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, PromisifyExpression.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, PropertyNameValuePair.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, RegularExpressionLiteral.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, RelationalExpression.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, SetterDeclaration.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, ShiftExpression.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, StringLiteral.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, SuperLiteral.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, TaggedTemplateString.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, TemplateLiteral.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, TemplateSegment.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, TEnumLiteral.class)));
		result.add(createMethodDesc(this,
				findMethod(getClass(), "typeImpl", RuleEnvironment.class, RuleApplicationTrace.class, TField.class)));
		result.add(createMethodDesc(this,
				findMethod(getClass(), "typeImpl", RuleEnvironment.class, RuleApplicationTrace.class, TGetter.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, ThisLiteral.class)));
		result.add(createMethodDesc(this,
				findMethod(getClass(), "typeImpl", RuleEnvironment.class, RuleApplicationTrace.class, TSetter.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, TVariable.class)));
		result.add(createMethodDesc(this,
				findMethod(getClass(), "typeImpl", RuleEnvironment.class, RuleApplicationTrace.class, Type.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, TypeDefiningElement.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, UnaryExpression.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, VariableDeclaration.class)));
		result.add(createMethodDesc(this, findMethod(getClass(), "typeImpl", RuleEnvironment.class,
				RuleApplicationTrace.class, YieldExpression.class)));

		return result;
	}

	private Method findMethod(Class<?> current, String name, Class<?>... parameterTypes) {
		if (current == Object.class)
			throw new IllegalArgumentException("Cannot find method");
		try {
			return current.getDeclaredMethod(name, parameterTypes);
		} catch (java.lang.NoSuchMethodException | SecurityException e) {
			return findMethod(current.getSuperclass(), name, parameterTypes);
		}
	}

	/*
	 * ===============================================================================================================
	 *
	 * Test methods with signatures copied from N4JS type system.
	 *
	 * ===============================================================================================================
	 */

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, AdditiveExpression x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, Argument x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, ArrayElement x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, ArrayLiteral x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, ArrayPadding x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, AssignmentExpression x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, AwaitExpression x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, BinaryBitwiseExpression x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, BinaryLogicalExpression x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, BooleanLiteral x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, CastExpression x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, CatchVariable x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, CommaExpression x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, ConditionalExpression x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, EqualityExpression x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, Expression x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, FormalParameter x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, FunctionExpression x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, GetterDeclaration x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, IdentifierRef x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, IndexedAccessExpression x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, LocalArgumentsVariable x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, ModuleNamespaceVirtualType x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, MultiplicativeExpression x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, N4ClassExpression x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, N4EnumLiteral x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, N4FieldDeclaration x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, NewExpression x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, NewTarget x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, NullLiteral x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, NumericLiteral x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, ObjectLiteral x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, ParameterizedCallExpression x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, ParameterizedPropertyAccessExpression x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, ParenExpression x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, PostfixExpression x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, PromisifyExpression x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, PropertyNameValuePair x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, RegularExpressionLiteral x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, RelationalExpression x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, SetterDeclaration x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, ShiftExpression x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, StringLiteral x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, SuperLiteral x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, TaggedTemplateString x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, TemplateLiteral x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, TemplateSegment x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, TEnumLiteral x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, TField x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, TGetter x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, ThisLiteral x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, TSetter x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, TVariable x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, Type x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, TypeDefiningElement x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, UnaryExpression x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, VariableDeclaration x) {
	}

	public void typeImpl(RuleEnvironment e, RuleApplicationTrace t, YieldExpression x) {
	}
}
