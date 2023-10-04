package de.niklas.exams.fasid_extra_exam_2022.selfwritten;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.List;
public class BettingTerm extends JFrame {

    private Player player;
    private List<Match> matches;
    Iterator<Match> matchIterator;
    Match activeMatch;
    private FasidTerm fasidTerm;
    private JLabel headingLabel, detailsLabel;
    JButton betButton;
    ButtonGroup buttonGroup;
    JRadioButton homeRadio, drawRadio, guestRadio, fasidRadio;


    public BettingTerm(Player player, List<Match> matches, FasidTerm fasidTerm) {
        this.player = player;
        this.matches = matches;
        matchIterator = matches.iterator();
        this.fasidTerm = fasidTerm;

        this.setTitle(String.format("%s´s BettingTerm", player.getName()));
        this.setLayout(new GridLayout(4, 1));
        headingLabel = new JLabel();
        headingLabel.setHorizontalAlignment(JLabel.CENTER);
        detailsLabel = new JLabel();
        detailsLabel.setHorizontalAlignment(JLabel.CENTER);

        betButton = new JButton("Bet");
        betButton.setSize(500, 50);
        betButton.addActionListener(e -> saveBet());

        this.add(headingLabel);
        this.add(detailsLabel);
        this.add(renderButtons());
        this.add(betButton);
        // this.pack();
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        renderNextGameToBet();
    }

    private JPanel renderButtons() {
        JPanel buttonPanel = new JPanel();
        buttonGroup = new ButtonGroup();
        homeRadio = new JRadioButton(ResultType.HOME.getLabel());
        drawRadio = new JRadioButton(ResultType.DRAW.getLabel());
        guestRadio = new JRadioButton(ResultType.GUEST.getLabel());
        fasidRadio = new JRadioButton(ResultType.FASID.getLabel());
        buttonGroup.add(homeRadio);
        buttonPanel.add(homeRadio);
        buttonGroup.add(drawRadio);
        buttonPanel.add(drawRadio);
        buttonGroup.add(guestRadio);
        buttonPanel.add(guestRadio);
        buttonGroup.add(fasidRadio);
        buttonPanel.add(fasidRadio);
        return buttonPanel;
    }

    public void renderNextGameToBet(){
        while(matchIterator.hasNext()){
            Match match = matchIterator.next();
            if (!match.hasResult()) {
                activeMatch = match;
                headingLabel.setText(match.toString());
                detailsLabel.setText(match.getMatchInformation());
                return;
            }
        }
        betButton.setEnabled(false);
    }

    public void saveBet(){
        if(buttonGroup.getSelection() != null){
            if(homeRadio.isSelected()){
                activeMatch.setResultType(ResultType.HOME);
            }
            else if(drawRadio.isSelected()){
                activeMatch.setResultType(ResultType.DRAW);
            }
            else if(guestRadio.isSelected()){
                activeMatch.setResultType(ResultType.GUEST);
            }
            else if(fasidRadio.isSelected()){
                activeMatch.setResultType(ResultType.FASID);
            }
            fasidTerm.reportBet(player, activeMatch);
            renderNextGameToBet();
        }
        else{
            JOptionPane.showMessageDialog(null, "Please select a match result type", "Meldung", JOptionPane.INFORMATION_MESSAGE);;
        }
    }
}
