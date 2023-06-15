package de.niklas.exercise.ui;

import javax.swing.*;
import java.awt.*;

/**
 * <strong>Währungsumrechner</strong><br>
 * Einen Mini Währungsrechner ohne Funktion
 *
 * @see "20_Swing_Aufgaben-2.pdf"
 * @author Niklas Buse
 */
public class CurrencyCalculator extends JFrame {

    public CurrencyCalculator(){
        super("Currency Converter");
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField textField = new JTextField(); //"Please enter amount to convert!"
        JButton euroToUsd = new JButton("EUR -> USD");
        JButton usdToEuro = new JButton("USD -> EUR");
        JButton cancel = new JButton("Cancel");

        this.add(textField, BorderLayout.NORTH);
        this.add(euroToUsd, BorderLayout.WEST);
        this.add(usdToEuro, BorderLayout.CENTER);
        this.add(cancel, BorderLayout.EAST);

        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new CurrencyCalculator();
    }
}
