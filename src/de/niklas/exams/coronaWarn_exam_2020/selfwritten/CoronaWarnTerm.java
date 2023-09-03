package de.niklas.exams.coronaWarn_exam_2020.selfwritten;

import de.niklas.exams.coronaWarn_exam_2020.provided.CoronaWarn;
import de.niklas.exams.coronaWarn_exam_2020.provided.CoronaWarnAPI;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * <strong>CoronaWarnTerm</strong><br>
 * Grafische Oberfläche der Warn-App
 * Implementiert CoronaWarnClient
 *
 * @see "Teilaufgabe c, d, g"
 * @author Niklas Buse
 */
public class CoronaWarnTerm implements CoronaWarnClient, Runnable{

    private JPhone jPhone;
    private Warnstatus warnstatus = Warnstatus.UNKNOWN;
    private List<Token> seenTokens = new ArrayList<>();
    private List<Token> ownTokens;
    private Token currentToken;


    private JFrame frame;
    private JLabel statusLabel, countLabel;
    private JButton new_token_button, check_button, clear_token_button, report_button;

    private Thread thread;

    public CoronaWarnTerm(JPhone jPhone){
        this.jPhone = jPhone;
        this.ownTokens = CoronaWarn.loadTokens(jPhone);
        this.currentToken = new Token();
        CoronaWarn.saveToken(jPhone, this.currentToken);
        CoronaWarnAPI.sendToken(this);

        JFrame frame = new JFrame(jPhone.getOwner());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel main_panel = new JPanel();
        main_panel.setLayout(new GridLayout(6, 1));

        statusLabel = new JLabel();
        statusLabel.setOpaque(true);
        statusLabel.setPreferredSize(new Dimension(0, 50));
        statusLabel.setHorizontalAlignment(JLabel.CENTER);
        setStatusLabel();

        main_panel.add(statusLabel);

        new_token_button = new JButton("New Token");
        new_token_button.addActionListener(e -> new_token());
        main_panel.add(new_token_button);

        check_button = new JButton("Check for infections");
        check_button.addActionListener(e -> check_infections());
        main_panel.add(check_button);

        clear_token_button = new JButton("Clear tokens");
        clear_token_button.addActionListener(e -> clear_tokens());
        main_panel.add(clear_token_button);

        report_button = new JButton("Report infection");
        report_button.addActionListener(e -> report_infection());
        main_panel.add(report_button);

        countLabel = new JLabel(String.format("Seen Tokens: %d", this.seenTokens.size()));
        countLabel.setToolTipText(this.currentToken.toString());
        main_panel.add(countLabel);

        frame.add(main_panel);
        frame.setSize(300, 400);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        new Thread(this).start();

        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    /**
     * Statuslabel Updaten
     */
    public void setStatusLabel(){
        statusLabel.setText(this.warnstatus.getText());
        statusLabel.setBackground(this.warnstatus.getColor());
    }

    /**
     * Generiere neuen Token and sende an API
     */
    public void new_token(){
        this.ownTokens.add(this.currentToken);
        CoronaWarn.saveToken(this.jPhone, this.currentToken);
        CoronaWarnAPI.sendToken(this);

        this.currentToken = new Token();
        this.countLabel.setToolTipText(this.currentToken.toString());
    }

    /**
     * API Call, ob eine Infektion möglich ist
     */
    public void check_infections(){
        if(CoronaWarnAPI.checkInfection(this)){
            this.warnstatus = Warnstatus.ALARM;
        }
        else{
            this.warnstatus = Warnstatus.OK;
        }
        setStatusLabel();
    }

    /**
     * Lösche alle Nutzerdaten und Token
     */
    public void clear_tokens(){
        this.ownTokens = new ArrayList<>();
        this.seenTokens = new ArrayList<>();
        this.countLabel.setText(String.format("Seen Tokens: %d", 0));
        CoronaWarn.clearTokenStore(this.jPhone);
        new_token();
    }

    /**
     * Melden einer Infektion und pausieren des Gerätes
     */
    public void report_infection(){
        CoronaWarnAPI.reportInfection(this);
        new_token_button.setEnabled(false);
        check_button.setEnabled(false);
        clear_token_button.setEnabled(false);
        report_button.setEnabled(false);

        this.warnstatus = Warnstatus.INFECTED;
        setStatusLabel();
    }

    @Override
    public Token getCurrentToken() {
        return this.currentToken;
    }

    @Override
    public List<Token> getAllTokens() {
        return this.ownTokens;
    }

    @Override
    public List<Token> getAllSeenTokens() {
        return this.seenTokens;
    }

    /**
     * Funktion, um Token von der API zu bekommen
     * @param token Token
     */
    @Override
    public void tokenReceived(Token token) {
        this.seenTokens.add(token);
        this.countLabel.setText(String.format("Seen Tokens: %d", this.seenTokens.size()));
    }

    /**
     * Thread, der sich um die Automatische Token Erneuerung kümmert
     */
    @Override
    public void run() {
//        Token Generierung
        while(this.warnstatus != Warnstatus.INFECTED){
            try {
                Thread.sleep(5000);
                new_token();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
