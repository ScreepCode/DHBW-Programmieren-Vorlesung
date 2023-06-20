package de.niklas.exercise.enums.library;

/**
 * <strong>Sortierkriterien</strong><br>
 * Erweiterung der Library aus vorheriger Aufgabe durch nutzen eines Enums für Sortierkriterien
 *
 * @see "26_Enum_Aufgaben.pdf"
 * @author Niklas Buse
 */
public enum Attributes {

    TITLE("Title"),
    AUTHOR("Author"),
    YEAR("Year"),
    PUBLISHER("Publisher");

    private String name;

    private Attributes(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
