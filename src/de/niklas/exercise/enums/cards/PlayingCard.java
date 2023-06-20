package de.niklas.exercise.enums.cards;

/**
 * <strong>Kartenspiel</strong><br>
 * Implementation der Spielkarten
 *
 * @see "26_Enum_Aufgaben.pdf"
 * @see CardGame
 * @author Niklas Buse
 */
public class PlayingCard implements Comparable<PlayingCard>{
    CardValue value;
    CardColor color;

    public PlayingCard(CardValue value, CardColor color){
        this.value = value;
        this.color = color;
    }

    /**
     * Errechnen des Kartenwerts
     * @return Kartenwert
     */
    public int getValue() {
        return this.color.ordinal() * 10 + this.value.ordinal();
    }

    /**
     * Vergleichen des Kartenwerts zu einer anderen
     * @param card Karte, zu der Verglichen wird
     * @return Vergleichswert
     */
    @Override
    public int compareTo(PlayingCard card) {
        return this.getValue() - card.getValue();
    }

    /**
     * Ausgabe der Karte mit Farbe und Wert (wie auf der Karte)
     * @return Karte als String
     */
    @Override
    public String toString() {
        return String.format("%s %s", color, value);
    }
}
