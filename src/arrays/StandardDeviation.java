package arrays;
import java.util.Random;

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
