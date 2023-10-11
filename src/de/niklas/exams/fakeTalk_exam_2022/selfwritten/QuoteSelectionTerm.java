package de.niklas.exams.fakeTalk_exam_2022.selfwritten;
import javax.swing.*;
import java.awt.*;
import java.nio.file.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class QuoteSelectionTerm extends JFrame implements Runnable {

    private boolean gameIsStarted = false;
    private List<FakeTalkClient> clients = new ArrayList<>();
    private int activeClient = 0;
    private List<Quote> quoteList;
    private List<QuoteButton> buttonList = new ArrayList<>();
    private JLabel playerLabel = new JLabel("");
    private JLabel remainingPoints = new JLabel("10");
    private boolean shouldRun = false;

    public QuoteSelectionTerm(List<Quote> quotes, int rows, int cols) throws FakeNewsException {
        if(rows*cols > quotes.size()){
            throw new FakeNewsException("Provided quote catalog does not contain enough (hot|bull)shit!");
        }

        Set<Quote> tempSet = new HashSet<Quote>();
        while(tempSet.size() < rows*cols){
            int rand = new Random().nextInt(quotes.size());
            tempSet.add(quotes.get(rand));
            quotes.remove(rand);
        }
        quoteList = tempSet.stream().toList();

        this.setTitle("FakeTalk");
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        northPanel.add(new JLabel("Pick a quote:"));
        northPanel.add(playerLabel);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(rows, cols));
        for(Quote quote : quoteList){
            QuoteButton button = new QuoteButton();
            button.setIcon(QuoteType.UNKNOWN.getIcon());
            button.setBackground(QuoteType.UNKNOWN.getColor());
            button.addActionListener(e -> pickQuote(quote));
            button.setEnabled(false);
            buttonList.add(button);
            centerPanel.add(button);
        }

        JPanel southPanel = new JPanel();
        southPanel.add(remainingPoints);
        southPanel.add(new JLabel("Points"));

        this.add(northPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);
//        this.pack();
        this.setSize(500, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void pickQuote(Quote quote){
        for(Quote q : quoteList){
            if(q == quote){
                clients.get(activeClient).setQuote(quote);
                new Thread(this).start();
                return;
            }
        }
    }

    public void register(FakeTalkClient client) throws FakeNewsException {
        if(gameIsStarted){
            throw new FakeNewsException("Game already started");
        }
        clients.add(client);
    }

    public void start() throws FakeNewsException {
        if(gameIsStarted){ return; }
        if(clients.size() < 2){
            throw new FakeNewsException("Less then 2 players registered");
        }
        gameIsStarted = true;
        for(QuoteButton button : buttonList){
            button.setEnabled(true);
        }
        playerLabel.setText(clients.get(activeClient).getPlayerName());
    }

    public void answerSelected(FakeTalkClient client, Quote q, QuoteType selectedType){
        shouldRun = false;
        JOptionPane.showMessageDialog(null, q.getCitation(), "Meldung", JOptionPane.INFORMATION_MESSAGE);
        if(q.getQuoteType() == selectedType){
            client.addPoints(Integer.parseInt(remainingPoints.getText()));
        }

        boolean allAreUnknown = true;
        for(int i = 0; i < quoteList.size(); i++){
            if(quoteList.get(i) == q){
                buttonList.get(i).setEnabled(false);
                buttonList.get(i).setType(selectedType);
            }
            else if(buttonList.get(i).isUnknown()){
                buttonList.get(i).setEnabled(true);
                allAreUnknown = false;
            }
        }
        if(allAreUnknown){
            StringBuilder builder = new StringBuilder();
            for(FakeTalkClient c : clients){
                builder.append(c).append(", ");
            }
            String info = String.format("Game finished. Score: %s", builder.substring(0, builder.length() - 2));
            JOptionPane.showMessageDialog(null, info, "Game finished!", JOptionPane.INFORMATION_MESSAGE);

            String filename = "fake-score.txt";
            try {
                Files.writeString(Paths.get(filename),
                    info + System.lineSeparator(),
                    StandardOpenOption.APPEND,
                    StandardOpenOption.CREATE
                );
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        else{
            activeClient = (activeClient + 1) % clients.size();
            playerLabel.setText(clients.get(activeClient).getPlayerName());
            remainingPoints.setText("10");
        }
    }

    @Override
    public void run() {
        shouldRun = true;
        for(int i = 10; shouldRun & i > 0; i--) {
            try {
                Thread.sleep(1000);
                remainingPoints.setText("" + i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
