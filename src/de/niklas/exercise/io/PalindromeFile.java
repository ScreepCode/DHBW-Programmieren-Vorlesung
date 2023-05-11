package de.niklas.exercise.io;

import java.io.*;
import java.util.Scanner;

/**
 * <strong>Palindrome Speichern</strong><br>
 * Überprüfen auf Palindrom und speichern wenn es so ist. Ausgabe der Datei anschließend
 *
 * @see "15_IO_Aufgaben-2.pdf"
 * @see de.niklas.exercise.strings.Palindrome
 * @author Niklas Buse
 */
public class PalindromeFile {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Bitte Wort eingeben: ");
        String eingabe = scan.next();

        StringBuffer ergebnis = new StringBuffer();
        for(int i = eingabe.length()-1; i >= 0; i--){   // Hier wird der String von Hinten nach Vorne durchgegangen
            ergebnis.append(eingabe.charAt(i));
        }
        System.out.printf("Umgekehrt: %s\n", ergebnis);

        System.out.printf("%s ist %s Palindrom\n",
                eingabe,
                (eingabe.equalsIgnoreCase(ergebnis.toString())? "ein": "kein")  // Überprüfung ohne Beachtung der Großschreibung, ob es sich um ähnliche Strings handelt
        );

        // Ab hier beginnt das neue

        String dateiName = "FileExperiments/palindrome.txt";
        if(eingabe.equalsIgnoreCase(ergebnis.toString())){                          // Nur speichern, wenn es wirklich ein Palindrom ist
            try(FileWriter fileWriter = new FileWriter(dateiName, true)){
                fileWriter.write(eingabe + System.lineSeparator());
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }

        System.out.println("Alle bisher gefundenen Palindrome: ");
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(dateiName))){ // BufferedReader um einzelne Zeilen lesen zu können
            while (bufferedReader.ready()){
                System.out.println(bufferedReader.readLine());  // jede zeile wird ausgegeben
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/* Beispielausführung
--------------------------------------
Eingabe:
Lagerregal
--------------------------------------
Ausgabe:
Bitte Wort eingeben: Lagerregal
Umgekehrt: lagerregaL
Lagerregal ist ein
Alle bisher gefundenen Palindrome:
Anna
Otto
EinEsellesenie
Otto
mnbvbnm
Lagerregal
--------------------------------------
Inhalt der Datei (crossTotal.txt):
Anna
Otto
EinEsellesenie
Otto
mnbvbnm
Lagerregal
--------------------------------------
 */