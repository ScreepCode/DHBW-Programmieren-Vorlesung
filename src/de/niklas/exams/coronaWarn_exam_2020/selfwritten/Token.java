package de.niklas.exams.coronaWarn_exam_2020.selfwritten;

import java.util.Date;

/**
 * <strong>Token</strong><br>
 * Implementation eines Tokens
 *
 * @see "Teilaufgabe a"
 * @author Niklas Buse
 */
public class Token {

    private String value;
    private Date date;

    public Token() {
        this.value = java.util.UUID.randomUUID().toString(); // To get a random UUID, if not provided
        this.date = new Date();
    }

    public Token(String value, Date date) {
        this.value = value;
        this.date = date;
    }

    public String getValue() {
        return value;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return value + " @ " + date.toString();
    }
}
