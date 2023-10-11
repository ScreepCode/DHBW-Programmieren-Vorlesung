package de.niklas.exams.snatchat_mock_exam;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SnatChatWindow extends JFrame implements SnatChatFrontend {

	private SnatChatRoom room;
	private Account account;
	private ChatMessagesComponent chatMessagesComponent = new ChatMessagesComponent();
	private JTextField inputField;
	
	public SnatChatWindow(SnatChatRoom room, Account account) {
		this.room = room;
		this.account = account;

		this.setTitle(String.format("%s (%s)", account.getName(), room.getRoomName()));
		
		JLabel accountLabel = new JLabel(account.getName(), JLabel.CENTER);
		accountLabel.setForeground(account.getColor());

		
		JPanel statePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		ButtonGroup buttonGroup = new ButtonGroup();
		for (State state : State.values()) {
			JRadioButton button = new JRadioButton(state.getLabel());
			if (state == State.AVAILABLE) {
				button.setSelected(true);
			}
			buttonGroup.add(button);
			statePanel.add(button);

			button.addActionListener(e -> updateState(state));
		}
		
		JPanel centerPanel = new JPanel(new BorderLayout());
		centerPanel.add(chatMessagesComponent, BorderLayout.CENTER);
		centerPanel.add(statePanel, BorderLayout.SOUTH);
	
		JPanel inputPanel = new JPanel(new BorderLayout());
		inputField = new JTextField();
		JButton sendButton = new JButton("Send");
		sendButton.addActionListener(e -> sendMessage(sendButton));
		inputField.addActionListener(e -> sendMessage(sendButton));

		inputPanel.add(inputField, BorderLayout.CENTER);
		inputPanel.add(sendButton, BorderLayout.EAST);

		this.add(accountLabel, BorderLayout.NORTH);
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(inputPanel, BorderLayout.SOUTH);
		// this.pack();
		this.setSize(500,300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	private void updateState(State newState){
		account.setState(newState);
		room.sendMessage(String.format("State of user '%s' is now %s", account.getName(), newState.getLabel()));
	}

	private void sendMessage(JButton actionButton){
		String message = inputField.getText();

		if (message.isEmpty()) {
			JOptionPane.showMessageDialog(actionButton, String.format("Dear %s, please enter a message", account.getName()));
		}
		else {
			Message msg = new Message(message, account);
			room.sendMessage(msg);
		}
		inputField.setText("");
	}

	@Override
	public void receiveMessage(String text) {
		JLabel label = new JLabel(text);
		label.setForeground(Color.GRAY);

		this.receiveMessage(label);
	}

	@Override
	public void receiveMessage(Message msg) {
		JLabel label = new JLabel(msg.getSender().getName() + ": " + msg.getText());
		label.setForeground(msg.getSender().getColor());

		this.receiveMessage(label);
	}
	
	private void receiveMessage(JLabel label) {
		this.chatMessagesComponent.add(label);
		
		Runnable countdown = () -> {
            int duration = 30;
            String origText = label.getText();
            for (int i = duration; i > 0; i--) {
                label.setText(String.format("%s [%d]", origText, i));
                try {
                    Thread.sleep(1000);
                }
				catch (InterruptedException e) {

                }
            }
            chatMessagesComponent.remove(label);
        };
		
		new Thread(countdown).start();
	}

	@Override
	public Account getAccount() {
		return account;
	}

}
