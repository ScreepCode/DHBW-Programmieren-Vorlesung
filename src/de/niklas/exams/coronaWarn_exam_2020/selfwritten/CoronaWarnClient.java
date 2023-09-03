package de.niklas.exams.coronaWarn_exam_2020.selfwritten;

import java.util.List;

/**
 * <strong>CoronaWarnClient</strong><br>
 * Implementation des CoronaWarnClient Interfaces
 *
 * @see "Teilaufgabe b"
 * @author Niklas Buse
 */
public interface CoronaWarnClient {

    public Token getCurrentToken();
    public List<Token> getAllTokens();
    public List<Token> getAllSeenTokens();
    public void tokenReceived(Token token);
}
