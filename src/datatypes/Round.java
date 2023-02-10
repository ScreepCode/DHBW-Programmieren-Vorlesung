package datatypes;
/**
 * <h1>Kaufmännisches Runden (1) & (2)</h1>
 * <li>Casten von Gleitkommazahlen -> Informationsverlust der Nachkommastelle; einfaches Abschneiden</li>
 * <li>Kaufmännisches Runden mit boolischen Ausdrücken -> ab 0,5 immer aufrunden</li>
 *
 * @see "04_Primitive_Datentypen_Aufgaben.pdf &
 *          05_Operatoren_Aufgaben.pdf"
 * @author Niklas Buse
 */
public class Round {

    public static void main(String[] args) {
        double pi = 3.1415926; // Naeherung der Kreiszahl Pi
        double e = 2.7182818; // Naeherung der Eulerschen Zahl e

        // Casten Positiver Zahlen
        System.out.println("Casten positiver Zahlen:");
        System.out.println("Pi ganzzahlig: " + (int) pi); // Ausgabe: 3
        System.out.println("e ganzzahlig: " + (int)e); // Ausgabe: 2

        // Casten Negativer Zahlen
        System.out.println("\nCasten negaitiver Zahlen:");
        System.out.println("-Pi ganzzahlig: " + (int) -pi); // Ausgabe: -3
        System.out.println("-e ganzzahlig: " + (int) -e); // Ausgabe: -2

        // Richtiges Runden korrekt
        System.out.println("\nRunden positiver & negativer Zahlen (korrekt):");
        int piInt = (pi > 0) ? (int)(pi + 0.5) : (int)(pi - 0.5); // Kaufmännisches Runden
        int eInt = (e > 0) ? (int)(e + 0.5) : (int)(e - 0.5);     // Kaufmännisches Runden

        System.out.println("Pi ganzzahlig: " + piInt); // Ausgabe: 3
        System.out.println("e ganzzahlig: " + eInt); // Ausgabe: 3

        pi = -pi;
        e = -e;
        piInt = (pi > 0) ? (int)(pi + 0.5) : (int)(pi - 0.5); // Kaufmännisches Runden
        eInt = (e > 0) ? (int)(e + 0.5) : (int)(e - 0.5);     // Kaufmännisches Runden

        System.out.println("-Pi ganzzahlig: " + piInt); // Ausgabe: 3
        System.out.println("-e ganzzahlig: " + eInt); // Ausgabe: 3

    }

}

/* Beispielausführung
--------------------------------------
Eingabe: Keine
--------------------------------------
Ausgabe:
Casten positiver Zahlen:
Pi ganzzahlig: 3
e ganzzahlig: 2

Casten negaitiver Zahlen:
-Pi ganzzahlig: -3
-e ganzzahlig: -2

Runden positiver & negativer Zahlen (korrekt):
Pi ganzzahlig: 3
e ganzzahlig: 3
-Pi ganzzahlig: -3
-e ganzzahlig: -3
--------------------------------------
 */