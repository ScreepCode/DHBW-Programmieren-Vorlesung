package de.niklas.exams.fasid_extra_exam_2022.selfwritten;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.List;
public class BettingTerm extends JFrame {

    private Player player;
    private List<Match> matches;
    private Iterator<Match> matchIterator;
    private Match activeMatch;
    private FasidTerm fasidTerm;
    private JLabel headingLabel, detailsLabel;
    private JButton betButton;
    private ButtonGroup buttonGroup;


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
        for(ResultType type : ResultType.values()){   // for all enum values
            if(type == ResultType.UNKNOWN) continue;  // used to skip enum values
            JRadioButton radioButton = new JRadioButton(type.getLabel());
            radioButton.setActionCommand(type.getLabel()); // way to get a String from selected button to check
            buttonGroup.add(radioButton);
            buttonPanel.add(radioButton);
        }
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
        String actionCommand = buttonGroup.getSelection().getActionCommand();

        if(buttonGroup.getSelection() != null){
            if (actionCommand.equals(ResultType.HOME.getLabel())){
                activeMatch.setResultType(ResultType.HOME);
            }
            else if(actionCommand.equals(ResultType.DRAW.getLabel())) {
                activeMatch.setResultType(ResultType.DRAW);
            }
            else if(actionCommand.equals(ResultType.GUEST.getLabel())) {
                activeMatch.setResultType(ResultType.GUEST);
            }
            else if(actionCommand.equals(ResultType.FASID.getLabel())) {
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
