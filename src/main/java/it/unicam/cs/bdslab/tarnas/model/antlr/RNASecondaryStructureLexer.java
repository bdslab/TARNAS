// Generated from /Users/piermichelerosati/Documents/github/TARNAS/src/main/java/it/unicam/cs/bdslab/tarnas/model/antlr/RNASecondaryStructure.g4 by ANTLR 4.13.2

package it.unicam.cs.bdslab.tarnas.model.antlr;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class RNASecondaryStructureLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INDEX=1, ZERO_INDEX=2, SEP=3, BOND=4, BPSEQCTLINES=5, LINECT=6, NUCLEOTIDE=7, 
		EDBN=8, LINE1BPSEQCT=9, LINE2BPSEQCT=10, LINE3BPSEQCT=11, LINE4BPSEQCT=12, 
		XML_HEADER_LINE1=13, XML_HEADER_LINE2=14, XML_CONTENT=15, COMMENT=16, 
		WS=17;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"INDEX", "ZERO_INDEX", "SEP", "BOND", "BPSEQCTLINES", "LINECT", "NONEWLINE", 
			"IUPAC_CODE", "NUCLEOTIDE", "NON_STANDARD_CODE", "EDBN_CODE", "EDBN", 
			"LINE1BPSEQCT", "LINE2BPSEQCT", "LINE3BPSEQCT", "LINE4BPSEQCT", "XML_HEADER_LINE1", 
			"XML_HEADER_LINE2", "XML_CONTENT", "COMMENT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'0'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INDEX", "ZERO_INDEX", "SEP", "BOND", "BPSEQCTLINES", "LINECT", 
			"NUCLEOTIDE", "EDBN", "LINE1BPSEQCT", "LINE2BPSEQCT", "LINE3BPSEQCT", 
			"LINE4BPSEQCT", "XML_HEADER_LINE1", "XML_HEADER_LINE2", "XML_CONTENT", 
			"COMMENT", "WS"
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


	public RNASecondaryStructureLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "RNASecondaryStructure.g4"; }

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
		"\u0004\u0000\u0011\u0134\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0001\u0000\u0001\u0000\u0005\u0000.\b\u0000\n\u0000\f\u00001\t\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0005\u0005C\b\u0005"+
		"\n\u0005\f\u0005F\t\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005V\b\u0005"+
		"\u0001\u0005\u0005\u0005Y\b\u0005\n\u0005\f\u0005\\\t\u0005\u0001\u0005"+
		"\u0003\u0005_\b\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0004\bi\b\b\u000b\b\f\bj\u0001"+
		"\t\u0001\t\u0001\n\u0003\np\b\n\u0001\u000b\u0004\u000bs\b\u000b\u000b"+
		"\u000b\f\u000bt\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0005\f\u0081\b\f\n\f\f\f\u0084\t\f\u0001\f"+
		"\u0003\f\u0087\b\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u0095\b\r\n\r\f\r\u0098"+
		"\t\r\u0001\r\u0003\r\u009b\b\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u00aa\b\u000e\n\u000e"+
		"\f\u000e\u00ad\t\u000e\u0001\u000e\u0003\u000e\u00b0\b\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f"+
		"\u00be\b\u000f\n\u000f\f\u000f\u00c1\t\u000f\u0001\u000f\u0003\u000f\u00c4"+
		"\b\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u00cf\b\u0010\n"+
		"\u0010\f\u0010\u00d2\t\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0003\u0010\u00d8\b\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003"+
		"\u0011\u0101\b\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0005"+
		"\u0012\u010d\b\u0012\n\u0012\f\u0012\u0110\t\u0012\u0001\u0012\u0001\u0012"+
		"\u0005\u0012\u0114\b\u0012\n\u0012\f\u0012\u0117\t\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0005\u0013\u0124\b\u0013\n"+
		"\u0013\f\u0013\u0127\t\u0013\u0001\u0013\u0003\u0013\u012a\b\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0014\u0004\u0014\u012f\b\u0014\u000b\u0014\f"+
		"\u0014\u0130\u0001\u0014\u0001\u0014\nDZ\u0082\u0096\u00ab\u00bf\u00d0"+
		"\u010e\u0115\u0125\u0000\u0015\u0001\u0001\u0003\u0002\u0005\u0003\u0007"+
		"\u0004\t\u0005\u000b\u0006\r\u0000\u000f\u0000\u0011\u0007\u0013\u0000"+
		"\u0015\u0000\u0017\b\u0019\t\u001b\n\u001d\u000b\u001f\f!\r#\u000e%\u000f"+
		"\'\u0010)\u0011\u0001\u0000\t\u0001\u000019\u0001\u000009\u0002\u0000"+
		",,;;\u0002\u0000\n\n\r\r\r\u0000--ADGHKKMNRWYYadghkkmnrwyy\r\u0000\"\""+
		"++//4477==??IIOP[[]]__~~\b\u0000()..<<>>A[]]a{}}\u0002\u0000##>>\u0003"+
		"\u0000\t\n\r\r  \u0148\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003"+
		"\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007"+
		"\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001"+
		"\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0017\u0001"+
		"\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001"+
		"\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001"+
		"\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000"+
		"\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000"+
		"\u0000)\u0001\u0000\u0000\u0000\u0001+\u0001\u0000\u0000\u0000\u00032"+
		"\u0001\u0000\u0000\u0000\u00054\u0001\u0000\u0000\u0000\u00076\u0001\u0000"+
		"\u0000\u0000\t<\u0001\u0000\u0000\u0000\u000bD\u0001\u0000\u0000\u0000"+
		"\rb\u0001\u0000\u0000\u0000\u000fd\u0001\u0000\u0000\u0000\u0011h\u0001"+
		"\u0000\u0000\u0000\u0013l\u0001\u0000\u0000\u0000\u0015o\u0001\u0000\u0000"+
		"\u0000\u0017r\u0001\u0000\u0000\u0000\u0019v\u0001\u0000\u0000\u0000\u001b"+
		"\u008a\u0001\u0000\u0000\u0000\u001d\u009e\u0001\u0000\u0000\u0000\u001f"+
		"\u00b3\u0001\u0000\u0000\u0000!\u00c7\u0001\u0000\u0000\u0000#\u00db\u0001"+
		"\u0000\u0000\u0000%\u0104\u0001\u0000\u0000\u0000\'\u0121\u0001\u0000"+
		"\u0000\u0000)\u012e\u0001\u0000\u0000\u0000+/\u0007\u0000\u0000\u0000"+
		",.\u0007\u0001\u0000\u0000-,\u0001\u0000\u0000\u0000.1\u0001\u0000\u0000"+
		"\u0000/-\u0001\u0000\u0000\u0000/0\u0001\u0000\u0000\u00000\u0002\u0001"+
		"\u0000\u0000\u00001/\u0001\u0000\u0000\u000023\u00050\u0000\u00003\u0004"+
		"\u0001\u0000\u0000\u000045\u0007\u0002\u0000\u00005\u0006\u0001\u0000"+
		"\u0000\u000067\u0005(\u0000\u000078\u0003\u0001\u0000\u000089\u0003\u0005"+
		"\u0002\u00009:\u0003\u0001\u0000\u0000:;\u0005)\u0000\u0000;\b\u0001\u0000"+
		"\u0000\u0000<=\u0003\u0019\f\u0000=>\u0003\u001b\r\u0000>?\u0003\u001d"+
		"\u000e\u0000?@\u0003\u001f\u000f\u0000@\n\u0001\u0000\u0000\u0000AC\u0003"+
		"\r\u0006\u0000BA\u0001\u0000\u0000\u0000CF\u0001\u0000\u0000\u0000DE\u0001"+
		"\u0000\u0000\u0000DB\u0001\u0000\u0000\u0000EU\u0001\u0000\u0000\u0000"+
		"FD\u0001\u0000\u0000\u0000GH\u0005E\u0000\u0000HI\u0005N\u0000\u0000I"+
		"J\u0005E\u0000\u0000JK\u0005R\u0000\u0000KL\u0005G\u0000\u0000LV\u0005"+
		"Y\u0000\u0000MN\u0005E\u0000\u0000NO\u0005n\u0000\u0000OP\u0005e\u0000"+
		"\u0000PQ\u0005r\u0000\u0000QR\u0005g\u0000\u0000RV\u0005y\u0000\u0000"+
		"ST\u0005d\u0000\u0000TV\u0005G\u0000\u0000UG\u0001\u0000\u0000\u0000U"+
		"M\u0001\u0000\u0000\u0000US\u0001\u0000\u0000\u0000VZ\u0001\u0000\u0000"+
		"\u0000WY\t\u0000\u0000\u0000XW\u0001\u0000\u0000\u0000Y\\\u0001\u0000"+
		"\u0000\u0000Z[\u0001\u0000\u0000\u0000ZX\u0001\u0000\u0000\u0000[^\u0001"+
		"\u0000\u0000\u0000\\Z\u0001\u0000\u0000\u0000]_\u0005\r\u0000\u0000^]"+
		"\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000"+
		"\u0000`a\u0005\n\u0000\u0000a\f\u0001\u0000\u0000\u0000bc\b\u0003\u0000"+
		"\u0000c\u000e\u0001\u0000\u0000\u0000de\u0007\u0004\u0000\u0000e\u0010"+
		"\u0001\u0000\u0000\u0000fi\u0003\u000f\u0007\u0000gi\u0003\u0013\t\u0000"+
		"hf\u0001\u0000\u0000\u0000hg\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000"+
		"\u0000jh\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000k\u0012\u0001"+
		"\u0000\u0000\u0000lm\u0007\u0005\u0000\u0000m\u0014\u0001\u0000\u0000"+
		"\u0000np\u0007\u0006\u0000\u0000on\u0001\u0000\u0000\u0000p\u0016\u0001"+
		"\u0000\u0000\u0000qs\u0003\u0015\n\u0000rq\u0001\u0000\u0000\u0000st\u0001"+
		"\u0000\u0000\u0000tr\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000"+
		"u\u0018\u0001\u0000\u0000\u0000vw\u0005F\u0000\u0000wx\u0005i\u0000\u0000"+
		"xy\u0005l\u0000\u0000yz\u0005e\u0000\u0000z{\u0005n\u0000\u0000{|\u0005"+
		"a\u0000\u0000|}\u0005m\u0000\u0000}~\u0005e\u0000\u0000~\u0082\u0001\u0000"+
		"\u0000\u0000\u007f\u0081\t\u0000\u0000\u0000\u0080\u007f\u0001\u0000\u0000"+
		"\u0000\u0081\u0084\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000"+
		"\u0000\u0082\u0080\u0001\u0000\u0000\u0000\u0083\u0086\u0001\u0000\u0000"+
		"\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0085\u0087\u0005\r\u0000\u0000"+
		"\u0086\u0085\u0001\u0000\u0000\u0000\u0086\u0087\u0001\u0000\u0000\u0000"+
		"\u0087\u0088\u0001\u0000\u0000\u0000\u0088\u0089\u0005\n\u0000\u0000\u0089"+
		"\u001a\u0001\u0000\u0000\u0000\u008a\u008b\u0005O\u0000\u0000\u008b\u008c"+
		"\u0005r\u0000\u0000\u008c\u008d\u0005g\u0000\u0000\u008d\u008e\u0005a"+
		"\u0000\u0000\u008e\u008f\u0005n\u0000\u0000\u008f\u0090\u0005i\u0000\u0000"+
		"\u0090\u0091\u0005s\u0000\u0000\u0091\u0092\u0005m\u0000\u0000\u0092\u0096"+
		"\u0001\u0000\u0000\u0000\u0093\u0095\t\u0000\u0000\u0000\u0094\u0093\u0001"+
		"\u0000\u0000\u0000\u0095\u0098\u0001\u0000\u0000\u0000\u0096\u0097\u0001"+
		"\u0000\u0000\u0000\u0096\u0094\u0001\u0000\u0000\u0000\u0097\u009a\u0001"+
		"\u0000\u0000\u0000\u0098\u0096\u0001\u0000\u0000\u0000\u0099\u009b\u0005"+
		"\r\u0000\u0000\u009a\u0099\u0001\u0000\u0000\u0000\u009a\u009b\u0001\u0000"+
		"\u0000\u0000\u009b\u009c\u0001\u0000\u0000\u0000\u009c\u009d\u0005\n\u0000"+
		"\u0000\u009d\u001c\u0001\u0000\u0000\u0000\u009e\u009f\u0005A\u0000\u0000"+
		"\u009f\u00a0\u0005c\u0000\u0000\u00a0\u00a1\u0005c\u0000\u0000\u00a1\u00a2"+
		"\u0005e\u0000\u0000\u00a2\u00a3\u0005s\u0000\u0000\u00a3\u00a4\u0005s"+
		"\u0000\u0000\u00a4\u00a5\u0005i\u0000\u0000\u00a5\u00a6\u0005o\u0000\u0000"+
		"\u00a6\u00a7\u0005n\u0000\u0000\u00a7\u00ab\u0001\u0000\u0000\u0000\u00a8"+
		"\u00aa\t\u0000\u0000\u0000\u00a9\u00a8\u0001\u0000\u0000\u0000\u00aa\u00ad"+
		"\u0001\u0000\u0000\u0000\u00ab\u00ac\u0001\u0000\u0000\u0000\u00ab\u00a9"+
		"\u0001\u0000\u0000\u0000\u00ac\u00af\u0001\u0000\u0000\u0000\u00ad\u00ab"+
		"\u0001\u0000\u0000\u0000\u00ae\u00b0\u0005\r\u0000\u0000\u00af\u00ae\u0001"+
		"\u0000\u0000\u0000\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001"+
		"\u0000\u0000\u0000\u00b1\u00b2\u0005\n\u0000\u0000\u00b2\u001e\u0001\u0000"+
		"\u0000\u0000\u00b3\u00b4\u0005C\u0000\u0000\u00b4\u00b5\u0005i\u0000\u0000"+
		"\u00b5\u00b6\u0005t\u0000\u0000\u00b6\u00b7\u0005a\u0000\u0000\u00b7\u00b8"+
		"\u0005t\u0000\u0000\u00b8\u00b9\u0005i\u0000\u0000\u00b9\u00ba\u0005o"+
		"\u0000\u0000\u00ba\u00bb\u0005n\u0000\u0000\u00bb\u00bf\u0001\u0000\u0000"+
		"\u0000\u00bc\u00be\t\u0000\u0000\u0000\u00bd\u00bc\u0001\u0000\u0000\u0000"+
		"\u00be\u00c1\u0001\u0000\u0000\u0000\u00bf\u00c0\u0001\u0000\u0000\u0000"+
		"\u00bf\u00bd\u0001\u0000\u0000\u0000\u00c0\u00c3\u0001\u0000\u0000\u0000"+
		"\u00c1\u00bf\u0001\u0000\u0000\u0000\u00c2\u00c4\u0005\r\u0000\u0000\u00c3"+
		"\u00c2\u0001\u0000\u0000\u0000\u00c3\u00c4\u0001\u0000\u0000\u0000\u00c4"+
		"\u00c5\u0001\u0000\u0000\u0000\u00c5\u00c6\u0005\n\u0000\u0000\u00c6 "+
		"\u0001\u0000\u0000\u0000\u00c7\u00c8\u0005<\u0000\u0000\u00c8\u00c9\u0005"+
		"?\u0000\u0000\u00c9\u00ca\u0005x\u0000\u0000\u00ca\u00cb\u0005m\u0000"+
		"\u0000\u00cb\u00cc\u0005l\u0000\u0000\u00cc\u00d0\u0001\u0000\u0000\u0000"+
		"\u00cd\u00cf\t\u0000\u0000\u0000\u00ce\u00cd\u0001\u0000\u0000\u0000\u00cf"+
		"\u00d2\u0001\u0000\u0000\u0000\u00d0\u00d1\u0001\u0000\u0000\u0000\u00d0"+
		"\u00ce\u0001\u0000\u0000\u0000\u00d1\u00d3\u0001\u0000\u0000\u0000\u00d2"+
		"\u00d0\u0001\u0000\u0000\u0000\u00d3\u00d4\u0005?\u0000\u0000\u00d4\u00d5"+
		"\u0005>\u0000\u0000\u00d5\u00d7\u0001\u0000\u0000\u0000\u00d6\u00d8\u0005"+
		"\r\u0000\u0000\u00d7\u00d6\u0001\u0000\u0000\u0000\u00d7\u00d8\u0001\u0000"+
		"\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000\u0000\u00d9\u00da\u0005\n\u0000"+
		"\u0000\u00da\"\u0001\u0000\u0000\u0000\u00db\u00dc\u0005<\u0000\u0000"+
		"\u00dc\u00dd\u0005!\u0000\u0000\u00dd\u00de\u0005D\u0000\u0000\u00de\u00df"+
		"\u0005O\u0000\u0000\u00df\u00e0\u0005C\u0000\u0000\u00e0\u00e1\u0005T"+
		"\u0000\u0000\u00e1\u00e2\u0005Y\u0000\u0000\u00e2\u00e3\u0005P\u0000\u0000"+
		"\u00e3\u00e4\u0005E\u0000\u0000\u00e4\u00e5\u0005 \u0000\u0000\u00e5\u00e6"+
		"\u0005r\u0000\u0000\u00e6\u00e7\u0005n\u0000\u0000\u00e7\u00e8\u0005a"+
		"\u0000\u0000\u00e8\u00e9\u0005m\u0000\u0000\u00e9\u00ea\u0005l\u0000\u0000"+
		"\u00ea\u00eb\u0005 \u0000\u0000\u00eb\u00ec\u0005S\u0000\u0000\u00ec\u00ed"+
		"\u0005Y\u0000\u0000\u00ed\u00ee\u0005S\u0000\u0000\u00ee\u00ef\u0005T"+
		"\u0000\u0000\u00ef\u00f0\u0005E\u0000\u0000\u00f0\u00f1\u0005M\u0000\u0000"+
		"\u00f1\u00f2\u0005 \u0000\u0000\u00f2\u00f3\u0005\"\u0000\u0000\u00f3"+
		"\u00f4\u0005r\u0000\u0000\u00f4\u00f5\u0005n\u0000\u0000\u00f5\u00f6\u0005"+
		"a\u0000\u0000\u00f6\u00f7\u0005m\u0000\u0000\u00f7\u00f8\u0005l\u0000"+
		"\u0000\u00f8\u00f9\u0005.\u0000\u0000\u00f9\u00fa\u0005d\u0000\u0000\u00fa"+
		"\u00fb\u0005t\u0000\u0000\u00fb\u00fc\u0005d\u0000\u0000\u00fc\u00fd\u0005"+
		"\"\u0000\u0000\u00fd\u00fe\u0005>\u0000\u0000\u00fe\u0100\u0001\u0000"+
		"\u0000\u0000\u00ff\u0101\u0005\r\u0000\u0000\u0100\u00ff\u0001\u0000\u0000"+
		"\u0000\u0100\u0101\u0001\u0000\u0000\u0000\u0101\u0102\u0001\u0000\u0000"+
		"\u0000\u0102\u0103\u0005\n\u0000\u0000\u0103$\u0001\u0000\u0000\u0000"+
		"\u0104\u0105\u0005<\u0000\u0000\u0105\u0106\u0005r\u0000\u0000\u0106\u0107"+
		"\u0005n\u0000\u0000\u0107\u0108\u0005a\u0000\u0000\u0108\u0109\u0005m"+
		"\u0000\u0000\u0109\u010a\u0005l\u0000\u0000\u010a\u010e\u0001\u0000\u0000"+
		"\u0000\u010b\u010d\t\u0000\u0000\u0000\u010c\u010b\u0001\u0000\u0000\u0000"+
		"\u010d\u0110\u0001\u0000\u0000\u0000\u010e\u010f\u0001\u0000\u0000\u0000"+
		"\u010e\u010c\u0001\u0000\u0000\u0000\u010f\u0111\u0001\u0000\u0000\u0000"+
		"\u0110\u010e\u0001\u0000\u0000\u0000\u0111\u0115\u0005>\u0000\u0000\u0112"+
		"\u0114\t\u0000\u0000\u0000\u0113\u0112\u0001\u0000\u0000\u0000\u0114\u0117"+
		"\u0001\u0000\u0000\u0000\u0115\u0116\u0001\u0000\u0000\u0000\u0115\u0113"+
		"\u0001\u0000\u0000\u0000\u0116\u0118\u0001\u0000\u0000\u0000\u0117\u0115"+
		"\u0001\u0000\u0000\u0000\u0118\u0119\u0005<\u0000\u0000\u0119\u011a\u0005"+
		"/\u0000\u0000\u011a\u011b\u0005r\u0000\u0000\u011b\u011c\u0005n\u0000"+
		"\u0000\u011c\u011d\u0005a\u0000\u0000\u011d\u011e\u0005m\u0000\u0000\u011e"+
		"\u011f\u0005l\u0000\u0000\u011f\u0120\u0005>\u0000\u0000\u0120&\u0001"+
		"\u0000\u0000\u0000\u0121\u0125\u0007\u0007\u0000\u0000\u0122\u0124\t\u0000"+
		"\u0000\u0000\u0123\u0122\u0001\u0000\u0000\u0000\u0124\u0127\u0001\u0000"+
		"\u0000\u0000\u0125\u0126\u0001\u0000\u0000\u0000\u0125\u0123\u0001\u0000"+
		"\u0000\u0000\u0126\u0129\u0001\u0000\u0000\u0000\u0127\u0125\u0001\u0000"+
		"\u0000\u0000\u0128\u012a\u0005\r\u0000\u0000\u0129\u0128\u0001\u0000\u0000"+
		"\u0000\u0129\u012a\u0001\u0000\u0000\u0000\u012a\u012b\u0001\u0000\u0000"+
		"\u0000\u012b\u012c\u0005\n\u0000\u0000\u012c(\u0001\u0000\u0000\u0000"+
		"\u012d\u012f\u0007\b\u0000\u0000\u012e\u012d\u0001\u0000\u0000\u0000\u012f"+
		"\u0130\u0001\u0000\u0000\u0000\u0130\u012e\u0001\u0000\u0000\u0000\u0130"+
		"\u0131\u0001\u0000\u0000\u0000\u0131\u0132\u0001\u0000\u0000\u0000\u0132"+
		"\u0133\u0006\u0014\u0000\u0000\u0133*\u0001\u0000\u0000\u0000\u001a\u0000"+
		"/DUZ^hjot\u0082\u0086\u0096\u009a\u00ab\u00af\u00bf\u00c3\u00d0\u00d7"+
		"\u0100\u010e\u0115\u0125\u0129\u0130\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}