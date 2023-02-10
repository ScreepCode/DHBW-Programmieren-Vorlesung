package control;
/**
 * <h1>Babylonisches Wurzelziehen (Heronverfahren)</h1>
 * Ein alter iterativer Algorithmus zur Bestimmung
 *   einer rationalen Näherung der Quadratwurzel einer Zahl
 *
 * @see "06_Kontrollstrukturen_Aufgaben.pdf"
 * @author Niklas Buse
 */
public class Babylon {
    public static void main(String[] args) {
        java.util.Scanner scan = new java.util.Scanner(System.in);
        System.out.print("Wurzel aus welcher Zahl ziehen? ");
        double zahl = scan.nextInt();
        double x1 = 0;
        double x2 = 1;
        while (Math.abs(x2-x1) > 0.000001){         // So lange, bis Unterschied kleiner als 10^-6 ist
            x1 = x2;
            x2 = (x1 + (zahl / x1)) /2;
            System.out.println(x2);
        };

        System.out.printf("Die Wurzel aus %.0f ist %.2f", zahl, x2);
    }
}

/* Beispielausführung
--------------------------------------
Eingabe: 143
--------------------------------------
Ausgabe:
72.0
36.99305555555556
20.429322972071002
13.714532729823066
12.070714129305212
11.95878456314772
11.958260754573612
11.958260743101398
Die Wurzel aus 143 ist 11,96
--------------------------------------
 */