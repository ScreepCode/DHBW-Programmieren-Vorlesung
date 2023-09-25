package de.niklas.exams.memory_exam_2019.selfwritten;

import de.niklas.exams.memory_exam_2019.provided.MemoryImages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MemoryGame {
    private int rows, cols;
    private List<Player> players;
    private List<MemoryImages.MemoryImage> images = new ArrayList<>();
    private Player activePlayer;

    public MemoryGame(List<Player> players, List<MemoryImages.MemoryImage> allImages, int rows, int cols) throws MemoryException {
        if(players.size() < 2){
            throw new MemoryException("At least two players required");
        }
        else{
            this.players = players;
        }

        int anzahl = (rows * cols)/2;
        if(anzahl > allImages.size()){
            throw new MemoryException("Too few images available");
        }
        else{
            this.rows = rows;
            this.cols = cols;

            for(int i = 0; i < anzahl; i++){
                int zufallszahl = new Random().nextInt(0, allImages.size());
                this.images.add(allImages.get(zufallszahl));
                allImages.remove(zufallszahl);
            }
        }
        this.activePlayer = players.get(0);
        this.activePlayer.setStatus(PlayerStatus.ACTIVE);
    }


    public Player getCurrentPlayer(){
        return activePlayer;
    }

    public boolean isBlankRequired(){
        return (rows * cols) % 2 != 0;
    }

    public void nextPlayer(){
        int stelle = players.indexOf(activePlayer);
        activePlayer.setStatus(PlayerStatus.WAITING);

        activePlayer = players.get((stelle + 1) % players.size());
        activePlayer.setStatus(PlayerStatus.ACTIVE);
    }

    public List<Player> getPlayersList(){
        return this.players;
    }

    public int getRows(){
        return this.rows;
    }

    public int getCols(){
        return this.cols;
    }

    public List<MemoryImages.MemoryImage> getImages(){
        return this.images;
    }

}
