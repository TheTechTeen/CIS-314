import java.awt.*;
import java.util.Formatter;
import javax.swing.*;

// Extends JPanel, overrides the paintComponent().
public class BouncyBall extends JPanel // change the name to BouncyBall -- it's funner
{
    // Container box's width and height
    private static final int BOX_WIDTH = 640;
    private static final int BOX_HEIGHT = 480;
    // Ball's properties
    private float ballRadius = 50; // Ball's radius
    private float ballX = BOX_WIDTH / 2; // Ball's center (x, y)
    private float ballY = BOX_HEIGHT/ 2;
    private float ballSpeedX = 2; // Ball's speed for x and y
    private float ballSpeedY = 2;

    private static final int UPDATE_RATE = 30; // Number of refresh per second

    private Color ballColor = Color.RED;

    // Constructor to create the graphic components and initialize game objects.
    public BouncyBall()
    {
        this.setPreferredSize(new Dimension(BOX_WIDTH, BOX_HEIGHT));// Start the ball bouncing (in its own thread)
        Thread gameThread = new Thread()
        {
            // here's the run method that the Thread provides
            // that must be overwritten
            public void run()
            {
                while (true)// occasionally an infinite loop is appropriate
                {
                    // Execute one update step
                    // Calculate the ball's new position
                    ballX += ballSpeedX;
                    ballY += ballSpeedY;
                    ballSpeedY += 0.5;
                    // Check if the ball moves over the bounds
                    // If so, adjust the position and speed.
                    if (ballX - ballRadius < 0)
                    {
                        ballSpeedX = -ballSpeedX; // Reflect along normal
                        ballX = ballRadius; // Re-position the ball at the edge
                        ballSpeedY *= (float) 0.5;
                    }
                    else if (ballX + ballRadius > BOX_WIDTH)
                    {
                        ballSpeedX = -ballSpeedX;
                        ballX = BOX_WIDTH - ballRadius;
                        ballSpeedY *= (float) 0.5;
                    }
                    // May cross both x and y bounds
                    if (ballY - ballRadius < 0)
                    {
                        ballSpeedY = -ballSpeedY * (float) 0.1;
                        ballY = ballRadius;
                    }
                    else if (ballY + ballRadius > BOX_HEIGHT)
                    {
                        ballSpeedY = -ballSpeedY * (float) 1.1;
                        ballY = BOX_HEIGHT - ballRadius;
                    }
                    // Refresh the display
                    repaint(); // Call paintComponent()
                    // Delay for timing control and give other threads a chance
                    try
                    {
                        Thread.sleep(1000 / UPDATE_RATE); // milliseconds
                    }
                    catch (InterruptedException ex) { }
                }
            }
        };
        gameThread.start();
        // Call run()
    }
    // Custom rendering codes for drawing the JPanel
    @Override // the paintComponents method
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        // Paint background// Draw the box
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, BOX_WIDTH, BOX_HEIGHT);
        // Draw the ball
        g.setColor(ballColor);
        g.fillOval((int) (ballX - ballRadius), (int) (ballY - ballRadius),
        (int)(2 * ballRadius), (int)(2 * ballRadius));
        // Display the ball's information
        g.setColor(Color.WHITE);
        g.setFont(new Font("Courier New", Font.PLAIN, 12));
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);
        formatter.format("Ball @(%3.0f,%3.0f) Speed=(%2.0f,%2.0f)", ballX,
        ballY, ballSpeedX, ballSpeedY);
        g.drawString(sb.toString(), 20, 30);
    }
    // main method
    public static void main(String[] args)
    {
        // Run GUI in the Event Dispatcher Thread (EDT) instead of main thread.
        javax.swing.SwingUtilities.invokeLater(new Runnable()
        {
            // another run method to override
            public void run()
            {
                // Set up main window (using Swing's Jframe)
                JFrame frame = new JFrame("A Bouncing Ball");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(new BouncyBall());
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}