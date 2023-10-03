package de.niklas.exams.stadtlandfluss_exam_2016.selfwritten;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class Sheet extends JFrame {

	private Game game;
	private Player player;
	private List<Row> rows = new ArrayList<>();
	private JLabel statsLabel1, statsLabel2, statsLabel3;
	private JButton start, stop;
	private JPanel columnPanel;
	
	public Sheet(Player player, Game game) {
		this.player = player;
		this.game = game;

		this.setTitle(player.getName());
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel statsPanel = new JPanel();
		statsPanel.setLayout(new GridLayout(3, 2, 5, 0));
		statsLabel1 = new JLabel("0");
		statsLabel2 = new JLabel("");
		statsLabel3 = new JLabel("");
		statsPanel.add(new JLabel("Punkte"));
		statsPanel.add(statsLabel1);
		statsPanel.add(new JLabel("Verbleibende Sekunden"));
		statsPanel.add(statsLabel2);
		statsPanel.add(new JLabel("Anfangsbuchstabe"));
		statsPanel.add(statsLabel3);

		columnPanel = new JPanel();
		columnPanel.add(new JLabel("Kein Spiel aktiv."));

		JPanel bottom = new JPanel();
		start = new JButton("Start");
		start.addActionListener(e -> game.startGame());
		stop = new JButton("Stop");
		stop.addActionListener(e -> game.stopGame());
		stop.setEnabled(false);
		bottom.add(start);
		bottom.add(stop);

		this.add(statsPanel, BorderLayout.NORTH);
		this.add(columnPanel, BorderLayout.CENTER);
		this.add(bottom, BorderLayout.SOUTH);
		this.pack();
		this.setVisible(true);
	}

	public void startGame() {
		columnPanel.removeAll();
		columnPanel.setLayout(new GridLayout(game.getColTypes().size(), 3, 5, 5));
		
		for (ColumnType type : game.getColTypes()) {
			JLabel topicLabel = new JLabel(type.getTopic());
			JTextField field = new JTextField(10);
			JLabel statsLabel = new JLabel("0");
			rows.add(new Row(topicLabel, field, statsLabel));
			columnPanel.add(topicLabel);
			columnPanel.add(field);
			columnPanel.add(statsLabel);
		}

		columnPanel.updateUI();

		statsLabel2.setText(game.getSeconds() + "");
		statsLabel3.setText(game.getBuchstabe() + "");
		start.setEnabled(false);
		stop.setEnabled(true);
		
		this.pack();
	}

	public void stopGame() {
		start.setEnabled(true);
		stop.setEnabled(false);
		int points = rows.stream()
						.mapToInt(Row::getPoints)
						.sum();
		points += Integer.valueOf(statsLabel1.getText());
		statsLabel1.setText( Integer.toString(points) );
		rows.removeAll(rows);
	}
	
	public List<Row> getRows() {
		return rows;
	}
	
	public void setTime(int x) {
		statsLabel2.setText(Integer.toString(x));
	}
	
}
