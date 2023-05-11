package de.niklas.exercise.methods;

import java.util.Scanner;

/**
 * <strong>Potenzen</strong><br>
 * Berechnung der Potenzen mit rekursiven Algorithmus
 *
 * @see "11_Methoden-Special_Aufgaben.pdf"
 * @author Niklas Buse
 */
public class Exponentiation {

    /**
     * Rekursive Methode zur Berechnung von Potenzen
     * @param x Basis der Zahl
     * @param n Exponent der Zahl
     * @return Rückgabe der potenzierten Zahl
     */
    public static double xPowerN(double x, int n){
        if(n == 0){                         // Wenn einfachste Form der Rekursion erreicht
            return 1;
        }
        else {
            return x * xPowerN(x, n-1);     // Vereinfachung des Rekursionsschritt
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Geben Sie bitte die Basis ein: ");
        double basis = scan.nextDouble();

        System.out.print("Geben Sie bitte den positiven ganzzahligen Exponenten ein: ");
        int exponent = scan.nextInt();

        double result = xPowerN(basis, exponent);
        System.out.printf("%.1f^ %d = %.1f", basis, exponent, result);
    }

}

/* Beispielausführung
--------------------------------------
Eingabe:
3,0
3
--------------------------------------
Ausgabe:
Geben Sie bitte die Basis ein: 3,0
Geben Sie bitte den positiven ganzzahligen Exponenten ein: 3
3,0^ 3 = 27,0
--------------------------------------
 */

