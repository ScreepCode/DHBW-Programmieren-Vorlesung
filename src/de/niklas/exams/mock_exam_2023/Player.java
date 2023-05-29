package de.niklas.exams.mock_exam_2023;

/**
 * <strong>Player</strong><br>
 * Die Implementation eines Spielers
 *
 * @see "Teilaufgabe d & g"
 * @author Niklas Buse
 */
public class Player {

    private String name;

    private int countDartsThrown;
    private Visit[] visits = new Visit[10];

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCountDartsThrown() {
        return countDartsThrown;
    }

    public int getRemainingPoints(){
        int remainingPoints = 501;
        for(Visit visit : visits){
            if(visit != null){
                remainingPoints -= visit.getValue();
            }
        }
        return remainingPoints;
    }

    public boolean addVisit(Visit visit){
        if(getRemainingPoints()-visit.getValue() == 0 & visit.getLastField().isDoubleField()){
            visits[countDartsThrown] = visit;
            countDartsThrown++;
            return true;
        }
        if(getRemainingPoints()-visit.getValue() <= 1){
            countDartsThrown++;
            return false;
        }
        else{
            visits[countDartsThrown] = visit;
            countDartsThrown++;
            return true;
        }
    }

    @Override
    public String toString() {
        return String.format("Player: %s, %d points remaining.", getName(), getRemainingPoints());
    }
}
