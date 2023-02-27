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
        if(this.rightCombination.length() != guess.length()){
            System.out.printf("Dein Tipp entspricht der falschen Länge");
            this.guessCounter--;
            return;
        }
        if(guess.equals(this.rightCombination)){
            this.stillMismatch = false;
            return;
        }
        int excactMatch = 0;
        int letterMatchWrongPos = 0;
        String handledChars = "";

        for(int i = 0; i < guess.length(); i++){
            String guessedChar = ""+guess.charAt(i);
            if(rightCombination.contains(guessedChar)){
                if((""+rightCombination.charAt(i)).equals(guessedChar)){
                    excactMatch++;
                }
                else {
                    letterMatchWrongPos++;
                }
            }


//            if(guessedChar == rightCombination.charAt(i)){
//                excactMatch++;
//                handledChars += ""+guessedChar;
//            }
//            else{
//                if(!handledChars.contains(""+guessedChar)){
//                    if(rightCombination.contains("" + guessedChar)) {
//                        letterMatchWrongPos++;
//                        handledChars += ""+guessedChar;
//                    }
//                }
//            }
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
