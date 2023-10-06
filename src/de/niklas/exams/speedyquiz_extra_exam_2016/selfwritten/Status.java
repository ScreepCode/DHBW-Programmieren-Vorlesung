package de.niklas.exams.speedyquiz_extra_exam_2016.selfwritten;

import java.awt.*;

public enum Status {

    ACTIVE(Color.ORANGE, 0, "aktuell gestellte Frage"),
    CORRECT(Color.GREEN, 1, "richtig beantwortete Frage"),
    WRONG(Color.RED, -1, "falsch beantwortete Frage"),
    PENDING(Color.WHITE, 0, "noch nicht ausgespielte/ausstehende Frage"),
    NO_ANSWER(Color.GRAY, 0, "Frage auf die ein anderer Spieler geantwortet hat");

    private final Color color;
    private final int points;
    private final String name;


    Status(Color color, int points, String name) {
        this.color = color;
        this.points = points;
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

}