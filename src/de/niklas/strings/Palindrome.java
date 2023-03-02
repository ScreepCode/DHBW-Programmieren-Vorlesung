package de.niklas.strings;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Bitte Wort eingeben: ");
        String eingabe = scan.next();

        StringBuffer ergebnis = new StringBuffer();
        for(int i = eingabe.length()-1; i >= 0; i--){
            ergebnis.append(eingabe.charAt(i));
        }
        System.out.printf("Umgekehrt: %s\n", ergebnis);

        System.out.printf("%s ist %s Palindrome",
                eingabe,
                (eingabe.equalsIgnoreCase(ergebnis.toString())? "ein": "kein")
        );
    }
}
