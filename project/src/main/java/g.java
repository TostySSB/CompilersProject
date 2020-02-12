// Generated from /Users/admin/Desktop/2020 Spring Semester/Compilers/CompilersProject/project/src/main/java/g.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class g extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PROGRAM=1, BEGIN=2, END=3, FUNCTION=4, READ=5, WRITE=6, IF=7, ELSE=8, 
		ENDIF=9, WHILE=10, ENDWHILE=11, CONTINUE=12, BREAK=13, RETURN=14, INT=15, 
		VOID=16, STRING=17, FLOAT=18, WHITESPACE=19, INTLITERAL=20, FLOATLITERAL=21, 
		COMMENT=22;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"WHITESPACE", "INTLITERAL", "FLOATLITERAL", "COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PROGRAM", "BEGIN", "END", "FUNCTION", "READ", "WRITE", "IF", "ELSE", 
			"ENDIF", "WHILE", "ENDWHILE", "CONTINUE", "BREAK", "RETURN", "INT", "VOID", 
			"STRING", "FLOAT", "WHITESPACE", "INTLITERAL", "FLOATLITERAL", "COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public g(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "g.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\30,\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\3\2\6\2\r\n\2\r\2\16\2\16\3\2\3\2\3\3\6\3\24\n"+
		"\3\r\3\16\3\25\3\4\7\4\31\n\4\f\4\16\4\34\13\4\3\4\3\4\6\4 \n\4\r\4\16"+
		"\4!\3\5\3\5\3\5\3\5\7\5(\n\5\f\5\16\5+\13\5\2\2\6\3\25\5\26\7\27\t\30"+
		"\3\2\4\5\2\13\f\17\17\"\"\3\2\62;\2\60\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\3\f\3\2\2\2\5\23\3\2\2\2\7\32\3\2\2\2\t#\3\2\2\2\13\r"+
		"\t\2\2\2\f\13\3\2\2\2\r\16\3\2\2\2\16\f\3\2\2\2\16\17\3\2\2\2\17\20\3"+
		"\2\2\2\20\21\b\2\2\2\21\4\3\2\2\2\22\24\t\3\2\2\23\22\3\2\2\2\24\25\3"+
		"\2\2\2\25\23\3\2\2\2\25\26\3\2\2\2\26\6\3\2\2\2\27\31\t\3\2\2\30\27\3"+
		"\2\2\2\31\34\3\2\2\2\32\30\3\2\2\2\32\33\3\2\2\2\33\35\3\2\2\2\34\32\3"+
		"\2\2\2\35\37\13\2\2\2\36 \t\3\2\2\37\36\3\2\2\2 !\3\2\2\2!\37\3\2\2\2"+
		"!\"\3\2\2\2\"\b\3\2\2\2#$\7/\2\2$%\7/\2\2%)\3\2\2\2&(\13\2\2\2\'&\3\2"+
		"\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*\n\3\2\2\2+)\3\2\2\2\b\2\16\25\32"+
		"!)\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}