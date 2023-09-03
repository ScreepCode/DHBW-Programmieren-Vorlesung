package de.niklas.exams.coronaWarn_exam_2020.selfwritten;

/**
 * <strong>JPhone</strong><br>
 * Implementation eines Mobilgeräts
 *
 * @see "Teilaufgabe a"
 * @author Niklas Buse
 */
public class JPhone {

    private String id, owner;

    public JPhone(String id, String owner) {
        this.id = id;
        this.owner = owner;
    }

    public String getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }
}
