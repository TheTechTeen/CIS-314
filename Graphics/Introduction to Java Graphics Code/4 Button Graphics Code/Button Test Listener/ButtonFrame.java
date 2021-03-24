// CIS 314
// ButtonFrame.java - more on action listeners

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ButtonFrame extends JFrame
{
	private JButton plainJButton;
	private JButton fancyJButton;

	// constructor
	public ButtonFrame()
	{
		super( "Testing Buttons" );
		setLayout( new FlowLayout() );

		// add the JButtons to the ButtonFrame
		// add a button with text
		plainJButton = new JButton( "Plain Button" );
		add( plainJButton );

		// add a button with an image
		Icon bug1 = new ImageIcon( getClass().getResource( "bug1.gif" ));
		Icon bug2 = new ImageIcon( getClass().getResource( "bug2.gif" ));
		fancyJButton = new JButton( "Fancy Button", bug1 ); // set image
		fancyJButton.setRolloverIcon( bug2 ); // set rollover image
		add( fancyJButton );

		// create new buttonHandler for button event handling
		ButtonHandler handler = new ButtonHandler();

		// link the buttonHandler object to the buttons
		fancyJButton.addActionListener( handler );
		plainJButton.addActionListener( handler );

	}// end of the constructor

	// private inner class for button event handling
	private class ButtonHandler implements ActionListener
	{
		// handle button events - manditory override of actionPerformed method
		public void actionPerformed( ActionEvent event )
		{
			// ButtonFrame.this centers the dialog box over the application window
			// first argument not null, must use member select because of inner and outer classes
			// inner class not GUI
			JOptionPane.showMessageDialog( ButtonFrame.this, String.format( "You pressed: %s", event.getActionCommand()));
		} // end method actionPerformed

	}// end of inner class

}// end of class ButtonFrame
