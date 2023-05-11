package de.niklas.exercise.classes;

import java.util.Random;

/**
 * <strong>Komplexe Zahlen</strong><br>
 * Diese Klasse stellt Rechenoperationen für Komplexe Zahlen
 *
 * @see "09_Klassen_Aufgaben-2.pdf"
 * @author Niklas Buse
 */
public class Complex {

    private double real;
    private double imag;

    /**
     * Erzeugen einer Komplexen Zahl
     *
     * @param real Realteil der Zahl
     * @param imag Imaginärteil der Zahl
     */
    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    /**
     * Rückgabe des Realteils einer Zahl
     * @return Realteil der Zahl
     */
    public double getReal() {
        return real;
    }

    /**
     * Rückgabe des Imaginärteils einer Zahl
     * @return Imaginärteils der Zahl
     */
    public double getImag() {
        return imag;
    }

    /**
     * Addieren von Komplexen Zahlen und dessen Rückgabe
     * @param comp dazu zu addierende Komplexe Zahl
     * @return Summe der Komplexen Zahlen
     */
    public Complex add(Complex comp){ // (a + bi) + (c + di) = a + c + (b+d)i
        return new Complex(
                this.getReal() + comp.getReal(),
                this.getImag() + comp.getImag()
        );
    }

    /**
     * Subtrahieren von Komplexen Zahlen und dessen Rückgabe
     * @param comp dazu zu subtrahierende Komplexe Zahl
     * @return Differenz der Komplexen Zahlen
     */
    public Complex sub(Complex comp){ // (a + bi) – (c + di) = a – c + (b–d)i
        return new Complex(
                this.getReal() - comp.getReal(),
                this.getImag() - comp.getImag()
        );
    }

    /**
     * Multiplikation von Komplexen Zahlen und dessen Rückgabe
     * @param comp dazu zu multiplizierende Komplexe Zahl
     * @return Produkt der Komplexen Zahlen
     */
    public Complex mult(Complex comp){ // (a + bi) * (c + di) = ac – bd + (ad + bc)i
        return new Complex(
                (this.getReal()*comp.getReal()) - (this.getImag()*comp.getImag()),
                (this.getReal()*comp.getImag()) + (this.getImag()*comp.getReal())
        );
    }

    /**
     * Division von Komplexen Zahlen und dessen Rückgabe
     * @param comp dazu zu dividierende Komplexe Zahl
     * @return Quotient der Komplexen Zahlen
     */
    public Complex div(Complex comp){ // (a + bi) * (c + di) = ac – bd + (ad + bc)i
        return new Complex(
                (this.getReal()*comp.getReal() + this.getImag()*comp.getImag())/(comp.getReal()*comp.getReal() + comp.getImag()*comp.getImag()),
                (this.getImag()*comp.getReal() - this.getReal()*comp.getImag())/(comp.getReal()*comp.getReal() + comp.getImag()*comp.getImag())
        );
    }

    /**
     * Rückgabe des Betrags der Komplexen Zahl
     * @return Betrag der komplexen Zahl
     */
    public double getMagnitude(){
        return Math.sqrt(this.getReal()*this.getReal() + this.getImag()*this.getImag());
    }

    /**
     * Rückgabe ob die Komplexe Zahl kleiner 2. Komplexe Zahl ist
     * @param comp2 2. Komplexe Zahl
     * @return Ob die Zahl kleiner ist
     */
    public boolean isLess(Complex comp2){
        return this.getMagnitude() < comp2.getMagnitude();
    }

    /**
     * Ausgabe der Komplexen Zahl im String
     * @return Komplexe Zahl als String
     */
    @Override
    public String toString() {
        return "Complex " + real + " " + imag + "i";
    }

    public static void main(String[] args) {
        Complex comp1 = new Complex(1.0, 2.0);
        Complex comp2 = new Complex(2.0, 1.0);
        System.out.println("C1: " + comp1);
        System.out.println("C2: " + comp2);
        System.out.println("C1+C2: " + comp1.add(comp2));
        System.out.println("C1-C2: " + comp1.sub(comp2));
        System.out.println("C1*C2: " + comp1.mult(comp2));
        System.out.println("C1/C2: " + comp1.div(comp2));
        System.out.println("C1<C2?: " + comp1.isLess(comp2));
//        System.out.println("Mag Test: " + new Complex(5.037, 8.190).getMagnitude());
        bubbleSort(10);
    }

    /**
     * Bubblesort von Komplexen Zahlen
     * @param anzahl Größe der zu sortierenden zufälligen Komplexen Zahlen
     */
    public static void bubbleSort(int anzahl){
        Complex[] array = new Complex[anzahl];
        Random r = new Random();

        for(int i = 0; i < anzahl; i++){
            array[i] = new Complex(
                    r.nextDouble()*20,
                    r.nextDouble()*20
            );
        }

        String outString = "Unortiert:\n";
        for(Complex comp : array){
            outString += String.format("%.3f %s %.3f  Betrag: %.3f \n",
                    comp.getReal(), (comp.getImag() >= 0 ? "": "+"),  comp.getImag(), comp.getMagnitude());                                     // Der String wird um jedes Element des Arrays erweitert.
        }
        System.out.println(outString);

        for(int i = 0; i < array.length - 1; i++){
            for(int j = 0; j < array.length - i - 1; j++){
                if(array[j+1].isLess(array[j])){
                    Complex tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }

        outString = "Sortiert:\n";
        for(Complex comp : array){
            outString += String.format("%.3f %s %.3f  Betrag: %.3f \n",
                    comp.getReal(), (comp.getImag() >= 0 ? "": "+"),  comp.getImag(), comp.getMagnitude());                                     // Der String wird um jedes Element des Arrays erweitert.
        }
        System.out.println(outString);
    }
}

/* Beispielausführung
--------------------------------------
Eingabe: Keine
--------------------------------------
Ausgabe:
C1: Complex 1.0 2.0i
C2: Complex 2.0 1.0i
C1+C2: Complex 3.0 3.0i
C1-C2: Complex -1.0 1.0i
C1*C2: Complex 0.0 5.0i
C1/C2: Complex 0.8 0.6i
C1<C2?: false
Unortiert:
17,234  11,894  Betrag: 20,940
17,411  10,613  Betrag: 20,391
19,292  4,577  Betrag: 19,828
13,493  0,469  Betrag: 13,501
15,291  10,027  Betrag: 18,285
14,845  8,331  Betrag: 17,023
3,683  2,858  Betrag: 4,662
2,596  2,490  Betrag: 3,598
12,049  2,316  Betrag: 12,270
17,825  6,736  Betrag: 19,055

Sortiert:
2,596  2,490  Betrag: 3,598
3,683  2,858  Betrag: 4,662
12,049  2,316  Betrag: 12,270
13,493  0,469  Betrag: 13,501
14,845  8,331  Betrag: 17,023
15,291  10,027  Betrag: 18,285
17,825  6,736  Betrag: 19,055
19,292  4,577  Betrag: 19,828
17,411  10,613  Betrag: 20,391
17,234  11,894  Betrag: 20,940
--------------------------------------
 */
