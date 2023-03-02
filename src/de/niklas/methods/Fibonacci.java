package de.niklas.methods;

import java.util.Scanner;

public class Fibonacci {

    public static int calculateFibonacci(int i){
        if(i <= 1){         // Bei 0 soll 0 zurückgegeben werden, bei 1 soll die 1
            return i;
        }
        else{
            return calculateFibonacci(i-1) + calculateFibonacci(i-2);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Geben Sie bitte die Basis ein: ");
        int number = scan.nextInt();
        calculateFibonacci(number);

        for (int i = 1; i <= number; i++) {
            int fibonacciNumber = calculateFibonacci(i);
            System.out.printf("F(%d) = %d\n", i, fibonacciNumber);
        }
    }

}