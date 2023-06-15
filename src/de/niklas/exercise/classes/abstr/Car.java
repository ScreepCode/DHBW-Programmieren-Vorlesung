package de.niklas.exercise.classes.abstr;

/**
 * <strong>Fahrzeuge, Wettrennen (2)</strong><br>
 * Implementation des Autos mit Erben von Fahrzeug
 *
 * @see "21_Abstrakte_Klassen_Aufgaben.pdf"
 * @see Race
 * @author Niklas Buse
 */
public class Car extends Vehicle {
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

    /**
     * Ausgeben der Fahrzeug info über diese Methode (ersetzt toString())
     * @return Fahrzeugstatus
     */
    @Override
    public String info() {
        return toString();
    }
}
