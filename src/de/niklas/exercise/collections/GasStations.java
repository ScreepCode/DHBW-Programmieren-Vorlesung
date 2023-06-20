package de.niklas.exercise.collections;

import java.util.*;
import javax.swing.*;
import java.awt.*;

/**
 * <strong>Tankstellenpreise</strong><br>
 * Eine GUI um Tankstellenpreise in einer HashMap zu speichern
 *
 * @see "25_Datenstrukturen_Aufgaben-3.pdf"
 * @author Niklas Buse
 */
public class GasStations extends JFrame {

    private JTextField stationField, dieselField, e5Field, e10Field;
    Map<String, GasPrices> gasPricesMap = new HashMap<>();

    public GasStations() {
        renderGUI();
    }

    /**
     * Erstellen der GUI für die Anwendung
     */
    private void renderGUI() {
        JFrame frame = new JFrame("GasStations");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel main_panel = new JPanel();
        main_panel.setLayout(new GridLayout(5, 2));

        main_panel.add(new Label("Station Name:"));
        stationField = new JTextField(15);
        main_panel.add(stationField);

        main_panel.add(new Label("Diesel:"));
        dieselField = new JTextField(15);
        main_panel.add(dieselField);

        main_panel.add(new Label("Super E5:"));
        e5Field = new JTextField(15);
        main_panel.add(e5Field);

        main_panel.add(new Label("Super E10:"));
        e10Field = new JTextField(15);
        main_panel.add(e10Field);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> save());
        main_panel.add(saveButton);
        JButton showButton = new JButton("Show all");
        showButton.addActionListener(e -> showAll());
        main_panel.add(showButton);

        frame.add(main_panel);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    /**
     * Speichern der in der GUI eingetragen Werte inkl. Fehlerbehandlung
     */
    public void save() {
        String stationName = this.stationField.getText();
        if (stationName.equals("") | stationName.isBlank() | stationName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please provide a Name!");
        } else {
            double diesel, e5, e10;
            try {
                diesel = Double.parseDouble(this.dieselField.getText().replace(",", "."));
            } catch (NumberFormatException e) {
                diesel = -1;
            }
            try {
                e5 = Double.parseDouble(this.e5Field.getText().replace(",", "."));
            } catch (Exception e) {
                e5 = -1;
            }
            try {
                e10 = Double.parseDouble(this.e10Field.getText().replace(",", "."));
            } catch (Exception e) {
                e10 = -1;
            }

            gasPricesMap.put(stationName, new GasPrices(diesel, e5, e10));

            JOptionPane.showMessageDialog(null, String.format("Saved: %s", gasPricesMap.get(this.stationField.getText())));
            stationField.setText("");
            dieselField.setText("");
            e5Field.setText("");
            e10Field.setText("");
        }
    }

    /**
     * Ausgeben der aktuell in der Map gespeicherten Einträge im MessageDialog
     */
    public void showAll() {
        StringBuilder stringBuilder = new StringBuilder();
        gasPricesMap.forEach((key, value) -> stringBuilder.append(key).append(": ").append(value));
        JOptionPane.showMessageDialog(null, stringBuilder.toString());
    }


    public static void main(String[] args) {
        new GasStations();
    }
}

/**
 * Basis Klasse für die Gaspreise
 */
class GasPrices {
    double diesel, superE5, superE10;

    public GasPrices(double diesel, double superE5, double superE10) {
        this.diesel = diesel;
        this.superE5 = superE5;
        this.superE10 = superE10;
    }

    /**
     * Überschreibt die toString() für anderen Stil
     * @return Gaspreise als String
     */
    @Override
    public String toString() {
        return String.format("Diesel: %.2f, SuperE5: %.2f, SuperE10: %.2f\n", diesel, superE5, superE10);
    }
}