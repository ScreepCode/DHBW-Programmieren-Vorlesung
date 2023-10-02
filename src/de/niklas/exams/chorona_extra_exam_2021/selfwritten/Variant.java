package de.niklas.exams.chorona_extra_exam_2021.selfwritten;

public enum Variant {

    WILD_TYPE("Wildtyp", "SARS-CoV-2"),
    ALPHA("Alpha", "B.1.1.7"),
    BETA("Beta", "B.1.351"),
    GAMMA("Gamma", "P.1"),
    DELTA("Delta", "B.1.617"),
    FETA("Feta", "O.u.z.o"),
    LAMBDA("Lambda", "C.37"),
    OMICRON("Omikron", "B.1.1.529");

    private final String label;
    private final String desigination;

    Variant(String label, String desigination) {
        this.label = label;
        this.desigination = desigination;
    }

    public String getLabel() {
        return label;
    }

    public String getDesigination() {
        return desigination;
    }

}
