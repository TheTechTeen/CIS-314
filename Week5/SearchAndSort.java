/* 
 * CIS 314, Spring 2021
 * Author: Aiden Dow
 * Date: 2/26/2021
 * Assignment: Searching and Sorting 
 * Comments: 
*/
public class SearchAndSort 
{
    public static void main(String[] args) 
    {
        int[] arrayToSort = new int[10];
        for (int i = 0; i < arrayToSort.length; i++) 
        {
            arrayToSort[i] = 1 + (int)(Math.random() * 10);
        }
        System.out.println("The original array:");
        printArray(arrayToSort);
        sort(arrayToSort);
        System.out.println("The sorted array:");
        printArray(arrayToSort);
        System.out.println("The array contains:");
        search(arrayToSort);
    }

    public static void printArray(int[] array)
    {
        for (int i = 0; i < array.length; i++) 
        {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void sort(int[] sortArray)
    {
        // I used the bubble sort since I've implemented it before in C++ and also because it's a really cool algorithm
        boolean changed = true;
        while(changed)
        {   
            changed = false;
            for (int j = 0; j < sortArray.length - 1; j++)
            {
                if (sortArray[j] > sortArray[j + 1])
                {
                    // swap [j] and [j+1] so the larger is later in the array.
                    int swapHolder = sortArray[j];
                    sortArray[j] = sortArray [j + 1];
                    sortArray[j + 1] = swapHolder;
                    changed = true;
                }
            }
        }
    }

    public static void search(int[] array)
    {
        // A dictionary would make this a lot easier, but we haven't learned those yet.
        String[] numNames = new String[]{"zeros", "ones", "twos", "threes", "fours", "fives", "sixes", "sevens", "eights", "nines", "tens"};
        
        int searchNum = 1;
        int i = 0;
        int numCount = 0;
        while (i < array.length) 
        {
            if (array[i] == searchNum) // if the number is the one we are looking for
            {
                // record and go on to the next array element
                numCount++;
                i++;
            }
            else 
            {
                // output and begin searching for next number
                System.out.println(numCount + " " + numNames[searchNum]);
                searchNum++;
                numCount = 0;
            }
        }
        // output the last searchNum in the array since the loop 
        // will not run the output loop after evaluating the last number
        System.out.println(numCount + " " + numNames[searchNum]);
    }
}