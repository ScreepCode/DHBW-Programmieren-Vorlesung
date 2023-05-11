package de.niklas.exercise.control;
/**
 * <strong>Temperaturtabelle</strong><br>
 * Ausgabe einer Temperaturtabelle von Fahrenheit (f) nach Celsius (c)
 * Formel: c = (5 / 9) * ( f - 32)
 *
 * @see "06_Kontrollstrukturen_Aufgaben.pdf"
 * @author Niklas Buse
 */
public class TemperatureTable {

    public static void main(String[] args) {

        System.out.println("Fahrenheit | Celsius");
        System.out.println("-----------+--------");
        for(int fahrenheit = 0; fahrenheit <= 300; fahrenheit++){           // Begrenzung der Einträge (einschließlich 300!)
            double celsius = (5.0/9.0) * (fahrenheit-32);                   // Berechnung
            if(fahrenheit % 20 == 0){                                       // Ausgabe nur jede 20. Temperatur
                System.out.printf("%-10s | %.1f \n", fahrenheit, celsius);
            }
        }

    }

}

/* Beispielausführung
--------------------------------------
Eingabe: Keine
--------------------------------------
Ausgabe:
Fahrenheit | Celsius
-----------+--------
0          | -17,8
20         | -6,7
40         | 4,4
60         | 15,6
80         | 26,7
100        | 37,8
120        | 48,9
140        | 60,0
160        | 71,1
180        | 82,2
200        | 93,3
220        | 104,4
240        | 115,6
260        | 126,7
280        | 137,8
300        | 148,9
--------------------------------------
 */