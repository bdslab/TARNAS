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
    XML_DECLARATION DTD RNAML_OPEN molecule_structure RNAML_CLOSE
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
    .*? numbering_table sequence_data .*? base_pair* .*?
;

numbering_table:
    '<numbering-table length="'(INDEX | ZERO_INDEX)'"' .*?'</numbering-table>'
;

sequence_data:
    '<seq-data>' NUCLEOTIDE+ '</seq-data>'
;

base_pair:
    '<base-pair comment="?">'
    BASE_ID_5P
    BASE_ID_3P
    EDGE_5P
    EDGE_3P
    BOND_ORIENTATION
    '</base-pair>'
;


// Lexer tokens
INDEX:
    [1-9][0-9]*
;

COORD:
    '-'? [0-9]+ '.' [0-9]+ ' ' '-'? [0-9]+ '.' [0-9]+
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

attributes:
    (ATTRIBUTE_NAME '=' ATTRIBUTE_VALUE)+
;

ATTRIBUTE_NAME:
    [a-zA-Z_:][a-zA-Z0-9_:-]*
;

ATTRIBUTE_VALUE:
    '"' ~["]* '"'
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

BASE_ID_5P:
    '<base-id-5p>' '<base-id>' '<position>' INDEX '</position>' '</base-id>' '</base-id-5p>'
;

BASE_ID_3P:
    '<base-id-3p>' '<base-id>' '<position>' INDEX '</position>' '</base-id>' '</base-id-3p>'
;

EDGE_5P:
    '<edge-5p>' ('+' | '-' | 'W' | 'H' | 'S' | '!') '</edge-5p>'
;

EDGE_3P:
    '<edge-3p>' ('+' | '-' | 'W' | 'H' | 'S' | '!') '</edge-3p>'
;

BOND_ORIENTATION:
    '<bond-orientation>' ('c' | 't' | '!') '</bond-orientation>'
;

fragment NON_STANDARD_CODE:
    '"'
    | '?'
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
    | [a-zA-Z]
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