package de.niklas.exams.fakeTalk_exam_2022.provided;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 * Component to display the quotes
 */
@SuppressWarnings( "serial" )
public class QuoteDisplay extends JScrollPane {

   private final JTextPane txt = new JTextPane();

   /**
    * Create the scroll pane that contains the text pane for display
    */
   public QuoteDisplay() {
      this.setViewportView( this.txt );
      this.setPreferredSize( new Dimension( 100, 100 ) );
      this.txt.setFont( this.getFont().deriveFont( 14f ) );
      this.txt.setEditable( false );
      this.txt.setMargin( new Insets( 20, 20, 20, 20 ) );
   }

   /**
    * Set the quote text.
    * 
    * It will automatically be centered horizontally.
    * 
    * @param text
    *           quote text to set
    */
   public void setText( String text ) {
      this.txt.setText( text );
      this.txt.setCaretPosition( 0 );
      StyledDocument doc = this.txt.getStyledDocument();
      SimpleAttributeSet center = new SimpleAttributeSet();
      StyleConstants.setAlignment( center, StyleConstants.ALIGN_CENTER );
      doc.setParagraphAttributes( 0, doc.getLength(), center, false );
   }
}
