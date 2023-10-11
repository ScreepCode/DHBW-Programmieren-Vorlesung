package de.niklas.exams.snatchat_mock_exam;

public class Message {
	
	private String text;
	private Account sender;
	
	public Message(String text, Account sender) {
		this.text = text;
		this.sender = sender;
	}

	public String getText() {
		return text;
	}


	public Account getSender() {
		return sender;
	}

	
	public static String rot13(String message) {
	      char[] textArray = message.toCharArray();

	      for (int i = 0; i < textArray.length; i++) {
	         char ch = textArray[i];
	         if (ch >= 'A' && ch <= 'M' || ch >= 'a' && ch <= 'm') {
	            ch += 13;
	         }
			 else if (ch >= 'N' && ch <= 'Z' || ch >= 'n' && ch <= 'z') {
	            ch -= 13;
	         }
	         textArray[i] = ch;
	      }
	      return new String(textArray);
	}

}
