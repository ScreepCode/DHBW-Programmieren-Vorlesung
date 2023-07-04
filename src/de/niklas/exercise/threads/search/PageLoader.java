package de.niklas.exercise.threads.search;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

/**
 * <strong>Suchmaschine</strong><br>
 * Pageloader/WebScraper Thread
 *
 * @see "27_Threads_Aufgaben-2.pdf"
 * @see SearchEngine
 * @author Niklas Buse
 */
public class PageLoader implements Runnable{

    private URL url;
    private String content;

    PageLoader(String url) {
        try {
            this.url = new URL(url);
            content = null;
            new Thread(this).start();
        }
        catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Liefert die URL als String zurück
     * @return Url als String
     */
    public String getUrl() {
        return this.url.toString();
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
        return content.strip();
    }

    /**
     * Anfrage und Ausgabe des Strings der Webseite
     */
    @Override
    public void run() {
        this.content = getContentAsStringFromUrl();
    }

    /**
     * Aufrufen der Seite und Rückgabe des Inhalts
     * @return Inhalt der Seite als String
     */
    public String getContentAsStringFromUrl() {
        StringBuilder buffer = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(this.url.openStream(), StandardCharsets.UTF_8))) {
            while (br.ready()) {
                buffer.append(br.readLine()).append(System.lineSeparator());
            }
            return buffer.toString();
        } catch (IOException ex) {
            return String.format("Fehler beim Laden: %s", ex.getMessage());
        }
    }
}
