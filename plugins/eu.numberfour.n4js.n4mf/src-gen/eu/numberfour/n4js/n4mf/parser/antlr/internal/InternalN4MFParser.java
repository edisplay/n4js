package eu.numberfour.n4js.n4mf.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import eu.numberfour.n4js.n4mf.services.N4MFGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalN4MFParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ExtendedRuntimeEnvironment", "ProvidedRuntimeLibraries", "RequiredRuntimeLibraries", "ImplementedProjects", "ProjectDependencies", "RuntimeEnvironment", "ImplementationId", "ProjectVersion", "TestedProjects", "RuntimeLibrary", "ModuleFilters", "ModuleLoader", "NoModuleWrap", "Node_builtin", "InitModules", "ProjectType", "Application", "ExecModule", "MainModule", "VendorName", "NoValidate", "Libraries", "ProjectId", "Resources", "Processor", "VendorId", "Commonjs", "External", "Sources", "Compile", "Content", "Library", "Output", "Source", "KW_System", "N4js", "Test", "User", "API", "In", "LeftParenthesis", "RightParenthesis", "Comma", "HyphenMinus", "FullStop", "Colon", "LeftSquareBracket", "RightSquareBracket", "LeftCurlyBracket", "RightCurlyBracket", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int TestedProjects=12;
    public static final int KW_System=38;
    public static final int ProjectDependencies=8;
    public static final int ExecModule=21;
    public static final int LeftParenthesis=44;
    public static final int Test=40;
    public static final int ProjectVersion=11;
    public static final int Libraries=25;
    public static final int ModuleFilters=14;
    public static final int RightSquareBracket=51;
    public static final int VendorName=23;
    public static final int RuntimeEnvironment=9;
    public static final int RULE_ID=54;
    public static final int NoValidate=24;
    public static final int NoModuleWrap=16;
    public static final int RightParenthesis=45;
    public static final int Sources=32;
    public static final int Content=34;
    public static final int RULE_INT=55;
    public static final int ProjectType=19;
    public static final int External=31;
    public static final int RULE_ML_COMMENT=57;
    public static final int LeftSquareBracket=50;
    public static final int Resources=27;
    public static final int Library=35;
    public static final int Application=20;
    public static final int ImplementedProjects=7;
    public static final int Processor=28;
    public static final int User=41;
    public static final int In=43;
    public static final int VendorId=29;
    public static final int RULE_STRING=56;
    public static final int Node_builtin=17;
    public static final int N4js=39;
    public static final int Compile=33;
    public static final int Source=37;
    public static final int RULE_SL_COMMENT=58;
    public static final int ImplementationId=10;
    public static final int Comma=46;
    public static final int HyphenMinus=47;
    public static final int Output=36;
    public static final int MainModule=22;
    public static final int Colon=49;
    public static final int RightCurlyBracket=53;
    public static final int EOF=-1;
    public static final int ExtendedRuntimeEnvironment=4;
    public static final int FullStop=48;
    public static final int ModuleLoader=15;
    public static final int Commonjs=30;
    public static final int RULE_WS=59;
    public static final int ProjectId=26;
    public static final int LeftCurlyBracket=52;
    public static final int ProvidedRuntimeLibraries=5;
    public static final int RULE_ANY_OTHER=60;
    public static final int RequiredRuntimeLibraries=6;
    public static final int InitModules=18;
    public static final int API=42;
    public static final int RuntimeLibrary=13;

    // delegates
    // delegators


        public InternalN4MFParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalN4MFParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalN4MFParser.tokenNames; }
    public String getGrammarFileName() { return "InternalN4MFParser.g"; }



     	private N4MFGrammarAccess grammarAccess;

        public InternalN4MFParser(TokenStream input, N4MFGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "ProjectDescription";
       	}

       	@Override
       	protected N4MFGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleProjectDescription"
    // InternalN4MFParser.g:58:1: entryRuleProjectDescription returns [EObject current=null] : iv_ruleProjectDescription= ruleProjectDescription EOF ;
    public final EObject entryRuleProjectDescription() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProjectDescription = null;


        try {
            // InternalN4MFParser.g:58:59: (iv_ruleProjectDescription= ruleProjectDescription EOF )
            // InternalN4MFParser.g:59:2: iv_ruleProjectDescription= ruleProjectDescription EOF
            {
             newCompositeNode(grammarAccess.getProjectDescriptionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProjectDescription=ruleProjectDescription();

            state._fsp--;

             current =iv_ruleProjectDescription; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProjectDescription"


    // $ANTLR start "ruleProjectDescription"
    // InternalN4MFParser.g:65:1: ruleProjectDescription returns [EObject current=null] : ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= ProjectId otherlv_2= Colon ( (lv_projectId_3_0= ruleN4mfIdentifier ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= ProjectType otherlv_5= Colon ( (lv_projectType_6_0= ruleProjectType ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ProjectVersion otherlv_8= Colon ( (lv_projectVersion_9_0= ruleDeclaredVersion ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= VendorId otherlv_11= Colon ( (lv_declaredVendorId_12_0= ruleN4mfIdentifier ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= VendorName otherlv_14= Colon ( (lv_vendorName_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= MainModule otherlv_17= Colon ( (lv_mainModule_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_extendedRuntimeEnvironment_19_0= ruleExtendedRuntimeEnvironment ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_providedRuntimeLibraries_20_0= ruleProvidedRuntimeLibraries ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_requiredRuntimeLibraries_21_0= ruleRequiredRuntimeLibraries ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_projectDependencies_22_0= ruleProjectDependencies ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= ImplementationId otherlv_24= Colon ( (lv_implementationId_25_0= ruleN4mfIdentifier ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_implementedProjects_26_0= ruleImplementedProjects ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_initModules_27_0= ruleInitModules ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_execModule_28_0= ruleExecModule ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_29= Output otherlv_30= Colon ( (lv_outputPath_31_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= Libraries otherlv_33= LeftCurlyBracket ( (lv_libraryPaths_34_0= RULE_STRING ) ) (otherlv_35= Comma ( (lv_libraryPaths_36_0= RULE_STRING ) ) )* otherlv_37= RightCurlyBracket ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= Resources otherlv_39= LeftCurlyBracket ( (lv_resourcePaths_40_0= RULE_STRING ) ) (otherlv_41= Comma ( (lv_resourcePaths_42_0= RULE_STRING ) ) )* otherlv_43= RightCurlyBracket ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= Sources otherlv_45= LeftCurlyBracket ( (lv_sourceFragment_46_0= ruleSourceFragment ) )+ otherlv_47= RightCurlyBracket ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= ModuleFilters otherlv_49= LeftCurlyBracket ( (lv_moduleFilters_50_0= ruleModuleFilter ) )+ otherlv_51= RightCurlyBracket ) ) ) ) | ({...}? => ( ({...}? => ( (lv_testedProjects_52_0= ruleTestedProjects ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= ModuleLoader otherlv_54= Colon ( (lv_moduleLoader_55_0= ruleModuleLoader ) ) ) ) ) ) )+ {...}?) ) ) ;
    public final EObject ruleProjectDescription() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token lv_vendorName_15_0=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token lv_mainModule_18_0=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_29=null;
        Token otherlv_30=null;
        Token lv_outputPath_31_0=null;
        Token otherlv_32=null;
        Token otherlv_33=null;
        Token lv_libraryPaths_34_0=null;
        Token otherlv_35=null;
        Token lv_libraryPaths_36_0=null;
        Token otherlv_37=null;
        Token otherlv_38=null;
        Token otherlv_39=null;
        Token lv_resourcePaths_40_0=null;
        Token otherlv_41=null;
        Token lv_resourcePaths_42_0=null;
        Token otherlv_43=null;
        Token otherlv_44=null;
        Token otherlv_45=null;
        Token otherlv_47=null;
        Token otherlv_48=null;
        Token otherlv_49=null;
        Token otherlv_51=null;
        Token otherlv_53=null;
        Token otherlv_54=null;
        AntlrDatatypeRuleToken lv_projectId_3_0 = null;

        Enumerator lv_projectType_6_0 = null;

        EObject lv_projectVersion_9_0 = null;

        AntlrDatatypeRuleToken lv_declaredVendorId_12_0 = null;

        EObject lv_extendedRuntimeEnvironment_19_0 = null;

        EObject lv_providedRuntimeLibraries_20_0 = null;

        EObject lv_requiredRuntimeLibraries_21_0 = null;

        EObject lv_projectDependencies_22_0 = null;

        AntlrDatatypeRuleToken lv_implementationId_25_0 = null;

        EObject lv_implementedProjects_26_0 = null;

        EObject lv_initModules_27_0 = null;

        EObject lv_execModule_28_0 = null;

        EObject lv_sourceFragment_46_0 = null;

        EObject lv_moduleFilters_50_0 = null;

        EObject lv_testedProjects_52_0 = null;

        Enumerator lv_moduleLoader_55_0 = null;



        	enterRule();

        try {
            // InternalN4MFParser.g:71:2: ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= ProjectId otherlv_2= Colon ( (lv_projectId_3_0= ruleN4mfIdentifier ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= ProjectType otherlv_5= Colon ( (lv_projectType_6_0= ruleProjectType ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ProjectVersion otherlv_8= Colon ( (lv_projectVersion_9_0= ruleDeclaredVersion ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= VendorId otherlv_11= Colon ( (lv_declaredVendorId_12_0= ruleN4mfIdentifier ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= VendorName otherlv_14= Colon ( (lv_vendorName_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= MainModule otherlv_17= Colon ( (lv_mainModule_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_extendedRuntimeEnvironment_19_0= ruleExtendedRuntimeEnvironment ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_providedRuntimeLibraries_20_0= ruleProvidedRuntimeLibraries ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_requiredRuntimeLibraries_21_0= ruleRequiredRuntimeLibraries ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_projectDependencies_22_0= ruleProjectDependencies ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= ImplementationId otherlv_24= Colon ( (lv_implementationId_25_0= ruleN4mfIdentifier ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_implementedProjects_26_0= ruleImplementedProjects ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_initModules_27_0= ruleInitModules ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_execModule_28_0= ruleExecModule ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_29= Output otherlv_30= Colon ( (lv_outputPath_31_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= Libraries otherlv_33= LeftCurlyBracket ( (lv_libraryPaths_34_0= RULE_STRING ) ) (otherlv_35= Comma ( (lv_libraryPaths_36_0= RULE_STRING ) ) )* otherlv_37= RightCurlyBracket ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= Resources otherlv_39= LeftCurlyBracket ( (lv_resourcePaths_40_0= RULE_STRING ) ) (otherlv_41= Comma ( (lv_resourcePaths_42_0= RULE_STRING ) ) )* otherlv_43= RightCurlyBracket ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= Sources otherlv_45= LeftCurlyBracket ( (lv_sourceFragment_46_0= ruleSourceFragment ) )+ otherlv_47= RightCurlyBracket ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= ModuleFilters otherlv_49= LeftCurlyBracket ( (lv_moduleFilters_50_0= ruleModuleFilter ) )+ otherlv_51= RightCurlyBracket ) ) ) ) | ({...}? => ( ({...}? => ( (lv_testedProjects_52_0= ruleTestedProjects ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= ModuleLoader otherlv_54= Colon ( (lv_moduleLoader_55_0= ruleModuleLoader ) ) ) ) ) ) )+ {...}?) ) ) )
            // InternalN4MFParser.g:72:2: ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= ProjectId otherlv_2= Colon ( (lv_projectId_3_0= ruleN4mfIdentifier ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= ProjectType otherlv_5= Colon ( (lv_projectType_6_0= ruleProjectType ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ProjectVersion otherlv_8= Colon ( (lv_projectVersion_9_0= ruleDeclaredVersion ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= VendorId otherlv_11= Colon ( (lv_declaredVendorId_12_0= ruleN4mfIdentifier ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= VendorName otherlv_14= Colon ( (lv_vendorName_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= MainModule otherlv_17= Colon ( (lv_mainModule_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_extendedRuntimeEnvironment_19_0= ruleExtendedRuntimeEnvironment ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_providedRuntimeLibraries_20_0= ruleProvidedRuntimeLibraries ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_requiredRuntimeLibraries_21_0= ruleRequiredRuntimeLibraries ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_projectDependencies_22_0= ruleProjectDependencies ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= ImplementationId otherlv_24= Colon ( (lv_implementationId_25_0= ruleN4mfIdentifier ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_implementedProjects_26_0= ruleImplementedProjects ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_initModules_27_0= ruleInitModules ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_execModule_28_0= ruleExecModule ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_29= Output otherlv_30= Colon ( (lv_outputPath_31_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= Libraries otherlv_33= LeftCurlyBracket ( (lv_libraryPaths_34_0= RULE_STRING ) ) (otherlv_35= Comma ( (lv_libraryPaths_36_0= RULE_STRING ) ) )* otherlv_37= RightCurlyBracket ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= Resources otherlv_39= LeftCurlyBracket ( (lv_resourcePaths_40_0= RULE_STRING ) ) (otherlv_41= Comma ( (lv_resourcePaths_42_0= RULE_STRING ) ) )* otherlv_43= RightCurlyBracket ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= Sources otherlv_45= LeftCurlyBracket ( (lv_sourceFragment_46_0= ruleSourceFragment ) )+ otherlv_47= RightCurlyBracket ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= ModuleFilters otherlv_49= LeftCurlyBracket ( (lv_moduleFilters_50_0= ruleModuleFilter ) )+ otherlv_51= RightCurlyBracket ) ) ) ) | ({...}? => ( ({...}? => ( (lv_testedProjects_52_0= ruleTestedProjects ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= ModuleLoader otherlv_54= Colon ( (lv_moduleLoader_55_0= ruleModuleLoader ) ) ) ) ) ) )+ {...}?) ) )
            {
            // InternalN4MFParser.g:72:2: ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= ProjectId otherlv_2= Colon ( (lv_projectId_3_0= ruleN4mfIdentifier ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= ProjectType otherlv_5= Colon ( (lv_projectType_6_0= ruleProjectType ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ProjectVersion otherlv_8= Colon ( (lv_projectVersion_9_0= ruleDeclaredVersion ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= VendorId otherlv_11= Colon ( (lv_declaredVendorId_12_0= ruleN4mfIdentifier ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= VendorName otherlv_14= Colon ( (lv_vendorName_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= MainModule otherlv_17= Colon ( (lv_mainModule_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_extendedRuntimeEnvironment_19_0= ruleExtendedRuntimeEnvironment ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_providedRuntimeLibraries_20_0= ruleProvidedRuntimeLibraries ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_requiredRuntimeLibraries_21_0= ruleRequiredRuntimeLibraries ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_projectDependencies_22_0= ruleProjectDependencies ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= ImplementationId otherlv_24= Colon ( (lv_implementationId_25_0= ruleN4mfIdentifier ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_implementedProjects_26_0= ruleImplementedProjects ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_initModules_27_0= ruleInitModules ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_execModule_28_0= ruleExecModule ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_29= Output otherlv_30= Colon ( (lv_outputPath_31_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= Libraries otherlv_33= LeftCurlyBracket ( (lv_libraryPaths_34_0= RULE_STRING ) ) (otherlv_35= Comma ( (lv_libraryPaths_36_0= RULE_STRING ) ) )* otherlv_37= RightCurlyBracket ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= Resources otherlv_39= LeftCurlyBracket ( (lv_resourcePaths_40_0= RULE_STRING ) ) (otherlv_41= Comma ( (lv_resourcePaths_42_0= RULE_STRING ) ) )* otherlv_43= RightCurlyBracket ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= Sources otherlv_45= LeftCurlyBracket ( (lv_sourceFragment_46_0= ruleSourceFragment ) )+ otherlv_47= RightCurlyBracket ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= ModuleFilters otherlv_49= LeftCurlyBracket ( (lv_moduleFilters_50_0= ruleModuleFilter ) )+ otherlv_51= RightCurlyBracket ) ) ) ) | ({...}? => ( ({...}? => ( (lv_testedProjects_52_0= ruleTestedProjects ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= ModuleLoader otherlv_54= Colon ( (lv_moduleLoader_55_0= ruleModuleLoader ) ) ) ) ) ) )+ {...}?) ) )
            // InternalN4MFParser.g:73:3: ( ( ( ({...}? => ( ({...}? => (otherlv_1= ProjectId otherlv_2= Colon ( (lv_projectId_3_0= ruleN4mfIdentifier ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= ProjectType otherlv_5= Colon ( (lv_projectType_6_0= ruleProjectType ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ProjectVersion otherlv_8= Colon ( (lv_projectVersion_9_0= ruleDeclaredVersion ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= VendorId otherlv_11= Colon ( (lv_declaredVendorId_12_0= ruleN4mfIdentifier ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= VendorName otherlv_14= Colon ( (lv_vendorName_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= MainModule otherlv_17= Colon ( (lv_mainModule_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_extendedRuntimeEnvironment_19_0= ruleExtendedRuntimeEnvironment ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_providedRuntimeLibraries_20_0= ruleProvidedRuntimeLibraries ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_requiredRuntimeLibraries_21_0= ruleRequiredRuntimeLibraries ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_projectDependencies_22_0= ruleProjectDependencies ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= ImplementationId otherlv_24= Colon ( (lv_implementationId_25_0= ruleN4mfIdentifier ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_implementedProjects_26_0= ruleImplementedProjects ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_initModules_27_0= ruleInitModules ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_execModule_28_0= ruleExecModule ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_29= Output otherlv_30= Colon ( (lv_outputPath_31_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= Libraries otherlv_33= LeftCurlyBracket ( (lv_libraryPaths_34_0= RULE_STRING ) ) (otherlv_35= Comma ( (lv_libraryPaths_36_0= RULE_STRING ) ) )* otherlv_37= RightCurlyBracket ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= Resources otherlv_39= LeftCurlyBracket ( (lv_resourcePaths_40_0= RULE_STRING ) ) (otherlv_41= Comma ( (lv_resourcePaths_42_0= RULE_STRING ) ) )* otherlv_43= RightCurlyBracket ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= Sources otherlv_45= LeftCurlyBracket ( (lv_sourceFragment_46_0= ruleSourceFragment ) )+ otherlv_47= RightCurlyBracket ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= ModuleFilters otherlv_49= LeftCurlyBracket ( (lv_moduleFilters_50_0= ruleModuleFilter ) )+ otherlv_51= RightCurlyBracket ) ) ) ) | ({...}? => ( ({...}? => ( (lv_testedProjects_52_0= ruleTestedProjects ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= ModuleLoader otherlv_54= Colon ( (lv_moduleLoader_55_0= ruleModuleLoader ) ) ) ) ) ) )+ {...}?) )
            {
            // InternalN4MFParser.g:73:3: ( ( ( ({...}? => ( ({...}? => (otherlv_1= ProjectId otherlv_2= Colon ( (lv_projectId_3_0= ruleN4mfIdentifier ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= ProjectType otherlv_5= Colon ( (lv_projectType_6_0= ruleProjectType ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ProjectVersion otherlv_8= Colon ( (lv_projectVersion_9_0= ruleDeclaredVersion ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= VendorId otherlv_11= Colon ( (lv_declaredVendorId_12_0= ruleN4mfIdentifier ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= VendorName otherlv_14= Colon ( (lv_vendorName_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= MainModule otherlv_17= Colon ( (lv_mainModule_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_extendedRuntimeEnvironment_19_0= ruleExtendedRuntimeEnvironment ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_providedRuntimeLibraries_20_0= ruleProvidedRuntimeLibraries ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_requiredRuntimeLibraries_21_0= ruleRequiredRuntimeLibraries ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_projectDependencies_22_0= ruleProjectDependencies ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= ImplementationId otherlv_24= Colon ( (lv_implementationId_25_0= ruleN4mfIdentifier ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_implementedProjects_26_0= ruleImplementedProjects ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_initModules_27_0= ruleInitModules ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_execModule_28_0= ruleExecModule ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_29= Output otherlv_30= Colon ( (lv_outputPath_31_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= Libraries otherlv_33= LeftCurlyBracket ( (lv_libraryPaths_34_0= RULE_STRING ) ) (otherlv_35= Comma ( (lv_libraryPaths_36_0= RULE_STRING ) ) )* otherlv_37= RightCurlyBracket ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= Resources otherlv_39= LeftCurlyBracket ( (lv_resourcePaths_40_0= RULE_STRING ) ) (otherlv_41= Comma ( (lv_resourcePaths_42_0= RULE_STRING ) ) )* otherlv_43= RightCurlyBracket ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= Sources otherlv_45= LeftCurlyBracket ( (lv_sourceFragment_46_0= ruleSourceFragment ) )+ otherlv_47= RightCurlyBracket ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= ModuleFilters otherlv_49= LeftCurlyBracket ( (lv_moduleFilters_50_0= ruleModuleFilter ) )+ otherlv_51= RightCurlyBracket ) ) ) ) | ({...}? => ( ({...}? => ( (lv_testedProjects_52_0= ruleTestedProjects ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= ModuleLoader otherlv_54= Colon ( (lv_moduleLoader_55_0= ruleModuleLoader ) ) ) ) ) ) )+ {...}?) )
            // InternalN4MFParser.g:74:4: ( ( ({...}? => ( ({...}? => (otherlv_1= ProjectId otherlv_2= Colon ( (lv_projectId_3_0= ruleN4mfIdentifier ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= ProjectType otherlv_5= Colon ( (lv_projectType_6_0= ruleProjectType ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ProjectVersion otherlv_8= Colon ( (lv_projectVersion_9_0= ruleDeclaredVersion ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= VendorId otherlv_11= Colon ( (lv_declaredVendorId_12_0= ruleN4mfIdentifier ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= VendorName otherlv_14= Colon ( (lv_vendorName_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= MainModule otherlv_17= Colon ( (lv_mainModule_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_extendedRuntimeEnvironment_19_0= ruleExtendedRuntimeEnvironment ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_providedRuntimeLibraries_20_0= ruleProvidedRuntimeLibraries ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_requiredRuntimeLibraries_21_0= ruleRequiredRuntimeLibraries ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_projectDependencies_22_0= ruleProjectDependencies ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= ImplementationId otherlv_24= Colon ( (lv_implementationId_25_0= ruleN4mfIdentifier ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_implementedProjects_26_0= ruleImplementedProjects ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_initModules_27_0= ruleInitModules ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_execModule_28_0= ruleExecModule ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_29= Output otherlv_30= Colon ( (lv_outputPath_31_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= Libraries otherlv_33= LeftCurlyBracket ( (lv_libraryPaths_34_0= RULE_STRING ) ) (otherlv_35= Comma ( (lv_libraryPaths_36_0= RULE_STRING ) ) )* otherlv_37= RightCurlyBracket ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= Resources otherlv_39= LeftCurlyBracket ( (lv_resourcePaths_40_0= RULE_STRING ) ) (otherlv_41= Comma ( (lv_resourcePaths_42_0= RULE_STRING ) ) )* otherlv_43= RightCurlyBracket ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= Sources otherlv_45= LeftCurlyBracket ( (lv_sourceFragment_46_0= ruleSourceFragment ) )+ otherlv_47= RightCurlyBracket ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= ModuleFilters otherlv_49= LeftCurlyBracket ( (lv_moduleFilters_50_0= ruleModuleFilter ) )+ otherlv_51= RightCurlyBracket ) ) ) ) | ({...}? => ( ({...}? => ( (lv_testedProjects_52_0= ruleTestedProjects ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= ModuleLoader otherlv_54= Colon ( (lv_moduleLoader_55_0= ruleModuleLoader ) ) ) ) ) ) )+ {...}?)
            {
             
            			  getUnorderedGroupHelper().enter(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup());
            			
            // InternalN4MFParser.g:77:4: ( ( ({...}? => ( ({...}? => (otherlv_1= ProjectId otherlv_2= Colon ( (lv_projectId_3_0= ruleN4mfIdentifier ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= ProjectType otherlv_5= Colon ( (lv_projectType_6_0= ruleProjectType ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ProjectVersion otherlv_8= Colon ( (lv_projectVersion_9_0= ruleDeclaredVersion ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= VendorId otherlv_11= Colon ( (lv_declaredVendorId_12_0= ruleN4mfIdentifier ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= VendorName otherlv_14= Colon ( (lv_vendorName_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= MainModule otherlv_17= Colon ( (lv_mainModule_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_extendedRuntimeEnvironment_19_0= ruleExtendedRuntimeEnvironment ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_providedRuntimeLibraries_20_0= ruleProvidedRuntimeLibraries ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_requiredRuntimeLibraries_21_0= ruleRequiredRuntimeLibraries ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_projectDependencies_22_0= ruleProjectDependencies ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= ImplementationId otherlv_24= Colon ( (lv_implementationId_25_0= ruleN4mfIdentifier ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_implementedProjects_26_0= ruleImplementedProjects ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_initModules_27_0= ruleInitModules ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_execModule_28_0= ruleExecModule ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_29= Output otherlv_30= Colon ( (lv_outputPath_31_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= Libraries otherlv_33= LeftCurlyBracket ( (lv_libraryPaths_34_0= RULE_STRING ) ) (otherlv_35= Comma ( (lv_libraryPaths_36_0= RULE_STRING ) ) )* otherlv_37= RightCurlyBracket ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= Resources otherlv_39= LeftCurlyBracket ( (lv_resourcePaths_40_0= RULE_STRING ) ) (otherlv_41= Comma ( (lv_resourcePaths_42_0= RULE_STRING ) ) )* otherlv_43= RightCurlyBracket ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= Sources otherlv_45= LeftCurlyBracket ( (lv_sourceFragment_46_0= ruleSourceFragment ) )+ otherlv_47= RightCurlyBracket ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= ModuleFilters otherlv_49= LeftCurlyBracket ( (lv_moduleFilters_50_0= ruleModuleFilter ) )+ otherlv_51= RightCurlyBracket ) ) ) ) | ({...}? => ( ({...}? => ( (lv_testedProjects_52_0= ruleTestedProjects ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= ModuleLoader otherlv_54= Colon ( (lv_moduleLoader_55_0= ruleModuleLoader ) ) ) ) ) ) )+ {...}?)
            // InternalN4MFParser.g:78:5: ( ({...}? => ( ({...}? => (otherlv_1= ProjectId otherlv_2= Colon ( (lv_projectId_3_0= ruleN4mfIdentifier ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= ProjectType otherlv_5= Colon ( (lv_projectType_6_0= ruleProjectType ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ProjectVersion otherlv_8= Colon ( (lv_projectVersion_9_0= ruleDeclaredVersion ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= VendorId otherlv_11= Colon ( (lv_declaredVendorId_12_0= ruleN4mfIdentifier ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= VendorName otherlv_14= Colon ( (lv_vendorName_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= MainModule otherlv_17= Colon ( (lv_mainModule_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_extendedRuntimeEnvironment_19_0= ruleExtendedRuntimeEnvironment ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_providedRuntimeLibraries_20_0= ruleProvidedRuntimeLibraries ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_requiredRuntimeLibraries_21_0= ruleRequiredRuntimeLibraries ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_projectDependencies_22_0= ruleProjectDependencies ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= ImplementationId otherlv_24= Colon ( (lv_implementationId_25_0= ruleN4mfIdentifier ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_implementedProjects_26_0= ruleImplementedProjects ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_initModules_27_0= ruleInitModules ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_execModule_28_0= ruleExecModule ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_29= Output otherlv_30= Colon ( (lv_outputPath_31_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= Libraries otherlv_33= LeftCurlyBracket ( (lv_libraryPaths_34_0= RULE_STRING ) ) (otherlv_35= Comma ( (lv_libraryPaths_36_0= RULE_STRING ) ) )* otherlv_37= RightCurlyBracket ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= Resources otherlv_39= LeftCurlyBracket ( (lv_resourcePaths_40_0= RULE_STRING ) ) (otherlv_41= Comma ( (lv_resourcePaths_42_0= RULE_STRING ) ) )* otherlv_43= RightCurlyBracket ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= Sources otherlv_45= LeftCurlyBracket ( (lv_sourceFragment_46_0= ruleSourceFragment ) )+ otherlv_47= RightCurlyBracket ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= ModuleFilters otherlv_49= LeftCurlyBracket ( (lv_moduleFilters_50_0= ruleModuleFilter ) )+ otherlv_51= RightCurlyBracket ) ) ) ) | ({...}? => ( ({...}? => ( (lv_testedProjects_52_0= ruleTestedProjects ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= ModuleLoader otherlv_54= Colon ( (lv_moduleLoader_55_0= ruleModuleLoader ) ) ) ) ) ) )+ {...}?
            {
            // InternalN4MFParser.g:78:5: ( ({...}? => ( ({...}? => (otherlv_1= ProjectId otherlv_2= Colon ( (lv_projectId_3_0= ruleN4mfIdentifier ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= ProjectType otherlv_5= Colon ( (lv_projectType_6_0= ruleProjectType ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ProjectVersion otherlv_8= Colon ( (lv_projectVersion_9_0= ruleDeclaredVersion ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= VendorId otherlv_11= Colon ( (lv_declaredVendorId_12_0= ruleN4mfIdentifier ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= VendorName otherlv_14= Colon ( (lv_vendorName_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= MainModule otherlv_17= Colon ( (lv_mainModule_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_extendedRuntimeEnvironment_19_0= ruleExtendedRuntimeEnvironment ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_providedRuntimeLibraries_20_0= ruleProvidedRuntimeLibraries ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_requiredRuntimeLibraries_21_0= ruleRequiredRuntimeLibraries ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_projectDependencies_22_0= ruleProjectDependencies ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= ImplementationId otherlv_24= Colon ( (lv_implementationId_25_0= ruleN4mfIdentifier ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_implementedProjects_26_0= ruleImplementedProjects ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_initModules_27_0= ruleInitModules ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_execModule_28_0= ruleExecModule ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_29= Output otherlv_30= Colon ( (lv_outputPath_31_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= Libraries otherlv_33= LeftCurlyBracket ( (lv_libraryPaths_34_0= RULE_STRING ) ) (otherlv_35= Comma ( (lv_libraryPaths_36_0= RULE_STRING ) ) )* otherlv_37= RightCurlyBracket ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= Resources otherlv_39= LeftCurlyBracket ( (lv_resourcePaths_40_0= RULE_STRING ) ) (otherlv_41= Comma ( (lv_resourcePaths_42_0= RULE_STRING ) ) )* otherlv_43= RightCurlyBracket ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= Sources otherlv_45= LeftCurlyBracket ( (lv_sourceFragment_46_0= ruleSourceFragment ) )+ otherlv_47= RightCurlyBracket ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= ModuleFilters otherlv_49= LeftCurlyBracket ( (lv_moduleFilters_50_0= ruleModuleFilter ) )+ otherlv_51= RightCurlyBracket ) ) ) ) | ({...}? => ( ({...}? => ( (lv_testedProjects_52_0= ruleTestedProjects ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= ModuleLoader otherlv_54= Colon ( (lv_moduleLoader_55_0= ruleModuleLoader ) ) ) ) ) ) )+
            int cnt5=0;
            loop5:
            do {
                int alt5=22;
                alt5 = dfa5.predict(input);
                switch (alt5) {
            	case 1 :
            	    // InternalN4MFParser.g:79:3: ({...}? => ( ({...}? => (otherlv_1= ProjectId otherlv_2= Colon ( (lv_projectId_3_0= ruleN4mfIdentifier ) ) ) ) ) )
            	    {
            	    // InternalN4MFParser.g:79:3: ({...}? => ( ({...}? => (otherlv_1= ProjectId otherlv_2= Colon ( (lv_projectId_3_0= ruleN4mfIdentifier ) ) ) ) ) )
            	    // InternalN4MFParser.g:80:4: {...}? => ( ({...}? => (otherlv_1= ProjectId otherlv_2= Colon ( (lv_projectId_3_0= ruleN4mfIdentifier ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleProjectDescription", "getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 0)");
            	    }
            	    // InternalN4MFParser.g:80:112: ( ({...}? => (otherlv_1= ProjectId otherlv_2= Colon ( (lv_projectId_3_0= ruleN4mfIdentifier ) ) ) ) )
            	    // InternalN4MFParser.g:81:5: ({...}? => (otherlv_1= ProjectId otherlv_2= Colon ( (lv_projectId_3_0= ruleN4mfIdentifier ) ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 0);
            	    				
            	    // InternalN4MFParser.g:84:8: ({...}? => (otherlv_1= ProjectId otherlv_2= Colon ( (lv_projectId_3_0= ruleN4mfIdentifier ) ) ) )
            	    // InternalN4MFParser.g:84:9: {...}? => (otherlv_1= ProjectId otherlv_2= Colon ( (lv_projectId_3_0= ruleN4mfIdentifier ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleProjectDescription", "true");
            	    }
            	    // InternalN4MFParser.g:84:18: (otherlv_1= ProjectId otherlv_2= Colon ( (lv_projectId_3_0= ruleN4mfIdentifier ) ) )
            	    // InternalN4MFParser.g:84:19: otherlv_1= ProjectId otherlv_2= Colon ( (lv_projectId_3_0= ruleN4mfIdentifier ) )
            	    {
            	    otherlv_1=(Token)match(input,ProjectId,FOLLOW_3); 

            	    								newLeafNode(otherlv_1, grammarAccess.getProjectDescriptionAccess().getProjectIdKeyword_0_0());
            	    							
            	    otherlv_2=(Token)match(input,Colon,FOLLOW_4); 

            	    								newLeafNode(otherlv_2, grammarAccess.getProjectDescriptionAccess().getColonKeyword_0_1());
            	    							
            	    // InternalN4MFParser.g:92:8: ( (lv_projectId_3_0= ruleN4mfIdentifier ) )
            	    // InternalN4MFParser.g:93:9: (lv_projectId_3_0= ruleN4mfIdentifier )
            	    {
            	    // InternalN4MFParser.g:93:9: (lv_projectId_3_0= ruleN4mfIdentifier )
            	    // InternalN4MFParser.g:94:10: lv_projectId_3_0= ruleN4mfIdentifier
            	    {

            	    										newCompositeNode(grammarAccess.getProjectDescriptionAccess().getProjectIdN4mfIdentifierParserRuleCall_0_2_0());
            	    									
            	    pushFollow(FOLLOW_5);
            	    lv_projectId_3_0=ruleN4mfIdentifier();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getProjectDescriptionRule());
            	    										}
            	    										set(
            	    											current,
            	    											"projectId",
            	    											lv_projectId_3_0,
            	    											"eu.numberfour.n4js.n4mf.N4MF.N4mfIdentifier");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalN4MFParser.g:117:3: ({...}? => ( ({...}? => (otherlv_4= ProjectType otherlv_5= Colon ( (lv_projectType_6_0= ruleProjectType ) ) ) ) ) )
            	    {
            	    // InternalN4MFParser.g:117:3: ({...}? => ( ({...}? => (otherlv_4= ProjectType otherlv_5= Colon ( (lv_projectType_6_0= ruleProjectType ) ) ) ) ) )
            	    // InternalN4MFParser.g:118:4: {...}? => ( ({...}? => (otherlv_4= ProjectType otherlv_5= Colon ( (lv_projectType_6_0= ruleProjectType ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleProjectDescription", "getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 1)");
            	    }
            	    // InternalN4MFParser.g:118:112: ( ({...}? => (otherlv_4= ProjectType otherlv_5= Colon ( (lv_projectType_6_0= ruleProjectType ) ) ) ) )
            	    // InternalN4MFParser.g:119:5: ({...}? => (otherlv_4= ProjectType otherlv_5= Colon ( (lv_projectType_6_0= ruleProjectType ) ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 1);
            	    				
            	    // InternalN4MFParser.g:122:8: ({...}? => (otherlv_4= ProjectType otherlv_5= Colon ( (lv_projectType_6_0= ruleProjectType ) ) ) )
            	    // InternalN4MFParser.g:122:9: {...}? => (otherlv_4= ProjectType otherlv_5= Colon ( (lv_projectType_6_0= ruleProjectType ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleProjectDescription", "true");
            	    }
            	    // InternalN4MFParser.g:122:18: (otherlv_4= ProjectType otherlv_5= Colon ( (lv_projectType_6_0= ruleProjectType ) ) )
            	    // InternalN4MFParser.g:122:19: otherlv_4= ProjectType otherlv_5= Colon ( (lv_projectType_6_0= ruleProjectType ) )
            	    {
            	    otherlv_4=(Token)match(input,ProjectType,FOLLOW_3); 

            	    								newLeafNode(otherlv_4, grammarAccess.getProjectDescriptionAccess().getProjectTypeKeyword_1_0());
            	    							
            	    otherlv_5=(Token)match(input,Colon,FOLLOW_6); 

            	    								newLeafNode(otherlv_5, grammarAccess.getProjectDescriptionAccess().getColonKeyword_1_1());
            	    							
            	    // InternalN4MFParser.g:130:8: ( (lv_projectType_6_0= ruleProjectType ) )
            	    // InternalN4MFParser.g:131:9: (lv_projectType_6_0= ruleProjectType )
            	    {
            	    // InternalN4MFParser.g:131:9: (lv_projectType_6_0= ruleProjectType )
            	    // InternalN4MFParser.g:132:10: lv_projectType_6_0= ruleProjectType
            	    {

            	    										newCompositeNode(grammarAccess.getProjectDescriptionAccess().getProjectTypeProjectTypeEnumRuleCall_1_2_0());
            	    									
            	    pushFollow(FOLLOW_5);
            	    lv_projectType_6_0=ruleProjectType();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getProjectDescriptionRule());
            	    										}
            	    										set(
            	    											current,
            	    											"projectType",
            	    											lv_projectType_6_0,
            	    											"eu.numberfour.n4js.n4mf.N4MF.ProjectType");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalN4MFParser.g:155:3: ({...}? => ( ({...}? => (otherlv_7= ProjectVersion otherlv_8= Colon ( (lv_projectVersion_9_0= ruleDeclaredVersion ) ) ) ) ) )
            	    {
            	    // InternalN4MFParser.g:155:3: ({...}? => ( ({...}? => (otherlv_7= ProjectVersion otherlv_8= Colon ( (lv_projectVersion_9_0= ruleDeclaredVersion ) ) ) ) ) )
            	    // InternalN4MFParser.g:156:4: {...}? => ( ({...}? => (otherlv_7= ProjectVersion otherlv_8= Colon ( (lv_projectVersion_9_0= ruleDeclaredVersion ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleProjectDescription", "getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 2)");
            	    }
            	    // InternalN4MFParser.g:156:112: ( ({...}? => (otherlv_7= ProjectVersion otherlv_8= Colon ( (lv_projectVersion_9_0= ruleDeclaredVersion ) ) ) ) )
            	    // InternalN4MFParser.g:157:5: ({...}? => (otherlv_7= ProjectVersion otherlv_8= Colon ( (lv_projectVersion_9_0= ruleDeclaredVersion ) ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 2);
            	    				
            	    // InternalN4MFParser.g:160:8: ({...}? => (otherlv_7= ProjectVersion otherlv_8= Colon ( (lv_projectVersion_9_0= ruleDeclaredVersion ) ) ) )
            	    // InternalN4MFParser.g:160:9: {...}? => (otherlv_7= ProjectVersion otherlv_8= Colon ( (lv_projectVersion_9_0= ruleDeclaredVersion ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleProjectDescription", "true");
            	    }
            	    // InternalN4MFParser.g:160:18: (otherlv_7= ProjectVersion otherlv_8= Colon ( (lv_projectVersion_9_0= ruleDeclaredVersion ) ) )
            	    // InternalN4MFParser.g:160:19: otherlv_7= ProjectVersion otherlv_8= Colon ( (lv_projectVersion_9_0= ruleDeclaredVersion ) )
            	    {
            	    otherlv_7=(Token)match(input,ProjectVersion,FOLLOW_3); 

            	    								newLeafNode(otherlv_7, grammarAccess.getProjectDescriptionAccess().getProjectVersionKeyword_2_0());
            	    							
            	    otherlv_8=(Token)match(input,Colon,FOLLOW_7); 

            	    								newLeafNode(otherlv_8, grammarAccess.getProjectDescriptionAccess().getColonKeyword_2_1());
            	    							
            	    // InternalN4MFParser.g:168:8: ( (lv_projectVersion_9_0= ruleDeclaredVersion ) )
            	    // InternalN4MFParser.g:169:9: (lv_projectVersion_9_0= ruleDeclaredVersion )
            	    {
            	    // InternalN4MFParser.g:169:9: (lv_projectVersion_9_0= ruleDeclaredVersion )
            	    // InternalN4MFParser.g:170:10: lv_projectVersion_9_0= ruleDeclaredVersion
            	    {

            	    										newCompositeNode(grammarAccess.getProjectDescriptionAccess().getProjectVersionDeclaredVersionParserRuleCall_2_2_0());
            	    									
            	    pushFollow(FOLLOW_5);
            	    lv_projectVersion_9_0=ruleDeclaredVersion();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getProjectDescriptionRule());
            	    										}
            	    										set(
            	    											current,
            	    											"projectVersion",
            	    											lv_projectVersion_9_0,
            	    											"eu.numberfour.n4js.n4mf.N4MF.DeclaredVersion");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalN4MFParser.g:193:3: ({...}? => ( ({...}? => (otherlv_10= VendorId otherlv_11= Colon ( (lv_declaredVendorId_12_0= ruleN4mfIdentifier ) ) ) ) ) )
            	    {
            	    // InternalN4MFParser.g:193:3: ({...}? => ( ({...}? => (otherlv_10= VendorId otherlv_11= Colon ( (lv_declaredVendorId_12_0= ruleN4mfIdentifier ) ) ) ) ) )
            	    // InternalN4MFParser.g:194:4: {...}? => ( ({...}? => (otherlv_10= VendorId otherlv_11= Colon ( (lv_declaredVendorId_12_0= ruleN4mfIdentifier ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleProjectDescription", "getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 3)");
            	    }
            	    // InternalN4MFParser.g:194:112: ( ({...}? => (otherlv_10= VendorId otherlv_11= Colon ( (lv_declaredVendorId_12_0= ruleN4mfIdentifier ) ) ) ) )
            	    // InternalN4MFParser.g:195:5: ({...}? => (otherlv_10= VendorId otherlv_11= Colon ( (lv_declaredVendorId_12_0= ruleN4mfIdentifier ) ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 3);
            	    				
            	    // InternalN4MFParser.g:198:8: ({...}? => (otherlv_10= VendorId otherlv_11= Colon ( (lv_declaredVendorId_12_0= ruleN4mfIdentifier ) ) ) )
            	    // InternalN4MFParser.g:198:9: {...}? => (otherlv_10= VendorId otherlv_11= Colon ( (lv_declaredVendorId_12_0= ruleN4mfIdentifier ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleProjectDescription", "true");
            	    }
            	    // InternalN4MFParser.g:198:18: (otherlv_10= VendorId otherlv_11= Colon ( (lv_declaredVendorId_12_0= ruleN4mfIdentifier ) ) )
            	    // InternalN4MFParser.g:198:19: otherlv_10= VendorId otherlv_11= Colon ( (lv_declaredVendorId_12_0= ruleN4mfIdentifier ) )
            	    {
            	    otherlv_10=(Token)match(input,VendorId,FOLLOW_3); 

            	    								newLeafNode(otherlv_10, grammarAccess.getProjectDescriptionAccess().getVendorIdKeyword_3_0());
            	    							
            	    otherlv_11=(Token)match(input,Colon,FOLLOW_4); 

            	    								newLeafNode(otherlv_11, grammarAccess.getProjectDescriptionAccess().getColonKeyword_3_1());
            	    							
            	    // InternalN4MFParser.g:206:8: ( (lv_declaredVendorId_12_0= ruleN4mfIdentifier ) )
            	    // InternalN4MFParser.g:207:9: (lv_declaredVendorId_12_0= ruleN4mfIdentifier )
            	    {
            	    // InternalN4MFParser.g:207:9: (lv_declaredVendorId_12_0= ruleN4mfIdentifier )
            	    // InternalN4MFParser.g:208:10: lv_declaredVendorId_12_0= ruleN4mfIdentifier
            	    {

            	    										newCompositeNode(grammarAccess.getProjectDescriptionAccess().getDeclaredVendorIdN4mfIdentifierParserRuleCall_3_2_0());
            	    									
            	    pushFollow(FOLLOW_5);
            	    lv_declaredVendorId_12_0=ruleN4mfIdentifier();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getProjectDescriptionRule());
            	    										}
            	    										set(
            	    											current,
            	    											"declaredVendorId",
            	    											lv_declaredVendorId_12_0,
            	    											"eu.numberfour.n4js.n4mf.N4MF.N4mfIdentifier");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalN4MFParser.g:231:3: ({...}? => ( ({...}? => (otherlv_13= VendorName otherlv_14= Colon ( (lv_vendorName_15_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalN4MFParser.g:231:3: ({...}? => ( ({...}? => (otherlv_13= VendorName otherlv_14= Colon ( (lv_vendorName_15_0= RULE_STRING ) ) ) ) ) )
            	    // InternalN4MFParser.g:232:4: {...}? => ( ({...}? => (otherlv_13= VendorName otherlv_14= Colon ( (lv_vendorName_15_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleProjectDescription", "getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 4)");
            	    }
            	    // InternalN4MFParser.g:232:112: ( ({...}? => (otherlv_13= VendorName otherlv_14= Colon ( (lv_vendorName_15_0= RULE_STRING ) ) ) ) )
            	    // InternalN4MFParser.g:233:5: ({...}? => (otherlv_13= VendorName otherlv_14= Colon ( (lv_vendorName_15_0= RULE_STRING ) ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 4);
            	    				
            	    // InternalN4MFParser.g:236:8: ({...}? => (otherlv_13= VendorName otherlv_14= Colon ( (lv_vendorName_15_0= RULE_STRING ) ) ) )
            	    // InternalN4MFParser.g:236:9: {...}? => (otherlv_13= VendorName otherlv_14= Colon ( (lv_vendorName_15_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleProjectDescription", "true");
            	    }
            	    // InternalN4MFParser.g:236:18: (otherlv_13= VendorName otherlv_14= Colon ( (lv_vendorName_15_0= RULE_STRING ) ) )
            	    // InternalN4MFParser.g:236:19: otherlv_13= VendorName otherlv_14= Colon ( (lv_vendorName_15_0= RULE_STRING ) )
            	    {
            	    otherlv_13=(Token)match(input,VendorName,FOLLOW_3); 

            	    								newLeafNode(otherlv_13, grammarAccess.getProjectDescriptionAccess().getVendorNameKeyword_4_0());
            	    							
            	    otherlv_14=(Token)match(input,Colon,FOLLOW_8); 

            	    								newLeafNode(otherlv_14, grammarAccess.getProjectDescriptionAccess().getColonKeyword_4_1());
            	    							
            	    // InternalN4MFParser.g:244:8: ( (lv_vendorName_15_0= RULE_STRING ) )
            	    // InternalN4MFParser.g:245:9: (lv_vendorName_15_0= RULE_STRING )
            	    {
            	    // InternalN4MFParser.g:245:9: (lv_vendorName_15_0= RULE_STRING )
            	    // InternalN4MFParser.g:246:10: lv_vendorName_15_0= RULE_STRING
            	    {
            	    lv_vendorName_15_0=(Token)match(input,RULE_STRING,FOLLOW_5); 

            	    										newLeafNode(lv_vendorName_15_0, grammarAccess.getProjectDescriptionAccess().getVendorNameSTRINGTerminalRuleCall_4_2_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getProjectDescriptionRule());
            	    										}
            	    										setWithLastConsumed(
            	    											current,
            	    											"vendorName",
            	    											lv_vendorName_15_0,
            	    											"org.eclipse.xtext.common.Terminals.STRING");
            	    									

            	    }


            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalN4MFParser.g:268:3: ({...}? => ( ({...}? => (otherlv_16= MainModule otherlv_17= Colon ( (lv_mainModule_18_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalN4MFParser.g:268:3: ({...}? => ( ({...}? => (otherlv_16= MainModule otherlv_17= Colon ( (lv_mainModule_18_0= RULE_STRING ) ) ) ) ) )
            	    // InternalN4MFParser.g:269:4: {...}? => ( ({...}? => (otherlv_16= MainModule otherlv_17= Colon ( (lv_mainModule_18_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleProjectDescription", "getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 5)");
            	    }
            	    // InternalN4MFParser.g:269:112: ( ({...}? => (otherlv_16= MainModule otherlv_17= Colon ( (lv_mainModule_18_0= RULE_STRING ) ) ) ) )
            	    // InternalN4MFParser.g:270:5: ({...}? => (otherlv_16= MainModule otherlv_17= Colon ( (lv_mainModule_18_0= RULE_STRING ) ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 5);
            	    				
            	    // InternalN4MFParser.g:273:8: ({...}? => (otherlv_16= MainModule otherlv_17= Colon ( (lv_mainModule_18_0= RULE_STRING ) ) ) )
            	    // InternalN4MFParser.g:273:9: {...}? => (otherlv_16= MainModule otherlv_17= Colon ( (lv_mainModule_18_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleProjectDescription", "true");
            	    }
            	    // InternalN4MFParser.g:273:18: (otherlv_16= MainModule otherlv_17= Colon ( (lv_mainModule_18_0= RULE_STRING ) ) )
            	    // InternalN4MFParser.g:273:19: otherlv_16= MainModule otherlv_17= Colon ( (lv_mainModule_18_0= RULE_STRING ) )
            	    {
            	    otherlv_16=(Token)match(input,MainModule,FOLLOW_3); 

            	    								newLeafNode(otherlv_16, grammarAccess.getProjectDescriptionAccess().getMainModuleKeyword_5_0());
            	    							
            	    otherlv_17=(Token)match(input,Colon,FOLLOW_8); 

            	    								newLeafNode(otherlv_17, grammarAccess.getProjectDescriptionAccess().getColonKeyword_5_1());
            	    							
            	    // InternalN4MFParser.g:281:8: ( (lv_mainModule_18_0= RULE_STRING ) )
            	    // InternalN4MFParser.g:282:9: (lv_mainModule_18_0= RULE_STRING )
            	    {
            	    // InternalN4MFParser.g:282:9: (lv_mainModule_18_0= RULE_STRING )
            	    // InternalN4MFParser.g:283:10: lv_mainModule_18_0= RULE_STRING
            	    {
            	    lv_mainModule_18_0=(Token)match(input,RULE_STRING,FOLLOW_5); 

            	    										newLeafNode(lv_mainModule_18_0, grammarAccess.getProjectDescriptionAccess().getMainModuleSTRINGTerminalRuleCall_5_2_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getProjectDescriptionRule());
            	    										}
            	    										setWithLastConsumed(
            	    											current,
            	    											"mainModule",
            	    											lv_mainModule_18_0,
            	    											"org.eclipse.xtext.common.Terminals.STRING");
            	    									

            	    }


            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // InternalN4MFParser.g:305:3: ({...}? => ( ({...}? => ( (lv_extendedRuntimeEnvironment_19_0= ruleExtendedRuntimeEnvironment ) ) ) ) )
            	    {
            	    // InternalN4MFParser.g:305:3: ({...}? => ( ({...}? => ( (lv_extendedRuntimeEnvironment_19_0= ruleExtendedRuntimeEnvironment ) ) ) ) )
            	    // InternalN4MFParser.g:306:4: {...}? => ( ({...}? => ( (lv_extendedRuntimeEnvironment_19_0= ruleExtendedRuntimeEnvironment ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleProjectDescription", "getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 6)");
            	    }
            	    // InternalN4MFParser.g:306:112: ( ({...}? => ( (lv_extendedRuntimeEnvironment_19_0= ruleExtendedRuntimeEnvironment ) ) ) )
            	    // InternalN4MFParser.g:307:5: ({...}? => ( (lv_extendedRuntimeEnvironment_19_0= ruleExtendedRuntimeEnvironment ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 6);
            	    				
            	    // InternalN4MFParser.g:310:8: ({...}? => ( (lv_extendedRuntimeEnvironment_19_0= ruleExtendedRuntimeEnvironment ) ) )
            	    // InternalN4MFParser.g:310:9: {...}? => ( (lv_extendedRuntimeEnvironment_19_0= ruleExtendedRuntimeEnvironment ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleProjectDescription", "true");
            	    }
            	    // InternalN4MFParser.g:310:18: ( (lv_extendedRuntimeEnvironment_19_0= ruleExtendedRuntimeEnvironment ) )
            	    // InternalN4MFParser.g:310:19: (lv_extendedRuntimeEnvironment_19_0= ruleExtendedRuntimeEnvironment )
            	    {
            	    // InternalN4MFParser.g:310:19: (lv_extendedRuntimeEnvironment_19_0= ruleExtendedRuntimeEnvironment )
            	    // InternalN4MFParser.g:311:9: lv_extendedRuntimeEnvironment_19_0= ruleExtendedRuntimeEnvironment
            	    {

            	    									newCompositeNode(grammarAccess.getProjectDescriptionAccess().getExtendedRuntimeEnvironmentExtendedRuntimeEnvironmentParserRuleCall_6_0());
            	    								
            	    pushFollow(FOLLOW_5);
            	    lv_extendedRuntimeEnvironment_19_0=ruleExtendedRuntimeEnvironment();

            	    state._fsp--;


            	    									if (current==null) {
            	    										current = createModelElementForParent(grammarAccess.getProjectDescriptionRule());
            	    									}
            	    									set(
            	    										current,
            	    										"extendedRuntimeEnvironment",
            	    										lv_extendedRuntimeEnvironment_19_0,
            	    										"eu.numberfour.n4js.n4mf.N4MF.ExtendedRuntimeEnvironment");
            	    									afterParserOrEnumRuleCall();
            	    								

            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // InternalN4MFParser.g:333:3: ({...}? => ( ({...}? => ( (lv_providedRuntimeLibraries_20_0= ruleProvidedRuntimeLibraries ) ) ) ) )
            	    {
            	    // InternalN4MFParser.g:333:3: ({...}? => ( ({...}? => ( (lv_providedRuntimeLibraries_20_0= ruleProvidedRuntimeLibraries ) ) ) ) )
            	    // InternalN4MFParser.g:334:4: {...}? => ( ({...}? => ( (lv_providedRuntimeLibraries_20_0= ruleProvidedRuntimeLibraries ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 7) ) {
            	        throw new FailedPredicateException(input, "ruleProjectDescription", "getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 7)");
            	    }
            	    // InternalN4MFParser.g:334:112: ( ({...}? => ( (lv_providedRuntimeLibraries_20_0= ruleProvidedRuntimeLibraries ) ) ) )
            	    // InternalN4MFParser.g:335:5: ({...}? => ( (lv_providedRuntimeLibraries_20_0= ruleProvidedRuntimeLibraries ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 7);
            	    				
            	    // InternalN4MFParser.g:338:8: ({...}? => ( (lv_providedRuntimeLibraries_20_0= ruleProvidedRuntimeLibraries ) ) )
            	    // InternalN4MFParser.g:338:9: {...}? => ( (lv_providedRuntimeLibraries_20_0= ruleProvidedRuntimeLibraries ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleProjectDescription", "true");
            	    }
            	    // InternalN4MFParser.g:338:18: ( (lv_providedRuntimeLibraries_20_0= ruleProvidedRuntimeLibraries ) )
            	    // InternalN4MFParser.g:338:19: (lv_providedRuntimeLibraries_20_0= ruleProvidedRuntimeLibraries )
            	    {
            	    // InternalN4MFParser.g:338:19: (lv_providedRuntimeLibraries_20_0= ruleProvidedRuntimeLibraries )
            	    // InternalN4MFParser.g:339:9: lv_providedRuntimeLibraries_20_0= ruleProvidedRuntimeLibraries
            	    {

            	    									newCompositeNode(grammarAccess.getProjectDescriptionAccess().getProvidedRuntimeLibrariesProvidedRuntimeLibrariesParserRuleCall_7_0());
            	    								
            	    pushFollow(FOLLOW_5);
            	    lv_providedRuntimeLibraries_20_0=ruleProvidedRuntimeLibraries();

            	    state._fsp--;


            	    									if (current==null) {
            	    										current = createModelElementForParent(grammarAccess.getProjectDescriptionRule());
            	    									}
            	    									set(
            	    										current,
            	    										"providedRuntimeLibraries",
            	    										lv_providedRuntimeLibraries_20_0,
            	    										"eu.numberfour.n4js.n4mf.N4MF.ProvidedRuntimeLibraries");
            	    									afterParserOrEnumRuleCall();
            	    								

            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 9 :
            	    // InternalN4MFParser.g:361:3: ({...}? => ( ({...}? => ( (lv_requiredRuntimeLibraries_21_0= ruleRequiredRuntimeLibraries ) ) ) ) )
            	    {
            	    // InternalN4MFParser.g:361:3: ({...}? => ( ({...}? => ( (lv_requiredRuntimeLibraries_21_0= ruleRequiredRuntimeLibraries ) ) ) ) )
            	    // InternalN4MFParser.g:362:4: {...}? => ( ({...}? => ( (lv_requiredRuntimeLibraries_21_0= ruleRequiredRuntimeLibraries ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 8) ) {
            	        throw new FailedPredicateException(input, "ruleProjectDescription", "getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 8)");
            	    }
            	    // InternalN4MFParser.g:362:112: ( ({...}? => ( (lv_requiredRuntimeLibraries_21_0= ruleRequiredRuntimeLibraries ) ) ) )
            	    // InternalN4MFParser.g:363:5: ({...}? => ( (lv_requiredRuntimeLibraries_21_0= ruleRequiredRuntimeLibraries ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 8);
            	    				
            	    // InternalN4MFParser.g:366:8: ({...}? => ( (lv_requiredRuntimeLibraries_21_0= ruleRequiredRuntimeLibraries ) ) )
            	    // InternalN4MFParser.g:366:9: {...}? => ( (lv_requiredRuntimeLibraries_21_0= ruleRequiredRuntimeLibraries ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleProjectDescription", "true");
            	    }
            	    // InternalN4MFParser.g:366:18: ( (lv_requiredRuntimeLibraries_21_0= ruleRequiredRuntimeLibraries ) )
            	    // InternalN4MFParser.g:366:19: (lv_requiredRuntimeLibraries_21_0= ruleRequiredRuntimeLibraries )
            	    {
            	    // InternalN4MFParser.g:366:19: (lv_requiredRuntimeLibraries_21_0= ruleRequiredRuntimeLibraries )
            	    // InternalN4MFParser.g:367:9: lv_requiredRuntimeLibraries_21_0= ruleRequiredRuntimeLibraries
            	    {

            	    									newCompositeNode(grammarAccess.getProjectDescriptionAccess().getRequiredRuntimeLibrariesRequiredRuntimeLibrariesParserRuleCall_8_0());
            	    								
            	    pushFollow(FOLLOW_5);
            	    lv_requiredRuntimeLibraries_21_0=ruleRequiredRuntimeLibraries();

            	    state._fsp--;


            	    									if (current==null) {
            	    										current = createModelElementForParent(grammarAccess.getProjectDescriptionRule());
            	    									}
            	    									set(
            	    										current,
            	    										"requiredRuntimeLibraries",
            	    										lv_requiredRuntimeLibraries_21_0,
            	    										"eu.numberfour.n4js.n4mf.N4MF.RequiredRuntimeLibraries");
            	    									afterParserOrEnumRuleCall();
            	    								

            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 10 :
            	    // InternalN4MFParser.g:389:3: ({...}? => ( ({...}? => ( (lv_projectDependencies_22_0= ruleProjectDependencies ) ) ) ) )
            	    {
            	    // InternalN4MFParser.g:389:3: ({...}? => ( ({...}? => ( (lv_projectDependencies_22_0= ruleProjectDependencies ) ) ) ) )
            	    // InternalN4MFParser.g:390:4: {...}? => ( ({...}? => ( (lv_projectDependencies_22_0= ruleProjectDependencies ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 9) ) {
            	        throw new FailedPredicateException(input, "ruleProjectDescription", "getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 9)");
            	    }
            	    // InternalN4MFParser.g:390:112: ( ({...}? => ( (lv_projectDependencies_22_0= ruleProjectDependencies ) ) ) )
            	    // InternalN4MFParser.g:391:5: ({...}? => ( (lv_projectDependencies_22_0= ruleProjectDependencies ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 9);
            	    				
            	    // InternalN4MFParser.g:394:8: ({...}? => ( (lv_projectDependencies_22_0= ruleProjectDependencies ) ) )
            	    // InternalN4MFParser.g:394:9: {...}? => ( (lv_projectDependencies_22_0= ruleProjectDependencies ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleProjectDescription", "true");
            	    }
            	    // InternalN4MFParser.g:394:18: ( (lv_projectDependencies_22_0= ruleProjectDependencies ) )
            	    // InternalN4MFParser.g:394:19: (lv_projectDependencies_22_0= ruleProjectDependencies )
            	    {
            	    // InternalN4MFParser.g:394:19: (lv_projectDependencies_22_0= ruleProjectDependencies )
            	    // InternalN4MFParser.g:395:9: lv_projectDependencies_22_0= ruleProjectDependencies
            	    {

            	    									newCompositeNode(grammarAccess.getProjectDescriptionAccess().getProjectDependenciesProjectDependenciesParserRuleCall_9_0());
            	    								
            	    pushFollow(FOLLOW_5);
            	    lv_projectDependencies_22_0=ruleProjectDependencies();

            	    state._fsp--;


            	    									if (current==null) {
            	    										current = createModelElementForParent(grammarAccess.getProjectDescriptionRule());
            	    									}
            	    									set(
            	    										current,
            	    										"projectDependencies",
            	    										lv_projectDependencies_22_0,
            	    										"eu.numberfour.n4js.n4mf.N4MF.ProjectDependencies");
            	    									afterParserOrEnumRuleCall();
            	    								

            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 11 :
            	    // InternalN4MFParser.g:417:3: ({...}? => ( ({...}? => (otherlv_23= ImplementationId otherlv_24= Colon ( (lv_implementationId_25_0= ruleN4mfIdentifier ) ) ) ) ) )
            	    {
            	    // InternalN4MFParser.g:417:3: ({...}? => ( ({...}? => (otherlv_23= ImplementationId otherlv_24= Colon ( (lv_implementationId_25_0= ruleN4mfIdentifier ) ) ) ) ) )
            	    // InternalN4MFParser.g:418:4: {...}? => ( ({...}? => (otherlv_23= ImplementationId otherlv_24= Colon ( (lv_implementationId_25_0= ruleN4mfIdentifier ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 10) ) {
            	        throw new FailedPredicateException(input, "ruleProjectDescription", "getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 10)");
            	    }
            	    // InternalN4MFParser.g:418:113: ( ({...}? => (otherlv_23= ImplementationId otherlv_24= Colon ( (lv_implementationId_25_0= ruleN4mfIdentifier ) ) ) ) )
            	    // InternalN4MFParser.g:419:5: ({...}? => (otherlv_23= ImplementationId otherlv_24= Colon ( (lv_implementationId_25_0= ruleN4mfIdentifier ) ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 10);
            	    				
            	    // InternalN4MFParser.g:422:8: ({...}? => (otherlv_23= ImplementationId otherlv_24= Colon ( (lv_implementationId_25_0= ruleN4mfIdentifier ) ) ) )
            	    // InternalN4MFParser.g:422:9: {...}? => (otherlv_23= ImplementationId otherlv_24= Colon ( (lv_implementationId_25_0= ruleN4mfIdentifier ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleProjectDescription", "true");
            	    }
            	    // InternalN4MFParser.g:422:18: (otherlv_23= ImplementationId otherlv_24= Colon ( (lv_implementationId_25_0= ruleN4mfIdentifier ) ) )
            	    // InternalN4MFParser.g:422:19: otherlv_23= ImplementationId otherlv_24= Colon ( (lv_implementationId_25_0= ruleN4mfIdentifier ) )
            	    {
            	    otherlv_23=(Token)match(input,ImplementationId,FOLLOW_3); 

            	    								newLeafNode(otherlv_23, grammarAccess.getProjectDescriptionAccess().getImplementationIdKeyword_10_0());
            	    							
            	    otherlv_24=(Token)match(input,Colon,FOLLOW_4); 

            	    								newLeafNode(otherlv_24, grammarAccess.getProjectDescriptionAccess().getColonKeyword_10_1());
            	    							
            	    // InternalN4MFParser.g:430:8: ( (lv_implementationId_25_0= ruleN4mfIdentifier ) )
            	    // InternalN4MFParser.g:431:9: (lv_implementationId_25_0= ruleN4mfIdentifier )
            	    {
            	    // InternalN4MFParser.g:431:9: (lv_implementationId_25_0= ruleN4mfIdentifier )
            	    // InternalN4MFParser.g:432:10: lv_implementationId_25_0= ruleN4mfIdentifier
            	    {

            	    										newCompositeNode(grammarAccess.getProjectDescriptionAccess().getImplementationIdN4mfIdentifierParserRuleCall_10_2_0());
            	    									
            	    pushFollow(FOLLOW_5);
            	    lv_implementationId_25_0=ruleN4mfIdentifier();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getProjectDescriptionRule());
            	    										}
            	    										set(
            	    											current,
            	    											"implementationId",
            	    											lv_implementationId_25_0,
            	    											"eu.numberfour.n4js.n4mf.N4MF.N4mfIdentifier");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 12 :
            	    // InternalN4MFParser.g:455:3: ({...}? => ( ({...}? => ( (lv_implementedProjects_26_0= ruleImplementedProjects ) ) ) ) )
            	    {
            	    // InternalN4MFParser.g:455:3: ({...}? => ( ({...}? => ( (lv_implementedProjects_26_0= ruleImplementedProjects ) ) ) ) )
            	    // InternalN4MFParser.g:456:4: {...}? => ( ({...}? => ( (lv_implementedProjects_26_0= ruleImplementedProjects ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 11) ) {
            	        throw new FailedPredicateException(input, "ruleProjectDescription", "getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 11)");
            	    }
            	    // InternalN4MFParser.g:456:113: ( ({...}? => ( (lv_implementedProjects_26_0= ruleImplementedProjects ) ) ) )
            	    // InternalN4MFParser.g:457:5: ({...}? => ( (lv_implementedProjects_26_0= ruleImplementedProjects ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 11);
            	    				
            	    // InternalN4MFParser.g:460:8: ({...}? => ( (lv_implementedProjects_26_0= ruleImplementedProjects ) ) )
            	    // InternalN4MFParser.g:460:9: {...}? => ( (lv_implementedProjects_26_0= ruleImplementedProjects ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleProjectDescription", "true");
            	    }
            	    // InternalN4MFParser.g:460:18: ( (lv_implementedProjects_26_0= ruleImplementedProjects ) )
            	    // InternalN4MFParser.g:460:19: (lv_implementedProjects_26_0= ruleImplementedProjects )
            	    {
            	    // InternalN4MFParser.g:460:19: (lv_implementedProjects_26_0= ruleImplementedProjects )
            	    // InternalN4MFParser.g:461:9: lv_implementedProjects_26_0= ruleImplementedProjects
            	    {

            	    									newCompositeNode(grammarAccess.getProjectDescriptionAccess().getImplementedProjectsImplementedProjectsParserRuleCall_11_0());
            	    								
            	    pushFollow(FOLLOW_5);
            	    lv_implementedProjects_26_0=ruleImplementedProjects();

            	    state._fsp--;


            	    									if (current==null) {
            	    										current = createModelElementForParent(grammarAccess.getProjectDescriptionRule());
            	    									}
            	    									set(
            	    										current,
            	    										"implementedProjects",
            	    										lv_implementedProjects_26_0,
            	    										"eu.numberfour.n4js.n4mf.N4MF.ImplementedProjects");
            	    									afterParserOrEnumRuleCall();
            	    								

            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 13 :
            	    // InternalN4MFParser.g:483:3: ({...}? => ( ({...}? => ( (lv_initModules_27_0= ruleInitModules ) ) ) ) )
            	    {
            	    // InternalN4MFParser.g:483:3: ({...}? => ( ({...}? => ( (lv_initModules_27_0= ruleInitModules ) ) ) ) )
            	    // InternalN4MFParser.g:484:4: {...}? => ( ({...}? => ( (lv_initModules_27_0= ruleInitModules ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 12) ) {
            	        throw new FailedPredicateException(input, "ruleProjectDescription", "getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 12)");
            	    }
            	    // InternalN4MFParser.g:484:113: ( ({...}? => ( (lv_initModules_27_0= ruleInitModules ) ) ) )
            	    // InternalN4MFParser.g:485:5: ({...}? => ( (lv_initModules_27_0= ruleInitModules ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 12);
            	    				
            	    // InternalN4MFParser.g:488:8: ({...}? => ( (lv_initModules_27_0= ruleInitModules ) ) )
            	    // InternalN4MFParser.g:488:9: {...}? => ( (lv_initModules_27_0= ruleInitModules ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleProjectDescription", "true");
            	    }
            	    // InternalN4MFParser.g:488:18: ( (lv_initModules_27_0= ruleInitModules ) )
            	    // InternalN4MFParser.g:488:19: (lv_initModules_27_0= ruleInitModules )
            	    {
            	    // InternalN4MFParser.g:488:19: (lv_initModules_27_0= ruleInitModules )
            	    // InternalN4MFParser.g:489:9: lv_initModules_27_0= ruleInitModules
            	    {

            	    									newCompositeNode(grammarAccess.getProjectDescriptionAccess().getInitModulesInitModulesParserRuleCall_12_0());
            	    								
            	    pushFollow(FOLLOW_5);
            	    lv_initModules_27_0=ruleInitModules();

            	    state._fsp--;


            	    									if (current==null) {
            	    										current = createModelElementForParent(grammarAccess.getProjectDescriptionRule());
            	    									}
            	    									set(
            	    										current,
            	    										"initModules",
            	    										lv_initModules_27_0,
            	    										"eu.numberfour.n4js.n4mf.N4MF.InitModules");
            	    									afterParserOrEnumRuleCall();
            	    								

            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 14 :
            	    // InternalN4MFParser.g:511:3: ({...}? => ( ({...}? => ( (lv_execModule_28_0= ruleExecModule ) ) ) ) )
            	    {
            	    // InternalN4MFParser.g:511:3: ({...}? => ( ({...}? => ( (lv_execModule_28_0= ruleExecModule ) ) ) ) )
            	    // InternalN4MFParser.g:512:4: {...}? => ( ({...}? => ( (lv_execModule_28_0= ruleExecModule ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 13) ) {
            	        throw new FailedPredicateException(input, "ruleProjectDescription", "getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 13)");
            	    }
            	    // InternalN4MFParser.g:512:113: ( ({...}? => ( (lv_execModule_28_0= ruleExecModule ) ) ) )
            	    // InternalN4MFParser.g:513:5: ({...}? => ( (lv_execModule_28_0= ruleExecModule ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 13);
            	    				
            	    // InternalN4MFParser.g:516:8: ({...}? => ( (lv_execModule_28_0= ruleExecModule ) ) )
            	    // InternalN4MFParser.g:516:9: {...}? => ( (lv_execModule_28_0= ruleExecModule ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleProjectDescription", "true");
            	    }
            	    // InternalN4MFParser.g:516:18: ( (lv_execModule_28_0= ruleExecModule ) )
            	    // InternalN4MFParser.g:516:19: (lv_execModule_28_0= ruleExecModule )
            	    {
            	    // InternalN4MFParser.g:516:19: (lv_execModule_28_0= ruleExecModule )
            	    // InternalN4MFParser.g:517:9: lv_execModule_28_0= ruleExecModule
            	    {

            	    									newCompositeNode(grammarAccess.getProjectDescriptionAccess().getExecModuleExecModuleParserRuleCall_13_0());
            	    								
            	    pushFollow(FOLLOW_5);
            	    lv_execModule_28_0=ruleExecModule();

            	    state._fsp--;


            	    									if (current==null) {
            	    										current = createModelElementForParent(grammarAccess.getProjectDescriptionRule());
            	    									}
            	    									set(
            	    										current,
            	    										"execModule",
            	    										lv_execModule_28_0,
            	    										"eu.numberfour.n4js.n4mf.N4MF.ExecModule");
            	    									afterParserOrEnumRuleCall();
            	    								

            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 15 :
            	    // InternalN4MFParser.g:539:3: ({...}? => ( ({...}? => (otherlv_29= Output otherlv_30= Colon ( (lv_outputPath_31_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // InternalN4MFParser.g:539:3: ({...}? => ( ({...}? => (otherlv_29= Output otherlv_30= Colon ( (lv_outputPath_31_0= RULE_STRING ) ) ) ) ) )
            	    // InternalN4MFParser.g:540:4: {...}? => ( ({...}? => (otherlv_29= Output otherlv_30= Colon ( (lv_outputPath_31_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 14) ) {
            	        throw new FailedPredicateException(input, "ruleProjectDescription", "getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 14)");
            	    }
            	    // InternalN4MFParser.g:540:113: ( ({...}? => (otherlv_29= Output otherlv_30= Colon ( (lv_outputPath_31_0= RULE_STRING ) ) ) ) )
            	    // InternalN4MFParser.g:541:5: ({...}? => (otherlv_29= Output otherlv_30= Colon ( (lv_outputPath_31_0= RULE_STRING ) ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 14);
            	    				
            	    // InternalN4MFParser.g:544:8: ({...}? => (otherlv_29= Output otherlv_30= Colon ( (lv_outputPath_31_0= RULE_STRING ) ) ) )
            	    // InternalN4MFParser.g:544:9: {...}? => (otherlv_29= Output otherlv_30= Colon ( (lv_outputPath_31_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleProjectDescription", "true");
            	    }
            	    // InternalN4MFParser.g:544:18: (otherlv_29= Output otherlv_30= Colon ( (lv_outputPath_31_0= RULE_STRING ) ) )
            	    // InternalN4MFParser.g:544:19: otherlv_29= Output otherlv_30= Colon ( (lv_outputPath_31_0= RULE_STRING ) )
            	    {
            	    otherlv_29=(Token)match(input,Output,FOLLOW_3); 

            	    								newLeafNode(otherlv_29, grammarAccess.getProjectDescriptionAccess().getOutputKeyword_14_0());
            	    							
            	    otherlv_30=(Token)match(input,Colon,FOLLOW_8); 

            	    								newLeafNode(otherlv_30, grammarAccess.getProjectDescriptionAccess().getColonKeyword_14_1());
            	    							
            	    // InternalN4MFParser.g:552:8: ( (lv_outputPath_31_0= RULE_STRING ) )
            	    // InternalN4MFParser.g:553:9: (lv_outputPath_31_0= RULE_STRING )
            	    {
            	    // InternalN4MFParser.g:553:9: (lv_outputPath_31_0= RULE_STRING )
            	    // InternalN4MFParser.g:554:10: lv_outputPath_31_0= RULE_STRING
            	    {
            	    lv_outputPath_31_0=(Token)match(input,RULE_STRING,FOLLOW_5); 

            	    										newLeafNode(lv_outputPath_31_0, grammarAccess.getProjectDescriptionAccess().getOutputPathSTRINGTerminalRuleCall_14_2_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getProjectDescriptionRule());
            	    										}
            	    										setWithLastConsumed(
            	    											current,
            	    											"outputPath",
            	    											lv_outputPath_31_0,
            	    											"org.eclipse.xtext.common.Terminals.STRING");
            	    									

            	    }


            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 16 :
            	    // InternalN4MFParser.g:576:3: ({...}? => ( ({...}? => (otherlv_32= Libraries otherlv_33= LeftCurlyBracket ( (lv_libraryPaths_34_0= RULE_STRING ) ) (otherlv_35= Comma ( (lv_libraryPaths_36_0= RULE_STRING ) ) )* otherlv_37= RightCurlyBracket ) ) ) )
            	    {
            	    // InternalN4MFParser.g:576:3: ({...}? => ( ({...}? => (otherlv_32= Libraries otherlv_33= LeftCurlyBracket ( (lv_libraryPaths_34_0= RULE_STRING ) ) (otherlv_35= Comma ( (lv_libraryPaths_36_0= RULE_STRING ) ) )* otherlv_37= RightCurlyBracket ) ) ) )
            	    // InternalN4MFParser.g:577:4: {...}? => ( ({...}? => (otherlv_32= Libraries otherlv_33= LeftCurlyBracket ( (lv_libraryPaths_34_0= RULE_STRING ) ) (otherlv_35= Comma ( (lv_libraryPaths_36_0= RULE_STRING ) ) )* otherlv_37= RightCurlyBracket ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 15) ) {
            	        throw new FailedPredicateException(input, "ruleProjectDescription", "getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 15)");
            	    }
            	    // InternalN4MFParser.g:577:113: ( ({...}? => (otherlv_32= Libraries otherlv_33= LeftCurlyBracket ( (lv_libraryPaths_34_0= RULE_STRING ) ) (otherlv_35= Comma ( (lv_libraryPaths_36_0= RULE_STRING ) ) )* otherlv_37= RightCurlyBracket ) ) )
            	    // InternalN4MFParser.g:578:5: ({...}? => (otherlv_32= Libraries otherlv_33= LeftCurlyBracket ( (lv_libraryPaths_34_0= RULE_STRING ) ) (otherlv_35= Comma ( (lv_libraryPaths_36_0= RULE_STRING ) ) )* otherlv_37= RightCurlyBracket ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 15);
            	    				
            	    // InternalN4MFParser.g:581:8: ({...}? => (otherlv_32= Libraries otherlv_33= LeftCurlyBracket ( (lv_libraryPaths_34_0= RULE_STRING ) ) (otherlv_35= Comma ( (lv_libraryPaths_36_0= RULE_STRING ) ) )* otherlv_37= RightCurlyBracket ) )
            	    // InternalN4MFParser.g:581:9: {...}? => (otherlv_32= Libraries otherlv_33= LeftCurlyBracket ( (lv_libraryPaths_34_0= RULE_STRING ) ) (otherlv_35= Comma ( (lv_libraryPaths_36_0= RULE_STRING ) ) )* otherlv_37= RightCurlyBracket )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleProjectDescription", "true");
            	    }
            	    // InternalN4MFParser.g:581:18: (otherlv_32= Libraries otherlv_33= LeftCurlyBracket ( (lv_libraryPaths_34_0= RULE_STRING ) ) (otherlv_35= Comma ( (lv_libraryPaths_36_0= RULE_STRING ) ) )* otherlv_37= RightCurlyBracket )
            	    // InternalN4MFParser.g:581:19: otherlv_32= Libraries otherlv_33= LeftCurlyBracket ( (lv_libraryPaths_34_0= RULE_STRING ) ) (otherlv_35= Comma ( (lv_libraryPaths_36_0= RULE_STRING ) ) )* otherlv_37= RightCurlyBracket
            	    {
            	    otherlv_32=(Token)match(input,Libraries,FOLLOW_9); 

            	    								newLeafNode(otherlv_32, grammarAccess.getProjectDescriptionAccess().getLibrariesKeyword_15_0());
            	    							
            	    otherlv_33=(Token)match(input,LeftCurlyBracket,FOLLOW_8); 

            	    								newLeafNode(otherlv_33, grammarAccess.getProjectDescriptionAccess().getLeftCurlyBracketKeyword_15_1());
            	    							
            	    // InternalN4MFParser.g:589:8: ( (lv_libraryPaths_34_0= RULE_STRING ) )
            	    // InternalN4MFParser.g:590:9: (lv_libraryPaths_34_0= RULE_STRING )
            	    {
            	    // InternalN4MFParser.g:590:9: (lv_libraryPaths_34_0= RULE_STRING )
            	    // InternalN4MFParser.g:591:10: lv_libraryPaths_34_0= RULE_STRING
            	    {
            	    lv_libraryPaths_34_0=(Token)match(input,RULE_STRING,FOLLOW_10); 

            	    										newLeafNode(lv_libraryPaths_34_0, grammarAccess.getProjectDescriptionAccess().getLibraryPathsSTRINGTerminalRuleCall_15_2_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getProjectDescriptionRule());
            	    										}
            	    										addWithLastConsumed(
            	    											current,
            	    											"libraryPaths",
            	    											lv_libraryPaths_34_0,
            	    											"org.eclipse.xtext.common.Terminals.STRING");
            	    									

            	    }


            	    }

            	    // InternalN4MFParser.g:607:8: (otherlv_35= Comma ( (lv_libraryPaths_36_0= RULE_STRING ) ) )*
            	    loop1:
            	    do {
            	        int alt1=2;
            	        int LA1_0 = input.LA(1);

            	        if ( (LA1_0==Comma) ) {
            	            alt1=1;
            	        }


            	        switch (alt1) {
            	    	case 1 :
            	    	    // InternalN4MFParser.g:608:9: otherlv_35= Comma ( (lv_libraryPaths_36_0= RULE_STRING ) )
            	    	    {
            	    	    otherlv_35=(Token)match(input,Comma,FOLLOW_8); 

            	    	    									newLeafNode(otherlv_35, grammarAccess.getProjectDescriptionAccess().getCommaKeyword_15_3_0());
            	    	    								
            	    	    // InternalN4MFParser.g:612:9: ( (lv_libraryPaths_36_0= RULE_STRING ) )
            	    	    // InternalN4MFParser.g:613:10: (lv_libraryPaths_36_0= RULE_STRING )
            	    	    {
            	    	    // InternalN4MFParser.g:613:10: (lv_libraryPaths_36_0= RULE_STRING )
            	    	    // InternalN4MFParser.g:614:11: lv_libraryPaths_36_0= RULE_STRING
            	    	    {
            	    	    lv_libraryPaths_36_0=(Token)match(input,RULE_STRING,FOLLOW_10); 

            	    	    											newLeafNode(lv_libraryPaths_36_0, grammarAccess.getProjectDescriptionAccess().getLibraryPathsSTRINGTerminalRuleCall_15_3_1_0());
            	    	    										

            	    	    											if (current==null) {
            	    	    												current = createModelElement(grammarAccess.getProjectDescriptionRule());
            	    	    											}
            	    	    											addWithLastConsumed(
            	    	    												current,
            	    	    												"libraryPaths",
            	    	    												lv_libraryPaths_36_0,
            	    	    												"org.eclipse.xtext.common.Terminals.STRING");
            	    	    										

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop1;
            	        }
            	    } while (true);

            	    otherlv_37=(Token)match(input,RightCurlyBracket,FOLLOW_5); 

            	    								newLeafNode(otherlv_37, grammarAccess.getProjectDescriptionAccess().getRightCurlyBracketKeyword_15_4());
            	    							

            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 17 :
            	    // InternalN4MFParser.g:641:3: ({...}? => ( ({...}? => (otherlv_38= Resources otherlv_39= LeftCurlyBracket ( (lv_resourcePaths_40_0= RULE_STRING ) ) (otherlv_41= Comma ( (lv_resourcePaths_42_0= RULE_STRING ) ) )* otherlv_43= RightCurlyBracket ) ) ) )
            	    {
            	    // InternalN4MFParser.g:641:3: ({...}? => ( ({...}? => (otherlv_38= Resources otherlv_39= LeftCurlyBracket ( (lv_resourcePaths_40_0= RULE_STRING ) ) (otherlv_41= Comma ( (lv_resourcePaths_42_0= RULE_STRING ) ) )* otherlv_43= RightCurlyBracket ) ) ) )
            	    // InternalN4MFParser.g:642:4: {...}? => ( ({...}? => (otherlv_38= Resources otherlv_39= LeftCurlyBracket ( (lv_resourcePaths_40_0= RULE_STRING ) ) (otherlv_41= Comma ( (lv_resourcePaths_42_0= RULE_STRING ) ) )* otherlv_43= RightCurlyBracket ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 16) ) {
            	        throw new FailedPredicateException(input, "ruleProjectDescription", "getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 16)");
            	    }
            	    // InternalN4MFParser.g:642:113: ( ({...}? => (otherlv_38= Resources otherlv_39= LeftCurlyBracket ( (lv_resourcePaths_40_0= RULE_STRING ) ) (otherlv_41= Comma ( (lv_resourcePaths_42_0= RULE_STRING ) ) )* otherlv_43= RightCurlyBracket ) ) )
            	    // InternalN4MFParser.g:643:5: ({...}? => (otherlv_38= Resources otherlv_39= LeftCurlyBracket ( (lv_resourcePaths_40_0= RULE_STRING ) ) (otherlv_41= Comma ( (lv_resourcePaths_42_0= RULE_STRING ) ) )* otherlv_43= RightCurlyBracket ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 16);
            	    				
            	    // InternalN4MFParser.g:646:8: ({...}? => (otherlv_38= Resources otherlv_39= LeftCurlyBracket ( (lv_resourcePaths_40_0= RULE_STRING ) ) (otherlv_41= Comma ( (lv_resourcePaths_42_0= RULE_STRING ) ) )* otherlv_43= RightCurlyBracket ) )
            	    // InternalN4MFParser.g:646:9: {...}? => (otherlv_38= Resources otherlv_39= LeftCurlyBracket ( (lv_resourcePaths_40_0= RULE_STRING ) ) (otherlv_41= Comma ( (lv_resourcePaths_42_0= RULE_STRING ) ) )* otherlv_43= RightCurlyBracket )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleProjectDescription", "true");
            	    }
            	    // InternalN4MFParser.g:646:18: (otherlv_38= Resources otherlv_39= LeftCurlyBracket ( (lv_resourcePaths_40_0= RULE_STRING ) ) (otherlv_41= Comma ( (lv_resourcePaths_42_0= RULE_STRING ) ) )* otherlv_43= RightCurlyBracket )
            	    // InternalN4MFParser.g:646:19: otherlv_38= Resources otherlv_39= LeftCurlyBracket ( (lv_resourcePaths_40_0= RULE_STRING ) ) (otherlv_41= Comma ( (lv_resourcePaths_42_0= RULE_STRING ) ) )* otherlv_43= RightCurlyBracket
            	    {
            	    otherlv_38=(Token)match(input,Resources,FOLLOW_9); 

            	    								newLeafNode(otherlv_38, grammarAccess.getProjectDescriptionAccess().getResourcesKeyword_16_0());
            	    							
            	    otherlv_39=(Token)match(input,LeftCurlyBracket,FOLLOW_8); 

            	    								newLeafNode(otherlv_39, grammarAccess.getProjectDescriptionAccess().getLeftCurlyBracketKeyword_16_1());
            	    							
            	    // InternalN4MFParser.g:654:8: ( (lv_resourcePaths_40_0= RULE_STRING ) )
            	    // InternalN4MFParser.g:655:9: (lv_resourcePaths_40_0= RULE_STRING )
            	    {
            	    // InternalN4MFParser.g:655:9: (lv_resourcePaths_40_0= RULE_STRING )
            	    // InternalN4MFParser.g:656:10: lv_resourcePaths_40_0= RULE_STRING
            	    {
            	    lv_resourcePaths_40_0=(Token)match(input,RULE_STRING,FOLLOW_10); 

            	    										newLeafNode(lv_resourcePaths_40_0, grammarAccess.getProjectDescriptionAccess().getResourcePathsSTRINGTerminalRuleCall_16_2_0());
            	    									

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getProjectDescriptionRule());
            	    										}
            	    										addWithLastConsumed(
            	    											current,
            	    											"resourcePaths",
            	    											lv_resourcePaths_40_0,
            	    											"org.eclipse.xtext.common.Terminals.STRING");
            	    									

            	    }


            	    }

            	    // InternalN4MFParser.g:672:8: (otherlv_41= Comma ( (lv_resourcePaths_42_0= RULE_STRING ) ) )*
            	    loop2:
            	    do {
            	        int alt2=2;
            	        int LA2_0 = input.LA(1);

            	        if ( (LA2_0==Comma) ) {
            	            alt2=1;
            	        }


            	        switch (alt2) {
            	    	case 1 :
            	    	    // InternalN4MFParser.g:673:9: otherlv_41= Comma ( (lv_resourcePaths_42_0= RULE_STRING ) )
            	    	    {
            	    	    otherlv_41=(Token)match(input,Comma,FOLLOW_8); 

            	    	    									newLeafNode(otherlv_41, grammarAccess.getProjectDescriptionAccess().getCommaKeyword_16_3_0());
            	    	    								
            	    	    // InternalN4MFParser.g:677:9: ( (lv_resourcePaths_42_0= RULE_STRING ) )
            	    	    // InternalN4MFParser.g:678:10: (lv_resourcePaths_42_0= RULE_STRING )
            	    	    {
            	    	    // InternalN4MFParser.g:678:10: (lv_resourcePaths_42_0= RULE_STRING )
            	    	    // InternalN4MFParser.g:679:11: lv_resourcePaths_42_0= RULE_STRING
            	    	    {
            	    	    lv_resourcePaths_42_0=(Token)match(input,RULE_STRING,FOLLOW_10); 

            	    	    											newLeafNode(lv_resourcePaths_42_0, grammarAccess.getProjectDescriptionAccess().getResourcePathsSTRINGTerminalRuleCall_16_3_1_0());
            	    	    										

            	    	    											if (current==null) {
            	    	    												current = createModelElement(grammarAccess.getProjectDescriptionRule());
            	    	    											}
            	    	    											addWithLastConsumed(
            	    	    												current,
            	    	    												"resourcePaths",
            	    	    												lv_resourcePaths_42_0,
            	    	    												"org.eclipse.xtext.common.Terminals.STRING");
            	    	    										

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop2;
            	        }
            	    } while (true);

            	    otherlv_43=(Token)match(input,RightCurlyBracket,FOLLOW_5); 

            	    								newLeafNode(otherlv_43, grammarAccess.getProjectDescriptionAccess().getRightCurlyBracketKeyword_16_4());
            	    							

            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 18 :
            	    // InternalN4MFParser.g:706:3: ({...}? => ( ({...}? => (otherlv_44= Sources otherlv_45= LeftCurlyBracket ( (lv_sourceFragment_46_0= ruleSourceFragment ) )+ otherlv_47= RightCurlyBracket ) ) ) )
            	    {
            	    // InternalN4MFParser.g:706:3: ({...}? => ( ({...}? => (otherlv_44= Sources otherlv_45= LeftCurlyBracket ( (lv_sourceFragment_46_0= ruleSourceFragment ) )+ otherlv_47= RightCurlyBracket ) ) ) )
            	    // InternalN4MFParser.g:707:4: {...}? => ( ({...}? => (otherlv_44= Sources otherlv_45= LeftCurlyBracket ( (lv_sourceFragment_46_0= ruleSourceFragment ) )+ otherlv_47= RightCurlyBracket ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 17) ) {
            	        throw new FailedPredicateException(input, "ruleProjectDescription", "getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 17)");
            	    }
            	    // InternalN4MFParser.g:707:113: ( ({...}? => (otherlv_44= Sources otherlv_45= LeftCurlyBracket ( (lv_sourceFragment_46_0= ruleSourceFragment ) )+ otherlv_47= RightCurlyBracket ) ) )
            	    // InternalN4MFParser.g:708:5: ({...}? => (otherlv_44= Sources otherlv_45= LeftCurlyBracket ( (lv_sourceFragment_46_0= ruleSourceFragment ) )+ otherlv_47= RightCurlyBracket ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 17);
            	    				
            	    // InternalN4MFParser.g:711:8: ({...}? => (otherlv_44= Sources otherlv_45= LeftCurlyBracket ( (lv_sourceFragment_46_0= ruleSourceFragment ) )+ otherlv_47= RightCurlyBracket ) )
            	    // InternalN4MFParser.g:711:9: {...}? => (otherlv_44= Sources otherlv_45= LeftCurlyBracket ( (lv_sourceFragment_46_0= ruleSourceFragment ) )+ otherlv_47= RightCurlyBracket )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleProjectDescription", "true");
            	    }
            	    // InternalN4MFParser.g:711:18: (otherlv_44= Sources otherlv_45= LeftCurlyBracket ( (lv_sourceFragment_46_0= ruleSourceFragment ) )+ otherlv_47= RightCurlyBracket )
            	    // InternalN4MFParser.g:711:19: otherlv_44= Sources otherlv_45= LeftCurlyBracket ( (lv_sourceFragment_46_0= ruleSourceFragment ) )+ otherlv_47= RightCurlyBracket
            	    {
            	    otherlv_44=(Token)match(input,Sources,FOLLOW_9); 

            	    								newLeafNode(otherlv_44, grammarAccess.getProjectDescriptionAccess().getSourcesKeyword_17_0());
            	    							
            	    otherlv_45=(Token)match(input,LeftCurlyBracket,FOLLOW_11); 

            	    								newLeafNode(otherlv_45, grammarAccess.getProjectDescriptionAccess().getLeftCurlyBracketKeyword_17_1());
            	    							
            	    // InternalN4MFParser.g:719:8: ( (lv_sourceFragment_46_0= ruleSourceFragment ) )+
            	    int cnt3=0;
            	    loop3:
            	    do {
            	        int alt3=2;
            	        int LA3_0 = input.LA(1);

            	        if ( (LA3_0==External||LA3_0==Source||LA3_0==Test) ) {
            	            alt3=1;
            	        }


            	        switch (alt3) {
            	    	case 1 :
            	    	    // InternalN4MFParser.g:720:9: (lv_sourceFragment_46_0= ruleSourceFragment )
            	    	    {
            	    	    // InternalN4MFParser.g:720:9: (lv_sourceFragment_46_0= ruleSourceFragment )
            	    	    // InternalN4MFParser.g:721:10: lv_sourceFragment_46_0= ruleSourceFragment
            	    	    {

            	    	    										newCompositeNode(grammarAccess.getProjectDescriptionAccess().getSourceFragmentSourceFragmentParserRuleCall_17_2_0());
            	    	    									
            	    	    pushFollow(FOLLOW_12);
            	    	    lv_sourceFragment_46_0=ruleSourceFragment();

            	    	    state._fsp--;


            	    	    										if (current==null) {
            	    	    											current = createModelElementForParent(grammarAccess.getProjectDescriptionRule());
            	    	    										}
            	    	    										add(
            	    	    											current,
            	    	    											"sourceFragment",
            	    	    											lv_sourceFragment_46_0,
            	    	    											"eu.numberfour.n4js.n4mf.N4MF.SourceFragment");
            	    	    										afterParserOrEnumRuleCall();
            	    	    									

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt3 >= 1 ) break loop3;
            	                EarlyExitException eee =
            	                    new EarlyExitException(3, input);
            	                throw eee;
            	        }
            	        cnt3++;
            	    } while (true);

            	    otherlv_47=(Token)match(input,RightCurlyBracket,FOLLOW_5); 

            	    								newLeafNode(otherlv_47, grammarAccess.getProjectDescriptionAccess().getRightCurlyBracketKeyword_17_3());
            	    							

            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 19 :
            	    // InternalN4MFParser.g:748:3: ({...}? => ( ({...}? => (otherlv_48= ModuleFilters otherlv_49= LeftCurlyBracket ( (lv_moduleFilters_50_0= ruleModuleFilter ) )+ otherlv_51= RightCurlyBracket ) ) ) )
            	    {
            	    // InternalN4MFParser.g:748:3: ({...}? => ( ({...}? => (otherlv_48= ModuleFilters otherlv_49= LeftCurlyBracket ( (lv_moduleFilters_50_0= ruleModuleFilter ) )+ otherlv_51= RightCurlyBracket ) ) ) )
            	    // InternalN4MFParser.g:749:4: {...}? => ( ({...}? => (otherlv_48= ModuleFilters otherlv_49= LeftCurlyBracket ( (lv_moduleFilters_50_0= ruleModuleFilter ) )+ otherlv_51= RightCurlyBracket ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 18) ) {
            	        throw new FailedPredicateException(input, "ruleProjectDescription", "getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 18)");
            	    }
            	    // InternalN4MFParser.g:749:113: ( ({...}? => (otherlv_48= ModuleFilters otherlv_49= LeftCurlyBracket ( (lv_moduleFilters_50_0= ruleModuleFilter ) )+ otherlv_51= RightCurlyBracket ) ) )
            	    // InternalN4MFParser.g:750:5: ({...}? => (otherlv_48= ModuleFilters otherlv_49= LeftCurlyBracket ( (lv_moduleFilters_50_0= ruleModuleFilter ) )+ otherlv_51= RightCurlyBracket ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 18);
            	    				
            	    // InternalN4MFParser.g:753:8: ({...}? => (otherlv_48= ModuleFilters otherlv_49= LeftCurlyBracket ( (lv_moduleFilters_50_0= ruleModuleFilter ) )+ otherlv_51= RightCurlyBracket ) )
            	    // InternalN4MFParser.g:753:9: {...}? => (otherlv_48= ModuleFilters otherlv_49= LeftCurlyBracket ( (lv_moduleFilters_50_0= ruleModuleFilter ) )+ otherlv_51= RightCurlyBracket )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleProjectDescription", "true");
            	    }
            	    // InternalN4MFParser.g:753:18: (otherlv_48= ModuleFilters otherlv_49= LeftCurlyBracket ( (lv_moduleFilters_50_0= ruleModuleFilter ) )+ otherlv_51= RightCurlyBracket )
            	    // InternalN4MFParser.g:753:19: otherlv_48= ModuleFilters otherlv_49= LeftCurlyBracket ( (lv_moduleFilters_50_0= ruleModuleFilter ) )+ otherlv_51= RightCurlyBracket
            	    {
            	    otherlv_48=(Token)match(input,ModuleFilters,FOLLOW_9); 

            	    								newLeafNode(otherlv_48, grammarAccess.getProjectDescriptionAccess().getModuleFiltersKeyword_18_0());
            	    							
            	    otherlv_49=(Token)match(input,LeftCurlyBracket,FOLLOW_13); 

            	    								newLeafNode(otherlv_49, grammarAccess.getProjectDescriptionAccess().getLeftCurlyBracketKeyword_18_1());
            	    							
            	    // InternalN4MFParser.g:761:8: ( (lv_moduleFilters_50_0= ruleModuleFilter ) )+
            	    int cnt4=0;
            	    loop4:
            	    do {
            	        int alt4=2;
            	        int LA4_0 = input.LA(1);

            	        if ( (LA4_0==NoModuleWrap||LA4_0==NoValidate) ) {
            	            alt4=1;
            	        }


            	        switch (alt4) {
            	    	case 1 :
            	    	    // InternalN4MFParser.g:762:9: (lv_moduleFilters_50_0= ruleModuleFilter )
            	    	    {
            	    	    // InternalN4MFParser.g:762:9: (lv_moduleFilters_50_0= ruleModuleFilter )
            	    	    // InternalN4MFParser.g:763:10: lv_moduleFilters_50_0= ruleModuleFilter
            	    	    {

            	    	    										newCompositeNode(grammarAccess.getProjectDescriptionAccess().getModuleFiltersModuleFilterParserRuleCall_18_2_0());
            	    	    									
            	    	    pushFollow(FOLLOW_14);
            	    	    lv_moduleFilters_50_0=ruleModuleFilter();

            	    	    state._fsp--;


            	    	    										if (current==null) {
            	    	    											current = createModelElementForParent(grammarAccess.getProjectDescriptionRule());
            	    	    										}
            	    	    										add(
            	    	    											current,
            	    	    											"moduleFilters",
            	    	    											lv_moduleFilters_50_0,
            	    	    											"eu.numberfour.n4js.n4mf.N4MF.ModuleFilter");
            	    	    										afterParserOrEnumRuleCall();
            	    	    									

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt4 >= 1 ) break loop4;
            	                EarlyExitException eee =
            	                    new EarlyExitException(4, input);
            	                throw eee;
            	        }
            	        cnt4++;
            	    } while (true);

            	    otherlv_51=(Token)match(input,RightCurlyBracket,FOLLOW_5); 

            	    								newLeafNode(otherlv_51, grammarAccess.getProjectDescriptionAccess().getRightCurlyBracketKeyword_18_3());
            	    							

            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 20 :
            	    // InternalN4MFParser.g:790:3: ({...}? => ( ({...}? => ( (lv_testedProjects_52_0= ruleTestedProjects ) ) ) ) )
            	    {
            	    // InternalN4MFParser.g:790:3: ({...}? => ( ({...}? => ( (lv_testedProjects_52_0= ruleTestedProjects ) ) ) ) )
            	    // InternalN4MFParser.g:791:4: {...}? => ( ({...}? => ( (lv_testedProjects_52_0= ruleTestedProjects ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 19) ) {
            	        throw new FailedPredicateException(input, "ruleProjectDescription", "getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 19)");
            	    }
            	    // InternalN4MFParser.g:791:113: ( ({...}? => ( (lv_testedProjects_52_0= ruleTestedProjects ) ) ) )
            	    // InternalN4MFParser.g:792:5: ({...}? => ( (lv_testedProjects_52_0= ruleTestedProjects ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 19);
            	    				
            	    // InternalN4MFParser.g:795:8: ({...}? => ( (lv_testedProjects_52_0= ruleTestedProjects ) ) )
            	    // InternalN4MFParser.g:795:9: {...}? => ( (lv_testedProjects_52_0= ruleTestedProjects ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleProjectDescription", "true");
            	    }
            	    // InternalN4MFParser.g:795:18: ( (lv_testedProjects_52_0= ruleTestedProjects ) )
            	    // InternalN4MFParser.g:795:19: (lv_testedProjects_52_0= ruleTestedProjects )
            	    {
            	    // InternalN4MFParser.g:795:19: (lv_testedProjects_52_0= ruleTestedProjects )
            	    // InternalN4MFParser.g:796:9: lv_testedProjects_52_0= ruleTestedProjects
            	    {

            	    									newCompositeNode(grammarAccess.getProjectDescriptionAccess().getTestedProjectsTestedProjectsParserRuleCall_19_0());
            	    								
            	    pushFollow(FOLLOW_5);
            	    lv_testedProjects_52_0=ruleTestedProjects();

            	    state._fsp--;


            	    									if (current==null) {
            	    										current = createModelElementForParent(grammarAccess.getProjectDescriptionRule());
            	    									}
            	    									set(
            	    										current,
            	    										"testedProjects",
            	    										lv_testedProjects_52_0,
            	    										"eu.numberfour.n4js.n4mf.N4MF.TestedProjects");
            	    									afterParserOrEnumRuleCall();
            	    								

            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 21 :
            	    // InternalN4MFParser.g:818:3: ({...}? => ( ({...}? => (otherlv_53= ModuleLoader otherlv_54= Colon ( (lv_moduleLoader_55_0= ruleModuleLoader ) ) ) ) ) )
            	    {
            	    // InternalN4MFParser.g:818:3: ({...}? => ( ({...}? => (otherlv_53= ModuleLoader otherlv_54= Colon ( (lv_moduleLoader_55_0= ruleModuleLoader ) ) ) ) ) )
            	    // InternalN4MFParser.g:819:4: {...}? => ( ({...}? => (otherlv_53= ModuleLoader otherlv_54= Colon ( (lv_moduleLoader_55_0= ruleModuleLoader ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 20) ) {
            	        throw new FailedPredicateException(input, "ruleProjectDescription", "getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 20)");
            	    }
            	    // InternalN4MFParser.g:819:113: ( ({...}? => (otherlv_53= ModuleLoader otherlv_54= Colon ( (lv_moduleLoader_55_0= ruleModuleLoader ) ) ) ) )
            	    // InternalN4MFParser.g:820:5: ({...}? => (otherlv_53= ModuleLoader otherlv_54= Colon ( (lv_moduleLoader_55_0= ruleModuleLoader ) ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 20);
            	    				
            	    // InternalN4MFParser.g:823:8: ({...}? => (otherlv_53= ModuleLoader otherlv_54= Colon ( (lv_moduleLoader_55_0= ruleModuleLoader ) ) ) )
            	    // InternalN4MFParser.g:823:9: {...}? => (otherlv_53= ModuleLoader otherlv_54= Colon ( (lv_moduleLoader_55_0= ruleModuleLoader ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleProjectDescription", "true");
            	    }
            	    // InternalN4MFParser.g:823:18: (otherlv_53= ModuleLoader otherlv_54= Colon ( (lv_moduleLoader_55_0= ruleModuleLoader ) ) )
            	    // InternalN4MFParser.g:823:19: otherlv_53= ModuleLoader otherlv_54= Colon ( (lv_moduleLoader_55_0= ruleModuleLoader ) )
            	    {
            	    otherlv_53=(Token)match(input,ModuleLoader,FOLLOW_3); 

            	    								newLeafNode(otherlv_53, grammarAccess.getProjectDescriptionAccess().getModuleLoaderKeyword_20_0());
            	    							
            	    otherlv_54=(Token)match(input,Colon,FOLLOW_15); 

            	    								newLeafNode(otherlv_54, grammarAccess.getProjectDescriptionAccess().getColonKeyword_20_1());
            	    							
            	    // InternalN4MFParser.g:831:8: ( (lv_moduleLoader_55_0= ruleModuleLoader ) )
            	    // InternalN4MFParser.g:832:9: (lv_moduleLoader_55_0= ruleModuleLoader )
            	    {
            	    // InternalN4MFParser.g:832:9: (lv_moduleLoader_55_0= ruleModuleLoader )
            	    // InternalN4MFParser.g:833:10: lv_moduleLoader_55_0= ruleModuleLoader
            	    {

            	    										newCompositeNode(grammarAccess.getProjectDescriptionAccess().getModuleLoaderModuleLoaderEnumRuleCall_20_2_0());
            	    									
            	    pushFollow(FOLLOW_5);
            	    lv_moduleLoader_55_0=ruleModuleLoader();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getProjectDescriptionRule());
            	    										}
            	    										set(
            	    											current,
            	    											"moduleLoader",
            	    											lv_moduleLoader_55_0,
            	    											"eu.numberfour.n4js.n4mf.N4MF.ModuleLoader");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup()) ) {
                throw new FailedPredicateException(input, "ruleProjectDescription", "getUnorderedGroupHelper().canLeave(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup())");
            }

            }


            }

             
            			  getUnorderedGroupHelper().leave(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup());
            			

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProjectDescription"


    // $ANTLR start "entryRuleExecModule"
    // InternalN4MFParser.g:867:1: entryRuleExecModule returns [EObject current=null] : iv_ruleExecModule= ruleExecModule EOF ;
    public final EObject entryRuleExecModule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExecModule = null;


        try {
            // InternalN4MFParser.g:867:51: (iv_ruleExecModule= ruleExecModule EOF )
            // InternalN4MFParser.g:868:2: iv_ruleExecModule= ruleExecModule EOF
            {
             newCompositeNode(grammarAccess.getExecModuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExecModule=ruleExecModule();

            state._fsp--;

             current =iv_ruleExecModule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExecModule"


    // $ANTLR start "ruleExecModule"
    // InternalN4MFParser.g:874:1: ruleExecModule returns [EObject current=null] : ( () otherlv_1= ExecModule otherlv_2= Colon ( (lv_execModule_3_0= ruleBootstrapModule ) ) ) ;
    public final EObject ruleExecModule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_execModule_3_0 = null;



        	enterRule();

        try {
            // InternalN4MFParser.g:880:2: ( ( () otherlv_1= ExecModule otherlv_2= Colon ( (lv_execModule_3_0= ruleBootstrapModule ) ) ) )
            // InternalN4MFParser.g:881:2: ( () otherlv_1= ExecModule otherlv_2= Colon ( (lv_execModule_3_0= ruleBootstrapModule ) ) )
            {
            // InternalN4MFParser.g:881:2: ( () otherlv_1= ExecModule otherlv_2= Colon ( (lv_execModule_3_0= ruleBootstrapModule ) ) )
            // InternalN4MFParser.g:882:3: () otherlv_1= ExecModule otherlv_2= Colon ( (lv_execModule_3_0= ruleBootstrapModule ) )
            {
            // InternalN4MFParser.g:882:3: ()
            // InternalN4MFParser.g:883:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExecModuleAccess().getExecModuleAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,ExecModule,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getExecModuleAccess().getExecModuleKeyword_1());
            		
            otherlv_2=(Token)match(input,Colon,FOLLOW_8); 

            			newLeafNode(otherlv_2, grammarAccess.getExecModuleAccess().getColonKeyword_2());
            		
            // InternalN4MFParser.g:897:3: ( (lv_execModule_3_0= ruleBootstrapModule ) )
            // InternalN4MFParser.g:898:4: (lv_execModule_3_0= ruleBootstrapModule )
            {
            // InternalN4MFParser.g:898:4: (lv_execModule_3_0= ruleBootstrapModule )
            // InternalN4MFParser.g:899:5: lv_execModule_3_0= ruleBootstrapModule
            {

            					newCompositeNode(grammarAccess.getExecModuleAccess().getExecModuleBootstrapModuleParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_execModule_3_0=ruleBootstrapModule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExecModuleRule());
            					}
            					set(
            						current,
            						"execModule",
            						lv_execModule_3_0,
            						"eu.numberfour.n4js.n4mf.N4MF.BootstrapModule");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExecModule"


    // $ANTLR start "entryRuleTestedProjects"
    // InternalN4MFParser.g:920:1: entryRuleTestedProjects returns [EObject current=null] : iv_ruleTestedProjects= ruleTestedProjects EOF ;
    public final EObject entryRuleTestedProjects() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestedProjects = null;


        try {
            // InternalN4MFParser.g:920:55: (iv_ruleTestedProjects= ruleTestedProjects EOF )
            // InternalN4MFParser.g:921:2: iv_ruleTestedProjects= ruleTestedProjects EOF
            {
             newCompositeNode(grammarAccess.getTestedProjectsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTestedProjects=ruleTestedProjects();

            state._fsp--;

             current =iv_ruleTestedProjects; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTestedProjects"


    // $ANTLR start "ruleTestedProjects"
    // InternalN4MFParser.g:927:1: ruleTestedProjects returns [EObject current=null] : ( () otherlv_1= TestedProjects otherlv_2= LeftCurlyBracket ( ( (lv_testedProjects_3_0= ruleTestedProject ) ) (otherlv_4= Comma ( (lv_testedProjects_5_0= ruleTestedProject ) ) )* )? otherlv_6= RightCurlyBracket ) ;
    public final EObject ruleTestedProjects() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_testedProjects_3_0 = null;

        EObject lv_testedProjects_5_0 = null;



        	enterRule();

        try {
            // InternalN4MFParser.g:933:2: ( ( () otherlv_1= TestedProjects otherlv_2= LeftCurlyBracket ( ( (lv_testedProjects_3_0= ruleTestedProject ) ) (otherlv_4= Comma ( (lv_testedProjects_5_0= ruleTestedProject ) ) )* )? otherlv_6= RightCurlyBracket ) )
            // InternalN4MFParser.g:934:2: ( () otherlv_1= TestedProjects otherlv_2= LeftCurlyBracket ( ( (lv_testedProjects_3_0= ruleTestedProject ) ) (otherlv_4= Comma ( (lv_testedProjects_5_0= ruleTestedProject ) ) )* )? otherlv_6= RightCurlyBracket )
            {
            // InternalN4MFParser.g:934:2: ( () otherlv_1= TestedProjects otherlv_2= LeftCurlyBracket ( ( (lv_testedProjects_3_0= ruleTestedProject ) ) (otherlv_4= Comma ( (lv_testedProjects_5_0= ruleTestedProject ) ) )* )? otherlv_6= RightCurlyBracket )
            // InternalN4MFParser.g:935:3: () otherlv_1= TestedProjects otherlv_2= LeftCurlyBracket ( ( (lv_testedProjects_3_0= ruleTestedProject ) ) (otherlv_4= Comma ( (lv_testedProjects_5_0= ruleTestedProject ) ) )* )? otherlv_6= RightCurlyBracket
            {
            // InternalN4MFParser.g:935:3: ()
            // InternalN4MFParser.g:936:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTestedProjectsAccess().getTestedProjectsAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,TestedProjects,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getTestedProjectsAccess().getTestedProjectsKeyword_1());
            		
            otherlv_2=(Token)match(input,LeftCurlyBracket,FOLLOW_16); 

            			newLeafNode(otherlv_2, grammarAccess.getTestedProjectsAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalN4MFParser.g:950:3: ( ( (lv_testedProjects_3_0= ruleTestedProject ) ) (otherlv_4= Comma ( (lv_testedProjects_5_0= ruleTestedProject ) ) )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==ProjectDependencies||LA7_0==ProjectVersion||LA7_0==ModuleFilters||(LA7_0>=ProjectType && LA7_0<=Application)||LA7_0==VendorName||(LA7_0>=Libraries && LA7_0<=VendorId)||LA7_0==Sources||LA7_0==Content||LA7_0==Output||(LA7_0>=Test && LA7_0<=API)||LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalN4MFParser.g:951:4: ( (lv_testedProjects_3_0= ruleTestedProject ) ) (otherlv_4= Comma ( (lv_testedProjects_5_0= ruleTestedProject ) ) )*
                    {
                    // InternalN4MFParser.g:951:4: ( (lv_testedProjects_3_0= ruleTestedProject ) )
                    // InternalN4MFParser.g:952:5: (lv_testedProjects_3_0= ruleTestedProject )
                    {
                    // InternalN4MFParser.g:952:5: (lv_testedProjects_3_0= ruleTestedProject )
                    // InternalN4MFParser.g:953:6: lv_testedProjects_3_0= ruleTestedProject
                    {

                    						newCompositeNode(grammarAccess.getTestedProjectsAccess().getTestedProjectsTestedProjectParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_10);
                    lv_testedProjects_3_0=ruleTestedProject();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTestedProjectsRule());
                    						}
                    						add(
                    							current,
                    							"testedProjects",
                    							lv_testedProjects_3_0,
                    							"eu.numberfour.n4js.n4mf.N4MF.TestedProject");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalN4MFParser.g:970:4: (otherlv_4= Comma ( (lv_testedProjects_5_0= ruleTestedProject ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==Comma) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalN4MFParser.g:971:5: otherlv_4= Comma ( (lv_testedProjects_5_0= ruleTestedProject ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FOLLOW_4); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getTestedProjectsAccess().getCommaKeyword_3_1_0());
                    	    				
                    	    // InternalN4MFParser.g:975:5: ( (lv_testedProjects_5_0= ruleTestedProject ) )
                    	    // InternalN4MFParser.g:976:6: (lv_testedProjects_5_0= ruleTestedProject )
                    	    {
                    	    // InternalN4MFParser.g:976:6: (lv_testedProjects_5_0= ruleTestedProject )
                    	    // InternalN4MFParser.g:977:7: lv_testedProjects_5_0= ruleTestedProject
                    	    {

                    	    							newCompositeNode(grammarAccess.getTestedProjectsAccess().getTestedProjectsTestedProjectParserRuleCall_3_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_10);
                    	    lv_testedProjects_5_0=ruleTestedProject();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getTestedProjectsRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"testedProjects",
                    	    								lv_testedProjects_5_0,
                    	    								"eu.numberfour.n4js.n4mf.N4MF.TestedProject");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,RightCurlyBracket,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getTestedProjectsAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTestedProjects"


    // $ANTLR start "entryRuleInitModules"
    // InternalN4MFParser.g:1004:1: entryRuleInitModules returns [EObject current=null] : iv_ruleInitModules= ruleInitModules EOF ;
    public final EObject entryRuleInitModules() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInitModules = null;


        try {
            // InternalN4MFParser.g:1004:52: (iv_ruleInitModules= ruleInitModules EOF )
            // InternalN4MFParser.g:1005:2: iv_ruleInitModules= ruleInitModules EOF
            {
             newCompositeNode(grammarAccess.getInitModulesRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInitModules=ruleInitModules();

            state._fsp--;

             current =iv_ruleInitModules; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInitModules"


    // $ANTLR start "ruleInitModules"
    // InternalN4MFParser.g:1011:1: ruleInitModules returns [EObject current=null] : ( () otherlv_1= InitModules otherlv_2= LeftCurlyBracket ( ( (lv_initModules_3_0= ruleBootstrapModule ) ) (otherlv_4= Comma ( (lv_initModules_5_0= ruleBootstrapModule ) ) )* )? otherlv_6= RightCurlyBracket ) ;
    public final EObject ruleInitModules() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_initModules_3_0 = null;

        EObject lv_initModules_5_0 = null;



        	enterRule();

        try {
            // InternalN4MFParser.g:1017:2: ( ( () otherlv_1= InitModules otherlv_2= LeftCurlyBracket ( ( (lv_initModules_3_0= ruleBootstrapModule ) ) (otherlv_4= Comma ( (lv_initModules_5_0= ruleBootstrapModule ) ) )* )? otherlv_6= RightCurlyBracket ) )
            // InternalN4MFParser.g:1018:2: ( () otherlv_1= InitModules otherlv_2= LeftCurlyBracket ( ( (lv_initModules_3_0= ruleBootstrapModule ) ) (otherlv_4= Comma ( (lv_initModules_5_0= ruleBootstrapModule ) ) )* )? otherlv_6= RightCurlyBracket )
            {
            // InternalN4MFParser.g:1018:2: ( () otherlv_1= InitModules otherlv_2= LeftCurlyBracket ( ( (lv_initModules_3_0= ruleBootstrapModule ) ) (otherlv_4= Comma ( (lv_initModules_5_0= ruleBootstrapModule ) ) )* )? otherlv_6= RightCurlyBracket )
            // InternalN4MFParser.g:1019:3: () otherlv_1= InitModules otherlv_2= LeftCurlyBracket ( ( (lv_initModules_3_0= ruleBootstrapModule ) ) (otherlv_4= Comma ( (lv_initModules_5_0= ruleBootstrapModule ) ) )* )? otherlv_6= RightCurlyBracket
            {
            // InternalN4MFParser.g:1019:3: ()
            // InternalN4MFParser.g:1020:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getInitModulesAccess().getInitModulesAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,InitModules,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getInitModulesAccess().getInitModulesKeyword_1());
            		
            otherlv_2=(Token)match(input,LeftCurlyBracket,FOLLOW_17); 

            			newLeafNode(otherlv_2, grammarAccess.getInitModulesAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalN4MFParser.g:1034:3: ( ( (lv_initModules_3_0= ruleBootstrapModule ) ) (otherlv_4= Comma ( (lv_initModules_5_0= ruleBootstrapModule ) ) )* )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_STRING) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalN4MFParser.g:1035:4: ( (lv_initModules_3_0= ruleBootstrapModule ) ) (otherlv_4= Comma ( (lv_initModules_5_0= ruleBootstrapModule ) ) )*
                    {
                    // InternalN4MFParser.g:1035:4: ( (lv_initModules_3_0= ruleBootstrapModule ) )
                    // InternalN4MFParser.g:1036:5: (lv_initModules_3_0= ruleBootstrapModule )
                    {
                    // InternalN4MFParser.g:1036:5: (lv_initModules_3_0= ruleBootstrapModule )
                    // InternalN4MFParser.g:1037:6: lv_initModules_3_0= ruleBootstrapModule
                    {

                    						newCompositeNode(grammarAccess.getInitModulesAccess().getInitModulesBootstrapModuleParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_10);
                    lv_initModules_3_0=ruleBootstrapModule();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getInitModulesRule());
                    						}
                    						add(
                    							current,
                    							"initModules",
                    							lv_initModules_3_0,
                    							"eu.numberfour.n4js.n4mf.N4MF.BootstrapModule");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalN4MFParser.g:1054:4: (otherlv_4= Comma ( (lv_initModules_5_0= ruleBootstrapModule ) ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==Comma) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalN4MFParser.g:1055:5: otherlv_4= Comma ( (lv_initModules_5_0= ruleBootstrapModule ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FOLLOW_8); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getInitModulesAccess().getCommaKeyword_3_1_0());
                    	    				
                    	    // InternalN4MFParser.g:1059:5: ( (lv_initModules_5_0= ruleBootstrapModule ) )
                    	    // InternalN4MFParser.g:1060:6: (lv_initModules_5_0= ruleBootstrapModule )
                    	    {
                    	    // InternalN4MFParser.g:1060:6: (lv_initModules_5_0= ruleBootstrapModule )
                    	    // InternalN4MFParser.g:1061:7: lv_initModules_5_0= ruleBootstrapModule
                    	    {

                    	    							newCompositeNode(grammarAccess.getInitModulesAccess().getInitModulesBootstrapModuleParserRuleCall_3_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_10);
                    	    lv_initModules_5_0=ruleBootstrapModule();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getInitModulesRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"initModules",
                    	    								lv_initModules_5_0,
                    	    								"eu.numberfour.n4js.n4mf.N4MF.BootstrapModule");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,RightCurlyBracket,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getInitModulesAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInitModules"


    // $ANTLR start "entryRuleImplementedProjects"
    // InternalN4MFParser.g:1088:1: entryRuleImplementedProjects returns [EObject current=null] : iv_ruleImplementedProjects= ruleImplementedProjects EOF ;
    public final EObject entryRuleImplementedProjects() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImplementedProjects = null;


        try {
            // InternalN4MFParser.g:1088:60: (iv_ruleImplementedProjects= ruleImplementedProjects EOF )
            // InternalN4MFParser.g:1089:2: iv_ruleImplementedProjects= ruleImplementedProjects EOF
            {
             newCompositeNode(grammarAccess.getImplementedProjectsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImplementedProjects=ruleImplementedProjects();

            state._fsp--;

             current =iv_ruleImplementedProjects; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImplementedProjects"


    // $ANTLR start "ruleImplementedProjects"
    // InternalN4MFParser.g:1095:1: ruleImplementedProjects returns [EObject current=null] : ( () otherlv_1= ImplementedProjects otherlv_2= LeftCurlyBracket ( ( (lv_implementedProjects_3_0= ruleProjectReference ) ) (otherlv_4= Comma ( (lv_implementedProjects_5_0= ruleProjectReference ) ) )* )? otherlv_6= RightCurlyBracket ) ;
    public final EObject ruleImplementedProjects() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_implementedProjects_3_0 = null;

        EObject lv_implementedProjects_5_0 = null;



        	enterRule();

        try {
            // InternalN4MFParser.g:1101:2: ( ( () otherlv_1= ImplementedProjects otherlv_2= LeftCurlyBracket ( ( (lv_implementedProjects_3_0= ruleProjectReference ) ) (otherlv_4= Comma ( (lv_implementedProjects_5_0= ruleProjectReference ) ) )* )? otherlv_6= RightCurlyBracket ) )
            // InternalN4MFParser.g:1102:2: ( () otherlv_1= ImplementedProjects otherlv_2= LeftCurlyBracket ( ( (lv_implementedProjects_3_0= ruleProjectReference ) ) (otherlv_4= Comma ( (lv_implementedProjects_5_0= ruleProjectReference ) ) )* )? otherlv_6= RightCurlyBracket )
            {
            // InternalN4MFParser.g:1102:2: ( () otherlv_1= ImplementedProjects otherlv_2= LeftCurlyBracket ( ( (lv_implementedProjects_3_0= ruleProjectReference ) ) (otherlv_4= Comma ( (lv_implementedProjects_5_0= ruleProjectReference ) ) )* )? otherlv_6= RightCurlyBracket )
            // InternalN4MFParser.g:1103:3: () otherlv_1= ImplementedProjects otherlv_2= LeftCurlyBracket ( ( (lv_implementedProjects_3_0= ruleProjectReference ) ) (otherlv_4= Comma ( (lv_implementedProjects_5_0= ruleProjectReference ) ) )* )? otherlv_6= RightCurlyBracket
            {
            // InternalN4MFParser.g:1103:3: ()
            // InternalN4MFParser.g:1104:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getImplementedProjectsAccess().getImplementedProjectsAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,ImplementedProjects,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getImplementedProjectsAccess().getImplementedProjectsKeyword_1());
            		
            otherlv_2=(Token)match(input,LeftCurlyBracket,FOLLOW_16); 

            			newLeafNode(otherlv_2, grammarAccess.getImplementedProjectsAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalN4MFParser.g:1118:3: ( ( (lv_implementedProjects_3_0= ruleProjectReference ) ) (otherlv_4= Comma ( (lv_implementedProjects_5_0= ruleProjectReference ) ) )* )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==ProjectDependencies||LA11_0==ProjectVersion||LA11_0==ModuleFilters||(LA11_0>=ProjectType && LA11_0<=Application)||LA11_0==VendorName||(LA11_0>=Libraries && LA11_0<=VendorId)||LA11_0==Sources||LA11_0==Content||LA11_0==Output||(LA11_0>=Test && LA11_0<=API)||LA11_0==RULE_ID) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalN4MFParser.g:1119:4: ( (lv_implementedProjects_3_0= ruleProjectReference ) ) (otherlv_4= Comma ( (lv_implementedProjects_5_0= ruleProjectReference ) ) )*
                    {
                    // InternalN4MFParser.g:1119:4: ( (lv_implementedProjects_3_0= ruleProjectReference ) )
                    // InternalN4MFParser.g:1120:5: (lv_implementedProjects_3_0= ruleProjectReference )
                    {
                    // InternalN4MFParser.g:1120:5: (lv_implementedProjects_3_0= ruleProjectReference )
                    // InternalN4MFParser.g:1121:6: lv_implementedProjects_3_0= ruleProjectReference
                    {

                    						newCompositeNode(grammarAccess.getImplementedProjectsAccess().getImplementedProjectsProjectReferenceParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_10);
                    lv_implementedProjects_3_0=ruleProjectReference();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getImplementedProjectsRule());
                    						}
                    						add(
                    							current,
                    							"implementedProjects",
                    							lv_implementedProjects_3_0,
                    							"eu.numberfour.n4js.n4mf.N4MF.ProjectReference");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalN4MFParser.g:1138:4: (otherlv_4= Comma ( (lv_implementedProjects_5_0= ruleProjectReference ) ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==Comma) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // InternalN4MFParser.g:1139:5: otherlv_4= Comma ( (lv_implementedProjects_5_0= ruleProjectReference ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FOLLOW_4); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getImplementedProjectsAccess().getCommaKeyword_3_1_0());
                    	    				
                    	    // InternalN4MFParser.g:1143:5: ( (lv_implementedProjects_5_0= ruleProjectReference ) )
                    	    // InternalN4MFParser.g:1144:6: (lv_implementedProjects_5_0= ruleProjectReference )
                    	    {
                    	    // InternalN4MFParser.g:1144:6: (lv_implementedProjects_5_0= ruleProjectReference )
                    	    // InternalN4MFParser.g:1145:7: lv_implementedProjects_5_0= ruleProjectReference
                    	    {

                    	    							newCompositeNode(grammarAccess.getImplementedProjectsAccess().getImplementedProjectsProjectReferenceParserRuleCall_3_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_10);
                    	    lv_implementedProjects_5_0=ruleProjectReference();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getImplementedProjectsRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"implementedProjects",
                    	    								lv_implementedProjects_5_0,
                    	    								"eu.numberfour.n4js.n4mf.N4MF.ProjectReference");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,RightCurlyBracket,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getImplementedProjectsAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImplementedProjects"


    // $ANTLR start "entryRuleProjectDependencies"
    // InternalN4MFParser.g:1172:1: entryRuleProjectDependencies returns [EObject current=null] : iv_ruleProjectDependencies= ruleProjectDependencies EOF ;
    public final EObject entryRuleProjectDependencies() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProjectDependencies = null;


        try {
            // InternalN4MFParser.g:1172:60: (iv_ruleProjectDependencies= ruleProjectDependencies EOF )
            // InternalN4MFParser.g:1173:2: iv_ruleProjectDependencies= ruleProjectDependencies EOF
            {
             newCompositeNode(grammarAccess.getProjectDependenciesRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProjectDependencies=ruleProjectDependencies();

            state._fsp--;

             current =iv_ruleProjectDependencies; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProjectDependencies"


    // $ANTLR start "ruleProjectDependencies"
    // InternalN4MFParser.g:1179:1: ruleProjectDependencies returns [EObject current=null] : ( () otherlv_1= ProjectDependencies otherlv_2= LeftCurlyBracket ( ( (lv_projectDependencies_3_0= ruleProjectDependency ) ) (otherlv_4= Comma ( (lv_projectDependencies_5_0= ruleProjectDependency ) ) )* )? otherlv_6= RightCurlyBracket ) ;
    public final EObject ruleProjectDependencies() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_projectDependencies_3_0 = null;

        EObject lv_projectDependencies_5_0 = null;



        	enterRule();

        try {
            // InternalN4MFParser.g:1185:2: ( ( () otherlv_1= ProjectDependencies otherlv_2= LeftCurlyBracket ( ( (lv_projectDependencies_3_0= ruleProjectDependency ) ) (otherlv_4= Comma ( (lv_projectDependencies_5_0= ruleProjectDependency ) ) )* )? otherlv_6= RightCurlyBracket ) )
            // InternalN4MFParser.g:1186:2: ( () otherlv_1= ProjectDependencies otherlv_2= LeftCurlyBracket ( ( (lv_projectDependencies_3_0= ruleProjectDependency ) ) (otherlv_4= Comma ( (lv_projectDependencies_5_0= ruleProjectDependency ) ) )* )? otherlv_6= RightCurlyBracket )
            {
            // InternalN4MFParser.g:1186:2: ( () otherlv_1= ProjectDependencies otherlv_2= LeftCurlyBracket ( ( (lv_projectDependencies_3_0= ruleProjectDependency ) ) (otherlv_4= Comma ( (lv_projectDependencies_5_0= ruleProjectDependency ) ) )* )? otherlv_6= RightCurlyBracket )
            // InternalN4MFParser.g:1187:3: () otherlv_1= ProjectDependencies otherlv_2= LeftCurlyBracket ( ( (lv_projectDependencies_3_0= ruleProjectDependency ) ) (otherlv_4= Comma ( (lv_projectDependencies_5_0= ruleProjectDependency ) ) )* )? otherlv_6= RightCurlyBracket
            {
            // InternalN4MFParser.g:1187:3: ()
            // InternalN4MFParser.g:1188:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getProjectDependenciesAccess().getProjectDependenciesAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,ProjectDependencies,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getProjectDependenciesAccess().getProjectDependenciesKeyword_1());
            		
            otherlv_2=(Token)match(input,LeftCurlyBracket,FOLLOW_16); 

            			newLeafNode(otherlv_2, grammarAccess.getProjectDependenciesAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalN4MFParser.g:1202:3: ( ( (lv_projectDependencies_3_0= ruleProjectDependency ) ) (otherlv_4= Comma ( (lv_projectDependencies_5_0= ruleProjectDependency ) ) )* )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==ProjectDependencies||LA13_0==ProjectVersion||LA13_0==ModuleFilters||(LA13_0>=ProjectType && LA13_0<=Application)||LA13_0==VendorName||(LA13_0>=Libraries && LA13_0<=VendorId)||LA13_0==Sources||LA13_0==Content||LA13_0==Output||(LA13_0>=Test && LA13_0<=API)||LA13_0==RULE_ID) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalN4MFParser.g:1203:4: ( (lv_projectDependencies_3_0= ruleProjectDependency ) ) (otherlv_4= Comma ( (lv_projectDependencies_5_0= ruleProjectDependency ) ) )*
                    {
                    // InternalN4MFParser.g:1203:4: ( (lv_projectDependencies_3_0= ruleProjectDependency ) )
                    // InternalN4MFParser.g:1204:5: (lv_projectDependencies_3_0= ruleProjectDependency )
                    {
                    // InternalN4MFParser.g:1204:5: (lv_projectDependencies_3_0= ruleProjectDependency )
                    // InternalN4MFParser.g:1205:6: lv_projectDependencies_3_0= ruleProjectDependency
                    {

                    						newCompositeNode(grammarAccess.getProjectDependenciesAccess().getProjectDependenciesProjectDependencyParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_10);
                    lv_projectDependencies_3_0=ruleProjectDependency();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getProjectDependenciesRule());
                    						}
                    						add(
                    							current,
                    							"projectDependencies",
                    							lv_projectDependencies_3_0,
                    							"eu.numberfour.n4js.n4mf.N4MF.ProjectDependency");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalN4MFParser.g:1222:4: (otherlv_4= Comma ( (lv_projectDependencies_5_0= ruleProjectDependency ) ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==Comma) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalN4MFParser.g:1223:5: otherlv_4= Comma ( (lv_projectDependencies_5_0= ruleProjectDependency ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FOLLOW_4); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getProjectDependenciesAccess().getCommaKeyword_3_1_0());
                    	    				
                    	    // InternalN4MFParser.g:1227:5: ( (lv_projectDependencies_5_0= ruleProjectDependency ) )
                    	    // InternalN4MFParser.g:1228:6: (lv_projectDependencies_5_0= ruleProjectDependency )
                    	    {
                    	    // InternalN4MFParser.g:1228:6: (lv_projectDependencies_5_0= ruleProjectDependency )
                    	    // InternalN4MFParser.g:1229:7: lv_projectDependencies_5_0= ruleProjectDependency
                    	    {

                    	    							newCompositeNode(grammarAccess.getProjectDependenciesAccess().getProjectDependenciesProjectDependencyParserRuleCall_3_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_10);
                    	    lv_projectDependencies_5_0=ruleProjectDependency();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getProjectDependenciesRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"projectDependencies",
                    	    								lv_projectDependencies_5_0,
                    	    								"eu.numberfour.n4js.n4mf.N4MF.ProjectDependency");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,RightCurlyBracket,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getProjectDependenciesAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProjectDependencies"


    // $ANTLR start "entryRuleProvidedRuntimeLibraries"
    // InternalN4MFParser.g:1256:1: entryRuleProvidedRuntimeLibraries returns [EObject current=null] : iv_ruleProvidedRuntimeLibraries= ruleProvidedRuntimeLibraries EOF ;
    public final EObject entryRuleProvidedRuntimeLibraries() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProvidedRuntimeLibraries = null;


        try {
            // InternalN4MFParser.g:1256:65: (iv_ruleProvidedRuntimeLibraries= ruleProvidedRuntimeLibraries EOF )
            // InternalN4MFParser.g:1257:2: iv_ruleProvidedRuntimeLibraries= ruleProvidedRuntimeLibraries EOF
            {
             newCompositeNode(grammarAccess.getProvidedRuntimeLibrariesRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProvidedRuntimeLibraries=ruleProvidedRuntimeLibraries();

            state._fsp--;

             current =iv_ruleProvidedRuntimeLibraries; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProvidedRuntimeLibraries"


    // $ANTLR start "ruleProvidedRuntimeLibraries"
    // InternalN4MFParser.g:1263:1: ruleProvidedRuntimeLibraries returns [EObject current=null] : ( () otherlv_1= ProvidedRuntimeLibraries otherlv_2= LeftCurlyBracket ( ( (lv_providedRuntimeLibraries_3_0= ruleProvidedRuntimeLibraryDependency ) ) (otherlv_4= Comma ( (lv_providedRuntimeLibraries_5_0= ruleProvidedRuntimeLibraryDependency ) ) )* )? otherlv_6= RightCurlyBracket ) ;
    public final EObject ruleProvidedRuntimeLibraries() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_providedRuntimeLibraries_3_0 = null;

        EObject lv_providedRuntimeLibraries_5_0 = null;



        	enterRule();

        try {
            // InternalN4MFParser.g:1269:2: ( ( () otherlv_1= ProvidedRuntimeLibraries otherlv_2= LeftCurlyBracket ( ( (lv_providedRuntimeLibraries_3_0= ruleProvidedRuntimeLibraryDependency ) ) (otherlv_4= Comma ( (lv_providedRuntimeLibraries_5_0= ruleProvidedRuntimeLibraryDependency ) ) )* )? otherlv_6= RightCurlyBracket ) )
            // InternalN4MFParser.g:1270:2: ( () otherlv_1= ProvidedRuntimeLibraries otherlv_2= LeftCurlyBracket ( ( (lv_providedRuntimeLibraries_3_0= ruleProvidedRuntimeLibraryDependency ) ) (otherlv_4= Comma ( (lv_providedRuntimeLibraries_5_0= ruleProvidedRuntimeLibraryDependency ) ) )* )? otherlv_6= RightCurlyBracket )
            {
            // InternalN4MFParser.g:1270:2: ( () otherlv_1= ProvidedRuntimeLibraries otherlv_2= LeftCurlyBracket ( ( (lv_providedRuntimeLibraries_3_0= ruleProvidedRuntimeLibraryDependency ) ) (otherlv_4= Comma ( (lv_providedRuntimeLibraries_5_0= ruleProvidedRuntimeLibraryDependency ) ) )* )? otherlv_6= RightCurlyBracket )
            // InternalN4MFParser.g:1271:3: () otherlv_1= ProvidedRuntimeLibraries otherlv_2= LeftCurlyBracket ( ( (lv_providedRuntimeLibraries_3_0= ruleProvidedRuntimeLibraryDependency ) ) (otherlv_4= Comma ( (lv_providedRuntimeLibraries_5_0= ruleProvidedRuntimeLibraryDependency ) ) )* )? otherlv_6= RightCurlyBracket
            {
            // InternalN4MFParser.g:1271:3: ()
            // InternalN4MFParser.g:1272:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getProvidedRuntimeLibrariesAccess().getProvidedRuntimeLibrariesAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,ProvidedRuntimeLibraries,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getProvidedRuntimeLibrariesAccess().getProvidedRuntimeLibrariesKeyword_1());
            		
            otherlv_2=(Token)match(input,LeftCurlyBracket,FOLLOW_16); 

            			newLeafNode(otherlv_2, grammarAccess.getProvidedRuntimeLibrariesAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalN4MFParser.g:1286:3: ( ( (lv_providedRuntimeLibraries_3_0= ruleProvidedRuntimeLibraryDependency ) ) (otherlv_4= Comma ( (lv_providedRuntimeLibraries_5_0= ruleProvidedRuntimeLibraryDependency ) ) )* )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==ProjectDependencies||LA15_0==ProjectVersion||LA15_0==ModuleFilters||(LA15_0>=ProjectType && LA15_0<=Application)||LA15_0==VendorName||(LA15_0>=Libraries && LA15_0<=VendorId)||LA15_0==Sources||LA15_0==Content||LA15_0==Output||(LA15_0>=Test && LA15_0<=API)||LA15_0==RULE_ID) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalN4MFParser.g:1287:4: ( (lv_providedRuntimeLibraries_3_0= ruleProvidedRuntimeLibraryDependency ) ) (otherlv_4= Comma ( (lv_providedRuntimeLibraries_5_0= ruleProvidedRuntimeLibraryDependency ) ) )*
                    {
                    // InternalN4MFParser.g:1287:4: ( (lv_providedRuntimeLibraries_3_0= ruleProvidedRuntimeLibraryDependency ) )
                    // InternalN4MFParser.g:1288:5: (lv_providedRuntimeLibraries_3_0= ruleProvidedRuntimeLibraryDependency )
                    {
                    // InternalN4MFParser.g:1288:5: (lv_providedRuntimeLibraries_3_0= ruleProvidedRuntimeLibraryDependency )
                    // InternalN4MFParser.g:1289:6: lv_providedRuntimeLibraries_3_0= ruleProvidedRuntimeLibraryDependency
                    {

                    						newCompositeNode(grammarAccess.getProvidedRuntimeLibrariesAccess().getProvidedRuntimeLibrariesProvidedRuntimeLibraryDependencyParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_10);
                    lv_providedRuntimeLibraries_3_0=ruleProvidedRuntimeLibraryDependency();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getProvidedRuntimeLibrariesRule());
                    						}
                    						add(
                    							current,
                    							"providedRuntimeLibraries",
                    							lv_providedRuntimeLibraries_3_0,
                    							"eu.numberfour.n4js.n4mf.N4MF.ProvidedRuntimeLibraryDependency");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalN4MFParser.g:1306:4: (otherlv_4= Comma ( (lv_providedRuntimeLibraries_5_0= ruleProvidedRuntimeLibraryDependency ) ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==Comma) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalN4MFParser.g:1307:5: otherlv_4= Comma ( (lv_providedRuntimeLibraries_5_0= ruleProvidedRuntimeLibraryDependency ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FOLLOW_4); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getProvidedRuntimeLibrariesAccess().getCommaKeyword_3_1_0());
                    	    				
                    	    // InternalN4MFParser.g:1311:5: ( (lv_providedRuntimeLibraries_5_0= ruleProvidedRuntimeLibraryDependency ) )
                    	    // InternalN4MFParser.g:1312:6: (lv_providedRuntimeLibraries_5_0= ruleProvidedRuntimeLibraryDependency )
                    	    {
                    	    // InternalN4MFParser.g:1312:6: (lv_providedRuntimeLibraries_5_0= ruleProvidedRuntimeLibraryDependency )
                    	    // InternalN4MFParser.g:1313:7: lv_providedRuntimeLibraries_5_0= ruleProvidedRuntimeLibraryDependency
                    	    {

                    	    							newCompositeNode(grammarAccess.getProvidedRuntimeLibrariesAccess().getProvidedRuntimeLibrariesProvidedRuntimeLibraryDependencyParserRuleCall_3_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_10);
                    	    lv_providedRuntimeLibraries_5_0=ruleProvidedRuntimeLibraryDependency();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getProvidedRuntimeLibrariesRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"providedRuntimeLibraries",
                    	    								lv_providedRuntimeLibraries_5_0,
                    	    								"eu.numberfour.n4js.n4mf.N4MF.ProvidedRuntimeLibraryDependency");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,RightCurlyBracket,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getProvidedRuntimeLibrariesAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProvidedRuntimeLibraries"


    // $ANTLR start "entryRuleRequiredRuntimeLibraries"
    // InternalN4MFParser.g:1340:1: entryRuleRequiredRuntimeLibraries returns [EObject current=null] : iv_ruleRequiredRuntimeLibraries= ruleRequiredRuntimeLibraries EOF ;
    public final EObject entryRuleRequiredRuntimeLibraries() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRequiredRuntimeLibraries = null;


        try {
            // InternalN4MFParser.g:1340:65: (iv_ruleRequiredRuntimeLibraries= ruleRequiredRuntimeLibraries EOF )
            // InternalN4MFParser.g:1341:2: iv_ruleRequiredRuntimeLibraries= ruleRequiredRuntimeLibraries EOF
            {
             newCompositeNode(grammarAccess.getRequiredRuntimeLibrariesRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRequiredRuntimeLibraries=ruleRequiredRuntimeLibraries();

            state._fsp--;

             current =iv_ruleRequiredRuntimeLibraries; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRequiredRuntimeLibraries"


    // $ANTLR start "ruleRequiredRuntimeLibraries"
    // InternalN4MFParser.g:1347:1: ruleRequiredRuntimeLibraries returns [EObject current=null] : ( () otherlv_1= RequiredRuntimeLibraries otherlv_2= LeftCurlyBracket ( ( (lv_requiredRuntimeLibraries_3_0= ruleRequiredRuntimeLibraryDependency ) ) (otherlv_4= Comma ( (lv_requiredRuntimeLibraries_5_0= ruleRequiredRuntimeLibraryDependency ) ) )* )? otherlv_6= RightCurlyBracket ) ;
    public final EObject ruleRequiredRuntimeLibraries() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_requiredRuntimeLibraries_3_0 = null;

        EObject lv_requiredRuntimeLibraries_5_0 = null;



        	enterRule();

        try {
            // InternalN4MFParser.g:1353:2: ( ( () otherlv_1= RequiredRuntimeLibraries otherlv_2= LeftCurlyBracket ( ( (lv_requiredRuntimeLibraries_3_0= ruleRequiredRuntimeLibraryDependency ) ) (otherlv_4= Comma ( (lv_requiredRuntimeLibraries_5_0= ruleRequiredRuntimeLibraryDependency ) ) )* )? otherlv_6= RightCurlyBracket ) )
            // InternalN4MFParser.g:1354:2: ( () otherlv_1= RequiredRuntimeLibraries otherlv_2= LeftCurlyBracket ( ( (lv_requiredRuntimeLibraries_3_0= ruleRequiredRuntimeLibraryDependency ) ) (otherlv_4= Comma ( (lv_requiredRuntimeLibraries_5_0= ruleRequiredRuntimeLibraryDependency ) ) )* )? otherlv_6= RightCurlyBracket )
            {
            // InternalN4MFParser.g:1354:2: ( () otherlv_1= RequiredRuntimeLibraries otherlv_2= LeftCurlyBracket ( ( (lv_requiredRuntimeLibraries_3_0= ruleRequiredRuntimeLibraryDependency ) ) (otherlv_4= Comma ( (lv_requiredRuntimeLibraries_5_0= ruleRequiredRuntimeLibraryDependency ) ) )* )? otherlv_6= RightCurlyBracket )
            // InternalN4MFParser.g:1355:3: () otherlv_1= RequiredRuntimeLibraries otherlv_2= LeftCurlyBracket ( ( (lv_requiredRuntimeLibraries_3_0= ruleRequiredRuntimeLibraryDependency ) ) (otherlv_4= Comma ( (lv_requiredRuntimeLibraries_5_0= ruleRequiredRuntimeLibraryDependency ) ) )* )? otherlv_6= RightCurlyBracket
            {
            // InternalN4MFParser.g:1355:3: ()
            // InternalN4MFParser.g:1356:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getRequiredRuntimeLibrariesAccess().getRequiredRuntimeLibrariesAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,RequiredRuntimeLibraries,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getRequiredRuntimeLibrariesAccess().getRequiredRuntimeLibrariesKeyword_1());
            		
            otherlv_2=(Token)match(input,LeftCurlyBracket,FOLLOW_16); 

            			newLeafNode(otherlv_2, grammarAccess.getRequiredRuntimeLibrariesAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalN4MFParser.g:1370:3: ( ( (lv_requiredRuntimeLibraries_3_0= ruleRequiredRuntimeLibraryDependency ) ) (otherlv_4= Comma ( (lv_requiredRuntimeLibraries_5_0= ruleRequiredRuntimeLibraryDependency ) ) )* )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==ProjectDependencies||LA17_0==ProjectVersion||LA17_0==ModuleFilters||(LA17_0>=ProjectType && LA17_0<=Application)||LA17_0==VendorName||(LA17_0>=Libraries && LA17_0<=VendorId)||LA17_0==Sources||LA17_0==Content||LA17_0==Output||(LA17_0>=Test && LA17_0<=API)||LA17_0==RULE_ID) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalN4MFParser.g:1371:4: ( (lv_requiredRuntimeLibraries_3_0= ruleRequiredRuntimeLibraryDependency ) ) (otherlv_4= Comma ( (lv_requiredRuntimeLibraries_5_0= ruleRequiredRuntimeLibraryDependency ) ) )*
                    {
                    // InternalN4MFParser.g:1371:4: ( (lv_requiredRuntimeLibraries_3_0= ruleRequiredRuntimeLibraryDependency ) )
                    // InternalN4MFParser.g:1372:5: (lv_requiredRuntimeLibraries_3_0= ruleRequiredRuntimeLibraryDependency )
                    {
                    // InternalN4MFParser.g:1372:5: (lv_requiredRuntimeLibraries_3_0= ruleRequiredRuntimeLibraryDependency )
                    // InternalN4MFParser.g:1373:6: lv_requiredRuntimeLibraries_3_0= ruleRequiredRuntimeLibraryDependency
                    {

                    						newCompositeNode(grammarAccess.getRequiredRuntimeLibrariesAccess().getRequiredRuntimeLibrariesRequiredRuntimeLibraryDependencyParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_10);
                    lv_requiredRuntimeLibraries_3_0=ruleRequiredRuntimeLibraryDependency();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRequiredRuntimeLibrariesRule());
                    						}
                    						add(
                    							current,
                    							"requiredRuntimeLibraries",
                    							lv_requiredRuntimeLibraries_3_0,
                    							"eu.numberfour.n4js.n4mf.N4MF.RequiredRuntimeLibraryDependency");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalN4MFParser.g:1390:4: (otherlv_4= Comma ( (lv_requiredRuntimeLibraries_5_0= ruleRequiredRuntimeLibraryDependency ) ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==Comma) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // InternalN4MFParser.g:1391:5: otherlv_4= Comma ( (lv_requiredRuntimeLibraries_5_0= ruleRequiredRuntimeLibraryDependency ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FOLLOW_4); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getRequiredRuntimeLibrariesAccess().getCommaKeyword_3_1_0());
                    	    				
                    	    // InternalN4MFParser.g:1395:5: ( (lv_requiredRuntimeLibraries_5_0= ruleRequiredRuntimeLibraryDependency ) )
                    	    // InternalN4MFParser.g:1396:6: (lv_requiredRuntimeLibraries_5_0= ruleRequiredRuntimeLibraryDependency )
                    	    {
                    	    // InternalN4MFParser.g:1396:6: (lv_requiredRuntimeLibraries_5_0= ruleRequiredRuntimeLibraryDependency )
                    	    // InternalN4MFParser.g:1397:7: lv_requiredRuntimeLibraries_5_0= ruleRequiredRuntimeLibraryDependency
                    	    {

                    	    							newCompositeNode(grammarAccess.getRequiredRuntimeLibrariesAccess().getRequiredRuntimeLibrariesRequiredRuntimeLibraryDependencyParserRuleCall_3_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_10);
                    	    lv_requiredRuntimeLibraries_5_0=ruleRequiredRuntimeLibraryDependency();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getRequiredRuntimeLibrariesRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"requiredRuntimeLibraries",
                    	    								lv_requiredRuntimeLibraries_5_0,
                    	    								"eu.numberfour.n4js.n4mf.N4MF.RequiredRuntimeLibraryDependency");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,RightCurlyBracket,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getRequiredRuntimeLibrariesAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRequiredRuntimeLibraries"


    // $ANTLR start "entryRuleExtendedRuntimeEnvironment"
    // InternalN4MFParser.g:1424:1: entryRuleExtendedRuntimeEnvironment returns [EObject current=null] : iv_ruleExtendedRuntimeEnvironment= ruleExtendedRuntimeEnvironment EOF ;
    public final EObject entryRuleExtendedRuntimeEnvironment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExtendedRuntimeEnvironment = null;


        try {
            // InternalN4MFParser.g:1424:67: (iv_ruleExtendedRuntimeEnvironment= ruleExtendedRuntimeEnvironment EOF )
            // InternalN4MFParser.g:1425:2: iv_ruleExtendedRuntimeEnvironment= ruleExtendedRuntimeEnvironment EOF
            {
             newCompositeNode(grammarAccess.getExtendedRuntimeEnvironmentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExtendedRuntimeEnvironment=ruleExtendedRuntimeEnvironment();

            state._fsp--;

             current =iv_ruleExtendedRuntimeEnvironment; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExtendedRuntimeEnvironment"


    // $ANTLR start "ruleExtendedRuntimeEnvironment"
    // InternalN4MFParser.g:1431:1: ruleExtendedRuntimeEnvironment returns [EObject current=null] : ( () otherlv_1= ExtendedRuntimeEnvironment otherlv_2= Colon ( (lv_extendedRuntimeEnvironment_3_0= ruleProjectReference ) ) ) ;
    public final EObject ruleExtendedRuntimeEnvironment() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_extendedRuntimeEnvironment_3_0 = null;



        	enterRule();

        try {
            // InternalN4MFParser.g:1437:2: ( ( () otherlv_1= ExtendedRuntimeEnvironment otherlv_2= Colon ( (lv_extendedRuntimeEnvironment_3_0= ruleProjectReference ) ) ) )
            // InternalN4MFParser.g:1438:2: ( () otherlv_1= ExtendedRuntimeEnvironment otherlv_2= Colon ( (lv_extendedRuntimeEnvironment_3_0= ruleProjectReference ) ) )
            {
            // InternalN4MFParser.g:1438:2: ( () otherlv_1= ExtendedRuntimeEnvironment otherlv_2= Colon ( (lv_extendedRuntimeEnvironment_3_0= ruleProjectReference ) ) )
            // InternalN4MFParser.g:1439:3: () otherlv_1= ExtendedRuntimeEnvironment otherlv_2= Colon ( (lv_extendedRuntimeEnvironment_3_0= ruleProjectReference ) )
            {
            // InternalN4MFParser.g:1439:3: ()
            // InternalN4MFParser.g:1440:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getExtendedRuntimeEnvironmentAccess().getExtendedRuntimeEnvironmentAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,ExtendedRuntimeEnvironment,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getExtendedRuntimeEnvironmentAccess().getExtendedRuntimeEnvironmentKeyword_1());
            		
            otherlv_2=(Token)match(input,Colon,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getExtendedRuntimeEnvironmentAccess().getColonKeyword_2());
            		
            // InternalN4MFParser.g:1454:3: ( (lv_extendedRuntimeEnvironment_3_0= ruleProjectReference ) )
            // InternalN4MFParser.g:1455:4: (lv_extendedRuntimeEnvironment_3_0= ruleProjectReference )
            {
            // InternalN4MFParser.g:1455:4: (lv_extendedRuntimeEnvironment_3_0= ruleProjectReference )
            // InternalN4MFParser.g:1456:5: lv_extendedRuntimeEnvironment_3_0= ruleProjectReference
            {

            					newCompositeNode(grammarAccess.getExtendedRuntimeEnvironmentAccess().getExtendedRuntimeEnvironmentProjectReferenceParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_extendedRuntimeEnvironment_3_0=ruleProjectReference();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExtendedRuntimeEnvironmentRule());
            					}
            					set(
            						current,
            						"extendedRuntimeEnvironment",
            						lv_extendedRuntimeEnvironment_3_0,
            						"eu.numberfour.n4js.n4mf.N4MF.ProjectReference");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExtendedRuntimeEnvironment"


    // $ANTLR start "entryRuleDeclaredVersion"
    // InternalN4MFParser.g:1477:1: entryRuleDeclaredVersion returns [EObject current=null] : iv_ruleDeclaredVersion= ruleDeclaredVersion EOF ;
    public final EObject entryRuleDeclaredVersion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaredVersion = null;


        try {
            // InternalN4MFParser.g:1477:56: (iv_ruleDeclaredVersion= ruleDeclaredVersion EOF )
            // InternalN4MFParser.g:1478:2: iv_ruleDeclaredVersion= ruleDeclaredVersion EOF
            {
             newCompositeNode(grammarAccess.getDeclaredVersionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDeclaredVersion=ruleDeclaredVersion();

            state._fsp--;

             current =iv_ruleDeclaredVersion; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDeclaredVersion"


    // $ANTLR start "ruleDeclaredVersion"
    // InternalN4MFParser.g:1484:1: ruleDeclaredVersion returns [EObject current=null] : ( ( (lv_major_0_0= RULE_INT ) ) (otherlv_1= FullStop ( (lv_minor_2_0= RULE_INT ) ) (otherlv_3= FullStop ( (lv_micro_4_0= RULE_INT ) ) )? )? (otherlv_5= HyphenMinus ( (lv_qualifier_6_0= ruleN4mfIdentifier ) ) )? ) ;
    public final EObject ruleDeclaredVersion() throws RecognitionException {
        EObject current = null;

        Token lv_major_0_0=null;
        Token otherlv_1=null;
        Token lv_minor_2_0=null;
        Token otherlv_3=null;
        Token lv_micro_4_0=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_qualifier_6_0 = null;



        	enterRule();

        try {
            // InternalN4MFParser.g:1490:2: ( ( ( (lv_major_0_0= RULE_INT ) ) (otherlv_1= FullStop ( (lv_minor_2_0= RULE_INT ) ) (otherlv_3= FullStop ( (lv_micro_4_0= RULE_INT ) ) )? )? (otherlv_5= HyphenMinus ( (lv_qualifier_6_0= ruleN4mfIdentifier ) ) )? ) )
            // InternalN4MFParser.g:1491:2: ( ( (lv_major_0_0= RULE_INT ) ) (otherlv_1= FullStop ( (lv_minor_2_0= RULE_INT ) ) (otherlv_3= FullStop ( (lv_micro_4_0= RULE_INT ) ) )? )? (otherlv_5= HyphenMinus ( (lv_qualifier_6_0= ruleN4mfIdentifier ) ) )? )
            {
            // InternalN4MFParser.g:1491:2: ( ( (lv_major_0_0= RULE_INT ) ) (otherlv_1= FullStop ( (lv_minor_2_0= RULE_INT ) ) (otherlv_3= FullStop ( (lv_micro_4_0= RULE_INT ) ) )? )? (otherlv_5= HyphenMinus ( (lv_qualifier_6_0= ruleN4mfIdentifier ) ) )? )
            // InternalN4MFParser.g:1492:3: ( (lv_major_0_0= RULE_INT ) ) (otherlv_1= FullStop ( (lv_minor_2_0= RULE_INT ) ) (otherlv_3= FullStop ( (lv_micro_4_0= RULE_INT ) ) )? )? (otherlv_5= HyphenMinus ( (lv_qualifier_6_0= ruleN4mfIdentifier ) ) )?
            {
            // InternalN4MFParser.g:1492:3: ( (lv_major_0_0= RULE_INT ) )
            // InternalN4MFParser.g:1493:4: (lv_major_0_0= RULE_INT )
            {
            // InternalN4MFParser.g:1493:4: (lv_major_0_0= RULE_INT )
            // InternalN4MFParser.g:1494:5: lv_major_0_0= RULE_INT
            {
            lv_major_0_0=(Token)match(input,RULE_INT,FOLLOW_18); 

            					newLeafNode(lv_major_0_0, grammarAccess.getDeclaredVersionAccess().getMajorINTTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDeclaredVersionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"major",
            						lv_major_0_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            // InternalN4MFParser.g:1510:3: (otherlv_1= FullStop ( (lv_minor_2_0= RULE_INT ) ) (otherlv_3= FullStop ( (lv_micro_4_0= RULE_INT ) ) )? )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==FullStop) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalN4MFParser.g:1511:4: otherlv_1= FullStop ( (lv_minor_2_0= RULE_INT ) ) (otherlv_3= FullStop ( (lv_micro_4_0= RULE_INT ) ) )?
                    {
                    otherlv_1=(Token)match(input,FullStop,FOLLOW_7); 

                    				newLeafNode(otherlv_1, grammarAccess.getDeclaredVersionAccess().getFullStopKeyword_1_0());
                    			
                    // InternalN4MFParser.g:1515:4: ( (lv_minor_2_0= RULE_INT ) )
                    // InternalN4MFParser.g:1516:5: (lv_minor_2_0= RULE_INT )
                    {
                    // InternalN4MFParser.g:1516:5: (lv_minor_2_0= RULE_INT )
                    // InternalN4MFParser.g:1517:6: lv_minor_2_0= RULE_INT
                    {
                    lv_minor_2_0=(Token)match(input,RULE_INT,FOLLOW_18); 

                    						newLeafNode(lv_minor_2_0, grammarAccess.getDeclaredVersionAccess().getMinorINTTerminalRuleCall_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDeclaredVersionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"minor",
                    							lv_minor_2_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }

                    // InternalN4MFParser.g:1533:4: (otherlv_3= FullStop ( (lv_micro_4_0= RULE_INT ) ) )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==FullStop) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // InternalN4MFParser.g:1534:5: otherlv_3= FullStop ( (lv_micro_4_0= RULE_INT ) )
                            {
                            otherlv_3=(Token)match(input,FullStop,FOLLOW_7); 

                            					newLeafNode(otherlv_3, grammarAccess.getDeclaredVersionAccess().getFullStopKeyword_1_2_0());
                            				
                            // InternalN4MFParser.g:1538:5: ( (lv_micro_4_0= RULE_INT ) )
                            // InternalN4MFParser.g:1539:6: (lv_micro_4_0= RULE_INT )
                            {
                            // InternalN4MFParser.g:1539:6: (lv_micro_4_0= RULE_INT )
                            // InternalN4MFParser.g:1540:7: lv_micro_4_0= RULE_INT
                            {
                            lv_micro_4_0=(Token)match(input,RULE_INT,FOLLOW_19); 

                            							newLeafNode(lv_micro_4_0, grammarAccess.getDeclaredVersionAccess().getMicroINTTerminalRuleCall_1_2_1_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getDeclaredVersionRule());
                            							}
                            							setWithLastConsumed(
                            								current,
                            								"micro",
                            								lv_micro_4_0,
                            								"org.eclipse.xtext.common.Terminals.INT");
                            						

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalN4MFParser.g:1558:3: (otherlv_5= HyphenMinus ( (lv_qualifier_6_0= ruleN4mfIdentifier ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==HyphenMinus) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalN4MFParser.g:1559:4: otherlv_5= HyphenMinus ( (lv_qualifier_6_0= ruleN4mfIdentifier ) )
                    {
                    otherlv_5=(Token)match(input,HyphenMinus,FOLLOW_4); 

                    				newLeafNode(otherlv_5, grammarAccess.getDeclaredVersionAccess().getHyphenMinusKeyword_2_0());
                    			
                    // InternalN4MFParser.g:1563:4: ( (lv_qualifier_6_0= ruleN4mfIdentifier ) )
                    // InternalN4MFParser.g:1564:5: (lv_qualifier_6_0= ruleN4mfIdentifier )
                    {
                    // InternalN4MFParser.g:1564:5: (lv_qualifier_6_0= ruleN4mfIdentifier )
                    // InternalN4MFParser.g:1565:6: lv_qualifier_6_0= ruleN4mfIdentifier
                    {

                    						newCompositeNode(grammarAccess.getDeclaredVersionAccess().getQualifierN4mfIdentifierParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_qualifier_6_0=ruleN4mfIdentifier();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDeclaredVersionRule());
                    						}
                    						set(
                    							current,
                    							"qualifier",
                    							lv_qualifier_6_0,
                    							"eu.numberfour.n4js.n4mf.N4MF.N4mfIdentifier");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDeclaredVersion"


    // $ANTLR start "entryRuleSourceFragment"
    // InternalN4MFParser.g:1587:1: entryRuleSourceFragment returns [EObject current=null] : iv_ruleSourceFragment= ruleSourceFragment EOF ;
    public final EObject entryRuleSourceFragment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSourceFragment = null;


        try {
            // InternalN4MFParser.g:1587:55: (iv_ruleSourceFragment= ruleSourceFragment EOF )
            // InternalN4MFParser.g:1588:2: iv_ruleSourceFragment= ruleSourceFragment EOF
            {
             newCompositeNode(grammarAccess.getSourceFragmentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSourceFragment=ruleSourceFragment();

            state._fsp--;

             current =iv_ruleSourceFragment; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSourceFragment"


    // $ANTLR start "ruleSourceFragment"
    // InternalN4MFParser.g:1594:1: ruleSourceFragment returns [EObject current=null] : ( ( (lv_sourceFragmentType_0_0= ruleSourceFragmentType ) ) otherlv_1= LeftCurlyBracket ( (lv_paths_2_0= RULE_STRING ) ) (otherlv_3= Comma ( (lv_paths_4_0= RULE_STRING ) ) )* otherlv_5= RightCurlyBracket ) ;
    public final EObject ruleSourceFragment() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_paths_2_0=null;
        Token otherlv_3=null;
        Token lv_paths_4_0=null;
        Token otherlv_5=null;
        Enumerator lv_sourceFragmentType_0_0 = null;



        	enterRule();

        try {
            // InternalN4MFParser.g:1600:2: ( ( ( (lv_sourceFragmentType_0_0= ruleSourceFragmentType ) ) otherlv_1= LeftCurlyBracket ( (lv_paths_2_0= RULE_STRING ) ) (otherlv_3= Comma ( (lv_paths_4_0= RULE_STRING ) ) )* otherlv_5= RightCurlyBracket ) )
            // InternalN4MFParser.g:1601:2: ( ( (lv_sourceFragmentType_0_0= ruleSourceFragmentType ) ) otherlv_1= LeftCurlyBracket ( (lv_paths_2_0= RULE_STRING ) ) (otherlv_3= Comma ( (lv_paths_4_0= RULE_STRING ) ) )* otherlv_5= RightCurlyBracket )
            {
            // InternalN4MFParser.g:1601:2: ( ( (lv_sourceFragmentType_0_0= ruleSourceFragmentType ) ) otherlv_1= LeftCurlyBracket ( (lv_paths_2_0= RULE_STRING ) ) (otherlv_3= Comma ( (lv_paths_4_0= RULE_STRING ) ) )* otherlv_5= RightCurlyBracket )
            // InternalN4MFParser.g:1602:3: ( (lv_sourceFragmentType_0_0= ruleSourceFragmentType ) ) otherlv_1= LeftCurlyBracket ( (lv_paths_2_0= RULE_STRING ) ) (otherlv_3= Comma ( (lv_paths_4_0= RULE_STRING ) ) )* otherlv_5= RightCurlyBracket
            {
            // InternalN4MFParser.g:1602:3: ( (lv_sourceFragmentType_0_0= ruleSourceFragmentType ) )
            // InternalN4MFParser.g:1603:4: (lv_sourceFragmentType_0_0= ruleSourceFragmentType )
            {
            // InternalN4MFParser.g:1603:4: (lv_sourceFragmentType_0_0= ruleSourceFragmentType )
            // InternalN4MFParser.g:1604:5: lv_sourceFragmentType_0_0= ruleSourceFragmentType
            {

            					newCompositeNode(grammarAccess.getSourceFragmentAccess().getSourceFragmentTypeSourceFragmentTypeEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_9);
            lv_sourceFragmentType_0_0=ruleSourceFragmentType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSourceFragmentRule());
            					}
            					set(
            						current,
            						"sourceFragmentType",
            						lv_sourceFragmentType_0_0,
            						"eu.numberfour.n4js.n4mf.N4MF.SourceFragmentType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,LeftCurlyBracket,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getSourceFragmentAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalN4MFParser.g:1625:3: ( (lv_paths_2_0= RULE_STRING ) )
            // InternalN4MFParser.g:1626:4: (lv_paths_2_0= RULE_STRING )
            {
            // InternalN4MFParser.g:1626:4: (lv_paths_2_0= RULE_STRING )
            // InternalN4MFParser.g:1627:5: lv_paths_2_0= RULE_STRING
            {
            lv_paths_2_0=(Token)match(input,RULE_STRING,FOLLOW_10); 

            					newLeafNode(lv_paths_2_0, grammarAccess.getSourceFragmentAccess().getPathsSTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSourceFragmentRule());
            					}
            					addWithLastConsumed(
            						current,
            						"paths",
            						lv_paths_2_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalN4MFParser.g:1643:3: (otherlv_3= Comma ( (lv_paths_4_0= RULE_STRING ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==Comma) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalN4MFParser.g:1644:4: otherlv_3= Comma ( (lv_paths_4_0= RULE_STRING ) )
            	    {
            	    otherlv_3=(Token)match(input,Comma,FOLLOW_8); 

            	    				newLeafNode(otherlv_3, grammarAccess.getSourceFragmentAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalN4MFParser.g:1648:4: ( (lv_paths_4_0= RULE_STRING ) )
            	    // InternalN4MFParser.g:1649:5: (lv_paths_4_0= RULE_STRING )
            	    {
            	    // InternalN4MFParser.g:1649:5: (lv_paths_4_0= RULE_STRING )
            	    // InternalN4MFParser.g:1650:6: lv_paths_4_0= RULE_STRING
            	    {
            	    lv_paths_4_0=(Token)match(input,RULE_STRING,FOLLOW_10); 

            	    						newLeafNode(lv_paths_4_0, grammarAccess.getSourceFragmentAccess().getPathsSTRINGTerminalRuleCall_3_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getSourceFragmentRule());
            	    						}
            	    						addWithLastConsumed(
            	    							current,
            	    							"paths",
            	    							lv_paths_4_0,
            	    							"org.eclipse.xtext.common.Terminals.STRING");
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            otherlv_5=(Token)match(input,RightCurlyBracket,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getSourceFragmentAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSourceFragment"


    // $ANTLR start "entryRuleModuleFilter"
    // InternalN4MFParser.g:1675:1: entryRuleModuleFilter returns [EObject current=null] : iv_ruleModuleFilter= ruleModuleFilter EOF ;
    public final EObject entryRuleModuleFilter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModuleFilter = null;


        try {
            // InternalN4MFParser.g:1675:53: (iv_ruleModuleFilter= ruleModuleFilter EOF )
            // InternalN4MFParser.g:1676:2: iv_ruleModuleFilter= ruleModuleFilter EOF
            {
             newCompositeNode(grammarAccess.getModuleFilterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModuleFilter=ruleModuleFilter();

            state._fsp--;

             current =iv_ruleModuleFilter; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModuleFilter"


    // $ANTLR start "ruleModuleFilter"
    // InternalN4MFParser.g:1682:1: ruleModuleFilter returns [EObject current=null] : ( ( (lv_moduleFilterType_0_0= ruleModuleFilterType ) ) otherlv_1= LeftCurlyBracket ( (lv_moduleSpecifiers_2_0= ruleModuleFilterSpecifier ) ) (otherlv_3= Comma ( (lv_moduleSpecifiers_4_0= ruleModuleFilterSpecifier ) ) )* otherlv_5= RightCurlyBracket ) ;
    public final EObject ruleModuleFilter() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Enumerator lv_moduleFilterType_0_0 = null;

        EObject lv_moduleSpecifiers_2_0 = null;

        EObject lv_moduleSpecifiers_4_0 = null;



        	enterRule();

        try {
            // InternalN4MFParser.g:1688:2: ( ( ( (lv_moduleFilterType_0_0= ruleModuleFilterType ) ) otherlv_1= LeftCurlyBracket ( (lv_moduleSpecifiers_2_0= ruleModuleFilterSpecifier ) ) (otherlv_3= Comma ( (lv_moduleSpecifiers_4_0= ruleModuleFilterSpecifier ) ) )* otherlv_5= RightCurlyBracket ) )
            // InternalN4MFParser.g:1689:2: ( ( (lv_moduleFilterType_0_0= ruleModuleFilterType ) ) otherlv_1= LeftCurlyBracket ( (lv_moduleSpecifiers_2_0= ruleModuleFilterSpecifier ) ) (otherlv_3= Comma ( (lv_moduleSpecifiers_4_0= ruleModuleFilterSpecifier ) ) )* otherlv_5= RightCurlyBracket )
            {
            // InternalN4MFParser.g:1689:2: ( ( (lv_moduleFilterType_0_0= ruleModuleFilterType ) ) otherlv_1= LeftCurlyBracket ( (lv_moduleSpecifiers_2_0= ruleModuleFilterSpecifier ) ) (otherlv_3= Comma ( (lv_moduleSpecifiers_4_0= ruleModuleFilterSpecifier ) ) )* otherlv_5= RightCurlyBracket )
            // InternalN4MFParser.g:1690:3: ( (lv_moduleFilterType_0_0= ruleModuleFilterType ) ) otherlv_1= LeftCurlyBracket ( (lv_moduleSpecifiers_2_0= ruleModuleFilterSpecifier ) ) (otherlv_3= Comma ( (lv_moduleSpecifiers_4_0= ruleModuleFilterSpecifier ) ) )* otherlv_5= RightCurlyBracket
            {
            // InternalN4MFParser.g:1690:3: ( (lv_moduleFilterType_0_0= ruleModuleFilterType ) )
            // InternalN4MFParser.g:1691:4: (lv_moduleFilterType_0_0= ruleModuleFilterType )
            {
            // InternalN4MFParser.g:1691:4: (lv_moduleFilterType_0_0= ruleModuleFilterType )
            // InternalN4MFParser.g:1692:5: lv_moduleFilterType_0_0= ruleModuleFilterType
            {

            					newCompositeNode(grammarAccess.getModuleFilterAccess().getModuleFilterTypeModuleFilterTypeEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_9);
            lv_moduleFilterType_0_0=ruleModuleFilterType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getModuleFilterRule());
            					}
            					set(
            						current,
            						"moduleFilterType",
            						lv_moduleFilterType_0_0,
            						"eu.numberfour.n4js.n4mf.N4MF.ModuleFilterType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,LeftCurlyBracket,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getModuleFilterAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalN4MFParser.g:1713:3: ( (lv_moduleSpecifiers_2_0= ruleModuleFilterSpecifier ) )
            // InternalN4MFParser.g:1714:4: (lv_moduleSpecifiers_2_0= ruleModuleFilterSpecifier )
            {
            // InternalN4MFParser.g:1714:4: (lv_moduleSpecifiers_2_0= ruleModuleFilterSpecifier )
            // InternalN4MFParser.g:1715:5: lv_moduleSpecifiers_2_0= ruleModuleFilterSpecifier
            {

            					newCompositeNode(grammarAccess.getModuleFilterAccess().getModuleSpecifiersModuleFilterSpecifierParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_10);
            lv_moduleSpecifiers_2_0=ruleModuleFilterSpecifier();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getModuleFilterRule());
            					}
            					add(
            						current,
            						"moduleSpecifiers",
            						lv_moduleSpecifiers_2_0,
            						"eu.numberfour.n4js.n4mf.N4MF.ModuleFilterSpecifier");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalN4MFParser.g:1732:3: (otherlv_3= Comma ( (lv_moduleSpecifiers_4_0= ruleModuleFilterSpecifier ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==Comma) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalN4MFParser.g:1733:4: otherlv_3= Comma ( (lv_moduleSpecifiers_4_0= ruleModuleFilterSpecifier ) )
            	    {
            	    otherlv_3=(Token)match(input,Comma,FOLLOW_8); 

            	    				newLeafNode(otherlv_3, grammarAccess.getModuleFilterAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalN4MFParser.g:1737:4: ( (lv_moduleSpecifiers_4_0= ruleModuleFilterSpecifier ) )
            	    // InternalN4MFParser.g:1738:5: (lv_moduleSpecifiers_4_0= ruleModuleFilterSpecifier )
            	    {
            	    // InternalN4MFParser.g:1738:5: (lv_moduleSpecifiers_4_0= ruleModuleFilterSpecifier )
            	    // InternalN4MFParser.g:1739:6: lv_moduleSpecifiers_4_0= ruleModuleFilterSpecifier
            	    {

            	    						newCompositeNode(grammarAccess.getModuleFilterAccess().getModuleSpecifiersModuleFilterSpecifierParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_10);
            	    lv_moduleSpecifiers_4_0=ruleModuleFilterSpecifier();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getModuleFilterRule());
            	    						}
            	    						add(
            	    							current,
            	    							"moduleSpecifiers",
            	    							lv_moduleSpecifiers_4_0,
            	    							"eu.numberfour.n4js.n4mf.N4MF.ModuleFilterSpecifier");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            otherlv_5=(Token)match(input,RightCurlyBracket,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getModuleFilterAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModuleFilter"


    // $ANTLR start "entryRuleBootstrapModule"
    // InternalN4MFParser.g:1765:1: entryRuleBootstrapModule returns [EObject current=null] : iv_ruleBootstrapModule= ruleBootstrapModule EOF ;
    public final EObject entryRuleBootstrapModule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBootstrapModule = null;


        try {
            // InternalN4MFParser.g:1765:56: (iv_ruleBootstrapModule= ruleBootstrapModule EOF )
            // InternalN4MFParser.g:1766:2: iv_ruleBootstrapModule= ruleBootstrapModule EOF
            {
             newCompositeNode(grammarAccess.getBootstrapModuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBootstrapModule=ruleBootstrapModule();

            state._fsp--;

             current =iv_ruleBootstrapModule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBootstrapModule"


    // $ANTLR start "ruleBootstrapModule"
    // InternalN4MFParser.g:1772:1: ruleBootstrapModule returns [EObject current=null] : ( ( (lv_moduleSpecifierWithWildcard_0_0= RULE_STRING ) ) (otherlv_1= In ( (lv_sourcePath_2_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleBootstrapModule() throws RecognitionException {
        EObject current = null;

        Token lv_moduleSpecifierWithWildcard_0_0=null;
        Token otherlv_1=null;
        Token lv_sourcePath_2_0=null;


        	enterRule();

        try {
            // InternalN4MFParser.g:1778:2: ( ( ( (lv_moduleSpecifierWithWildcard_0_0= RULE_STRING ) ) (otherlv_1= In ( (lv_sourcePath_2_0= RULE_STRING ) ) )? ) )
            // InternalN4MFParser.g:1779:2: ( ( (lv_moduleSpecifierWithWildcard_0_0= RULE_STRING ) ) (otherlv_1= In ( (lv_sourcePath_2_0= RULE_STRING ) ) )? )
            {
            // InternalN4MFParser.g:1779:2: ( ( (lv_moduleSpecifierWithWildcard_0_0= RULE_STRING ) ) (otherlv_1= In ( (lv_sourcePath_2_0= RULE_STRING ) ) )? )
            // InternalN4MFParser.g:1780:3: ( (lv_moduleSpecifierWithWildcard_0_0= RULE_STRING ) ) (otherlv_1= In ( (lv_sourcePath_2_0= RULE_STRING ) ) )?
            {
            // InternalN4MFParser.g:1780:3: ( (lv_moduleSpecifierWithWildcard_0_0= RULE_STRING ) )
            // InternalN4MFParser.g:1781:4: (lv_moduleSpecifierWithWildcard_0_0= RULE_STRING )
            {
            // InternalN4MFParser.g:1781:4: (lv_moduleSpecifierWithWildcard_0_0= RULE_STRING )
            // InternalN4MFParser.g:1782:5: lv_moduleSpecifierWithWildcard_0_0= RULE_STRING
            {
            lv_moduleSpecifierWithWildcard_0_0=(Token)match(input,RULE_STRING,FOLLOW_20); 

            					newLeafNode(lv_moduleSpecifierWithWildcard_0_0, grammarAccess.getBootstrapModuleAccess().getModuleSpecifierWithWildcardSTRINGTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBootstrapModuleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"moduleSpecifierWithWildcard",
            						lv_moduleSpecifierWithWildcard_0_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalN4MFParser.g:1798:3: (otherlv_1= In ( (lv_sourcePath_2_0= RULE_STRING ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==In) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalN4MFParser.g:1799:4: otherlv_1= In ( (lv_sourcePath_2_0= RULE_STRING ) )
                    {
                    otherlv_1=(Token)match(input,In,FOLLOW_8); 

                    				newLeafNode(otherlv_1, grammarAccess.getBootstrapModuleAccess().getInKeyword_1_0());
                    			
                    // InternalN4MFParser.g:1803:4: ( (lv_sourcePath_2_0= RULE_STRING ) )
                    // InternalN4MFParser.g:1804:5: (lv_sourcePath_2_0= RULE_STRING )
                    {
                    // InternalN4MFParser.g:1804:5: (lv_sourcePath_2_0= RULE_STRING )
                    // InternalN4MFParser.g:1805:6: lv_sourcePath_2_0= RULE_STRING
                    {
                    lv_sourcePath_2_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    						newLeafNode(lv_sourcePath_2_0, grammarAccess.getBootstrapModuleAccess().getSourcePathSTRINGTerminalRuleCall_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getBootstrapModuleRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"sourcePath",
                    							lv_sourcePath_2_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBootstrapModule"


    // $ANTLR start "entryRuleModuleFilterSpecifier"
    // InternalN4MFParser.g:1826:1: entryRuleModuleFilterSpecifier returns [EObject current=null] : iv_ruleModuleFilterSpecifier= ruleModuleFilterSpecifier EOF ;
    public final EObject entryRuleModuleFilterSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModuleFilterSpecifier = null;


        try {
            // InternalN4MFParser.g:1826:62: (iv_ruleModuleFilterSpecifier= ruleModuleFilterSpecifier EOF )
            // InternalN4MFParser.g:1827:2: iv_ruleModuleFilterSpecifier= ruleModuleFilterSpecifier EOF
            {
             newCompositeNode(grammarAccess.getModuleFilterSpecifierRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModuleFilterSpecifier=ruleModuleFilterSpecifier();

            state._fsp--;

             current =iv_ruleModuleFilterSpecifier; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModuleFilterSpecifier"


    // $ANTLR start "ruleModuleFilterSpecifier"
    // InternalN4MFParser.g:1833:1: ruleModuleFilterSpecifier returns [EObject current=null] : ( ( (lv_moduleSpecifierWithWildcard_0_0= RULE_STRING ) ) (otherlv_1= In ( (lv_sourcePath_2_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleModuleFilterSpecifier() throws RecognitionException {
        EObject current = null;

        Token lv_moduleSpecifierWithWildcard_0_0=null;
        Token otherlv_1=null;
        Token lv_sourcePath_2_0=null;


        	enterRule();

        try {
            // InternalN4MFParser.g:1839:2: ( ( ( (lv_moduleSpecifierWithWildcard_0_0= RULE_STRING ) ) (otherlv_1= In ( (lv_sourcePath_2_0= RULE_STRING ) ) )? ) )
            // InternalN4MFParser.g:1840:2: ( ( (lv_moduleSpecifierWithWildcard_0_0= RULE_STRING ) ) (otherlv_1= In ( (lv_sourcePath_2_0= RULE_STRING ) ) )? )
            {
            // InternalN4MFParser.g:1840:2: ( ( (lv_moduleSpecifierWithWildcard_0_0= RULE_STRING ) ) (otherlv_1= In ( (lv_sourcePath_2_0= RULE_STRING ) ) )? )
            // InternalN4MFParser.g:1841:3: ( (lv_moduleSpecifierWithWildcard_0_0= RULE_STRING ) ) (otherlv_1= In ( (lv_sourcePath_2_0= RULE_STRING ) ) )?
            {
            // InternalN4MFParser.g:1841:3: ( (lv_moduleSpecifierWithWildcard_0_0= RULE_STRING ) )
            // InternalN4MFParser.g:1842:4: (lv_moduleSpecifierWithWildcard_0_0= RULE_STRING )
            {
            // InternalN4MFParser.g:1842:4: (lv_moduleSpecifierWithWildcard_0_0= RULE_STRING )
            // InternalN4MFParser.g:1843:5: lv_moduleSpecifierWithWildcard_0_0= RULE_STRING
            {
            lv_moduleSpecifierWithWildcard_0_0=(Token)match(input,RULE_STRING,FOLLOW_20); 

            					newLeafNode(lv_moduleSpecifierWithWildcard_0_0, grammarAccess.getModuleFilterSpecifierAccess().getModuleSpecifierWithWildcardSTRINGTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getModuleFilterSpecifierRule());
            					}
            					setWithLastConsumed(
            						current,
            						"moduleSpecifierWithWildcard",
            						lv_moduleSpecifierWithWildcard_0_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalN4MFParser.g:1859:3: (otherlv_1= In ( (lv_sourcePath_2_0= RULE_STRING ) ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==In) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalN4MFParser.g:1860:4: otherlv_1= In ( (lv_sourcePath_2_0= RULE_STRING ) )
                    {
                    otherlv_1=(Token)match(input,In,FOLLOW_8); 

                    				newLeafNode(otherlv_1, grammarAccess.getModuleFilterSpecifierAccess().getInKeyword_1_0());
                    			
                    // InternalN4MFParser.g:1864:4: ( (lv_sourcePath_2_0= RULE_STRING ) )
                    // InternalN4MFParser.g:1865:5: (lv_sourcePath_2_0= RULE_STRING )
                    {
                    // InternalN4MFParser.g:1865:5: (lv_sourcePath_2_0= RULE_STRING )
                    // InternalN4MFParser.g:1866:6: lv_sourcePath_2_0= RULE_STRING
                    {
                    lv_sourcePath_2_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    						newLeafNode(lv_sourcePath_2_0, grammarAccess.getModuleFilterSpecifierAccess().getSourcePathSTRINGTerminalRuleCall_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getModuleFilterSpecifierRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"sourcePath",
                    							lv_sourcePath_2_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModuleFilterSpecifier"


    // $ANTLR start "entryRuleProvidedRuntimeLibraryDependency"
    // InternalN4MFParser.g:1887:1: entryRuleProvidedRuntimeLibraryDependency returns [EObject current=null] : iv_ruleProvidedRuntimeLibraryDependency= ruleProvidedRuntimeLibraryDependency EOF ;
    public final EObject entryRuleProvidedRuntimeLibraryDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProvidedRuntimeLibraryDependency = null;


        try {
            // InternalN4MFParser.g:1887:73: (iv_ruleProvidedRuntimeLibraryDependency= ruleProvidedRuntimeLibraryDependency EOF )
            // InternalN4MFParser.g:1888:2: iv_ruleProvidedRuntimeLibraryDependency= ruleProvidedRuntimeLibraryDependency EOF
            {
             newCompositeNode(grammarAccess.getProvidedRuntimeLibraryDependencyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProvidedRuntimeLibraryDependency=ruleProvidedRuntimeLibraryDependency();

            state._fsp--;

             current =iv_ruleProvidedRuntimeLibraryDependency; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProvidedRuntimeLibraryDependency"


    // $ANTLR start "ruleProvidedRuntimeLibraryDependency"
    // InternalN4MFParser.g:1894:1: ruleProvidedRuntimeLibraryDependency returns [EObject current=null] : ( (lv_project_0_0= ruleSimpleProjectDescription ) ) ;
    public final EObject ruleProvidedRuntimeLibraryDependency() throws RecognitionException {
        EObject current = null;

        EObject lv_project_0_0 = null;



        	enterRule();

        try {
            // InternalN4MFParser.g:1900:2: ( ( (lv_project_0_0= ruleSimpleProjectDescription ) ) )
            // InternalN4MFParser.g:1901:2: ( (lv_project_0_0= ruleSimpleProjectDescription ) )
            {
            // InternalN4MFParser.g:1901:2: ( (lv_project_0_0= ruleSimpleProjectDescription ) )
            // InternalN4MFParser.g:1902:3: (lv_project_0_0= ruleSimpleProjectDescription )
            {
            // InternalN4MFParser.g:1902:3: (lv_project_0_0= ruleSimpleProjectDescription )
            // InternalN4MFParser.g:1903:4: lv_project_0_0= ruleSimpleProjectDescription
            {

            				newCompositeNode(grammarAccess.getProvidedRuntimeLibraryDependencyAccess().getProjectSimpleProjectDescriptionParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_project_0_0=ruleSimpleProjectDescription();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getProvidedRuntimeLibraryDependencyRule());
            				}
            				set(
            					current,
            					"project",
            					lv_project_0_0,
            					"eu.numberfour.n4js.n4mf.N4MF.SimpleProjectDescription");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProvidedRuntimeLibraryDependency"


    // $ANTLR start "entryRuleRequiredRuntimeLibraryDependency"
    // InternalN4MFParser.g:1923:1: entryRuleRequiredRuntimeLibraryDependency returns [EObject current=null] : iv_ruleRequiredRuntimeLibraryDependency= ruleRequiredRuntimeLibraryDependency EOF ;
    public final EObject entryRuleRequiredRuntimeLibraryDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRequiredRuntimeLibraryDependency = null;


        try {
            // InternalN4MFParser.g:1923:73: (iv_ruleRequiredRuntimeLibraryDependency= ruleRequiredRuntimeLibraryDependency EOF )
            // InternalN4MFParser.g:1924:2: iv_ruleRequiredRuntimeLibraryDependency= ruleRequiredRuntimeLibraryDependency EOF
            {
             newCompositeNode(grammarAccess.getRequiredRuntimeLibraryDependencyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRequiredRuntimeLibraryDependency=ruleRequiredRuntimeLibraryDependency();

            state._fsp--;

             current =iv_ruleRequiredRuntimeLibraryDependency; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRequiredRuntimeLibraryDependency"


    // $ANTLR start "ruleRequiredRuntimeLibraryDependency"
    // InternalN4MFParser.g:1930:1: ruleRequiredRuntimeLibraryDependency returns [EObject current=null] : ( (lv_project_0_0= ruleSimpleProjectDescription ) ) ;
    public final EObject ruleRequiredRuntimeLibraryDependency() throws RecognitionException {
        EObject current = null;

        EObject lv_project_0_0 = null;



        	enterRule();

        try {
            // InternalN4MFParser.g:1936:2: ( ( (lv_project_0_0= ruleSimpleProjectDescription ) ) )
            // InternalN4MFParser.g:1937:2: ( (lv_project_0_0= ruleSimpleProjectDescription ) )
            {
            // InternalN4MFParser.g:1937:2: ( (lv_project_0_0= ruleSimpleProjectDescription ) )
            // InternalN4MFParser.g:1938:3: (lv_project_0_0= ruleSimpleProjectDescription )
            {
            // InternalN4MFParser.g:1938:3: (lv_project_0_0= ruleSimpleProjectDescription )
            // InternalN4MFParser.g:1939:4: lv_project_0_0= ruleSimpleProjectDescription
            {

            				newCompositeNode(grammarAccess.getRequiredRuntimeLibraryDependencyAccess().getProjectSimpleProjectDescriptionParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_project_0_0=ruleSimpleProjectDescription();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getRequiredRuntimeLibraryDependencyRule());
            				}
            				set(
            					current,
            					"project",
            					lv_project_0_0,
            					"eu.numberfour.n4js.n4mf.N4MF.SimpleProjectDescription");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRequiredRuntimeLibraryDependency"


    // $ANTLR start "entryRuleTestedProject"
    // InternalN4MFParser.g:1959:1: entryRuleTestedProject returns [EObject current=null] : iv_ruleTestedProject= ruleTestedProject EOF ;
    public final EObject entryRuleTestedProject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestedProject = null;


        try {
            // InternalN4MFParser.g:1959:54: (iv_ruleTestedProject= ruleTestedProject EOF )
            // InternalN4MFParser.g:1960:2: iv_ruleTestedProject= ruleTestedProject EOF
            {
             newCompositeNode(grammarAccess.getTestedProjectRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTestedProject=ruleTestedProject();

            state._fsp--;

             current =iv_ruleTestedProject; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTestedProject"


    // $ANTLR start "ruleTestedProject"
    // InternalN4MFParser.g:1966:1: ruleTestedProject returns [EObject current=null] : ( (lv_project_0_0= ruleSimpleProjectDescription ) ) ;
    public final EObject ruleTestedProject() throws RecognitionException {
        EObject current = null;

        EObject lv_project_0_0 = null;



        	enterRule();

        try {
            // InternalN4MFParser.g:1972:2: ( ( (lv_project_0_0= ruleSimpleProjectDescription ) ) )
            // InternalN4MFParser.g:1973:2: ( (lv_project_0_0= ruleSimpleProjectDescription ) )
            {
            // InternalN4MFParser.g:1973:2: ( (lv_project_0_0= ruleSimpleProjectDescription ) )
            // InternalN4MFParser.g:1974:3: (lv_project_0_0= ruleSimpleProjectDescription )
            {
            // InternalN4MFParser.g:1974:3: (lv_project_0_0= ruleSimpleProjectDescription )
            // InternalN4MFParser.g:1975:4: lv_project_0_0= ruleSimpleProjectDescription
            {

            				newCompositeNode(grammarAccess.getTestedProjectAccess().getProjectSimpleProjectDescriptionParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_project_0_0=ruleSimpleProjectDescription();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getTestedProjectRule());
            				}
            				set(
            					current,
            					"project",
            					lv_project_0_0,
            					"eu.numberfour.n4js.n4mf.N4MF.SimpleProjectDescription");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTestedProject"


    // $ANTLR start "entryRuleProjectReference"
    // InternalN4MFParser.g:1995:1: entryRuleProjectReference returns [EObject current=null] : iv_ruleProjectReference= ruleProjectReference EOF ;
    public final EObject entryRuleProjectReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProjectReference = null;


        try {
            // InternalN4MFParser.g:1995:57: (iv_ruleProjectReference= ruleProjectReference EOF )
            // InternalN4MFParser.g:1996:2: iv_ruleProjectReference= ruleProjectReference EOF
            {
             newCompositeNode(grammarAccess.getProjectReferenceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProjectReference=ruleProjectReference();

            state._fsp--;

             current =iv_ruleProjectReference; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProjectReference"


    // $ANTLR start "ruleProjectReference"
    // InternalN4MFParser.g:2002:1: ruleProjectReference returns [EObject current=null] : ( (lv_project_0_0= ruleSimpleProjectDescription ) ) ;
    public final EObject ruleProjectReference() throws RecognitionException {
        EObject current = null;

        EObject lv_project_0_0 = null;



        	enterRule();

        try {
            // InternalN4MFParser.g:2008:2: ( ( (lv_project_0_0= ruleSimpleProjectDescription ) ) )
            // InternalN4MFParser.g:2009:2: ( (lv_project_0_0= ruleSimpleProjectDescription ) )
            {
            // InternalN4MFParser.g:2009:2: ( (lv_project_0_0= ruleSimpleProjectDescription ) )
            // InternalN4MFParser.g:2010:3: (lv_project_0_0= ruleSimpleProjectDescription )
            {
            // InternalN4MFParser.g:2010:3: (lv_project_0_0= ruleSimpleProjectDescription )
            // InternalN4MFParser.g:2011:4: lv_project_0_0= ruleSimpleProjectDescription
            {

            				newCompositeNode(grammarAccess.getProjectReferenceAccess().getProjectSimpleProjectDescriptionParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_project_0_0=ruleSimpleProjectDescription();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getProjectReferenceRule());
            				}
            				set(
            					current,
            					"project",
            					lv_project_0_0,
            					"eu.numberfour.n4js.n4mf.N4MF.SimpleProjectDescription");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProjectReference"


    // $ANTLR start "entryRuleProjectDependency"
    // InternalN4MFParser.g:2031:1: entryRuleProjectDependency returns [EObject current=null] : iv_ruleProjectDependency= ruleProjectDependency EOF ;
    public final EObject entryRuleProjectDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProjectDependency = null;


        try {
            // InternalN4MFParser.g:2031:58: (iv_ruleProjectDependency= ruleProjectDependency EOF )
            // InternalN4MFParser.g:2032:2: iv_ruleProjectDependency= ruleProjectDependency EOF
            {
             newCompositeNode(grammarAccess.getProjectDependencyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProjectDependency=ruleProjectDependency();

            state._fsp--;

             current =iv_ruleProjectDependency; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProjectDependency"


    // $ANTLR start "ruleProjectDependency"
    // InternalN4MFParser.g:2038:1: ruleProjectDependency returns [EObject current=null] : ( ( (lv_project_0_0= ruleSimpleProjectDescription ) ) ( (lv_versionConstraint_1_0= ruleVersionConstraint ) )? ( (lv_declaredScope_2_0= ruleProjectDependencyScope ) )? ) ;
    public final EObject ruleProjectDependency() throws RecognitionException {
        EObject current = null;

        EObject lv_project_0_0 = null;

        EObject lv_versionConstraint_1_0 = null;

        Enumerator lv_declaredScope_2_0 = null;



        	enterRule();

        try {
            // InternalN4MFParser.g:2044:2: ( ( ( (lv_project_0_0= ruleSimpleProjectDescription ) ) ( (lv_versionConstraint_1_0= ruleVersionConstraint ) )? ( (lv_declaredScope_2_0= ruleProjectDependencyScope ) )? ) )
            // InternalN4MFParser.g:2045:2: ( ( (lv_project_0_0= ruleSimpleProjectDescription ) ) ( (lv_versionConstraint_1_0= ruleVersionConstraint ) )? ( (lv_declaredScope_2_0= ruleProjectDependencyScope ) )? )
            {
            // InternalN4MFParser.g:2045:2: ( ( (lv_project_0_0= ruleSimpleProjectDescription ) ) ( (lv_versionConstraint_1_0= ruleVersionConstraint ) )? ( (lv_declaredScope_2_0= ruleProjectDependencyScope ) )? )
            // InternalN4MFParser.g:2046:3: ( (lv_project_0_0= ruleSimpleProjectDescription ) ) ( (lv_versionConstraint_1_0= ruleVersionConstraint ) )? ( (lv_declaredScope_2_0= ruleProjectDependencyScope ) )?
            {
            // InternalN4MFParser.g:2046:3: ( (lv_project_0_0= ruleSimpleProjectDescription ) )
            // InternalN4MFParser.g:2047:4: (lv_project_0_0= ruleSimpleProjectDescription )
            {
            // InternalN4MFParser.g:2047:4: (lv_project_0_0= ruleSimpleProjectDescription )
            // InternalN4MFParser.g:2048:5: lv_project_0_0= ruleSimpleProjectDescription
            {

            					newCompositeNode(grammarAccess.getProjectDependencyAccess().getProjectSimpleProjectDescriptionParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_21);
            lv_project_0_0=ruleSimpleProjectDescription();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getProjectDependencyRule());
            					}
            					set(
            						current,
            						"project",
            						lv_project_0_0,
            						"eu.numberfour.n4js.n4mf.N4MF.SimpleProjectDescription");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalN4MFParser.g:2065:3: ( (lv_versionConstraint_1_0= ruleVersionConstraint ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==LeftParenthesis||LA25_0==LeftSquareBracket||LA25_0==RULE_INT) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalN4MFParser.g:2066:4: (lv_versionConstraint_1_0= ruleVersionConstraint )
                    {
                    // InternalN4MFParser.g:2066:4: (lv_versionConstraint_1_0= ruleVersionConstraint )
                    // InternalN4MFParser.g:2067:5: lv_versionConstraint_1_0= ruleVersionConstraint
                    {

                    					newCompositeNode(grammarAccess.getProjectDependencyAccess().getVersionConstraintVersionConstraintParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_22);
                    lv_versionConstraint_1_0=ruleVersionConstraint();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getProjectDependencyRule());
                    					}
                    					set(
                    						current,
                    						"versionConstraint",
                    						lv_versionConstraint_1_0,
                    						"eu.numberfour.n4js.n4mf.N4MF.VersionConstraint");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalN4MFParser.g:2084:3: ( (lv_declaredScope_2_0= ruleProjectDependencyScope ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==Compile||LA26_0==Test) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalN4MFParser.g:2085:4: (lv_declaredScope_2_0= ruleProjectDependencyScope )
                    {
                    // InternalN4MFParser.g:2085:4: (lv_declaredScope_2_0= ruleProjectDependencyScope )
                    // InternalN4MFParser.g:2086:5: lv_declaredScope_2_0= ruleProjectDependencyScope
                    {

                    					newCompositeNode(grammarAccess.getProjectDependencyAccess().getDeclaredScopeProjectDependencyScopeEnumRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_declaredScope_2_0=ruleProjectDependencyScope();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getProjectDependencyRule());
                    					}
                    					set(
                    						current,
                    						"declaredScope",
                    						lv_declaredScope_2_0,
                    						"eu.numberfour.n4js.n4mf.N4MF.ProjectDependencyScope");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProjectDependency"


    // $ANTLR start "entryRuleSimpleProjectDescription"
    // InternalN4MFParser.g:2107:1: entryRuleSimpleProjectDescription returns [EObject current=null] : iv_ruleSimpleProjectDescription= ruleSimpleProjectDescription EOF ;
    public final EObject entryRuleSimpleProjectDescription() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleProjectDescription = null;


        try {
            // InternalN4MFParser.g:2107:65: (iv_ruleSimpleProjectDescription= ruleSimpleProjectDescription EOF )
            // InternalN4MFParser.g:2108:2: iv_ruleSimpleProjectDescription= ruleSimpleProjectDescription EOF
            {
             newCompositeNode(grammarAccess.getSimpleProjectDescriptionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSimpleProjectDescription=ruleSimpleProjectDescription();

            state._fsp--;

             current =iv_ruleSimpleProjectDescription; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSimpleProjectDescription"


    // $ANTLR start "ruleSimpleProjectDescription"
    // InternalN4MFParser.g:2114:1: ruleSimpleProjectDescription returns [EObject current=null] : ( ( ( (lv_declaredVendorId_0_0= ruleN4mfIdentifier ) ) otherlv_1= Colon )? ( (lv_projectId_2_0= ruleN4mfIdentifier ) ) ) ;
    public final EObject ruleSimpleProjectDescription() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_declaredVendorId_0_0 = null;

        AntlrDatatypeRuleToken lv_projectId_2_0 = null;



        	enterRule();

        try {
            // InternalN4MFParser.g:2120:2: ( ( ( ( (lv_declaredVendorId_0_0= ruleN4mfIdentifier ) ) otherlv_1= Colon )? ( (lv_projectId_2_0= ruleN4mfIdentifier ) ) ) )
            // InternalN4MFParser.g:2121:2: ( ( ( (lv_declaredVendorId_0_0= ruleN4mfIdentifier ) ) otherlv_1= Colon )? ( (lv_projectId_2_0= ruleN4mfIdentifier ) ) )
            {
            // InternalN4MFParser.g:2121:2: ( ( ( (lv_declaredVendorId_0_0= ruleN4mfIdentifier ) ) otherlv_1= Colon )? ( (lv_projectId_2_0= ruleN4mfIdentifier ) ) )
            // InternalN4MFParser.g:2122:3: ( ( (lv_declaredVendorId_0_0= ruleN4mfIdentifier ) ) otherlv_1= Colon )? ( (lv_projectId_2_0= ruleN4mfIdentifier ) )
            {
            // InternalN4MFParser.g:2122:3: ( ( (lv_declaredVendorId_0_0= ruleN4mfIdentifier ) ) otherlv_1= Colon )?
            int alt27=2;
            alt27 = dfa27.predict(input);
            switch (alt27) {
                case 1 :
                    // InternalN4MFParser.g:2123:4: ( (lv_declaredVendorId_0_0= ruleN4mfIdentifier ) ) otherlv_1= Colon
                    {
                    // InternalN4MFParser.g:2123:4: ( (lv_declaredVendorId_0_0= ruleN4mfIdentifier ) )
                    // InternalN4MFParser.g:2124:5: (lv_declaredVendorId_0_0= ruleN4mfIdentifier )
                    {
                    // InternalN4MFParser.g:2124:5: (lv_declaredVendorId_0_0= ruleN4mfIdentifier )
                    // InternalN4MFParser.g:2125:6: lv_declaredVendorId_0_0= ruleN4mfIdentifier
                    {

                    						newCompositeNode(grammarAccess.getSimpleProjectDescriptionAccess().getDeclaredVendorIdN4mfIdentifierParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_3);
                    lv_declaredVendorId_0_0=ruleN4mfIdentifier();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSimpleProjectDescriptionRule());
                    						}
                    						set(
                    							current,
                    							"declaredVendorId",
                    							lv_declaredVendorId_0_0,
                    							"eu.numberfour.n4js.n4mf.N4MF.N4mfIdentifier");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,Colon,FOLLOW_4); 

                    				newLeafNode(otherlv_1, grammarAccess.getSimpleProjectDescriptionAccess().getColonKeyword_0_1());
                    			

                    }
                    break;

            }

            // InternalN4MFParser.g:2147:3: ( (lv_projectId_2_0= ruleN4mfIdentifier ) )
            // InternalN4MFParser.g:2148:4: (lv_projectId_2_0= ruleN4mfIdentifier )
            {
            // InternalN4MFParser.g:2148:4: (lv_projectId_2_0= ruleN4mfIdentifier )
            // InternalN4MFParser.g:2149:5: lv_projectId_2_0= ruleN4mfIdentifier
            {

            					newCompositeNode(grammarAccess.getSimpleProjectDescriptionAccess().getProjectIdN4mfIdentifierParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_projectId_2_0=ruleN4mfIdentifier();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSimpleProjectDescriptionRule());
            					}
            					set(
            						current,
            						"projectId",
            						lv_projectId_2_0,
            						"eu.numberfour.n4js.n4mf.N4MF.N4mfIdentifier");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSimpleProjectDescription"


    // $ANTLR start "entryRuleVersionConstraint"
    // InternalN4MFParser.g:2170:1: entryRuleVersionConstraint returns [EObject current=null] : iv_ruleVersionConstraint= ruleVersionConstraint EOF ;
    public final EObject entryRuleVersionConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionConstraint = null;


        try {
            // InternalN4MFParser.g:2170:58: (iv_ruleVersionConstraint= ruleVersionConstraint EOF )
            // InternalN4MFParser.g:2171:2: iv_ruleVersionConstraint= ruleVersionConstraint EOF
            {
             newCompositeNode(grammarAccess.getVersionConstraintRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVersionConstraint=ruleVersionConstraint();

            state._fsp--;

             current =iv_ruleVersionConstraint; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVersionConstraint"


    // $ANTLR start "ruleVersionConstraint"
    // InternalN4MFParser.g:2177:1: ruleVersionConstraint returns [EObject current=null] : ( ( ( ( (lv_exclLowerBound_0_0= LeftParenthesis ) ) | otherlv_1= LeftSquareBracket ) ( (lv_lowerVersion_2_0= ruleDeclaredVersion ) ) ( (otherlv_3= Comma ( (lv_upperVersion_4_0= ruleDeclaredVersion ) ) ( ( (lv_exclUpperBound_5_0= RightParenthesis ) ) | otherlv_6= RightSquareBracket ) )? | otherlv_7= RightParenthesis ) ) | ( (lv_lowerVersion_8_0= ruleDeclaredVersion ) ) ) ;
    public final EObject ruleVersionConstraint() throws RecognitionException {
        EObject current = null;

        Token lv_exclLowerBound_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_exclUpperBound_5_0=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_lowerVersion_2_0 = null;

        EObject lv_upperVersion_4_0 = null;

        EObject lv_lowerVersion_8_0 = null;



        	enterRule();

        try {
            // InternalN4MFParser.g:2183:2: ( ( ( ( ( (lv_exclLowerBound_0_0= LeftParenthesis ) ) | otherlv_1= LeftSquareBracket ) ( (lv_lowerVersion_2_0= ruleDeclaredVersion ) ) ( (otherlv_3= Comma ( (lv_upperVersion_4_0= ruleDeclaredVersion ) ) ( ( (lv_exclUpperBound_5_0= RightParenthesis ) ) | otherlv_6= RightSquareBracket ) )? | otherlv_7= RightParenthesis ) ) | ( (lv_lowerVersion_8_0= ruleDeclaredVersion ) ) ) )
            // InternalN4MFParser.g:2184:2: ( ( ( ( (lv_exclLowerBound_0_0= LeftParenthesis ) ) | otherlv_1= LeftSquareBracket ) ( (lv_lowerVersion_2_0= ruleDeclaredVersion ) ) ( (otherlv_3= Comma ( (lv_upperVersion_4_0= ruleDeclaredVersion ) ) ( ( (lv_exclUpperBound_5_0= RightParenthesis ) ) | otherlv_6= RightSquareBracket ) )? | otherlv_7= RightParenthesis ) ) | ( (lv_lowerVersion_8_0= ruleDeclaredVersion ) ) )
            {
            // InternalN4MFParser.g:2184:2: ( ( ( ( (lv_exclLowerBound_0_0= LeftParenthesis ) ) | otherlv_1= LeftSquareBracket ) ( (lv_lowerVersion_2_0= ruleDeclaredVersion ) ) ( (otherlv_3= Comma ( (lv_upperVersion_4_0= ruleDeclaredVersion ) ) ( ( (lv_exclUpperBound_5_0= RightParenthesis ) ) | otherlv_6= RightSquareBracket ) )? | otherlv_7= RightParenthesis ) ) | ( (lv_lowerVersion_8_0= ruleDeclaredVersion ) ) )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==LeftParenthesis||LA32_0==LeftSquareBracket) ) {
                alt32=1;
            }
            else if ( (LA32_0==RULE_INT) ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // InternalN4MFParser.g:2185:3: ( ( ( (lv_exclLowerBound_0_0= LeftParenthesis ) ) | otherlv_1= LeftSquareBracket ) ( (lv_lowerVersion_2_0= ruleDeclaredVersion ) ) ( (otherlv_3= Comma ( (lv_upperVersion_4_0= ruleDeclaredVersion ) ) ( ( (lv_exclUpperBound_5_0= RightParenthesis ) ) | otherlv_6= RightSquareBracket ) )? | otherlv_7= RightParenthesis ) )
                    {
                    // InternalN4MFParser.g:2185:3: ( ( ( (lv_exclLowerBound_0_0= LeftParenthesis ) ) | otherlv_1= LeftSquareBracket ) ( (lv_lowerVersion_2_0= ruleDeclaredVersion ) ) ( (otherlv_3= Comma ( (lv_upperVersion_4_0= ruleDeclaredVersion ) ) ( ( (lv_exclUpperBound_5_0= RightParenthesis ) ) | otherlv_6= RightSquareBracket ) )? | otherlv_7= RightParenthesis ) )
                    // InternalN4MFParser.g:2186:4: ( ( (lv_exclLowerBound_0_0= LeftParenthesis ) ) | otherlv_1= LeftSquareBracket ) ( (lv_lowerVersion_2_0= ruleDeclaredVersion ) ) ( (otherlv_3= Comma ( (lv_upperVersion_4_0= ruleDeclaredVersion ) ) ( ( (lv_exclUpperBound_5_0= RightParenthesis ) ) | otherlv_6= RightSquareBracket ) )? | otherlv_7= RightParenthesis )
                    {
                    // InternalN4MFParser.g:2186:4: ( ( (lv_exclLowerBound_0_0= LeftParenthesis ) ) | otherlv_1= LeftSquareBracket )
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==LeftParenthesis) ) {
                        alt28=1;
                    }
                    else if ( (LA28_0==LeftSquareBracket) ) {
                        alt28=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 28, 0, input);

                        throw nvae;
                    }
                    switch (alt28) {
                        case 1 :
                            // InternalN4MFParser.g:2187:5: ( (lv_exclLowerBound_0_0= LeftParenthesis ) )
                            {
                            // InternalN4MFParser.g:2187:5: ( (lv_exclLowerBound_0_0= LeftParenthesis ) )
                            // InternalN4MFParser.g:2188:6: (lv_exclLowerBound_0_0= LeftParenthesis )
                            {
                            // InternalN4MFParser.g:2188:6: (lv_exclLowerBound_0_0= LeftParenthesis )
                            // InternalN4MFParser.g:2189:7: lv_exclLowerBound_0_0= LeftParenthesis
                            {
                            lv_exclLowerBound_0_0=(Token)match(input,LeftParenthesis,FOLLOW_7); 

                            							newLeafNode(lv_exclLowerBound_0_0, grammarAccess.getVersionConstraintAccess().getExclLowerBoundLeftParenthesisKeyword_0_0_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getVersionConstraintRule());
                            							}
                            							setWithLastConsumed(current, "exclLowerBound", true, "(");
                            						

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalN4MFParser.g:2202:5: otherlv_1= LeftSquareBracket
                            {
                            otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_7); 

                            					newLeafNode(otherlv_1, grammarAccess.getVersionConstraintAccess().getLeftSquareBracketKeyword_0_0_1());
                            				

                            }
                            break;

                    }

                    // InternalN4MFParser.g:2207:4: ( (lv_lowerVersion_2_0= ruleDeclaredVersion ) )
                    // InternalN4MFParser.g:2208:5: (lv_lowerVersion_2_0= ruleDeclaredVersion )
                    {
                    // InternalN4MFParser.g:2208:5: (lv_lowerVersion_2_0= ruleDeclaredVersion )
                    // InternalN4MFParser.g:2209:6: lv_lowerVersion_2_0= ruleDeclaredVersion
                    {

                    						newCompositeNode(grammarAccess.getVersionConstraintAccess().getLowerVersionDeclaredVersionParserRuleCall_0_1_0());
                    					
                    pushFollow(FOLLOW_23);
                    lv_lowerVersion_2_0=ruleDeclaredVersion();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getVersionConstraintRule());
                    						}
                    						set(
                    							current,
                    							"lowerVersion",
                    							lv_lowerVersion_2_0,
                    							"eu.numberfour.n4js.n4mf.N4MF.DeclaredVersion");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalN4MFParser.g:2226:4: ( (otherlv_3= Comma ( (lv_upperVersion_4_0= ruleDeclaredVersion ) ) ( ( (lv_exclUpperBound_5_0= RightParenthesis ) ) | otherlv_6= RightSquareBracket ) )? | otherlv_7= RightParenthesis )
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==EOF||LA31_0==Compile||LA31_0==Test||LA31_0==Comma||LA31_0==RightCurlyBracket) ) {
                        alt31=1;
                    }
                    else if ( (LA31_0==RightParenthesis) ) {
                        alt31=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 31, 0, input);

                        throw nvae;
                    }
                    switch (alt31) {
                        case 1 :
                            // InternalN4MFParser.g:2227:5: (otherlv_3= Comma ( (lv_upperVersion_4_0= ruleDeclaredVersion ) ) ( ( (lv_exclUpperBound_5_0= RightParenthesis ) ) | otherlv_6= RightSquareBracket ) )?
                            {
                            // InternalN4MFParser.g:2227:5: (otherlv_3= Comma ( (lv_upperVersion_4_0= ruleDeclaredVersion ) ) ( ( (lv_exclUpperBound_5_0= RightParenthesis ) ) | otherlv_6= RightSquareBracket ) )?
                            int alt30=2;
                            int LA30_0 = input.LA(1);

                            if ( (LA30_0==Comma) ) {
                                int LA30_1 = input.LA(2);

                                if ( (LA30_1==RULE_INT) ) {
                                    alt30=1;
                                }
                            }
                            switch (alt30) {
                                case 1 :
                                    // InternalN4MFParser.g:2228:6: otherlv_3= Comma ( (lv_upperVersion_4_0= ruleDeclaredVersion ) ) ( ( (lv_exclUpperBound_5_0= RightParenthesis ) ) | otherlv_6= RightSquareBracket )
                                    {
                                    otherlv_3=(Token)match(input,Comma,FOLLOW_7); 

                                    						newLeafNode(otherlv_3, grammarAccess.getVersionConstraintAccess().getCommaKeyword_0_2_0_0());
                                    					
                                    // InternalN4MFParser.g:2232:6: ( (lv_upperVersion_4_0= ruleDeclaredVersion ) )
                                    // InternalN4MFParser.g:2233:7: (lv_upperVersion_4_0= ruleDeclaredVersion )
                                    {
                                    // InternalN4MFParser.g:2233:7: (lv_upperVersion_4_0= ruleDeclaredVersion )
                                    // InternalN4MFParser.g:2234:8: lv_upperVersion_4_0= ruleDeclaredVersion
                                    {

                                    								newCompositeNode(grammarAccess.getVersionConstraintAccess().getUpperVersionDeclaredVersionParserRuleCall_0_2_0_1_0());
                                    							
                                    pushFollow(FOLLOW_24);
                                    lv_upperVersion_4_0=ruleDeclaredVersion();

                                    state._fsp--;


                                    								if (current==null) {
                                    									current = createModelElementForParent(grammarAccess.getVersionConstraintRule());
                                    								}
                                    								set(
                                    									current,
                                    									"upperVersion",
                                    									lv_upperVersion_4_0,
                                    									"eu.numberfour.n4js.n4mf.N4MF.DeclaredVersion");
                                    								afterParserOrEnumRuleCall();
                                    							

                                    }


                                    }

                                    // InternalN4MFParser.g:2251:6: ( ( (lv_exclUpperBound_5_0= RightParenthesis ) ) | otherlv_6= RightSquareBracket )
                                    int alt29=2;
                                    int LA29_0 = input.LA(1);

                                    if ( (LA29_0==RightParenthesis) ) {
                                        alt29=1;
                                    }
                                    else if ( (LA29_0==RightSquareBracket) ) {
                                        alt29=2;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 29, 0, input);

                                        throw nvae;
                                    }
                                    switch (alt29) {
                                        case 1 :
                                            // InternalN4MFParser.g:2252:7: ( (lv_exclUpperBound_5_0= RightParenthesis ) )
                                            {
                                            // InternalN4MFParser.g:2252:7: ( (lv_exclUpperBound_5_0= RightParenthesis ) )
                                            // InternalN4MFParser.g:2253:8: (lv_exclUpperBound_5_0= RightParenthesis )
                                            {
                                            // InternalN4MFParser.g:2253:8: (lv_exclUpperBound_5_0= RightParenthesis )
                                            // InternalN4MFParser.g:2254:9: lv_exclUpperBound_5_0= RightParenthesis
                                            {
                                            lv_exclUpperBound_5_0=(Token)match(input,RightParenthesis,FOLLOW_2); 

                                            									newLeafNode(lv_exclUpperBound_5_0, grammarAccess.getVersionConstraintAccess().getExclUpperBoundRightParenthesisKeyword_0_2_0_2_0_0());
                                            								

                                            									if (current==null) {
                                            										current = createModelElement(grammarAccess.getVersionConstraintRule());
                                            									}
                                            									setWithLastConsumed(current, "exclUpperBound", true, ")");
                                            								

                                            }


                                            }


                                            }
                                            break;
                                        case 2 :
                                            // InternalN4MFParser.g:2267:7: otherlv_6= RightSquareBracket
                                            {
                                            otherlv_6=(Token)match(input,RightSquareBracket,FOLLOW_2); 

                                            							newLeafNode(otherlv_6, grammarAccess.getVersionConstraintAccess().getRightSquareBracketKeyword_0_2_0_2_1());
                                            						

                                            }
                                            break;

                                    }


                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // InternalN4MFParser.g:2274:5: otherlv_7= RightParenthesis
                            {
                            otherlv_7=(Token)match(input,RightParenthesis,FOLLOW_2); 

                            					newLeafNode(otherlv_7, grammarAccess.getVersionConstraintAccess().getRightParenthesisKeyword_0_2_1());
                            				

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalN4MFParser.g:2281:3: ( (lv_lowerVersion_8_0= ruleDeclaredVersion ) )
                    {
                    // InternalN4MFParser.g:2281:3: ( (lv_lowerVersion_8_0= ruleDeclaredVersion ) )
                    // InternalN4MFParser.g:2282:4: (lv_lowerVersion_8_0= ruleDeclaredVersion )
                    {
                    // InternalN4MFParser.g:2282:4: (lv_lowerVersion_8_0= ruleDeclaredVersion )
                    // InternalN4MFParser.g:2283:5: lv_lowerVersion_8_0= ruleDeclaredVersion
                    {

                    					newCompositeNode(grammarAccess.getVersionConstraintAccess().getLowerVersionDeclaredVersionParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_lowerVersion_8_0=ruleDeclaredVersion();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getVersionConstraintRule());
                    					}
                    					set(
                    						current,
                    						"lowerVersion",
                    						lv_lowerVersion_8_0,
                    						"eu.numberfour.n4js.n4mf.N4MF.DeclaredVersion");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVersionConstraint"


    // $ANTLR start "entryRuleN4mfIdentifier"
    // InternalN4MFParser.g:2304:1: entryRuleN4mfIdentifier returns [String current=null] : iv_ruleN4mfIdentifier= ruleN4mfIdentifier EOF ;
    public final String entryRuleN4mfIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleN4mfIdentifier = null;


        try {
            // InternalN4MFParser.g:2304:54: (iv_ruleN4mfIdentifier= ruleN4mfIdentifier EOF )
            // InternalN4MFParser.g:2305:2: iv_ruleN4mfIdentifier= ruleN4mfIdentifier EOF
            {
             newCompositeNode(grammarAccess.getN4mfIdentifierRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleN4mfIdentifier=ruleN4mfIdentifier();

            state._fsp--;

             current =iv_ruleN4mfIdentifier.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleN4mfIdentifier"


    // $ANTLR start "ruleN4mfIdentifier"
    // InternalN4MFParser.g:2311:1: ruleN4mfIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | kw= ProjectId | kw= ProjectType | kw= ProjectVersion | kw= VendorId | kw= VendorName | kw= Output | kw= Libraries | kw= Resources | kw= Sources | kw= ModuleFilters | (kw= ProjectDependencies kw= KW_System ) | kw= API | kw= User | kw= Application | (kw= Processor kw= Source ) | kw= Content | kw= Test ) ;
    public final AntlrDatatypeRuleToken ruleN4mfIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;


        	enterRule();

        try {
            // InternalN4MFParser.g:2317:2: ( (this_ID_0= RULE_ID | kw= ProjectId | kw= ProjectType | kw= ProjectVersion | kw= VendorId | kw= VendorName | kw= Output | kw= Libraries | kw= Resources | kw= Sources | kw= ModuleFilters | (kw= ProjectDependencies kw= KW_System ) | kw= API | kw= User | kw= Application | (kw= Processor kw= Source ) | kw= Content | kw= Test ) )
            // InternalN4MFParser.g:2318:2: (this_ID_0= RULE_ID | kw= ProjectId | kw= ProjectType | kw= ProjectVersion | kw= VendorId | kw= VendorName | kw= Output | kw= Libraries | kw= Resources | kw= Sources | kw= ModuleFilters | (kw= ProjectDependencies kw= KW_System ) | kw= API | kw= User | kw= Application | (kw= Processor kw= Source ) | kw= Content | kw= Test )
            {
            // InternalN4MFParser.g:2318:2: (this_ID_0= RULE_ID | kw= ProjectId | kw= ProjectType | kw= ProjectVersion | kw= VendorId | kw= VendorName | kw= Output | kw= Libraries | kw= Resources | kw= Sources | kw= ModuleFilters | (kw= ProjectDependencies kw= KW_System ) | kw= API | kw= User | kw= Application | (kw= Processor kw= Source ) | kw= Content | kw= Test )
            int alt33=18;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt33=1;
                }
                break;
            case ProjectId:
                {
                alt33=2;
                }
                break;
            case ProjectType:
                {
                alt33=3;
                }
                break;
            case ProjectVersion:
                {
                alt33=4;
                }
                break;
            case VendorId:
                {
                alt33=5;
                }
                break;
            case VendorName:
                {
                alt33=6;
                }
                break;
            case Output:
                {
                alt33=7;
                }
                break;
            case Libraries:
                {
                alt33=8;
                }
                break;
            case Resources:
                {
                alt33=9;
                }
                break;
            case Sources:
                {
                alt33=10;
                }
                break;
            case ModuleFilters:
                {
                alt33=11;
                }
                break;
            case ProjectDependencies:
                {
                alt33=12;
                }
                break;
            case API:
                {
                alt33=13;
                }
                break;
            case User:
                {
                alt33=14;
                }
                break;
            case Application:
                {
                alt33=15;
                }
                break;
            case Processor:
                {
                alt33=16;
                }
                break;
            case Content:
                {
                alt33=17;
                }
                break;
            case Test:
                {
                alt33=18;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // InternalN4MFParser.g:2319:3: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_0);
                    		

                    			newLeafNode(this_ID_0, grammarAccess.getN4mfIdentifierAccess().getIDTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalN4MFParser.g:2327:3: kw= ProjectId
                    {
                    kw=(Token)match(input,ProjectId,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getN4mfIdentifierAccess().getProjectIdKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalN4MFParser.g:2333:3: kw= ProjectType
                    {
                    kw=(Token)match(input,ProjectType,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getN4mfIdentifierAccess().getProjectTypeKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalN4MFParser.g:2339:3: kw= ProjectVersion
                    {
                    kw=(Token)match(input,ProjectVersion,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getN4mfIdentifierAccess().getProjectVersionKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalN4MFParser.g:2345:3: kw= VendorId
                    {
                    kw=(Token)match(input,VendorId,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getN4mfIdentifierAccess().getVendorIdKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalN4MFParser.g:2351:3: kw= VendorName
                    {
                    kw=(Token)match(input,VendorName,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getN4mfIdentifierAccess().getVendorNameKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalN4MFParser.g:2357:3: kw= Output
                    {
                    kw=(Token)match(input,Output,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getN4mfIdentifierAccess().getOutputKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalN4MFParser.g:2363:3: kw= Libraries
                    {
                    kw=(Token)match(input,Libraries,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getN4mfIdentifierAccess().getLibrariesKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalN4MFParser.g:2369:3: kw= Resources
                    {
                    kw=(Token)match(input,Resources,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getN4mfIdentifierAccess().getResourcesKeyword_8());
                    		

                    }
                    break;
                case 10 :
                    // InternalN4MFParser.g:2375:3: kw= Sources
                    {
                    kw=(Token)match(input,Sources,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getN4mfIdentifierAccess().getSourcesKeyword_9());
                    		

                    }
                    break;
                case 11 :
                    // InternalN4MFParser.g:2381:3: kw= ModuleFilters
                    {
                    kw=(Token)match(input,ModuleFilters,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getN4mfIdentifierAccess().getModuleFiltersKeyword_10());
                    		

                    }
                    break;
                case 12 :
                    // InternalN4MFParser.g:2387:3: (kw= ProjectDependencies kw= KW_System )
                    {
                    // InternalN4MFParser.g:2387:3: (kw= ProjectDependencies kw= KW_System )
                    // InternalN4MFParser.g:2388:4: kw= ProjectDependencies kw= KW_System
                    {
                    kw=(Token)match(input,ProjectDependencies,FOLLOW_25); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getN4mfIdentifierAccess().getProjectDependenciesKeyword_11_0());
                    			
                    kw=(Token)match(input,KW_System,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getN4mfIdentifierAccess().getSystemKeyword_11_1());
                    			

                    }


                    }
                    break;
                case 13 :
                    // InternalN4MFParser.g:2400:3: kw= API
                    {
                    kw=(Token)match(input,API,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getN4mfIdentifierAccess().getAPIKeyword_12());
                    		

                    }
                    break;
                case 14 :
                    // InternalN4MFParser.g:2406:3: kw= User
                    {
                    kw=(Token)match(input,User,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getN4mfIdentifierAccess().getUserKeyword_13());
                    		

                    }
                    break;
                case 15 :
                    // InternalN4MFParser.g:2412:3: kw= Application
                    {
                    kw=(Token)match(input,Application,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getN4mfIdentifierAccess().getApplicationKeyword_14());
                    		

                    }
                    break;
                case 16 :
                    // InternalN4MFParser.g:2418:3: (kw= Processor kw= Source )
                    {
                    // InternalN4MFParser.g:2418:3: (kw= Processor kw= Source )
                    // InternalN4MFParser.g:2419:4: kw= Processor kw= Source
                    {
                    kw=(Token)match(input,Processor,FOLLOW_26); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getN4mfIdentifierAccess().getProcessorKeyword_15_0());
                    			
                    kw=(Token)match(input,Source,FOLLOW_2); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getN4mfIdentifierAccess().getSourceKeyword_15_1());
                    			

                    }


                    }
                    break;
                case 17 :
                    // InternalN4MFParser.g:2431:3: kw= Content
                    {
                    kw=(Token)match(input,Content,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getN4mfIdentifierAccess().getContentKeyword_16());
                    		

                    }
                    break;
                case 18 :
                    // InternalN4MFParser.g:2437:3: kw= Test
                    {
                    kw=(Token)match(input,Test,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getN4mfIdentifierAccess().getTestKeyword_17());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleN4mfIdentifier"


    // $ANTLR start "ruleProjectType"
    // InternalN4MFParser.g:2446:1: ruleProjectType returns [Enumerator current=null] : ( (enumLiteral_0= Application ) | (enumLiteral_1= Processor ) | (enumLiteral_2= Library ) | (enumLiteral_3= API ) | (enumLiteral_4= RuntimeEnvironment ) | (enumLiteral_5= RuntimeLibrary ) | (enumLiteral_6= Test ) ) ;
    public final Enumerator ruleProjectType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;


        	enterRule();

        try {
            // InternalN4MFParser.g:2452:2: ( ( (enumLiteral_0= Application ) | (enumLiteral_1= Processor ) | (enumLiteral_2= Library ) | (enumLiteral_3= API ) | (enumLiteral_4= RuntimeEnvironment ) | (enumLiteral_5= RuntimeLibrary ) | (enumLiteral_6= Test ) ) )
            // InternalN4MFParser.g:2453:2: ( (enumLiteral_0= Application ) | (enumLiteral_1= Processor ) | (enumLiteral_2= Library ) | (enumLiteral_3= API ) | (enumLiteral_4= RuntimeEnvironment ) | (enumLiteral_5= RuntimeLibrary ) | (enumLiteral_6= Test ) )
            {
            // InternalN4MFParser.g:2453:2: ( (enumLiteral_0= Application ) | (enumLiteral_1= Processor ) | (enumLiteral_2= Library ) | (enumLiteral_3= API ) | (enumLiteral_4= RuntimeEnvironment ) | (enumLiteral_5= RuntimeLibrary ) | (enumLiteral_6= Test ) )
            int alt34=7;
            switch ( input.LA(1) ) {
            case Application:
                {
                alt34=1;
                }
                break;
            case Processor:
                {
                alt34=2;
                }
                break;
            case Library:
                {
                alt34=3;
                }
                break;
            case API:
                {
                alt34=4;
                }
                break;
            case RuntimeEnvironment:
                {
                alt34=5;
                }
                break;
            case RuntimeLibrary:
                {
                alt34=6;
                }
                break;
            case Test:
                {
                alt34=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // InternalN4MFParser.g:2454:3: (enumLiteral_0= Application )
                    {
                    // InternalN4MFParser.g:2454:3: (enumLiteral_0= Application )
                    // InternalN4MFParser.g:2455:4: enumLiteral_0= Application
                    {
                    enumLiteral_0=(Token)match(input,Application,FOLLOW_2); 

                    				current = grammarAccess.getProjectTypeAccess().getAPPLICATIONEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getProjectTypeAccess().getAPPLICATIONEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalN4MFParser.g:2462:3: (enumLiteral_1= Processor )
                    {
                    // InternalN4MFParser.g:2462:3: (enumLiteral_1= Processor )
                    // InternalN4MFParser.g:2463:4: enumLiteral_1= Processor
                    {
                    enumLiteral_1=(Token)match(input,Processor,FOLLOW_2); 

                    				current = grammarAccess.getProjectTypeAccess().getPROCESSOREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getProjectTypeAccess().getPROCESSOREnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalN4MFParser.g:2470:3: (enumLiteral_2= Library )
                    {
                    // InternalN4MFParser.g:2470:3: (enumLiteral_2= Library )
                    // InternalN4MFParser.g:2471:4: enumLiteral_2= Library
                    {
                    enumLiteral_2=(Token)match(input,Library,FOLLOW_2); 

                    				current = grammarAccess.getProjectTypeAccess().getLIBRARYEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getProjectTypeAccess().getLIBRARYEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalN4MFParser.g:2478:3: (enumLiteral_3= API )
                    {
                    // InternalN4MFParser.g:2478:3: (enumLiteral_3= API )
                    // InternalN4MFParser.g:2479:4: enumLiteral_3= API
                    {
                    enumLiteral_3=(Token)match(input,API,FOLLOW_2); 

                    				current = grammarAccess.getProjectTypeAccess().getAPIEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getProjectTypeAccess().getAPIEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalN4MFParser.g:2486:3: (enumLiteral_4= RuntimeEnvironment )
                    {
                    // InternalN4MFParser.g:2486:3: (enumLiteral_4= RuntimeEnvironment )
                    // InternalN4MFParser.g:2487:4: enumLiteral_4= RuntimeEnvironment
                    {
                    enumLiteral_4=(Token)match(input,RuntimeEnvironment,FOLLOW_2); 

                    				current = grammarAccess.getProjectTypeAccess().getRUNTIME_ENVIRONMENTEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getProjectTypeAccess().getRUNTIME_ENVIRONMENTEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalN4MFParser.g:2494:3: (enumLiteral_5= RuntimeLibrary )
                    {
                    // InternalN4MFParser.g:2494:3: (enumLiteral_5= RuntimeLibrary )
                    // InternalN4MFParser.g:2495:4: enumLiteral_5= RuntimeLibrary
                    {
                    enumLiteral_5=(Token)match(input,RuntimeLibrary,FOLLOW_2); 

                    				current = grammarAccess.getProjectTypeAccess().getRUNTIME_LIBRARYEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getProjectTypeAccess().getRUNTIME_LIBRARYEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalN4MFParser.g:2502:3: (enumLiteral_6= Test )
                    {
                    // InternalN4MFParser.g:2502:3: (enumLiteral_6= Test )
                    // InternalN4MFParser.g:2503:4: enumLiteral_6= Test
                    {
                    enumLiteral_6=(Token)match(input,Test,FOLLOW_2); 

                    				current = grammarAccess.getProjectTypeAccess().getTESTEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getProjectTypeAccess().getTESTEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProjectType"


    // $ANTLR start "ruleSourceFragmentType"
    // InternalN4MFParser.g:2513:1: ruleSourceFragmentType returns [Enumerator current=null] : ( (enumLiteral_0= Source ) | (enumLiteral_1= External ) | (enumLiteral_2= Test ) ) ;
    public final Enumerator ruleSourceFragmentType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalN4MFParser.g:2519:2: ( ( (enumLiteral_0= Source ) | (enumLiteral_1= External ) | (enumLiteral_2= Test ) ) )
            // InternalN4MFParser.g:2520:2: ( (enumLiteral_0= Source ) | (enumLiteral_1= External ) | (enumLiteral_2= Test ) )
            {
            // InternalN4MFParser.g:2520:2: ( (enumLiteral_0= Source ) | (enumLiteral_1= External ) | (enumLiteral_2= Test ) )
            int alt35=3;
            switch ( input.LA(1) ) {
            case Source:
                {
                alt35=1;
                }
                break;
            case External:
                {
                alt35=2;
                }
                break;
            case Test:
                {
                alt35=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // InternalN4MFParser.g:2521:3: (enumLiteral_0= Source )
                    {
                    // InternalN4MFParser.g:2521:3: (enumLiteral_0= Source )
                    // InternalN4MFParser.g:2522:4: enumLiteral_0= Source
                    {
                    enumLiteral_0=(Token)match(input,Source,FOLLOW_2); 

                    				current = grammarAccess.getSourceFragmentTypeAccess().getSOURCEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getSourceFragmentTypeAccess().getSOURCEEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalN4MFParser.g:2529:3: (enumLiteral_1= External )
                    {
                    // InternalN4MFParser.g:2529:3: (enumLiteral_1= External )
                    // InternalN4MFParser.g:2530:4: enumLiteral_1= External
                    {
                    enumLiteral_1=(Token)match(input,External,FOLLOW_2); 

                    				current = grammarAccess.getSourceFragmentTypeAccess().getEXTERNALEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getSourceFragmentTypeAccess().getEXTERNALEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalN4MFParser.g:2537:3: (enumLiteral_2= Test )
                    {
                    // InternalN4MFParser.g:2537:3: (enumLiteral_2= Test )
                    // InternalN4MFParser.g:2538:4: enumLiteral_2= Test
                    {
                    enumLiteral_2=(Token)match(input,Test,FOLLOW_2); 

                    				current = grammarAccess.getSourceFragmentTypeAccess().getTESTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getSourceFragmentTypeAccess().getTESTEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSourceFragmentType"


    // $ANTLR start "ruleModuleFilterType"
    // InternalN4MFParser.g:2548:1: ruleModuleFilterType returns [Enumerator current=null] : ( (enumLiteral_0= NoValidate ) | (enumLiteral_1= NoModuleWrap ) ) ;
    public final Enumerator ruleModuleFilterType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalN4MFParser.g:2554:2: ( ( (enumLiteral_0= NoValidate ) | (enumLiteral_1= NoModuleWrap ) ) )
            // InternalN4MFParser.g:2555:2: ( (enumLiteral_0= NoValidate ) | (enumLiteral_1= NoModuleWrap ) )
            {
            // InternalN4MFParser.g:2555:2: ( (enumLiteral_0= NoValidate ) | (enumLiteral_1= NoModuleWrap ) )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==NoValidate) ) {
                alt36=1;
            }
            else if ( (LA36_0==NoModuleWrap) ) {
                alt36=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // InternalN4MFParser.g:2556:3: (enumLiteral_0= NoValidate )
                    {
                    // InternalN4MFParser.g:2556:3: (enumLiteral_0= NoValidate )
                    // InternalN4MFParser.g:2557:4: enumLiteral_0= NoValidate
                    {
                    enumLiteral_0=(Token)match(input,NoValidate,FOLLOW_2); 

                    				current = grammarAccess.getModuleFilterTypeAccess().getNO_VALIDATEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getModuleFilterTypeAccess().getNO_VALIDATEEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalN4MFParser.g:2564:3: (enumLiteral_1= NoModuleWrap )
                    {
                    // InternalN4MFParser.g:2564:3: (enumLiteral_1= NoModuleWrap )
                    // InternalN4MFParser.g:2565:4: enumLiteral_1= NoModuleWrap
                    {
                    enumLiteral_1=(Token)match(input,NoModuleWrap,FOLLOW_2); 

                    				current = grammarAccess.getModuleFilterTypeAccess().getNO_MODULE_WRAPPINGEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getModuleFilterTypeAccess().getNO_MODULE_WRAPPINGEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModuleFilterType"


    // $ANTLR start "ruleProjectDependencyScope"
    // InternalN4MFParser.g:2575:1: ruleProjectDependencyScope returns [Enumerator current=null] : ( (enumLiteral_0= Compile ) | (enumLiteral_1= Test ) ) ;
    public final Enumerator ruleProjectDependencyScope() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalN4MFParser.g:2581:2: ( ( (enumLiteral_0= Compile ) | (enumLiteral_1= Test ) ) )
            // InternalN4MFParser.g:2582:2: ( (enumLiteral_0= Compile ) | (enumLiteral_1= Test ) )
            {
            // InternalN4MFParser.g:2582:2: ( (enumLiteral_0= Compile ) | (enumLiteral_1= Test ) )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==Compile) ) {
                alt37=1;
            }
            else if ( (LA37_0==Test) ) {
                alt37=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // InternalN4MFParser.g:2583:3: (enumLiteral_0= Compile )
                    {
                    // InternalN4MFParser.g:2583:3: (enumLiteral_0= Compile )
                    // InternalN4MFParser.g:2584:4: enumLiteral_0= Compile
                    {
                    enumLiteral_0=(Token)match(input,Compile,FOLLOW_2); 

                    				current = grammarAccess.getProjectDependencyScopeAccess().getCOMPILEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getProjectDependencyScopeAccess().getCOMPILEEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalN4MFParser.g:2591:3: (enumLiteral_1= Test )
                    {
                    // InternalN4MFParser.g:2591:3: (enumLiteral_1= Test )
                    // InternalN4MFParser.g:2592:4: enumLiteral_1= Test
                    {
                    enumLiteral_1=(Token)match(input,Test,FOLLOW_2); 

                    				current = grammarAccess.getProjectDependencyScopeAccess().getTESTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getProjectDependencyScopeAccess().getTESTEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProjectDependencyScope"


    // $ANTLR start "ruleModuleLoader"
    // InternalN4MFParser.g:2602:1: ruleModuleLoader returns [Enumerator current=null] : ( (enumLiteral_0= N4js ) | (enumLiteral_1= Commonjs ) | (enumLiteral_2= Node_builtin ) ) ;
    public final Enumerator ruleModuleLoader() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalN4MFParser.g:2608:2: ( ( (enumLiteral_0= N4js ) | (enumLiteral_1= Commonjs ) | (enumLiteral_2= Node_builtin ) ) )
            // InternalN4MFParser.g:2609:2: ( (enumLiteral_0= N4js ) | (enumLiteral_1= Commonjs ) | (enumLiteral_2= Node_builtin ) )
            {
            // InternalN4MFParser.g:2609:2: ( (enumLiteral_0= N4js ) | (enumLiteral_1= Commonjs ) | (enumLiteral_2= Node_builtin ) )
            int alt38=3;
            switch ( input.LA(1) ) {
            case N4js:
                {
                alt38=1;
                }
                break;
            case Commonjs:
                {
                alt38=2;
                }
                break;
            case Node_builtin:
                {
                alt38=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // InternalN4MFParser.g:2610:3: (enumLiteral_0= N4js )
                    {
                    // InternalN4MFParser.g:2610:3: (enumLiteral_0= N4js )
                    // InternalN4MFParser.g:2611:4: enumLiteral_0= N4js
                    {
                    enumLiteral_0=(Token)match(input,N4js,FOLLOW_2); 

                    				current = grammarAccess.getModuleLoaderAccess().getN4JSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getModuleLoaderAccess().getN4JSEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalN4MFParser.g:2618:3: (enumLiteral_1= Commonjs )
                    {
                    // InternalN4MFParser.g:2618:3: (enumLiteral_1= Commonjs )
                    // InternalN4MFParser.g:2619:4: enumLiteral_1= Commonjs
                    {
                    enumLiteral_1=(Token)match(input,Commonjs,FOLLOW_2); 

                    				current = grammarAccess.getModuleLoaderAccess().getCOMMONJSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getModuleLoaderAccess().getCOMMONJSEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalN4MFParser.g:2626:3: (enumLiteral_2= Node_builtin )
                    {
                    // InternalN4MFParser.g:2626:3: (enumLiteral_2= Node_builtin )
                    // InternalN4MFParser.g:2627:4: enumLiteral_2= Node_builtin
                    {
                    enumLiteral_2=(Token)match(input,Node_builtin,FOLLOW_2); 

                    				current = grammarAccess.getModuleLoaderAccess().getNODE_BUILTINEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getModuleLoaderAccess().getNODE_BUILTINEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModuleLoader"

    // Delegated rules


    protected DFA5 dfa5 = new DFA5(this);
    protected DFA27 dfa27 = new DFA27(this);
    static final String dfa_1s = "\27\uffff";
    static final String dfa_2s = "\1\1\26\uffff";
    static final String dfa_3s = "\1\4\26\uffff";
    static final String dfa_4s = "\1\44\26\uffff";
    static final String dfa_5s = "\1\uffff\1\26\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25";
    static final String dfa_6s = "\1\0\26\uffff}>";
    static final String[] dfa_7s = {
            "\1\10\1\11\1\12\1\15\1\13\1\uffff\1\14\1\4\1\25\1\uffff\1\24\1\26\2\uffff\1\16\1\3\1\uffff\1\17\1\7\1\6\1\uffff\1\21\1\2\1\22\1\uffff\1\5\2\uffff\1\23\3\uffff\1\20",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "()+ loopback of 78:5: ( ({...}? => ( ({...}? => (otherlv_1= ProjectId otherlv_2= Colon ( (lv_projectId_3_0= ruleN4mfIdentifier ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_4= ProjectType otherlv_5= Colon ( (lv_projectType_6_0= ruleProjectType ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_7= ProjectVersion otherlv_8= Colon ( (lv_projectVersion_9_0= ruleDeclaredVersion ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= VendorId otherlv_11= Colon ( (lv_declaredVendorId_12_0= ruleN4mfIdentifier ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= VendorName otherlv_14= Colon ( (lv_vendorName_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= MainModule otherlv_17= Colon ( (lv_mainModule_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_extendedRuntimeEnvironment_19_0= ruleExtendedRuntimeEnvironment ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_providedRuntimeLibraries_20_0= ruleProvidedRuntimeLibraries ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_requiredRuntimeLibraries_21_0= ruleRequiredRuntimeLibraries ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_projectDependencies_22_0= ruleProjectDependencies ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= ImplementationId otherlv_24= Colon ( (lv_implementationId_25_0= ruleN4mfIdentifier ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_implementedProjects_26_0= ruleImplementedProjects ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_initModules_27_0= ruleInitModules ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_execModule_28_0= ruleExecModule ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_29= Output otherlv_30= Colon ( (lv_outputPath_31_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= Libraries otherlv_33= LeftCurlyBracket ( (lv_libraryPaths_34_0= RULE_STRING ) ) (otherlv_35= Comma ( (lv_libraryPaths_36_0= RULE_STRING ) ) )* otherlv_37= RightCurlyBracket ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= Resources otherlv_39= LeftCurlyBracket ( (lv_resourcePaths_40_0= RULE_STRING ) ) (otherlv_41= Comma ( (lv_resourcePaths_42_0= RULE_STRING ) ) )* otherlv_43= RightCurlyBracket ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= Sources otherlv_45= LeftCurlyBracket ( (lv_sourceFragment_46_0= ruleSourceFragment ) )+ otherlv_47= RightCurlyBracket ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= ModuleFilters otherlv_49= LeftCurlyBracket ( (lv_moduleFilters_50_0= ruleModuleFilter ) )+ otherlv_51= RightCurlyBracket ) ) ) ) | ({...}? => ( ({...}? => ( (lv_testedProjects_52_0= ruleTestedProjects ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= ModuleLoader otherlv_54= Colon ( (lv_moduleLoader_55_0= ruleModuleLoader ) ) ) ) ) ) )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA5_0 = input.LA(1);

                         
                        int index5_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA5_0==EOF) ) {s = 1;}

                        else if ( LA5_0 == ProjectId && getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 0) ) {s = 2;}

                        else if ( LA5_0 == ProjectType && getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 1) ) {s = 3;}

                        else if ( LA5_0 == ProjectVersion && getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 2) ) {s = 4;}

                        else if ( LA5_0 == VendorId && getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 3) ) {s = 5;}

                        else if ( LA5_0 == VendorName && getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 4) ) {s = 6;}

                        else if ( LA5_0 == MainModule && getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 5) ) {s = 7;}

                        else if ( LA5_0 == ExtendedRuntimeEnvironment && getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 6) ) {s = 8;}

                        else if ( LA5_0 == ProvidedRuntimeLibraries && getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 7) ) {s = 9;}

                        else if ( LA5_0 == RequiredRuntimeLibraries && getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 8) ) {s = 10;}

                        else if ( LA5_0 == ProjectDependencies && getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 9) ) {s = 11;}

                        else if ( LA5_0 == ImplementationId && getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 10) ) {s = 12;}

                        else if ( LA5_0 == ImplementedProjects && getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 11) ) {s = 13;}

                        else if ( LA5_0 == InitModules && getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 12) ) {s = 14;}

                        else if ( LA5_0 == ExecModule && getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 13) ) {s = 15;}

                        else if ( LA5_0 == Output && getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 14) ) {s = 16;}

                        else if ( LA5_0 == Libraries && getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 15) ) {s = 17;}

                        else if ( LA5_0 == Resources && getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 16) ) {s = 18;}

                        else if ( LA5_0 == Sources && getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 17) ) {s = 19;}

                        else if ( LA5_0 == ModuleFilters && getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 18) ) {s = 20;}

                        else if ( LA5_0 == TestedProjects && getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 19) ) {s = 21;}

                        else if ( LA5_0 == ModuleLoader && getUnorderedGroupHelper().canSelect(grammarAccess.getProjectDescriptionAccess().getUnorderedGroup(), 20) ) {s = 22;}

                         
                        input.seek(index5_0);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 5, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_8s = "\1\uffff\13\24\1\uffff\3\24\1\uffff\2\24\2\uffff\2\24";
    static final String dfa_9s = "\1\10\13\4\1\46\3\4\1\45\2\4\2\uffff\2\4";
    static final String dfa_10s = "\1\66\13\67\1\46\3\67\1\45\2\67\2\uffff\2\67";
    static final String dfa_11s = "\23\uffff\1\1\1\2\2\uffff";
    static final String dfa_12s = "\27\uffff}>";
    static final String[] dfa_13s = {
            "\1\14\2\uffff\1\4\2\uffff\1\13\4\uffff\1\3\1\17\2\uffff\1\6\1\uffff\1\10\1\2\1\11\1\20\1\5\2\uffff\1\12\1\uffff\1\21\1\uffff\1\7\3\uffff\1\22\1\16\1\15\13\uffff\1\1",
            "\5\24\1\uffff\3\24\1\uffff\2\24\2\uffff\2\24\1\uffff\3\24\1\uffff\3\24\1\uffff\1\24\2\uffff\2\24\2\uffff\1\24\3\uffff\1\24\3\uffff\1\24\1\uffff\1\24\2\uffff\1\23\1\24\2\uffff\1\24\1\uffff\1\24",
            "\5\24\1\uffff\3\24\1\uffff\2\24\2\uffff\2\24\1\uffff\3\24\1\uffff\3\24\1\uffff\1\24\2\uffff\2\24\2\uffff\1\24\3\uffff\1\24\3\uffff\1\24\1\uffff\1\24\2\uffff\1\23\1\24\2\uffff\1\24\1\uffff\1\24",
            "\5\24\1\uffff\3\24\1\uffff\2\24\2\uffff\2\24\1\uffff\3\24\1\uffff\3\24\1\uffff\1\24\2\uffff\2\24\2\uffff\1\24\3\uffff\1\24\3\uffff\1\24\1\uffff\1\24\2\uffff\1\23\1\24\2\uffff\1\24\1\uffff\1\24",
            "\5\24\1\uffff\3\24\1\uffff\2\24\2\uffff\2\24\1\uffff\3\24\1\uffff\3\24\1\uffff\1\24\2\uffff\2\24\2\uffff\1\24\3\uffff\1\24\3\uffff\1\24\1\uffff\1\24\2\uffff\1\23\1\24\2\uffff\1\24\1\uffff\1\24",
            "\5\24\1\uffff\3\24\1\uffff\2\24\2\uffff\2\24\1\uffff\3\24\1\uffff\3\24\1\uffff\1\24\2\uffff\2\24\2\uffff\1\24\3\uffff\1\24\3\uffff\1\24\1\uffff\1\24\2\uffff\1\23\1\24\2\uffff\1\24\1\uffff\1\24",
            "\5\24\1\uffff\3\24\1\uffff\2\24\2\uffff\2\24\1\uffff\3\24\1\uffff\3\24\1\uffff\1\24\2\uffff\2\24\2\uffff\1\24\3\uffff\1\24\3\uffff\1\24\1\uffff\1\24\2\uffff\1\23\1\24\2\uffff\1\24\1\uffff\1\24",
            "\5\24\1\uffff\3\24\1\uffff\2\24\2\uffff\2\24\1\uffff\3\24\1\uffff\3\24\1\uffff\1\24\2\uffff\2\24\2\uffff\1\24\3\uffff\1\24\3\uffff\1\24\1\uffff\1\24\2\uffff\1\23\1\24\2\uffff\1\24\1\uffff\1\24",
            "\5\24\1\uffff\3\24\1\uffff\2\24\2\uffff\2\24\1\uffff\3\24\1\uffff\3\24\1\uffff\1\24\2\uffff\2\24\2\uffff\1\24\3\uffff\1\24\3\uffff\1\24\1\uffff\1\24\2\uffff\1\23\1\24\2\uffff\1\24\1\uffff\1\24",
            "\5\24\1\uffff\3\24\1\uffff\2\24\2\uffff\2\24\1\uffff\3\24\1\uffff\3\24\1\uffff\1\24\2\uffff\2\24\2\uffff\1\24\3\uffff\1\24\3\uffff\1\24\1\uffff\1\24\2\uffff\1\23\1\24\2\uffff\1\24\1\uffff\1\24",
            "\5\24\1\uffff\3\24\1\uffff\2\24\2\uffff\2\24\1\uffff\3\24\1\uffff\3\24\1\uffff\1\24\2\uffff\2\24\2\uffff\1\24\3\uffff\1\24\3\uffff\1\24\1\uffff\1\24\2\uffff\1\23\1\24\2\uffff\1\24\1\uffff\1\24",
            "\5\24\1\uffff\3\24\1\uffff\2\24\2\uffff\2\24\1\uffff\3\24\1\uffff\3\24\1\uffff\1\24\2\uffff\2\24\2\uffff\1\24\3\uffff\1\24\3\uffff\1\24\1\uffff\1\24\2\uffff\1\23\1\24\2\uffff\1\24\1\uffff\1\24",
            "\1\25",
            "\5\24\1\uffff\3\24\1\uffff\2\24\2\uffff\2\24\1\uffff\3\24\1\uffff\3\24\1\uffff\1\24\2\uffff\2\24\2\uffff\1\24\3\uffff\1\24\3\uffff\1\24\1\uffff\1\24\2\uffff\1\23\1\24\2\uffff\1\24\1\uffff\1\24",
            "\5\24\1\uffff\3\24\1\uffff\2\24\2\uffff\2\24\1\uffff\3\24\1\uffff\3\24\1\uffff\1\24\2\uffff\2\24\2\uffff\1\24\3\uffff\1\24\3\uffff\1\24\1\uffff\1\24\2\uffff\1\23\1\24\2\uffff\1\24\1\uffff\1\24",
            "\5\24\1\uffff\3\24\1\uffff\2\24\2\uffff\2\24\1\uffff\3\24\1\uffff\3\24\1\uffff\1\24\2\uffff\2\24\2\uffff\1\24\3\uffff\1\24\3\uffff\1\24\1\uffff\1\24\2\uffff\1\23\1\24\2\uffff\1\24\1\uffff\1\24",
            "\1\26",
            "\5\24\1\uffff\3\24\1\uffff\2\24\2\uffff\2\24\1\uffff\3\24\1\uffff\3\24\1\uffff\1\24\2\uffff\2\24\2\uffff\1\24\3\uffff\1\24\3\uffff\1\24\1\uffff\1\24\2\uffff\1\23\1\24\2\uffff\1\24\1\uffff\1\24",
            "\5\24\1\uffff\3\24\1\uffff\2\24\2\uffff\2\24\1\uffff\3\24\1\uffff\3\24\1\uffff\1\24\2\uffff\2\24\2\uffff\1\24\3\uffff\1\24\3\uffff\1\24\1\uffff\1\24\2\uffff\1\23\1\24\2\uffff\1\24\1\uffff\1\24",
            "",
            "",
            "\5\24\1\uffff\3\24\1\uffff\2\24\2\uffff\2\24\1\uffff\3\24\1\uffff\3\24\1\uffff\1\24\2\uffff\2\24\2\uffff\1\24\3\uffff\1\24\3\uffff\1\24\1\uffff\1\24\2\uffff\1\23\1\24\2\uffff\1\24\1\uffff\1\24",
            "\5\24\1\uffff\3\24\1\uffff\2\24\2\uffff\2\24\1\uffff\3\24\1\uffff\3\24\1\uffff\1\24\2\uffff\2\24\2\uffff\1\24\3\uffff\1\24\3\uffff\1\24\1\uffff\1\24\2\uffff\1\23\1\24\2\uffff\1\24\1\uffff\1\24"
    };
    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA27 extends DFA {

        public DFA27(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 27;
            this.eot = dfa_1;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "2122:3: ( ( (lv_declaredVendorId_0_0= ruleN4mfIdentifier ) ) otherlv_1= Colon )?";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x004007153E984900L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x000000112EECDDF2L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000050810102200L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0020400000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000012080000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0020012080000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000001010000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0020000001010000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000008040020000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x006007153E984900L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0120000000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0001800000000002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0084110200000002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000010200000002L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000600000000002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0008200000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000002000000000L});

}
