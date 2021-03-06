/*
CIS 314, Spring 2021
Date: 4/12/2021
Author: Aiden Dow
Assignment: Bouncing Balls
Comments: I changed the color to red, made the ball so it can be clicked and dragged, and changed it so it only bounced up and down. I also changed the text formatting.
*/

import java.awt.*;
import java.awt.event.*;
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
    private float ballSpeedX = 0; // Ball's speed for x and y
    private float ballSpeedY = 2;

    private static final int UPDATE_RATE = 30; // Number of refresh per second

    private Color ballColor = Color.RED; // added a variable for color

    private Boolean clicked = false;

    // Constructor to create the graphic components and initialize game objects.
    public BouncyBall()
    {
        this.setPreferredSize(new Dimension(BOX_WIDTH, BOX_HEIGHT));// Start the ball bouncing (in its own thread)
        this.addMouseListener(new HeldDownMouseListener()); // listen for clicking and dragging the ball
        Thread gameThread = new Thread()
        {
            // here's the run method that the Thread provides
            // that must be overwritten
            @Override
            public void run()
            {
                while (true)// occasionally an infinite loop is appropriate
                {
                    if (!clicked)
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
                        }
                        else if (ballX + ballRadius > BOX_WIDTH)
                        {
                            ballSpeedX = -ballSpeedX;
                            ballX = BOX_WIDTH - ballRadius;
                        }
                        // May cross both x and y bounds
                        if (ballY - ballRadius < 0)
                        {
                            ballSpeedY = 0;
                            ballY = ballRadius;
                        }
                        else if (ballY + ballRadius > BOX_HEIGHT)
                        {
                            ballSpeedY = -ballSpeedY;
                            ballY = BOX_HEIGHT - ballRadius; // fyi this makes it bounce higher each time 
                        }
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
        g.setFont(new Font("Monospaced", Font.BOLD, 16));
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);
        formatter.format("Ball @(%4.0f,%4.0f) Speed=(%3.0f,%3.0f)", ballX,
        ballY, ballSpeedX, ballSpeedY);
        g.drawString(sb.toString(), 20, 30);
    }

    private class HeldDownMouseListener implements MouseListener {
        private float diffX;
        private float diffY;

        @Override
        public void mouseExited(MouseEvent arg0) {}

        @Override
        public void mouseEntered(MouseEvent arg0) {}

        @Override
        public void mouseClicked(MouseEvent arg0) {}

        @Override
        public void mousePressed(MouseEvent arg0) {
            diffX = arg0.getX() - ballX;
            diffY = arg0.getY() - ballY;
            if (Math.pow(diffX, 2) + Math.pow(diffY, 2) < Math.pow(ballRadius, 2))
            {
                // if the click is on the ball, stop it and lock it.
                ballSpeedX = 0;
                ballSpeedY = 0;
                clicked = true;
            }
        }

        @Override
        public void mouseReleased(MouseEvent arg0) {
            if (clicked)
            {
                // move the ball to the new position and resume updates
                ballX = arg0.getX() - diffX;
                ballY = arg0.getY() - diffY;
                clicked = false;
            }
        }

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