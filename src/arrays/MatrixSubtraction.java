package arrays;

import java.util.Random;
import java.util.Scanner;

public class MatrixSubtraction {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Bitte Anzahl der Zeilen n eingeben: ");
        int zeilen = scan.nextInt();
        System.out.print("Bitte Anzahl der Spalten m eingeben: ");
        int spalten = scan.nextInt();

        int[][] xMatrix = new int[zeilen][spalten];
        int[][] yMatrix = new int[zeilen][spalten];
        int[][] subMatrix = new int[zeilen][spalten];

        System.out.println("X:");
        for(int i = 0; i < xMatrix.length; i++){
            for(int j = 0; j < xMatrix[i].length; j++){
                xMatrix[i][j] = new Random().nextInt(100);
                System.out.printf("%4s", xMatrix[i][j]);
            }
            System.out.println();
        }
        System.out.println("Y:");
        for(int i = 0; i < yMatrix.length; i++){
            for(int j = 0; j < yMatrix[i].length; j++){
                yMatrix[i][j] = new Random().nextInt(100);
                System.out.printf("%4s", yMatrix[i][j]);
            }
            System.out.println();
        }
        System.out.println("X-Y:");
        for(int i = 0; i < xMatrix.length & i < yMatrix.length; i++){
            for(int j = 0; j < xMatrix[i].length & i < yMatrix[i].length ; j++){
                subMatrix[i][j] = xMatrix[i][j]-yMatrix[i][j];
                System.out.printf("%4s", subMatrix[i][j]);
            }
            System.out.println();
        }
    }
}
