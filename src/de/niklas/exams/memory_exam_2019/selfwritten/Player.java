package de.niklas.exams.memory_exam_2019.selfwritten;

public class Player implements Comparable{
    private String name;
    private int points;
    private PlayerStatus status;

    public Player(String name){
        this.name = name;
        this.points = 0;
        this.status = PlayerStatus.WAITING;
    }

    public void addPoint(){
        points += 1;
    }

    public void setStatus(PlayerStatus status){
        this.status = status;
    }

    public PlayerStatus getStatus(){
        return this.status;
    }

    @Override
    public String toString() {
        return String.format("%s (%d)", this.name, this.points);
    }

    public int getPoints(){
        return points;
    }


    @Override
    public int compareTo(Object object) {
        Player other = (Player) object;
        return Integer.compare(other.getPoints(), this.points);
    }
}
