package de.niklas.exercise.threads;
import javax.swing.*;
import java.awt.*;

/**
 * <strong>Ampel</strong><br>
 * Emulation einer Ampel über Threads mit Sleep
 * Die Bearbeitung wurde mir von Jonas freundlicherweise zur Verfügung gestellt
 *
 * @see "27_Threads_Aufgaben-1.pdf"
 * @author Niklas Buse (& Jonas Huber)
 */
public class TrafficLight extends JComponent implements Runnable{
    private LightPhase phase;
    private JFrame frame;
    private Thread runner;

    public TrafficLight() {
        this.frame = new JFrame();
        this.frame.add(this);
        this.phase = LightPhase.RED;

        this.frame.setTitle("Traffic Light");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setLocationRelativeTo(null);
        this.frame.setSize(80, 340);
        this.frame.setVisible(true);

        this.runner = new Thread(this);
        this.runner.start();
    }

    /**
     * Zeichnen der Ampel
     * Entsprechend der aktiven Phase wird gefärbt
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        g.fillRect(0, 0, 100, 320);

        // Red
        g.setColor((this.phase.red) ? Color.RED : Color.WHITE); // Ausdruck als Boolean, statt als if um es zu vereinfachen
        g.fillOval(10, 30, 80, 80);

        // Yellow        g.setColor((this.phase.yellow) ? Color.YELLOW : Color.WHITE);
        g.fillOval(10, 120, 80, 80);

        // Green
        g.setColor((this.phase.green) ? Color.GREEN : Color.WHITE);
        g.fillOval(10, 210, 80, 80);
    }

    /**
     * Phasenhandling über Threading mit Sleep
     */
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(this.phase.duration);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.phase = this.phase.nextPhase();
            this.repaint();
        }
    }

    public static void main(String[] args) {
        new TrafficLight();
    }
}

enum LightPhase {
    RED(true, false, false, 5000),
    RED_YELLOW(true, true, false, 500),
    GREEN(false, false, true, 5000),
    YELLOW(false, true, false, 500);

    public final boolean red;
    public final boolean yellow;
    public final boolean green;
    public final int duration;

    /**
     * Einzelne Ampelphasen
     * @param red Rote Anzeige
     * @param yellow Gelbe Anzeige
     * @param green Grüne Anzeige
     * @param duration Phasendauer bis zur nächsten
     */
    LightPhase(boolean red, boolean yellow, boolean green, int duration) {
        this.red = red;
        this.yellow = yellow;
        this.green = green;
        this.duration = duration;
    }

    /**
     * Setzen der neuen Phase
     * @return neue Phase
     */
    public LightPhase nextPhase() {
        return switch (this) {
            case RED -> RED_YELLOW;
            case RED_YELLOW -> GREEN;
            case GREEN -> YELLOW;
            case YELLOW -> RED;
            default -> throw new IllegalStateException("Invalid traffic light phase");
        };
    }
}
