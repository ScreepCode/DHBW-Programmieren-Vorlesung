package de.niklas.exercise.ui;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * <strong>Datei auswählen und zeilenweise darstellen</strong><br>
 * Eine Textdatei über FileChooser nehmen und einmal als Label und als TextArea anzeigen
 *
 * @see "20_Swing_Aufgaben-2.pdf"
 * @author Niklas Buse
 */
public class TextfileViewer {

    public TextfileViewer(){
        String[] fileData = chooseFile();
        if(fileData != null){               // nur wenn wirklich eine Datei ausgewählt wurde
            String fileName = fileData[1];
            String content = readFile(fileData[0]);
            showAsLabel(fileName, content);
            showAsTextArea(fileName, content);
        }
    }

    /**
     * Auswählen einer Datei
     * @return Filepath oder null
     */
    private String[] chooseFile(){
        JFileChooser chooser = new JFileChooser();
        int state = chooser.showOpenDialog(null); // Varianten öffnen / zeigen
        if (state == JFileChooser.APPROVE_OPTION){
            return new String[]{chooser.getSelectedFile().getAbsolutePath(), chooser.getSelectedFile().getName()};
        } else {
            return null;
        }
    }

    /**
     * Einlesen aller Zeilen und zurückgeben als String inkl. Zeilenumbruch
     * @param fileName Name der Datei
     * @return Inhalt der ganzen Datei als String
     */
    private String readFile(String fileName){
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


    /**
     * Zeigt den Inhalt der Datei basierend auf Labels da
     * @param fileName Name der Datei
     * @param fileContent Inhalt der Datei
     */
    private void showAsLabel(String fileName, String fileContent){
        JFrame frame = new JFrame(fileName);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] contentAsArray = fileContent.split(System.lineSeparator());        // Split zu Zeilen basierend auf Zeilenumbruch
        frame.setLayout(new GridLayout(0, 1));
        for(int i = 0; i < 10 && i < contentAsArray.length; i++){
            frame.add(new JLabel(contentAsArray[i]));
        }

        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    /**
     * Zeigt den Inhalt der Datei basierend auf einer TextArea da
     * @param fileName Name der Datei
     * @param fileContent Inhalt der Datei
     */
    private void showAsTextArea(String fileName, String fileContent){
        JFrame frame = new JFrame(fileName);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea textArea = new JTextArea();
        textArea.setText(fileContent);
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        frame.add(new JScrollPane(textArea));

        frame.setSize(300, 400);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new TextfileViewer();
    }
}
