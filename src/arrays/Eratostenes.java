package arrays;
/**
 * <h1>Sieb des Eratostenes*</h1>
 * Der folgende Algorithmus ermittelt alle Primzahlen zwischen 2 und einer vorgegebenen Grenze n.
 * Die genauen Regeln findest du in der Aufgabe oder online
 *
 * @see "07_Arrays_Aufgaben-1.pdf"
 * @author Niklas Buse
 */
public class Eratostenes {
    public static void main(String[] args) {
        int grenze = 100;

        boolean[] sieve = new boolean[grenze];                      // Alle möglichen Zahlen werden hier als boolean angegeben; false = noch möglich,
        String primes = "Alle Primzahlen von 2 bis " + grenze + ": ";   //      true = "markiert", entweder gerade als Primzahl oder ein Vielfaches einer anderen Zahl und damit keine Primzahl
        for(int i = 0; i < sieve.length; i++){                      //      somit wird keine Zahl doppelt betrachtet
            sieve[i] = false;
        } //false ist noch drin

        for(int i = 2; i < sieve.length; i++){
            if(sieve[i] == false){                  // Wenn Zahl noch nicht markiert wurde
                sieve[i] = true;                    // Zahl wird dann markiert +
                primes += i + " ";                  //      zum Ausgabestring hinzugefügt

                for(int j = i+1; j < sieve.length; j++){    // Hier wird der Array für alle Zahlen höher des minimum was gerade markiert wurde durchgegangen
                    if (j%i == 0){                          // Hier wird mit Modulo auf ein Vielfaches der eigentlichen Zahl geprüft; wenn Restdivision = 0, dann ist es ein Vielfaches
                        sieve[j] = true;                    // Hier die Markierung, damit es im Nachhinein nicht mehr betrachtet wird.
                    }
                }
            }
        }
        System.out.println(primes);         // Ausgabe aller Primzahlen
    }
}

/* Beispielausführung
--------------------------------------
Eingabe: Keine
--------------------------------------
Ausgabe:
Alle Primzahlen von 2 bis 100: 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97
--------------------------------------
 */