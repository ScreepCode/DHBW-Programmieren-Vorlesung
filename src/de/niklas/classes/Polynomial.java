package de.niklas.classes;

import java.util.Arrays;

public class Polynomial {

    private double a, b, c;

    public Polynomial(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    @Override
    public String toString() {
        return String.format("%.1fx²%s%.1fx%s%.1f",
                this.getA(),
                (this.getB() >= 0 ? " + ": " "), this.getB(),
                (this.getC() >= 0 ? " + ": " "), this.getC()
        );
//        return String.format("%.1fx^2 + %.1fx + %.1f", a, b, c);
    }

    public double calculateFunctionValue(double x){
        return this.getA() * (x*x) + this.getB() * x + this.getC();
    }

    public Polynomial addPolynomial(Polynomial p2){
        return new Polynomial(
                this.getA() + p2.getA(),
                this.getB() + p2.getB(),
                this.getC() + p2.getC()
        );
    }

    public Polynomial subPolynomial(Polynomial p2){
        return new Polynomial(
                this.getA() - p2.getA(),
                this.getB() - p2.getB(),
                this.getC() - p2.getC()
        );
    }

    public Polynomial multiplyPolynomial(double scalar){
        return new Polynomial(
                this.getA() - scalar,
                this.getB() - scalar,
                this.getC() - scalar
        );
    }

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
        poly3.multiplyPolynomial(2);
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

