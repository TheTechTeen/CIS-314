// CIS 314
// works with ButtonTestListener3.java

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

// implements ActionListener means that the entire class is an ActionListener
// notice that in this example, the actionPerformed method is overridden twice
// once in the ButtonFrame class, and once in the private inner class
public class ButtonFrame extends JFrame implements ActionListener
{
   private JButton button1, button2, button3;
   private JLabel myLabel;
   private JTextField myField;

   public ButtonFrame()
   {
      super( "Testing Buttons 3 Listeners" );
      setLayout( new FlowLayout() ); // set frame layout

      myLabel = new JLabel("my Label");
      myField = new JTextField(10);
      myField.setEditable(true);
      add(myLabel);
	  add(myField);

      button1 = new JButton( "Button 1" ); // button with text
      add( button1 ); // add Button to JFrame
      button2 = new JButton( "Button 2" ); // button with text
      add( button2 ); // add Button to JFrame
      button3 = new JButton( "Button 3" ); // button with text
      add( button3 ); // add Button to JFrame

	  // create an instance of the private inner class ButtonHandler
	  // ButtonHandler implements ActionListener
      ButtonHandler handler = new ButtonHandler();

	  // demonstrating three ways of linking an ActionListener to a graphic object
	  button1.addActionListener( handler );  // using the private inner class action listener
      button2.addActionListener( this );  // Using the ButtonFrame class action listener
      button3.addActionListener(
		new ActionListener() // using an anonymous inner class action listener - notice that this inner class has no name
           {
            public void actionPerformed( ActionEvent event )
            {
              myField.setText("Button Three");
            } // end method actionPerformed
           } // end anonymous inner class
		  );  // be sure to pair up the parenthesis and curly brackets correctly. Notice the final semi colon here.
   } // end ButtonFrame constructor

  // overriding the actionPerformed method that belongs to the ButtonFrame class (because the class implements ActionListener)
  public void actionPerformed(ActionEvent e)
    {
       myField.setText("Button Two");
    } // end of actionPerformed


  // the private inner class that implements ActionListener
  private class ButtonHandler implements ActionListener
   {
	   // overriding the actionPerformed method in the private inner class
      // handle button1 event
      public void actionPerformed( ActionEvent event )
      {
         myField.setText("Button One!");
      } // end method actionPerformed
   } // end private inner class ButtonHandler
} // end class ButtonFrame
