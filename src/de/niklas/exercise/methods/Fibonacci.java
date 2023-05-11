package de.niklas.exercise.methods;

import java.util.Scanner;

/**
 * <strong>Fibonacci-Zahlen rekursiv</strong><br>
 * Rekursive Berechnung der Fibonacci-Zahlen
 *
 * @see "11_Methoden-Special_Aufgaben.pdf"
 * @author Niklas Buse
 */
public class Fibonacci {

    public static int calculateFibonacci(int i){
        if(i <= 1){         // Bei 0 soll 0 zurückgegeben werden, bei 1 soll die 1
            return i;
        }
        else{
            return calculateFibonacci(i-1) + calculateFibonacci(i-2); // Vereinfachung des Rekursionsschritts
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Wie viele Fibonacci-Zahlen berechnen? ");
        int number = scan.nextInt();
        calculateFibonacci(number);

        for (int i = 1; i <= number; i++) {
            int fibonacciNumber = calculateFibonacci(i);
            System.out.printf("F(%d) = %d\n", i, fibonacciNumber);
        }
    }
}

/* Beispielausführung
--------------------------------------
Eingabe:
20
--------------------------------------
Ausgabe:
Wie viele Fibonacci-Zahlen berechnen? 20
F(1) = 1
F(2) = 1
F(3) = 2
F(4) = 3
F(5) = 5
F(6) = 8
F(7) = 13
F(8) = 21
F(9) = 34
F(10) = 55
F(11) = 89
F(12) = 144
F(13) = 233
F(14) = 377
F(15) = 610
F(16) = 987
F(17) = 1597
F(18) = 2584
F(19) = 4181
F(20) = 6765
--------------------------------------
 */
