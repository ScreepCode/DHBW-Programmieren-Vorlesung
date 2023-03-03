package de.niklas.classes.vehicles;

/**
 * <strong>Fahrzeuge, Wettrennen</strong><br>
 * Implementation des Fahrzeugs, Basis
 *
 * @see "13_Vererbung_Aufgaben-1.pdf"
 * @see Race
 * @author Niklas Buse
 */
public class Vehicle {

    int wheels;
    double vMax;
    double position = 0;
    double speed = 0;

    /**
     * Basiskonstruktor
     * @param wheels Reifenanzahl
     * @param vMax Maximalgeschwindigkeit
     */
    public Vehicle(int wheels, double vMax){
        this.wheels = wheels;
        this.vMax = vMax;
    }

    /**
     * Setzen der Geschwindigkeit in km/h; Begrenzung auf maximale Geschwindigkeit
     * @param speed Geschwindigkeit in km/h
     */
    public void setSpeed(double speed){
        if(speed >= this.vMax){
            this.speed = this.vMax;
        }
        else{
            this.speed = speed;
        }
    }

    /**
     * Fahren der Distanz, Angabe der Zeit in Minuten
     * @param minutes Anzahl minuten, wie lange das Auto fahren soll
     */
    public void drive(double minutes){
        if(this.speed != 0){
            this.position += this.speed/60 * minutes;
        }
    }

    /**
     * Ausgabe des Fahrzeugs mit seinen Parametern/Status
     * @return Fahrzeugstatus
     */
    @Override
    public String toString() {
        return String.format("%s at position %.1f km with %d wheels at speed %.1f km/h of max. %.1f km/h.",
                this.getClass().getSimpleName(),
                this.position,
                this.wheels,
                this.speed,
                this.vMax
        );
    }
}