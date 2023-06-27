package de.niklas.exercise.threads.search;

import java.io.*;
import java.net.*;

/**
 * <strong>Suchmaschine</strong><br>
 * Pageloader/WebScraper Thread
 *
 * @see "27_Threads_Aufgaben-2.pdf"
 * @see SearchEngine
 * @author Niklas Buse
 */
public class PageLoader implements Runnable{

    public static String CHARSET = "UTF-8";
    public URL url;
    public String content;

    PageLoader(String url) {
        try {
            this.url = new URL(url);
            content = null;
        }
        catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Liefert Information, ob das heruntergeladen abgeschlossen ist
     * @return Ladezustand
     */
    public boolean pageLoaded() {
        return (content != null);
    }

    /**
     * Liefert den Inhalt der geladenen Seite zurück
     * WICHTIG: Vorher abfragen, ob der Inhalt schon geladen ist.
     * @return Seiteninhalt
     */
    public String getPageContent() {
        return content;
    }

    /**
     * Anfrage und Ausgabe des Strings der Webseite
     */
    @Override
    public void run() {
        this.content = getContentAsStringFromUrl();

        // Diese Ausgabe ist für die SearchEngine.exec(), in der exec2() ist es richtig implementiert

//        System.out.printf("------\nGeladen: %s \nInhalt: \n%s \n------",
//                this.url.toString(),
//                content.substring(0, (Math.min(content.length(), 50))));
    }

    /**
     * Aufrufen der Seite und Rückgabe des Inhalts
     * @return Inhalt der Seite als String
     */
    public String getContentAsStringFromUrl() {
        StringBuilder buffer = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(this.url.openStream(), CHARSET))) {
            while (br.ready()) {
                buffer.append(br.readLine()).append(System.lineSeparator());
            }
            return buffer.toString();
        } catch (IOException ex) {
            return String.format("Fehler beim Laden: %s", ex.getMessage());
        }
    }
}
