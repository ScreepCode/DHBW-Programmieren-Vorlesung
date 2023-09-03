package de.niklas.exams.coronaWarn_exam_2020.selfwritten;

import java.awt.*;

/**
 * <strong>Warnstatus</strong><br>
 * Implementation des Warnstatus als Komplexer Datentyp
 *
 * @see "Teilaufgabe a"
 * @author Niklas Buse
 */
public enum Warnstatus {

    UNKNOWN("Unknown", new Color(175, 175, 175)),
    OK("Ok", new Color(100, 200, 100)),
    ALARM("Possible encounter", new Color(255, 100, 100)),
    INFECTED("In quarantine", new Color(150, 150, 255));

    private final String text;
    private final Color color;

    Warnstatus(String text, Color color) {
        this.text = text;
        this.color = color;
    }

    public String getText() {
        return text;
    }

    public Color getColor() {
        return color;
    }
}
