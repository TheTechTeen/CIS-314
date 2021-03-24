/*
CIS 314, Spring 2021
Date: 2/16/2021
Author: Aiden Dow
Assignment: Idiot-proof calculator
Comments: 
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator
{
    private static Scanner input = new Scanner(System.in);

    private static String getOperand()
    {
        try
        {
            System.out.print("Add, subtract, multiply or divide? ");
            String operand = input.next();
            if (operand.equals("add") || operand.equals("subtract") || operand.equals("divide") || operand.equals("multiply"))
            {
                return operand;
            }
            else
            {
                System.out.println("That operation is not supported. Try again!");
                return getOperand();
            }
        }
        catch(InputMismatchException ime)
        {
            System.out.println("That's not an integer. Try again!");
            input.nextLine();
            return getOperand();
        }
    }

    private static int getInt()
    {
        try
        {
            System.out.print("Please enter an integer: ");
            return input.nextInt();
        }
        catch(InputMismatchException ime)
        {
            System.out.println("That's not an integer. Try again!");
            input.nextLine();
            return getInt();
        }
    }
    
    private static int add(int a, int b)
    {
        return a + b;
    }

    private static int subtract(int minuend, int subtrahend)
    {
        return minuend - subtrahend;
    }

    private static int multiply(int a, int b)
    {
        return a * b;
    }

    private static double divide(int dividend, int divisor)
    {
        return dividend / (double) divisor;
    }

    public static void main(String[] args) 
    {
        int a = getInt();
        int b = getInt();
        String result = "";
        String operand = getOperand();

        if (operand.equals("add"))
        {
            result = Integer.toString(add(a, b));
        }
        else if (operand.equals("subtract"))
        {
            result = Integer.toString(subtract(a, b));
        }
        else if (operand.equals("multiply"))
        {
            result = Integer.toString(multiply(a, b));
        }
        else if (operand.equals("divide"))
        {
            try
            {
                result = Double.toString(divide(a, b));
            }
            catch (ArithmeticException ae)
            {
                result = "undefined";
            }
        }

        System.out.printf("The result is %s\n", result);
    }
}