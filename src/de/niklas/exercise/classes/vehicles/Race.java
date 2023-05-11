package de.niklas.exercise.classes.vehicles;

/**
 * <strong>Fahrzeuge, Wettrennen</strong><br>
 * Simulation eines Wettrennens;
 * Genauere Details im Aufgabenblatt
 *
 * @see "13_Vererbung_Aufgaben-1.pdf"
 * @author Niklas Buse
 */
public class Race {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[4];
        vehicles[0] = new Bicycle(20.0);
        vehicles[1] = new Car(150.0);
        vehicles[2] = new RacingCar(200.0);
        vehicles[3] = new Ambulance(80.0, true);
        // 4 hours lead for the bike
        vehicles[0].drive(240.0);
        // 1 hour of driving for everyone
        for (int i = 0; i < vehicles.length; i++) {
            vehicles[i].drive(60);
        }
        // Output Race
        for (int i = 0; i < vehicles.length; i++) {
            System.out.println(vehicles[i].toString());
        }
    }
}

/* Beispielausführung
--------------------------------------
Eingabe: Keine
--------------------------------------
Ausgabe:
Bicycle at position 100,0 km with 2 wheels at speed 20,0 km/h of max. 30,0 km/h.
Car at position 140,0 km with 4 wheels at speed 140,0 km/h of max. 140,0 km/h.
RacingCar at position 200,0 km with 4 wheels at speed 200,0 km/h of max. 220,0 km/h.
Ambulance at position 80,0 km with 4 wheels at speed 80,0 km/h of max. 140,0 km/h. Signal on.
--------------------------------------
 */
