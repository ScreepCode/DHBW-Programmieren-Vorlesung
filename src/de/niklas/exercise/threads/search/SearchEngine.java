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

    private final ExecutorService exec;
    private final List<PageLoader> loaders;

    public List<String> urls = new LinkedList<>();
    public static final int MAXTHREADS = 3;

    public SearchEngine(){
        this.exec = Executors.newFixedThreadPool(MAXTHREADS);
        this.loaders = new LinkedList<>();
    }


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
     * Ausführung der PageLoader Threads
     */
    public void exec() {
        for (String url : urls) {
            System.out.printf("Started: %s%n", url);
            PageLoader newLoader = new PageLoader(url);
            this.loaders.add(newLoader);
            this.exec.execute(newLoader);

            while (!this.loaders.isEmpty()) {
                Iterator<PageLoader> iterator = loaders.iterator();

                while (iterator.hasNext()) {
                    PageLoader page = iterator.next();
                    if (page.pageLoaded()) {
                        String content = page.getPageContent();
                        System.out.printf("Finished: %s\n%s\n...\n", page.getUrl(), content.strip().substring(0, (Math.min(content.length(), 100))));
                        iterator.remove(); // remove current element from list
                    }
                }
            }
            exec.shutdown();
        }
    }

    public static void main(String[] args) {
//        wenn Proxy notwendig
//        System.setProperty("proxySet", "true");
//        System.setProperty("proxyHost", "xyz"); // Hier müsste dann ein Proxyhost rein
//        System.setProperty("proxyPort", "8000");
        SearchEngine searchEngine = new SearchEngine();
        searchEngine.loadURLs("FileExperiments/urls.txt");
        searchEngine.exec();
    }
}