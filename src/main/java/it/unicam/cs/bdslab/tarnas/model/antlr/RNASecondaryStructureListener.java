// Generated from /Users/pierohierro/Desktop/university/paper_tarnas/TARNAS/src/main/java/it/unicam/cs/bdslab/tarnas/model/antlr/RNASecondaryStructure.g4 by ANTLR 4.13.2

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
	 * Enter a parse tree produced by {@link RNASecondaryStructureParser#rnaml}.
	 * @param ctx the parse tree
	 */
	void enterRnaml(RNASecondaryStructureParser.RnamlContext ctx);
	/**
	 * Exit a parse tree produced by {@link RNASecondaryStructureParser#rnaml}.
	 * @param ctx the parse tree
	 */
	void exitRnaml(RNASecondaryStructureParser.RnamlContext ctx);
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
	 * Enter a parse tree produced by {@link RNASecondaryStructureParser#molecule_structure}.
	 * @param ctx the parse tree
	 */
	void enterMolecule_structure(RNASecondaryStructureParser.Molecule_structureContext ctx);
	/**
	 * Exit a parse tree produced by {@link RNASecondaryStructureParser#molecule_structure}.
	 * @param ctx the parse tree
	 */
	void exitMolecule_structure(RNASecondaryStructureParser.Molecule_structureContext ctx);
	/**
	 * Enter a parse tree produced by {@link RNASecondaryStructureParser#molecule_body}.
	 * @param ctx the parse tree
	 */
	void enterMolecule_body(RNASecondaryStructureParser.Molecule_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link RNASecondaryStructureParser#molecule_body}.
	 * @param ctx the parse tree
	 */
	void exitMolecule_body(RNASecondaryStructureParser.Molecule_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link RNASecondaryStructureParser#sequence_rnaml}.
	 * @param ctx the parse tree
	 */
	void enterSequence_rnaml(RNASecondaryStructureParser.Sequence_rnamlContext ctx);
	/**
	 * Exit a parse tree produced by {@link RNASecondaryStructureParser#sequence_rnaml}.
	 * @param ctx the parse tree
	 */
	void exitSequence_rnaml(RNASecondaryStructureParser.Sequence_rnamlContext ctx);
	/**
	 * Enter a parse tree produced by {@link RNASecondaryStructureParser#sequence_data}.
	 * @param ctx the parse tree
	 */
	void enterSequence_data(RNASecondaryStructureParser.Sequence_dataContext ctx);
	/**
	 * Exit a parse tree produced by {@link RNASecondaryStructureParser#sequence_data}.
	 * @param ctx the parse tree
	 */
	void exitSequence_data(RNASecondaryStructureParser.Sequence_dataContext ctx);
	/**
	 * Enter a parse tree produced by {@link RNASecondaryStructureParser#structure_rnaml}.
	 * @param ctx the parse tree
	 */
	void enterStructure_rnaml(RNASecondaryStructureParser.Structure_rnamlContext ctx);
	/**
	 * Exit a parse tree produced by {@link RNASecondaryStructureParser#structure_rnaml}.
	 * @param ctx the parse tree
	 */
	void exitStructure_rnaml(RNASecondaryStructureParser.Structure_rnamlContext ctx);
	/**
	 * Enter a parse tree produced by {@link RNASecondaryStructureParser#base_pair}.
	 * @param ctx the parse tree
	 */
	void enterBase_pair(RNASecondaryStructureParser.Base_pairContext ctx);
	/**
	 * Exit a parse tree produced by {@link RNASecondaryStructureParser#base_pair}.
	 * @param ctx the parse tree
	 */
	void exitBase_pair(RNASecondaryStructureParser.Base_pairContext ctx);
	/**
	 * Enter a parse tree produced by {@link RNASecondaryStructureParser#base_id_5p}.
	 * @param ctx the parse tree
	 */
	void enterBase_id_5p(RNASecondaryStructureParser.Base_id_5pContext ctx);
	/**
	 * Exit a parse tree produced by {@link RNASecondaryStructureParser#base_id_5p}.
	 * @param ctx the parse tree
	 */
	void exitBase_id_5p(RNASecondaryStructureParser.Base_id_5pContext ctx);
	/**
	 * Enter a parse tree produced by {@link RNASecondaryStructureParser#base_id_3p}.
	 * @param ctx the parse tree
	 */
	void enterBase_id_3p(RNASecondaryStructureParser.Base_id_3pContext ctx);
	/**
	 * Exit a parse tree produced by {@link RNASecondaryStructureParser#base_id_3p}.
	 * @param ctx the parse tree
	 */
	void exitBase_id_3p(RNASecondaryStructureParser.Base_id_3pContext ctx);
	/**
	 * Enter a parse tree produced by {@link RNASecondaryStructureParser#edge_5p}.
	 * @param ctx the parse tree
	 */
	void enterEdge_5p(RNASecondaryStructureParser.Edge_5pContext ctx);
	/**
	 * Exit a parse tree produced by {@link RNASecondaryStructureParser#edge_5p}.
	 * @param ctx the parse tree
	 */
	void exitEdge_5p(RNASecondaryStructureParser.Edge_5pContext ctx);
	/**
	 * Enter a parse tree produced by {@link RNASecondaryStructureParser#edge_3p}.
	 * @param ctx the parse tree
	 */
	void enterEdge_3p(RNASecondaryStructureParser.Edge_3pContext ctx);
	/**
	 * Exit a parse tree produced by {@link RNASecondaryStructureParser#edge_3p}.
	 * @param ctx the parse tree
	 */
	void exitEdge_3p(RNASecondaryStructureParser.Edge_3pContext ctx);
	/**
	 * Enter a parse tree produced by {@link RNASecondaryStructureParser#bond_orientation}.
	 * @param ctx the parse tree
	 */
	void enterBond_orientation(RNASecondaryStructureParser.Bond_orientationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RNASecondaryStructureParser#bond_orientation}.
	 * @param ctx the parse tree
	 */
	void exitBond_orientation(RNASecondaryStructureParser.Bond_orientationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RNASecondaryStructureParser#interactions}.
	 * @param ctx the parse tree
	 */
	void enterInteractions(RNASecondaryStructureParser.InteractionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link RNASecondaryStructureParser#interactions}.
	 * @param ctx the parse tree
	 */
	void exitInteractions(RNASecondaryStructureParser.InteractionsContext ctx);
}