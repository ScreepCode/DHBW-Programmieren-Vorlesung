package de.niklas.exercise.enums.cards;

/**
 * <strong>Kartenspiel</strong><br>
 * Implementation des Kartenwert Enum
 *
 * @see "26_Enum_Aufgaben.pdf"
 * @see CardGame
 * @author Niklas Buse
 */
public enum CardValue {
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    JACK("Bube"),
    QUEEN("Dame"),
    KING("König"),
    ACE("Ass");

    public String value;

    CardValue(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
