package de.niklas.exercise.io;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * <strong>FileExperiments</strong><br>
 * Erstellen und Löschen von Dateien relativ zu einem festgelegten Work Directory
 *
 * @see "15_IO_Aufgaben-1.pdf"
 * @author Niklas Buse
 */
public class FileExperiments {
    public static void main(String[] args) {
        File myDir = new File("myDir");             // Erstelle ein Verzeichnisobjekt
        myDir.mkdir();                                      // Hier wird das Verzeichnis erst erstellt

        for (int i = 1; i <= 3; i++){
            File tmpFile = new File(myDir, "foo"+i);   // Erstelle ein File Objekt
            try {
                tmpFile.createNewFile();                    // Erstelle die Datei im Dateisystem (try-catch für Error-Handling)
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(myDir.getAbsolutePath());        // Gebe den Pfad vom Wurzelverzeichnis aus

        File[] fileList = myDir.listFiles();                // Alle Dateien listen in meinem Verzeichnis
        System.out.println("Dateiliste: " + Arrays.toString(myDir.listFiles()));

        // Löschen der Dateien
        for(File file : fileList){                          // Es müssen erst alle Dateien gelöscht werden, bevor das Verzeichnis gelöscht werden soll
            file.delete();
        }
        myDir.delete();                                     // Am Ende wird das Verzeichnis wieder gelöscht
    }
}

/* Beispielausführung
--------------------------------------
Eingabe: Keine
--------------------------------------
Ausgabe:
C:\DEV\DHBW\DHBW-Programmieren-Vorlesung\FileExperiments\myDir
Dateiliste: [myDir\foo1, myDir\foo2, myDir\foo3]
--------------------------------------
 */