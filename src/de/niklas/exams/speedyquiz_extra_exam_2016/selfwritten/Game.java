package de.niklas.exams.speedyquiz_extra_exam_2016.selfwritten;

import javax.swing.*;
import java.nio.file.*;
import java.io.*;
import java.util.*;

public class Game implements Runnable{

    private List<Question> questionList;
    private int aktQuestion;
    private ArrayList<GameClient> clients = new ArrayList<>();
    private boolean gameStarted = false;
    private int duration = 0;

    public Game(List<Question> questionPool, int anzahlFragen) throws GameException {
        if(questionPool.size() < anzahlFragen){
            throw new GameException("Too few questions available");
        }
        Set<Question> questionSet = new HashSet<>();
        while(questionSet.size() < anzahlFragen){
            questionSet.add(questionPool.get(new Random().nextInt(questionPool.size())));
        }
        questionList = questionSet.stream().toList();
    }

    public void registerClient(GameClient client){
        if(!gameStarted){
            clients.add(client);
        }
    }

    public int getQuestionCount(){
        return questionList.size();
    }

    public void startGame(){
        aktQuestion = -1;
        nextQuestion();
    }

    public void answerSelected(GameClient client, int index){
        for(GameClient c : clients){
            if(c == client){
                if(questionList.get(aktQuestion).getCorrectIndex() == index){
                    c.setAnswerState(aktQuestion, Status.CORRECT);
                }
                else{
                    c.setAnswerState(aktQuestion, Status.WRONG);
                }
            }
            else{
                c.setAnswerState(aktQuestion, Status.NO_ANSWER);
            }
        }
        nextQuestion();
    }

    private void nextQuestion(){
        aktQuestion++;
        if(aktQuestion < questionList.size()){
            for(GameClient client : clients){
                client.setQuestion(aktQuestion, questionList.get(aktQuestion));
            }
            new Thread(this).start();
        }
        else{
            for(GameClient client : clients){
                client.gameIsOver();
            }

            StringBuilder messageBuilder = new StringBuilder(String.format("Game finished after %d seconds, score:", duration));
            for(GameClient client : clients){
                messageBuilder.append(String.format(" %s (%d),", client.getPlayerName(), client.getPoints()));
            }
            String message = messageBuilder.substring(0, messageBuilder.length()-1);

            JOptionPane.showMessageDialog(null, message, "Meldung", JOptionPane.INFORMATION_MESSAGE);
            String filename = "highscore.txt";
            try {
                Files.writeString(Paths.get(filename), message + System.lineSeparator(),
                    StandardOpenOption.APPEND,
                    StandardOpenOption.CREATE
                );
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }

    @Override
    public void run() {
        int questionBegin = aktQuestion;
        int time = 10;
        while(questionBegin == aktQuestion & time > 0){
            time--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for(GameClient client : clients){
                client.setRemainingSeconds(time);
            }
        }
        duration += 10 - time;
        if(time == 0){
            for(GameClient client : clients){
                client.setAnswerState(aktQuestion, Status.NO_ANSWER);
            }
            nextQuestion();
        }
    }
}
