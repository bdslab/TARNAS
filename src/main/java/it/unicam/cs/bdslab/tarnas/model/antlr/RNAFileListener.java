package it.unicam.cs.bdslab.tarnas.model.antlr;


import it.unicam.cs.bdslab.tarnas.model.rnafile.RNAFile;
import it.unicam.cs.bdslab.tarnas.model.rnafile.RNAFormat;
import it.unicam.cs.bdslab.tarnas.model.rnafile.RNAInputFileParserException;
import it.unicam.cs.bdslab.tarnas.model.rnastructure.NonCanonicalEdgeFamily;
import it.unicam.cs.bdslab.tarnas.model.rnastructure.NonCanonicalEdgeFamilyValues;
import it.unicam.cs.bdslab.tarnas.model.rnastructure.RNASecondaryStructure;
import it.unicam.cs.bdslab.tarnas.model.rnastructure.WeakBond;
import org.antlr.v4.runtime.tree.ParseTree;
import org.jsoup.Jsoup;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

import static it.unicam.cs.bdslab.tarnas.model.rnafile.RNAFormat.DB;
import static it.unicam.cs.bdslab.tarnas.model.rnafile.RNAFormat.RNAML;

public class RNAFileListener extends RNASecondaryStructureBaseListener {
    private RNAFile rnaFile;
    private RNASecondaryStructure s;
    private StringBuffer sequenceBuffer;
    private StringBuffer edbnsBuffer;
    private List<String> header;
    private String fileName;
    private List<String> content;

    public RNAFileListener() {

    }

    public void setFilePath(Path filePath) throws IOException {
        this.content = Files.readAllLines(filePath);
        this.s = new RNASecondaryStructure();
        this.sequenceBuffer = new StringBuffer();
        this.edbnsBuffer = new StringBuffer();
        this.header = new ArrayList<>();
        this.fileName = String.valueOf(filePath.getFileName());
    }

    public RNAFile getRnaFile() {
        var rnaFile = this.rnaFile;
        this.clearDataStructures();
        return rnaFile;
    }

    private void clearDataStructures() {
        this.rnaFile = null;
        this.s = null;
        this.sequenceBuffer = null;
        this.edbnsBuffer = null;
        this.header = null;
        this.fileName = null;
        this.content = null;
    }

    //BPSEQ
    @Override
    public void enterBpseq(RNASecondaryStructureParser.BpseqContext ctx) {
        if (ctx.COMMENT() != null) ctx.COMMENT().forEach(line -> this.header.add(line.getText().trim()));
        if (ctx.BPSEQCTLINES() != null)
            this.header.addAll(Arrays.stream(ctx.BPSEQCTLINES().getText().split("\n")).map(String::trim).toList());
        if (this.s.getSize() == -1) {
            this.s.setSequence("");
            this.s.setSize(0);
        }
    }

    @Override
    public void enterBpseqLineUnpaired(RNASecondaryStructureParser.BpseqLineUnpairedContext ctx) {
        // add the current nucleotide to the sequence
        this.sequenceBuffer.append(ctx.NUCLEOTIDE().getText().trim());
    }

    @Override
    public void enterBpseqLineBond(RNASecondaryStructureParser.BpseqLineBondContext ctx) {
        // add the current nucleotide to the sequence
        this.sequenceBuffer.append(ctx.NUCLEOTIDE().getText().trim());
        // determines the indexes of this bond
        int left = Integer.parseInt(ctx.INDEX(0).getText());
        int right = Integer.parseInt(ctx.INDEX(1).getText());
        if (left < right) {
            // only add the bond once, when it is first introduced
            this.s.addBond(new WeakBond(left, right));
        }
    }

    @Override
    public void exitBpseq(RNASecondaryStructureParser.BpseqContext ctx) {
        // create body
        var body = this.content.subList(this.header.size(), this.content.size());
        // assign the whole sequence to the RNASecondaryStructure
        this.s.setSequence(this.sequenceBuffer.toString());
        // set the size of the structure to the length of the sequence
        this.s.setSize(this.s.getSequence().length());
        // everything has been added to the structure, finalise it
        this.s.finalise();
        // create rnafile object with unnecessary empty body
        this.rnaFile = new RNAFile(this.fileName, this.header, body, this.s, RNAFormat.BPSEQ);
    }
    //CT

    @Override
    public void enterCt(RNASecondaryStructureParser.CtContext ctx) {
        if (ctx.COMMENT() != null) ctx.COMMENT().forEach(line -> this.header.add(line.getText().trim()));
        if (ctx.BPSEQCTLINES() != null)
            this.header.addAll(Arrays.stream(ctx.BPSEQCTLINES().getText().split("\n")).map(String::trim).toList());
        if (this.s.getSize() == -1) {
            this.s.setSequence("");
            this.s.setSize(0);
        }
    }

    @Override
    public void enterCtLineUnpaired(RNASecondaryStructureParser.CtLineUnpairedContext ctx) {
        // add the current nucleotide to the sequence
        this.sequenceBuffer.append(ctx.NUCLEOTIDE().getText().trim());
    }

    @Override
    public void enterCtLineBond(RNASecondaryStructureParser.CtLineBondContext ctx) {
        // add the current nucleotide to the sequence
        this.sequenceBuffer.append(ctx.NUCLEOTIDE().getText().trim());
        // determines the indexes of this bond
        int left = Integer.parseInt(ctx.INDEX(0).getText());
        int right = Integer.parseInt(ctx.getChild(4).getText());
        if (left < right) {
            // only add the bond once, when it is first introduced
            this.s.addBond(new WeakBond(left, right));
        }
    }

    @Override
    public void exitCt(RNASecondaryStructureParser.CtContext ctx) {
        // create body
        var body = this.content.subList(this.header.size(), this.content.size());
        // assign the whole sequence to the RNASecondaryStructure
        this.s.setSequence(this.sequenceBuffer.toString());
        // set the size of the structure to the length of the sequence
        this.s.setSize(this.s.getSequence().length());
        // everything has been added to the structure, finalise it
        this.s.finalise();
        // create rnafile object with unnecessary empty body
        this.rnaFile = new RNAFile(this.fileName, this.header, body, this.s, RNAFormat.CT);
    }
    //AAS

    @Override
    public void enterAas(RNASecondaryStructureParser.AasContext ctx) {
        ctx.COMMENT().forEach(line -> this.header.add(line.getText().trim()));
    }


    @Override
    public void enterBonds(RNASecondaryStructureParser.BondsContext ctx) {
        if (this.s.getSize() == -1) {
            this.s.setSequence("");
            this.s.setSize(0);
        }
        // take the bond and add it to the structure
        var indexes = this.getBondTokens(ctx.BOND().getText());
        int left = Integer.parseInt(indexes.get(0));
        int right = Integer.parseInt(indexes.get(1));
        this.s.addBond(new WeakBond(left, right));
    }


    private List<String> getBondTokens(String bondTokenText) {
        var separator = bondTokenText.contains(",") ? ',' : ';';
        var left = bondTokenText.substring(bondTokenText.indexOf('(') + 1, bondTokenText.lastIndexOf(separator));
        var right = bondTokenText.substring(bondTokenText.indexOf(separator) + 1, bondTokenText.lastIndexOf(')'));
        return List.of(left, right);
    }

    @Override
    public void exitAas(RNASecondaryStructureParser.AasContext ctx) {
        // create body
        var body = this.content.subList(this.header.size(), this.content.size());
        // everything has been added to the structure, finalise it
        this.s.finalise();
        // create rnafile object with unnecessary empty body
        this.rnaFile = new RNAFile(this.fileName, this.header, body, this.s, this.s.getSequence() == null ? RNAFormat.AAS_NO_SEQUENCE : RNAFormat.AAS);
    }
    // FASTA

    @Override
    public void enterFasta(RNASecondaryStructureParser.FastaContext ctx) {
        ctx.COMMENT().forEach(line -> this.header.add(line.getText().trim()));
    }

    @Override
    public void exitFasta(RNASecondaryStructureParser.FastaContext ctx) {
        // create body
        var body = this.content.subList(this.header.size(), this.content.size());
        // create rnafile object with unnecessary empty body
        this.rnaFile = new RNAFile(this.fileName, this.header, body, this.s, RNAFormat.FASTA);
    }
    // EDBN

    @Override
    public void exitEdbn_structure(RNASecondaryStructureParser.Edbn_structureContext ctx) {
        var edbn = ctx.EDBN().stream().map(ParseTree::getText).toList();
        for (var e : edbn) {
            /*
             * Control if this part of string has been classified wrongly as EDBN
             * while originally it was a nucleotide part with non-recognised
             * codes; in this case throw an exception
             */
            if (!e.contains(".")) {
                // there are no dots, check if there is at least one bracket
                if (!e.contains("(") && !e.contains(")") && !e.contains("[") && !e.contains("]") && !e.contains("{") && !e.contains("}")) {
                    // there are no brackets, check if the string is very short
                    if (e.length() >= 5) {
                        // ok, it is not considered edbn, the exception is thrown
                        String m = "Line " + ctx.start.getLine() + " Character " + (ctx.start.getCharPositionInLine() + 1) + ": " + "unrecognised nucleotide code in " + e;
                        throw new RNAInputFileParserException(m);
                    }
                }
            }
            /*
             * add this line of edbn to the already existing ones because of the
             * right recursion of the parse tree
             */
            this.edbnsBuffer.append(e);
        }
        if (this.s.getSize() == -1) {
            this.s.setSequence("");
            this.s.setSize(this.edbnsBuffer.length());
        }

        if (this.s.getSize() != 0 && this.edbnsBuffer.length() != this.s.getSize())
            throw new RNAInputFileParserException("Extended Dot-Bracket Notation Structure is of length " + this.edbnsBuffer.length() + " while the sequence of nucleotides is of length " + this.s.getSize());
    }

    @Override
    public void enterSequence(RNASecondaryStructureParser.SequenceContext ctx) {
        var sequence = ctx.NUCLEOTIDE().stream().map(ParseTree::getText).collect(Collectors.joining());
        this.sequenceBuffer.append(sequence);
        this.s.setSequence(this.sequenceBuffer.toString());
        this.s.setSize(this.s.getSequence().length());
    }

    @Override
    public void enterEdbn(RNASecondaryStructureParser.EdbnContext ctx) {
        ctx.COMMENT().forEach(line -> this.header.add(line.getText().trim()));
    }

    @Override
    public void exitEdbn(RNASecondaryStructureParser.EdbnContext ctx) {
        var bonds = parseEDBN(this.edbnsBuffer.toString());
        // add all the bonds to the structure
        for (var wb : bonds)
            this.s.addBond(wb);
        this.s.finalise();
        // create rnafile object
        if (Objects.equals(this.s.getSequence(), ""))
            this.rnaFile = new RNAFile(this.fileName, this.header, List.of(this.edbnsBuffer.toString()), this.s, RNAFormat.DB_NO_SEQUENCE);
        else
            this.rnaFile = new RNAFile(this.fileName, this.header, List.of(this.sequenceBuffer.toString(), this.edbnsBuffer.toString()), this.s, DB);
    }

    @Override
    public void exitRnamlContent(RNASecondaryStructureParser.RnamlContentContext ctx) {
        buildEdgeFamilies(this.s, ctx.XML_CONTENT().getText());
        this.rnaFile = new RNAFile(this.fileName, this.header, List.of(ctx.XML_HEADER_LINE1().getText(), ctx.XML_HEADER_LINE2().getText(), ctx.XML_CONTENT().getText()), this.s, RNAML);
    }

    /*
     * Parse an Extended Dot-Bracket Notation string and transform it into a
     * list of weak bonds.
     *
     * @param extendedDotBracketNotation the string of extended dot-bracket
     * notation to convert
     *
     * @return a list of the bonds in the given extended dot-bracket notation
     *
     * @throws RNAInputFileParserException if the extended dot-bracket
     * notation contains errors
     */

    private static List<WeakBond> parseEDBN(String extendedDotBracketNotation) {
        var bonds = new ArrayList<WeakBond>();
        /*
         * Parse the edbn string using stacks to push opening symbols and
         * match them with closing ones
         */
        var stacks = new HashMap<Character, Stack<Integer>>();
        for (int i = 0; i < extendedDotBracketNotation.length(); i++) {
            var c = extendedDotBracketNotation.charAt(i);
            Character oc = c;
            if (isOpeningChar(c)) {
                if (!stacks.containsKey(oc)) stacks.put(oc, new Stack<>());
                stacks.get(oc).push(i);
            }
            if (isClosingChar(c)) {
                Character opening = getCorrespondingOpening(c);
                if (stacks.get(opening) == null || stacks.get(opening).isEmpty()) {
                    throw new RNAInputFileParserException("Extended dot-bracket notation parsing: closing character at position " + (i + 1) + " does not have a corresponding opening character");
                }
                int leftPosition = stacks.get(opening).pop();
                // add this weak bond to bonds
                bonds.add(new WeakBond(leftPosition + 1, i + 1));
            }
            // skip the "."
        }
        // check mismatched closing symbols
        var ks = stacks.keySet();
        for (var c : ks)
            if (!stacks.get(c).isEmpty()) {
                var msg = new StringBuilder("Extended dot-bracket notation parsing: " + stacks.get(c).size() + " missing closing occurrence(s) of " + c + " symbol, left opening symbol(s) at position(s) ");
                for (Integer i : stacks.get(c))
                    msg.append(i + 1).append(" ");
                throw new RNAInputFileParserException(msg.toString());
            }
        // return
        return bonds;
    }
    /*
     * Determine if the given character is a correct opening character of an
     * extended dot-bracket notation string.
     */

    private static boolean isOpeningChar(char c) {
        return c == '(' || c == '[' || c == '{' || c == '<' || Character.isUpperCase(c);
    }
    /*
     * Determine if the given character is a correct closing character of an
     * extended dot-bracket notation string.
     */

    private static boolean isClosingChar(char c) {
        return c == ')' || c == ']' || c == '}' || c == '>' || Character.isLowerCase(c);
    }
    /*
     * Given a closing character of an extended dot-bracket notation string,
     * returns the corresponding opening character.
     */

    private static char getCorrespondingOpening(char c) {
        return switch (c) {
            case ')' -> '(';
            case ']' -> '[';
            case '}' -> '{';
            case '>' -> '<';
            default -> Character.toUpperCase(c);
        };
    }

    private void buildEdgeFamilies(RNASecondaryStructure structure, String xmlContent) {
        var doc = Jsoup.parse(xmlContent, "", org.jsoup.parser.Parser.xmlParser());
        var sequence = doc.select("seq-data")
                .first()
                .text()
                .trim()
                .replaceAll("\\s+", "");

        var edgeFamilies = new ArrayList<NonCanonicalEdgeFamily>();

        for (var basePair : doc.select("base-pair")) {
            var edge5pElement = basePair.selectFirst("edge-5p");
            var edge3pElement = basePair.selectFirst("edge-3p");
            var bondOrientationElement = basePair.selectFirst("bond-orientation");
            var position5pElement = basePair.selectFirst("base-id-5p base-id position");
            var position3pElement = basePair.selectFirst("base-id-3p base-id position");

            if (edge5pElement == null || edge3pElement == null || bondOrientationElement == null) {
                continue; // We check only these three tags because they may be missing, whereas the position element is always present.
            }

            var bond_type1_value = edge5pElement.text().trim();
            var bond_type2_value = edge3pElement.text().trim();
            var bondOrientation_value = bondOrientationElement.text().trim();

            if (!isCanonicalPair(bond_type1_value, bond_type2_value, bondOrientation_value)) {
                int base_id_5p_index = Integer.parseInt(position5pElement.text().trim());
                int base_id_3p_index = Integer.parseInt(position3pElement.text().trim());

                var base_id_5p = String.valueOf(sequence.charAt(base_id_5p_index - 1));
                var base_id_3p = String.valueOf(sequence.charAt(base_id_3p_index - 1));

                // Prepare EdgeFamily values
                var bond_type_1 = NonCanonicalEdgeFamilyValues.fromShortLabel(bond_type1_value);
                var bond_type_2 = NonCanonicalEdgeFamilyValues.fromShortLabel(bond_type2_value);
                var bondOrientation = NonCanonicalEdgeFamilyValues.fromShortLabel(bondOrientation_value);

                // Create and add the new EdgeFamily
                var edgeFamily = new NonCanonicalEdgeFamily(base_id_5p, base_id_5p_index, base_id_3p, base_id_3p_index,
                        bond_type_1, bond_type_2, bondOrientation);
                edgeFamilies.add(edgeFamily);
            }
        }
        structure.setEdgeFamilies(edgeFamilies);
    }

    private static boolean isCanonicalPair(String edge5p, String edge3p, String bondOrientation) {
        boolean isCanonicalEdge = (edge5p.equals("W") && edge3p.equals("W")) ||
                (edge5p.equals("+") && edge3p.equals("+")) ||
                (edge5p.equals("-") && edge3p.equals("-"));
        boolean isCanonicalBondOrientation = bondOrientation.equals("c");
        return isCanonicalEdge && isCanonicalBondOrientation;
    }
}