package de.niklas.control;
/**
 * <strong>Schaltjahr</strong><br>
 * Berechnen, ob ein Jahr ein Schaltjahr ist
 * Regeln: Jahreszahl/4 und nicht durch 100; Oder durch 400
 *
 * @see "06_Kontrollstrukturen_Aufgaben.pdf"
 * @author Niklas Buse
 */
public class LeapYear {
    public static void main(String[] args) {
        java.util.Scanner scan = new java.util.Scanner(System.in);
        System.out.print("Welches Jahr soll auf Schaltjahr geprüft werden? ");
        int jahr = scan.nextInt();

        if((jahr%4 == 0) && (jahr%100 != 0) || jahr % 400 == 0){    // Jahr durch 4 teilbar ohne Rest, aber auch ungleich geteilt durch 100 Rest 0
            System.out.printf("%d ist ein Schaltjahr", jahr);       //      oder als andere Bedingung teilen durch 400 ohne Rest.
        }                                                           // Denn wenn durch 400 teilbar trift auch durch 4 zu
        else {
            System.out.printf("%d ist kein Schaltjahr", jahr);
        }
    }
}

/* Beispielausführung
--------------------------------------
Eingabe:
2023
2020
2000
2100
--------------------------------------
Ausgabe:
Welches Jahr soll auf Schaltjahr geprüft werden? 2023
2023 ist kein Schaltjahr
Welches Jahr soll auf Schaltjahr geprüft werden? 2020
2020 ist ein Schaltjahr
Welches Jahr soll auf Schaltjahr geprüft werden? 2000
2000 ist ein Schaltjahr
Welches Jahr soll auf Schaltjahr geprüft werden? 2100
2100 ist kein Schaltjahr
--------------------------------------
 */