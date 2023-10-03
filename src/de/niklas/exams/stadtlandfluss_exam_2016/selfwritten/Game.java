package de.niklas.exams.stadtlandfluss_exam_2016.selfwritten;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class Game implements Runnable{

	private EnumSet<ColumnType> colTypes;
	private char buchstabe;
	private final int min, max;
	private final int seconds;
	private final List<Sheet> sheets = new ArrayList<>();
	private boolean isRunning;
	
	public Game(int min, int max, int seconds) {
		this.min = Math.max(3, min);
		this.max = Math.max(min, max);
		this.seconds = seconds;
	}
	
	public char createFirstChar() {
		return (char) new Random().nextInt(65, 92);
	}
	
	public EnumSet<ColumnType> createColumns() {
		EnumSet<ColumnType> colTypes = EnumSet.of(ColumnType.CITY, ColumnType.COUNTRY, ColumnType.RIVER);
		
		int amount = new Random().nextInt(min, max + 1);
		while (colTypes.size() < amount) {
			colTypes.add(ColumnType.values()[new Random().nextInt(3, ColumnType.values().length)]);
		}
		
		return colTypes;
	}

	public void calcPoints() {
		for (int i = 0; i < colTypes.size(); i++) {
			// Get all valid rows
			int runCounter = i;
			List<Row> rows = getInputs(i).stream()
					.filter(row -> row.getInput().length() > 1)
					.filter(row -> row.getInput().charAt(0) == buchstabe)
					.filter(row -> validateWithFile(row, runCounter))
					.collect(Collectors.toList());

			// if only one sheet has valid input
			if (rows.size() == 1) {
				rows.get(0).setPoints("20");
				continue;
			}

			// if more than one sheet
			while (!rows.isEmpty()) {
				// List with identical inputs
				List<Row> same = rows.stream()
						.filter(row -> row.getInput().equals(rows.get(0).getInput()))
						.toList();
				
				if (same.size() == 1) {
					same.get(0).setPoints("10");
				} else {
					same.forEach(row -> row.setPoints("5"));
				}
				
				rows.removeAll(same);
			}
		}
	}
	
	public void register(Sheet sheet) {
		sheets.add(sheet);
	}
	
	public void startGame() {
		this.isRunning = true;
		this.colTypes = createColumns();
		this.buchstabe = createFirstChar();
		sheets.forEach(Sheet::startGame);
		
		new Thread(this).start();
	}
	
	public void stopGame() {
		this.isRunning = false;
		calcPoints();
		sheets.forEach(Sheet::stopGame);
	}
	
	public EnumSet<ColumnType> getColTypes() {
		return colTypes;
	}

	public char getBuchstabe() {
		return buchstabe;
	}

	public int getSeconds() {
		return seconds;
	}
	
	private List<Row> getInputs(int row) {
		return sheets.stream()
				.map(sh -> sh.getRows().get(row) )
				.collect(Collectors.toList());
	}

	private boolean validateWithFile(Row row, int runCounter){
		String filename = "src/de/niklas/exams/stadtlandfluss_exam_2016/provided/validwords.txt";
		try {
			List<String> validWords = Files.readAllLines(Paths.get(filename)) // als Stream weiterverarbeiten
		            .stream().toList();

			List<ColumnType> columnTypeList = colTypes.stream().toList();

			if(validWords.contains(row.getInput().toLowerCase())){
				return true;
			}
			else{
				String[] opts = { "Ja", "Nein", "Abbrechen"};
				int popup = JOptionPane.showOptionDialog(null, String.format("Ist %s korrekt für die Kategorie %s", row.getInput(), columnTypeList.get(runCounter).getTopic()),"Option auswählen", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opts, opts[0]);
				if(popup == JOptionPane.YES_OPTION){
					try {
					    Files.writeString(Paths.get(filename),
					        row.getInput().toLowerCase() + System.lineSeparator(),
					        StandardOpenOption.APPEND,
					        StandardOpenOption.CREATE
					    );
					} catch (IOException ex) {
					    JOptionPane.showMessageDialog(null, ex.getMessage());
					}
					return true;
				}
				else{
					return false;
				}
			}
		} catch (NumberFormatException | IOException ex) {
		    System.err.printf("Read error: %s%n", ex.getLocalizedMessage());
			return true;
		}
	}

	@Override
	public void run() {
		int i = 61;
		while (i > 0 && isRunning) {
			i--;
			for (Sheet sh : sheets){
				sh.setTime(i);
			}
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException ignored) {}
		}
		if (i == 0 && isRunning){
			stopGame();
		}
	}
}
