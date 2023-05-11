package de.niklas.exercise.classes.vehicles;

/**
 * <strong>Fahrzeuge, Wettrennen</strong><br>
 * Implementation des Fahrrads
 *
 * @see "13_Vererbung_Aufgaben-1.pdf"
 * @see Race
 * @author Niklas Buse
 */
public class Bicycle extends Vehicle{
    /**
     * Dieser Konstruktor ist für Fahrräder
     * @param speed Aktuelle Geschwindigkeit
     */
    public Bicycle(double speed){
        super(2, 30); // Aufrufen des "Eltern" Konstruktors mit entsprechenden Parametern
        super.setSpeed(speed);    // Setzen der zu fahrenden Geschwindigkeit
    }
}
