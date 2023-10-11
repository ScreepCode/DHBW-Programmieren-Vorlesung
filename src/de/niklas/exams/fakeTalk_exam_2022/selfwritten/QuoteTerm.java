package de.niklas.exams.fakeTalk_exam_2022.selfwritten;
import de.niklas.exams.fakeTalk_exam_2022.provided.QuoteDisplay;

import javax.swing.*;
import java.awt.*;

public class QuoteTerm extends JFrame implements FakeTalkClient {

    private String name;
    private QuoteSelectionTerm selectionTerm;
    private QuoteDisplay display = new QuoteDisplay();
    private Quote activeQuote = null;
    private JButton hotShit, bullshit;
    private JLabel pointsLabel = new JLabel("0");
    private int points = 0;

    public QuoteTerm(String name, QuoteSelectionTerm selectionTerm) {
        this.name = name;
        this.selectionTerm = selectionTerm;

        this.setTitle(name);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        hotShit = new JButton();
        bullshit = new JButton();
        hotShit.setIcon(QuoteType.HOT_SHIT.getIcon());
        bullshit.setIcon(QuoteType.BULLSHIT.getIcon());
        hotShit.setEnabled(false);
        bullshit.setEnabled(false);
        hotShit.addActionListener(e -> selectAnswer(QuoteType.HOT_SHIT));
        bullshit.addActionListener(e  -> selectAnswer(QuoteType.BULLSHIT));

        buttonPanel.add(hotShit);
        buttonPanel.add(bullshit);

        JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        labelPanel.add(pointsLabel);
        labelPanel.add(new JLabel(" Points"));

        this.add(display, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.CENTER);
        this.add(labelPanel, BorderLayout.SOUTH);
        // this.pack();
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void selectAnswer(QuoteType type){
        selectionTerm.answerSelected(this, activeQuote, type);
        display.setText("");
        hotShit.setEnabled(false);
        bullshit.setEnabled(false);
    }

    @Override
    public String getPlayerName() {
        return name;
    }

    @Override
    public void setQuote(Quote q) {
        activeQuote = q;
        display.setText(q.getText());
        hotShit.setEnabled(true);
        bullshit.setEnabled(true);
    }

    @Override
    public void addPoints(int points) {
        this.points += points;
        pointsLabel.setText("" + points);
    }

    @Override
    public int getPoints() {
        return points;
    }
}
