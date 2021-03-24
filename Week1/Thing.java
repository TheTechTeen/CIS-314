/*
CIS 314, Spring 2021
Date: 1/29/2021
Author: Aiden Dow
Assignment: Things And Widgets
Comments: 
*/
public class Thing 
{
    private static int count = 0;
    
    public Thing()
    {
        count++;
    }
    
    public int getCount()
    {
        return count;
    }
}