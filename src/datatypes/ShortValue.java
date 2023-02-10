package datatypes;
/**
 * <h1>Überlauf, Zweierkomplement</h1>
 * <li>32767 als Short-Value initialisieren, Wert auf über Maximum erhöhen.</li>
 *
 * @see "04_Primitive_Datentypen_Aufgaben.pdf"
 * @author  Niklas Buse
 */
public class ShortValue {
    public static void main(String[] args) {
        short s = 32767;                    // Maximale Zahl, die ein Short aufnehmen kann
        System.out.println("val: " + s);    // Ausgabe: val: 32767
        s += 1;                             // Maximale Zahl erhört -> führt zum Überlauf des Values
        System.out.println("val+1: " + s);  // Ausgabe: val+1: -32768
    }

}

/* Beispielausführung
--------------------------------------
Eingabe: Keine
--------------------------------------
Ausgabe:
val: 32767
val+1: -32768
--------------------------------------
 */
