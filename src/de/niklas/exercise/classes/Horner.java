package de.niklas.exercise.classes;

/**
 * <strong>Polynome und Horner-Schema</strong><br>
 * Implementation des Horner-Schema für einen beliebigen Grad des Polynoms
 *
 * @see "09_Klassen_Aufgaben-2.pdf"
 * @author Niklas Buse
 */
public class Horner {
    private double[] koeffizienten;

    /**
     * Eingabe der Koeffizienten für das Polynom;
     * gestartet wird mit Koeffizienten der niedrigsten Potenz
     * @param koeffizienten Koeffizient
     */
    public Horner(double ... koeffizienten){
        this.koeffizienten = koeffizienten;
    }

    /**
     * Berechnen des Funktionswerts mit dem Horner-Schema
     * @param x x-Wert
     * @return Funktionswert der Funktion für x
     */
    public double getValue(double x){
        double result = 0;
        for(int i = koeffizienten.length - 1; i >= 0; i--) {
            result = koeffizienten[i] + result * x;
        }
        return result;
    }

    /**
     * Ausgabe des Polynoms
     * @return Polynom als String
     */
    @Override
    public String toString() {
        String out = "";
        for(int i = koeffizienten.length - 1; i >= 0; i--){
            out += (koeffizienten[i] >= 0 ? "+": "") + koeffizienten[i] + "*x^" + i + " ";
        }
        return "Polynomial f: " + out.substring(1);
    }

    public static void main(String[] args) {
        Horner h1 = new Horner(1.0, -2.0, 3.0, 4.5, 8.0, -10.0, 3.0, 4.0, 2.0, -3.0, 0.5);
        System.out.println(h1);
        System.out.println("f(1.5) = " + h1.getValue(1.5));
    }
}

/* Beispielausführung
--------------------------------------
Eingabe: Keine
--------------------------------------
Ausgabe:
Polynomial f: 0.5*x^10 -3.0*x^9 +2.0*x^8 +4.0*x^7 +3.0*x^6 -10.0*x^5 +8.0*x^4 +4.5*x^3 +3.0*x^2 -2.0*x^1 +1.0*x^0
f(1.5) = 51.77587890625
--------------------------------------
 */
