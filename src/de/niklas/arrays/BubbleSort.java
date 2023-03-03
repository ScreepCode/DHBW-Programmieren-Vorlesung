package de.niklas.arrays;

import java.util.Scanner;
/**
 * <strong>Bubblesort</strong><br>
 * Integration des Bubblesort Algorithmus. Kurzerklärung: Nebeneinanderliegende Elemente vergleichen und ggf. tauschen.
 *
 * @see "07_Arrays_Aufgaben-1.pdf"
 * @author Niklas Buse
 */
public class BubbleSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Bitte Anzahl der Elemente n eingeben: ");
        int elemente = scan.nextInt();                                  // Einlesen, wie viele Zahlen sortiert werden sollen

        int[] array = new int[elemente];

        for(int i = 0; i < elemente; i++){
            System.out.printf("Zahl %d eingeben: ", i);
            array[i] = scan.nextInt();                                  // Einlesen der Zahlen
        }

        for(int i = 0; i < array.length - 1; i++){                      // Diese Schleife sorgt dafür, dass jede Stelle von vorne nach hinten sortiert wird.
            for(int j = 0; j < array.length - i - 1; j++){              // Diese Stelle sorgt dafür, dass das entsprechende Element nach hinten durchgereicht wird.
                if(array[j] > array[j+1]){                              // Vergleich, ob das Element höher als das Nachfolgende ist
                    int tmp = array[j];                                 // Wenn JA, dann wird über einen Dreischritt die beiden Elemente vertauscht (es geht effizienter, aber so geht es immer)
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }

        String outString = "Sortiert: ";
        for(int val : array){                                           // Ausgeben des Arrays mit einer for-each
            outString += val + " ";                                     // Der String wird um jedes Element des Arrays erweitert.
        }

        System.out.println(outString);

    }
}

/* Beispielausführung
--------------------------------------
Eingabe:
5
5
4
3
2
1
--------------------------------------
Ausgabe:
Bitte Anzahl der Elemente n eingeben: 5
Zahl 0 eingeben: 5
Zahl 1 eingeben: 4
Zahl 2 eingeben: 3
Zahl 3 eingeben: 2
Zahl 4 eingeben: 1
Sortiert: 1 2 3 4 5
--------------------------------------
 */