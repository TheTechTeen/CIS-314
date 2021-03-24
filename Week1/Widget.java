/*
CIS 314, Spring 2021
Date: 1/29/2021
Author: Aiden Dow
Assignment: Things And Widgets
Comments: The assignment doc didn't say where to take the name from, so I generated it from a random prebuilt list of my favorite widget names
*/

import java.util.Random;
public class Widget extends Thing
{
    private String name;

    public Widget()
    {
        super();
        
        //Randomly picks a name from a pre-built list
        String[] names = new String[]{"Whatchamacallit", "Thingamajig", "Whosiwhatsis", "Knick-knack"};
        int rnd = new Random().nextInt(names.length);
        name = names[rnd];
    }

    public String getName()
    {
        return name;
    }
}
