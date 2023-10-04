package de.niklas.exams.fasid_extra_exam_2022.provided;

import de.niklas.exams.fasid_extra_exam_2022.selfwritten.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

public class FasidWorldCup {


		public static void main( String[] args ) {
			List<Match> matches = FasidWorldCup.loadMatches( "src/de/niklas/exams/fasid_extra_exam_2022/provided/fasid-matches.csv" );

			Player[] players = new Player[] {
				new Player("Franz"),
				new Player("Lothar")
			};
			try {
				new FasidTerm(matches, players);
			} catch (FasidException fe) {
				JOptionPane.showMessageDialog(null, "Fehler: " + fe.getMessage());
			}
		}

		private static List<Match> loadMatches( String filename ) {
			List<Match> matches = new LinkedList<>();
			try {
			    Files.readAllLines(Paths.get(filename)) // als Stream weiterverarbeiten
			            .forEach(line -> matches.add(parseMatch(line))); // z.B.
			} catch (NumberFormatException | IOException ex) {
			    System.err.printf("Read error: %s%n", ex.getLocalizedMessage());
			}

			return matches;
		}

		private static Match parseMatch( String s ) {
			if ( s != null ) {
				String[] parts = s.trim().split( ";" );
				if ( parts.length == 6 ) {
					return new Match( parts[0], parts[1], parts[2], parts[3], parts[4], parts[5] );
				}
				if ( parts.length == 5 ) {
					return new Match( parts[0], parts[1], parts[2], parts[3], parts[4], null );
				}
			}
			return null;
		}
}
