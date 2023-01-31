package arrays;

import java.util.Scanner;

public class Norm {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Bitte Anzahl der Elemente n eingeben: ");
        int elemente = scan.nextInt();

        int[] xse = new int[elemente];

        for(int i = 0; i < elemente; i++){
            System.out.printf("Bitte x_%d eingeben: ", i);
            xse[i] = scan.nextInt();
        }

        int tempSum = 0;
        for(int i = 0; i < elemente; i++){
            tempSum += xse[i]*xse[i];
        }

        double betrag = Math.sqrt(tempSum);
        System.out.printf("Der Betrag von x ist %.2f", betrag);
    }
}
