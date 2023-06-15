package de.niklas.exercise.classes.abstr;

/**
 * <strong>Fahrzeuge, Wettrennen (2)</strong><br>
 * Implementation des Rennautos mit Erben von Auto
 *
 * @see "21_Abstrakte_Klassen_Aufgaben.pdf"
 * @see Race
 * @author Niklas Buse
 */
public class RacingCar extends Car {
    /**
     * Dieser Konstruktor ist für Rennautos
     * @param speed Aktuelle Geschwindigkeit
     */
    public RacingCar(double speed){
        super(220, speed);  // Aufrufen des "Eltern" Konstruktors mit entsprechenden Parametern
    }

    /**
     * Ausgeben der Fahrzeug info über diese Methode (ersetzt toString())
     * @return Fahrzeugstatus
     */
    @Override
    public String info() {
        return super.info();
    }
}