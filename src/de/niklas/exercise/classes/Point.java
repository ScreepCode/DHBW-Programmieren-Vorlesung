package de.niklas.exercise.classes;
/**
 * <strong>Zweidimensionaler Punkt</strong><br>
 * Zahlreiche Rechnungen mit 2-Dimensionalen Punkten
 * Spiegelungen, Abstand
 *
 * @see "09_Klassen_Aufgaben-1.pdf"
 * @author Niklas Buse
 */
public class Point {

    private double x_coordinate;
    private double y_coordinate;

    /**
     * Erzeugen eines Punktes mit 2 Koordinaten
     *
     * @param x_coordinate X-Koordinate
     * @param y_coordinate Y-Koordinate
     */
    public Point(double x_coordinate, double y_coordinate) {
        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;
    }

    /**
     * Setzen des X-Koordinaten Wertes
     * @param x_coordinate X-Koordinaten Wert
     */
    public void setX_coordinate(double x_coordinate) {
        this.x_coordinate = x_coordinate;
    }

    /**
     * Setzen des Y-Koordinaten Wertes
     * @param y_coordinate Y-Koordinaten Wert
     */
    public void setY_coordinate(double y_coordinate) {
        this.y_coordinate = y_coordinate;
    }

    /**
     * Rückgabe des X-Koordinaten Werts
     * @return X-Koordinaten Wert
     */
    public double getX_coordinate() {
        return x_coordinate;
    }

    /**
     * Rückgabe des Y-Koordinaten Werts
     * @return Y-Koordinaten Wert
     */
    public double getY_coordinate() {
        return y_coordinate;
    }

    /**
     * Ausgabe des Punktkoordinaten als String
     * @return Koordinaten des Punktes
     */
    @Override
    public String toString() {
        return "Punkt  (" +
                "" + x_coordinate +
                "," + y_coordinate +
                ')';
    }

    /**
     * Berechnung und Rückgabe der Distanz zum Nullpunkt
     * @return Distanzwert zum Nullpunkt
     */
    public double distanceToOrigin(){
        return Math.sqrt(x_coordinate * x_coordinate + y_coordinate * y_coordinate);
    }

    /**
     * Spiegeln des Punktes an der x-Achse und Rückgabe es neuen Punktes
     * @return Gespiegelten Punkt
     */
    public Point mirrorOnX(){
        return new Point(x_coordinate, y_coordinate * -1);
    }

    /**
     * Spiegeln des Punktes an der y-Achse und Rückgabe es neuen Punktes
     * @return Gespiegelten Punkt
     */
    public Point mirrorOnY(){
        return new Point(x_coordinate, y_coordinate * -1);
    }

    /**
     * Spiegeln des Punktes am Nullpunkt und Rückgabe es neuen Punktes
     * @return Gespiegelten Punkt
     */
    public Point mirrorOrigin(){
        return new Point(x_coordinate * -1, y_coordinate * -1);
    }

    /**
     * Berechnet die Distanz zum übergebenen Punkt
     * @param otherPoint Anderer Punkt
     * @return Distanz zu anderem Punkt
     */
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

/* Beispielausführung
--------------------------------------
Eingabe: Keine
--------------------------------------
Ausgabe:
A: Punkt  (4.0,2.0)
B: Punkt  (-1.0,-1.0)
Abstand A-B: 5.830951894845301
A': Punkt  (-4.0,-2.0)
Abstand A’-B: 3.1622776601683795
--------------------------------------
 */
