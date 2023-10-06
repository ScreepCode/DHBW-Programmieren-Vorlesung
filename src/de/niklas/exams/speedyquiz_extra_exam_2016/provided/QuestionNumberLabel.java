package de.niklas.exams.speedyquiz_extra_exam_2016.provided;

import de.niklas.exams.speedyquiz_extra_exam_2016.selfwritten.Status;

import javax.swing.*;

public class QuestionNumberLabel extends JLabel {

    private Status status = Status.PENDING;

    public QuestionNumberLabel(String label){
        super(label);
        this.setOpaque(true);
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setBackground(status.getColor());
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
        this.setBackground(status.getColor());
    }
}
