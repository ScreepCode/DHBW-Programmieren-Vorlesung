package classes;

public class Radio {

    private boolean on;
    private int volume;
    private double frequency;

    public Radio(boolean pOn, int pVolume, double pFrequency) {
        this.setOn(pOn);
        this.setVolume(pVolume);
        this.setFrequency(pFrequency);
    }

    public Radio(){
        this(true, 5, 99.9);
    }

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

    public void incVolume(){
        this.setVolume(this.volume+1);
    }

    public void decVolume(){
        this.setVolume(this.volume-1);
    }

    public int getVolume(){
        return this.volume;
    }

    private void setOn(boolean pOn){
        this.on = pOn;
    }

    public void turnOn(){
        if(!this.on){
            this.on = true;
        }
    }

    public void turnOff(){
        if(this.on){
            this.on = false;
        }
    }

    private boolean getOn(){
        return this.on;
    }

    public void setFrequency(double pFrequency){
        if(pFrequency < 85.0 | pFrequency > 110.0){
            this.frequency = 99.9;
        }
        else{
            this.frequency = pFrequency;
        }
    }

    public double getFrequency() {
        return frequency;
    }

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
