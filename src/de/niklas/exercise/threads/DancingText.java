package de.niklas.exercise.threads;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * <strong>Tanzende Schrift</strong><br>
 * Sich bewegende Schrift durch ein Thread mit Sleep
 *
 * @see "27_Threads_Aufgaben-1.pdf"
 * @author Niklas Buse
 */
public class DancingText extends JFrame implements Runnable{

    String text = "Hier ist ein cooler Text";
    private Thread thread;
    private Random rand = new Random();

    public DancingText() {
        this.setTitle("Dancing Text");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(text.length()*50+20, 300);
        this.setVisible(true);
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    /**
     * Die Methode, die durch Thread Start ausgeführt wird
     */
    public void run() {
        while (thread != null) {
            repaint();
            try {
                Thread.sleep((text.length()* 7L));
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    /**
     * Paint Methode des Frames
     * @param g Grafik Fenster
     */
    public void paint(Graphics g) {
        g.setFont(new Font("Helvetica", Font.BOLD, 72));
//        g.clearRect(0, 0, this.getWidth(), this.getHeight());
        for (int i = 0; i < text.length(); i++) {
            g.setColor(new Color(rand.nextInt(0,256), rand.nextInt(0,256), rand.nextInt(0,256)));
            g.drawString(text.substring(i, i + 1), i * 45 + 45, (20 + rand.nextInt(100)) + 120);
        }
    }

    public static void main(String[] args) {
        new DancingText();
    }
}
