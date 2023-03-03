package de.niklas.classes.vehicles;

public class Ambulance extends Car{
    private boolean blueLightStatus;
    public Ambulance(double speed, boolean blueLightStatus){
        super(speed);
        this.blueLightStatus = blueLightStatus;
    }
    public boolean getBlueLightStatus(){
        return blueLightStatus;
    }
    public void changeBlueLightStatus(boolean status){
        this.blueLightStatus = status;
    }

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
