/*
CIS 314, Spring 2021
Date: 1/29/2021
Author: Aiden Dow
Assignment: Things And Widgets
Comments: 
*/
public class Test
{
    public static void main(String[] args) 
    {
        System.out.println("Creating a new Thing");
        Thing thing = new Thing();
        System.out.printf("This thing is one of %d things in your universe\n", thing.getCount());

        System.out.println("Creating a new Widget");
        Widget widget = new Widget();
        System.out.printf("The %s widget is one of %d things in your universe", widget.getName(), widget.getCount());
    }
}
