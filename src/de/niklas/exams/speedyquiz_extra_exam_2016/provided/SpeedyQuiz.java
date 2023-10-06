package de.niklas.exams.speedyquiz_extra_exam_2016.provided;

import de.niklas.exams.speedyquiz_extra_exam_2016.selfwritten.*;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * Speedy Quiz
 */
public class SpeedyQuiz {
	
	/**
	 * Main method, entry point of application
	 * 
	 * @param args CLI arguments
	 */
	public static void main(String[] args) {
		// Set cross platform LAF to get colors for sure to work on MacOS
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
		}
		
		List<Question> questionPool = loadQuestions();
		
		try {
			Game game = new Game(questionPool, 10);

			game.registerClient( new GameTerm("Mia", game) );
			game.registerClient( new GameTerm("Ben", game) );

			game.startGame();
		} catch (GameException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Game Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}

	/**
	 * Load questions
	 * 
	 * @return questions to load
	 */
	public static List<Question> loadQuestions(){
		List<Question> questions = new ArrayList<>();


		String filename = "src/de/niklas/exams/speedyquiz_extra_exam_2016/provided/questions.txt";
		try {
		    Files.readAllLines(Paths.get(filename)) // als Stream weiterverarbeiten
		            .forEach(line -> questions.add(parseQuestion(line))); // z.B.
		} catch (NumberFormatException | IOException ex) {
		    JOptionPane.showMessageDialog(null, String.format("questions.txt (%s)", ex.getCause()) , "Error loading questions", JOptionPane.ERROR_MESSAGE);

		}
		
		return questions;
	}
	
	/**
	 * Parse a question from input line
	 * 
	 * @param line line to parse
	 * @return created question instance
	 */
	public static Question parseQuestion( String line ){
		try {
			String[] parts = line.split(";");
				if ( parts.length == 6 ){
				String[] answers = new String[4];
				System.arraycopy(parts, 1, answers, 0, 4);
				return new Question(parts[0], answers, Integer.parseInt(parts[5]));
			}
		} catch (Exception e) {
		}
		return null;
	}
	
}
