package de.niklas.exams.test_exam2023;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * <strong>Game</strong><br>
 * Die Hauptdatei, in der das Spiel abläuft
 *
 * @see "Teilaufgabe e & f & h"
 * @author Niklas Buse
 */
public class Game {

    Board board;
    Player[] players;

    public Game(Board board, Player[] players) {
        this.players = players;
        this.board = board;
    }

    public void start(){
        while(gameShouldRun()){
            playerVisit(0);
            if(gameShouldRun()){
                playerVisit(1);
            }
        }
        printAndSaveEnding();
    }

    private boolean gameShouldRun(){
        if(players[0].getCountDartsThrown() == 10 && players[1].getCountDartsThrown() == 10){
            return false;
        }
        if(players[0].getRemainingPoints() == 0 || players[1].getRemainingPoints() == 0){
            return false;
        }
        return true;
    }
    private void playerVisit(int playerNumber){
        Scanner scan = new Scanner(System.in);
        Player player = players[playerNumber];

        System.out.println(player);
        printCheckoutWay(player.getRemainingPoints());
        System.out.print("Enter Visit: ");
        String[] versuchsArr = scan.nextLine().split(" ");
        Field[] fields = new Field[versuchsArr.length];
        for(int i = 0; i < versuchsArr.length; i++){
            fields[i] = board.parseField(versuchsArr[i]);
        }
        Visit visit = new Visit(fields);
        player.addVisit(visit);

        System.out.printf("Scored: %d\n", visit.getValue());
        System.out.println("====================");
    }

    private void printAndSaveEnding(){
        if(players[0].getCountDartsThrown() == 10 || players[1].getCountDartsThrown() == 10){
            System.out.println("You're to bad for this game!");
        }
        else{
            Player winningPlayer = (players[0].getRemainingPoints() == 0)? players[0] : players[1];
            System.out.printf("Game shot and the leg, %s!", winningPlayer.getName());


            String outputString = String.format("%s won with %d darts", winningPlayer.getName(), winningPlayer.getCountDartsThrown());
            try (FileWriter fWriter = new FileWriter("highscore.txt", true)){     // öffnen des FileWriters mit Anweisung append
                fWriter.write(outputString + System.lineSeparator());          // Schreiben des Strings in die Datei
//                System.out.println("Ergebnis in der Datei gespeichert.");
            }
            catch (IOException e) {
                e.printStackTrace();                                                // Ausgeben des Fehlers, wenn einer auftritt
            }
        }
    }

    private void printCheckoutWay(int remainingPoints){ // Diese Methode könnte einmalig im Konstruktor gemacht werden, um nicht jedes mal die Datei einzulesen
        String[] checkoutWays = new String[170];
        if(remainingPoints <= 170){
            try(BufferedReader bufferedReader = new BufferedReader(new FileReader("checkouts.txt"))){ // BufferedReader um einzelne Zeilen lesen zu können
                for(int i = 0; i < 170; i++){
                    checkoutWays[i] = bufferedReader.readLine();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            System.out.printf("Possible Checkout: %s\n", checkoutWays[remainingPoints-1]);
        }

    }
}
