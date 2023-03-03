package de.niklas.control;
/**
 * <strong>Einmaleins</strong><br>
 * Addieren beliebig vieler Eingaben (größer 0)
 * Einmal als While Schleife, auskommentiert die Lösung mit do-while
 *
 * @see "06_Kontrollstrukturen_Aufgaben.pdf"
 * @author Niklas Buse
 */
public class AddUp {

    public static void main(String[] args) {
        java.util.Scanner scan = new java.util.Scanner(System.in);
        int ergebnis = 0;
        while(true){
            System.out.print("Zahl eingeben (<0 für Abbruch): ");
            int zahl = scan.nextInt();
            if(zahl < 0){
                System.out.printf("Summe: %d", ergebnis);
                break;
            }
            else{
                ergebnis += zahl;
            }
        }

//        do{
//            System.out.print("Zahl eingeben (<0 für Abbruch): ");
//            int zahl = scan.nextInt();
//            if(zahl < 0){
//                System.out.printf("Summe: %d", ergebnis);
//                break;
//            }
//            else{
//                ergebnis += zahl;
//            }
//        }while (true);
    }

}

/* Beispielausführung
--------------------------------------
Eingabe:
1
2
3
4
-1
--------------------------------------
Ausgabe:
Zahl eingeben (<0 für Abbruch): 1
Zahl eingeben (<0 für Abbruch): 2
Zahl eingeben (<0 für Abbruch): 3
Zahl eingeben (<0 für Abbruch): 4
Zahl eingeben (<0 für Abbruch): -1
Summe: 10
--------------------------------------
 */