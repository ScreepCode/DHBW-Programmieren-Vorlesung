package de.niklas.classes;

import java.util.Random;
import java.util.Scanner;

/**
 * <strong>Mastermind</strong><br>
 * Implementation des Spiels Mastermind mit 5 zufälligen Buchstaben aus (A bis H)
 *
 * @see "09_Klassen_Aufgaben-3.pdf"
 * @author Niklas Buse
 */
public class MasterMind {

    private String rightCombination = "";
    private String[][] guesses;
    private int guessCounter = 0;
    private boolean stillMismatch = true;
    Scanner scan = new Scanner(System.in);

    /**
     * Initialisierung des Spiels mit der Anzahl an maximalen Versuchen
     * @param maxVersuche Maximale Anzahl an Versuchen
     */
    public MasterMind(int maxVersuche){
        this.guesses = new String[maxVersuche][3];
        generateCombination();
        startGame();
    }

    /**
     * Generieren der zufälligen Buchstabenfolge
     */
    private void generateCombination(){
        String[] possibilities = new String[]{"A", "B", "C", "D", "E", "F", "G", "H"};          // Alle möglichen Buchstaben
        for(int i = 0; i < 5; i++){
            this.rightCombination += possibilities[new Random().nextInt(possibilities.length)]; // Kombination wird erweitert durch einen zufälligen Eintrag im Array
        }
//        System.out.println(rightCombination + "\n\n");        // zum Testen, dass die richtige Kombination einmal ausgeben wird
//        this.rightCombination = "HDGDF";                      // zum Testen eine bekannte Kombination
    }

    /**
     * Starten des Spielverlaufs
     * Spielende ist bei richtig geratender Kombination oder der Überschreitung der maximalen Versuche
     */
    private void startGame(){
        while (this.stillMismatch | this.guessCounter <= 20){
            System.out.print("Geben Sie ihren Tipp ab: ");
            this.scan = new Scanner(System.in);
            String guess = scan.nextLine().toUpperCase();
            validateGuess(guess);                           // Überprüfen des Versuchs
            this.guessCounter++;
            printGuesses();                                 // Ausgabe aller erfolgten Versuche
        }
        System.out.printf("Mit %d Versuchen gewonnen!", this.guessCounter);
    }

    /**
     * Überprüfung und Speicherung des Versuchs
     * @param guess zu überprüfender Versuch
     */
    private void validateGuess(String guess){
        int excactMatch = 0;
        int letterMatchWrongPos = 0;

        // Kopieren der Kombination und des Versuchs als Array
        String[] cRightCombination =  this.rightCombination.split("");
        String[] cGuess =  guess.split("");

        if(guess.equals(this.rightCombination)){    //Überprüfung, ob richtig geraten wurden, wenn ja, dann Beenden der Funktion
            this.stillMismatch = false;
            return;
        }

        // Überprüfung nach richtigen Positionen
        for(int i = 0; i < cRightCombination.length; i++){
            if(cRightCombination[i].equals(cGuess[i])){
                excactMatch++;
                cRightCombination[i] = "0";     // Wenn ja, werden die entsprechenden Felder auf ein Zeichen gesetzt, was außerhalb der Möglichkeiten ist
                cGuess[i] = "0";                //  das vereinfacht das Überprüfen der falschen Stellen, da diese Positionen ja schon abgehandelt sind
            }
        }

        for(int i = 0; i < cRightCombination.length; i++){
            for(int j = 0; j < cGuess.length; j++){
                if(cRightCombination[i] != "0" && cRightCombination[i].equals(cGuess[j])){  // Durchgehen aller möglicher Treffer an falschen Positionen;
                    letterMatchWrongPos++;                                                  //  Hier wird das Zeichen von dem Positionstreffer gefiltert
                    cRightCombination[i] = "0"; // Gleicher Vorgang, wenn schon behandelt wurde, dass nicht nochmal behandelt wird
                    cGuess[j] = "0";
                }
            }
        }

        guesses[guessCounter] = new String[]{guess, ""+excactMatch, ""+letterMatchWrongPos};    // Speichern des Versuchs im Array für die Ausgabe
    }

    /**
     * Ausgabe aller Versuche die getätigt wurden, inkl. der zutreffenden Attribute
     */
    private void printGuesses(){
        if(this.stillMismatch){
            System.out.printf("%d bisherige Versuche: \n", this.guessCounter);
            for(int i = 0; i < guessCounter; i++){
                System.out.printf("%s %s %s \n", guesses[i][0], guesses[i][1], guesses[i][2]);
            }
        }
    }


    public static void main(String[] args) {
        new MasterMind(20);
    }

}

/* Beispielausführung
--------------------------------------
Eingabe:
abbcc
deeff
dghdd
dedgh
fdgdh
hdgdf
--------------------------------------
Ausgabe:
Geben Sie ihren Tipp ab: abbcc
1 bisherige Versuche:
ABBCC 0 0
Geben Sie ihren Tipp ab: deeff
2 bisherige Versuche:
ABBCC 0 0
DEEFF 1 1
Geben Sie ihren Tipp ab: dghdd
3 bisherige Versuche:
ABBCC 0 0
DEEFF 1 1
DGHDD 1 3
Geben Sie ihren Tipp ab: dedgh
4 bisherige Versuche:
ABBCC 0 0
DEEFF 1 1
DGHDD 1 3
DEDGH 0 4
Geben Sie ihren Tipp ab: fdgdh
5 bisherige Versuche:
ABBCC 0 0
DEEFF 1 1
DGHDD 1 3
DEDGH 0 4
FDGDH 3 2
Geben Sie ihren Tipp ab: hdgdf
Mit 6 Versuchen gewonnen!
--------------------------------------
 */
