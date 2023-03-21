package de.niklas.io;

import java.io.*;
import java.util.ArrayList;

/**
 * <strong>Zugriff auf eine Textdatei</strong><br>
 * Aufgabe ist es, aus einer Datei Teilbereiche in der Console auszugeben
 *
 * @see "15_IO_Aufgaben-3.pdf"
 * @see de.niklas.strings.Palindrome
 * @author Niklas Buse
 */
public class TextFile {

    private File file = null;
    private ArrayList<String> textfileLines = new ArrayList<String>();


    /**
     * Erstelle eine Verwaltung einer Textdatei auf Zeilenbasis
     * @param f Datei die übergeben wird
     */
    public TextFile(File f){
        this.file = f;
    }

    public TextFile(String pathname){
        this.file = new File(pathname);
    }

    /**
     * Einlesen aller Zeilen und Zwischenspeichern
     */
    public void read(){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while(bufferedReader.ready()) {
                textfileLines.add(bufferedReader.readLine());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Schreibe alle Zeilen aus dem Zwischenspeicher in die Datei
     */
    public void write() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))){
            for (String line : textfileLines) {
                bufferedWriter.write(line + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gibt die Anzahl der benutzbaren Zeilen zurück
     * @return Anzahl der Zeilen
     */
    public int availableLines(){
        return textfileLines.size();
    }

    /**
     * Gibt alle Zeilen aus der Zwischenablage zurück, können von der Datei schon abweichen
     * @return Textzeilen aus dem Zwischenspeicher
     */
    public String[] getLines(){
        String[] stringArr = new String[textfileLines.size()];
        for (int i = 0; i < textfileLines.size(); i++) {
            stringArr[i] = textfileLines.get(i);
        }
        return stringArr;
    }

    /**
     * Gibe eine spezifische Zeile i zurück
     * @param i Zeilennummer
     * @return Inhalt der i. Zeile
     * @throws LineNumberOutOfBoundsException
     */
    public String getLine(int i) throws LineNumberOutOfBoundsException{
        if(i > 0 && i < availableLines()){
            return textfileLines.get(i);
        }
        else{
            throw new LineNumberOutOfBoundsException("Falsche Eingabe bei getLine");
        }
    }

    /**
     * Verändert eine spezifische Zeile i zurück
     * @param i Zeilennummer
     * @param s neuer Inhalt der Zeile
     * @throws LineNumberOutOfBoundsException
     */
    public void setLine(int i, String s) throws LineNumberOutOfBoundsException{
        if(i > 0 && i < availableLines()){
            textfileLines.set(i, s);
        }
        else{
            throw new LineNumberOutOfBoundsException("Falsche Eingabe bei setLine");
        }
    }

    /**
     * Ersetzt alle Vorkommnisse in den Zeilen
     * @param regexp RegEx Ausdruck
     * @param ersatz Womit das ersetzt werden soll
     */
    public void replaceAll(String regexp, String ersatz){
        for(int i = 0; i < textfileLines.size(); i++){
            textfileLines.set(i, textfileLines.get(i).replaceAll(regexp, ersatz));
        }
//        write();
    }

    /**
     * Setzt Datei und Zwischenspeicher zurück
     */
    public void close(){
        file = null;
        textfileLines = new ArrayList<String>();
    }

    public static void main(String[] args) {
        TextFile tfl = new TextFile("FileExperiments/entchen.txt");
        tfl.read();
        for(String line : tfl.getLines()){
            System.out.println(line);
        }

        System.out.println("\nNach Aufruf von: tfl.replaceAll(\"meine\", \"unsre\") \n");

        tfl.replaceAll("meine", "unsere");
        for(String line : tfl.getLines()){
            System.out.println(line);
        }
    }
}

/* Beispielausführung
--------------------------------------
Eingabe:
Lagerregal
--------------------------------------
Ausgabe:
Alle meine Entchen
schwimmen auf dem See,
Köpfchen in das Wasser,
Schwänzchen in die Höh.
Alle meine Täubchen
gurren auf dem Dach
fliegt eins in die Lüfte
fliegen alle nach.
Alle meine Hühner
scharren in dem Stroh,
finden sie ein Körnchen,
sind sie alle froh.
Alle meine Gänschen
watscheln durch den Grund,
suchen in dem Tümpel,
werden kugelrund.

Nach Aufruf von: tfl.replaceAll("meine", "unsre")

Alle unsere Entchen
schwimmen auf dem See,
Köpfchen in das Wasser,
Schwänzchen in die Höh.
Alle unsere Täubchen
gurren auf dem Dach
fliegt eins in die Lüfte
fliegen alle nach.
Alle unsere Hühner
scharren in dem Stroh,
finden sie ein Körnchen,
sind sie alle froh.
Alle unsere Gänschen
watscheln durch den Grund,
suchen in dem Tümpel,
werden kugelrund.
--------------------------------------
Inhalt der Datei (entchen.txt):
Alle meine Entchen
schwimmen auf dem See,
Köpfchen in das Wasser,
Schwänzchen in die Höh.
Alle meine Täubchen
gurren auf dem Dach
fliegt eins in die Lüfte
fliegen alle nach.
Alle meine Hühner
scharren in dem Stroh,
finden sie ein Körnchen,
sind sie alle froh.
Alle meine Gänschen
watscheln durch den Grund,
suchen in dem Tümpel,
werden kugelrund.
--------------------------------------
 */