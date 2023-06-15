package de.niklas.exercise.ui.event;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * <strong>Zahlenraten</strong><br>
 * - Ratespiel von Zahlen zwischen 1 und 1000; Hinweise ob höher oder kleiner ; Zählen der Versuche
 * - Eingabe von Name, Versuch und den Aktionsbuttons
 * - Hier als Grafische Oberfläche
 *
 * @see "23_Events_Aufgaben-1.pdf"
 * @author Niklas Buse
 */
public class NumberGuess extends JFrame{

    JTextField name_field, guess_field, output_field;
    JButton new_game_button, ok_button, best_player_button, exit_button;

    int attempts = 0;
    int right_number = 0;

    public NumberGuess(){
        super("Number Guessing Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel main_panel = new JPanel();

        JPanel name_panel = new JPanel();
        name_panel.add(new JLabel("Player Name"));
        name_field = new JTextField(20);
        name_panel.add(name_field);

        JPanel guess_panel = new JPanel();
        guess_panel.add(new JLabel("Enter number between 1 and 1000"));
        guess_field = new JTextField(10);
        guess_panel.add(guess_field);

        JPanel action_panel = new JPanel();
        new_game_button = new JButton("New Game");
        new_game_button.addActionListener(e -> newGame());
        action_panel.add(new_game_button);
        ok_button = new JButton("Ok");
        ok_button.addActionListener(e -> evaluateGuess());
        action_panel.add(ok_button);
        best_player_button = new JButton("Best Player");
        best_player_button.addActionListener(e -> getBestPlayer());
        action_panel.add(best_player_button);
        exit_button = new JButton("Exit");
        exit_button.addActionListener(e -> System.exit(0));
        action_panel.add(exit_button);

        JPanel output_panel = new JPanel();
        output_field = new JTextField(40);
        output_panel.add(output_field);

        main_panel.add(name_panel);
        main_panel.add(guess_panel);
        main_panel.add(action_panel);
        main_panel.add(output_panel);

        this.add(main_panel);
        this.setSize(500, 200);                                        // Automatische anpassung an Anzahl der Buttons
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    /**
     * Initialisieren eines Neuen Spiels
     */
    private void newGame(){
        name_field.setText("");
        guess_field.setText("");
        output_field.setText("Game Started!");

        attempts = 0;
        right_number = new Random().nextInt(1000);
        System.out.printf("Right number: %d \n", right_number);
    }

    /**
     * Auswertung eines Versuchs
     */
    private void evaluateGuess(){
        if(name_field.getText().equals("")){
            output_field.setText("Bitte erst Namen eingeben.");
        }
        else if(guess_field.getText().equals("")){
            output_field.setText("Bitte gib eine Zahl an.");
        }
        else{
            attempts += 1;
            int guess = Integer.parseInt(guess_field.getText());
            String output = String.format("Attempt #%d: %d => ", attempts, guess);
            if(guess == right_number){
                output += "Right! -> Saved to File";
                saveToFile(String.format("%s: %d", name_field.getText(), attempts));
            }
            else if(guess > right_number){
                output += "too big!";
            }
            if(guess < right_number){
                output += "too low!";
            }
            output_field.setText(output);
        }
    }

    /**
     * Speichern des Ergebnisses in eine Datei
     * @param out String zum Speichern
     */
    private void saveToFile(String out){
        try(FileWriter fileWriter = new FileWriter("FileExperiments/numberGuessing.txt", true)){
            fileWriter.write(out + System.lineSeparator());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Auslesen des besten Spielers bisher aus der Datei
     */
    private void getBestPlayer(){
        String bestPlayer = "";
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("FileExperiments/numberGuessing.txt"))){ // BufferedReader um einzelne Zeilen lesen zu können
            while (bufferedReader.ready()){
                String player = bufferedReader.readLine();  // jede zeile wird ausgegeben
                try{
                    if (Integer.parseInt(bestPlayer.split(":")[1].trim())
                            > Integer.parseInt(player.split(":")[1].trim())){
                        bestPlayer = player;
                    }
                }
                catch (Exception e){
                    bestPlayer = player;
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        String[] player = bestPlayer.split(":");
        output_field.setText(String.format("Best Player: %s with %d Attempts", player[0], Integer.parseInt(player[1].trim())));
    }

    public static void main(String[] args) {
        new NumberGuess();
    }
}
