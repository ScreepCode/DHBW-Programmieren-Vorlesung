package de.niklas.classes;

public class Point {

    private double x_coordinate;
    private double y_coordinate;

    public Point(double x_coordinate, double y_coordinate) {
        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;
    }

    public void setX_coordinate(double x_coordinate) {
        this.x_coordinate = x_coordinate;
    }

    public void setY_coordinate(double y_coordinate) {
        this.y_coordinate = y_coordinate;
    }

    public double getX_coordinate() {
        return x_coordinate;
    }

    public double getY_coordinate() {
        return y_coordinate;
    }

    @Override
    public String toString() {
        return "Punkt  (" +
                "" + x_coordinate +
                "," + y_coordinate +
                ')';
    }

    public double distanceToOrigin(){
        return Math.sqrt(x_coordinate * x_coordinate + y_coordinate * y_coordinate);
    }

    public Point mirrorOnX(){
        return new Point(x_coordinate, y_coordinate * -1);
    }

    public Point mirrorOnY(){
        return new Point(x_coordinate, y_coordinate * -1);
    }

    public Point mirrorOrigin(){
        return new Point(x_coordinate * -1, y_coordinate * -1);
    }

    public double getDistance(Point otherPoint){
        return Math.sqrt(
                Math.pow(this.x_coordinate - otherPoint.getX_coordinate(), 2) +
                        Math.pow(this.y_coordinate - otherPoint.getY_coordinate(), 2)
        );
    }

    public static void main(String[] args) {
        Point pointA = new Point(4.0, 2.0);
        System.out.println("A: " + pointA);
        Point pointB = new Point(-1.0, -1.0);
        System.out.println("B: " + pointB);
        System.out.println("Abstand A-B: "
                + pointA.getDistance(pointB));
        pointA = pointA.mirrorOrigin();
        System.out.println("A': " + pointA);
        System.out.println("Abstand A’-B: "
                + pointA.getDistance(pointB));
    }

}
