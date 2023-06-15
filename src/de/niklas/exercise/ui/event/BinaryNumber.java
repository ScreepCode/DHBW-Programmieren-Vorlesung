package de.niklas.exercise.ui.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <strong>Binäre Zahlen</strong><br>
 * Eine zusammensetzung mit Binären Zahlen mit Verwendung von Icons
 *
 * @see "23_Events_Aufgaben-1.pdf"
 * @author Niklas Buse
 */
public class BinaryNumber extends JFrame implements ActionListener {

    JToggleButton[] buttons;
    JLabel output_label;

    public BinaryNumber(int size){
        super("BinaryNumber");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttons = new JToggleButton[size];

        JPanel main_panel = new JPanel();
        main_panel.setLayout(new BorderLayout());

        JPanel button_panel = new JPanel();
        button_panel.setLayout(new GridLayout(2, buttons.length));                              // Anzahl Spalten entspricht der Anzahl der Buttons
        ImageIcon imgOff = new ImageIcon("src/de/niklas/exercise/ui/event/icons/off.png");
        ImageIcon imgOn = new ImageIcon("src/de/niklas/exercise/ui/event/icons/on.png");
        for(int i = buttons.length-1; i >= 0; i--){                                                    // Jeder Button bekommt: Icons, ActionListener und wird hinzugefügt
            buttons[i] = new JToggleButton();
            buttons[i].setIcon(imgOff); // icon if not selected (default icon)
            buttons[i].setSelectedIcon(imgOn); // icon if selected
            buttons[i].addActionListener(this);
            button_panel.add(buttons[i]);
        }
        for(int i = buttons.length-1; i >= 0; i--){
            button_panel.add(new Label(String.format("2^%d", i)));                                  // Labels werden für den Nutzer hinzugefügt, um die Logik zu verstehen
        }

        JPanel output_panel = new JPanel();
        output_label = new JLabel("0");
        output_panel.add(output_label);

        main_panel.add(button_panel, BorderLayout.NORTH);
        main_panel.add(output_panel, BorderLayout.SOUTH);

        this.add(main_panel);
        this.pack();                                        // Automatische anpassung an Anzahl der Buttons
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int outputNumber = 0;
        for(int i = buttons.length-1; i >= 0; i--){
            if(buttons[i].isSelected()){
                outputNumber += Math.pow(2, i);
            }
        }
        output_label.setText(String.format("%d", outputNumber));
    }

    public static void main(String[] args) {
        new BinaryNumber(8);
    }
}
