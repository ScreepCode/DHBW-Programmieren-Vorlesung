package de.niklas.exercise.arrays;

import java.util.Scanner;
/**
 * <strong>Skalarprodukt zweier Vektoren</strong><br>
 * Einlesen von 2 Vektoren mit vorher angegebener Komponenten Anzahl; Ausgabe von dessen Skalarprodukt
 *
 * @see "07_Arrays_Aufgaben-1.pdf"
 * @author Niklas Buse
 */
public class DotProduct {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Bitte Anzahl der Elemente n eingeben: ");
        int elemente = scan.nextInt();                          // Einlesen der Komponenten der Vektoren

        int[] xse = new int[elemente];                          // Hier werden die Arrays entsprechender
        int[] yse = new int[elemente];                          //      länge generiert

        for(int i = 0; i < elemente; i++){
            System.out.printf("Bitte x_%d eingeben: ", i);
            xse[i] = scan.nextInt();                            // Einlesen der X Werte
        }

        for(int i = 0; i < elemente; i++){
            System.out.printf("Bitte y_%d eingeben: ", i);
            yse[i] = scan.nextInt();                            // Einlesen der Y Werte
        }

        int dotProdukt = 0;
        for(int i = 0; i < elemente; i++){                      // Hier werden alle Einzelmultiplikation aufgerufen
            dotProdukt += xse[i]*yse[i];
        }

        System.out.printf("Das Skalarprodukt von x und y ist %d", dotProdukt);
    }
}

/* Beispielausführung
--------------------------------------
Eingabe:
3
5
3
1
-2
4
9
--------------------------------------
Ausgabe:
Bitte Anzahl der Elemente n eingeben: 3
Bitte x_0 eingeben: 5
Bitte x_1 eingeben: 3
Bitte x_2 eingeben: 1
Bitte y_0 eingeben: -2
Bitte y_1 eingeben: 4
Bitte y_2 eingeben: 9
Das Skalarprodukt von x und y ist 11
--------------------------------------
 */