package de.niklas.exercise.threads.buffer;

/**
 * <strong>Synchronisation</strong><br>
 * Test Klasse
 *
 * @see "27_Threads_Aufgaben-2.pdf"
 * @see MyBuffer
 * @author Niklas Buse
 */
public class BufferTest {
    public static void main(String[] args) {
        MyBuffer buffer = new MyBuffer();

        // Ausführliche Initialisierung
//        Thread runProducer = new Thread(new ProducerThread(buffer));
//        Thread runConsumer = new Thread(new ConsumerThread(buffer));
//        runProducer.start();
//        runConsumer.start();

        // Für diese Aufgabe reicht theoretisch diese Schreibweise, weil wir an den laufenden Threads nicht zugreifen wollen
        new Thread(new ProducerThread(buffer)).start();
        new Thread(new ConsumerThread(buffer)).start();
    }
}
