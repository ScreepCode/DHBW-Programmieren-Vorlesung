package de.niklas.exercise.ui.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <strong>Währungsumrechner (2)</strong><br>
 * Einen Mini Währungsrechner inkl. Funktion
 *
 * @see "23_Events_Aufgaben-1.pdf"
 * @author Niklas Buse
 */
public class CurrencyCalculator extends JFrame implements ActionListener {

    JButton usdToEuro;
    JButton euroToUsd;
    JTextField textField;
    public CurrencyCalculator(){
        super("Currency Converter");
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textField = new JTextField(); //"Please enter amount to convert!"
        euroToUsd = new JButton("EUR -> USD");
        euroToUsd.addActionListener(this);
        usdToEuro = new JButton("USD -> EUR");
        usdToEuro.addActionListener(this);
        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(e -> System.exit(0)); // Hier wird diese Form gewählt, da hier nicht wirklich viel Logik drin steht

        this.add(textField, BorderLayout.NORTH);
        this.add(euroToUsd, BorderLayout.WEST);
        this.add(usdToEuro, BorderLayout.CENTER);
        this.add(cancel, BorderLayout.EAST);

        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == euroToUsd || e.getSource() == usdToEuro) {
            try {
                String text = textField.getText();
                double number = Double.parseDouble(text);
                if (e.getSource() == euroToUsd) {
                    number = number * 1.09;
                } else if (e.getSource() == usdToEuro) {
                    number = number / 1.09;
                }
                textField.setText(String.format("%.2f", number));
            } catch (Exception ex) {
                textField.setText("eine Fehlermeldung");
            }
        }
    }

    public static void main(String[] args) {
        new CurrencyCalculator();
    }
}
