
// testing LabelFrame

import javax.swing.JFrame;

public class LabelTest
{
	public static void main(String[] args)
	{
		LabelFrame labelFrame = new LabelFrame();
		labelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		labelFrame.setSize(260, 180);
		labelFrame.setLocationRelativeTo(null);  // sets the location of the object in the center of the screen
		labelFrame.setVisible(true);
	}
}
