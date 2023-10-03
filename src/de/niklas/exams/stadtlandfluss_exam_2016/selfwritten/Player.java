package de.niklas.exams.stadtlandfluss_exam_2016.selfwritten;

public class Player {

	private String name;
	private int points;
	
	public Player(String name) {
		this.name = name;
		points = 0;
	}

	public String getName() {
		return name;
	}

	public int getPoints() {
		return points;
	}
	
}
