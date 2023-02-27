package de.niklas.classes;

import java.util.Random;
import java.util.Scanner;

public class MasterMind {

    private String rightCombination = "";
    private String[][] guesses;
    private int guessCounter = 0;
    private boolean stillMismatch = true;
    Scanner scan = new Scanner(System.in);

    public MasterMind(int maxVersuche){
        this.guesses = new String[maxVersuche][3];
        generateCombination();
        startGame();
    }

    private void generateCombination(){
//        String[] possibilities = new String[]{"A", "B", "C", "D", "E", "F", "G", "H"};
//        for(int i = 0; i < 5; i++){
//            this.rightCombination += possibilities[new Random().nextInt(possibilities.length)];
//        }
//        System.out.println(rightCombination + "\n\n");
        this.rightCombination = "HDGDF";
    }

    private void startGame(){
        while (this.stillMismatch | this.guessCounter >= 20){
            System.out.print("Geben Sie ihren Tipp ab: ");
            this.scan = new Scanner(System.in);
            String guess = scan.nextLine().toUpperCase();
            validateGuess(guess);
            this.guessCounter++;
            printGuesses();
        }
        System.out.printf("Mit %d Versuchen gewonnen!", this.guessCounter);
    }

    private void validateGuess(String guess){
        int excactMatch = 0;
        int letterMatchWrongPos = 0;

        // copy combinations and guess
        String[] cRightCombination =  this.rightCombination.split("");
        String[] cGuess =  guess.split("");

        if(guess.equals(this.rightCombination)){
            this.stillMismatch = false;
            return;
        }

        // check for positions
        for(int i = 0; i < cRightCombination.length; i++){
            if(cRightCombination[i].equals(cGuess[i])){
                excactMatch++;
                cRightCombination[i] = "0";
                cGuess[i] = "0";
            }
        }

        for(int i = 0; i < cRightCombination.length; i++){
            for(int j = 0; j < cGuess.length; j++){
                if(cRightCombination[i] != "0" && cRightCombination[i].equals(cGuess[j])){
                    letterMatchWrongPos++;
                    cRightCombination[i] = "0";
                    cGuess[j] = "0";
                }
            }
        }

        guesses[guessCounter] = new String[]{guess, ""+excactMatch, ""+letterMatchWrongPos};
    }

    private void printGuesses(){
        if(this.stillMismatch){
            System.out.printf("%d bisherige Versuche: \n", this.guessCounter);
            for(int i = 0; i < guessCounter; i++){
                System.out.printf("%s %s %s \n", guesses[i][0], guesses[i][1], guesses[i][2]);
            }
        }
    }


    public static void main(String[] args) {
        new MasterMind(20);
    }

}
