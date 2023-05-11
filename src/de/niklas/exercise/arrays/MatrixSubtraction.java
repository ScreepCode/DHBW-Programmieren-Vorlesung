package de.niklas.exercise.arrays;

import java.util.Random;
import java.util.Scanner;
/**
 * <strong>Subtraktion zweier Matrizen</strong><br>
 * Hier werden 2 Matrizen mit eingegebener Größe mit zufälligen Zahlen generiert und voneinander subtrahiert.
 *
 * @see "07_Arrays_Aufgaben-2.pdf"
 * @author Niklas Buse
 */
public class MatrixSubtraction {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Bitte Anzahl der Zeilen n eingeben: ");
        int zeilen = scan.nextInt();
        System.out.print("Bitte Anzahl der Spalten m eingeben: ");
        int spalten = scan.nextInt();

        int[][] xMatrix = new int[zeilen][spalten];                     // Man kann das ganze Auch alles kompakter Schreiben
        int[][] yMatrix = new int[zeilen][spalten];                     //  So ist die Funktionsweise am einfachsten erkennbar.
        int[][] subMatrix = new int[zeilen][spalten];
                                                                        // Im späteren Fall würde man die einzelnen for Schleifen (das Generieren) in eine extra Methode schreiben, um doppelten Code zu vermeiden
        System.out.println("X:");
        for(int i = 0; i < xMatrix.length; i++){                        // Hier wird jede Zeile der Matrix durchlaufen → Basiswert die Array-Länge des ersten Arrays
            for(int j = 0; j < xMatrix[i].length; j++){                 // Hier wird jeder Wert der Matrix durchlaufen → Basiswert die Array-Länge des zweiten Arrays
            xMatrix[i][j] = new Random().nextInt(100);              // Der Wert der Matrix wird gesetzt; ersten beiden Blöcke die Zufallszahl, im dritten Block dann die Subtraktion.
                System.out.printf("%4s", xMatrix[i][j]);                // Hier wird jede Stelle des Arrays ausgegeben und auf 4 Zeichen aufgefüllt für schönere Darstellung.
            }                                                           //      denn die maximale Zahlenlänge ist 3 + Minuszeichen (-100). Für den Fall soll die Matrix dennoch schön sein
            System.out.println();                                       // Für einfachen Zeilenumbruch in der Matrix
        }
        System.out.println("Y:");
        for(int i = 0; i < yMatrix.length; i++){
            for(int j = 0; j < yMatrix[i].length; j++){
                yMatrix[i][j] = new Random().nextInt(100);
                System.out.printf("%4s", yMatrix[i][j]);
            }
            System.out.println();
        }
        System.out.println("X-Y:");
        for(int i = 0; i < xMatrix.length & i < yMatrix.length; i++){
            for(int j = 0; j < xMatrix[i].length & i < yMatrix[i].length ; j++){
                subMatrix[i][j] = xMatrix[i][j]-yMatrix[i][j];
                System.out.printf("%4s", subMatrix[i][j]);
            }
            System.out.println();
        }
    }
}

/* Beispielausführung
--------------------------------------
Eingabe:
4
5
--------------------------------------
Ausgabe:
Bitte Anzahl der Zeilen n eingeben: 4
Bitte Anzahl der Spalten m eingeben: 5
X:
  61   3  90  97  82
  94  31  17  96  41
  12  16  71   2  26
  71  78  84  18  28
Y:
  86  20  45  26  19
  60  37  78  10  54
  95  37  88  12   7
   8  85  64  99  77
X-Y:
 -25 -17  45  71  63
  34  -6 -61  86 -13
 -83 -21 -17 -10  19
  63  -7  20 -81 -49
--------------------------------------
 */