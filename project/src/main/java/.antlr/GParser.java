// Generated from c:\Users\Tosty\Documents\Programming\Spring2020\Compilers\Project\CompilersProject\project\src\main\java\G.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		KEYWORD=1, WS=2, INTLITERAL=3, FLOATLITERAL=4, STRINGLITERAL=5, IDENTIFIER=6, 
		OPERATOR=7, COMMENT=8;
	public static final int
		RULE_inputFile = 0;
	public static final String[] ruleNames = {
		"inputFile"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "KEYWORD", "WS", "INTLITERAL", "FLOATLITERAL", "STRINGLITERAL", 
		"IDENTIFIER", "OPERATOR", "COMMENT"
	};
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

	@Override
	public String getGrammarFileName() { return "G.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class InputFileContext extends ParserRuleContext {
		public List<TerminalNode> WS() { return getTokens(GParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(GParser.WS, i);
		}
		public List<TerminalNode> INTLITERAL() { return getTokens(GParser.INTLITERAL); }
		public TerminalNode INTLITERAL(int i) {
			return getToken(GParser.INTLITERAL, i);
		}
		public List<TerminalNode> FLOATLITERAL() { return getTokens(GParser.FLOATLITERAL); }
		public TerminalNode FLOATLITERAL(int i) {
			return getToken(GParser.FLOATLITERAL, i);
		}
		public List<TerminalNode> COMMENT() { return getTokens(GParser.COMMENT); }
		public TerminalNode COMMENT(int i) {
			return getToken(GParser.COMMENT, i);
		}
		public List<TerminalNode> KEYWORD() { return getTokens(GParser.KEYWORD); }
		public TerminalNode KEYWORD(int i) {
			return getToken(GParser.KEYWORD, i);
		}
		public List<TerminalNode> OPERATOR() { return getTokens(GParser.OPERATOR); }
		public TerminalNode OPERATOR(int i) {
			return getToken(GParser.OPERATOR, i);
		}
		public InputFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inputFile; }
	}

	public final InputFileContext inputFile() throws RecognitionException {
		InputFileContext _localctx = new InputFileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_inputFile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(3); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(2);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KEYWORD) | (1L << WS) | (1L << INTLITERAL) | (1L << FLOATLITERAL) | (1L << OPERATOR) | (1L << COMMENT))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(5); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KEYWORD) | (1L << WS) | (1L << INTLITERAL) | (1L << FLOATLITERAL) | (1L << OPERATOR) | (1L << COMMENT))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\n\n\4\2\t\2\3\2\6"+
		"\2\6\n\2\r\2\16\2\7\3\2\2\2\3\2\2\3\4\2\3\6\t\n\2\t\2\5\3\2\2\2\4\6\t"+
		"\2\2\2\5\4\3\2\2\2\6\7\3\2\2\2\7\5\3\2\2\2\7\b\3\2\2\2\b\3\3\2\2\2\3\7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}