package de.niklas.control;

import java.util.Random;
/**
 * <h1>Zahlenraten</h1>
 * Das Programm, welches vermutlich am weitesten von den Musterlösung abschweift.
 * <li>Mindestanforderungen: </li>
 * <li>- Ratespiel von Zahlen zwischen 1 und 100; Hinweise ob höher oder kleiner ; Zählen der Versuche</li>
 * <li>- Eingabe von Name, Zahlen und Endabfrage, ob beendet werden soll </li>
 * <li>Mein Zusatz: Alles abfangen, was Fehler erzeugen könnte & Session Statistiken </li>
 *
 * @see "06_Kontrollstrukturen_Aufgaben.pdf"
 * @author Niklas Buse
 */
public class NumberGuess {

    public static void main(String[] args) {
        java.util.Scanner scan = new java.util.Scanner(System.in);
        System.out.print("Wie ist dein Name? ");
        String name = scan.nextLine();      // Der Name bleibt für alle Spiele gleich; Alle Eingaben einer Zeile hier erlaubt

        int gameCounter = 0;                // Diese Variablen ermöglichen die eine Statistik aller gespielten Spiele
        int totalGuesses = 0;               //      bis Abbruch
        boolean play = true;

        while (play) {                      // Hier werden Spiele gestartet, solange Wiederholung erwünscht.
            scan = new java.util.Scanner(System.in);

            int guessCounter = 1;                           // Ratecounter + Zufallszahl für jede Spielrunde neu
            int toGuess = new Random().nextInt(100);
//            System.out.printf("Random = %d\n", toGuess);  // temporäre Ausgabe der Zufallszahl

            while (true) {                                                  // In dieser Schleife wird geraten, bis richtiges Ergebnis
                System.out.printf("%s, rate eine Zahl [1-100]: ", name);
                String input = scan.nextLine();                             // Hier wird eine ganze Zeile als Input genommen um zu verhindern, dass mehrere Zahlen auf einmal geschrieben werden und dann nacheinander abgehandelt werden.
                int guess;
                if(input.matches("^[0-9]*$")){ //[+-]?\d+             // Dieser RegEx Ausdruck ist NICHT teil der Vorlesung! Was dieser aber macht ist, zu überprüfen ob die Eingabe nur aus Ziffern 0-9 besteht von Anfang bis Ende durchgehen.
                    if(input.length() == 0){                                // Abbruch, wenn direkt Enter gedrückt wird, ohne Eingabe
                        System.out.println("Bitte gebe eine Zahl an ^^");
                        continue;
                    }
                    if(input.length() == 0 || input.length() > 2){          // Abbruch, wenn eine Zahl mit mehr als zwei Stellen eingegeben wird
                        System.out.println("Die Zahl liegt nur zwischen 0 und 100 ^^");
                        continue;
                    }
                    guess = Integer.parseInt(input);
                    if(guess < 0 || guess > 100) {                          // Abbruch, wenn eine Zahl außerhalb der grenzen eingegeben wird.
                        System.out.println("Die Zahl liegt nur zwischen 0 und 100 ^^");
                        continue;
                    }
                }
                else{
                    System.out.println("Bitte gebe nur Zahlen ein ^^");     // Abbruch, wenn RegEx andere Zeichen erkennt
                    continue;
                }
                                                                            // Eigentliche Überprüfung der angegebenen Zahl, wenn Eingabe erlaubt.
                if (guess == toGuess) {                                     // Wenn Zahl erraten wird, dann wird die While Schleife abgebrochen
                    System.out.printf("Versuch %d: %d ist korrrekt.\n", guessCounter, guess);
                    break;
                } else if (guess < toGuess) {                               // Fall Zahl kleiner
                    System.out.printf("Versuch %d: %d ist zu niedrig.\n", guessCounter, guess);
                    guessCounter++;
                } else if (guess > toGuess) {                               // Fall Zahl größer
                    System.out.printf("Versuch %d: %d ist zu hoch.\n", guessCounter, guess);
                    guessCounter++;
                }
            }

            System.out.println("Was möchtest du tun? ");                    // Abfrage nach weiterem Verlauf
            System.out.println("1 - Das Spiel fortsetzen ");
            System.out.println("0 - Das Spiel beenden ");
            while(true){                                                    // Abfrage, bis eine der beiden Zahlen genommen wurde
                System.out.print("Deine Eingabe: ");
                scan = new java.util.Scanner(System.in);
                String auswahl = scan.nextLine();                           // Scannt ganze Zeile, nicht nur einzelne Zahlen!
                if(auswahl.equals("1")){                                    // Wenn nur 1 angegeben wird
                    gameCounter++;                                          // Statistiken werden in Total geschrieben
                    totalGuesses += guessCounter;
                    break;                                                  // Schleife wird beendet; da play noch true ist, wird neue Runde gestartet
                }
                else if(auswahl.equals("0")){                               // Wenn nur 0 angegeben wird
                    gameCounter++;                                          // Statistiken werden in Total geschrieben
                    totalGuesses += guessCounter;
                    System.out.printf("" +                                  // Endnachricht mit ausgabe der Statistiken
                                    "Danke für spielen %s. ^^ \n" +
                                    "Du hast %d Spiel(e) gespielt und im Schnitt %d Versuch(e) gebraucht."
                            , name, gameCounter, totalGuesses/gameCounter);
                    play = false;                                           // Da play jetzt false ist, bricht sowohl diese als auch die große Spielschleife abgebrochen
                    break;
                }
                else{
                    System.out.println("Bitte nur '0' oder '1' eingeben, so schwer ist das nicht ^^");  // Aufforderung bei ungültiger Eingabe
                }
            }
        }
    }
}

/* Beispielausführung
--------------------------------------
Eingabe:
Niklas^^
50
25
33
40
37
38

1

50
75
57
65
60

0
--------------------------------------
Ausgabe:
Wie ist dein Name? Niklas^^
Niklas^^, rate eine Zahl [1-100]: 50
Versuch 1: 50 ist zu hoch.
Niklas^^, rate eine Zahl [1-100]: 25
Versuch 2: 25 ist zu niedrig.
Niklas^^, rate eine Zahl [1-100]: 33
Versuch 3: 33 ist zu niedrig.
Niklas^^, rate eine Zahl [1-100]: 40
Versuch 4: 40 ist zu hoch.
Niklas^^, rate eine Zahl [1-100]: 37
Versuch 5: 37 ist zu niedrig.
Niklas^^, rate eine Zahl [1-100]: 38
Versuch 6: 38 ist korrrekt.
Was möchtest du tun?
1 - Das Spiel fortsetzen
0 - Das Spiel beenden
Deine Eingabe: 1
Niklas^^, rate eine Zahl [1-100]: 50
Versuch 1: 50 ist zu niedrig.
Niklas^^, rate eine Zahl [1-100]: 75
Versuch 2: 75 ist zu hoch.
Niklas^^, rate eine Zahl [1-100]: 57
Versuch 3: 57 ist zu niedrig.
Niklas^^, rate eine Zahl [1-100]: 65
Versuch 4: 65 ist zu hoch.
Niklas^^, rate eine Zahl [1-100]: 60
Versuch 5: 60 ist korrrekt.
Was möchtest du tun?
1 - Das Spiel fortsetzen
0 - Das Spiel beenden
Deine Eingabe: 0
Danke für spielen Niklas^^. ^^
Du hast 2 Spiel(e) gespielt und im Schnitt 5 Versuch(e) gebraucht.
--------------------------------------
 */
