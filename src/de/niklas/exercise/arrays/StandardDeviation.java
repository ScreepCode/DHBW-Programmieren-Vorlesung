package de.niklas.exercise.arrays;
import java.util.Random;
/**
 * <strong>Mittelwert und Standardabweichung</strong><br>
 * Im Titel genannte Werte errechnen auf Basis von Zufallszahlen
 *
 * @see "07_Arrays_Aufgaben-1.pdf"
 * @author Niklas Buse
 */
public class StandardDeviation {
    public static void main(String[] args) {
        int numArray[] = new int[100];

        for(int i = 0; i < numArray.length; i++){
            numArray[i] = new Random().nextInt(11);
        }

        double sum = 0;
        for(int val : numArray){
            sum += val;
        }

        double mittelwert = sum/numArray.length;
        double varianz = 0.0;
        for(int i = 0; i < numArray.length; i++) {
            varianz += Math.pow(numArray[i] - mittelwert,2);
        }
        double abweichung = Math.sqrt(1.0/(numArray.length-1) * varianz);
        System.out.printf("Mittelwert: %.2f\n", mittelwert);
        System.out.printf("Standardabweichung: %f", abweichung);
    }
}

/* Beispielausführung
--------------------------------------
Eingabe: Keine
--------------------------------------
Ausgabe:
Mittelwert: 5,24
Standardabweichung: 3,309368
--------------------------------------
 */