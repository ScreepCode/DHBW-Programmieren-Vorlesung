package de.niklas.exercise.ui.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;

/**
 * <strong>Hütchenspiel</strong><br>
 * Das Hütchenspiel über GUI mit Ergebnisdatei
 *
 * @see "23_Events_Aufgaben-2.pdf"
 * @author Niklas Buse
 */
public class ShellGame extends JFrame {
    JTextField name, output;
    JButton shell1, shell2, shell3, exit, statistik;

    String playerName;
    int shell;
    int trys = 0;
    String filename = "FileExperiments/ShellGame.txt";

    public ShellGame() {
        super("Shellgame");

        JPanel mainPanel = new JPanel();
        mainPanel.add(new JLabel("Spielername: "));
        name = new JTextField(15);
        mainPanel.add(name);
        this.add(mainPanel);

        JPanel panel2 = new JPanel();
        shell1 = new JButton("Shell 1");
        shell1.addActionListener(this::shellExecution);
        shell2 = new JButton("Shell 2");
        shell2.addActionListener(this::shellExecution);
        shell3 = new JButton("Shell 3");
        shell3.addActionListener(this::shellExecution);
        panel2.add(shell1);
        panel2.add(shell2);
        panel2.add(shell3);
        this.add(panel2);

        JPanel buttonPanel = new JPanel();
        statistik = new JButton("Statistik");
        statistik.addActionListener(e -> getStats());
        buttonPanel.add(statistik);
        exit = new JButton("Exit");
        exit.addActionListener(e -> System.exit(0));
        buttonPanel.add(exit);
        this.add(buttonPanel);

        JPanel outputPanel = new JPanel();
        output = new JTextField(30);
        outputPanel.add(output);
        this.add(outputPanel);

        this.setLayout(new GridLayout(4, 1, 5, 5));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

        newHide();
    }

    /**
     * Custom Action Listener über Lamdafunktionen
     * @param e Actionevent, wie beim Interface
     */
    public void shellExecution(ActionEvent e){
        if(e.getSource() == shell1){
            trys++;
            if (shell == 1) {
                output.setText("Versuch "+trys+": Gewonnen, die Kugel war unter Hut "+shell);
                writeResult();
            } else {
                output.setText("Versuch "+trys+": Falsch, die Kugel war unter Hut "+shell);
            }
            newHide();
        }
        else if(e.getSource() == shell2){
            trys++;
            if (shell == 2) {
                output.setText("Versuch "+trys+": Gewonnen, die Kugel war unter Hut "+shell);
                writeResult();
            } else {
                output.setText("Versuch "+trys+": Falsch, die Kugel war unter Hut "+shell);
            }
            newHide();
        }
        else if(e.getSource() == shell3){
            trys++;
            if (shell == 3) {
                output.setText("Versuch "+trys+": Gewonnen, die Kugel war unter Hut "+shell);
                writeResult();
            } else {
                output.setText("Versuch "+trys+": Falsch, die Kugel war unter Hut "+shell);
            }
            newHide();
        }
    }

    /**
     * Schreiben vom Ergebnis in eine Datei
     */
    public void writeResult(){
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename, true))) {
            playerName = name.getText();
            pw.println(playerName + "," + trys);
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        trys = 0;
    }

    /**
     * Auslesen und Schreiben der Statistiken
     */
    public void getStats(){
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            float summe = 0;
            int zaehler =0;

            while (br.ready()) {
                String line = br.readLine();
                String[] split = line.split(",");
                int z =  Integer.parseInt(split[1]);
                summe += z;
                zaehler++;
            }
            output.setText("Erfolg nach " + (summe/zaehler)+ " Versuchen!" );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Verstecken der Shells
     */
    private void newHide() {
        this.shell = (int) (Math.random() * 3) + 1;

        //Hilfe
        System.out.println(this.shell);
    }

    public static void main(String[] args) {
        new ShellGame();
    }
}
