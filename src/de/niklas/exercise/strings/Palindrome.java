package de.niklas.exercise.strings;

import java.util.Scanner;

/**
 * <strong>Palindrom</strong><br>
 * Überprüfung, ob die Eingabe ein Palindrom ist
 *
 * @see "10_Strings_Aufgaben.pdf"
 * @author Niklas Buse
 */
public class Palindrome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Bitte Wort eingeben: ");
        String eingabe = scan.next();

        StringBuffer ergebnis = new StringBuffer();
        for(int i = eingabe.length()-1; i >= 0; i--){   // Hier wird der String von Hinten nach Vorne durchgegangen
            ergebnis.append(eingabe.charAt(i));
        }
        System.out.printf("Umgekehrt: %s\n", ergebnis);

        System.out.printf("%s ist %s Palindrome",
                eingabe,
                (eingabe.equalsIgnoreCase(ergebnis.toString())? "ein": "kein")  // Überprüfung ohne Beachtung der Großschreibung, ob es sich um ähnliche Strings handelt
        );
    }
}

/* Beispielausführung
--------------------------------------
Eingabe:
Anna
--------------------------------------
Ausgabe:
Bitte Wort eingeben: Anna
Umgekehrt: annA
Anna ist ein Palindrome
--------------------------------------
 */
