package de.niklas.exams.chorona_extra_exam_2021.selfwritten;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RoomSetting {

    private final int width, height;
    private final Set<Point> pollutants = new HashSet<>();

    public RoomSetting(int width, int height, int numberPollutants) throws AHAException {
        this.width = width;
        this.height = height;

        if((width * height) < numberPollutants){
            throw new AHAException();
        }

        generatePolluters(numberPollutants);
    }

    public void generatePolluters(int numberPollutants){
        while(pollutants.size() < numberPollutants){
            int x = new Random().nextInt(1, this.width);
            int y = new Random().nextInt(0, this.height);
            pollutants.add(new Point(x, y));
        }
    }

    public Set<Point> getPolluters() {
        return pollutants;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
