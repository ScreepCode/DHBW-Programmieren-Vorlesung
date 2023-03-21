package de.niklas.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * <strong>Teil einer Datei</strong><br>
 * Aufgabe ist es, aus einer Datei Teilbereiche in der Console auszugeben
 *
 * @see "15_IO_Aufgaben-2.pdf"
 * @see de.niklas.strings.Palindrome
 * @author Niklas Buse
 */
public class TextfileLines {
    public static void main(String[] args) {

        ArrayList<String> lines = new ArrayList<String>();  // Arraylist ist erst Teil des 2. Semesters!
        try(BufferedReader br = new BufferedReader(new FileReader("FileExperiments/beispiel.txt"))) {
            while(br.ready()) {
                lines.add(br.readLine());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        StringBuilder concatString = new StringBuilder();
        for(int i = 1; i <= 4; i++){
            System.out.println(lines.get(i));
            concatString.append(lines.get(i));
        }
        System.out.println("Zeile 2-5: " + concatString);
    }
}

/* Beispielausführung
--------------------------------------
Eingabe: Keine
--------------------------------------
Ausgabe:
ipsum
dolor
4
5
ipsumdolor45
--------------------------------------
Inhalt der Datei (beispiel.txt):
Lorem
ipsum
dolor
4
5
6
7
the
end is
near!
--------------------------------------
 */