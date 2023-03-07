package de.niklas.classes.periodic;

/**
 * <strong>Periodensystem</strong><br>
 * Implementation eines Metalls, auf Basis von Element
 *
 * @see "13_Vererbung_Aufgaben-2.pdf"
 * @see PeriodicTable
 * @author Niklas Buse
 */
public class Metal extends Element{

    private boolean metalloid;
    private double conductivity;

    /**
     * Konstruktor für ein Metall geerbt vom Element
     * @param name Name
     * @param symbol Symbol
     * @param ordinal Ordnungszahl
     * @param shell Schale
     * @param phase Aggregatzustand: Fest=1, Flüssig=2, Gas=3
     * @param mainGroup Hauptgruppe: True=Hauptgruppe, False=Nebengruppe
     * @param metalloid Halbmetall: True, wenn es eines ist
     * @param conductivity Leitfähigkeit in sigma
     */
    public Metal(String name, String symbol, int ordinal, char shell, int phase, boolean mainGroup, boolean metalloid, double conductivity) {
        super(name, symbol, ordinal, shell, phase, mainGroup);
        this.metalloid = metalloid;
        this.conductivity = conductivity;
    }

    /**
     * Rückgabe, ob es sich um ein Metalloid (Halbmetall) handelt
     * @return Metalloid ja/nein
     */
    public boolean isMetalloid() {
        return metalloid;
    }

    /**
     * Setzen, ob es sich um ein Metalloid (Halbmetall) handelt
     * @return Metalloid ja/nein
     */
    public void setMetalloid(boolean metalloid) {
        this.metalloid = metalloid;
    }

    /**
     * Rückgabe, der Leitfähigkeit in Sigma
     * @return Leitfähigkeit
     */
    public double getConductivity() {
        return conductivity;
    }

    /**
     * Setzen der Leitfähigkeit in Sigma
     * @param conductivity Leitfähigkeit
     */
    public void setConductivity(double conductivity) {
        this.conductivity = conductivity;
    }

    /**
     * Überschreiben der Element toString, die um die Metallparameter erweitert wird
     * @return Metallinformationen
     */
    @Override
    public String toString() {
        return String.format("%s (%s, %d) Schale: %c, %s, Gruppe: %sgruppe, %s\u03C3: %s",  // Der Unicode ist das Sigma Zeichen für leitfähigkeit
                this.getName(),
                this.getSymbol(),
                this.getOrdinal(),
                this.getShell(),
                super.aggregat2String(),
                (this.isMainGroup()? "Haupt" : "Neben"),
                (this.metalloid? "Halbleiter, " : ""),
                this.getConductivity()
        );
    }
}
