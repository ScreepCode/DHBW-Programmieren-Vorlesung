package de.niklas.exercise.strings;

import java.util.Scanner;

/**
 * <strong>Römische Zahlen</strong><br>
 * Umwandlung von gültigen Römischen Zahlen ins Dezimalsystem
 *
 * @see "10_Strings_Aufgaben.pdf"
 * @author Niklas Buse
 */
public class RomanNumber {

    public RomanNumber(){
        String romanNumberString = readRomanNumber();                                   // Einlesen
        String rightNumberString = convertToRightNumber(romanNumberString);             // Umwandlung in Zahlen
        int solution = convertToInteger(rightNumberString);                             // Zusammenrechnen
        System.out.printf("Der Wert der Zahl %s ist %s", romanNumberString, solution);  // Ausgabe
    }

    /**
     * Einlesen der römischen Zahl und dessen Rückgabe
     * @return Eingelesene römische Zahl
     */
    public String readRomanNumber(){
        System.out.print("Bitte geben Sie eine röm. Zahl ein: ");
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    /**
     * Umwandlung der römischen Zahl in Dezimalzahlen ohne zusammen zurechnen
     * @param romanNumberString römische Zahl
     * @return String mit den umgewandelten Zahlen; Format: "[Zahl] [Zahl]..."
     */
    public String convertToRightNumber(String romanNumberString){
        String convertNumber = romanNumberString;
        convertNumber = convertNumber.replaceAll("IV", " 4 ");      // Erst die Differenzen, dann die einzelnen Zahlen
        convertNumber = convertNumber.replaceAll("IX", " 9 ");
        convertNumber = convertNumber.replaceAll("XL", " 40 ");
        convertNumber = convertNumber.replaceAll("XC", " 90 ");
        convertNumber = convertNumber.replaceAll("CD", " 400 ");
        convertNumber = convertNumber.replaceAll("CM", " 900 ");

        convertNumber = convertNumber.replaceAll("I", " 1 ");
        convertNumber = convertNumber.replaceAll("X", " 10 ");
        convertNumber = convertNumber.replaceAll("L", " 50 ");
        convertNumber = convertNumber.replaceAll("C", " 100 ");
        convertNumber = convertNumber.replaceAll("D", " 500 ");
        convertNumber = convertNumber.replaceAll("M", " 1000 ");

        convertNumber = convertNumber.replaceAll("  ", " ");    // Ersetzen von Doppellücken zu einfachen Lücken

        return convertNumber;
    }

    /**
     * Umrechnung und Zusammenrechnens des Zahlenstring
     * @param numberString String aus Nummer, getrennt mit Leerzeichen
     * @return Umgewandelte Zahl
     */
    public int convertToInteger(String numberString){
        String[] numberArr = numberString.split(" ");   // Split zum Array an jedem Leerzeichen
        int solution = 0;

        for(int i = 1; i < numberArr.length; i++){            // Durchgehen des Arrays; ACHTUNG: Start bei 1, da am Anfang eine Lücke bleibt
            solution += Integer.parseInt(numberArr[i]);
        }
        return solution;
    }

    public static void main(String[] args) {
        new RomanNumber();
    }
}

/* Beispielausführung
--------------------------------------
Eingabe:
MCMLXXXIV
--------------------------------------
Ausgabe:
Bitte geben Sie eine röm. Zahl ein: MCMLXXXIV
Der Wert der Zahl MCMLXXXIV ist 1984
--------------------------------------
 */
