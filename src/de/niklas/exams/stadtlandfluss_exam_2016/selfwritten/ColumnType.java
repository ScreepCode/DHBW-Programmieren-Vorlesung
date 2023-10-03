package de.niklas.exams.stadtlandfluss_exam_2016.selfwritten;

public enum ColumnType {

	CITY		("Stadt"),
	COUNTRY		("Land"),
	RIVER		("Fluss"),
	PROFESSION 	("Beruf"),
	ANIMAL		("Tier"),
	NAME		("Name"),
	SPORT		("Sportart"),
	FOOD		("Lebensmittel"),
	BEVERAGE	("Getränk"),
	GAME		("Spiel");

	private final String topic;
	
	private ColumnType(String topic) {
		this.topic = topic;
	}

	public String getTopic() {
		return topic;
	}
	
}
