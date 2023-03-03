package de.niklas.classes.vehicles;

public class Vehicle {

    int wheels;
    double vMax;
    double position = 0;
    double speed = 0;

    public Vehicle(int wheels, double vMax){
        this.wheels = wheels;
        this.vMax = vMax;
    }

    public void setSpeed(double speed){
        if(speed >= this.vMax){
            this.speed = this.vMax;
        }
        else{
            this.speed = speed;
        }
    }

    public void drive(double minutes){
        if(this.speed != 0){
            this.position += this.speed/60 * minutes;
        }
    }

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