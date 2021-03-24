
// event handling and nested classes
// demonstrating a private inner class

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

// TextFieldFrame is a subclass of JFrame
public class TextFieldFrame extends JFrame
{
	private final JTextField textField1; // a text field with a set size
	private final JTextField textField2; // text field with text
	private final JTextField textField3; // text field with text and size
	private final JPasswordField passwordField; // a password field with text

	// TextFieldFrame constructor adds JTextField to JFrame
	public TextFieldFrame()
	{
		super("Testing JTextField and JPasswordField");
		setLayout(new FlowLayout());

		// construct JTextField with 10 columns
		textField1 = new JTextField(10);
		add(textField1);

		// construct JTextField with default text
		textField2 = new JTextField("Enter text here");
		add(textField2);

		// construct JTextField with default text and 21 columns
		textField3 = new JTextField("Uneditable text field", 21);
		textField3.setEditable(false);
		add(textField3);

		// construct JPasswordField with default text
		passwordField = new JPasswordField("Hidden Text");
		add(passwordField);

		// Instantiate TextField Handler (private inner class defined below)
		TextFieldHandler handler = new TextFieldHandler();

		// register event handlers
		textField1.addActionListener(handler);
		textField2.addActionListener(handler);
		textField3.addActionListener(handler);
		passwordField.addActionListener(handler);
	} // end of constructor

	// private inner class for event handling
	// implements the ActionListener interface
	private class TextFieldHandler implements ActionListener
	{
		// an implemented interface must have all of its methods overridden
		// ActionListener only has one method - actionPerformed
		@Override
		public void actionPerformed(ActionEvent event)
		{
			String string = "";

			// the body of the actionPerformed method will define what actions
			// the event handler will implement

			// user pressed Enter in JTextField textField1
			if(event.getSource() == textField1)
				string = String.format("textfield1: %s", event.getActionCommand());

			// user pressed enter in JTextField textField2
			else if(event.getSource() == textField2)
				string = String.format("textField2: %s", event.getActionCommand());

			// user pressed enter in JTextField textField3
			else if(event.getSource() == textField3)
				string = String.format("textField3: %s", event.getActionCommand());

			// user pressed Enter in JTextField passwordField
			else if(event.getSource() == passwordField)
				string = String.format("passwordField: %s", event.getActionCommand());

			// display JTextField content
			JOptionPane.showMessageDialog(null, string);

		}// end of actionPerformed method

	}// end of private inner class TextField Handler

} // end of class TextFieldFrame
