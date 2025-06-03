package it.unicam.cs.bdslab.tarnas.model.antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RNASecondaryStructureParser}.
 */
public interface RNASecondaryStructureListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RNASecondaryStructureParser#rna_format}.
	 * @param ctx the parse tree
	 */
	void enterRna_format(RNASecondaryStructureParser.Rna_formatContext ctx);
	/**
	 * Exit a parse tree produced by {@link RNASecondaryStructureParser#rna_format}.
	 * @param ctx the parse tree
	 */
	void exitRna_format(RNASecondaryStructureParser.Rna_formatContext ctx);
	/**
	 * Enter a parse tree produced by {@link RNASecondaryStructureParser#aas}.
	 * @param ctx the parse tree
	 */
	void enterAas(RNASecondaryStructureParser.AasContext ctx);
	/**
	 * Exit a parse tree produced by {@link RNASecondaryStructureParser#aas}.
	 * @param ctx the parse tree
	 */
	void exitAas(RNASecondaryStructureParser.AasContext ctx);
	/**
	 * Enter a parse tree produced by {@link RNASecondaryStructureParser#edbn}.
	 * @param ctx the parse tree
	 */
	void enterEdbn(RNASecondaryStructureParser.EdbnContext ctx);
	/**
	 * Exit a parse tree produced by {@link RNASecondaryStructureParser#edbn}.
	 * @param ctx the parse tree
	 */
	void exitEdbn(RNASecondaryStructureParser.EdbnContext ctx);
	/**
	 * Enter a parse tree produced by {@link RNASecondaryStructureParser#fasta}.
	 * @param ctx the parse tree
	 */
	void enterFasta(RNASecondaryStructureParser.FastaContext ctx);
	/**
	 * Exit a parse tree produced by {@link RNASecondaryStructureParser#fasta}.
	 * @param ctx the parse tree
	 */
	void exitFasta(RNASecondaryStructureParser.FastaContext ctx);
	/**
	 * Enter a parse tree produced by {@link RNASecondaryStructureParser#bpseq}.
	 * @param ctx the parse tree
	 */
	void enterBpseq(RNASecondaryStructureParser.BpseqContext ctx);
	/**
	 * Exit a parse tree produced by {@link RNASecondaryStructureParser#bpseq}.
	 * @param ctx the parse tree
	 */
	void exitBpseq(RNASecondaryStructureParser.BpseqContext ctx);
	/**
	 * Enter a parse tree produced by {@link RNASecondaryStructureParser#ct}.
	 * @param ctx the parse tree
	 */
	void enterCt(RNASecondaryStructureParser.CtContext ctx);
	/**
	 * Exit a parse tree produced by {@link RNASecondaryStructureParser#ct}.
	 * @param ctx the parse tree
	 */
	void exitCt(RNASecondaryStructureParser.CtContext ctx);
	/**
	 * Enter a parse tree produced by {@link RNASecondaryStructureParser#edbn_structure}.
	 * @param ctx the parse tree
	 */
	void enterEdbn_structure(RNASecondaryStructureParser.Edbn_structureContext ctx);
	/**
	 * Exit a parse tree produced by {@link RNASecondaryStructureParser#edbn_structure}.
	 * @param ctx the parse tree
	 */
	void exitEdbn_structure(RNASecondaryStructureParser.Edbn_structureContext ctx);
	/**
	 * Enter a parse tree produced by {@link RNASecondaryStructureParser#sequence}.
	 * @param ctx the parse tree
	 */
	void enterSequence(RNASecondaryStructureParser.SequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link RNASecondaryStructureParser#sequence}.
	 * @param ctx the parse tree
	 */
	void exitSequence(RNASecondaryStructureParser.SequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link RNASecondaryStructureParser#bonds}.
	 * @param ctx the parse tree
	 */
	void enterBonds(RNASecondaryStructureParser.BondsContext ctx);
	/**
	 * Exit a parse tree produced by {@link RNASecondaryStructureParser#bonds}.
	 * @param ctx the parse tree
	 */
	void exitBonds(RNASecondaryStructureParser.BondsContext ctx);
	/**
	 * Enter a parse tree produced by {@link RNASecondaryStructureParser#ct_structure}.
	 * @param ctx the parse tree
	 */
	void enterCt_structure(RNASecondaryStructureParser.Ct_structureContext ctx);
	/**
	 * Exit a parse tree produced by {@link RNASecondaryStructureParser#ct_structure}.
	 * @param ctx the parse tree
	 */
	void exitCt_structure(RNASecondaryStructureParser.Ct_structureContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ctLineUnpaired}
	 * labeled alternative in {@link RNASecondaryStructureParser#ct_line}.
	 * @param ctx the parse tree
	 */
	void enterCtLineUnpaired(RNASecondaryStructureParser.CtLineUnpairedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ctLineUnpaired}
	 * labeled alternative in {@link RNASecondaryStructureParser#ct_line}.
	 * @param ctx the parse tree
	 */
	void exitCtLineUnpaired(RNASecondaryStructureParser.CtLineUnpairedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ctLineBond}
	 * labeled alternative in {@link RNASecondaryStructureParser#ct_line}.
	 * @param ctx the parse tree
	 */
	void enterCtLineBond(RNASecondaryStructureParser.CtLineBondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ctLineBond}
	 * labeled alternative in {@link RNASecondaryStructureParser#ct_line}.
	 * @param ctx the parse tree
	 */
	void exitCtLineBond(RNASecondaryStructureParser.CtLineBondContext ctx);
	/**
	 * Enter a parse tree produced by {@link RNASecondaryStructureParser#bpseq_structure}.
	 * @param ctx the parse tree
	 */
	void enterBpseq_structure(RNASecondaryStructureParser.Bpseq_structureContext ctx);
	/**
	 * Exit a parse tree produced by {@link RNASecondaryStructureParser#bpseq_structure}.
	 * @param ctx the parse tree
	 */
	void exitBpseq_structure(RNASecondaryStructureParser.Bpseq_structureContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bpseqLineUnpaired}
	 * labeled alternative in {@link RNASecondaryStructureParser#bpseq_line}.
	 * @param ctx the parse tree
	 */
	void enterBpseqLineUnpaired(RNASecondaryStructureParser.BpseqLineUnpairedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bpseqLineUnpaired}
	 * labeled alternative in {@link RNASecondaryStructureParser#bpseq_line}.
	 * @param ctx the parse tree
	 */
	void exitBpseqLineUnpaired(RNASecondaryStructureParser.BpseqLineUnpairedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bpseqLineBond}
	 * labeled alternative in {@link RNASecondaryStructureParser#bpseq_line}.
	 * @param ctx the parse tree
	 */
	void enterBpseqLineBond(RNASecondaryStructureParser.BpseqLineBondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bpseqLineBond}
	 * labeled alternative in {@link RNASecondaryStructureParser#bpseq_line}.
	 * @param ctx the parse tree
	 */
	void exitBpseqLineBond(RNASecondaryStructureParser.BpseqLineBondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rnamlContent}
	 * labeled alternative in {@link RNASecondaryStructureParser#rnaml}.
	 * @param ctx the parse tree
	 */
	void enterRnamlContent(RNASecondaryStructureParser.RnamlContentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rnamlContent}
	 * labeled alternative in {@link RNASecondaryStructureParser#rnaml}.
	 * @param ctx the parse tree
	 */
	void exitRnamlContent(RNASecondaryStructureParser.RnamlContentContext ctx);
}