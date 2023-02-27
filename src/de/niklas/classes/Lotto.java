package de.niklas.classes;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lotto {

    private int m;
    private int n;
    private int[] guesses;
    private int[] drawn;
    Scanner scan;


    public Lotto(int m, int n){
        this.m = m;
        this.n = n;
        this.guesses = new int[m];
        this.drawn = new int[m];
    }

    public void tippen(){
        scan = new Scanner(System.in);
        for(int i = 0; i < m; i++){
            boolean notValidGuess = true;
            while(notValidGuess){
                System.out.printf("Geben Sie bitte Ihren Tipp für die %d. Zahl ein: ", i+1);
                int guess =  scan.nextInt();
                if(guess <= n & guess >= 1){
                    this.guesses[i] = guess;
                    notValidGuess = false;
                }
                else{
                    System.out.printf("Bitte gebe einen Tipp ab, der zwischen 1 und %d ist\n", this.n);
                }
            }
        }
        System.out.println("Tipp: " + Arrays.toString(guesses));
    }

    public void tippen(int[] tipp){
        if(tipp.length == guesses.length){
            this.guesses = tipp;
        }
        else{
            System.out.println("Dein festgelegter Tipp hat nicht die passende Anzahl an Tipps");
            System.out.println("Das Programm wird automatisch beendet.");
            System.exit(0);
        }
        System.out.println("Tipp: " + Arrays.toString(guesses));
    }

    public void ziehen(){
        for(int i = 0; i < drawn.length; i++){
            drawn[i] = new Random().nextInt(n);
        }
        System.out.println("Tipp: " + Arrays.toString(guesses));
        System.out.println("Gezogene Zahlen: " + Arrays.toString(drawn));
    }

    public int richtige(){
        int counter = 0;
        for(int i = 0; i<guesses.length & i<drawn.length; i++){
            if(guesses[i] == drawn[i]){
                counter++;
            }
        }
        return counter;
    }


    public static void main(String[] args) {
        Lotto deutschesLotto = new Lotto(6,49);
        deutschesLotto.tippen();
//        deutschesLotto.tippen(new int[]{31, 32, 33, 34, 35, 36});
        deutschesLotto.ziehen();
        System.out.println("Richtige: " + deutschesLotto.richtige());
    }
}
