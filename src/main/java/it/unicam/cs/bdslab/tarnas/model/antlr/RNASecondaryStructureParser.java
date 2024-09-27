// Generated from D:/UNIVERSITA/paper_tarnas/TARNAS/src/main/java/it/unicam/cs/bdslab/tarnas/model/antlr/RNASecondaryStructure.g4 by ANTLR 4.13.2

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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RNASecondaryStructureVisitor ) return ((RNASecondaryStructureVisitor<? extends T>)visitor).visitRna_format(this);
			else return visitor.visitChildren(this);
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
		public BondsContext bonds() {
			return getRuleContext(BondsContext.class,0);
		}
		public List<TerminalNode> COMMENT() { return getTokens(RNASecondaryStructureParser.COMMENT); }
		public TerminalNode COMMENT(int i) {
			return getToken(RNASecondaryStructureParser.COMMENT, i);
		}
		public SequenceContext sequence() {
			return getRuleContext(SequenceContext.class,0);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RNASecondaryStructureVisitor ) return ((RNASecondaryStructureVisitor<? extends T>)visitor).visitAas(this);
			else return visitor.visitChildren(this);
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

			setState(45);
			bonds();
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RNASecondaryStructureVisitor ) return ((RNASecondaryStructureVisitor<? extends T>)visitor).visitEdbn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EdbnContext edbn() throws RecognitionException {
		EdbnContext _localctx = new EdbnContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_edbn);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMENT) {
				{
				{
				setState(47);
				match(COMMENT);
				}
				}
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NUCLEOTIDE) {
				{
				setState(53);
				sequence();
				}
			}

			setState(56);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RNASecondaryStructureVisitor ) return ((RNASecondaryStructureVisitor<? extends T>)visitor).visitFasta(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FastaContext fasta() throws RecognitionException {
		FastaContext _localctx = new FastaContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_fasta);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMENT) {
				{
				{
				setState(58);
				match(COMMENT);
				}
				}
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(64);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RNASecondaryStructureVisitor ) return ((RNASecondaryStructureVisitor<? extends T>)visitor).visitBpseq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BpseqContext bpseq() throws RecognitionException {
		BpseqContext _localctx = new BpseqContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_bpseq);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BPSEQCTLINES) {
					{
					setState(66);
					match(BPSEQCTLINES);
					}
				}

				}
				break;
			case 2:
				{
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMENT) {
					{
					{
					setState(69);
					match(COMMENT);
					}
					}
					setState(74);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
			setState(77);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RNASecondaryStructureVisitor ) return ((RNASecondaryStructureVisitor<? extends T>)visitor).visitCt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CtContext ct() throws RecognitionException {
		CtContext _localctx = new CtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ct);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BPSEQCTLINES) {
					{
					setState(79);
					match(BPSEQCTLINES);
					}
				}

				}
				break;
			case 2:
				{
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMENT) {
					{
					{
					setState(82);
					match(COMMENT);
					}
					}
					setState(87);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
			setState(90);
			match(LINECT);
			setState(91);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RNASecondaryStructureVisitor ) return ((RNASecondaryStructureVisitor<? extends T>)visitor).visitEdbn_structure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Edbn_structureContext edbn_structure() throws RecognitionException {
		Edbn_structureContext _localctx = new Edbn_structureContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_edbn_structure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(93);
				match(EDBN);
				}
				}
				setState(96); 
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RNASecondaryStructureVisitor ) return ((RNASecondaryStructureVisitor<? extends T>)visitor).visitSequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SequenceContext sequence() throws RecognitionException {
		SequenceContext _localctx = new SequenceContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_sequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(98);
				match(NUCLEOTIDE);
				}
				}
				setState(101); 
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
		public BondsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bonds; }
	 
		public BondsContext() { }
		public void copyFrom(BondsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BondsEndContext extends BondsContext {
		public BondsEndContext(BondsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).enterBondsEnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).exitBondsEnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RNASecondaryStructureVisitor ) return ((RNASecondaryStructureVisitor<? extends T>)visitor).visitBondsEnd(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BondsContinueContext extends BondsContext {
		public TerminalNode BOND() { return getToken(RNASecondaryStructureParser.BOND, 0); }
		public BondsContext bonds() {
			return getRuleContext(BondsContext.class,0);
		}
		public TerminalNode SEP() { return getToken(RNASecondaryStructureParser.SEP, 0); }
		public BondsContinueContext(BondsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).enterBondsContinue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).exitBondsContinue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RNASecondaryStructureVisitor ) return ((RNASecondaryStructureVisitor<? extends T>)visitor).visitBondsContinue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BondsContext bonds() throws RecognitionException {
		BondsContext _localctx = new BondsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_bonds);
		int _la;
		try {
			setState(109);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOND:
				_localctx = new BondsContinueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(103);
				match(BOND);
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEP) {
					{
					setState(104);
					match(SEP);
					}
				}

				setState(107);
				bonds();
				}
				break;
			case EOF:
				_localctx = new BondsEndContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RNASecondaryStructureVisitor ) return ((RNASecondaryStructureVisitor<? extends T>)visitor).visitCt_structure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Ct_structureContext ct_structure() throws RecognitionException {
		Ct_structureContext _localctx = new Ct_structureContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_ct_structure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(111);
				ct_line();
				}
				}
				setState(114); 
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RNASecondaryStructureVisitor ) return ((RNASecondaryStructureVisitor<? extends T>)visitor).visitCtLineUnpaired(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RNASecondaryStructureVisitor ) return ((RNASecondaryStructureVisitor<? extends T>)visitor).visitCtLineBond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Ct_lineContext ct_line() throws RecognitionException {
		Ct_lineContext _localctx = new Ct_lineContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_ct_line);
		int _la;
		try {
			setState(128);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				_localctx = new CtLineUnpairedContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				match(INDEX);
				setState(117);
				match(NUCLEOTIDE);
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
				_la = _input.LA(1);
				if ( !(_la==INDEX || _la==ZERO_INDEX) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(120);
				match(ZERO_INDEX);
				setState(121);
				match(INDEX);
				}
				break;
			case 2:
				_localctx = new CtLineBondContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(122);
				match(INDEX);
				setState(123);
				match(NUCLEOTIDE);
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
				_la = _input.LA(1);
				if ( !(_la==INDEX || _la==ZERO_INDEX) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(126);
				match(INDEX);
				setState(127);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RNASecondaryStructureVisitor ) return ((RNASecondaryStructureVisitor<? extends T>)visitor).visitBpseq_structure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bpseq_structureContext bpseq_structure() throws RecognitionException {
		Bpseq_structureContext _localctx = new Bpseq_structureContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_bpseq_structure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(130);
				bpseq_line();
				}
				}
				setState(133); 
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RNASecondaryStructureVisitor ) return ((RNASecondaryStructureVisitor<? extends T>)visitor).visitBpseqLineUnpaired(this);
			else return visitor.visitChildren(this);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RNASecondaryStructureVisitor ) return ((RNASecondaryStructureVisitor<? extends T>)visitor).visitBpseqLineBond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bpseq_lineContext bpseq_line() throws RecognitionException {
		Bpseq_lineContext _localctx = new Bpseq_lineContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_bpseq_line);
		try {
			setState(141);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new BpseqLineUnpairedContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(135);
				match(INDEX);
				setState(136);
				match(NUCLEOTIDE);
				setState(137);
				match(ZERO_INDEX);
				}
				break;
			case 2:
				_localctx = new BpseqLineBondContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
				match(INDEX);
				setState(139);
				match(NUCLEOTIDE);
				setState(140);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof RNASecondaryStructureVisitor ) return ((RNASecondaryStructureVisitor<? extends T>)visitor).visitRnamlContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RnamlContext rnaml() throws RecognitionException {
		RnamlContext _localctx = new RnamlContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_rnaml);
		try {
			_localctx = new RnamlContentContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(XML_HEADER_LINE1);
			setState(144);
			match(XML_HEADER_LINE2);
			setState(145);
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
		"\u0004\u0001\u0011\u0094\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0003\u0000#\b\u0000\u0001\u0001\u0005"+
		"\u0001&\b\u0001\n\u0001\f\u0001)\t\u0001\u0001\u0001\u0003\u0001,\b\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0005\u00021\b\u0002\n\u0002\f\u0002"+
		"4\t\u0002\u0001\u0002\u0003\u00027\b\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0005\u0003<\b\u0003\n\u0003\f\u0003?\t\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0003\u0004D\b\u0004\u0001\u0004\u0005\u0004G\b\u0004"+
		"\n\u0004\f\u0004J\t\u0004\u0003\u0004L\b\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0003\u0005Q\b\u0005\u0001\u0005\u0005\u0005T\b\u0005\n\u0005"+
		"\f\u0005W\t\u0005\u0003\u0005Y\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0004\u0006_\b\u0006\u000b\u0006\f\u0006`\u0001\u0007\u0004"+
		"\u0007d\b\u0007\u000b\u0007\f\u0007e\u0001\b\u0001\b\u0003\bj\b\b\u0001"+
		"\b\u0001\b\u0003\bn\b\b\u0001\t\u0004\tq\b\t\u000b\t\f\tr\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0003\n\u0081\b\n\u0001\u000b\u0004\u000b\u0084\b\u000b\u000b"+
		"\u000b\f\u000b\u0085\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003"+
		"\f\u008e\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0000\u0000\u000e"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u0000\u0001\u0001\u0000\u0001\u0002\u009d\u0000\"\u0001\u0000\u0000\u0000"+
		"\u0002\'\u0001\u0000\u0000\u0000\u00042\u0001\u0000\u0000\u0000\u0006"+
		"=\u0001\u0000\u0000\u0000\bK\u0001\u0000\u0000\u0000\nX\u0001\u0000\u0000"+
		"\u0000\f^\u0001\u0000\u0000\u0000\u000ec\u0001\u0000\u0000\u0000\u0010"+
		"m\u0001\u0000\u0000\u0000\u0012p\u0001\u0000\u0000\u0000\u0014\u0080\u0001"+
		"\u0000\u0000\u0000\u0016\u0083\u0001\u0000\u0000\u0000\u0018\u008d\u0001"+
		"\u0000\u0000\u0000\u001a\u008f\u0001\u0000\u0000\u0000\u001c#\u0003\u0002"+
		"\u0001\u0000\u001d#\u0003\n\u0005\u0000\u001e#\u0003\u0004\u0002\u0000"+
		"\u001f#\u0003\b\u0004\u0000 #\u0003\u0006\u0003\u0000!#\u0003\u001a\r"+
		"\u0000\"\u001c\u0001\u0000\u0000\u0000\"\u001d\u0001\u0000\u0000\u0000"+
		"\"\u001e\u0001\u0000\u0000\u0000\"\u001f\u0001\u0000\u0000\u0000\" \u0001"+
		"\u0000\u0000\u0000\"!\u0001\u0000\u0000\u0000#\u0001\u0001\u0000\u0000"+
		"\u0000$&\u0005\u0010\u0000\u0000%$\u0001\u0000\u0000\u0000&)\u0001\u0000"+
		"\u0000\u0000\'%\u0001\u0000\u0000\u0000\'(\u0001\u0000\u0000\u0000(+\u0001"+
		"\u0000\u0000\u0000)\'\u0001\u0000\u0000\u0000*,\u0003\u000e\u0007\u0000"+
		"+*\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000,-\u0001\u0000\u0000"+
		"\u0000-.\u0003\u0010\b\u0000.\u0003\u0001\u0000\u0000\u0000/1\u0005\u0010"+
		"\u0000\u00000/\u0001\u0000\u0000\u000014\u0001\u0000\u0000\u000020\u0001"+
		"\u0000\u0000\u000023\u0001\u0000\u0000\u000036\u0001\u0000\u0000\u0000"+
		"42\u0001\u0000\u0000\u000057\u0003\u000e\u0007\u000065\u0001\u0000\u0000"+
		"\u000067\u0001\u0000\u0000\u000078\u0001\u0000\u0000\u000089\u0003\f\u0006"+
		"\u00009\u0005\u0001\u0000\u0000\u0000:<\u0005\u0010\u0000\u0000;:\u0001"+
		"\u0000\u0000\u0000<?\u0001\u0000\u0000\u0000=;\u0001\u0000\u0000\u0000"+
		"=>\u0001\u0000\u0000\u0000>@\u0001\u0000\u0000\u0000?=\u0001\u0000\u0000"+
		"\u0000@A\u0003\u000e\u0007\u0000A\u0007\u0001\u0000\u0000\u0000BD\u0005"+
		"\u0005\u0000\u0000CB\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000\u0000"+
		"DL\u0001\u0000\u0000\u0000EG\u0005\u0010\u0000\u0000FE\u0001\u0000\u0000"+
		"\u0000GJ\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000HI\u0001\u0000"+
		"\u0000\u0000IL\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000\u0000KC\u0001"+
		"\u0000\u0000\u0000KH\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000"+
		"MN\u0003\u0016\u000b\u0000N\t\u0001\u0000\u0000\u0000OQ\u0005\u0005\u0000"+
		"\u0000PO\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000QY\u0001\u0000"+
		"\u0000\u0000RT\u0005\u0010\u0000\u0000SR\u0001\u0000\u0000\u0000TW\u0001"+
		"\u0000\u0000\u0000US\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000"+
		"VY\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000XP\u0001\u0000\u0000"+
		"\u0000XU\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Z[\u0005\u0006"+
		"\u0000\u0000[\\\u0003\u0012\t\u0000\\\u000b\u0001\u0000\u0000\u0000]_"+
		"\u0005\b\u0000\u0000^]\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000"+
		"`^\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000a\r\u0001\u0000\u0000"+
		"\u0000bd\u0005\u0007\u0000\u0000cb\u0001\u0000\u0000\u0000de\u0001\u0000"+
		"\u0000\u0000ec\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000f\u000f"+
		"\u0001\u0000\u0000\u0000gi\u0005\u0004\u0000\u0000hj\u0005\u0003\u0000"+
		"\u0000ih\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000jk\u0001\u0000"+
		"\u0000\u0000kn\u0003\u0010\b\u0000ln\u0001\u0000\u0000\u0000mg\u0001\u0000"+
		"\u0000\u0000ml\u0001\u0000\u0000\u0000n\u0011\u0001\u0000\u0000\u0000"+
		"oq\u0003\u0014\n\u0000po\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000"+
		"rp\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000s\u0013\u0001\u0000"+
		"\u0000\u0000tu\u0005\u0001\u0000\u0000uv\u0005\u0007\u0000\u0000vw\u0007"+
		"\u0000\u0000\u0000wx\u0007\u0000\u0000\u0000xy\u0005\u0002\u0000\u0000"+
		"y\u0081\u0005\u0001\u0000\u0000z{\u0005\u0001\u0000\u0000{|\u0005\u0007"+
		"\u0000\u0000|}\u0007\u0000\u0000\u0000}~\u0007\u0000\u0000\u0000~\u007f"+
		"\u0005\u0001\u0000\u0000\u007f\u0081\u0005\u0001\u0000\u0000\u0080t\u0001"+
		"\u0000\u0000\u0000\u0080z\u0001\u0000\u0000\u0000\u0081\u0015\u0001\u0000"+
		"\u0000\u0000\u0082\u0084\u0003\u0018\f\u0000\u0083\u0082\u0001\u0000\u0000"+
		"\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u0083\u0001\u0000\u0000"+
		"\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u0017\u0001\u0000\u0000"+
		"\u0000\u0087\u0088\u0005\u0001\u0000\u0000\u0088\u0089\u0005\u0007\u0000"+
		"\u0000\u0089\u008e\u0005\u0002\u0000\u0000\u008a\u008b\u0005\u0001\u0000"+
		"\u0000\u008b\u008c\u0005\u0007\u0000\u0000\u008c\u008e\u0005\u0001\u0000"+
		"\u0000\u008d\u0087\u0001\u0000\u0000\u0000\u008d\u008a\u0001\u0000\u0000"+
		"\u0000\u008e\u0019\u0001\u0000\u0000\u0000\u008f\u0090\u0005\r\u0000\u0000"+
		"\u0090\u0091\u0005\u000e\u0000\u0000\u0091\u0092\u0005\u000f\u0000\u0000"+
		"\u0092\u001b\u0001\u0000\u0000\u0000\u0014\"\'+26=CHKPUX`eimr\u0080\u0085"+
		"\u008d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}