// CIS 314
// works with ButtonFrame.java

import javax.swing.JFrame;

public class ButtonTestListener3
{
   public static void main( String[] args)
   {
      ButtonFrame buttonFrame = new ButtonFrame(); // create ButtonFrame
      buttonFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      buttonFrame.setSize( 275, 110 ); // set frame size
      buttonFrame.setVisible( true ); // display frame
      buttonFrame.setLocationRelativeTo(null);
   } // end main
} // end class ButtonTest
