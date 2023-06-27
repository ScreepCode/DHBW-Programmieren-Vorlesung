package de.niklas.exercise.threads.buffer;

import java.util.Random;

/**
 * <strong>Synchronisation</strong><br>
 * Implementation des ConsumerThreads zum herausnehmen des aktuellen Werts
 *
 * @see "27_Threads_Aufgaben-2.pdf"
 * @see MyBuffer
 * @author Niklas Buse
 */
class ConsumerThread extends Thread {
    MyBuffer buffer;
    public ConsumerThread(MyBuffer buffer) {
        this.buffer = buffer;
    }
    public void run() {
        for(int i = 0; i < 100; i++){
            this.buffer.get();
            try {
                Thread.sleep(new Random().nextInt(0, 1001)); // Zahl zwischen 0 und 1000
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

