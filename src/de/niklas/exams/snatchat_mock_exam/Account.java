package de.niklas.exams.snatchat_mock_exam;

import java.awt.Color;
import java.util.Random;

public class Account {

	private String name;
	private Color color;
	private State state;
	
	public Account(String name) {
		this.name = name;
		this.state = State.AVAILABLE;
		Random rand = new Random();
		this.color = new Color(rand.nextInt(0, 201), rand.nextInt(0, 201), rand.nextInt(0, 201));
	}

	public String getName() {
		return name;
	}

	public Color getColor() {
		return color;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

}
