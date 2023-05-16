package de.niklas.exercise.ui;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * <strong>Frame mit Text</strong><br>
 * Aus einer txt-Datei Text auf eine TextArea schreiben
 *
 * @see "20_Swing_Aufgaben-1.pdf"
 * @author Niklas Buse
 */
public class TextFrame extends JFrame {

    public TextFrame(String fileName, int width, int height) {
        super(fileName.split("/")[(fileName.split("/")).length-1]);   // Ich möchte nur den Dateinamen anzeigen, übergebe jedoch zum Öffnen den gesamten Pfad. Daher alles nach dem Letzten / nur benötigt
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(new JTextArea(readFile(fileName)));                               // Aufrufen des readFile, um den Content als String zu bekommen

        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
     * Einlesen aller Zeilen und zurückgeben als String inkl. Zeilenumbruch
     * @param fileName Name der Datei
     * @return Inhalt der ganzen Datei
     */
    private String readFile(String fileName){                                                   // Wie diese Funktion geht, ist schon in den IO Klassen behandelt
        StringBuilder content = new StringBuilder();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
            while (bufferedReader.ready()){
                content.append(bufferedReader.readLine()).append(System.lineSeparator());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    public static void main(String[] args) throws Exception{
        if(args.length != 3){                                                                                           // Überprüfung, ob die Argumentanzahl stimmt, wenn nicht, gibt es den print
            System.out.println("""                                                              
                Bitte gebe die 3 Kommandozeilenparametern an: NameDerDatei, Breite, Höhe:
                    z.B. FileExperiments/palindrome.txt 400 500
                """
            );                                                                                                          // Mit 3 Anführungszeichen lassen sich Textblöcke erstellen,
        }                                                                                                               //   die genau so, inkl. Zeilenumbruch, benutzt werden können
        else{
            try{
                TextFrame frame = new TextFrame(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]));                           // Hier kann beim Parsen zum Integer der Error entstehen.
            }                                                                                                           //  Daher die Initialising komplett im try, damit nicht irgendwas erstellt werden kann.
            catch (NumberFormatException e){
                e.printStackTrace();
            }
        }
    }
}
