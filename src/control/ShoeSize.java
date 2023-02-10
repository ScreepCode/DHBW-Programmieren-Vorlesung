package control;
/**
 * <h1>Schuhgrößen</h1>
 * <li>Umrechnen von Zentimeter in Schuhgröße (EU)</li>
 * <li>Rechnung: Schuhgröße = Zentimeter * 1,5</li>
 * <li>(Zusatz: Möglichst wenig zwischenspeichern</li>
 *
 * @see "06_Kontrollstrukturen_Aufgaben.pdf"
 * @author Niklas Buse
 */
public class ShoeSize {
    public static void main(String[] args) {
        double zentimeter = 19.33;          // Startwert

        System.out.print("Zentimeter    | Größe\n" + "--------------+------\n");
        for(int shoeSize = 30; shoeSize <= 49; shoeSize++){
            System.out.printf("%.2f - %.2f | %d %n", (shoeSize-1)/1.5, shoeSize/1.5, shoeSize); // Ausgabe der Zentimeter auf 2 Nachkommastellen
        }
    }
}

/* Beispielausführung
--------------------------------------
Eingabe: Keine
--------------------------------------
Ausgabe:
Zentimeter    | Größe
--------------+------
19,33 - 20,00 | 30
20,00 - 20,67 | 31
20,67 - 21,33 | 32
21,33 - 22,00 | 33
22,00 - 22,67 | 34
22,67 - 23,33 | 35
23,33 - 24,00 | 36
24,00 - 24,67 | 37
24,67 - 25,33 | 38
25,33 - 26,00 | 39
26,00 - 26,67 | 40
26,67 - 27,33 | 41
27,33 - 28,00 | 42
28,00 - 28,67 | 43
28,67 - 29,33 | 44
29,33 - 30,00 | 45
30,00 - 30,67 | 46
30,67 - 31,33 | 47
31,33 - 32,00 | 48
32,00 - 32,67 | 49
--------------------------------------
 */