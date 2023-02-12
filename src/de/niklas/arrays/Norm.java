package de.niklas.arrays;
import java.util.Scanner;
/**
 * <h1>Betrag eines Vektors</h1>
 * Einlesen der Anzahl der Vektorkomponenten und Ausgabe von dem Betrag (auf zwei Nachkommastellen gerundet)
 *
 * @see "07_Arrays_Aufgaben-1.pdf"
 * @author Niklas Buse
 */
public class Norm {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Bitte Anzahl der Elemente n eingeben: ");
        int elemente = scan.nextInt();                              // Einlesen der Komponenten Zahl

        int[] xse = new int[elemente];                              // Ein Array dieser Länge erstellt

        for(int i = 0; i < elemente; i++){
            System.out.printf("Bitte x_%d eingeben: ", i);
            xse[i] = scan.nextInt();                                // Die stellen nacheinander Füllen
        }

        int tempSum = 0;
        for(int i = 0; i < elemente; i++){
            tempSum += xse[i]*xse[i];                               // Berechnen der Summe unter der Wurzel
        }

        double betrag = Math.sqrt(tempSum);                         // Von der Summe die Wurzel ziehen
        System.out.printf("Der Betrag von x ist %.2f", betrag);     // Ausgabe mit Ergebnis auf 2 Nachkommastellen gerundet
    }
}

/* Beispielausführung
--------------------------------------
Eingabe:
1
2
4
--------------------------------------
Ausgabe:
Bitte Anzahl der Elemente n eingeben: 3
Bitte x_0 eingeben: 1
Bitte x_1 eingeben: 2
Bitte x_2 eingeben: 4
Der Betrag von x ist 4,58
--------------------------------------
 */