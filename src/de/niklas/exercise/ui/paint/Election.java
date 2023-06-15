package de.niklas.exercise.ui.paint;

import java.awt.*;
import javax.swing.*;

/**
 * <strong>Wahl</strong><br>
 * Zeichnen der Bundestagsergebnisse in einem dynamischen Fenster
 * Mir wurde von Theresa freundlicherweise das Zeichnen zur Verfügung gestellt
 *
 * @see "24_Zeichnen_Aufgaben.pdf"
 * @author Niklas Buse (& Theresa Geber)
 */
public class Election extends JComponent {
    ElectionResult[] electionResults;

    public Election(ElectionResult[] electionResults){
        this.electionResults = electionResults;
    }

    protected void paintComponent(Graphics g) {
        int bottom = getHeight() - (getWidth() * 8) /100;
        int spaceBetween = getWidth() / 100;
        int width = (getWidth() / electionResults.length) - (2 * spaceBetween);
        System.out.println(width);

        g.drawLine(10, bottom, getWidth() - 10, bottom);
        for (ElectionResult electionResult : electionResults) {
            double percent = electionResult.getVote();
            String partyName = electionResult.getParty();
            int recHeight = (getHeight() * ((int) percent * 2)) / 100;

            g.setColor(electionResult.getColor());
            g.fillRect(spaceBetween, bottom - recHeight, width, recHeight);
            g.setColor(Color.BLACK);
            g.drawString(partyName, spaceBetween, bottom + 20);
            g.drawString(String.format("%.2f %%", percent), 2 + spaceBetween, bottom + 35);
            spaceBetween += (getWidth() * 2) / 100 + width;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Bundeswahl 2017");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);

        ElectionResult[] electionResults = new ElectionResult[]{
                new ElectionResult("Union", 33.0, new Color(0,0,0)),
                new ElectionResult("SPD", 20.5, new Color(244,0,0)),
                new ElectionResult("AfD", 12.6, new Color(29,15,255)),
                new ElectionResult("FDP", 10.7, new Color(254,254,0)),
                new ElectionResult("Linke", 9.2, new Color(245,0,255)),
                new ElectionResult("Grüne", 8.9, new Color(81,255,0)),
                new ElectionResult("Andere", 5.1, new Color(64,64,64))
        };

        Election election = new Election(electionResults);

        frame.add(election);
        frame.setVisible(true);
    }
}

/**
 * Diese interne Klasse ist aus OOP Sicht für die einzelnen Wahlergebnisse
 */
class ElectionResult {
    String party;
    double vote;
    Color color;

    public ElectionResult(String party, double vote, Color color) {
        this.party = party;
        this.vote = vote;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public double getVote() {
        return vote;
    }

    public void setVote(double vote) {
        this.vote = vote;
    }
}
