
// practicing with Java AWT and Swing graphics
// the event dispatch thread (see below) is the thread of control
// that passes mouse clicks and keystrokes to the user interface components

import java.awt.*;
import javax.swing.*;

public class SimpleFrameTest
{
	public static void main(String[] args)
	{
		// creates a new SimpleFrame object
		// -> is a lambda operator
		// parameters on the left, implementation on the right
		// A lambda expression is a short block of code which takes in parameters and returns a value.
		// Lambda expressions are similar to methods, but they do not need a name and they can be implemented in the body of a method.

		// All Swing components must be implemented from the event dispatch thread
		// this expression executes statements in the event dispatch thread

		// this can also be done from the main method of an application with the class
		// or from the main method of a separate application. We will see examples of both code solutions
		EventQueue.invokeLater(()->
		{
			var frame = new SimpleFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			frame.setLocation(250, 250);
			frame.setTitle("This is a title");
		});
	}// end of main method
} // end of SimpleFrameTest class

// defines the SimpleFrame class, a subclass of JFrame
class SimpleFrame extends JFrame
{
	// fields, declared private, static, and final
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 300;

	// constructor
	public SimpleFrame()
	{
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
}
