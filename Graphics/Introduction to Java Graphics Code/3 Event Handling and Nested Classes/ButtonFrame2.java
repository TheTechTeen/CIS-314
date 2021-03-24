
// basic event handling
// button clicks
// notice that the main method is part of the ButtonFrame2 class, not a separate application

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

// ButtonFrame2 inherits all of JFrame members - important
public class ButtonFrame2 extends JFrame
{
	// declaring class level variables, scope throughout the class
	private JPanel buttonPanel;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;

	// the constructor
	public ButtonFrame2()
	{
		// set the size of the JFrame
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		// create buttons
		JButton yellowButton = new JButton("Yellow");
		JButton blueButton = new JButton("Blue");
		JButton redButton = new JButton("Red");

		// create a panel to put the buttons into
		buttonPanel = new JPanel();

		// add buttons to panel
		buttonPanel.add(yellowButton);
		buttonPanel.add(blueButton);
		buttonPanel.add(redButton);

		// add the buttonPanel to the JFrame
		add(buttonPanel);

		// Event Handling Step 3 - instantiate objects of the action listener class
		// create button actions
		// colorAction is a private inner class - see below
		ColorAction yellowAction = new ColorAction(Color.YELLOW);  // colors are constants
		ColorAction blueAction = new ColorAction(Color.BLUE);
		ColorAction redAction = new ColorAction(Color.RED);

		// Event Handling Step 4
		// associate the actions with the buttons
		yellowButton.addActionListener(yellowAction);
		blueButton.addActionListener(blueAction);
		redButton.addActionListener(redAction);

	}// end of constructor

	// Event Handling Step 1
	// private inner class implements action listener, sets background color
	private class ColorAction implements ActionListener
	{
		// class variable for ColorAction
		private Color backgroundColor;

		// constructor
		// instantiates an object of the colorAction class
		// uses a color as a parameter
		public ColorAction(Color c)
		{
			backgroundColor = c;
		}

		// Event Handling Step 2
		// actionListener interface has only one method to override - actionPerformed()
		public void actionPerformed(ActionEvent e)
		{
			// setBackground is a method of JPanel
			buttonPanel.setBackground(backgroundColor);
		}
	} // end of private class ColorAction

	public static void main(String[] args)
	{
		ButtonFrame2 buttonFrame2 = new ButtonFrame2();
		buttonFrame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buttonFrame2.setLocationRelativeTo(null); // centers the GUI
		buttonFrame2.setVisible(true);
	} // end of main method

} // end of ButtonFrame2.class
