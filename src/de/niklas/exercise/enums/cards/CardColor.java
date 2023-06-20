package de.niklas.exercise.enums.cards;

/**
 * <strong>Kartenspiel</strong><br>
 * Implementation des Kartenfarben Enum
 *
 * @see "26_Enum_Aufgaben.pdf"
 * @see CardGame
 * @author Niklas Buse
 */
public enum CardColor {
    DIAMONDS("Karo"),
    HEARTH("Herz"),
    SPADE("Pik"),
    CLUBS("Kreuz");

    public String color;

    CardColor(String color){
        this.color = color;
    }

    @Override
    public String toString() {
        return this.color;
    }
}
