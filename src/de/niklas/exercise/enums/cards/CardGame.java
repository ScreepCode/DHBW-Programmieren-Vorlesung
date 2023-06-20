package de.niklas.exercise.enums.cards;

import java.util.*;

/**
 * <strong>Kartenspiel</strong><br>
 * Implementation der Funktionen vom Kartenspiel
 *
 * @see "26_Enum_Aufgaben.pdf"
 * @author Niklas Buse
 */
public class CardGame {
    List<PlayingCard> gameCards;

    public CardGame() {
        gameCards = new ArrayList<PlayingCard>();
        for (CardColor color : CardColor.values()){
            for (CardValue value : CardValue.values()) {
                gameCards.add(new PlayingCard(value, color));
            }
        }
    }

    /**
     * Shuffeln des Kartendecks
     */
    public void shuffle() {
        Collections.shuffle(gameCards);
    }

    /**
     * Sortieren der Karten
     */
    public void sort() {
        Collections.sort(gameCards);
    }

    /**
     * Zurückgeben und löschen der obersten Karte
     * @return Oberste Karte
     */
    public PlayingCard get() {
        if (gameCards.isEmpty()) {
            return null;
        }
        return gameCards.remove(0);
    }

    /**
     * Rückgabe aller Karten die im Stapel sind
     * @return Alle Karten des Stapels
     */
    public List<PlayingCard> all() {
        return gameCards;
    }
}
