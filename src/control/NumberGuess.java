package control;

import java.util.Random;

public class NumberGuess {

    public static void main(String[] args) {
        java.util.Scanner scan = new java.util.Scanner(System.in);
        System.out.print("Wie ist dein Name? ");
        String name = scan.nextLine();

        int gameCounter = 0;
        int totalGuesses = 0;
        boolean play = true;

        while (play) {
            scan = new java.util.Scanner(System.in);

            int guessCounter = 1;
            int toGuess = new Random().nextInt(100);
            System.out.printf("Random = %d\n", toGuess);

            while (true) {
                System.out.printf("%s, rate eine Zahl [1-100]: ", name);
                String input = scan.nextLine();
                int guess;
                if(input.matches("^[0-9]*$")){ //[+-]?\d+
                    if(input.length() == 0){
                        System.out.println("Bitte gebe eine Zahl an ^^");
                        continue;
                    }
                    if(input.length() == 0 || input.length() > 2){
                        System.out.println("Die Zahl liegt nur zwischen 0 und 100 ^^");
                        continue;
                    }
                    guess = Integer.parseInt(input);
                    if(guess < 0 || guess > 100) {
                        System.out.println("Die Zahl liegt nur zwischen 0 und 100 ^^");
                        continue;
                    }
                }
                else{
                    System.out.println("Bitte gebe nur Zahlen ein ^^");
                    continue;
                }
                if (guess == toGuess) {
                    System.out.printf("Versuch %d: %d ist korrrekt.\n", guessCounter, guess);
                    break;
                } else if (guess < toGuess) {
                    System.out.printf("Versuch %d: %d ist zu niedrig.\n", guessCounter, guess);
                    guessCounter++;
                } else if (guess > toGuess) {
                    System.out.printf("Versuch %d: %d ist zu hoch.\n", guessCounter, guess);
                    guessCounter++;
                }
            }

            System.out.println("Was möchtest du tun? ");
            System.out.println("1 - Das Spiel fortsetzen ");
            System.out.println("0 - Das Spiel beenden ");
            while(true){
                System.out.print("Deine Eingabe: ");
                scan = new java.util.Scanner(System.in);
                String auswahl = scan.nextLine();
                if(auswahl.equals("1")){
                    gameCounter++;
                    totalGuesses += guessCounter;
                    break;
                }
                else if(auswahl.equals("0")){
                    gameCounter++;
                    totalGuesses += guessCounter;
                    System.out.printf("" +
                                    "Danke für spielen %s. ^^ \n" +
                                    "Du hast %d Spiel(e) gespielt und im Schnitt %d Versuch(e) gebraucht."
                            , name, gameCounter, totalGuesses/gameCounter);
                    play = false;
                    break;
                }
                else{
                    System.out.println("Bitte nur '0' oder '1' eingeben, so schwer ist das nicht ^^");
                }
            }
        }
    }
}
