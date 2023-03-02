package de.niklas.strings;

import java.util.Scanner;

public class CrossTotal {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Bitte Zahl für Quersumme eingeben: ");
        String eingabe = scan.next();
        int ergebnis = 0;
        for(int i = 0; i < eingabe.length(); i++){
//            String zifferAlsString = ""+eingabe.charAt(i);
//            ergebnis += Integer.valueOf(zifferAlsString);
            ergebnis += eingabe.charAt(i) - '0';
        }
        System.out.printf("Die Quersumme von %s ist %d.", eingabe, ergebnis);
    }
}
