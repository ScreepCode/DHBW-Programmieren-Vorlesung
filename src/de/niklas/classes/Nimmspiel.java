package de.niklas.classes;

import java.util.Random;
import java.util.Scanner;

/**
 * <strong>Nimmspiel</strong><br>
 * Implementation eines Nimmspiels
 * Dazu gibt es 2 Töpfe mit einer genierten Anzahl an Kugeln, der letzte der eine Kugel zieht hat gewonnen
 *
 * @see "09_Klassen_Aufgaben-3.pdf"
 * @author Niklas Buse
 */
public class Nimmspiel {

    private String[] player = new String[2];
    private int[] stacks = new int[2];
    private int nextPlayer;
    Scanner scan = new Scanner(System.in);

    /**
     * Initialiesierung des Nimmspiels mit den übergebenen 2 Spielernamen
     * @param player1 Spielername 1
     * @param player2 Spielername 2
     */
    public Nimmspiel(String player1, String player2){
        player[0] = player1;
        player[1] = player2;

        // Generierung der Stapel
        for(int i = 0; i < stacks.length; i++){
            stacks[i] = new Random().nextInt(4, 11);
        }

        // Zufällige Bestimmung des zu beginnenden Spielers
        this.nextPlayer = new Random().nextInt(0, 1);

        play();
    }

    /**
     * Starten des Spielablaufs
     */
    private void play(){
        while(checkStacksIfFull()){                     // Hier wird gecheckt, ob noch Kugeln vorhanden sind, wenn nicht, gibt es einen Sieger
            System.out.printf(toString());              // Ausgabe des aktuellen Spielsituation
            nextPlayer = (nextPlayer == 1) ? 0 : 1;     // Wechsel des Spielers
            move();                                     // Zug vom entsprechendem Spieler
        }
        System.out.printf(toString());                  // Ausgabe des Spielstands
        System.out.println("\nSpiel beendet.");
        System.out.printf("Gewonnen hat Spieler %s", player[nextPlayer]); // Sieger Bekanntgabe
    }

    /**
     * Funktion für jeden einzelnen Spielzug
     */
    private void move(){
        System.out.printf("\nSpieler %s: Von welchem Haufen ziehen Sie Kugeln? ", player[nextPlayer]);
        scan = new java.util.Scanner(System.in);
        int stackNum = scan.nextInt() - 1;  // Umrechnung des Stapels, auf den Array Index
        if(stacks[stackNum] == 0){          // Unerlaubte Auswahl, da der Stapel leer ist, automatisch wird der andere genomen
            System.out.printf("Spieler %s: Der Haufen ist bereits leer, du musst automatisch vom anderen nehmen!", player[nextPlayer]);
        }
        boolean pulled = false;
        while(!pulled) { // Überprüfung, ob ein gültiger Spielzug stattgefunden hat
            System.out.printf("Spieler %s: Wie viele Kugeln ziehen Sie? ", player[nextPlayer]);
            scan = new java.util.Scanner(System.in);
            int toPull = scan.nextInt();
            if (this.stacks[stackNum] >= toPull) { // Abgleich, ob genug Kugeln vorhanden sind
                this.stacks[stackNum] -= toPull;   // Stapel wird um Anzahl reduziert
                pulled = true;
            } else {
                System.out.printf("Spieler %s: Du kannst nicht mehr Kugeln ziehen als auf dem Haufen sind!", player[nextPlayer]);
            }
        }
    }

    private boolean checkStacksIfFull(){                // Überprüfung, ob mind. ein Stapel noch Kugeln hat.
        return !(stacks[0] == 0 && stacks[1] == 0);     // Es kann nur false geben, wenn beide Stapel leer sind
    }

    /**
     * Ausgabe der aktuellen Spielsituation
     * @return Spielsituation als String
     */
    @Override
    public String toString() {
        return String.format("\nSpieler: %s und %s, Haufen 1: %d Kugel(n), Haufen 2: %d Kugel(n)", player[0], player[1], stacks[0], stacks[1]);
    }

    public static void main(String[] args) {
        new Nimmspiel("Alf", "Ben");
    }
}

/* Beispielausführung
--------------------------------------
Eingabe:
1
4

2
6

1
1

2
1
--------------------------------------
Ausgabe:
Spieler: Alf und Ben, Haufen 1: 5 Kugel(n), Haufen 2: 7 Kugel(n)
Spieler Alf: Von welchem Haufen ziehen Sie Kugeln? 1
Spieler Alf: Wie viele Kugeln ziehen Sie? 4

Spieler: Alf und Ben, Haufen 1: 1 Kugel(n), Haufen 2: 7 Kugel(n)
Spieler Ben: Von welchem Haufen ziehen Sie Kugeln? 2
Spieler Ben: Wie viele Kugeln ziehen Sie? 6

Spieler: Alf und Ben, Haufen 1: 1 Kugel(n), Haufen 2: 1 Kugel(n)
Spieler Alf: Von welchem Haufen ziehen Sie Kugeln? 1
Spieler Alf: Wie viele Kugeln ziehen Sie? 1

Spieler: Alf und Ben, Haufen 1: 0 Kugel(n), Haufen 2: 1 Kugel(n)
Spieler Ben: Von welchem Haufen ziehen Sie Kugeln? 2
Spieler Ben: Wie viele Kugeln ziehen Sie? 1

Spieler: Alf und Ben, Haufen 1: 0 Kugel(n), Haufen 2: 0 Kugel(n)
Spiel beendet.
Gewonnen hat Spieler Ben
--------------------------------------
 */
