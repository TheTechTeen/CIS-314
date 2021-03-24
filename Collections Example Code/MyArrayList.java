/*
The following code shows an example how to create a Collection of type List
which is parameterized with <String> to indicate to the Java compiler that only Strings are allowed in this list.
It uses a method reference and the foreach loop from Java 8.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyArrayList
{
    public static void main(String[] args)
    {
        // create a list using the as list method
        List<String> list = Arrays.asList("Lars", "Simon");

        // alternatively
        List<String> anotherList = new ArrayList<>();
        anotherList.add("Lars");
        anotherList.add("Simon");

        // print each element to the console using method references
        list.forEach(System.out::println);
        anotherList.forEach(System.out::println);

    }
}