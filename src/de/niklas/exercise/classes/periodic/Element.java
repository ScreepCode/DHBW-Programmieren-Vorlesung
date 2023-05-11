package de.niklas.exercise.classes.periodic;

/**
 * <strong>Periodensystem</strong><br>
 * Implementation eines einzelnen Elements
 *
 * @see "13_Vererbung_Aufgaben-2.pdf"
 * @see PeriodicTable
 * @author Niklas Buse
 */
public class Element {
    private String name;
    private String symbol;
    private int ordinal;
    private char shell;
    private int phase;
    private boolean mainGroup;

    /**
     * Konstruktor für ein Element
     * @param name Name
     * @param symbol Symbol
     * @param ordinal Ordnungszahl
     * @param shell Schale
     * @param phase Aggregatzustand: Fest=1, Flüssig=2, Gas=3
     * @param mainGroup Hauptgruppe: True=Hauptgruppe, False=Nebengruppe
     */
    public Element(String name, String symbol, int ordinal, char shell, int phase, boolean mainGroup) {
        this.name = name;
        this.symbol = symbol;
        this.ordinal = ordinal;
        this.shell = shell;
        this.phase = phase;
        this.mainGroup = mainGroup;
    }

    /**
     * Rückgabe vom Elementnamen
     * @return Elementname
     */
    public String getName() {
        return name;
    }

    /**
     * Setzen des Elementnamens
     * @param name Elementname
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Rückgabe vom Elementsymbols
     * @return Elementsymbols
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Setzen des Elementsymbols
     * @param symbol Elementsymbol
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * Rückgabe der Ordnungszahl
     * @return Ordnungszahl
     */
    public int getOrdinal() {
        return ordinal;
    }

    /**
     * Setzen der Ordnungszahl
     * @param ordinal Ordnungszahl
     */
    public void setOrdinal(int ordinal) {
        this.ordinal = ordinal;
    }

    /**
     * Rückgabe der Schale, in der sich das Element befindet
     * @return Schale
     */
    public char getShell() {
        return shell;
    }

    /**
     * Setzen der Schale, in der sich das Element befindet
     * @param shell Schale
     */
    public void setShell(char shell) {
        this.shell = shell;
    }

    /**
     * Rückgabe des Aggregatzustands als Zahl
     * @return Aggregatzustands (als int)
     */
    public int getPhase() {
        return phase;
    }

    /**
     * Setzen des Aggregatzustands als Zahl (Fest=1, Flüssig=2, Gas=3)
     * @param phase Aggregatzustand
     */
    public void setPhase(int phase) {
        this.phase = phase;
    }

    /**
     * Rückgabe, ob es eine Hauptgruppe ist
     * @return Hauptgruppe ja/nein
     */
    public boolean isMainGroup() {
        return mainGroup;
    }

    /**
     * Setzen, ob es eine Hauptgruppe ist (True=Hauptgruppe, False=Nebengruppe)
     * @param mainGroup Hauptgruppe
     */
    public void setMainGroup(boolean mainGroup) {
        this.mainGroup = mainGroup;
    }

    /**
     * Rückgabe des Aggregatzustands als Wort
     * @return Aggregatzustands (als Wort)
     */
    public String aggregat2String() {
        switch (this.getPhase()) {
            case 1:
                return "fest";
            case 2:
                return "flüssig";
            default:
                return "gasförmig";
        }
    }

    /**
     * Überprüfung, ob das eingegebene Element mit dem eigenen übereinstimmt
     * @param o Objekt, das zu vergleichen ist (erwartet wird ein Element)
     * @return Ob sie übereinstimmen
     */
    public boolean equals(Object o){
        if (o instanceof Element) {                                     // Hier wird erstmal überprüft, ob es sich bei dem Objekt um ein Element handelt
            return this.getOrdinal() == ((Element) o).getOrdinal();
        }
        else {
            return false;
        }
    }

    /**
     * Ausgabe des Elements mit allen Eigenschaften
     * @return Elementinformationen
     */
    @Override
    public String toString() {
        return String.format("%s (%s, %d) Schale: %c, %s, Gruppe: %sgruppe",
                this.getName(),
                this.getSymbol(),
                this.getOrdinal(),
                this.getShell(),
                aggregat2String(),
                (this.isMainGroup()? "Haupt" : "Neben")
        );
    }
}
