package de.niklas.exams.fasid_extra_exam_2022.selfwritten;

public enum ResultType {
    UNKNOWN("Unknown", -1),
    DRAW("Draw", 0),
    HOME("Home wins", 1),
    GUEST("Guest wins", 2),
    FASID("Fasid", 99);

    private String label;
    private int toto;

    ResultType(String label, int toto){
        this.label = label;
        this.toto = toto;
    }

    public String getLabel() {
        return label;
    }

    public int getToto() {
        return toto;
    }

    @Override
    public String toString() {
        return String.format("%s (%d)", label, toto);
    }
}
