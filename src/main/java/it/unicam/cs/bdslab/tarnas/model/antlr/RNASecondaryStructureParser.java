package it.unicam.cs.bdslab.tarnas.model.antlr;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class RNASecondaryStructureParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INDEX=1, ZERO_INDEX=2, SEP=3, BOND=4, BPSEQCTLINES=5, LINECT=6, NUCLEOTIDE=7, 
		EDBN=8, LINE1BPSEQCT=9, LINE2BPSEQCT=10, LINE3BPSEQCT=11, LINE4BPSEQCT=12, 
		XML_HEADER_LINE1=13, XML_HEADER_LINE2=14, XML_CONTENT=15, COMMENT=16, 
		WS=17;
	public static final int
		RULE_rna_format = 0, RULE_aas = 1, RULE_edbn = 2, RULE_fasta = 3, RULE_bpseq = 4, 
		RULE_ct = 5, RULE_edbn_structure = 6, RULE_sequence = 7, RULE_bonds = 8, 
		RULE_ct_structure = 9, RULE_ct_line = 10, RULE_bpseq_structure = 11, RULE_bpseq_line = 12, 
		RULE_rnaml = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"rna_format", "aas", "edbn", "fasta", "bpseq", "ct", "edbn_structure", 
			"sequence", "bonds", "ct_structure", "ct_line", "bpseq_structure", "bpseq_line", 
			"rnaml"
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

	@Override
	public String getGrammarFileName() { return "RNASecondaryStructure.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public RNASecondaryStructureParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Rna_formatContext extends ParserRuleContext {
		public AasContext aas() {
			return getRuleContext(AasContext.class,0);
		}
		public CtContext ct() {
			return getRuleContext(CtContext.class,0);
		}
		public EdbnContext edbn() {
			return getRuleContext(EdbnContext.class,0);
		}
		public BpseqContext bpseq() {
			return getRuleContext(BpseqContext.class,0);
		}
		public FastaContext fasta() {
			return getRuleContext(FastaContext.class,0);
		}
		public RnamlContext rnaml() {
			return getRuleContext(RnamlContext.class,0);
		}
		public Rna_formatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rna_format; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).enterRna_format(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).exitRna_format(this);
		}
	}

	public final Rna_formatContext rna_format() throws RecognitionException {
		Rna_formatContext _localctx = new Rna_formatContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_rna_format);
		try {
			setState(34);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(28);
				aas();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(29);
				ct();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(30);
				edbn();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(31);
				bpseq();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(32);
				fasta();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(33);
				rnaml();
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class AasContext extends ParserRuleContext {
		public List<TerminalNode> COMMENT() { return getTokens(RNASecondaryStructureParser.COMMENT); }
		public TerminalNode COMMENT(int i) {
			return getToken(RNASecondaryStructureParser.COMMENT, i);
		}
		public SequenceContext sequence() {
			return getRuleContext(SequenceContext.class,0);
		}
		public List<BondsContext> bonds() {
			return getRuleContexts(BondsContext.class);
		}
		public BondsContext bonds(int i) {
			return getRuleContext(BondsContext.class,i);
		}
		public AasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aas; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).enterAas(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).exitAas(this);
		}
	}

	public final AasContext aas() throws RecognitionException {
		AasContext _localctx = new AasContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_aas);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMENT) {
				{
				{
				setState(36);
				match(COMMENT);
				}
				}
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NUCLEOTIDE) {
				{
				setState(42);
				sequence();
				}
			}

			setState(46); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(45);
				bonds();
				}
				}
				setState(48); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==BOND );
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

	@SuppressWarnings("CheckReturnValue")
	public static class EdbnContext extends ParserRuleContext {
		public Edbn_structureContext edbn_structure() {
			return getRuleContext(Edbn_structureContext.class,0);
		}
		public List<TerminalNode> COMMENT() { return getTokens(RNASecondaryStructureParser.COMMENT); }
		public TerminalNode COMMENT(int i) {
			return getToken(RNASecondaryStructureParser.COMMENT, i);
		}
		public SequenceContext sequence() {
			return getRuleContext(SequenceContext.class,0);
		}
		public EdbnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_edbn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).enterEdbn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).exitEdbn(this);
		}
	}

	public final EdbnContext edbn() throws RecognitionException {
		EdbnContext _localctx = new EdbnContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_edbn);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMENT) {
				{
				{
				setState(50);
				match(COMMENT);
				}
				}
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NUCLEOTIDE) {
				{
				setState(56);
				sequence();
				}
			}

			setState(59);
			edbn_structure();
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

	@SuppressWarnings("CheckReturnValue")
	public static class FastaContext extends ParserRuleContext {
		public SequenceContext sequence() {
			return getRuleContext(SequenceContext.class,0);
		}
		public List<TerminalNode> COMMENT() { return getTokens(RNASecondaryStructureParser.COMMENT); }
		public TerminalNode COMMENT(int i) {
			return getToken(RNASecondaryStructureParser.COMMENT, i);
		}
		public FastaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fasta; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).enterFasta(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).exitFasta(this);
		}
	}

	public final FastaContext fasta() throws RecognitionException {
		FastaContext _localctx = new FastaContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_fasta);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMENT) {
				{
				{
				setState(61);
				match(COMMENT);
				}
				}
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(67);
			sequence();
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

	@SuppressWarnings("CheckReturnValue")
	public static class BpseqContext extends ParserRuleContext {
		public Bpseq_structureContext bpseq_structure() {
			return getRuleContext(Bpseq_structureContext.class,0);
		}
		public TerminalNode BPSEQCTLINES() { return getToken(RNASecondaryStructureParser.BPSEQCTLINES, 0); }
		public List<TerminalNode> COMMENT() { return getTokens(RNASecondaryStructureParser.COMMENT); }
		public TerminalNode COMMENT(int i) {
			return getToken(RNASecondaryStructureParser.COMMENT, i);
		}
		public BpseqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bpseq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).enterBpseq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).exitBpseq(this);
		}
	}

	public final BpseqContext bpseq() throws RecognitionException {
		BpseqContext _localctx = new BpseqContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_bpseq);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BPSEQCTLINES) {
					{
					setState(69);
					match(BPSEQCTLINES);
					}
				}

				}
				break;
			case 2:
				{
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMENT) {
					{
					{
					setState(72);
					match(COMMENT);
					}
					}
					setState(77);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
			setState(80);
			bpseq_structure();
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

	@SuppressWarnings("CheckReturnValue")
	public static class CtContext extends ParserRuleContext {
		public TerminalNode LINECT() { return getToken(RNASecondaryStructureParser.LINECT, 0); }
		public Ct_structureContext ct_structure() {
			return getRuleContext(Ct_structureContext.class,0);
		}
		public TerminalNode BPSEQCTLINES() { return getToken(RNASecondaryStructureParser.BPSEQCTLINES, 0); }
		public List<TerminalNode> COMMENT() { return getTokens(RNASecondaryStructureParser.COMMENT); }
		public TerminalNode COMMENT(int i) {
			return getToken(RNASecondaryStructureParser.COMMENT, i);
		}
		public CtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ct; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).enterCt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).exitCt(this);
		}
	}

	public final CtContext ct() throws RecognitionException {
		CtContext _localctx = new CtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ct);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BPSEQCTLINES) {
					{
					setState(82);
					match(BPSEQCTLINES);
					}
				}

				}
				break;
			case 2:
				{
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMENT) {
					{
					{
					setState(85);
					match(COMMENT);
					}
					}
					setState(90);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
			setState(93);
			match(LINECT);
			setState(94);
			ct_structure();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Edbn_structureContext extends ParserRuleContext {
		public List<TerminalNode> EDBN() { return getTokens(RNASecondaryStructureParser.EDBN); }
		public TerminalNode EDBN(int i) {
			return getToken(RNASecondaryStructureParser.EDBN, i);
		}
		public Edbn_structureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_edbn_structure; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).enterEdbn_structure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).exitEdbn_structure(this);
		}
	}

	public final Edbn_structureContext edbn_structure() throws RecognitionException {
		Edbn_structureContext _localctx = new Edbn_structureContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_edbn_structure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(96);
				match(EDBN);
				}
				}
				setState(99); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==EDBN );
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

	@SuppressWarnings("CheckReturnValue")
	public static class SequenceContext extends ParserRuleContext {
		public List<TerminalNode> NUCLEOTIDE() { return getTokens(RNASecondaryStructureParser.NUCLEOTIDE); }
		public TerminalNode NUCLEOTIDE(int i) {
			return getToken(RNASecondaryStructureParser.NUCLEOTIDE, i);
		}
		public SequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).enterSequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).exitSequence(this);
		}
	}

	public final SequenceContext sequence() throws RecognitionException {
		SequenceContext _localctx = new SequenceContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_sequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(101);
				match(NUCLEOTIDE);
				}
				}
				setState(104); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUCLEOTIDE );
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

	@SuppressWarnings("CheckReturnValue")
	public static class BondsContext extends ParserRuleContext {
		public TerminalNode BOND() { return getToken(RNASecondaryStructureParser.BOND, 0); }
		public TerminalNode SEP() { return getToken(RNASecondaryStructureParser.SEP, 0); }
		public BondsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bonds; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).enterBonds(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).exitBonds(this);
		}
	}

	public final BondsContext bonds() throws RecognitionException {
		BondsContext _localctx = new BondsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_bonds);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(BOND);
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEP) {
				{
				setState(107);
				match(SEP);
				}
			}

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

	@SuppressWarnings("CheckReturnValue")
	public static class Ct_structureContext extends ParserRuleContext {
		public List<Ct_lineContext> ct_line() {
			return getRuleContexts(Ct_lineContext.class);
		}
		public Ct_lineContext ct_line(int i) {
			return getRuleContext(Ct_lineContext.class,i);
		}
		public Ct_structureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ct_structure; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).enterCt_structure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).exitCt_structure(this);
		}
	}

	public final Ct_structureContext ct_structure() throws RecognitionException {
		Ct_structureContext _localctx = new Ct_structureContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_ct_structure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(110);
				ct_line();
				}
				}
				setState(113); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==INDEX );
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

	@SuppressWarnings("CheckReturnValue")
	public static class Ct_lineContext extends ParserRuleContext {
		public Ct_lineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ct_line; }
	 
		public Ct_lineContext() { }
		public void copyFrom(Ct_lineContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CtLineUnpairedContext extends Ct_lineContext {
		public List<TerminalNode> INDEX() { return getTokens(RNASecondaryStructureParser.INDEX); }
		public TerminalNode INDEX(int i) {
			return getToken(RNASecondaryStructureParser.INDEX, i);
		}
		public TerminalNode NUCLEOTIDE() { return getToken(RNASecondaryStructureParser.NUCLEOTIDE, 0); }
		public List<TerminalNode> ZERO_INDEX() { return getTokens(RNASecondaryStructureParser.ZERO_INDEX); }
		public TerminalNode ZERO_INDEX(int i) {
			return getToken(RNASecondaryStructureParser.ZERO_INDEX, i);
		}
		public CtLineUnpairedContext(Ct_lineContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).enterCtLineUnpaired(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).exitCtLineUnpaired(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CtLineBondContext extends Ct_lineContext {
		public List<TerminalNode> INDEX() { return getTokens(RNASecondaryStructureParser.INDEX); }
		public TerminalNode INDEX(int i) {
			return getToken(RNASecondaryStructureParser.INDEX, i);
		}
		public TerminalNode NUCLEOTIDE() { return getToken(RNASecondaryStructureParser.NUCLEOTIDE, 0); }
		public List<TerminalNode> ZERO_INDEX() { return getTokens(RNASecondaryStructureParser.ZERO_INDEX); }
		public TerminalNode ZERO_INDEX(int i) {
			return getToken(RNASecondaryStructureParser.ZERO_INDEX, i);
		}
		public CtLineBondContext(Ct_lineContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).enterCtLineBond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).exitCtLineBond(this);
		}
	}

	public final Ct_lineContext ct_line() throws RecognitionException {
		Ct_lineContext _localctx = new Ct_lineContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_ct_line);
		int _la;
		try {
			setState(127);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				_localctx = new CtLineUnpairedContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(115);
				match(INDEX);
				setState(116);
				match(NUCLEOTIDE);
				setState(117);
				_la = _input.LA(1);
				if ( !(_la==INDEX || _la==ZERO_INDEX) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(118);
				_la = _input.LA(1);
				if ( !(_la==INDEX || _la==ZERO_INDEX) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(119);
				match(ZERO_INDEX);
				setState(120);
				match(INDEX);
				}
				break;
			case 2:
				_localctx = new CtLineBondContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				match(INDEX);
				setState(122);
				match(NUCLEOTIDE);
				setState(123);
				_la = _input.LA(1);
				if ( !(_la==INDEX || _la==ZERO_INDEX) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(124);
				_la = _input.LA(1);
				if ( !(_la==INDEX || _la==ZERO_INDEX) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(125);
				match(INDEX);
				setState(126);
				match(INDEX);
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class Bpseq_structureContext extends ParserRuleContext {
		public List<Bpseq_lineContext> bpseq_line() {
			return getRuleContexts(Bpseq_lineContext.class);
		}
		public Bpseq_lineContext bpseq_line(int i) {
			return getRuleContext(Bpseq_lineContext.class,i);
		}
		public Bpseq_structureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bpseq_structure; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).enterBpseq_structure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).exitBpseq_structure(this);
		}
	}

	public final Bpseq_structureContext bpseq_structure() throws RecognitionException {
		Bpseq_structureContext _localctx = new Bpseq_structureContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_bpseq_structure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(129);
				bpseq_line();
				}
				}
				setState(132); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==INDEX );
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

	@SuppressWarnings("CheckReturnValue")
	public static class Bpseq_lineContext extends ParserRuleContext {
		public Bpseq_lineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bpseq_line; }
	 
		public Bpseq_lineContext() { }
		public void copyFrom(Bpseq_lineContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BpseqLineUnpairedContext extends Bpseq_lineContext {
		public TerminalNode INDEX() { return getToken(RNASecondaryStructureParser.INDEX, 0); }
		public TerminalNode NUCLEOTIDE() { return getToken(RNASecondaryStructureParser.NUCLEOTIDE, 0); }
		public TerminalNode ZERO_INDEX() { return getToken(RNASecondaryStructureParser.ZERO_INDEX, 0); }
		public BpseqLineUnpairedContext(Bpseq_lineContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).enterBpseqLineUnpaired(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).exitBpseqLineUnpaired(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BpseqLineBondContext extends Bpseq_lineContext {
		public List<TerminalNode> INDEX() { return getTokens(RNASecondaryStructureParser.INDEX); }
		public TerminalNode INDEX(int i) {
			return getToken(RNASecondaryStructureParser.INDEX, i);
		}
		public TerminalNode NUCLEOTIDE() { return getToken(RNASecondaryStructureParser.NUCLEOTIDE, 0); }
		public BpseqLineBondContext(Bpseq_lineContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).enterBpseqLineBond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).exitBpseqLineBond(this);
		}
	}

	public final Bpseq_lineContext bpseq_line() throws RecognitionException {
		Bpseq_lineContext _localctx = new Bpseq_lineContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_bpseq_line);
		try {
			setState(140);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new BpseqLineUnpairedContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(134);
				match(INDEX);
				setState(135);
				match(NUCLEOTIDE);
				setState(136);
				match(ZERO_INDEX);
				}
				break;
			case 2:
				_localctx = new BpseqLineBondContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(137);
				match(INDEX);
				setState(138);
				match(NUCLEOTIDE);
				setState(139);
				match(INDEX);
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class RnamlContext extends ParserRuleContext {
		public RnamlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rnaml; }
	 
		public RnamlContext() { }
		public void copyFrom(RnamlContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RnamlContentContext extends RnamlContext {
		public TerminalNode XML_HEADER_LINE1() { return getToken(RNASecondaryStructureParser.XML_HEADER_LINE1, 0); }
		public TerminalNode XML_HEADER_LINE2() { return getToken(RNASecondaryStructureParser.XML_HEADER_LINE2, 0); }
		public TerminalNode XML_CONTENT() { return getToken(RNASecondaryStructureParser.XML_CONTENT, 0); }
		public RnamlContentContext(RnamlContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).enterRnamlContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).exitRnamlContent(this);
		}
	}

	public final RnamlContext rnaml() throws RecognitionException {
		RnamlContext _localctx = new RnamlContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_rnaml);
		try {
			_localctx = new RnamlContentContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(XML_HEADER_LINE1);
			setState(143);
			match(XML_HEADER_LINE2);
			setState(144);
			match(XML_CONTENT);
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
		"\u0004\u0001\u0011\u0093\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0003\u0000#\b\u0000\u0001\u0001\u0005"+
		"\u0001&\b\u0001\n\u0001\f\u0001)\t\u0001\u0001\u0001\u0003\u0001,\b\u0001"+
		"\u0001\u0001\u0004\u0001/\b\u0001\u000b\u0001\f\u00010\u0001\u0002\u0005"+
		"\u00024\b\u0002\n\u0002\f\u00027\t\u0002\u0001\u0002\u0003\u0002:\b\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0005\u0003?\b\u0003\n\u0003\f\u0003"+
		"B\t\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0003\u0004G\b\u0004\u0001"+
		"\u0004\u0005\u0004J\b\u0004\n\u0004\f\u0004M\t\u0004\u0003\u0004O\b\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0003\u0005T\b\u0005\u0001\u0005"+
		"\u0005\u0005W\b\u0005\n\u0005\f\u0005Z\t\u0005\u0003\u0005\\\b\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0004\u0006b\b\u0006\u000b"+
		"\u0006\f\u0006c\u0001\u0007\u0004\u0007g\b\u0007\u000b\u0007\f\u0007h"+
		"\u0001\b\u0001\b\u0003\bm\b\b\u0001\t\u0004\tp\b\t\u000b\t\f\tq\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0003\n\u0080\b\n\u0001\u000b\u0004\u000b\u0083\b\u000b"+
		"\u000b\u000b\f\u000b\u0084\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0003\f\u008d\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0000\u0000"+
		"\u000e\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u0000\u0001\u0001\u0000\u0001\u0002\u009c\u0000\"\u0001\u0000\u0000"+
		"\u0000\u0002\'\u0001\u0000\u0000\u0000\u00045\u0001\u0000\u0000\u0000"+
		"\u0006@\u0001\u0000\u0000\u0000\bN\u0001\u0000\u0000\u0000\n[\u0001\u0000"+
		"\u0000\u0000\fa\u0001\u0000\u0000\u0000\u000ef\u0001\u0000\u0000\u0000"+
		"\u0010j\u0001\u0000\u0000\u0000\u0012o\u0001\u0000\u0000\u0000\u0014\u007f"+
		"\u0001\u0000\u0000\u0000\u0016\u0082\u0001\u0000\u0000\u0000\u0018\u008c"+
		"\u0001\u0000\u0000\u0000\u001a\u008e\u0001\u0000\u0000\u0000\u001c#\u0003"+
		"\u0002\u0001\u0000\u001d#\u0003\n\u0005\u0000\u001e#\u0003\u0004\u0002"+
		"\u0000\u001f#\u0003\b\u0004\u0000 #\u0003\u0006\u0003\u0000!#\u0003\u001a"+
		"\r\u0000\"\u001c\u0001\u0000\u0000\u0000\"\u001d\u0001\u0000\u0000\u0000"+
		"\"\u001e\u0001\u0000\u0000\u0000\"\u001f\u0001\u0000\u0000\u0000\" \u0001"+
		"\u0000\u0000\u0000\"!\u0001\u0000\u0000\u0000#\u0001\u0001\u0000\u0000"+
		"\u0000$&\u0005\u0010\u0000\u0000%$\u0001\u0000\u0000\u0000&)\u0001\u0000"+
		"\u0000\u0000\'%\u0001\u0000\u0000\u0000\'(\u0001\u0000\u0000\u0000(+\u0001"+
		"\u0000\u0000\u0000)\'\u0001\u0000\u0000\u0000*,\u0003\u000e\u0007\u0000"+
		"+*\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000,.\u0001\u0000\u0000"+
		"\u0000-/\u0003\u0010\b\u0000.-\u0001\u0000\u0000\u0000/0\u0001\u0000\u0000"+
		"\u00000.\u0001\u0000\u0000\u000001\u0001\u0000\u0000\u00001\u0003\u0001"+
		"\u0000\u0000\u000024\u0005\u0010\u0000\u000032\u0001\u0000\u0000\u0000"+
		"47\u0001\u0000\u0000\u000053\u0001\u0000\u0000\u000056\u0001\u0000\u0000"+
		"\u000069\u0001\u0000\u0000\u000075\u0001\u0000\u0000\u00008:\u0003\u000e"+
		"\u0007\u000098\u0001\u0000\u0000\u00009:\u0001\u0000\u0000\u0000:;\u0001"+
		"\u0000\u0000\u0000;<\u0003\f\u0006\u0000<\u0005\u0001\u0000\u0000\u0000"+
		"=?\u0005\u0010\u0000\u0000>=\u0001\u0000\u0000\u0000?B\u0001\u0000\u0000"+
		"\u0000@>\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000AC\u0001\u0000"+
		"\u0000\u0000B@\u0001\u0000\u0000\u0000CD\u0003\u000e\u0007\u0000D\u0007"+
		"\u0001\u0000\u0000\u0000EG\u0005\u0005\u0000\u0000FE\u0001\u0000\u0000"+
		"\u0000FG\u0001\u0000\u0000\u0000GO\u0001\u0000\u0000\u0000HJ\u0005\u0010"+
		"\u0000\u0000IH\u0001\u0000\u0000\u0000JM\u0001\u0000\u0000\u0000KI\u0001"+
		"\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000LO\u0001\u0000\u0000\u0000"+
		"MK\u0001\u0000\u0000\u0000NF\u0001\u0000\u0000\u0000NK\u0001\u0000\u0000"+
		"\u0000OP\u0001\u0000\u0000\u0000PQ\u0003\u0016\u000b\u0000Q\t\u0001\u0000"+
		"\u0000\u0000RT\u0005\u0005\u0000\u0000SR\u0001\u0000\u0000\u0000ST\u0001"+
		"\u0000\u0000\u0000T\\\u0001\u0000\u0000\u0000UW\u0005\u0010\u0000\u0000"+
		"VU\u0001\u0000\u0000\u0000WZ\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000"+
		"\u0000XY\u0001\u0000\u0000\u0000Y\\\u0001\u0000\u0000\u0000ZX\u0001\u0000"+
		"\u0000\u0000[S\u0001\u0000\u0000\u0000[X\u0001\u0000\u0000\u0000\\]\u0001"+
		"\u0000\u0000\u0000]^\u0005\u0006\u0000\u0000^_\u0003\u0012\t\u0000_\u000b"+
		"\u0001\u0000\u0000\u0000`b\u0005\b\u0000\u0000a`\u0001\u0000\u0000\u0000"+
		"bc\u0001\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000"+
		"\u0000d\r\u0001\u0000\u0000\u0000eg\u0005\u0007\u0000\u0000fe\u0001\u0000"+
		"\u0000\u0000gh\u0001\u0000\u0000\u0000hf\u0001\u0000\u0000\u0000hi\u0001"+
		"\u0000\u0000\u0000i\u000f\u0001\u0000\u0000\u0000jl\u0005\u0004\u0000"+
		"\u0000km\u0005\u0003\u0000\u0000lk\u0001\u0000\u0000\u0000lm\u0001\u0000"+
		"\u0000\u0000m\u0011\u0001\u0000\u0000\u0000np\u0003\u0014\n\u0000on\u0001"+
		"\u0000\u0000\u0000pq\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000"+
		"qr\u0001\u0000\u0000\u0000r\u0013\u0001\u0000\u0000\u0000st\u0005\u0001"+
		"\u0000\u0000tu\u0005\u0007\u0000\u0000uv\u0007\u0000\u0000\u0000vw\u0007"+
		"\u0000\u0000\u0000wx\u0005\u0002\u0000\u0000x\u0080\u0005\u0001\u0000"+
		"\u0000yz\u0005\u0001\u0000\u0000z{\u0005\u0007\u0000\u0000{|\u0007\u0000"+
		"\u0000\u0000|}\u0007\u0000\u0000\u0000}~\u0005\u0001\u0000\u0000~\u0080"+
		"\u0005\u0001\u0000\u0000\u007fs\u0001\u0000\u0000\u0000\u007fy\u0001\u0000"+
		"\u0000\u0000\u0080\u0015\u0001\u0000\u0000\u0000\u0081\u0083\u0003\u0018"+
		"\f\u0000\u0082\u0081\u0001\u0000\u0000\u0000\u0083\u0084\u0001\u0000\u0000"+
		"\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000"+
		"\u0000\u0085\u0017\u0001\u0000\u0000\u0000\u0086\u0087\u0005\u0001\u0000"+
		"\u0000\u0087\u0088\u0005\u0007\u0000\u0000\u0088\u008d\u0005\u0002\u0000"+
		"\u0000\u0089\u008a\u0005\u0001\u0000\u0000\u008a\u008b\u0005\u0007\u0000"+
		"\u0000\u008b\u008d\u0005\u0001\u0000\u0000\u008c\u0086\u0001\u0000\u0000"+
		"\u0000\u008c\u0089\u0001\u0000\u0000\u0000\u008d\u0019\u0001\u0000\u0000"+
		"\u0000\u008e\u008f\u0005\r\u0000\u0000\u008f\u0090\u0005\u000e\u0000\u0000"+
		"\u0090\u0091\u0005\u000f\u0000\u0000\u0091\u001b\u0001\u0000\u0000\u0000"+
		"\u0014\"\'+059@FKNSX[chlq\u007f\u0084\u008c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}