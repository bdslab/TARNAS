package it.unicam.cs.bdslab.tarnas.model.rnastructure;

public enum EdgeFamilyValues {
    NOT_CANONICAL_PAIR("Not-Canonical Pair"),
    SUGAR("Sugar"),
    HOOGSTEEN("Hoogsteen"),
    WATSON_CRICK("Watson-Crick"),
    TRANS("trans"),
    CIS("cis"),
    EXCLAMATION("!");

    private final String label;

    EdgeFamilyValues(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static EdgeFamilyValues fromShortLabel(String shortLabel) {
        return switch (shortLabel) {
            case "S" -> SUGAR;
            case "W" -> WATSON_CRICK;
            case "H" -> HOOGSTEEN;
            case "!" -> EXCLAMATION;
            case "t" -> TRANS;
            case "c" -> CIS;
            default -> throw new IllegalArgumentException("Unknown label: " + shortLabel);
        };
    }
}