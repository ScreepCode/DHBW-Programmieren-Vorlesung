package de.niklas.classes;

import java.util.Random;
import java.util.Scanner;

public class Nimmspiel {

    private String[] player = new String[2];
    private int[] stacks = new int[2];
    private int nextPlayer;
    Scanner scan = new Scanner(System.in);


    public Nimmspiel(String player1, String player2){
        player[0] = player1;
        player[1] = player2;

        for(int i = 0; i < stacks.length; i++){
            stacks[i] = new Random().nextInt(4, 11);
        }

        this.nextPlayer = new Random().nextInt(0, 1);

        play();
    }

    private void play(){
        while(checkStacksIfFull()){
            System.out.printf(toString());
            nextPlayer = (nextPlayer == 1) ? 0 : 1;
            move();
        }
        System.out.printf(toString());
        System.out.println("\nSpiel beendet.");
        System.out.printf("Gewonnen hat Spieler %s", player[nextPlayer]);
    }

    private void move(){
        System.out.printf("\nSpieler %s: Von welchem Haufen ziehen Sie Kugeln? ", player[nextPlayer]);
        scan = new java.util.Scanner(System.in);
        int stackNum = scan.nextInt() - 1;
        if(stacks[stackNum] == 0){
            System.out.printf("Spieler %s: Der Haufen ist bereits leer, du musst automatisch vom anderen nehmen!", player[nextPlayer]);
        }
        boolean pulled = false;
        while(!pulled) {
            System.out.printf("Spieler %s: Wie viele Kugeln ziehen Sie? ", player[nextPlayer]);
            scan = new java.util.Scanner(System.in);
            int toPull = scan.nextInt();
            if (this.stacks[stackNum] >= toPull) {
                this.stacks[stackNum] -= toPull;
                pulled = true;
            } else {
                System.out.printf("Spieler %s: Du kannst nicht mehr Kugeln ziehen als auf dem Haufen sind!", player[nextPlayer]);
            }
        }
    }

    private boolean checkStacksIfFull(){
        return !(stacks[0] == 0 && stacks[1] == 0);
    }

    @Override
    public String toString() {
        return String.format("\nSpieler: %s und %s, Haufen 1: %d Kugel(n), Haufen 2: %d Kugel(n)", player[0], player[1], stacks[0], stacks[1]);
    }

    public static void main(String[] args) {
        new Nimmspiel("Alf", "Ben");
    }
}
