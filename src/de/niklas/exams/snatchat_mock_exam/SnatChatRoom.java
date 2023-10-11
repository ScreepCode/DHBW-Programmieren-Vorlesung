package de.niklas.exams.snatchat_mock_exam;

import javax.swing.*;
import java.nio.file.*;
import java.io.*;
import java.util.*;

public class SnatChatRoom {

	private String roomName;
	private List<SnatChatFrontend> clients = new ArrayList<>();

	public SnatChatRoom(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomName() {
		return roomName;
	}

	public void register(SnatChatFrontend s) {
		this.clients.add(s);

		ArrayList<String> lines = new ArrayList<>();
		String filename = String.format("%s.txt", this.roomName);
		try {
			lines.addAll(Files.readAllLines(Paths.get(filename))); // z.B.
		} catch (NumberFormatException | IOException ex) {
		    System.err.printf("Read error: %s%n", ex.getLocalizedMessage());
		}
		int lastMessageCount = Math.max(0, lines.size()-11);
		for (int i = lastMessageCount; i < lines.size(); i++) {
			s.receiveMessage(Message.rot13(lines.get(i)));
		}
	}

	public void unregister(SnatChatFrontend s) {
		clients.remove(s);
	}

	public void sendMessage(Message msg) {
		for(SnatChatFrontend client : clients) {
			client.receiveMessage(msg);
		}
		this.writeLog(String.format("%s : %s", msg.getSender().getName(), msg.getText()));
	}

	public void sendMessage(String text) {
		for(SnatChatFrontend client : clients) {
			client.receiveMessage(text);
		}
		this.writeLog(text);
	}
	
	private void writeLog(String text) {
		String filename = String.format("%s.txt", this.roomName);

		try {
		    Files.writeString(Paths.get(filename), Message.rot13(text) + System.lineSeparator(),
		        StandardOpenOption.APPEND,
		        StandardOpenOption.CREATE
		    );
		} catch (IOException ex) {
		    JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}

}
