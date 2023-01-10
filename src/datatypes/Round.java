package datatypes;

public class Round {

    public static void main(String[] args) {
        double pi = 3.1415926; // Naeherung der Kreiszahl Pi
        double e = 2.7182818; // Naeherung der Eulerschen Zahl e

        System.out.println("Pi ganzzahlig: " + (int) pi); // Ausgabe: 3
        System.out.println("e ganzzahlig: " + (int)e); // Ausgabe: 2

        int piInt = (int) (pi + 0.5);
        int eInt = (int) (e + 0.5);

        System.out.println("Pi ganzzahlig: " + piInt); // Ausgabe: 3
        System.out.println("e ganzzahlig: " + eInt); // Ausgabe: 3

    }

}
