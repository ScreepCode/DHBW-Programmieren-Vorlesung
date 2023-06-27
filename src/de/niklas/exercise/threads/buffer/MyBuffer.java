package de.niklas.exercise.threads.buffer;

import java.util.LinkedList;
import java.util.List;

/**
 * <strong>Synchronisation</strong><br>
 * Implementation des Buffers als Linked-List
 *
 * @see "27_Threads_Aufgaben-2.pdf"
 * @author Niklas Buse
 */
public class MyBuffer {
    private final List<Integer> values = new LinkedList<Integer>();
    static final int MAXSIZE = 3;

    /**
     * Hinzufügen der Elemente mit Überprüfung auf maximale Größe
     * Bei Bedarf anhalten des Threads
     * @param in Wert der hinzugefügt wird
     */
    public synchronized void put(int in) {
        if (this.values.size() == MAXSIZE) { // Wenn der Buffer voll ist, muss gewartet werden
            try {
                this.wait();
            }
            catch (InterruptedException e) { e.printStackTrace(); }
        }
        this.values.add(in);
        this.notify(); // Benachrichtigen, wenn zuvor leer war
        System.out.printf("Put: %d\n", in);
        System.out.printf("Fill level after put: %d\n",  this.values.size());
    }

    /**
     * Abrufen des aktuellen Elements
     * Bei Bedarf anhalten des Threads
     * @return Wert der ausgelesen wird
     */
    public synchronized int get() {
        if (values.isEmpty()) { // Wenn der Buffer leer ist, muss gewartet werden
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        int out = this.values.remove(0);
        this.notify(); // Benachrichtigen, wenn zuvor voll war
        System.out.printf("Get: %d\n", out);
        System.out.printf("Fill level after get: %d\n",  this.values.size());
        return out;
    }
}
