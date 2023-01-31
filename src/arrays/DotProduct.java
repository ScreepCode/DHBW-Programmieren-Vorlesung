package arrays;

import java.util.Scanner;

public class DotProduct {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Bitte Anzahl der Elemente n eingeben: ");
        int elemente = scan.nextInt();

        int[] xse = new int[elemente];
        int[] yse = new int[elemente];

        for(int i = 0; i < elemente; i++){
            System.out.printf("Bitte x_%d eingeben: ", i);
            xse[i] = scan.nextInt();
        }

        for(int i = 0; i < elemente; i++){
            System.out.printf("Bitte y_%d eingeben: ", i);
            yse[i] = scan.nextInt();
        }

        int dotProdukt = 0;
        for(int i = 0; i < elemente; i++){
            dotProdukt += xse[i]*yse[i];
        }

        System.out.printf("Das Skalarprodukt von  von x und y ist %d", dotProdukt);
    }
}
