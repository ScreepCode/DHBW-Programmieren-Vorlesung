package de.niklas.exercise.ui.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <strong>Body-Mass-Index (BMI)</strong><br>
 * Einen Mini BMI Rechner
 *
 * @see "23_Events_Aufgaben-1.pdf"
 * @author Niklas Buse
 */
public class BMICalculator extends JFrame implements ActionListener {

    JTextField weight_input;
    JTextField height_input;
    JRadioButton gender_male;
    JRadioButton gender_female;
    JButton calculate_button;
    JTextField bmi_calculated_output;
    JTextField bmi_evaluation;

    public BMICalculator(){
        super("BMI Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel main_panel = new JPanel();
        main_panel.setLayout(new GridLayout(5, 1));

        JPanel weight_panel = new JPanel();
        JLabel weight_label = new JLabel("Weight [kg]:");
        weight_panel.add(weight_label);
        weight_input = new JTextField(15);
        weight_panel.add(weight_input);

        JPanel height_panel = new JPanel();
        JLabel height_label = new JLabel("Body height [m]:");
        height_panel.add(height_label);
        height_input = new JTextField(15);
        height_panel.add(height_input);

        JPanel gender_panel = new JPanel();
        ButtonGroup gender_group = new ButtonGroup();
        gender_male = new JRadioButton("male");
        gender_group.add(gender_male);
        gender_panel.add(gender_male);
        gender_male.setSelected(true);
        gender_female = new JRadioButton("female");
        gender_group.add(gender_female);
        gender_panel.add(gender_female);

        JPanel calculate_panel = new JPanel();
        calculate_button = new JButton("Calculate");
        calculate_button.addActionListener(this);
        calculate_panel.add(calculate_button);

        JPanel bmi_panel = new JPanel();
        JLabel bmi_label = new JLabel("BMI:");
        bmi_panel.add(bmi_label);
        bmi_calculated_output = new JTextField(17);
        bmi_calculated_output.setEnabled(false);
        bmi_panel.add(bmi_calculated_output);
        bmi_evaluation = new JTextField(20);
        bmi_evaluation.setEnabled(false);
        bmi_panel.add(bmi_evaluation);

        main_panel.add(weight_panel, 0);
        main_panel.add(height_panel, 1);
        main_panel.add(gender_panel, 2);
        main_panel.add(calculate_panel, 3);
        main_panel.add(bmi_panel, 4);

        this.add(main_panel);
        this.setSize(300, 270);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == calculate_button){
            try{
                double weight = Double.parseDouble(weight_input.getText().replace(",","."));
                double height = Double.parseDouble(height_input.getText().replace(",","."));
                double bmi = weight/(height*height);
                bmi_calculated_output.setText(String.format("%f", bmi));
                bmi_evaluation.setText(evaluate_bmi(bmi));
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    /**
     * Auswertung des BMI in eine wörtliche Einordnung
     * @param bmi als Zahl
     * @return BMI Auswertung als String
     */
    public String evaluate_bmi(double bmi){
        if(gender_male.isSelected() & (bmi < 20) |
                gender_female.isSelected() & (bmi < 19)){
            return "Untergewicht";
        }
        else if(gender_male.isSelected() & (bmi > 20 & bmi < 25) |
                gender_female.isSelected() & (bmi > 19 & bmi < 24)){
            return "Normalgewicht";
        }
        else if(gender_male.isSelected() & (bmi > 25 & bmi < 30) |
                gender_female.isSelected() & (bmi > 24 & bmi < 30)){
            return "Übergewicht";
        }
        else if(gender_male.isSelected() & (bmi > 30 & bmi < 40) |
                gender_female.isSelected() & (bmi > 30 & bmi < 40)){
            return "Adipositas";
        }
        else if(gender_male.isSelected() & (bmi > 40) |
                gender_female.isSelected() & (bmi > 40)){
            return "massive Adipositas";
        }
        return "NUR EINZELN AUF DIE WAAGE!!!";
    }

    public static void main(String[] args) {
        new BMICalculator();
    }
}
