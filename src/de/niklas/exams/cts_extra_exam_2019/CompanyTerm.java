package de.niklas.exams.cts_extra_exam_2019;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CompanyTerm extends JFrame implements Comparable<CompanyTerm>{

    private Company company;
    private StockExchangeTerm stockExchangeTerm;
    private JLabel priceLabel = new JLabel("Price per ton CO2 equivalent: 0.00 EUR");
    private ArrayList<JTextField> inputsField = new ArrayList<>();

    public CompanyTerm(Company company, StockExchangeTerm stockExchangeTerm){
        this.company = company;
        this.stockExchangeTerm = stockExchangeTerm;

        this.setTitle(String.format("%s - Certificate Purchase Terminal", company));

        JPanel mainPanel = new JPanel(new GridLayout(GreenhouseGas.values().length, 3));
        for(GreenhouseGas gh : GreenhouseGas.values()){
            mainPanel.add(new JLabel(gh.getName()));
            JTextField textField = new JTextField();
            textField.setText("0");
            mainPanel.add(textField);
            inputsField.add(textField);

            JButton button = new JButton("Purchase");
            button.addActionListener(e -> purchase(gh.getName()));
            mainPanel.add(button);
        }
        updatePrice();


        this.add(priceLabel, BorderLayout.NORTH);
        this.add(mainPanel, BorderLayout.CENTER);
        // this.pack();
        this.setSize(500, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }


    public void updatePrice(){
        priceLabel.setText(String.format("Price per ton CO2 equivalent: %.2f EUR", stockExchangeTerm.getPrice()));
    }


    private void purchase(String nameOfGH){
        JTextField textField;
        GreenhouseGas ghg;
        if(nameOfGH.equals(GreenhouseGas.CARBON_DIOXIDE.getName())){
            textField = inputsField.get(0);
            ghg = GreenhouseGas.CARBON_DIOXIDE;
        }
        else if (nameOfGH.equals(GreenhouseGas.METHANE.getName())){
            textField = inputsField.get(1);
            ghg = GreenhouseGas.METHANE;
        }
        else if (nameOfGH.equals(GreenhouseGas.NITROUS_OXIDE.getName())){
            textField = inputsField.get(2);
            ghg = GreenhouseGas.NITROUS_OXIDE;
        }
        else{
            System.out.println("Dem Button kann kein Textfeld zugeordnet werden");
            return;
        }

        String content = textField.getText();
        try{
            int tons = Integer.parseInt(content);
            if(tons < 1){
                JOptionPane.showMessageDialog(null, "You must purchase certificates for least 1 ton", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            float paidSum = stockExchangeTerm.purchase(company, ghg, tons);
            JOptionPane.showMessageDialog(null, String.format("Price of transaction: %.3f EUR", paidSum), "Meldung", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(null, String.format("Invalid input: %s", content), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    public Company getCompany() {
        return company;
    }

    @Override
    public int compareTo(CompanyTerm otherCompany) {
        return company.getName().compareTo(otherCompany.getCompany().getName());
    }
}
