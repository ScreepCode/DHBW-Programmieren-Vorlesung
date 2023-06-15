package de.niklas.exercise.ui.editor;

import de.niklas.exercise.io.TextFile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * <strong>Editor</strong><br>
 * Ein kleinen Editor mit einer großen Menubar
 *
 * @see "23_Events_Aufgaben-2.pdf"
 * @author Niklas Buse
 */
public class Editor extends JFrame implements ActionListener {

    JEditorPane editorPane;
    JMenuItem new_item, open_item, save_item, close_item;
    String filepath = "";

    public Editor() {
        super("Editor");
        JMenuBar menubar = new JMenuBar();
        this.setJMenuBar(menubar);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        // Scrollable Editor
        editorPane = new JEditorPane();
        editorPane.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(editorPane);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(scrollPane, BorderLayout.CENTER);             // Hier wird vor dem Hinzufügen auf das Frame der Editor noch mit Scrollbars versehen

        // Menubar - wie in der Aufgabe mit der Struktur
        JMenu datei = new JMenu("Datei");
        menubar.add(datei);
        JMenu bearbeiten = new JMenu("Bearbeiten");
        menubar.add(bearbeiten);

        new_item = new JMenuItem("Neu");
        new_item.addActionListener(this);
        datei.add(new_item);

        open_item = new JMenuItem("Öffnen");
        open_item.addActionListener(this);
        datei.add(open_item);

        save_item = new JMenuItem("Speichern");
        save_item.addActionListener(this);
        save_item.setEnabled(false);
        datei.add(save_item);

        datei.add(new JSeparator());

        close_item = new JMenuItem("Beenden");
        close_item.addActionListener(this);
        datei.add(close_item);

        this.setSize(500, 600);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }


    public static void main(String[] args) {
        new Editor();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Für das Löschen des aktuellen Inhalts
        if(e.getSource() == new_item){
            filepath = "";
            editorPane.setText("");
        }
        // Öffnen einer neuen Datei über File Chooser
        else if (e.getSource() == open_item) {
            JFileChooser chooser = new JFileChooser();
            int state = chooser.showOpenDialog(null); // Varianten öffnen / zeigen
            if (state == JFileChooser.APPROVE_OPTION){
                filepath = chooser.getSelectedFile().getAbsolutePath();
            } else {
                filepath = "";
            }

            try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath))){ // BufferedReader um einzelne Zeilen lesen zu können
                while (bufferedReader.ready()){
                    editorPane.setText(editorPane.getText() + bufferedReader.readLine() + System.lineSeparator());  // jede zeile wird ausgegeben
                }
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
            save_item.setEnabled(true);
        }
        // Speichern des aktuellen Inhalts in die Datei
        else if (e.getSource() == save_item) {
            if(!filepath.equals("")){
                try(FileWriter fileWriter = new FileWriter(filepath, false)){
                    fileWriter.write(editorPane.getText());
                }
                catch (IOException ex){
                    ex.printStackTrace();
                }
            }
        }
        // Beenden der Datei, wenn über Popup bestätigt
        else if (e.getSource() == close_item) {
            String[] opts = { "Ja", "Nein"};
            int popup = JOptionPane.showOptionDialog(null, "Möchtest du wirklich beenden","Beenden?",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opts, opts[0]);
            if ( popup == JOptionPane.YES_OPTION ) {
                System.exit(0);
            }
        }
    }


}

