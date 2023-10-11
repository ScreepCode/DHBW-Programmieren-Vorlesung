package de.niklas.exams.fakeTalk_exam_2022.selfwritten;
import de.niklas.exams.fakeTalk_exam_2022.provided.FakeTalkIcons;

import javax.swing.*;
import java.awt.*;

public enum QuoteType {

    UNKNOWN("Unknown", FakeTalkIcons.ICON_UNKNOWN, Color.lightGray),
    HOT_SHIT("Hot shit", FakeTalkIcons.ICON_HOT_SHIT, Color.green),
    BULLSHIT("Bullshit", FakeTalkIcons.ICON_BULLSHIT, new Color(74, 65, 42));

    private final String name;
    private final Icon icon;
    private final Color color;

    QuoteType(String name, Icon icon, Color color) {
        this.name = name;
        this.icon = icon;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public Icon getIcon() {
        return icon;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return String.format("%s", name);
    }
}