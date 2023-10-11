package de.niklas.exams.cts_extra_exam_2019;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class StockExchangeTerm extends JFrame implements Runnable{

    private HashMap<String, Integer> companyHashMap = new HashMap<String, Integer>();
    private ArrayList<CompanyTerm> companies = new ArrayList<CompanyTerm>();
    private float price = 25.0F;
    private JTextArea logArea;

    public StockExchangeTerm(){
        this.setTitle("Stock Exchange Terminal");

        logArea = new JTextArea();
        logArea.setEditable(false);

        this.add(logArea, BorderLayout.CENTER);
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        new Thread(this).start();
    }

    public void registerCompanyTerm(CompanyTerm company){
        companies.add(company);
        companyHashMap.put(company.getCompany().getName(), 0);
        refreshTerminal();
    }

    public void unregisterCompanyTerm(CompanyTerm company){
        companies.remove(company);
        companyHashMap.remove(company.getCompany().getName());
        refreshTerminal();
    }

    public float purchase(Company company, GreenhouseGas ghg, int tons){
        float costs = ghg.getGlobalWarmingPotential() * (tons * price);
        int  vorher = companyHashMap.get(company.getName());
        companyHashMap.put(company.getName(), vorher + (ghg.getGlobalWarmingPotential() * tons));
        price += (float) (price * 0.1);
        for(CompanyTerm companyTerm : companies){
            companyTerm.updatePrice();
        }
        refreshTerminal();
        writeFile(company, tons, ghg.getName(), costs);
        return costs;
    }

    private void refreshTerminal(){
        Collections.sort(companies);
        StringBuilder content = new StringBuilder();
        for(CompanyTerm companyTerm : companies){
            String company = companyTerm.getCompany().getName();
            int tons = companyHashMap.get(company);
            String message = String.format("%s: %d tons CO2 equivalent \n", companyTerm.getCompany().getAbbr(), tons);
            content.append(message);
        }
        logArea.setText(content.toString());
    }

    private void writeFile(Company company, int tons, String nameGHG, float price){
        String line = String.format("%s (%s) purchased %d tons of %s for EUR %.2f.", company.getName(), company.getLocation(), tons, nameGHG, price);
        String filename = "purchases.txt";
        try {
            Files.writeString(Paths.get(filename),
                line + System.lineSeparator(),
                StandardOpenOption.APPEND,
                StandardOpenOption.CREATE
            );
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public float getPrice() {
        return price;
    }

    @Override
    public void run() {
        float ursprungsPreis = price;
        while(price < (ursprungsPreis * 10)){
            try {
                Thread.sleep(15000);
                price += (float) (price * 0.2);
                for(CompanyTerm companyTerm : companies){
                    companyTerm.updatePrice();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
