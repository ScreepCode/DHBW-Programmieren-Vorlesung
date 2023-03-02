package de.niklas.methods;

import java.util.Scanner;

public class Exponentiation {

    public static double xPowerN(double x, int n){
        if(n == 0){
            return 1;
        }
        else {
            return x * xPowerN(x, n-1);
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
