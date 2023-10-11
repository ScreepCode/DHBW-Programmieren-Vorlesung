package de.niklas.exams.snatchat_mock_exam;

public interface SnatChatFrontend {

	void receiveMessage(Message msg);
	void receiveMessage(String text);
	Account getAccount();
}
