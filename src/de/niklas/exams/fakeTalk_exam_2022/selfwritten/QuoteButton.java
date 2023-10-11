package de.niklas.exams.fakeTalk_exam_2022.selfwritten;
import javax.swing.*;

public class QuoteButton extends JButton {

    private QuoteType type = QuoteType.UNKNOWN;

    public void updateButton(){
        this.setIcon(type.getIcon());
        this.setBackground(type.getColor());
    }

    public void setType(QuoteType type) {
        this.type = type;
        updateButton();
    }

    public boolean isUnknown(){
        return QuoteType.UNKNOWN == type;
    }
}
