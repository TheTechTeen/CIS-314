/* 
 * CIS 314, Spring 2021
 * Author: Aiden Dow
 * Date: 3/23/2021
 * Assignment: Robots!
 * Comments: 
*/

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Robots extends JFrame 
{
    // class variables
    private final char HUMAN = 'H';
    private final char DEAD_HUMAN = '#';
    private final char ROBOT = 'R';
    private final char JUNK = '*';
    private final char DOOR = 'D';
    private final char FENCE = 'X';
    private final char FLOOR = ' ';

    // I prefer to use named constants to reference the numbers for the directions (ETC)
    private final int UP = 1;
    private final int DOWN = 2;
    private final int LEFT = 3;
    private final int RIGHT = 4;

    private final int doorX = 0; 
    private final int doorY = 5;
    private final int numRows = 12; 
    private final int numCols = 12;
    private int resultsAreaWidth = 28;
    private int resultsAreaHeight = 3;

    private JPanel buttonPanel;
    private JButton buttonUp; 
    private JButton buttonDown; 
    private JButton buttonLeft; 
    private JButton buttonRight; 
    private JButton buttonStart; 

    private String boardString = "";

    private JTextArea boardArea; 
    private JTextArea resultsArea;
    private JTextField currentScoreField;

    private int level;
    private int score;
    private int robotCount;

    private int humanX; 
    private int humanY;
    private boolean alive;  
    private double moveFactor;

    private int robotsX[]; 
    private int robotsY[]; 
    private boolean robotsAlive[];

    private char board[][];

    // constuctor
    public Robots() 
    {
        super("RoboChase!");
        setLayout(new FlowLayout());

        boardArea = new JTextArea();
        boardArea.setRows(numRows);
        boardArea.setColumns(numCols);
        boardArea.setFont(new Font("monospaced", Font.PLAIN, 12));
        boardArea.setEditable(false);
        boardArea.setAlignmentX(SwingConstants.CENTER);
        add(boardArea);

        ButtonHandler handler = new ButtonHandler();
        buttonStart = new JButton("Start");
        buttonStart.addActionListener(handler);
        buttonLeft = new JButton("Left");
        buttonLeft.addActionListener(handler);
        buttonUp = new JButton("Up");
        buttonUp.addActionListener(handler);
        buttonDown = new JButton("Down");
        buttonDown.addActionListener(handler);
        buttonRight = new JButton("Right");
        buttonRight.addActionListener(handler);

        buttonPanel = new JPanel();
        buttonPanel.add(buttonStart);
        buttonPanel.add(buttonLeft);
        buttonPanel.add(buttonUp);
        buttonPanel.add(buttonDown);
        buttonPanel.add(buttonRight);
        add(buttonPanel);

        resultsArea = new JTextArea();
        resultsArea.setColumns(resultsAreaWidth);
        resultsArea.setRows(resultsAreaHeight);
        add(resultsArea);

        currentScoreField = new JTextField("No Current Game", 28);
        currentScoreField.setEditable(false);
        add(currentScoreField);
    }

    // methods
    public void initializeBoard(char board[][])
    {
        // set up the board with the fence and door
        board = new char[numRows][numCols];
        for (int y = 0; y < numRows; y++) 
        {
            for (int x = 0; x < numCols; x++) 
            {
                if (x == doorX && y == doorY)
                {
                    board[y][x] = DOOR;
                }
                else if (x == 0 || x == numCols - 1 || y == 0 || y == numRows - 1)
                {
                    board[y][x] = FENCE;
                }
                else
                {
                    board[y][x] = FLOOR;
                }
            }
        }
        this.board = board;
    }

    public void displayBoard(char board[][])
    {
        // display the board to boardArea
        boardString = "";
        for (int y = 0; y < numRows; y++) 
        {
            if (y != 0)
            {
                boardString += "\n";
            }

            for (int x = 0; x < numCols; x++) 
            {
                boardString += board[y][x];
            }
        }
        boardArea.setText(boardString);
    }

    public void placeHuman(char board[][])
    {
        // Place the human on an empty board space
        alive = true;
        do 
        {
            humanX = (int) 1 + (int)(Math.random() * ((numCols - 2) + 1));
            humanY = (int) 1 + (int)(Math.random() * ((numRows - 2) + 1));
        } while (board[humanY][humanX] != FLOOR);
        board[humanY][humanX] = HUMAN;
    }

    public void placeRobots(int robotCount, int robotsX[], int robotsY[], boolean robotsAlive[], char board[][])
    {
        // Place the correct number of robots on empty spaces
        robotsX = new int[robotCount];
        robotsY = new int[robotCount];
        robotsAlive = new boolean[robotCount];

        for (int i = 0; i < robotCount; i++) 
        {
            do 
            {
                robotsX[i] = (int) 1 + (int)(Math.random() * ((numCols - 2) + 1));
                robotsY[i] = (int) 1 + (int)(Math.random() * ((numRows - 2) + 1));
                robotsAlive[i] = true;
            } while (board[robotsY[i]][robotsX[i]] != FLOOR);
            board[robotsY[i]][robotsX[i]] = ROBOT;
        }
        
        this.robotsX = robotsX;
        this.robotsY = robotsY;
        this.robotsAlive = robotsAlive;
    }

    public Boolean analyze(int humanX, int humanY, int robotsX[], int robotsY[], boolean robotsAlive[], char board[][]) 
    {
        // Determine whether the player is alive
        for (int i = 0; i < robotCount; i++) 
        {
            alive = alive && (humanX != robotsX[i] || humanY != robotsY[i] || !robotsAlive[i]); 
        }
        alive = alive && ((humanX != 0 && humanX != numCols - 1 && humanY != 0 && humanY != numRows - 1) || (humanX == doorX && humanY == doorY));
        return alive;
    }

    public Boolean winLevel()
    {
        // determine whether the player has won the level
        return humanX == doorX && humanY == doorY;
    }
    
    public void moveHuman(int direction, char board[][])
    {
        // Moves the human a certain direction
        if (alive)
        {
            board[humanY][humanX] = FLOOR;
            if (direction == UP)
            {
                humanY--;
            }
            else if (direction == DOWN)
            {
                humanY++;
            }
            else if (direction == LEFT)
            {
                humanX--;
            }
            else if (direction == RIGHT)
            {
                humanX++;
            }
            board[humanY][humanX] = HUMAN;
        }
    }

    public int deadRobots(int robotCount, boolean robotsAlive[])
    {
        // count the number of dead robots
        int deadRobotCount = 0;
        for (int i = 0; i < robotCount; i++)
        {
            if(!robotsAlive[i])
            {
                deadRobotCount++;
            }
        }
        return deadRobotCount;
    }

    public void moveRobots(int humanX, int humanY, int robotCount, int robotsX[], int robotsY[], boolean robotsAlive[], char board [][], double moveFactor)
    {
        // move the robots. They always move directly toward the player.
        for (int i = 0; i < robotCount; i++) 
        {
            if (Math.random() <= moveFactor && robotsAlive[i])
            {
                board[robotsY[i]][robotsX[i]] = FLOOR;
                if (humanX < robotsX[i])
                {
                    robotsX[i]--;
                }
                else if (humanX > robotsX[i])
                {
                    robotsX[i]++;
                }
                if (humanY < robotsY[i])
                {
                    robotsY[i]--;
                }
                else if (humanY > robotsY[i])
                {
                    robotsY[i]++;
                }
                board[robotsY[i]][robotsX[i]] = ROBOT;
            }
        }
        for (int i = 0; i < robotCount; i++) 
        {
            for (int j = 0; j < robotCount; j++) 
            {
                if (i != j && robotsX[i] == robotsX[j] && robotsY[i] == robotsY[j])
                {
                    robotsAlive[i] = false;
                    robotsAlive[j] = false;
                    board[robotsY[i]][robotsX[i]] = JUNK;
                }
            }
        }
    }

    // my added methods
    public void startLevel(boolean newGame)
    {
        // start a new level, either level 1 (newgame) or the next level
        // also handles the variables that change over the course of the levels
        if (newGame)
        {
            level = 1;
            robotCount = 4;
            moveFactor = 0.1;
            score = 0;
        }
        else
        {
            level++;
            robotCount++;
            moveFactor += 0.02;
        }
        displayScore();
        initializeBoard(board);
        placeRobots(robotCount, robotsX, robotsY, robotsAlive, board);
        placeHuman(board);
    }

    public void worldRespond()
    {
        // after the player has moved, make the world respond by moving the robots and handling whether the player won or died.
        moveRobots(humanX, humanY, robotCount, robotsX, robotsY, robotsAlive, board, moveFactor);
        alive = analyze(humanX, humanY, robotsX, robotsY, robotsAlive, board);
        if (winLevel())
        {
            incrementScore();
            resultsArea.setText("You make it out the door - only to be \nconfronted by another room full of robots.");
            startLevel(false);
        }
        else if (!alive)
        {
            board[humanY][humanX] = DEAD_HUMAN;
            resultsArea.setText("You died! try again");
        }
    }

    public void incrementScore()
    {
        score += 100 * (level +1);
        score += deadRobots(robotCount, robotsAlive);
    }

    public void displayScore()
    {
        currentScoreField.setText(String.format("Level %d: %d points", level, score));
    }

    // event handler
    private class ButtonHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            if (alive)
            {
                if (event.getSource() == buttonUp)
                {
                    moveHuman(UP, board);
                    worldRespond();
                }
                else if (event.getSource() == buttonDown)
                {
                    moveHuman(DOWN, board);
                    worldRespond();
                }
                else if (event.getSource() == buttonLeft)
                {
                    moveHuman(LEFT, board);
                    worldRespond();
                }
                else if (event.getSource() == buttonRight)
                {
                    moveHuman(RIGHT, board);
                    worldRespond();
                }
            }
            else if (event.getSource() == buttonStart)
            {
                startLevel(true);
            }
            displayBoard(board);
        }
    }

    // main method
    public static void main(String[] args) 
    {
        Robots robotFrame = new Robots(); // create ButtonFrame
        robotFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        robotFrame.setSize(350, 400); // set frame size
        robotFrame.setVisible(true); // display frame
        robotFrame.setLocationRelativeTo(null);
    }
}
