package de.niklas.exercise.enums.cards;

/**
 * <strong>Kartenspiel</strong><br>
 * Implementation des Testklasse, wie in der Aufgabe beschrieben
 * Erst 10 Karten vergleichen, dann Rest ausgeben
 *
 * @see "26_Enum_Aufgaben.pdf"
 * @see CardGame
 * @author Niklas Buse
 */
public class TestGame {
    public static void main(String[] args) {
        CardGame game = new CardGame();
        game.shuffle();

        PlayingCard heart7 = new PlayingCard(CardValue.SEVEN, CardColor.HEARTH);

        System.out.println("10 Karten ziehen und vergleichen:");
        for (int i = 0; i < 10; i++) {
            PlayingCard card = game.get();
            System.out.printf("%s verglichen mit %s: %d%n", card, heart7, card.compareTo(heart7));
        }

        System.out.println("Übrige Karten sortiert:");
        game.sort();
        for (PlayingCard cd : game.all()) {
            System.out.println(cd);
        }
    }
}
