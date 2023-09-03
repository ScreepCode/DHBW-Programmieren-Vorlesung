package de.niklas.exams.dart_mock_exam_2023;

/**
 * <strong>DartsCounter</strong><br>
 * Startdatei, die zum Ausführen vorgegeben wurde.
 *
 * @see "Download"
 * @author Aufgabe
 */
public class DartsCounter {

    public static void main( String[] args ) {

        final Board b = new Board();

        final Player[] players = new Player[] {
                new Player( "Michael van Gerwen" ),
                new Player( "Rob Cross" )
        };

        final Game g = new Game(b, players);
        g.start();

    }

}

// Fertig programmiert: 9.26
// Programm läuft: 9.41
// Final: 9.43
