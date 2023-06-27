package de.niklas.exercise.threads.buffer;

import java.util.Random;

/**
 * <strong>Synchronisation</strong><br>
 * Implementation des ProducerThreads zum hinzufügen von Werten
 *
 * @see "27_Threads_Aufgaben-2.pdf"
 * @see MyBuffer
 * @author Niklas Buse
 */
class ProducerThread extends Thread {
    MyBuffer buffer;
    public ProducerThread(MyBuffer buffer) {
        this.buffer = buffer;
    }
    public void run() {
        for(int i = 0; i < 100; i++){
            this.buffer.put(i);
            try {
                Thread.sleep(new Random().nextInt(0, 1001));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


