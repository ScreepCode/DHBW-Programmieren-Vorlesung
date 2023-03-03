package de.niklas.classes.vehicles;

public class Car extends Vehicle{
    public Car(double speed){
        super(4, 140);
        super.setSpeed(speed);
    }

    public Car(int vMax, double speed){
        super(4, vMax);
        super.setSpeed(speed);
    }
}
