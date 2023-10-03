package de.niklas.exams.stadtlandfluss_exam_2016.provided;

import de.niklas.exams.stadtlandfluss_exam_2016.selfwritten.*;

public class StadtLandFluss {

	public static void main(String[] args) {
		Game slf = new Game(4,6,60);
		slf.register(new Sheet(new Player("Otto"),slf));
		slf.register(new Sheet(new Player("Anna"),slf));
	}
}
