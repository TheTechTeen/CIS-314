/*
Collections.addAll() method adds all of the specified elements to the specified collection.
Elements to be added may be specified individually or as an array.
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsAddAll
{
    public static void main(String[] args)
    {
        List<String> myList = new ArrayList<String>();  // declare a list of Strings

		// add elements, one at a time
       	myList.add("java");
        myList.add("c");
        myList.add("c++");

        // print the list
        System.out.println("Initial list:" + myList);

		// add using the collections add all method to add elements to the list
        Collections.addAll(myList, "perl","php");
        System.out.println("After adding elements:" + myList);

        // create an array of Strings
        String[] strArr = {".Net", "unix"};

        // add the array
        Collections.addAll(myList, strArr);
        System.out.println("After adding array:"+myList);
    }
}