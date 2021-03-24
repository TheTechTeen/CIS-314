
// practicing with Java AWT and Swing graphics components

import java.awt.*;
import javax.swing.*;

public class NotHelloWorld
{
	// the main method starts the whole cascade running
	public static void main(String[] args)
	{
		// EventQueue is a Java AWT class
		// builds the JFrame object
		// runs when called
		EventQueue.invokeLater(()->
		{
			var frame = new NotHelloWorldFrame();  // creates a new object of the NotHelloWorldFrame class
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			frame.setLocation(250, 250);
			frame.setTitle("Not Hello World");
		});
	}// end of the main method
}// end of NotHelloWorld class

// a frame that contains a message panel
// inheritance makes this class a sub class of JFrame
class NotHelloWorldFrame extends JFrame
{
	// constructor
	public NotHelloWorldFrame()
	{
		add(new NotHelloWorldComponent());  // creates a new NotHelloWorldComponent to fill the frame
		pack();  // the component will fill the frame
	}
}

// a component that is placed inside the frame and displays a message
// inheritance makes this a class of JComponent
class NotHelloWorldComponent extends JComponent
{
	public final static int MESSAGE_X = 75;
	public final static int MESSAGE_Y = 100;

	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;

	public void paintComponent(Graphics g)
	{
		g.drawString("Not a hello world program", MESSAGE_X, MESSAGE_Y);
	}

	public Dimension getPreferredSize()
	{
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
}
