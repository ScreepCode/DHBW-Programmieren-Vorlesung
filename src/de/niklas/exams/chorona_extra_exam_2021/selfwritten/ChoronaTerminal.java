package de.niklas.exams.chorona_extra_exam_2021.selfwritten;

import de.niklas.exams.chorona_extra_exam_2021.provided.Chorona;
import de.niklas.exams.chorona_extra_exam_2021.provided.Room;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.*;

public class ChoronaTerminal extends JFrame implements Runnable {

    private Variant variant;
    private Room room;

    JLabel stepsCountLabel = new JLabel("0");
    JButton stepButton, playButton, saveButton;
    CellButton[][] allCellButtons;

    public ChoronaTerminal(Variant variant, Room room){
        this.variant = variant;
        this.room = room;

        this.setTitle(String.format("Chorona - %s(%s)", variant.getLabel(), variant.getDesigination()));
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel stepsPanel = new JPanel();
        stepsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel stepsLabel = new JLabel("Steps");
        stepsCountLabel.setText(String.format("%d", room.getSteps()));
        stepsPanel.add(stepsLabel);
        stepsPanel.add(stepsCountLabel);

        JPanel rasterPanel = new JPanel();
        rasterPanel.setLayout(new GridLayout(room.getSetting().getWidth(), room.getSetting().getWidth()));
        allCellButtons = new CellButton[room.getSetting().getHeight()][room.getSetting().getWidth()];
        for(int y = 0; y < room.getSetting().getHeight(); y++){
            for(int x = 0; x < room.getSetting().getWidth(); x++){
                CellButton cell = new CellButton(0, room.getSetting().getPolluters().contains(new Point(x, y)));
                cell.setPreferredSize(new Dimension(80, 80));
                allCellButtons[y][x] = cell;
                Chorona.updateButtonForDose(cell, 0);
                rasterPanel.add(cell);
            }
        }

        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new GridLayout(1, 3));
        stepButton = new JButton("Step");
        stepButton.addActionListener(e -> stepAction());
        actionPanel.add(stepButton);
        playButton = new JButton("Play");
        playButton.addActionListener(e -> playAction());
        actionPanel.add(playButton);
        saveButton = new JButton("Save");
        saveButton.addActionListener(e -> saveAction());
        actionPanel.add(saveButton);

        mainPanel.add(stepsPanel, BorderLayout.NORTH);
        mainPanel.add(rasterPanel, BorderLayout.CENTER);
        mainPanel.add(actionPanel, BorderLayout.SOUTH);
        this.add(mainPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void stepAction(){
        room.step();
        stepsCountLabel.setText(String.format("%d", room.getSteps()));
        for(int y = 0; y < allCellButtons.length; y++){
            for(int x = 0; x < allCellButtons[y].length; x++){
                Chorona.updateButtonForDose(allCellButtons[y][x], room.getDose(x, y));
            }
        }
    }

    public void saveAction(){
        String filename = String.format("%s-%d-%d-%d-%d.txt", variant.getLabel(), room.getSetting().getWidth(), room.getSetting().getHeight(), room.getSetting().getPolluters().size(), room.getSteps());
        StringBuilder content = new StringBuilder();

        for(int y = 0; y < allCellButtons.length; y++){
            for(int x = 0; x < allCellButtons[y].length; x++){
                content.append(String.format("%d;%d;%.1f", x, y, room.getDose(x, y))).append(System.lineSeparator());
            }
        }

        try {
            Files.writeString(Paths.get(filename), content,
                StandardOpenOption.CREATE_NEW
            );

            JOptionPane.showMessageDialog(null, String.format("%s saved successfully", filename), "Meldung", JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, String.format("%s saved successfully", filename), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void playAction(){
        new Thread(this).start();
    }

    @Override
    public void run() {
        int steps = 0;
        playButton.setEnabled(false);
        stepButton.setEnabled(false);
        while(steps < 20){
            try {
                Thread.sleep(500);
                stepAction();
                steps++;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        playButton.setEnabled(true);
        stepButton.setEnabled(true);
    }
}
