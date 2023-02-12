package de.niklas.arrays;
/**
 * <h1>Pascalsches Dreieck</h1>
 * Berechnung: Die "drüber liegenden Elemente" ergeben addiert das unterliegende + Randzahlen = 1
 *
 * @see "07_Arrays_Aufgaben-2.pdf"
 * @author Niklas Buse
 */
public class Pascal {
    public static void main(String[] args) {
        int zeilenAnzahl = 9;                                                           // Unser Dreieck soll 9 Zeilen sein
        int[][] pascalDreieck = new int[zeilenAnzahl][zeilenAnzahl];                    // Wir erstellen uns eine quadratische Matrix, um die höchsten Inhalte haben zu können
        pascalDreieck[0][0] = 1;                                                        // Erste Element ist 1

        for(int i = 0; i < zeilenAnzahl; i++){                                          // Jede Zeile hat so viele Elemente wie Anzahl der Zeile von oben gezählt
            pascalDreieck[i][0] = 1;                                                    // Erste Element (Rand) = 1
            for(int j = 1; j <= i; j++){
                pascalDreieck[i][j] = pascalDreieck[i-1][j-1] + pascalDreieck[i-1][j];  // Berechnung der einzelnen Einträge auf Grundlage darüber liegenden Elemente
            }                                                                           //  Notiz: Integer die keinen neuen Wert haben = 0; heißt jedes Ende der Zeile wird durch 1 (vorheriger Rand) + 0 erzeugt
        }

        for(int i = 0; i < zeilenAnzahl; i++){                                          // Jede Zeile wird durchlaufen, um das Dreieck auszugeben
            for(int j = 0; j < zeilenAnzahl - i; j++) {                                 // Hier werden die vorstehenden Leerzeichen generiert für eine schöne Ansicht. (bis zu 20 Zeilen!)
                System.out.print("  ");
            }
            for(int j = 0; j <= i; j++){                                                // Nacheinander die Ausgabe der Elemente, die besetzt sind (bsp. 8. Zeile = 8 Elemente)
                System.out.printf("%4s", pascalDreieck[i][j]);                          // Jede Zahl wird auf 6 Stellen mit Leerzeichen getrennt für optimale Darstellung (bis zu 20 Zeilen!)
            }                                                                           //      (durch ausprobieren)
            System.out.println();                                                       // Zeilenumbruch (am Ende werden keine Leerzeichen benötigt)
        }
    }                                                                                   // Wenn nur kleinere Dreiecke wie 9 Zeilen gebraucht wird, kann die Anzahl der Leerzeichen (Z. 24) und die Anzahl der Auffüllungen
}                                                                                       //      verkleinert werden. Richtlinie: Leerzeichen = n & Auffüllen = n*2 (sinnvoll für n >= 2)
                                                                                        //      Damit gerne probieren ^^
/* Beispielausführung
--------------------------------------
Eingabe: Keine
--------------------------------------
Ausgabe:
                                1
                             1     1
                          1     2     1
                       1     3     3     1
                    1     4     6     4     1
                 1     5    10    10     5     1
              1     6    15    20    15     6     1
           1     7    21    35    35    21     7     1
        1     8    28    56    70    56    28     8     1
--------------------------------------
 */