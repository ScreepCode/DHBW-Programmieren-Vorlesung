package de.niklas.exams.speedyquiz_extra_exam_2016.selfwritten;

import de.niklas.exams.speedyquiz_extra_exam_2016.provided.QuestionNumberLabel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameTerm extends JFrame implements GameClient{

    private String name;
    private Game game;
    private JLabel questionText, countdown;
    private ArrayList<QuestionNumberLabel> questionNumberLabels = new ArrayList<>();
    private ArrayList<JButton> answerButtons = new ArrayList<>();

    public GameTerm(String name, Game game){
        this.name = name;
        this.game = game;

        this.setTitle(name);
        this.setLayout(new BorderLayout());

        JPanel pointPanel = new JPanel();
        pointPanel.setLayout(new GridLayout(1, 10));
        for(int i = 0; i < game.getQuestionCount(); i++){
            QuestionNumberLabel label = new QuestionNumberLabel(String.format("%d", i+1));
            questionNumberLabels.add(label);
            pointPanel.add(label);
        }

        JPanel questionPanel = new JPanel();
        questionPanel.setLayout(new BorderLayout());
        questionText = new JLabel();
        questionText.setHorizontalAlignment(JLabel.CENTER);
        countdown = new JLabel("10");
        countdown.setHorizontalAlignment(JLabel.CENTER);
        questionPanel.add(questionText, BorderLayout.NORTH);
        questionPanel.add(countdown, BorderLayout.SOUTH);

        JPanel answerPanel = new JPanel();
        answerPanel.setLayout(new GridLayout(2, 2));
        for(int i = 0; i < 4; i++){
            int index = i;
            JButton button = new JButton(String.valueOf(index));
            button.addActionListener(e -> {
                game.answerSelected(this, index);
            });
            answerButtons.add(button);
            answerPanel.add(button);
        }

        this.add(pointPanel, BorderLayout.NORTH);
        this.add(questionPanel, BorderLayout.CENTER);
        this.add(answerPanel, BorderLayout.SOUTH);
//         this.pack();
        this.setSize(500, 150);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public String getPlayerName() {
        return name;
    }

    @Override
    public int getPoints() {
        int points = 0;
        for(QuestionNumberLabel label : questionNumberLabels){
            points += label.getStatus().getPoints();
        }
        return points;
    }

    @Override
    public void setQuestion(int questionIndex, Question q) {
        questionNumberLabels.get(questionIndex).setStatus(Status.ACTIVE);
        questionText.setText(q.getQuestionText());
        for(int i = 0; i < q.getAnswers().length; i++){
            answerButtons.get(i).setText(q.getAnswers()[i]);
        }
        countdown.setText("10");
    }

    @Override
    public void gameIsOver() {
        for(JButton button : answerButtons){
            button.setEnabled(false);
        }
    }

    @Override
    public void setAnswerState(int questionIndex, Status status) {
        questionNumberLabels.get(questionIndex).setStatus(status);
    }

    public void setRemainingSeconds(int remainingSeconds){
        this.countdown.setText(String.valueOf(remainingSeconds));
    }
}
