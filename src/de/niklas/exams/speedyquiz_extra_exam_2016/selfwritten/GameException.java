package de.niklas.exams.speedyquiz_extra_exam_2016.selfwritten;

public class GameException extends Exception {
    public GameException() {
        super("Message");
    }

    public GameException(String message) {
        super(message);
    }
}