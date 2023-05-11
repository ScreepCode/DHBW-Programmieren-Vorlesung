package de.niklas.exercise.strings;

import java.util.Scanner;

/**
 * <strong>Quersumme</strong><br>
 * Einlesen einer Zahl und Ausgabe der Quersumme
 *
 * @see "10_Strings_Aufgaben.pdf"
 * @author Niklas Buse
 */
public class CrossTotal {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Bitte Zahl für Quersumme eingeben: ");
        String eingabe = scan.next();
        int ergebnis = 0;
        for(int i = 0; i < eingabe.length(); i++){
//            String zifferAlsString = ""+eingabe.charAt(i);        // Hier ist die Lösung mit Wandlung vom char -> String -> Zahl
//            ergebnis += Integer.valueOf(zifferAlsString);
            ergebnis += eingabe.charAt(i) - '0';                    // Hier ist die Lösung mit Wert des Chars - den Wert der ersten Ziffer (0), Rest ist der Ziffernwert
        }
        System.out.printf("Die Quersumme von %s ist %d.", eingabe, ergebnis);
    }
}

/* Beispielausführung
--------------------------------------
Eingabe:
369246
--------------------------------------
Ausgabe:
Bitte Zahl für Quersumme eingeben: 369246
Die Quersumme von 369246 ist 30.
--------------------------------------
 */
