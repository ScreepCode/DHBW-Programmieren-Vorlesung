package de.niklas.io;

import java.io.*;
import java.util.Scanner;
/**
 * <strong>Quersummen speichern</strong><br>
 * Die Klasse CrossTotal erweitern um das Lokale Speichern in einer Datei
 *
 * @see "15_IO_Aufgaben-1.pdf"
 * @see de.niklas.strings.CrossTotal
 * @author Niklas Buse
 */
public class CrossTotalFile {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Bitte Zahl für Quersumme eingeben: ");
        String eingabe = scan.next();
        int ergebnis = 0;
        for(int i = 0; i < eingabe.length(); i++){
            ergebnis += eingabe.charAt(i) - '0';    // Hier ist die Lösung mit Wert des Chars - den Wert der ersten Ziffer (0), Rest ist der Ziffernwert
        }

        String outputString = String.format("Die Quersumme von %s ist %d.", eingabe, ergebnis);
        System.out.println(outputString);

        // Ab hier wird das Ergebnis lokal gespeichert

        try (FileWriter fWriter = new FileWriter("FileExperiments/crossTotal.txt", true)){     // öffnen des FileWriters mit Anweisung append
            fWriter.write(outputString + System.lineSeparator());          // Schreiben des Strings in die Datei
            System.out.println("Ergebnis in der Datei gespeichert.");
        }
        catch (IOException e) {
            e.printStackTrace();                                                // Ausgeben des Fehlers, wenn einer auftritt
        }
    }
}

/* Beispielausführung
--------------------------------------
Eingabe:
369246
--------------------------------------
Ausgabe:
Bitte Zahl für Quersumme eingeben: 369246
Die Quersumme von 369246 ist 30.
Ergebnis in der Datei gespeichert.
--------------------------------------
Inhalt der Datei (crossTotal.txt):
[Vorheriger Inhalt]
Die Quersumme von 369246 ist 30.
--------------------------------------
 */
