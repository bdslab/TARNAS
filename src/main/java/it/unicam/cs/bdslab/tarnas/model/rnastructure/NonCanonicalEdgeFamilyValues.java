package it.unicam.cs.bdslab.tarnas.model.rnastructure;

public enum NonCanonicalEdgeFamilyValues {
    SUGAR("Sugar"),
    HOOGSTEEN("Hoogsteen"),
    WATSON_CRICK("Watson-Crick"),
    TRANS("trans"),
    CIS("cis"),
    EXCLAMATION("!"),
    NONE("???");

    private final String label;

    NonCanonicalEdgeFamilyValues(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static NonCanonicalEdgeFamilyValues fromShortLabel(String shortLabel) {
        return switch (shortLabel) {
            case "S", "s" -> SUGAR;
            case "W" -> WATSON_CRICK;
            case "H" -> HOOGSTEEN;
            case "!" -> EXCLAMATION;
            case "t" -> TRANS;
            case "c" -> CIS;
            default -> NONE;
        };
    }
}