// Generated from /Users/pierohierro/Desktop/university/paper_tarnas/TARNAS/src/main/java/it/unicam/cs/bdslab/tarnas/model/antlr/RNASecondaryStructure.g4 by ANTLR 4.13.2

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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, INDEX=9, 
		XML_DECLARATION=10, DTD=11, RNAML_OPEN=12, RNAML_CLOSE=13, ZERO_INDEX=14, 
		SEP=15, BOND=16, BPSEQCTLINES=17, LINECT=18, NUCLEOTIDE=19, BASE_ID_5P_OPEN=20, 
		BASE_ID_OPEN=21, POSITION_OPEN=22, BASE_ID_5P_CLOSE=23, BASE_ID_CLOSE=24, 
		POSITION_CLOSE=25, BASE_ID_3P_OPEN=26, BASE_ID_3P_CLOSE=27, EDGE_5P_OPEN=28, 
		EDGE_5P_CLOSE=29, EDGE_3P_OPEN=30, EDGE_3P_CLOSE=31, BOND_ORIENTATION_OPEN=32, 
		BOND_ORIENTATION_CLOSE=33, INTERACTIONS_OPEN=34, INTERACTIONS_CLOSE=35, 
		STR_ANNOTATION_OPEN=36, STR_ANNOTATION_CLOSE=37, BASE_PAIR_OPEN=38, BASE_PAIR_CLOSE=39, 
		BASE_PAIR_OPEN_COMMENT=40, EDBN=41, LINE1BPSEQCT=42, LINE2BPSEQCT=43, 
		LINE3BPSEQCT=44, LINE4BPSEQCT=45, COMMENT=46, WS=47;
	public static final int
		RULE_rna_format = 0, RULE_aas = 1, RULE_edbn = 2, RULE_fasta = 3, RULE_bpseq = 4, 
		RULE_ct = 5, RULE_rnaml = 6, RULE_edbn_structure = 7, RULE_sequence = 8, 
		RULE_bonds = 9, RULE_ct_structure = 10, RULE_ct_line = 11, RULE_bpseq_structure = 12, 
		RULE_bpseq_line = 13, RULE_molecule_structure = 14, RULE_molecule_body = 15, 
		RULE_sequence_rnaml = 16, RULE_sequence_data = 17, RULE_structure_rnaml = 18, 
		RULE_base_pair = 19, RULE_base_id_5p = 20, RULE_base_id_3p = 21, RULE_edge_5p = 22, 
		RULE_edge_3p = 23, RULE_bond_orientation = 24, RULE_interactions = 25;
	private static String[] makeRuleNames() {
		return new String[] {
			"rna_format", "aas", "edbn", "fasta", "bpseq", "ct", "rnaml", "edbn_structure", 
			"sequence", "bonds", "ct_structure", "ct_line", "bpseq_structure", "bpseq_line", 
			"molecule_structure", "molecule_body", "sequence_rnaml", "sequence_data", 
			"structure_rnaml", "base_pair", "base_id_5p", "base_id_3p", "edge_5p", 
			"edge_3p", "bond_orientation", "interactions"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'<molecule id=\"1\">'", "'</molecule>'", "'<sequence>'", "'</sequence>'", 
			"'<seq-data>'", "'</seq-data>'", "'<structure>'", "'</structure>'", null, 
			null, null, null, "'</rnaml>'", "'0'", null, null, null, null, null, 
			"'<base-id-5p>'", "'<base-id>'", "'<position>'", "'</base-id-5p>'", "'</base-id>'", 
			"'</position>'", "'<base-id-3p>'", "'</base-id-3p>'", "'<edge-5p>'", 
			"'</edge-5p>'", "'<edge-3p>'", "'</edge-3p>'", "'<bond-orientation>'", 
			"'</bond-orientation>'", "'<interactions>'", "'</interactions>'", "'<str-annotation>'", 
			"'</str-annotation>'", "'<base-pair>'", "'</base-pair>'", "'<base-pair comment=\"?\">'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "INDEX", "XML_DECLARATION", 
			"DTD", "RNAML_OPEN", "RNAML_CLOSE", "ZERO_INDEX", "SEP", "BOND", "BPSEQCTLINES", 
			"LINECT", "NUCLEOTIDE", "BASE_ID_5P_OPEN", "BASE_ID_OPEN", "POSITION_OPEN", 
			"BASE_ID_5P_CLOSE", "BASE_ID_CLOSE", "POSITION_CLOSE", "BASE_ID_3P_OPEN", 
			"BASE_ID_3P_CLOSE", "EDGE_5P_OPEN", "EDGE_5P_CLOSE", "EDGE_3P_OPEN", 
			"EDGE_3P_CLOSE", "BOND_ORIENTATION_OPEN", "BOND_ORIENTATION_CLOSE", "INTERACTIONS_OPEN", 
			"INTERACTIONS_CLOSE", "STR_ANNOTATION_OPEN", "STR_ANNOTATION_CLOSE", 
			"BASE_PAIR_OPEN", "BASE_PAIR_CLOSE", "BASE_PAIR_OPEN_COMMENT", "EDBN", 
			"LINE1BPSEQCT", "LINE2BPSEQCT", "LINE3BPSEQCT", "LINE4BPSEQCT", "COMMENT", 
			"WS"
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
			setState(58);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(52);
				aas();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(53);
				ct();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(54);
				edbn();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(55);
				bpseq();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(56);
				fasta();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(57);
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
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMENT) {
				{
				{
				setState(60);
				match(COMMENT);
				}
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NUCLEOTIDE) {
				{
				setState(66);
				sequence();
				}
			}

			setState(70); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(69);
				bonds();
				}
				}
				setState(72); 
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
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMENT) {
				{
				{
				setState(74);
				match(COMMENT);
				}
				}
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NUCLEOTIDE) {
				{
				setState(80);
				sequence();
				}
			}

			setState(83);
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
			setState(91);
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
			setState(102);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(94);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BPSEQCTLINES) {
					{
					setState(93);
					match(BPSEQCTLINES);
					}
				}

				}
				break;
			case 2:
				{
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMENT) {
					{
					{
					setState(96);
					match(COMMENT);
					}
					}
					setState(101);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
			setState(104);
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
			setState(115);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BPSEQCTLINES) {
					{
					setState(106);
					match(BPSEQCTLINES);
					}
				}

				}
				break;
			case 2:
				{
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMENT) {
					{
					{
					setState(109);
					match(COMMENT);
					}
					}
					setState(114);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
			setState(117);
			match(LINECT);
			setState(118);
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
	public static class RnamlContext extends ParserRuleContext {
		public TerminalNode XML_DECLARATION() { return getToken(RNASecondaryStructureParser.XML_DECLARATION, 0); }
		public TerminalNode DTD() { return getToken(RNASecondaryStructureParser.DTD, 0); }
		public TerminalNode RNAML_OPEN() { return getToken(RNASecondaryStructureParser.RNAML_OPEN, 0); }
		public Molecule_structureContext molecule_structure() {
			return getRuleContext(Molecule_structureContext.class,0);
		}
		public TerminalNode RNAML_CLOSE() { return getToken(RNASecondaryStructureParser.RNAML_CLOSE, 0); }
		public InteractionsContext interactions() {
			return getRuleContext(InteractionsContext.class,0);
		}
		public RnamlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rnaml; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).enterRnaml(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).exitRnaml(this);
		}
	}

	public final RnamlContext rnaml() throws RecognitionException {
		RnamlContext _localctx = new RnamlContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_rnaml);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(XML_DECLARATION);
			setState(121);
			match(DTD);
			setState(122);
			match(RNAML_OPEN);
			setState(123);
			molecule_structure();
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INTERACTIONS_OPEN) {
				{
				setState(124);
				interactions();
				}
			}

			setState(127);
			match(RNAML_CLOSE);
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
		enterRule(_localctx, 14, RULE_edbn_structure);
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
				match(EDBN);
				}
				}
				setState(132); 
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
		enterRule(_localctx, 16, RULE_sequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(134);
				match(NUCLEOTIDE);
				}
				}
				setState(137); 
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
		enterRule(_localctx, 18, RULE_bonds);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(BOND);
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEP) {
				{
				setState(140);
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
		enterRule(_localctx, 20, RULE_ct_structure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(143);
				ct_line();
				}
				}
				setState(146); 
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
		enterRule(_localctx, 22, RULE_ct_line);
		int _la;
		try {
			setState(160);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				_localctx = new CtLineUnpairedContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(148);
				match(INDEX);
				setState(149);
				match(NUCLEOTIDE);
				setState(150);
				_la = _input.LA(1);
				if ( !(_la==INDEX || _la==ZERO_INDEX) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(151);
				_la = _input.LA(1);
				if ( !(_la==INDEX || _la==ZERO_INDEX) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(152);
				match(ZERO_INDEX);
				setState(153);
				match(INDEX);
				}
				break;
			case 2:
				_localctx = new CtLineBondContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(154);
				match(INDEX);
				setState(155);
				match(NUCLEOTIDE);
				setState(156);
				_la = _input.LA(1);
				if ( !(_la==INDEX || _la==ZERO_INDEX) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(157);
				_la = _input.LA(1);
				if ( !(_la==INDEX || _la==ZERO_INDEX) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(158);
				match(INDEX);
				setState(159);
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
		enterRule(_localctx, 24, RULE_bpseq_structure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(162);
				bpseq_line();
				}
				}
				setState(165); 
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
		enterRule(_localctx, 26, RULE_bpseq_line);
		try {
			setState(173);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				_localctx = new BpseqLineUnpairedContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(167);
				match(INDEX);
				setState(168);
				match(NUCLEOTIDE);
				setState(169);
				match(ZERO_INDEX);
				}
				break;
			case 2:
				_localctx = new BpseqLineBondContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(170);
				match(INDEX);
				setState(171);
				match(NUCLEOTIDE);
				setState(172);
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
	public static class Molecule_structureContext extends ParserRuleContext {
		public Molecule_bodyContext molecule_body() {
			return getRuleContext(Molecule_bodyContext.class,0);
		}
		public Molecule_structureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_molecule_structure; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).enterMolecule_structure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).exitMolecule_structure(this);
		}
	}

	public final Molecule_structureContext molecule_structure() throws RecognitionException {
		Molecule_structureContext _localctx = new Molecule_structureContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_molecule_structure);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(T__0);
			setState(176);
			molecule_body();
			setState(177);
			match(T__1);
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
	public static class Molecule_bodyContext extends ParserRuleContext {
		public Sequence_rnamlContext sequence_rnaml() {
			return getRuleContext(Sequence_rnamlContext.class,0);
		}
		public Structure_rnamlContext structure_rnaml() {
			return getRuleContext(Structure_rnamlContext.class,0);
		}
		public Molecule_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_molecule_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).enterMolecule_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).exitMolecule_body(this);
		}
	}

	public final Molecule_bodyContext molecule_body() throws RecognitionException {
		Molecule_bodyContext _localctx = new Molecule_bodyContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_molecule_body);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			sequence_rnaml();
			setState(180);
			structure_rnaml();
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
	public static class Sequence_rnamlContext extends ParserRuleContext {
		public Sequence_dataContext sequence_data() {
			return getRuleContext(Sequence_dataContext.class,0);
		}
		public Sequence_rnamlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequence_rnaml; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).enterSequence_rnaml(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).exitSequence_rnaml(this);
		}
	}

	public final Sequence_rnamlContext sequence_rnaml() throws RecognitionException {
		Sequence_rnamlContext _localctx = new Sequence_rnamlContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_sequence_rnaml);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			match(T__2);
			setState(186);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(183);
					matchWildcard();
					}
					} 
				}
				setState(188);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			setState(189);
			sequence_data();
			setState(193);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(190);
					matchWildcard();
					}
					} 
				}
				setState(195);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			setState(196);
			match(T__3);
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
	public static class Sequence_dataContext extends ParserRuleContext {
		public List<TerminalNode> NUCLEOTIDE() { return getTokens(RNASecondaryStructureParser.NUCLEOTIDE); }
		public TerminalNode NUCLEOTIDE(int i) {
			return getToken(RNASecondaryStructureParser.NUCLEOTIDE, i);
		}
		public Sequence_dataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequence_data; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).enterSequence_data(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).exitSequence_data(this);
		}
	}

	public final Sequence_dataContext sequence_data() throws RecognitionException {
		Sequence_dataContext _localctx = new Sequence_dataContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_sequence_data);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(T__4);
			setState(200); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(199);
				match(NUCLEOTIDE);
				}
				}
				setState(202); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUCLEOTIDE );
			setState(204);
			match(T__5);
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
	public static class Structure_rnamlContext extends ParserRuleContext {
		public List<Base_pairContext> base_pair() {
			return getRuleContexts(Base_pairContext.class);
		}
		public Base_pairContext base_pair(int i) {
			return getRuleContext(Base_pairContext.class,i);
		}
		public Structure_rnamlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structure_rnaml; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).enterStructure_rnaml(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).exitStructure_rnaml(this);
		}
	}

	public final Structure_rnamlContext structure_rnaml() throws RecognitionException {
		Structure_rnamlContext _localctx = new Structure_rnamlContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_structure_rnaml);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			match(T__6);
			setState(210);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(207);
					matchWildcard();
					}
					} 
				}
				setState(212);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			setState(214); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(213);
					base_pair();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(216); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(221);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(218);
					matchWildcard();
					}
					} 
				}
				setState(223);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			}
			setState(224);
			match(T__7);
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
	public static class Base_pairContext extends ParserRuleContext {
		public Base_id_5pContext base_id_5p() {
			return getRuleContext(Base_id_5pContext.class,0);
		}
		public Base_id_3pContext base_id_3p() {
			return getRuleContext(Base_id_3pContext.class,0);
		}
		public TerminalNode BASE_PAIR_CLOSE() { return getToken(RNASecondaryStructureParser.BASE_PAIR_CLOSE, 0); }
		public TerminalNode BASE_PAIR_OPEN() { return getToken(RNASecondaryStructureParser.BASE_PAIR_OPEN, 0); }
		public TerminalNode BASE_PAIR_OPEN_COMMENT() { return getToken(RNASecondaryStructureParser.BASE_PAIR_OPEN_COMMENT, 0); }
		public Edge_5pContext edge_5p() {
			return getRuleContext(Edge_5pContext.class,0);
		}
		public Edge_3pContext edge_3p() {
			return getRuleContext(Edge_3pContext.class,0);
		}
		public Bond_orientationContext bond_orientation() {
			return getRuleContext(Bond_orientationContext.class,0);
		}
		public Base_pairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_pair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).enterBase_pair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).exitBase_pair(this);
		}
	}

	public final Base_pairContext base_pair() throws RecognitionException {
		Base_pairContext _localctx = new Base_pairContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_base_pair);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			_la = _input.LA(1);
			if ( !(_la==BASE_PAIR_OPEN || _la==BASE_PAIR_OPEN_COMMENT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(227);
			base_id_5p();
			setState(228);
			base_id_3p();
			setState(230);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EDGE_5P_OPEN) {
				{
				setState(229);
				edge_5p();
				}
			}

			setState(233);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EDGE_3P_OPEN) {
				{
				setState(232);
				edge_3p();
				}
			}

			setState(236);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BOND_ORIENTATION_OPEN) {
				{
				setState(235);
				bond_orientation();
				}
			}

			setState(238);
			match(BASE_PAIR_CLOSE);
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
	public static class Base_id_5pContext extends ParserRuleContext {
		public TerminalNode BASE_ID_5P_OPEN() { return getToken(RNASecondaryStructureParser.BASE_ID_5P_OPEN, 0); }
		public TerminalNode BASE_ID_OPEN() { return getToken(RNASecondaryStructureParser.BASE_ID_OPEN, 0); }
		public TerminalNode POSITION_OPEN() { return getToken(RNASecondaryStructureParser.POSITION_OPEN, 0); }
		public TerminalNode INDEX() { return getToken(RNASecondaryStructureParser.INDEX, 0); }
		public TerminalNode POSITION_CLOSE() { return getToken(RNASecondaryStructureParser.POSITION_CLOSE, 0); }
		public TerminalNode BASE_ID_CLOSE() { return getToken(RNASecondaryStructureParser.BASE_ID_CLOSE, 0); }
		public TerminalNode BASE_ID_5P_CLOSE() { return getToken(RNASecondaryStructureParser.BASE_ID_5P_CLOSE, 0); }
		public Base_id_5pContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_id_5p; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).enterBase_id_5p(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).exitBase_id_5p(this);
		}
	}

	public final Base_id_5pContext base_id_5p() throws RecognitionException {
		Base_id_5pContext _localctx = new Base_id_5pContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_base_id_5p);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			match(BASE_ID_5P_OPEN);
			setState(241);
			match(BASE_ID_OPEN);
			setState(242);
			match(POSITION_OPEN);
			setState(243);
			match(INDEX);
			setState(244);
			match(POSITION_CLOSE);
			setState(245);
			match(BASE_ID_CLOSE);
			setState(246);
			match(BASE_ID_5P_CLOSE);
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
	public static class Base_id_3pContext extends ParserRuleContext {
		public TerminalNode BASE_ID_3P_OPEN() { return getToken(RNASecondaryStructureParser.BASE_ID_3P_OPEN, 0); }
		public TerminalNode BASE_ID_OPEN() { return getToken(RNASecondaryStructureParser.BASE_ID_OPEN, 0); }
		public TerminalNode POSITION_OPEN() { return getToken(RNASecondaryStructureParser.POSITION_OPEN, 0); }
		public TerminalNode INDEX() { return getToken(RNASecondaryStructureParser.INDEX, 0); }
		public TerminalNode POSITION_CLOSE() { return getToken(RNASecondaryStructureParser.POSITION_CLOSE, 0); }
		public TerminalNode BASE_ID_CLOSE() { return getToken(RNASecondaryStructureParser.BASE_ID_CLOSE, 0); }
		public TerminalNode BASE_ID_3P_CLOSE() { return getToken(RNASecondaryStructureParser.BASE_ID_3P_CLOSE, 0); }
		public Base_id_3pContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_id_3p; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).enterBase_id_3p(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).exitBase_id_3p(this);
		}
	}

	public final Base_id_3pContext base_id_3p() throws RecognitionException {
		Base_id_3pContext _localctx = new Base_id_3pContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_base_id_3p);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			match(BASE_ID_3P_OPEN);
			setState(249);
			match(BASE_ID_OPEN);
			setState(250);
			match(POSITION_OPEN);
			setState(251);
			match(INDEX);
			setState(252);
			match(POSITION_CLOSE);
			setState(253);
			match(BASE_ID_CLOSE);
			setState(254);
			match(BASE_ID_3P_CLOSE);
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
	public static class Edge_5pContext extends ParserRuleContext {
		public TerminalNode EDGE_5P_OPEN() { return getToken(RNASecondaryStructureParser.EDGE_5P_OPEN, 0); }
		public TerminalNode NUCLEOTIDE() { return getToken(RNASecondaryStructureParser.NUCLEOTIDE, 0); }
		public TerminalNode EDGE_5P_CLOSE() { return getToken(RNASecondaryStructureParser.EDGE_5P_CLOSE, 0); }
		public Edge_5pContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_edge_5p; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).enterEdge_5p(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).exitEdge_5p(this);
		}
	}

	public final Edge_5pContext edge_5p() throws RecognitionException {
		Edge_5pContext _localctx = new Edge_5pContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_edge_5p);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			match(EDGE_5P_OPEN);
			setState(257);
			match(NUCLEOTIDE);
			setState(258);
			match(EDGE_5P_CLOSE);
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
	public static class Edge_3pContext extends ParserRuleContext {
		public TerminalNode EDGE_3P_OPEN() { return getToken(RNASecondaryStructureParser.EDGE_3P_OPEN, 0); }
		public TerminalNode NUCLEOTIDE() { return getToken(RNASecondaryStructureParser.NUCLEOTIDE, 0); }
		public TerminalNode EDGE_3P_CLOSE() { return getToken(RNASecondaryStructureParser.EDGE_3P_CLOSE, 0); }
		public Edge_3pContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_edge_3p; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).enterEdge_3p(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).exitEdge_3p(this);
		}
	}

	public final Edge_3pContext edge_3p() throws RecognitionException {
		Edge_3pContext _localctx = new Edge_3pContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_edge_3p);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			match(EDGE_3P_OPEN);
			setState(261);
			match(NUCLEOTIDE);
			setState(262);
			match(EDGE_3P_CLOSE);
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
	public static class Bond_orientationContext extends ParserRuleContext {
		public TerminalNode BOND_ORIENTATION_OPEN() { return getToken(RNASecondaryStructureParser.BOND_ORIENTATION_OPEN, 0); }
		public TerminalNode NUCLEOTIDE() { return getToken(RNASecondaryStructureParser.NUCLEOTIDE, 0); }
		public TerminalNode BOND_ORIENTATION_CLOSE() { return getToken(RNASecondaryStructureParser.BOND_ORIENTATION_CLOSE, 0); }
		public Bond_orientationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bond_orientation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).enterBond_orientation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).exitBond_orientation(this);
		}
	}

	public final Bond_orientationContext bond_orientation() throws RecognitionException {
		Bond_orientationContext _localctx = new Bond_orientationContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_bond_orientation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			match(BOND_ORIENTATION_OPEN);
			setState(265);
			match(NUCLEOTIDE);
			setState(266);
			match(BOND_ORIENTATION_CLOSE);
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
	public static class InteractionsContext extends ParserRuleContext {
		public TerminalNode INTERACTIONS_OPEN() { return getToken(RNASecondaryStructureParser.INTERACTIONS_OPEN, 0); }
		public TerminalNode STR_ANNOTATION_OPEN() { return getToken(RNASecondaryStructureParser.STR_ANNOTATION_OPEN, 0); }
		public TerminalNode STR_ANNOTATION_CLOSE() { return getToken(RNASecondaryStructureParser.STR_ANNOTATION_CLOSE, 0); }
		public TerminalNode INTERACTIONS_CLOSE() { return getToken(RNASecondaryStructureParser.INTERACTIONS_CLOSE, 0); }
		public InteractionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interactions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).enterInteractions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RNASecondaryStructureListener ) ((RNASecondaryStructureListener)listener).exitInteractions(this);
		}
	}

	public final InteractionsContext interactions() throws RecognitionException {
		InteractionsContext _localctx = new InteractionsContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_interactions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			match(INTERACTIONS_OPEN);
			setState(269);
			match(STR_ANNOTATION_OPEN);
			setState(270);
			match(STR_ANNOTATION_CLOSE);
			setState(271);
			match(INTERACTIONS_CLOSE);
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
		"\u0004\u0001/\u0112\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0003\u0000;\b\u0000\u0001\u0001\u0005\u0001"+
		">\b\u0001\n\u0001\f\u0001A\t\u0001\u0001\u0001\u0003\u0001D\b\u0001\u0001"+
		"\u0001\u0004\u0001G\b\u0001\u000b\u0001\f\u0001H\u0001\u0002\u0005\u0002"+
		"L\b\u0002\n\u0002\f\u0002O\t\u0002\u0001\u0002\u0003\u0002R\b\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0005\u0003W\b\u0003\n\u0003\f\u0003Z\t"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0003\u0004_\b\u0004\u0001"+
		"\u0004\u0005\u0004b\b\u0004\n\u0004\f\u0004e\t\u0004\u0003\u0004g\b\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0003\u0005l\b\u0005\u0001\u0005"+
		"\u0005\u0005o\b\u0005\n\u0005\f\u0005r\t\u0005\u0003\u0005t\b\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0003\u0006~\b\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0004\u0007\u0083\b\u0007\u000b\u0007\f\u0007\u0084\u0001\b\u0004"+
		"\b\u0088\b\b\u000b\b\f\b\u0089\u0001\t\u0001\t\u0003\t\u008e\b\t\u0001"+
		"\n\u0004\n\u0091\b\n\u000b\n\f\n\u0092\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00a1\b\u000b\u0001\f"+
		"\u0004\f\u00a4\b\f\u000b\f\f\f\u00a5\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0003\r\u00ae\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0005"+
		"\u0010\u00b9\b\u0010\n\u0010\f\u0010\u00bc\t\u0010\u0001\u0010\u0001\u0010"+
		"\u0005\u0010\u00c0\b\u0010\n\u0010\f\u0010\u00c3\t\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0011\u0001\u0011\u0004\u0011\u00c9\b\u0011\u000b\u0011\f"+
		"\u0011\u00ca\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0005\u0012"+
		"\u00d1\b\u0012\n\u0012\f\u0012\u00d4\t\u0012\u0001\u0012\u0004\u0012\u00d7"+
		"\b\u0012\u000b\u0012\f\u0012\u00d8\u0001\u0012\u0005\u0012\u00dc\b\u0012"+
		"\n\u0012\f\u0012\u00df\t\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u00e7\b\u0013\u0001\u0013\u0003"+
		"\u0013\u00ea\b\u0013\u0001\u0013\u0003\u0013\u00ed\b\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0004\u00ba"+
		"\u00c1\u00d2\u00dd\u0000\u001a\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02\u0000\u0002\u0002"+
		"\u0000\t\t\u000e\u000e\u0002\u0000&&((\u0119\u0000:\u0001\u0000\u0000"+
		"\u0000\u0002?\u0001\u0000\u0000\u0000\u0004M\u0001\u0000\u0000\u0000\u0006"+
		"X\u0001\u0000\u0000\u0000\bf\u0001\u0000\u0000\u0000\ns\u0001\u0000\u0000"+
		"\u0000\fx\u0001\u0000\u0000\u0000\u000e\u0082\u0001\u0000\u0000\u0000"+
		"\u0010\u0087\u0001\u0000\u0000\u0000\u0012\u008b\u0001\u0000\u0000\u0000"+
		"\u0014\u0090\u0001\u0000\u0000\u0000\u0016\u00a0\u0001\u0000\u0000\u0000"+
		"\u0018\u00a3\u0001\u0000\u0000\u0000\u001a\u00ad\u0001\u0000\u0000\u0000"+
		"\u001c\u00af\u0001\u0000\u0000\u0000\u001e\u00b3\u0001\u0000\u0000\u0000"+
		" \u00b6\u0001\u0000\u0000\u0000\"\u00c6\u0001\u0000\u0000\u0000$\u00ce"+
		"\u0001\u0000\u0000\u0000&\u00e2\u0001\u0000\u0000\u0000(\u00f0\u0001\u0000"+
		"\u0000\u0000*\u00f8\u0001\u0000\u0000\u0000,\u0100\u0001\u0000\u0000\u0000"+
		".\u0104\u0001\u0000\u0000\u00000\u0108\u0001\u0000\u0000\u00002\u010c"+
		"\u0001\u0000\u0000\u00004;\u0003\u0002\u0001\u00005;\u0003\n\u0005\u0000"+
		"6;\u0003\u0004\u0002\u00007;\u0003\b\u0004\u00008;\u0003\u0006\u0003\u0000"+
		"9;\u0003\f\u0006\u0000:4\u0001\u0000\u0000\u0000:5\u0001\u0000\u0000\u0000"+
		":6\u0001\u0000\u0000\u0000:7\u0001\u0000\u0000\u0000:8\u0001\u0000\u0000"+
		"\u0000:9\u0001\u0000\u0000\u0000;\u0001\u0001\u0000\u0000\u0000<>\u0005"+
		".\u0000\u0000=<\u0001\u0000\u0000\u0000>A\u0001\u0000\u0000\u0000?=\u0001"+
		"\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000@C\u0001\u0000\u0000\u0000"+
		"A?\u0001\u0000\u0000\u0000BD\u0003\u0010\b\u0000CB\u0001\u0000\u0000\u0000"+
		"CD\u0001\u0000\u0000\u0000DF\u0001\u0000\u0000\u0000EG\u0003\u0012\t\u0000"+
		"FE\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000"+
		"\u0000HI\u0001\u0000\u0000\u0000I\u0003\u0001\u0000\u0000\u0000JL\u0005"+
		".\u0000\u0000KJ\u0001\u0000\u0000\u0000LO\u0001\u0000\u0000\u0000MK\u0001"+
		"\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000NQ\u0001\u0000\u0000\u0000"+
		"OM\u0001\u0000\u0000\u0000PR\u0003\u0010\b\u0000QP\u0001\u0000\u0000\u0000"+
		"QR\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000ST\u0003\u000e\u0007"+
		"\u0000T\u0005\u0001\u0000\u0000\u0000UW\u0005.\u0000\u0000VU\u0001\u0000"+
		"\u0000\u0000WZ\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000XY\u0001"+
		"\u0000\u0000\u0000Y[\u0001\u0000\u0000\u0000ZX\u0001\u0000\u0000\u0000"+
		"[\\\u0003\u0010\b\u0000\\\u0007\u0001\u0000\u0000\u0000]_\u0005\u0011"+
		"\u0000\u0000^]\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_g\u0001"+
		"\u0000\u0000\u0000`b\u0005.\u0000\u0000a`\u0001\u0000\u0000\u0000be\u0001"+
		"\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000"+
		"dg\u0001\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000f^\u0001\u0000\u0000"+
		"\u0000fc\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000hi\u0003\u0018"+
		"\f\u0000i\t\u0001\u0000\u0000\u0000jl\u0005\u0011\u0000\u0000kj\u0001"+
		"\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000lt\u0001\u0000\u0000\u0000"+
		"mo\u0005.\u0000\u0000nm\u0001\u0000\u0000\u0000or\u0001\u0000\u0000\u0000"+
		"pn\u0001\u0000\u0000\u0000pq\u0001\u0000\u0000\u0000qt\u0001\u0000\u0000"+
		"\u0000rp\u0001\u0000\u0000\u0000sk\u0001\u0000\u0000\u0000sp\u0001\u0000"+
		"\u0000\u0000tu\u0001\u0000\u0000\u0000uv\u0005\u0012\u0000\u0000vw\u0003"+
		"\u0014\n\u0000w\u000b\u0001\u0000\u0000\u0000xy\u0005\n\u0000\u0000yz"+
		"\u0005\u000b\u0000\u0000z{\u0005\f\u0000\u0000{}\u0003\u001c\u000e\u0000"+
		"|~\u00032\u0019\u0000}|\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000"+
		"~\u007f\u0001\u0000\u0000\u0000\u007f\u0080\u0005\r\u0000\u0000\u0080"+
		"\r\u0001\u0000\u0000\u0000\u0081\u0083\u0005)\u0000\u0000\u0082\u0081"+
		"\u0001\u0000\u0000\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0084\u0082"+
		"\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u000f"+
		"\u0001\u0000\u0000\u0000\u0086\u0088\u0005\u0013\u0000\u0000\u0087\u0086"+
		"\u0001\u0000\u0000\u0000\u0088\u0089\u0001\u0000\u0000\u0000\u0089\u0087"+
		"\u0001\u0000\u0000\u0000\u0089\u008a\u0001\u0000\u0000\u0000\u008a\u0011"+
		"\u0001\u0000\u0000\u0000\u008b\u008d\u0005\u0010\u0000\u0000\u008c\u008e"+
		"\u0005\u000f\u0000\u0000\u008d\u008c\u0001\u0000\u0000\u0000\u008d\u008e"+
		"\u0001\u0000\u0000\u0000\u008e\u0013\u0001\u0000\u0000\u0000\u008f\u0091"+
		"\u0003\u0016\u000b\u0000\u0090\u008f\u0001\u0000\u0000\u0000\u0091\u0092"+
		"\u0001\u0000\u0000\u0000\u0092\u0090\u0001\u0000\u0000\u0000\u0092\u0093"+
		"\u0001\u0000\u0000\u0000\u0093\u0015\u0001\u0000\u0000\u0000\u0094\u0095"+
		"\u0005\t\u0000\u0000\u0095\u0096\u0005\u0013\u0000\u0000\u0096\u0097\u0007"+
		"\u0000\u0000\u0000\u0097\u0098\u0007\u0000\u0000\u0000\u0098\u0099\u0005"+
		"\u000e\u0000\u0000\u0099\u00a1\u0005\t\u0000\u0000\u009a\u009b\u0005\t"+
		"\u0000\u0000\u009b\u009c\u0005\u0013\u0000\u0000\u009c\u009d\u0007\u0000"+
		"\u0000\u0000\u009d\u009e\u0007\u0000\u0000\u0000\u009e\u009f\u0005\t\u0000"+
		"\u0000\u009f\u00a1\u0005\t\u0000\u0000\u00a0\u0094\u0001\u0000\u0000\u0000"+
		"\u00a0\u009a\u0001\u0000\u0000\u0000\u00a1\u0017\u0001\u0000\u0000\u0000"+
		"\u00a2\u00a4\u0003\u001a\r\u0000\u00a3\u00a2\u0001\u0000\u0000\u0000\u00a4"+
		"\u00a5\u0001\u0000\u0000\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a5"+
		"\u00a6\u0001\u0000\u0000\u0000\u00a6\u0019\u0001\u0000\u0000\u0000\u00a7"+
		"\u00a8\u0005\t\u0000\u0000\u00a8\u00a9\u0005\u0013\u0000\u0000\u00a9\u00ae"+
		"\u0005\u000e\u0000\u0000\u00aa\u00ab\u0005\t\u0000\u0000\u00ab\u00ac\u0005"+
		"\u0013\u0000\u0000\u00ac\u00ae\u0005\t\u0000\u0000\u00ad\u00a7\u0001\u0000"+
		"\u0000\u0000\u00ad\u00aa\u0001\u0000\u0000\u0000\u00ae\u001b\u0001\u0000"+
		"\u0000\u0000\u00af\u00b0\u0005\u0001\u0000\u0000\u00b0\u00b1\u0003\u001e"+
		"\u000f\u0000\u00b1\u00b2\u0005\u0002\u0000\u0000\u00b2\u001d\u0001\u0000"+
		"\u0000\u0000\u00b3\u00b4\u0003 \u0010\u0000\u00b4\u00b5\u0003$\u0012\u0000"+
		"\u00b5\u001f\u0001\u0000\u0000\u0000\u00b6\u00ba\u0005\u0003\u0000\u0000"+
		"\u00b7\u00b9\t\u0000\u0000\u0000\u00b8\u00b7\u0001\u0000\u0000\u0000\u00b9"+
		"\u00bc\u0001\u0000\u0000\u0000\u00ba\u00bb\u0001\u0000\u0000\u0000\u00ba"+
		"\u00b8\u0001\u0000\u0000\u0000\u00bb\u00bd\u0001\u0000\u0000\u0000\u00bc"+
		"\u00ba\u0001\u0000\u0000\u0000\u00bd\u00c1\u0003\"\u0011\u0000\u00be\u00c0"+
		"\t\u0000\u0000\u0000\u00bf\u00be\u0001\u0000\u0000\u0000\u00c0\u00c3\u0001"+
		"\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000\u0000\u0000\u00c1\u00bf\u0001"+
		"\u0000\u0000\u0000\u00c2\u00c4\u0001\u0000\u0000\u0000\u00c3\u00c1\u0001"+
		"\u0000\u0000\u0000\u00c4\u00c5\u0005\u0004\u0000\u0000\u00c5!\u0001\u0000"+
		"\u0000\u0000\u00c6\u00c8\u0005\u0005\u0000\u0000\u00c7\u00c9\u0005\u0013"+
		"\u0000\u0000\u00c8\u00c7\u0001\u0000\u0000\u0000\u00c9\u00ca\u0001\u0000"+
		"\u0000\u0000\u00ca\u00c8\u0001\u0000\u0000\u0000\u00ca\u00cb\u0001\u0000"+
		"\u0000\u0000\u00cb\u00cc\u0001\u0000\u0000\u0000\u00cc\u00cd\u0005\u0006"+
		"\u0000\u0000\u00cd#\u0001\u0000\u0000\u0000\u00ce\u00d2\u0005\u0007\u0000"+
		"\u0000\u00cf\u00d1\t\u0000\u0000\u0000\u00d0\u00cf\u0001\u0000\u0000\u0000"+
		"\u00d1\u00d4\u0001\u0000\u0000\u0000\u00d2\u00d3\u0001\u0000\u0000\u0000"+
		"\u00d2\u00d0\u0001\u0000\u0000\u0000\u00d3\u00d6\u0001\u0000\u0000\u0000"+
		"\u00d4\u00d2\u0001\u0000\u0000\u0000\u00d5\u00d7\u0003&\u0013\u0000\u00d6"+
		"\u00d5\u0001\u0000\u0000\u0000\u00d7\u00d8\u0001\u0000\u0000\u0000\u00d8"+
		"\u00d6\u0001\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000\u0000\u00d9"+
		"\u00dd\u0001\u0000\u0000\u0000\u00da\u00dc\t\u0000\u0000\u0000\u00db\u00da"+
		"\u0001\u0000\u0000\u0000\u00dc\u00df\u0001\u0000\u0000\u0000\u00dd\u00de"+
		"\u0001\u0000\u0000\u0000\u00dd\u00db\u0001\u0000\u0000\u0000\u00de\u00e0"+
		"\u0001\u0000\u0000\u0000\u00df\u00dd\u0001\u0000\u0000\u0000\u00e0\u00e1"+
		"\u0005\b\u0000\u0000\u00e1%\u0001\u0000\u0000\u0000\u00e2\u00e3\u0007"+
		"\u0001\u0000\u0000\u00e3\u00e4\u0003(\u0014\u0000\u00e4\u00e6\u0003*\u0015"+
		"\u0000\u00e5\u00e7\u0003,\u0016\u0000\u00e6\u00e5\u0001\u0000\u0000\u0000"+
		"\u00e6\u00e7\u0001\u0000\u0000\u0000\u00e7\u00e9\u0001\u0000\u0000\u0000"+
		"\u00e8\u00ea\u0003.\u0017\u0000\u00e9\u00e8\u0001\u0000\u0000\u0000\u00e9"+
		"\u00ea\u0001\u0000\u0000\u0000\u00ea\u00ec\u0001\u0000\u0000\u0000\u00eb"+
		"\u00ed\u00030\u0018\u0000\u00ec\u00eb\u0001\u0000\u0000\u0000\u00ec\u00ed"+
		"\u0001\u0000\u0000\u0000\u00ed\u00ee\u0001\u0000\u0000\u0000\u00ee\u00ef"+
		"\u0005\'\u0000\u0000\u00ef\'\u0001\u0000\u0000\u0000\u00f0\u00f1\u0005"+
		"\u0014\u0000\u0000\u00f1\u00f2\u0005\u0015\u0000\u0000\u00f2\u00f3\u0005"+
		"\u0016\u0000\u0000\u00f3\u00f4\u0005\t\u0000\u0000\u00f4\u00f5\u0005\u0019"+
		"\u0000\u0000\u00f5\u00f6\u0005\u0018\u0000\u0000\u00f6\u00f7\u0005\u0017"+
		"\u0000\u0000\u00f7)\u0001\u0000\u0000\u0000\u00f8\u00f9\u0005\u001a\u0000"+
		"\u0000\u00f9\u00fa\u0005\u0015\u0000\u0000\u00fa\u00fb\u0005\u0016\u0000"+
		"\u0000\u00fb\u00fc\u0005\t\u0000\u0000\u00fc\u00fd\u0005\u0019\u0000\u0000"+
		"\u00fd\u00fe\u0005\u0018\u0000\u0000\u00fe\u00ff\u0005\u001b\u0000\u0000"+
		"\u00ff+\u0001\u0000\u0000\u0000\u0100\u0101\u0005\u001c\u0000\u0000\u0101"+
		"\u0102\u0005\u0013\u0000\u0000\u0102\u0103\u0005\u001d\u0000\u0000\u0103"+
		"-\u0001\u0000\u0000\u0000\u0104\u0105\u0005\u001e\u0000\u0000\u0105\u0106"+
		"\u0005\u0013\u0000\u0000\u0106\u0107\u0005\u001f\u0000\u0000\u0107/\u0001"+
		"\u0000\u0000\u0000\u0108\u0109\u0005 \u0000\u0000\u0109\u010a\u0005\u0013"+
		"\u0000\u0000\u010a\u010b\u0005!\u0000\u0000\u010b1\u0001\u0000\u0000\u0000"+
		"\u010c\u010d\u0005\"\u0000\u0000\u010d\u010e\u0005$\u0000\u0000\u010e"+
		"\u010f\u0005%\u0000\u0000\u010f\u0110\u0005#\u0000\u0000\u01103\u0001"+
		"\u0000\u0000\u0000\u001e:?CHMQX^cfkps}\u0084\u0089\u008d\u0092\u00a0\u00a5"+
		"\u00ad\u00ba\u00c1\u00ca\u00d2\u00d8\u00dd\u00e6\u00e9\u00ec";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}