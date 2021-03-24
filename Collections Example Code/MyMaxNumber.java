/* Get the maximum element from a collection */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyMaxNumber
{
    public static void main(String[] args)
    {
        List<Integer> li = new ArrayList<Integer>();
        li.add(23);
        li.add(44);
        li.add(12);
        li.add(45);
        li.add(2);
        li.add(16);
        System.out.println("Maximum element from the list: " + Collections.max(li));

        System.out.println("Minimum element from the list: " + Collections.min(li));

        // now sort the list
       Collections.sort(li);

       System.out.println(li);

       Collections.sort(li, Collections.reverseOrder());
              System.out.println(li);

    }
}