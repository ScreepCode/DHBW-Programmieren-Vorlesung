package de.niklas.exercise.classes;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * <strong>Lotto</strong><br>
 * Implementation eines Lottospiels
 *
 * @see "09_Klassen_Aufgaben-3.pdf"
 * @author Niklas Buse
 */
public class Lotto {

    private int m;
    private int n;
    private int[] guesses;
    private int[] drawn;
    Scanner scan;

    /**
     * Eingabe der Lottoparameter
     * @param m Mögliche Maximalzahl
     * @param n Anzahl zu ratender Zahlen
     */
    public Lotto(int m, int n){
        this.m = m;
        this.n = n;
        this.guesses = new int[m];
        this.drawn = new int[m];
    }

    /**
     * Einlesen der Zahlen zum Spielen aus der CMD,
     * dabei wird auf die Gültigkeit des Tipps geachtet
     */
    public void tippen(){
        scan = new Scanner(System.in);
        for(int i = 0; i < m; i++){
            boolean notValidGuess = true;
            while(notValidGuess){
                System.out.printf("Geben Sie bitte Ihren Tipp für die %d. Zahl ein: ", i+1);
                int guess =  scan.nextInt();
                if(guess <= n & guess >= 1){
                    this.guesses[i] = guess;
                    notValidGuess = false;
                }
                else{
                    System.out.printf("Bitte gebe einen Tipp ab, der zwischen 1 und %d ist\n", this.n);
                }
            }
        }
        Arrays.sort(guesses);
        System.out.println("Tipp: " + Arrays.toString(guesses));
    }

    /**
     * Tippen durch Eingabe eines Arrays
     * @param tipp Array an Tippzahlen
     */
    public void tippen(int[] tipp){
        if(tipp.length == guesses.length){
            this.guesses = tipp;
        }
        else{
            System.out.println("Dein festgelegter Tipp hat nicht die passende Anzahl an Tipps");
            System.out.println("Das Programm wird automatisch beendet.");
            System.exit(0);
        }
        System.out.println("Tipp: " + Arrays.toString(guesses));
    }

    /**
     * Zufälliges Ziehen der Lottozahlen
     */
    public void ziehen(){
        for(int i = 0; i < drawn.length; i++){
            drawn[i] = new Random().nextInt(1, n);
        }
        Arrays.sort(drawn);
        System.out.println();
        System.out.println("Tipp: " + Arrays.toString(guesses));
        System.out.println("Gezogene Zahlen: " + Arrays.toString(drawn));
    }

    /**
     * Bestimmung und Rückgabe richtiger Tipps
     * @return Anzahl richtiger Tipps
     */
    public int richtige(){
        int counter = 0;
        for(int i = 0; i<guesses.length & i<drawn.length; i++){
            if(guesses[i] == drawn[i]){
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        Lotto deutschesLotto = new Lotto(6,49);
        deutschesLotto.tippen();
//        deutschesLotto.tippen(new int[]{31, 32, 33, 34, 35, 36}); // Vordefinierter Tipp zum Testen
        deutschesLotto.ziehen();
        System.out.println("Richtige: " + deutschesLotto.richtige());
    }
}

/* Beispielausführung
--------------------------------------
Eingabe:
1
2
3
4
5
6
--------------------------------------
Ausgabe:
Geben Sie bitte Ihren Tipp für die 1. Zahl ein: 1
Geben Sie bitte Ihren Tipp für die 2. Zahl ein: 2
Geben Sie bitte Ihren Tipp für die 3. Zahl ein: 3
Geben Sie bitte Ihren Tipp für die 4. Zahl ein: 4
Geben Sie bitte Ihren Tipp für die 5. Zahl ein: 5
Geben Sie bitte Ihren Tipp für die 6. Zahl ein: 6
Tipp: [1, 2, 3, 4, 5, 6]

Tipp: [1, 2, 3, 4, 5, 6]
Gezogene Zahlen: [1, 9, 31, 40, 41, 45]
Richtige: 1
--------------------------------------
 */
