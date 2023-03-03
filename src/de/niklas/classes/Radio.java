package de.niklas.classes;
/**
 * <strong>Radio</strong><br>
 * Es sollte eine Klasse zur Integration eines Radios gemacht werden.
 * Dabei gibt es Status, Lautstärke und Frequenz als Parameter
 *
 * @see "09_Klassen_Aufgaben-1.pdf"
 * @author Niklas Buse
 */
public class Radio {

    private boolean on;
    private int volume;
    private double frequency;

    /**
     * Erzeugen eines Radios mit benutzerdefinierten Zuständen
     *
     * @param pOn Radiozustand
     * @param pVolume Lautstärke
     * @param pFrequency Frequenz
     */
    public Radio(boolean pOn, int pVolume, double pFrequency) {
        this.setOn(pOn);
        this.setVolume(pVolume);
        this.setFrequency(pFrequency);
    }

    /**
     * Erzeugen eines Radios mit festgelegten Zuständen
     */
    public Radio(){
        this(true, 5, 99.9);
    }


    /**
     * Setzen der Lautstärke;
     * Bereichsbegrenzung von 0 bis 10.
     * @param pVolume
     */
    private void setVolume(int pVolume){
        if(pVolume >= 10){
            this.volume = 10;
        }
        else if (pVolume <= 0) {
            this.volume = 0;
        }
        else{
            this.volume = pVolume;
        }
    }

    /**
     * Erhöhen der Lautstärke um 1, wenn nicht an Bereichsgrenze
     */
    public void incVolume(){
        this.setVolume(this.volume+1);
    }

    /**
     * Verringern der Lautstärke um 1, wenn nicht an Bereichsgrenze
     */
    public void decVolume(){
        this.setVolume(this.volume-1);
    }

    /**
     * Rückgabe der aktuellen Lautstärke
     * @return Lautstärke
     */
    public int getVolume(){
        return this.volume;
    }

    /**
     * Setzen des Zustands
     */
    private void setOn(boolean pOn){
        this.on = pOn;
    }

    /**
     * Gerät einschalten, falls ausgeschaltet
     */
    public void turnOn(){
        if(!this.on){
            this.on = true;
        }
    }

    /**
     * Gerät ausgeschalten, falls einschaltet
     */
    public void turnOff(){
        if(this.on){
            this.on = false;
        }
    }

    /**
     * Rückgabe des aktuellen Zustands
     */
    private boolean getOn(){
        return this.on;
    }

    /**
     * Setzen der Frequenz;
     * Bereichsbegrenzung von 85,0 bis 99,9.
     * @param pFrequency Frequenz
     */
    public void setFrequency(double pFrequency){
        if(pFrequency < 85.0 | pFrequency > 110.0){
            this.frequency = 99.9;
        }
        else{
            this.frequency = pFrequency;
        }
    }

    /**
     * Rückgabe der aktuellen Frequenz
     * @return Aktuelle Frequenz
     */
    public double getFrequency() {
        return frequency;
    }

    /**
     * @return Zusammenfassung des Radios als String
     */
    @Override
    public String toString() {
        return "Radio " + ((this.on) ? "an" : "aus") + "; " +
                "Lautstärke " + this.volume + "; " +
                "Frequenz " + this.frequency + " MHz";
    }

    public static void main(String[] args) {
        Radio radio = new Radio(false, 7, 93.5);
        System.out.println(radio);
        radio.turnOn();
        System.out.println(radio);
        radio.incVolume(); radio.incVolume();
        System.out.println(radio);
        radio.incVolume();
        radio.incVolume();
        System.out.println(radio);
        radio.decVolume();
        System.out.println(radio);
        radio.setFrequency(97.8);
        System.out.println(radio);
        radio.setFrequency(112.7);
        System.out.println(radio);
        radio.turnOff();
        System.out.println(radio);
    }
}

/* Beispielausführung
--------------------------------------
Eingabe: Keine
--------------------------------------
Ausgabe:
Radio aus; Lautstärke 7; Frequenz 93.5 MHz
Radio an; Lautstärke 7; Frequenz 93.5 MHz
Radio an; Lautstärke 9; Frequenz 93.5 MHz
Radio an; Lautstärke 10; Frequenz 93.5 MHz
Radio an; Lautstärke 9; Frequenz 93.5 MHz
Radio an; Lautstärke 9; Frequenz 97.8 MHz
Radio an; Lautstärke 9; Frequenz 99.9 MHz
Radio aus; Lautstärke 9; Frequenz 99.9 MHz
--------------------------------------
 */