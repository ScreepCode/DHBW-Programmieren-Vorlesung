package de.niklas.exercise.java8.soccer;

/**
 * <strong>Arbeiten mit Streams</strong><br>
 * Player Implementierung als record, da keine Setter benötigt
 *
 * @see "33_Java8_Aufgaben.pdf"
 * @see Soccer
 * @author Niklas Buse
 */
public record Player(int number, String name, String position, String birthday, String club, int games, int goals) {

    @Override
    public String toString() {
        return String.format("%2d | %s, %s, %s, %s, %d games, %d goals", number, name, position, birthday, club, games, goals);
    }

    /**
     * Vergleich von Spielern nach Nummer
     * @param p1 Spieler 1
     * @param p2 Spieler 2
     * @return Vergleichswert der Spieler
     */
    public static int comparePlayerByNumber(Player p1, Player p2){
        return p1.number() - p2.number();
    }

    /**
     * Vergleich von Spielern nach Name
     * @param p1 Spieler 1
     * @param p2 Spieler 2
     * @return Vergleichswert der Spieler
     */
    public static int comparePlayerByName(Player p1, Player p2){
        return p1.name().compareTo(p2.name());
    }
}
