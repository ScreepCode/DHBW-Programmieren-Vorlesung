package control;
/**
 * <h1>Wildbestand</h1>
 * <li>Bestand von Hirschen mit Beginn 200, Abbruch bei über 300</li>
 * <li>10% Zuwachs jährlich + Jahresende -15 durch Abschuss</li>
 *
 * @see "06_Kontrollstrukturen_Aufgaben.pdf"
 * @author Niklas Buse
 */
public class Deers {
    public static void main(String[] args) {
        int deers = 200;                    // Anfangsbestand
        int duration = 0;
        while(deers <= 300){                // Abbruchbedingung wenn über 300
            duration++;
            deers = (int) (deers * 1.1);    // Jährliches Wachstum
            deers -= 15;                    // Jährlicher Abschuss

            System.out.printf("%d: %d Hirsche %n", duration, deers); // Ausgabe
        }
    }

}

/* Beispielausführung
--------------------------------------
Eingabe: Keine
--------------------------------------
Ausgabe:
1: 205 Hirsche
2: 210 Hirsche
3: 216 Hirsche
4: 222 Hirsche
5: 229 Hirsche
6: 236 Hirsche
7: 244 Hirsche
8: 253 Hirsche
9: 263 Hirsche
10: 274 Hirsche
11: 286 Hirsche
12: 299 Hirsche
13: 313 Hirsche
--------------------------------------
 */