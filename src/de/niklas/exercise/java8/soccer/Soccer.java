package de.niklas.exercise.java8.soccer;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;

/**
 * <strong>Arbeiten mit Streams</strong><br>
 * Analyse der Weltmeistermannschaft von 2018
 * Ausschließlich NIO, Streams und Lambdas
 *
 * @see "33_Java8_Aufgaben.pdf"
 * @author Niklas Buse
 */
public class Soccer {
    private final String filename;
    private final ArrayList<Player> players = new ArrayList<>();

    public Soccer(String filename){
        this.filename = filename;
        loadPlayer();
    }

    /**
     * Ausgabe der Spieler, sortiert nach Nummer
     */
    public void printBySortedNumber(){
        System.out.println("Players sorted by number:");
        players.stream()
                .sorted(Player::comparePlayerByNumber)
                .forEach(System.out::println);
        System.out.println("-----");
    }

    /**
     * Ausgabe aller Spieler mit mehr als 50 Toren
     */
    public void printMoreThen50Games(){
        System.out.println("Players sorted by number:");
        players.stream()
                .filter(player -> player.games() > 50) // Nur Spieler mit mehr als 50 Toren
                .sorted(Player::comparePlayerByName)
                .forEach(System.out::println);
        System.out.println("-----");
    }

    /**
     * Ausgabe aller Clubs der Spieler, aber jeweils nur 1x
     */
    public void printAllClubs(){
        System.out.println("All clubs of the players:");
        players.stream()
                .map(Player::club) // Neues Mapping auf Clubs
                .distinct() // Nur einmaliges Vorkommen jeden Werts
                .forEach(System.out::println);
        System.out.println("-----");
    }

    /**
     * Ausgabe von Torstatistiken
     */
    public void printGoalStats(){
        System.out.printf(String.format("Count of players with less than 5 goals: %d\n",
            players.stream()
                .map(Player::goals)// Neues Mapping auf Tore
                .filter(goals -> goals < 5) // Filter, für alles unter 5
                .count()
            )
        );

        System.out.printf(String.format("Count of goals of all players: %d\n",
            players.stream()
                .mapToInt(Player::goals) // Map der Tore auf den Stream als Int
                .sum()  // Summenfunktion, da es Integer sind
            )
        );
    }

    /**
     * Laden aller Spieler aus der CSV Datei
     */
    public void loadPlayer() {
        Path p = Paths.get(this.filename);
        try {
            Files.readAllLines(p) // alle Zeilen lesen
                    .stream() // als Stream weiterverarbeiten
                    .map(line -> line.split( ";" )) // aufsplitten an ";" zu String-Array
                    .filter(line -> line.length == 7 ) // alle Arrays rausfiltern, die nicht genau 7 Einträge haben
                    .map(line -> new Player(
                            Integer.parseInt(line[0]),
                            line[1],
                            line[2],
                            line[3],
                            line[4],
                            Integer.parseInt(line[5]),
                            Integer.parseInt(line[6])
                    ))
                    .forEach(this.players::add); // jeden Spieler in die Liste hinzufügen
        } catch (NumberFormatException | IOException ex) {
            System.err.printf("Read error: %s%n", ex.getLocalizedMessage());
        }
    }

    public static void main(String[] args) {
        Soccer soccer = new Soccer("FileExperiments/TeamDE.txt");
        soccer.printBySortedNumber();
        soccer.printMoreThen50Games();
        soccer.printAllClubs();
        soccer.printGoalStats();
    }

}