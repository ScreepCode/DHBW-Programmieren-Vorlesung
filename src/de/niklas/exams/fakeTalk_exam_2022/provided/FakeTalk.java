package de.niklas.exams.fakeTalk_exam_2022.provided;

import de.niklas.exams.fakeTalk_exam_2022.selfwritten.*;

import java.io.*;
import java.nio.file.*;
import java.util.LinkedList;
import java.util.List;

public class FakeTalk {

   public static void main( String[] args ) {
      List<Quote> quotes = FakeTalk.loadQuotes("src/de/niklas/exams/fakeTalk_exam_2022/provided/corona.csv");
      try {
         QuoteSelectionTerm selectionTerm = new QuoteSelectionTerm( quotes, 3, 4 );

         QuoteTerm t1 = new QuoteTerm( "Muenchhausen", selectionTerm );
         QuoteTerm t2 = new QuoteTerm( "Pinocchio", selectionTerm );
         selectionTerm.register( t1 );
         selectionTerm.register( t2 );

         selectionTerm.start();
      } catch ( FakeNewsException e ) {
         e.printStackTrace();
      }
   }

   private static List<Quote> loadQuotes( String filename ) {
      List<Quote> quotes = new LinkedList<>();

      try {
          Files.readAllLines(Paths.get(filename)) // als Stream weiterverarbeiten
                  .forEach(line -> quotes.add(parseQuote(line))); // z.B.
      } catch (NumberFormatException | IOException ex) {
          System.err.printf("Read error: %s%n", ex.getLocalizedMessage());
      }

      return quotes;
   }

   private static Quote parseQuote( String s ) {
      if ( s != null ) {
         String[] parts = s.trim().split( ";" );
         if ( parts.length == 6 || parts.length == 5 ) {
            return new Quote( parts[1], parts[2], parts[3], parts[4], Boolean.parseBoolean( parts[0] ) ? QuoteType.HOT_SHIT : QuoteType.BULLSHIT );
         }
      }
      return null;
   }

}
