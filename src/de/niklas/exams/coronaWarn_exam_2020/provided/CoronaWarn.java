package de.niklas.exams.coronaWarn_exam_2020.provided;

import java.io.*;
import java.nio.file.*;
import java.util.*;

import javax.swing.*;

import de.niklas.exams.coronaWarn_exam_2020.selfwritten.*;

/**
 * <strong>CoronaWarn</strong><br>
 * Vorgegebene Klasse für die Klausur
 * Erweiterung mit Aufgabe e und f um File IO
 *
 * @see "Teilaufgabe e, f"
 * @author Niklas Buse
 */
public class CoronaWarn {

    /**
     * Application entry point for CoronaWarn
     * @param args command line arguments, not used here
     */
    public static void main( String[] args ) {
        try {
            // Only necessary on MacOS to prevent color issues with standard look and feel.
            // Redundant on other operation systems - they use this look and feel by default.
            UIManager.setLookAndFeel(
                    UIManager.getCrossPlatformLookAndFeelClassName() );
        } catch ( final Exception e ) {}

        JPhone phone1 = new JPhone( "0123-4567", "Markus" );
        JPhone phone2 = new JPhone( "9876-5432", "Angela" );
        JPhone phone3 = new JPhone( "4711-0815", "Olaf" );

        CoronaWarnTerm client1 = new CoronaWarnTerm( phone1 );
        CoronaWarnTerm client2 = new CoronaWarnTerm( phone2 );
        CoronaWarnTerm client3 = new CoronaWarnTerm( phone3 );

        CoronaWarnAPI.registerClients( client1, client2, client3 );
    }

    /**
     * Clear token store for phone
     *
     * @param phone phone to clear store for
     */
    public static void clearTokenStore( JPhone phone ) {
        // ADD CODE HERE
        System.out.println( "Clear token store" );
        try {
            Files.writeString(Paths.get(String.format("%s-tokens.txt", phone.getId())), "");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    /**
     * Load tokens for phone
     * überarbeitet in Aufgabe f
     * @param phone phone to load tokens for
     * @return loaded tokens
     */
    public static List<Token> loadTokens( JPhone phone ) {
        List<Token> tokens = new LinkedList<>();

        Path p = Paths.get(String.format("FileExperiments/%s-tokens.txt", phone.getId()));
        try {
            Files.readAllLines(p) // als Stream weiterverarbeiten
                    .forEach(line -> tokens.add(parseToken(line))); // Jede Zeile wird in ein Token Objekt umgewandelt
        } catch (NumberFormatException | IOException ex) {
            System.err.printf("Read error: %s%n", ex.getLocalizedMessage());
        }

        return tokens;
    }

    /**
     * Save token for provided phone
     * überarbeitet in Aufgabe e
     *
     * @param phone phone to save token for
     * @param token token to save
     */
    public static void saveToken(JPhone phone, Token token) {
        String line = token.getValue() + ";" + token.getDate().getTime();
        try {
            // Hier wird der neue Token in der Datei unten angehängt (Parameter StandardOpenOption.APPEND)
            // Die Datei wird automatisch erstellt, wenn nicht bereits geschehen (StandardOpenOption.CREATE)
            Files.writeString(Paths.get(String.format("FileExperiments/%s-tokens.txt", phone.getId())), line + System.lineSeparator(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        File f = new File(String.format("%s-tokens.txt", phone.getId()));
    }

    /**
     * Parse a token line
     *
     * @param line token line to parse
     * @return parsed token instance
     */
    private static Token parseToken( String line ) {
        String[] parts = line.split( "[;]" );
        if ( parts.length == 2 ) {
            try {
                return new Token(parts[0], new Date( Long.parseLong(parts[1])));
            } catch (Exception e) {
                System.err.println("Error parsing token line: " + line);
                e.printStackTrace();
            }
        }
        return null;
    }
}