package de.niklas.classes.vehicles;

/**
 * <strong>Fahrzeuge, Wettrennen</strong><br>
 * Implementation des Autos mit Erben von Fahrzeug
 *
 * @see "13_Vererbung_Aufgaben-1.pdf"
 * @see Race
 * @author Niklas Buse
 */
public class Car extends Vehicle{
    /**
     * Dieser Konstruktor ist für Autos
     * @param speed Aktuelle Geschwindigkeit
     */
    public Car(double speed){
        super(4, 140);  // Aufrufen des "Eltern" Konstruktors mit entsprechenden Parametern
        super.setSpeed(speed);      // Setzen der zu fahrenden Geschwindigkeit
    }

    /**
     * Dieser Konstruktor ist für Fahrzeuge, die von Car Erben
     * @param vMax Neue Maximalgeschwindigkeit
     * @param speed Aktuelle Geschwindigkeit
     */
    public Car(int vMax, double speed){
        super(4, vMax);  // Aufrufen des "Eltern" Konstruktors mit entsprechenden Parametern
        super.setSpeed(speed); // Setzen der zu fahrenden Geschwindigkeit
    }
}
