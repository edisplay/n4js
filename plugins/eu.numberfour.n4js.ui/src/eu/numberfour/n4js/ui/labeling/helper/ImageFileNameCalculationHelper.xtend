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
package eu.numberfour.n4js.ui.labeling.helper

import com.google.common.base.Strings
import eu.numberfour.n4js.n4JS.ExportedVariableDeclaration
import eu.numberfour.n4js.n4JS.ExportedVariableStatement
import eu.numberfour.n4js.n4JS.FunctionDeclaration
import eu.numberfour.n4js.n4JS.ImportDeclaration
import eu.numberfour.n4js.n4JS.N4ClassDeclaration
import eu.numberfour.n4js.n4JS.N4EnumDeclaration
import eu.numberfour.n4js.n4JS.N4FieldDeclaration
import eu.numberfour.n4js.n4JS.N4InterfaceDeclaration
import eu.numberfour.n4js.n4JS.N4MethodDeclaration
import eu.numberfour.n4js.n4JS.NamedImportSpecifier
import eu.numberfour.n4js.n4JS.Script
import eu.numberfour.n4js.ts.types.FieldAccessor
import eu.numberfour.n4js.ts.types.MemberAccessModifier
import eu.numberfour.n4js.ts.types.TClass
import eu.numberfour.n4js.ts.types.TEnum
import eu.numberfour.n4js.ts.types.TEnumLiteral
import eu.numberfour.n4js.ts.types.TField
import eu.numberfour.n4js.ts.types.TFunction
import eu.numberfour.n4js.ts.types.TInterface
import eu.numberfour.n4js.ts.types.TMethod
import eu.numberfour.n4js.ts.types.TModule
import eu.numberfour.n4js.ts.types.TVariable
import eu.numberfour.n4js.ts.types.TypeAccessModifier
import eu.numberfour.n4js.ts.types.TypesPackage
import org.eclipse.xtext.resource.IEObjectDescription

import static eu.numberfour.n4js.resource.N4JSResourceDescriptionStrategy.*

/**
 * This helper class dispatches the selection of the main image file to use for
 * a given AST (resp. types) element. For classes, interfaces, enumerations, fields
 * and methods there are already different images available for different visibility
 * states so for their selection there is a switch here.
 * <br /><br />
 * As fallback for an unknown element null is returned, this is expected by the API
 * of the label provider.
 */
class ImageFileNameCalculationHelper {

	/* calculation of image file name for AST -> delegates to types model, as information is easier to retrieve there */

	def dispatch String getImageFileName(Script script) {
		return getImageFileName(script.module)
	}

	def dispatch String getImageFileName(N4ClassDeclaration n4ClassDeclaration) {
		 getImageFileName(n4ClassDeclaration.definedType)
	}

	def dispatch String getImageFileName(N4InterfaceDeclaration n4InterfaceDeclaration) {
		 getImageFileName(n4InterfaceDeclaration.definedType)
	}

	def dispatch String getImageFileName(FunctionDeclaration functionDeclaration) {
		 getImageFileName(functionDeclaration.definedType)
	}

	def dispatch String getImageFileName(N4EnumDeclaration n4EnumDeclaration) {
		 getImageFileName(n4EnumDeclaration.definedTypeAsEnum)
	}

	def dispatch String getImageFileName(N4MethodDeclaration n4MethodDeclaration) {
		 getImageFileName(n4MethodDeclaration.definedTypeElement)
	}

	def dispatch String getImageFileName(N4FieldDeclaration n4FieldDeclaration) {
		 getImageFileName(n4FieldDeclaration.definedField)
	}

	def dispatch String getImageFileName(ExportedVariableDeclaration vd) {
		 getImageFileName(vd.definedVariable)
	}

	def dispatch String getImageFileName(ExportedVariableStatement vs) {
		 return "var_simple_aggr.gif"
	}

	def dispatch String getImageFileName(ImportDeclaration importDelaration) {
		return "import_obj.gif"
	}

	def dispatch String getImageFileName(NamedImportSpecifier namedImportSpecifier) {
		return "import.gif"
	}

	/* calculation of image file name for types model */

	def dispatch String getImageFileName(TModule tClass) {
		"submodule.gif"
	}

	def dispatch String getImageFileName(TClass tClass) {
		return getClassFileName(tClass.typeAccessModifier);
	}

	def private String getClassFileName(TypeAccessModifier modifier) {
		switch modifier {
			case TypeAccessModifier.PUBLIC: "innerclass_public_obj.gif"
			case TypeAccessModifier.PUBLIC_INTERNAL: "innerclass_protected_obj.gif"
			case TypeAccessModifier.PROJECT: "innerclass_default_obj.gif"
			case TypeAccessModifier.PRIVATE: "innerclass_private_obj.gif"
			default: "innerclass_default_obj.gif"
		}
	}

	def dispatch String getImageFileName(TInterface tInterface) {
		return getInterfaceFileName(tInterface.typeAccessModifier);
	}

	def private String getInterfaceFileName(TypeAccessModifier modifier) {
		switch modifier {
			case TypeAccessModifier.PUBLIC: "innerinterface_public_obj.gif"
			case TypeAccessModifier.PUBLIC_INTERNAL: "innerinterface_protected_obj.gif"
			case TypeAccessModifier.PROJECT: "innerinterface_default_obj.gif"
			case TypeAccessModifier.PRIVATE: "innerinterface_private_obj.gif"
			default: "innerinterface_default_obj.gif"
		}
	}

	def dispatch String getImageFileName(TEnum tEnum) {
		return getEnumFileName(tEnum.typeAccessModifier)
	}

	def private String getEnumFileName(TypeAccessModifier modifier) {
		switch modifier {
			case TypeAccessModifier.PUBLIC: "enum_obj.gif"
			case TypeAccessModifier.PUBLIC_INTERNAL: "enum_protected_obj.gif"
			case TypeAccessModifier.PROJECT: "enum_default_obj.gif"
			case TypeAccessModifier.PRIVATE: "enum_private_obj.gif"
			default: "enum_obj.gif"
		}
	}

	def dispatch String getImageFileName(TFunction tFunction) {
		switch tFunction.typeAccessModifier {
			case TypeAccessModifier.PUBLIC: "function.gif"
			case TypeAccessModifier.PUBLIC_INTERNAL: "function.gif"
			case TypeAccessModifier.PROJECT: "function.gif"
			case TypeAccessModifier.PRIVATE: "function.gif"
			default: "function.gif"
		}
	}

	def dispatch String getImageFileName(TMethod tMethod) {
		switch tMethod.memberAccessModifier {
			case MemberAccessModifier.PUBLIC: "method_public_obj.gif"
			case MemberAccessModifier.PUBLIC_INTERNAL: "method_public_obj.gif"
			case MemberAccessModifier.PROTECTED: "method_protected_obj.gif"
			case MemberAccessModifier.PROJECT: "method.gif"
			case MemberAccessModifier.PRIVATE: "method_private_obj.gif"
			default: "method.gif"
		}
	}

	def dispatch String getImageFileName(FieldAccessor fieldAccessor) {
		switch fieldAccessor.memberAccessModifier {
			case MemberAccessModifier.PUBLIC: "method_public_obj.gif"
			case MemberAccessModifier.PUBLIC_INTERNAL: "method_public_obj.gif"
			case MemberAccessModifier.PROTECTED: "method_protected_obj.gif"
			case MemberAccessModifier.PROJECT: "method.gif"
			case MemberAccessModifier.PRIVATE: "method_private_obj.gif"
			default: "method.gif"
		}
	}

	def dispatch String getImageFileName(TField tField) {
		switch tField.memberAccessModifier {
			case MemberAccessModifier.PUBLIC: "field_public_obj.gif"
			case MemberAccessModifier.PUBLIC_INTERNAL: "field_public_obj.gif"
			case MemberAccessModifier.PROTECTED: "method_protected_obj.gif"
			case MemberAccessModifier.PROJECT: "field_default_obj.gif"
			case MemberAccessModifier.PRIVATE: "field_private_obj.gif"
			default: "field_default_obj.gif"
		}
	}

	def dispatch String getImageFileName(TEnumLiteral tEnumLiteral) {
		"field_public_obj.gif"
	}

	def dispatch String getImageFileName(TVariable tVariable) {
		return "var_simple.gif"
	}

	def dispatch String getImageFileName(IEObjectDescription description) {
		val modifier = tryGetAccessModifier(description);
		switch (description.EClass) {
			case TypesPackage.eINSTANCE.TClass: getClassFileName(modifier)
			case TypesPackage.eINSTANCE.TInterface: getInterfaceFileName(modifier)
			case TypesPackage.eINSTANCE.TEnum: getEnumFileName(modifier)
			default: null
		}
	}

	def private TypeAccessModifier tryGetAccessModifier(IEObjectDescription description) {
		try {
			val ordinal = Integer.parseInt(Strings.nullToEmpty(description.getUserData(ACCESS_MODIFIERY_KEY)))
			return TypeAccessModifier.values.findFirst[it.ordinal === ordinal];
		} catch (NumberFormatException e) {
			return TypeAccessModifier.PUBLIC;
		}
	}

	// fallback
	def dispatch String getImageFileName(Object object) {
		return null
	}
}
