package de.niklas.exams.fasid_extra_exam_2022.provided;

import java.awt.Color;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class FasidAlarmLabel extends JLabel {

	private Timer blinkTimer;
	private boolean cancelIfNotDisplayable = false;
	
	public FasidAlarmLabel() {
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setFont(this.getFont().deriveFont(Font.BOLD, 18f));
		this.setOpaque(true);
		this.setDoubleBuffered( true );
	}
	
	public void setFasidAlarm(String name) {
		this.clearAlarmTimer();
		this.setText("!!! Fasid alarm by player " + name + " !!!");
		this.startAlarm();
	}
	

	public void hideFasidAlam() {
		this.clearAlarmTimer();
	}
	
	private void clearAlarmTimer() {
		if ( this.blinkTimer != null ) {
			this.blinkTimer.cancel();
		}
		this.setBackground( null );
		this.setText("");
		this.setBorder( null );
	}
	
	private void startAlarm() {
		this.blinkTimer = new Timer(true);
		this.cancelIfNotDisplayable = false;
		
		TimerTask blinkTask = new TimerTask() {
			boolean redBg = false;
			@Override
			public void run() {
				if ( FasidAlarmLabel.this.isDisplayable() ) {
					FasidAlarmLabel.this.cancelIfNotDisplayable = true;
				}
				else if (FasidAlarmLabel.this.cancelIfNotDisplayable) {
					FasidAlarmLabel.this.clearAlarmTimer();
					return;
				}
				
				if ( this.redBg ) {
					FasidAlarmLabel.this.setForeground(Color.RED);
					FasidAlarmLabel.this.setBackground(Color.WHITE);
					FasidAlarmLabel.this.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
				} else {
					FasidAlarmLabel.this.setForeground(Color.WHITE);
					FasidAlarmLabel.this.setBackground(Color.RED);
					FasidAlarmLabel.this.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
				}
				this.redBg = !this.redBg;
			}
		};
		this.blinkTimer.scheduleAtFixedRate(blinkTask, 0, 200);
	}
}