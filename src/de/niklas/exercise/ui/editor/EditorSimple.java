package de.niklas.exercise.ui.editor;

import javax.swing.*;
import java.awt.*;

/**
 * <strong>Editor</strong><br>
 * Ein kleinen Editor mit einer großen Menubar (noch nicht funktional)
 *
 * @see "20_Swing_Aufgaben-2.pdf"
 * @author Niklas Buse
 */
public class EditorSimple extends JFrame {
    public EditorSimple() {
        super("Editor");
        JMenuBar menubar = new JMenuBar();
        this.setJMenuBar(menubar);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        // Scrollable Editor
        JEditorPane editorPane = new JEditorPane();
        editorPane.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        this.add(new JScrollPane(editorPane), BorderLayout.CENTER);             // Hier wird vor dem Hinzufügen auf das Frame der Editor noch mit Scrollbars versehen

        // Menubar - wie in der Aufgabe mit der Struktur
        JMenu datei = new JMenu("Datei");
        JMenu bearbeiten = new JMenu("Bearbeiten");
        menubar.add(datei);
        menubar.add(bearbeiten);
            datei.add(new JMenuItem("Neu"));
            datei.add(new JMenuItem("Öffen"));
            datei.add(new JSeparator());
            datei.add(new JMenuItem("Schließen"));
            datei.add(new JSeparator());
            datei.add(new JMenuItem("Speichern"));
            datei.add(new JMenuItem("Speichern unter"));
            datei.add(new JMenuItem("Als Webseite speichern"));
            datei.add(new JMenuItem("Suchen"));
            datei.add(new JSeparator());
            datei.add(new JMenuItem("Versionen"));
            datei.add(new JSeparator());
            datei.add(new JMenuItem("Webseitenvorschau"));
            datei.add(new JSeparator());
            datei.add(new JMenuItem("Seite einrichten..."));
            datei.add(new JMenuItem("Seitenansicht"));
            datei.add(new JMenuItem("Drucken"));
            datei.add(new JSeparator());
                JMenu sendenAn = new JMenu("Senden an");
                sendenAn.add(new JMenuItem("E-Mail-Empfänger"));
                sendenAn.add(new JMenuItem("E-Mail-Empfänger (zur Überarbeitung)"));
                sendenAn.add(new JMenuItem("E-Mail-Empfänger (als Anlage)"));
                sendenAn.add(new JSeparator());
                sendenAn.add(new JMenuItem("Verteilerempfänger..."));
                sendenAn.add(new JMenuItem("Onlinebesprechungsteilnehmer"));
                sendenAn.add(new JMenuItem("Exchange-Ordner"));
                sendenAn.add(new JMenuItem("Fax-Empfänger"));
                sendenAn.add(new JSeparator());
                sendenAn.add(new JMenuItem("Microsoft PowerPoint"));
            datei.add(sendenAn);
            datei.add(new JMenuItem("Eigenschaften"));
            datei.add(new JSeparator());
            datei.add(new JMenuItem("bilanz_2017.doc"));
            datei.add(new JMenuItem("bericht_2018_01.doc"));
            datei.add(new JMenuItem("ziele.doc"));
            datei.add(new JSeparator());
            datei.add(new JMenuItem("Beenden"));

            bearbeiten.add(new JMenuItem("Rückgängig"));
            bearbeiten.add(new JMenuItem("Wiederholen"));
            bearbeiten.add(new JSeparator());
            bearbeiten.add(new JMenuItem("Ausschneiden"));
            bearbeiten.add(new JMenuItem("Kopieren"));
            bearbeiten.add(new JMenuItem("Office-Zwischenablage"));
            bearbeiten.add(new JMenuItem("Einfügen"));
            bearbeiten.add(new JMenuItem("Inhalte einfügen"));
            bearbeiten.add(new JMenuItem("Als Hyperlink einfügen"));
            bearbeiten.add(new JSeparator());
            bearbeiten.add(new JMenuItem("Löschen"));
            bearbeiten.add(new JMenuItem("Alles markieren"));
            bearbeiten.add(new JSeparator());
            bearbeiten.add(new JMenuItem("Suchen..."));
            bearbeiten.add(new JSeparator());
            bearbeiten.add(new JMenuItem("Ersetzen..."));
            bearbeiten.add(new JMenuItem("Gehe zu..."));
            bearbeiten.add(new JSeparator());
            bearbeiten.add(new JMenuItem("Verknüpfungen..."));
            bearbeiten.add(new JMenuItem("Objekt"));

        this.setSize(500, 600);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }


    public static void main(String[] args) {
        new EditorSimple();
    }
}
