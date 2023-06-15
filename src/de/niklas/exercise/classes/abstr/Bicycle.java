package de.niklas.exercise.classes.abstr;

/**
 * <strong>Fahrzeuge, Wettrennen (2)</strong><br>
 * Implementation des Fahrrads
 *
 * @see "21_Abstrakte_Klassen_Aufgaben.pdf"
 * @see Race
 * @author Niklas Buse
 */
public class Bicycle extends Vehicle {
    /**
     * Dieser Konstruktor ist für Fahrräder
     * @param speed Aktuelle Geschwindigkeit
     */
    public Bicycle(double speed){
        super(2, 30); // Aufrufen des "Eltern" Konstruktors mit entsprechenden Parametern
        super.setSpeed(speed);    // Setzen der zu fahrenden Geschwindigkeit
    }

    /**
     * Ausgeben der Fahrzeug info über diese Methode (ersetzt toString())
     * @return Fahrzeugstatus
     */
    @Override
    public String info() {
        return toString();
    }
}
