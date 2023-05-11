package de.niklas.exercise.classes;

import java.util.Arrays;

/**
 * <strong>Polynom 2. Grades</strong><br>
 * Diese Klasse stellt einige Operationen für Polynome 2. Gerades zur Verfügung
 * Dazu zählen einige einfache Rechenoperationen und die Nullpunktbestimmung
 *
 * @see "09_Klassen_Aufgaben-2.pdf"
 * @author Niklas Buse
 */
public class Polynomial {

    private double a, b, c;

    /**
     * Erzeugen eines Polynoms des 2. Gerades
     * @param a Faktor A
     * @param b Faktor B
     * @param c Faktor C
     */
    public Polynomial(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Rückgabe des Faktors A
     * @return Faktor A
     */
    public double getA() {
        return a;
    }

    /**
     * Rückgabe des Faktors B
     * @return Faktor B
     */
    public double getB() {
        return b;
    }

    /**
     * Rückgabe des Faktors C
     * @return Faktor C
     */
    public double getC() {
        return c;
    }

    /**
     * Ausgabe der Funktion als String
     * @return Funktion als String
     */
    @Override
    public String toString() {
        return String.format("%.1fx²%s%.1fx%s%.1f",
                this.getA(),
                (this.getB() >= 0 ? " + ": " "), this.getB(),   // Hier wird jeweils entschieden, ob in dem String ein "+" für eine positive Zahl hinzugefügt werden muss,
                (this.getC() >= 0 ? " + ": " "), this.getC()    //  denn negative Zahlen haben automatisch ein "-"
        );
//        return String.format("%.1fx^2 + %.1fx + %.1f", a, b, c); // Hier die Vereinfachte Version, wo es aber zu einem "+ -" kommen kann
    }

    /**
     * Berechnung und Rückgabe des Funktionswerts für das eingegebene x
     * @param x x-Wert
     * @return Funktionswert
     */
    public double calculateFunctionValue(double x){
        return this.getA() * (x*x) + this.getB() * x + this.getC();
    }

    /**
     * Dazu addieren von einem anderen Polynom und Rückgabe des daraus resultierendem
     * @param p2 zu addierendes Polynom
     * @return Rückgabe des neuen Polynoms
     */
    public Polynomial addPolynomial(Polynomial p2){
        return new Polynomial(
                this.getA() + p2.getA(),
                this.getB() + p2.getB(),
                this.getC() + p2.getC()
        );
    }

    /**
     * Davon subtrahieren von einem anderen Polynom und Rückgabe des daraus resultierendem
     * @param p2 zu subtrahierendes Polynom
     * @return Rückgabe des neuen Polynoms
     */
    public Polynomial subPolynomial(Polynomial p2){
        return new Polynomial(
                this.getA() - p2.getA(),
                this.getB() - p2.getB(),
                this.getC() - p2.getC()
        );
    }

    /**
     * Dazu multiplizieren von einem Skalar und Rückgabe des daraus resultierendem
     * @param scalar zu multiplizierendem Skalar
     * @return Rückgabe des neuen Polynoms
     */
    public Polynomial multiplyPolynomial(double scalar){
        return new Polynomial(
                this.getA() * scalar,
                this.getB() * scalar,
                this.getC() * scalar
        );
    }

    /**
     * Berechnung der Nullpunkte mithilfe der P-Q-Formel
     * @return Array mit Nullpunkten
     */
    public double[] calculateRootsPQ(){
        double x1, x2;
        int length = 2;
        x1 = (((-1) * this.getB() + Math.sqrt((this.getB() * this.getB()) - (4 * this.getA() * this.getC())))/ (2 * this.getA()));
        x2 = (((-1) * this.getB() - Math.sqrt((this.getB() * this.getB()) - (4 * this.getA() * this.getC())))/ (2 * this.getA()));
        if (Double.isNaN(x1) & Double.isNaN(x2)) {
            length = 0;
        }
        else if (x1 == x2) {
            length = 1;
        }
        else {
            length = 2;
        }
        double[] werte = new double[length];
        if (length == 1) {
            werte[0] = x1;
        }
        else if (length == 2) {
            werte[0] = x1;werte[1] = x2;
        }
        return werte;
    }

    /**
     * Berechnung der Nullpunkte mithilfe der A-B-C-Formel
     * @return Array mit Nullpunkten
     */
    public double[] calculateRootsABC(){
        double discriminant = this.getB() * this.getB() - 4 * this.getA() * this.getC();
        if(discriminant >= 0){
            double[] roots = new double[]{
                    (-this.getB() + Math.sqrt(discriminant)) / (2*this.getA()),
                    (-this.getB() - Math.sqrt(discriminant)) / (2*this.getA())
            };
            if(roots[0] != roots[1]){
                return roots;
            }
            else{
                return new double[]{roots[0]};
            }
        }
        else{
            return new double[0];
        }
    }


    public static void main(String[] args) {
        Polynomial poly1 = new Polynomial(2.0, 0.0, 0.0);
        Polynomial poly2 = new Polynomial(0.0, -4.0, 1.0);
        System.out.println("P1: " + poly1);
        System.out.println("P2: " + poly2);
        Polynomial poly3 = poly1.addPolynomial(poly2);
        System.out.println("P3 = P1 + P2: " + poly3);
        poly3 = poly3.multiplyPolynomial(2);
        System.out.println("P3 = 2.0 * P3: " + poly3);
        double[] rootsPQ = poly3.calculateRootsPQ();
        double[] rootsABC = poly3.calculateRootsPQ();

        String rootString = "";
        for(double root : rootsPQ){
            rootString += root + " ";
        }
        System.out.println("Nullstellen von P3 mit PQ(" + poly3 +"): \n" + rootString);
        System.out.println("Nullstellen von P3 mit ABC(" + poly3 +"): \n" + Arrays.toString(rootsABC));
    }
}

/* Beispielausführung
--------------------------------------
Eingabe: Keine
--------------------------------------
Ausgabe:
P1: 2,0x² + 0,0x + 0,0
P2: 0,0x² -4,0x + 1,0
P3 = P1 + P2: 2,0x² -4,0x + 1,0
P3 = 2.0 * P3: 2,0x² -4,0x + 1,0
Nullstellen von P3 mit PQ(2,0x² -4,0x + 1,0):
1.7071067811865475 0.2928932188134524
Nullstellen von P3 mit ABC(2,0x² -4,0x + 1,0):
[1.7071067811865475, 0.2928932188134524]
--------------------------------------
 */
