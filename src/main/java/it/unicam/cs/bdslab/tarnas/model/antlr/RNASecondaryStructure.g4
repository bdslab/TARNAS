/*
 * ANTLR 4 grammar for reading files containing RNA Secondary Structures
 * in:
 *
 * Dot-Bracket Notation (DBN) Format  - with optional sequence of
 *                                                nucleotides
 *
 * Arc-Annotated Sequence (AAS) Format - with optional sequence of nucleotides
 *
 * Bpseq Format - with optional four initial lines
 *
 * Ct Format - with optional four initial lines
 *
 * Fasta format - with sequence of nucleotides
 *
 * @author Luca Tesei, Piero Hierro, Piermichele Rosati
 *
 */
grammar RNASecondaryStructure;

@header {
package it.unicam.cs.bdslab.tarnas.model.antlr;
}

// Grammar rules
rna_format:
    aas | ct | edbn | bpseq | fasta | rnaml
;

aas:
    COMMENT* sequence? bonds+
;

edbn:
    COMMENT* sequence? edbn_structure
;

fasta:
    COMMENT* sequence
;

bpseq:
    (BPSEQCTLINES? | COMMENT*) bpseq_structure
;

ct:
    (BPSEQCTLINES? | COMMENT*) LINECT ct_structure
;

rnaml:
    XML_DECLARATION DTD RNAML_OPEN molecule_structure interactions? RNAML_CLOSE
;

edbn_structure:
    EDBN+
;

sequence:
    NUCLEOTIDE+
;

bonds:
    BOND SEP?
;

ct_structure:
    ct_line+
;

ct_line:
    INDEX                       // First column: sequence index
    NUCLEOTIDE                  // Second column: base in one-letter notation
    ( ZERO_INDEX | INDEX )      // Third column: sequence indices (plus/minus one)
    ( ZERO_INDEX | INDEX )      // Fourth column: sequence indices (plus/minus one)
    ZERO_INDEX                  // Fifth column: pairing partner of this base if it involved in a base pair
    INDEX # ctLineUnpaired      // Sixth column: sequence indices (plus/minus one)
    |
    INDEX
    NUCLEOTIDE
    ( ZERO_INDEX | INDEX )
    ( ZERO_INDEX | INDEX )
    INDEX                       // Fifth column: no pairing partner of this base if it not involved in a base pair
    INDEX # ctLineBond
;

bpseq_structure:
    bpseq_line+
;

bpseq_line:
    INDEX NUCLEOTIDE ZERO_INDEX # bpseqLineUnpaired
    | INDEX NUCLEOTIDE INDEX # bpseqLineBond
;

molecule_structure:
    '<molecule id="1">' molecule_body '</molecule>'
;

molecule_body:
    sequence_rnaml structure_rnaml
;

sequence_rnaml:
    '<sequence>' .*? sequence_data .*? '</sequence>'
;

sequence_data:
    '<seq-data>' NUCLEOTIDE+ '</seq-data>'
;

structure_rnaml:
    '<structure>' .*? base_pair+ .*? '</structure>'
;

base_pair:
    (BASE_PAIR_OPEN | BASE_PAIR_OPEN_COMMENT)
    base_id_5p
    base_id_3p
    edge_5p?
    edge_3p?
    bond_orientation?
    BASE_PAIR_CLOSE
;

base_id_5p:
    BASE_ID_5P_OPEN BASE_ID_OPEN POSITION_OPEN  INDEX POSITION_CLOSE BASE_ID_CLOSE BASE_ID_5P_CLOSE
;

base_id_3p:
    BASE_ID_3P_OPEN BASE_ID_OPEN POSITION_OPEN INDEX POSITION_CLOSE BASE_ID_CLOSE BASE_ID_3P_CLOSE
;

edge_5p:
    EDGE_5P_OPEN NUCLEOTIDE EDGE_5P_CLOSE
;

edge_3p:
    EDGE_3P_OPEN NUCLEOTIDE EDGE_3P_CLOSE

;

bond_orientation:
    BOND_ORIENTATION_OPEN NUCLEOTIDE BOND_ORIENTATION_CLOSE
;

interactions:
    INTERACTIONS_OPEN STR_ANNOTATION_OPEN STR_ANNOTATION_CLOSE INTERACTIONS_CLOSE
;

// Lexer tokens
INDEX:
    [1-9][0-9]*
;

XML_DECLARATION:
    '<?xml' .*? '?>' '\r'? '\n'
;

DTD:
    '<!DOCTYPE rnaml SYSTEM "rnaml.dtd">' '\r'? '\n'
;

RNAML_OPEN:
    '<rnaml version="1.0">' '\r'? '\n'
;

RNAML_CLOSE:
    '</rnaml>'
;

ZERO_INDEX:
    '0'
;

SEP:
    ',' | ';'
;

BOND:
    '(' INDEX SEP INDEX ')'
;

BPSEQCTLINES:
    LINE1BPSEQCT LINE2BPSEQCT LINE3BPSEQCT LINE4BPSEQCT
;

LINECT:
    NONEWLINE*?
    (
        'ENERGY'
        | 'Energy'
        | 'dG'
    ) .*? '\r'? '\n'
;

fragment NONEWLINE:
    ~( '\r' | '\n' )
;

fragment IUPAC_CODE:
    [ACGUacguTtRrYysSWwKkMmBbDdHhVvNn-]
;

NUCLEOTIDE:
    (
        IUPAC_CODE
        | NON_STANDARD_CODE
    )+
;


BASE_ID_5P_OPEN:
    '<base-id-5p>'
;

BASE_ID_OPEN:
    '<base-id>'
;

POSITION_OPEN:
    '<position>'
;

BASE_ID_5P_CLOSE:
    '</base-id-5p>'
;

BASE_ID_CLOSE:
    '</base-id>'
;

POSITION_CLOSE:
    '</position>'
;

BASE_ID_3P_OPEN:
    '<base-id-3p>'
;

BASE_ID_3P_CLOSE:
    '</base-id-3p>'
;

EDGE_5P_OPEN:
    '<edge-5p>'
;

EDGE_5P_CLOSE:
    '</edge-5p>'
;

EDGE_3P_OPEN:
    '<edge-3p>'
;

EDGE_3P_CLOSE:
    '</edge-3p>'
;

BOND_ORIENTATION_OPEN:
    '<bond-orientation>'
;

BOND_ORIENTATION_CLOSE:
    '</bond-orientation>'
;


INTERACTIONS_OPEN:
    '<interactions>'
;

INTERACTIONS_CLOSE:
    '</interactions>'
;

STR_ANNOTATION_OPEN:
    '<str-annotation>'
;

STR_ANNOTATION_CLOSE:
    '</str-annotation>'
;

BASE_PAIR_OPEN:
    '<base-pair>'
;

BASE_PAIR_CLOSE:
    '</base-pair>'
;

BASE_PAIR_OPEN_COMMENT:
    '<base-pair comment="?">'
;

fragment NON_STANDARD_CODE:
    '"'
    | '?'
    | '!'
    | ']'
    | '~'
    | '['
    | '_'
    | '+'
    | '='
    | '/'
    | '4'
    | '7'
    | 'P'
    | 'O'
    | 'I'
    | '\''
;

fragment EDBN_CODE:
    '.'
    | '('
    | ')'
    | '['
    | ']'
    | '{'
    | '}'
    | '<'
    | '>'
    | [a-bd-suv-z]
    | [A-BD-SUV-Z]
;

EDBN:
    EDBN_CODE+
;

LINE1BPSEQCT:
    'Filename' .*? '\r'? '\n'
;

LINE2BPSEQCT:
    'Organism' .*? '\r'? '\n'
;

LINE3BPSEQCT:
    'Accession' .*? '\r'? '\n'
;

LINE4BPSEQCT:
    'Citation' .*? '\r'? '\n'
;

COMMENT:
    ('#' | '>') .*? '\r'? '\n'
;

WS:
    [ \t\r\n]+ -> skip
; // skip spaces, tabs, newlines