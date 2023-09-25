package de.niklas.exams.memory_exam_2019.selfwritten;

import java.awt.*;

public enum PlayerStatus {

    ACTIVE(Color.ORANGE),
    WAITING(Color.BLACK),
    FINISHED(Color.GRAY);

    public Color color;
    PlayerStatus(Color color) {
        this.color = color;
    }
}
