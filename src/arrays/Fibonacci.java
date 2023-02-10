package arrays;
/**
 * <h1>Fibonacci-Folge</h1>
 * Fibonacci Folge mithilfe eines Arrays errechnen und ausgeben
 *
 * @see "07_Arrays_Aufgaben-1.pdf"
 * @author Niklas Buse
 */
public class Fibonacci {
    public static void main(String[] args) {
        long numArray[] = new long[50];
        numArray[0] = 1;
        numArray[1] = 1;

        for(int i = 1; i < numArray.length-1; i++){
            numArray[i+1] = numArray[i] + numArray[i-1];
        }

        for(int i = 0; i < numArray.length; i++){
            System.out.printf("Fibonaccizahl von %d ist %d.\n", i+1, numArray[i]);
        }
    }

}

/* Beispielausführung
--------------------------------------
Eingabe: Keine
--------------------------------------
Ausgabe:
Fibonaccizahl von 1 ist 1.
Fibonaccizahl von 2 ist 1.
Fibonaccizahl von 3 ist 2.
Fibonaccizahl von 4 ist 3.
Fibonaccizahl von 5 ist 5.
Fibonaccizahl von 6 ist 8.
Fibonaccizahl von 7 ist 13.
Fibonaccizahl von 8 ist 21.
Fibonaccizahl von 9 ist 34.
Fibonaccizahl von 10 ist 55.
Fibonaccizahl von 11 ist 89.
Fibonaccizahl von 12 ist 144.
Fibonaccizahl von 13 ist 233.
Fibonaccizahl von 14 ist 377.
Fibonaccizahl von 15 ist 610.
Fibonaccizahl von 16 ist 987.
Fibonaccizahl von 17 ist 1597.
Fibonaccizahl von 18 ist 2584.
Fibonaccizahl von 19 ist 4181.
Fibonaccizahl von 20 ist 6765.
Fibonaccizahl von 21 ist 10946.
Fibonaccizahl von 22 ist 17711.
Fibonaccizahl von 23 ist 28657.
Fibonaccizahl von 24 ist 46368.
Fibonaccizahl von 25 ist 75025.
Fibonaccizahl von 26 ist 121393.
Fibonaccizahl von 27 ist 196418.
Fibonaccizahl von 28 ist 317811.
Fibonaccizahl von 29 ist 514229.
Fibonaccizahl von 30 ist 832040.
Fibonaccizahl von 31 ist 1346269.
Fibonaccizahl von 32 ist 2178309.
Fibonaccizahl von 33 ist 3524578.
Fibonaccizahl von 34 ist 5702887.
Fibonaccizahl von 35 ist 9227465.
Fibonaccizahl von 36 ist 14930352.
Fibonaccizahl von 37 ist 24157817.
Fibonaccizahl von 38 ist 39088169.
Fibonaccizahl von 39 ist 63245986.
Fibonaccizahl von 40 ist 102334155.
Fibonaccizahl von 41 ist 165580141.
Fibonaccizahl von 42 ist 267914296.
Fibonaccizahl von 43 ist 433494437.
Fibonaccizahl von 44 ist 701408733.
Fibonaccizahl von 45 ist 1134903170.
Fibonaccizahl von 46 ist 1836311903.
Fibonaccizahl von 47 ist 2971215073.
Fibonaccizahl von 48 ist 4807526976.
Fibonaccizahl von 49 ist 7778742049.
Fibonaccizahl von 50 ist 12586269025.
--------------------------------------
 */