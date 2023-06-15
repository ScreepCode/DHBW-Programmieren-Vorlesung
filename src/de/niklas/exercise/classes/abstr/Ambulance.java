package de.niklas.exercise.classes.abstr;

/**
 * <strong>Fahrzeuge, Wettrennen (2)</strong><br>
 * Implementation des Krankenwagens
 *
 * @see "21_Abstrakte_Klassen_Aufgaben.pdf"
 * @see Race
 * @author Niklas Buse
 */
public class Ambulance extends Car {
    private boolean blueLightStatus;

    /**
     * Konstruktor für Krankenwagen; erweitert vom Auto um Blaulicht
     * @param speed Geschwinkeitkeit
     * @param blueLightStatus Blaulichtstatus
     */
    public Ambulance(double speed, boolean blueLightStatus){
        super(speed);
        this.blueLightStatus = blueLightStatus;
    }

    /**
     * Rückgabe über Schaltstatus des Blaulichts
     * @return Ob Blaulicht angeschaltet ist
     */
    public boolean getBlueLightStatus(){
        return blueLightStatus;
    }

    /**
     * Schalten des Blaulichts
     * @param status Status, der zu schalten ist
     */
    public void changeBlueLightStatus(boolean status){
        this.blueLightStatus = status;
    }

    /**
     * Ausgeben der Fahrzeug info über diese Methode (ersetzt toString())
     * @return Fahrzeugstatus mit Blaulichtstatus
     */
    @Override
    public String info() {
        return String.format("%s at position %.1f km with %d wheels at speed %.1f km/h of max. %.1f km/h. Signal %s.",
                this.getClass().getSimpleName(),
                this.position,
                this.wheels,
                this.speed,
                this.vMax,
                (getBlueLightStatus())? "on" : "off"
        );
    }

    /**
     * Überschreiben der Vehicle toString, der hier um einen Parameter erweitert wird
     * @return Fahrzeugstatus mit Blaulichtstatus
     */
    @Override
    public String toString() {
        return String.format("%s at position %.1f km with %d wheels at speed %.1f km/h of max. %.1f km/h. Signal %s.",
                this.getClass().getSimpleName(),
                this.position,
                this.wheels,
                this.speed,
                this.vMax,
                (getBlueLightStatus())? "on" : "off"
        );
    }
}
