package de.niklas.control;

public class Quadratics {

    public static void main(String[] args) {
        java.util.Scanner scan = new java.util.Scanner(System.in);
        System.out.println("Quadratische Gleichung berechnen. Gebe deine Werte nacheinander ein:");
        System.out.println("a:");
        int a = scan.nextInt();
        System.out.println("b:");
        int b = scan.nextInt();
        System.out.println("c:");
        int c = scan.nextInt();

        int d = b * b - 4 * a * c;
        System.out.println(d);

        if(d == 0){
            System.out.println("Die Gleichung ist degeneriert.");
            System.out.printf("Die Lösung ist: %d\n", -(c/b));
        }
        else{
            System.out.println("Die Gleichung ist konjugiert komplex.");
            System.out.printf("Die Lösung ist x1: %f\n", (-b + Math.sqrt(d))/(2*a));
            System.out.printf("Die Lösung ist x2: %f\n", (-b - Math.sqrt(d))/(2*a));
        }

    }

}
