package de.niklas.classes;

import java.util.Arrays;

public class Horner {
    private double[] koeffizienten;
    public Horner(double ... koeffizienten){
        this.koeffizienten = koeffizienten;
    }

    public double getValue(double x){
        double result = 0;
        for(int i = koeffizienten.length - 1; i >= 0; i--) {
            result = koeffizienten[i] + result * x;
        }
        return result;
    }

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
        System.out.println(h1.toString());
        System.out.println("f(1.5) = " + h1.getValue(1.5));
    }
}
