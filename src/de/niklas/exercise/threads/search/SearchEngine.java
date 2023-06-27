package de.niklas.exercise.threads.search;

import java.util.*;
import java.io.*;
import java.util.concurrent.*;

/**
 * <strong>Suchmaschine</strong><br>
 * Implementation der WebScraping Aufrufe über Threading
 *
 * @see "27_Threads_Aufgaben-2.pdf"
 * @author Niklas Buse
 */
public class SearchEngine {

    public List<String> urls = new LinkedList<String>();

    public static final int MAXTHREADS = 3;

    /**
     * Laden der URLs
     * @param filename Dateiname/Pfad
     */
    public void loadURLs(String filename) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            while (br.ready()) {
                urls.add(br.readLine());
            }
            br.close();
        } catch (IOException ex) {
            System.err.println("Fehler beim Laden der Datei: " + filename);
        }
    }

    /**
     * Ausführenung der PageLoader Threads
     * Diese Lösung ist nach der Aufgabe her nicht korrekt, da hier überprüft und ausgeben soll.
     * Korrektur und eigene Implementierung ist exec2
     */
    public void exec (){
        this.loadURLs("FileExperiments/urls.txt"); // Laden der URLs
        ExecutorService exec = Executors.newFixedThreadPool(MAXTHREADS); // Thread Pool in der Größe der Konstante
        while (!this.urls.isEmpty()) {
            PageLoader pl = new PageLoader(this.urls.remove(0)); // Nutzen der nächsten Links + Löschen aus der Liste
            exec.execute(pl); // Ausführen der Run Methode des Page Loaders
        }
        exec.shutdown();
    }

    /**
     * Ausführung der PageThreads;
     * es wird eine LinkedList erzeugt, in der die Threads in Startreihenfolge reingepackt werden.
     * Danach wird das vordere Element überprüft, ob es schon fertig ist und dann ggf. ausgegeben, entfernt und Platz für den nächsten Thread.
     * Diese Implementierung ist NICHT optimal, da die Ladezeiten variieren können und somit das andere Elemente als das vordere schon fertig sein könnte
     */
    public void exec2(){
        this.loadURLs("FileExperiments/urls.txt"); // Laden der URLs
        Queue<PageLoader> pagesThreads = new LinkedList<>(); // Eine Queue, das FIFO Prinzip zu haben
        while (!this.urls.isEmpty() | !pagesThreads.isEmpty()){ // Solange es noch URLs gibt, oder in der Liste noch Threads laufen
            if(pagesThreads.size() < MAXTHREADS & !this.urls.isEmpty()){ // Nur neue Threads starten, wenn die MaxThreads noch nicht überschritten sind
                PageLoader page = new PageLoader(this.urls.remove(0));
                pagesThreads.add(page);
                new Thread(page).start();
            }
            if(pagesThreads.element().pageLoaded()){ // Wenn das vordere Element fertig ist
                PageLoader page = pagesThreads.remove(); // Nehme es aus der Liste raus, damit der nächste Thread gestartet werden kann
                String content = page.getPageContent();
                System.out.printf("------\nGeladen: %s \nInhalt: \n%s \n------",
                        page.url.toString(),
                        content.substring(0, (Math.min(content.length(), 50))));
            }
        }
    }

    public static void main(String[] args) {
//        wenn Proxy notwendig
//        System.setProperty("proxySet", "true");
//        System.setProperty("proxyHost", "xyz"); // Hier müsste dann ein Proxyhost rein
//        System.setProperty("proxyPort", "8000");
        SearchEngine searchEngine = new SearchEngine();
//        searchEngine.exec(); // Lösung die nicht der Aufgabe entspricht
        searchEngine.exec2();
    }
}