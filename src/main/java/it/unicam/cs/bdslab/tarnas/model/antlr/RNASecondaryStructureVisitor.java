// Generated from D:/UNIVERSITA/paper_tarnas/TARNAS/src/main/java/it/unicam/cs/bdslab/tarnas/model/antlr/RNASecondaryStructure.g4 by ANTLR 4.13.2

package it.unicam.cs.bdslab.tarnas.model.antlr;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RNASecondaryStructureParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RNASecondaryStructureVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link RNASecondaryStructureParser#rna_format}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRna_format(RNASecondaryStructureParser.Rna_formatContext ctx);
	/**
	 * Visit a parse tree produced by {@link RNASecondaryStructureParser#aas}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAas(RNASecondaryStructureParser.AasContext ctx);
	/**
	 * Visit a parse tree produced by {@link RNASecondaryStructureParser#edbn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEdbn(RNASecondaryStructureParser.EdbnContext ctx);
	/**
	 * Visit a parse tree produced by {@link RNASecondaryStructureParser#fasta}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFasta(RNASecondaryStructureParser.FastaContext ctx);
	/**
	 * Visit a parse tree produced by {@link RNASecondaryStructureParser#bpseq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBpseq(RNASecondaryStructureParser.BpseqContext ctx);
	/**
	 * Visit a parse tree produced by {@link RNASecondaryStructureParser#ct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCt(RNASecondaryStructureParser.CtContext ctx);
	/**
	 * Visit a parse tree produced by {@link RNASecondaryStructureParser#edbn_structure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEdbn_structure(RNASecondaryStructureParser.Edbn_structureContext ctx);
	/**
	 * Visit a parse tree produced by {@link RNASecondaryStructureParser#sequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequence(RNASecondaryStructureParser.SequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link RNASecondaryStructureParser#bonds}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBonds(RNASecondaryStructureParser.BondsContext ctx);
	/**
	 * Visit a parse tree produced by {@link RNASecondaryStructureParser#ct_structure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCt_structure(RNASecondaryStructureParser.Ct_structureContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ctLineUnpaired}
	 * labeled alternative in {@link RNASecondaryStructureParser#ct_line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtLineUnpaired(RNASecondaryStructureParser.CtLineUnpairedContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ctLineBond}
	 * labeled alternative in {@link RNASecondaryStructureParser#ct_line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtLineBond(RNASecondaryStructureParser.CtLineBondContext ctx);
	/**
	 * Visit a parse tree produced by {@link RNASecondaryStructureParser#bpseq_structure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBpseq_structure(RNASecondaryStructureParser.Bpseq_structureContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bpseqLineUnpaired}
	 * labeled alternative in {@link RNASecondaryStructureParser#bpseq_line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBpseqLineUnpaired(RNASecondaryStructureParser.BpseqLineUnpairedContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bpseqLineBond}
	 * labeled alternative in {@link RNASecondaryStructureParser#bpseq_line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBpseqLineBond(RNASecondaryStructureParser.BpseqLineBondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rnamlContent}
	 * labeled alternative in {@link RNASecondaryStructureParser#rnaml}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRnamlContent(RNASecondaryStructureParser.RnamlContentContext ctx);
}