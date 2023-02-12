package de.niklas.control;
/**
 * <h1>Einmaleins</h1>
 * Ausgabe des 1x1 mithilfe einer verschachtelten Vorschleife
 *
 * @see "06_Kontrollstrukturen_Aufgaben.pdf"
 * @author Niklas Buse
 */
public class MultiplicationTable {
    public static void main(String[] args) {
        for(int i = 1; i <= 10; i++){               // Jede Zeile
            for(int j = 1; j <= 10; j++){           // Einträge pro Zeile
                System.out.printf("%4s", i*j);      // Ausgabe in der Matrix (Die 4 ist dafür, dass das Element 4 Zeichen lang ist
            }                                       //      wenn das nicht passt, wird mit Leerzeichen aufgefüllt.
            System.out.print("\n");                 // Zeilenumbruch
        }
    }
}

/* Beispielausführung
--------------------------------------
Eingabe: Keine
--------------------------------------
Ausgabe:
   1   2   3   4   5   6   7   8   9  10
   2   4   6   8  10  12  14  16  18  20
   3   6   9  12  15  18  21  24  27  30
   4   8  12  16  20  24  28  32  36  40
   5  10  15  20  25  30  35  40  45  50
   6  12  18  24  30  36  42  48  54  60
   7  14  21  28  35  42  49  56  63  70
   8  16  24  32  40  48  56  64  72  80
   9  18  27  36  45  54  63  72  81  90
  10  20  30  40  50  60  70  80  90 100
--------------------------------------
 */