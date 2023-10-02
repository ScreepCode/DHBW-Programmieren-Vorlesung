package de.niklas.exams.chorona_extra_exam_2021.selfwritten;

import javax.swing.*;
import java.awt.*;

public class CellButton extends JButton {

    private double dose;
    private boolean polluter;

    public CellButton(double dose, boolean polluter){
        super(String.format("%.2f", dose));

        if(polluter){
            this.setBorder(BorderFactory.createLineBorder(Color.BLACK,4));
        }
    }

    public double getDose() {
        return dose;
    }

    public void setDose(double dose) {
        this.dose = dose;
    }

    public boolean isPolluter() {
        return polluter;
    }

    public void setPolluter(boolean polluter) {
        this.polluter = polluter;
    }
}
