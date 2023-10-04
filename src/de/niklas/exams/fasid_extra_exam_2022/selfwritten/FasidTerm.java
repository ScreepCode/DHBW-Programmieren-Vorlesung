package de.niklas.exams.fasid_extra_exam_2022.selfwritten;

import de.niklas.exams.fasid_extra_exam_2022.provided.FasidAlarmLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.List;

public class FasidTerm extends JFrame implements CorruptionPrevention, Runnable{

    private List<Match> matches;
    private Player[] players;
    private JTextArea textArea;
    private FasidAlarmLabel alarmLabel = new FasidAlarmLabel();

    public FasidTerm(List<Match> matches, Player[] players) throws FasidException {
        this.matches = matches;
        this.players = players;

        if(matches.isEmpty()){
            throw new FasidException("Not enough matches");
        }
        if(players.length == 0){
            throw new FasidException("Not enough players");
        }

        // GUI
        this.setTitle("FA$ID® World Cup");
        this.setLayout(new BorderLayout());

        JPanel playerPanel = new JPanel();
        playerPanel.setLayout(new GridLayout(players.length, 1));
        for (Player player : players) {
            JButton playerButton = new JButton(String.format("Start betting, player %s", player.getName()));
            playerPanel.add(playerButton);
            playerButton.addActionListener(e -> openingBettingTerm(e, player));
        }

        JPanel logPanel = new JPanel();
        textArea = new JTextArea(30, 60);
        logPanel.add(textArea);



        this.add(playerPanel, BorderLayout.NORTH);
        this.add(logPanel, BorderLayout.CENTER);
        this.add(alarmLabel, BorderLayout.SOUTH);
         this.pack();
//        this.setSize(500, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void openingBettingTerm(ActionEvent event, Player player){
        JButton eventButton = (JButton) event.getSource();
        new BettingTerm(player, matches, this);
        eventButton.setEnabled(false);
    }

    public void reportBet(Player player, Match match){
        if(match.getResultType() == ResultType.FASID & 1 == new Random().nextInt(3)){
            fasid(player);
        }
        else{
            alarmLabel.hideFasidAlam();
        }
        String out = String.format("Player %s bets '%s' on match %s", player, match.getResultType(), match);
        textArea.setText(textArea.getText() + out + System.lineSeparator());

        String filename = "src/de/niklas/exams/fasid_extra_exam_2022/selfwritten/fasid.txt";
        try {
            Files.writeString(Paths.get(filename),
                out + System.lineSeparator(),
                StandardOpenOption.APPEND,
                StandardOpenOption.CREATE
            );
        } catch (IOException ex) {}
    }

    @Override
    public void fasid(Player player) {
        alarmLabel.setFasidAlarm(player.toString());
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        alarmLabel.hideFasidAlam();
    }
}
