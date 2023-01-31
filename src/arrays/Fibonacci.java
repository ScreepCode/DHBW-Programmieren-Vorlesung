package arrays;

import java.util.Random;

public class Fibonacci {
    public static void main(String[] args) {
        long numArray[] = new long[50];
        numArray[0] = 1;
        numArray[1] = 1;

        for(int i = 1; i < numArray.length-1; i++){
            numArray[i+1] = numArray[i] + numArray[i-1];
        }

        System.out.printf("Fibonaccizahl von %d ist %d.", numArray.length, numArray[numArray.length-1]);

    }
}
