package arrays;

import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Bitte Anzahl der Elemente n eingeben: ");
        int elemente = scan.nextInt();

        int[] array = new int[elemente];

        for(int i = 0; i < elemente; i++){
            System.out.printf("Zahl %d eingeben: ", i);
            array[i] = scan.nextInt();
        }

        for(int i = 0; i < array.length - 1; i++){
            for(int j = 0; j < array.length - i - 1; j++){
                if(array[j] > array[j+1]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }

        String outString = "Sortiert: ";
        for(int val : array){
            outString += val + " ";
        }

        System.out.println(outString);

    }
}
