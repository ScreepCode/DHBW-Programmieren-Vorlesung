package de.niklas.classes.vehicles;

/**
 * <strong>Fahrzeuge, Wettrennen</strong><br>
 * Implementation des Rennautos mit Erben von Auto
 *
 * @see "13_Vererbung_Aufgaben-1.pdf"
 * @see Race
 * @author Niklas Buse
 */
public class RacingCar extends Car{
    /**
     * Dieser Konstruktor ist für Rennautos
     * @param speed Aktuelle Geschwindigkeit
     */
    public RacingCar(double speed){
        super(220, speed);  // Aufrufen des "Eltern" Konstruktors mit entsprechenden Parametern
    }
}