package de.niklas.exercise.collections;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * <strong>Ziehung der Lottozahlen</strong><br>
 * Ziehung der Lottozahlen 1 aus 49 und Speicherung in einem TreeSet
 *
 * @see "25_Datenstrukturen_Aufgaben-1.pdf"
 * @author Niklas Buse
 */
public class Lottery {

    Set<Integer> zahlen = new TreeSet<>();
    Integer zufallsZahl;    // Speichern der Zusatzzahl. Das TreeSet sortiert automatisch, merkt sich so aber jetzt die letzte Zahl (Zusatzzahl)

    /**
     * Generieren und Speichern der Zufallszahlen
     */
    public void pull() {
        Random r = new Random();
        while (zahlen.size() < 7) {
            zufallsZahl = r.nextInt(1, 50); // Ab 1 bis < 50
            zahlen.add(zufallsZahl);
        }
    }

    /**
     * Ausgeben des Ergebnisses im Terminal
     */
    public void print() {
        this.zahlen.remove(this.zufallsZahl); // Löschen der Zusatzzahl (letzte Zufallszahl) aus dem Set um sie später zusätzlich auszugeben
        StringBuilder lotteryNumbers = new StringBuilder();
        for (int zahl : this.zahlen) {
            lotteryNumbers.append(String.format("%d ", zahl));
        }
        System.out.printf("%sZusatzzahl: %d %n", lotteryNumbers, this.zufallsZahl);
    }

    public static void main(String[] args) {
        Lottery lotto = new Lottery();
        lotto.pull();
        lotto.print();
    }
}