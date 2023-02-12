package de.niklas.operators;
/**
 * <h1>Ostertermin berechnen</h1>
 * Aufgrundlage des Jahres wird berechnet, an welchem Termin Ostersonntag liegt
 *
 * @see "05_Operatoren_Aufgaben.pdf"
 * @author Niklas Buse
 */
public class Easter {

    public static void main(String[] args) {
        System.out.println("Wir rechnen jetzt aus, wo Ostersonntag liegt");
        System.out.println("Von welchem Jahr möchtest du es ausrechnen?");
        java.util.Scanner scan = new java.util.Scanner(System.in);              // Initialisierung des Scanners
        int jahr = scan.nextInt();                                              // Der nächste Integer, der eingegeben wird,
                                                                                //  wird in der Variable gespeichert.
        int a = jahr % 19;
        int b = jahr % 4;
        int c = jahr % 7;
        int k = jahr / 100;
        int p = (8 * k + 13) / 25;
        int q = k / 4;
        int m = (15 + k - p - q) % 30;
        int n = (4 + k - q) % 7;
        int d = (19 * a + m) % 30;
        int e = (2 * b + 4 * c + 6 * d + n) % 7;
        int ostern = (22 + d + e);


        String monat = (ostern <= 31) ? "März" : "April";                       // Hier wird der Wechsel zwischen März und April vollzogen
        ostern = (ostern <= 31) ? ostern : ostern-31;                               // Hier dann ggf. der Termin angepasst
        System.out.printf("Im Jahr %d liegt Ostern am %d. %s.", jahr, ostern, monat);   // Formatierter String
    }
}

/* Beispielausführung
--------------------------------------
Eingabe: 2023
--------------------------------------
Ausgabe:
Wir rechnen jetzt aus, wo Ostersonntag liegt
Von welchem Jahr möchtest du es ausrechnen?

Im Jahr 2023 liegt Ostern am 9. April.
--------------------------------------
 */