package de.niklas.exams.stadtlandfluss_exam_2016.selfwritten;

import javax.swing.*;

public class Row {

	private final JTextField field;
	private final JLabel valueLabel;
	
	public Row(JLabel textLabel, JTextField field, JLabel valueLabel) {
		this.field = field;
		this.valueLabel = valueLabel;
	}
	
	public String getInput() {
		return field.getText().toUpperCase();
	}
	
	public int getPoints() {
		return Integer.valueOf(valueLabel.getText());
	}
	
	public void setPoints(String points) {
		valueLabel.setText(points);
	}
	
}
