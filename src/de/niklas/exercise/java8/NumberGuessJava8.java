package de.niklas.exercise.java8;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import javax.swing.*;

/**
 * <strong>Zahlenraten (3)</strong><br>
 * Musterlösung von NumberGuess mit Java 8 Features überarbeiten
 * und weitere Überarbeitungen
 *
 * @see "33_Java8_Aufgaben.pdf"
 * @author Niklas Buse (& DHBW lecturer)
 */
public class NumberGuessJava8 extends JFrame {
    private int numberToGuess, countAttempts;
    private final int limit = 1000;
    private final JButton btnExit = new JButton( "Exit" );
    private final JButton btnOk = new JButton( "OK" );
    private final JButton btnNew = new JButton( "New Game" );
    private final JButton btnStat = new JButton( "Best Player" );
    private final JTextField txtName = new JTextField( "Name", 20 );
    private final JTextField txtGuess = new JTextField( 10 );
    private final JTextField txtOutput = new JTextField( 40 );
    private final String statFileName = "FileExperiments/numberGuessing.txt";

    public NumberGuessJava8() {
        super("Number Guessing Game");
        this.setLayout(new GridLayout(4,1));

        JPanel panName = new JPanel();
        JPanel panNumberinput = new JPanel();
        JPanel panButtons = new JPanel();
        JPanel panOutput = new JPanel();

        panName.add(new JLabel("Player Name"));
        panName.add(this.txtName);
        panNumberinput.add(new JLabel(String.format("Enter number between 1 and %d", this.limit)));
        panNumberinput.add(this.txtGuess);

        addAll(panButtons, this.btnNew, this.btnOk, this.btnStat, this.btnExit); // Alle Action Buttons über Hilfsfunktion
        panOutput.add(this.txtOutput);
        addAll(this, panName, panNumberinput, panButtons, panOutput);

        this.addEventHandling();
        this.createRandomNumber();
        this.setSize(500, 250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    /**
     * Hilfsfunktion um mehrere Objekte in einen Container hinzuzufügen
     * @param container Container (Frame/Panel/evt.)
     * @param components Alle Komponenten, die hinzugefügt werden sollen
     */
    private void addAll(Container container, Component... components){
        for (Component component : components) {
            container.add(component);
        }
    }

    /**
     * ActionListener auf die Buttons hinzufügen,
     * hier Änderung auf Lambda Funktionen
     */
    public void addEventHandling() {
        this.btnNew.addActionListener(event -> this.createRandomNumber());
        this.btnExit.addActionListener(event -> System.exit( 0 ));
        this.txtGuess.addActionListener(this::okActionListener);
        this.btnOk.addActionListener(this::okActionListener);
        this.btnStat.addActionListener(event -> this.showBestPlayer());
    }

    /**
     * ActionListener für Versuche, Änderung auf String.format
     * @param event Event
     */
    public void okActionListener(ActionEvent event) {
        try {
            int guess = Integer.parseInt(this.txtGuess.getText());
            this.countAttempts++;
            this.txtGuess.setText("");
            if (guess > this.numberToGuess) {
                this.txtOutput.setText(
                        String.format("Attempt #%s: %s => too big!", this.countAttempts, guess)
                );
            }
            else if (guess < this.numberToGuess) {
                this.txtOutput.setText(
                        String.format("Attempt #%s: %s => too small!", this.countAttempts, guess)
                );
            }
            else {
                this.txtOutput.setText(
                        String.format("Attempt #%s: %s => correct!!! New Game!", this.countAttempts, guess)
                );
                this.writeStatFile();
                this.createRandomNumber();
            }
        } catch (NumberFormatException ex) {
            this.txtOutput.setText("Bad input!");
        }
    }

    /**
     * Schreiben des Versuchs in die Datei,
     * hier Änderung auf NIO write
     */
    private void writeStatFile() {
        String entry = String.format("%s: %s", this.txtName.getText(), this.countAttempts);
        try {
            Files.writeString(Paths.get(this.statFileName), entry + System.lineSeparator(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Lese den besten Spieler (wenigste Versuche) aus und gebe ihn im Textfeld aus,
     * hier Änderung auf NIO Reading und Verarbeiten als Stream
     */
    private void showBestPlayer() {
        try{
            Player bestPlayer = Files.readAllLines(Paths.get(this.statFileName)) // Einlesen aller Zeilen
                    .stream()   // Umwandeln in Stream
                    .map(Player::parsePlayer) // Jede Zeile auf ein Spieler Objekt mappen
                    .min(Comparator.comparingInt(Player::attempts)) // Min nach den Attempts filtern
                    .orElse(null); // Für den Fall, dass der Stream leer ist

            if (bestPlayer != null) {
                this.txtOutput.setText(String.format("Bester Spieler: %s, %d Versuche", bestPlayer.name, bestPlayer.attempts));
            }
            else {
                this.txtOutput.setText("Keine Spieler Daten vorhanden.");
            }
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }

    /**
     * Neustarten des Spiels durch Generieren einer neuen Zahl,
     * hier Änderung von Math.random auf Random von java.util
     */
    private void createRandomNumber() {
        this.txtGuess.setText("");
        this.txtOutput.setText("New Game!");
        this.numberToGuess = new Random().nextInt(1, this.limit+1);
        this.countAttempts = 0;
        // For debugging purposes
        System.out.println("Number to guess: " + this.numberToGuess);
    }
    public static void main(String[] args) {
        new NumberGuessJava8();
    }

    /**
     * Player Record zum Filtern
     * @param name Name des Spieles
     * @param attempts Versuchsanzahl
     */
    private record Player (String name, int attempts){
        /**
         * Wandeln einer Zeile in einen Player Record
         * @param line Eingelesene Zeile
         * @return Player Record
         */
        private static Player parsePlayer(String line) {
            String[] parts = line.split(":"); // Split nach Trennungszeichen
            String name = parts[0].trim(); // Trim um Leerzeichen zu entfernen
            int score = Integer.parseInt(parts[1].trim()); // Trim + parseToInt
            return new Player(name, score); // Rückgabe des Player
        }
    }
}

