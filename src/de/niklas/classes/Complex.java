package de.niklas.classes;

import java.util.Random;

public class Complex {

    private double real;
    private double imag;

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public double getImag() {
        return imag;
    }

    public Complex add(Complex comp){ // (a + bi) + (c + di) = a + c + (b+d)i
        return new Complex(
                this.getReal() + comp.getReal(),
                this.getImag() + comp.getImag()
        );
    }

    public Complex sub(Complex comp){ // (a + bi) – (c + di) = a – c + (b–d)i
        return new Complex(
                this.getReal() - comp.getReal(),
                this.getImag() - comp.getImag()
        );
    }

    public Complex mult(Complex comp){ // (a + bi) * (c + di) = ac – bd + (ad + bc)i
        return new Complex(
                (this.getReal()*comp.getReal()) - (this.getImag()*comp.getImag()),
                (this.getReal()*comp.getImag()) + (this.getImag()*comp.getReal())
        );
    }

    public Complex div(Complex comp){ // (a + bi) * (c + di) = ac – bd + (ad + bc)i
        return new Complex(
                (this.getReal()*comp.getReal() + this.getImag()*comp.getImag())/(comp.getReal()*comp.getReal() + comp.getImag()*comp.getImag()),
                (this.getImag()*comp.getReal() - this.getReal()*comp.getImag())/(comp.getReal()*comp.getReal() + comp.getImag()*comp.getImag())
        );
    }

    public double getMagnitude(){
        return Math.sqrt(this.getReal()*this.getReal() + this.getImag()*this.getImag());
    }

    public boolean isLess(Complex comp2){
        return this.getMagnitude() < comp2.getMagnitude();
    }

//    bubblesort mit isLess

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
        for(Complex comp : array){                                           // Ausgeben des Arrays mit einer for-each
            outString += String.format("%.3f %s %.3f  Betrag: %.3f \n",
                    comp.getReal(), (comp.getImag() >= 0 ? "": "+"),  comp.getImag(), comp.getMagnitude());                                     // Der String wird um jedes Element des Arrays erweitert.
        }
        System.out.println(outString);

        for(int i = 0; i < array.length - 1; i++){                      // Diese Schleife sorgt dafür, dass jede Stelle von vorne nach hinten sortiert wird.
            for(int j = 0; j < array.length - i - 1; j++){              // Diese Stelle sorgt dafür, dass das entsprechende Element nach hinten durchgereicht wird.
                if(array[j].isLess(array[j+1])){                              // Vergleich, ob das Element höher als das Nachfolgende ist
                    Complex tmp = array[j];                                 // Wenn JA, dann wird über einen Dreischritt die beiden Elemente vertauscht (es geht effizienter, aber so geht es immer)
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }

        outString = "Sortiert:\n";
        for(Complex comp : array){                                           // Ausgeben des Arrays mit einer for-each
            outString += String.format("%.3f %s %.3f  Betrag: %.3f \n",
                    comp.getReal(), (comp.getImag() >= 0 ? "": "+"),  comp.getImag(), comp.getMagnitude());                                     // Der String wird um jedes Element des Arrays erweitert.
        }
        System.out.println(outString);
    }
}
