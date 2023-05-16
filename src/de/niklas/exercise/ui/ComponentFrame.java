package de.niklas.exercise.ui;
import javax.swing.*;

/**
 * <strong>Swing-Grundkomponenten</strong><br>
 * Die Klasse zeigt die Grundkomponenten von Java-Swing
 *
 * @see "20_Swing_Aufgaben-1.pdf"
 * @author Niklas Buse
 */
public class ComponentFrame extends JFrame{                                                // Wir erben von JFrame

    public ComponentFrame(){         // Frame als Top-Level-Container
        this.setTitle("Several basic Swing components");                                   // Setze Titel des Fensters
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                               // Operation auf dem x → Beenden

        JPanel panel = new JPanel();                                                        // JPanel → Darauf werden alle Komponenten geschrieben, ggf. später anderes Layout oder mehrere Panels auf einem Frame
        panel.add(new JLabel("JLabel"));                                               // Die folgenden Objekte werden alle auf das Panel geschrieben mit einem Text bzw. Platzhalter
        panel.add(new JTextField("JTextField"));
        panel.add(new JPasswordField("JPasswordField"));
        panel.add(new JButton("JButton"));
        panel.add(new JToggleButton("JToggleButton"));
        panel.add(new JCheckBox("JCheckBox"));
//        panel.add(new JComboBox(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));   // Man kann die Combobox auch mit einem vorher festgelegten Array initialisieren
        JComboBox comboBox = new JComboBox();                                               //    oder wie hier dynamisch mit addItem
        for(int i = 0; i <= 3; i++){
            comboBox.addItem("Item" + (i+1));
            comboBox.addItem("Item" + (i+1));
        }
        panel.add(comboBox);
        ButtonGroup buttonGroup = new ButtonGroup();                                        // Hier erstelle ich eine ButtonGroup, dies ist keine sichtbare, sondern eine "Logische" Komponente
        for(int i = 0; i <=2 ; i++){                                                        // Daher wird hier jeder Radiobutton sowohl in die Gruppe, als auch auf das Panel hinzugefügt
            JRadioButton radioButton = new JRadioButton("Radio-Button-" + (i+1));
            buttonGroup.add(radioButton);
            panel.add(radioButton);
        }

        this.add(panel);                                                                    // Das Panel wird jetzt auf das Frame gepackt
        this.setSize(600, 100);                                                // Die Größe wird hier festgelegt
//        frame.pack();                                                                      //   oder mit pack auf die Größe der Items gesetzt (bei Floatlayout (Standard) dann meist nur in einer Zeile
        this.setLocationRelativeTo(null);                                                   // Hiermit platziere ich das Fenster in der Mitte des Bildschirms
        this.setVisible(true);                                                              // Das Fenster wird noch Sichtbar
    }

    public static void main(String[] args) {
        new ComponentFrame();
    }

}
