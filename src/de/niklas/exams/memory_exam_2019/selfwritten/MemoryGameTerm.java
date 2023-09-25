package de.niklas.exams.memory_exam_2019.selfwritten;

import de.niklas.exams.memory_exam_2019.provided.MemoryImages;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;

public class MemoryGameTerm extends JFrame implements Runnable{

    private MemoryGame game;
    private ArrayList<JLabel> playerLabels = new ArrayList<>();
    private ArrayList<JToggleButton> memCards = new ArrayList<>();
    private JToggleButton karteOffen;
    private int spielrunden = 0;

    public MemoryGameTerm(MemoryGame game){
        super("Soeder Memory");
        this.game = game;
        this.setLayout(new BorderLayout());

        JPanel playerPanel = new JPanel();
        for(Player player : game.getPlayersList()){
            JLabel label = new JLabel(player.toString());
            playerLabels.add(label);
            playerPanel.add(label);
        }

        setLabelText();

        JPanel memPanel = new JPanel();
        memPanel.setLayout(new GridLayout(game.getRows(), game.getCols()));
        for(int i = 0; i < game.getRows() * game.getCols(); i++){
            JToggleButton jTB = new JToggleButton();
            jTB.addActionListener(e -> actionPerformed(jTB));
            memCards.add(jTB);
        }
        fillMemoryCards();
        for(JToggleButton memCard : memCards){
            memPanel.add(memCard);
        }


        this.add(playerPanel, BorderLayout.NORTH);
        this.add(memPanel, BorderLayout.SOUTH);
        this.pack();
//        this.setSize(500, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        new Thread(this).start();
    }

    private void fillMemoryCards(){
        int memCardsToFill = this.memCards.size();
        if(game.isBlankRequired()){
            this.memCards.get(this.memCards.size()-1).setIcon(MemoryImages.getBlank());
            this.memCards.get(this.memCards.size()-1).setEnabled(false);
            memCardsToFill--;
        }

        for(int i = 0; i < memCardsToFill; i++){
            this.memCards.get(i).setIcon(MemoryImages.getBackside());
        }

        for(int i = 0; i < game.getImages().size(); i++){
            memCards.get(i).setSelectedIcon(game.getImages().get(i).getImage());
            memCards.get(i+game.getImages().size()).setSelectedIcon(game.getImages().get(i).getImage());
        }

        Collections.shuffle(memCards);
    }

    public void setLabelText(){
        for(int i = 0; i < game.getPlayersList().size(); i++){
            this.playerLabels.get(i).setText(game.getPlayersList().get(i).toString());
            this.playerLabels.get(i).setForeground(game.getPlayersList().get(i).getStatus().color);
        }
    }

    public void actionPerformed(JToggleButton toggleButton) {
        if(karteOffen == null){
            karteOffen = toggleButton;
        }
        else {
            spielrunden += 1;
            if(karteOffen.getSelectedIcon() == toggleButton.getSelectedIcon()){
                karteOffen.setEnabled(false);
                toggleButton.setEnabled(false);
                game.getCurrentPlayer().addPoint();
                karteOffen = null;


                boolean allDisabled = true;
                for (JToggleButton memCard : memCards) {
                    if (memCard.isEnabled()) {
                        allDisabled = false;
                    }
                }

                if(allDisabled){
                    for(Player player : game.getPlayersList()){
                        player.setStatus(PlayerStatus.FINISHED);
                        endGame();
                    }
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Sorry, those don´t match", "Wrong", JOptionPane.ERROR_MESSAGE);
                karteOffen.setSelected(false);
                toggleButton.setSelected(false);

                game.nextPlayer();
                karteOffen = null;
            }
        }

        setLabelText();
    }

    public void endGame(){
        Collections.sort(game.getPlayersList());
        StringBuilder playerResult = new StringBuilder();
        for(Player player : game.getPlayersList()){
            playerResult.append(player.toString()).append(", ");
        }
        playerResult = new StringBuilder(playerResult.substring(0, playerResult.length() - 2));

        String oldScores = "";
        String readOldScores = readOldScores();
        if(!readOldScores.isEmpty()){
            oldScores = String.format("\n\nLast games: \n%s", readOldScores);
        }

        String message = String.format("Game end after %d rounds, scores: %s %s", spielrunden, playerResult, oldScores);
        JOptionPane.showMessageDialog(null, message, "Score", JOptionPane.INFORMATION_MESSAGE);

        saveGame(String.format("Game end after %d rounds, scores: %s", spielrunden, playerResult));
        System.exit(0);
    }

    public String readOldScores(){
        StringBuilder stringBuilder = new StringBuilder();
        String filename = "memory.txt";
        try {
            Files.readAllLines(Paths.get(filename))
                    .forEach(line -> stringBuilder.append(line).append(System.lineSeparator())); // als Stream weiterverarbeiten
        } catch (NumberFormatException | IOException ignored) {}

        return stringBuilder.toString();
    }

    public void saveGame(String saveGame){
        String filename = "memory.txt";
        String line = saveGame;
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

    @Override
    public void run() {
        int counter = 0;
        while(true){
            try {
                Thread.sleep(1000);
                counter++;
                this.setTitle(String.format("Soeder Memory (%d)", counter));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
