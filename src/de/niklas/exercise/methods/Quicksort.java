package de.niklas.exercise.methods;

import java.util.Arrays;
import java.util.Random;

/**
 * <strong>Quicksort*</strong><br>
 * Sortierung eines Integer Arrays mit dem Quicksort Algorithmus
 * Für genaue Details zur Funktionsweise ins Aufgabenblatt gucken
 * Die Algorithmusbeschreibung entstammt dem Aufgabenblatt
 *
 * @see "11_Methoden-Special_Aufgaben.pdf"
 * @author Niklas Buse
 */
public class Quicksort {

    int[] data;

    /**
     *
     * @param array zu sortierende Zahlen
     */
    public static void sort(int[] array){
        Quicksort qs = new Quicksort();
        qs.data = array;
        qs.quicksort(0, array.length-1);    // Am Anfang werden beide Grenzen einmalig Übergeben
    }

    /**
     * Anfang der Sortierung von einem eingegebenen Array
     * @param left  Linke Grenze
     * @param right Rechte Grenze
     */
    private void quicksort(int left, int right){
        if(left < right){
            int teiler =  teile(left, right);
            quicksort(left, teiler-1);
            quicksort(teiler+1, right);
        }
    }

    /**
     * Teilschritte des Algorithmus
     * @param left Linke Grenze
     * @param right Rechte Grenze
     * @return Position des Pivotelements
     */
    private int teile(int left, int right){
        // Ziel ist es hier, das Array in zwei Teile zu teilen.
        // Dazu wählen wir ein Pivotelement, mit dem wir alle Elemente des
        // Arrays vergleichen. Wir legen die beiden Teile des Arrays so an,
        // dass der linke alle kleineren Elemente enthält, der rechte Teil
        // alle größeren.
        // Wir tauschen hierzu, falls notwendig nicht passende Elemente.
        // wähle rechtes Element als Pivotelement aus
        // und starte mit j links vom Pivotelement

        int i = left;
        int j = right-1;
        int pivot = data[right];

        do{
            // Suche von links ein Element, das größer als das Pivot ist
            for(; data[i] <= pivot && i < right; i++);

            // Suche von rechts ein Element, das kleiner als das Pivot ist
            for(; data[j] >= pivot && j > left; j--);

            if(i < j){
                int tmp = data[i];
                data[i] = data[j];
                data[j] = tmp;
            }
        }while(i < j); // solange i an j nicht vorbeigelaufen ist

        // Tausche das Pivotelement mit seiner endgültigen Position i
        if(data[i] > pivot){
            int tmp = data[i];
            data[i] = data[right];
            data[right] = tmp;
        }

        return i; // gib die Position des Pivotelements zurück
    }

    public void swap(int i, int j){
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    public static void main(String[] args) {
        int[] unsortedArr = new int[new Random().nextInt(2, 100)];
        for(int i = 0; i < unsortedArr.length-1; i++){
            unsortedArr[i] = new Random().nextInt(1, 100);
        }
        System.out.println("Unsortiert: " + Arrays.toString(unsortedArr));
        sort(unsortedArr);
        System.out.println("Sortiert:   " + Arrays.toString(unsortedArr));
    }
}

/* Beispielausführung
--------------------------------------
Eingabe: Keine
--------------------------------------
Ausgabe:
Unsortiert: [66, 66, 17, 99, 68, 5, 6, 55, 98, 96, 78, 9, 83, 7, 16, 71, 53, 33, 8, 88, 5, 72, 48, 32, 34, 7, 6, 17, 71, 74, 94, 43, 91, 68, 54, 91, 83, 75, 49, 4, 21, 34, 57, 1, 41, 1, 22, 5, 64, 13, 45, 25, 20, 4, 50, 9, 72, 7, 69, 86, 63, 84, 79, 23, 74, 20, 35, 5, 12, 32, 88, 8, 83, 1, 96, 76, 50, 3, 25, 30, 44, 76, 5, 60, 42, 4, 92, 78, 36, 59, 6, 86, 51, 24, 43, 27, 38, 82, 0]
Sortiert:   [0, 1, 1, 1, 3, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 9, 9, 12, 13, 16, 17, 17, 20, 20, 21, 22, 23, 24, 25, 25, 27, 30, 32, 32, 33, 34, 34, 35, 36, 38, 41, 42, 43, 43, 44, 45, 48, 49, 50, 50, 51, 53, 54, 55, 57, 59, 60, 63, 64, 66, 66, 68, 68, 69, 71, 71, 72, 72, 74, 74, 75, 76, 76, 78, 78, 79, 82, 83, 83, 83, 84, 86, 86, 88, 88, 91, 91, 92, 94, 96, 96, 98, 99]
--------------------------------------
 */

