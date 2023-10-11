package de.niklas.exams.snatchat_mock_exam;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Bereitgestelltes Oberflaechenelement zur Anzeige der Chat-Nachrichten auf Basis einer beliebigen Komponente.
 * 
 * Einfach wie ein Panel benutzen:
 * <pre>
 * ChatMessagesComponent chats = new ChatMessagesComponent();
 * chats.add(...);
 * (...)
 * chats.remove(...);
 * </pre>
 */
@SuppressWarnings("serial")
public class ChatMessagesComponent extends JScrollPane {
	
	/**
	 * Anzahl der Nachtrichten
	 */
	private int messagesCount = 0;
	
	/**
	 * Panel, zu dem die Komponenten hinzugefuegt werden
	 */
	private JPanel messagesPanel = new JPanel(new GridBagLayout());
	
	/**
	 * Auffuellkomponente in Y-Richtung (damit Nachrichten oben stehen)
	 */
	private JPanel fillerY = new JPanel();
	
	/**
	 * Erstelle die Komponente fuer die Chat-Nachrichten
	 */
	public ChatMessagesComponent() {
		this.setViewportView(this.messagesPanel);
	}
	
	/**
	 * Fuege eine Komponente als Chat-Nachricht hinzu
	 * @param component Komponente zum hinzufuegen
	 */
	public void add( JComponent component ){
		this.messagesPanel.remove(this.fillerY);
		component.setBorder(BorderFactory.createEmptyBorder(1, 0, 1, 0));
		this.messagesPanel.add(component, new GridBagConstraints(0, this.messagesCount++, 1, 1, 1., 0., GridBagConstraints.BASELINE_LEADING, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
		this.messagesPanel.add(this.fillerY, new GridBagConstraints(0, this.messagesCount, 1, 1, 1., 1., GridBagConstraints.BASELINE_LEADING, GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
		this.messagesPanel.revalidate();
	}
	
	/**
	 * Entferne eine Komponente
	 * @param component Komponente die entfernt werden soll
	 */
	public void remove( JComponent component ){
		this.messagesPanel.remove(component);
		this.messagesPanel.revalidate();
		this.messagesPanel.repaint();
	}
	
}
