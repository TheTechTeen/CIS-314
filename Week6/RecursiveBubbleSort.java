/* 
 * CIS 314, Spring 2021
 * Author: Aiden Dow
 * Date: 3/8/2021
 * Assignment: Recursion 
 * Comments: 
*/
public class RecursiveBubbleSort 
{
    public static void main(String[] args) 
    {
        int[] arrayToSort = new int[10];
        for (int i = 0; i < arrayToSort.length; i++) 
        {
            arrayToSort[i] = 1 + (int)(Math.random() * 100);
        }
        for (int i = 0; i < arrayToSort.length; i++) 
        {
            System.out.print(arrayToSort[i] + " ");
        }
        System.out.println("\nSorted Array:");
        bubbleSort(arrayToSort, arrayToSort.length);
    }
    private static void bubbleSort(int[] array, int control)
    {
        if (control <= 1)
        {
            // Print the array
            for (int i = 0; i < array.length; i++) 
            {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
        else
        {
            for (int i = 0; i < array.length - 1; i++)
            {
                if (array[i] > array[i + 1])
                {
                    // swap [j] and [j+1] so the larger is later in the array.
                    int swapHolder = array[i];
                    array[i] = array [i + 1];
                    array[i + 1] = swapHolder;
                }
            }
            bubbleSort(array, control - 1);
        }
    }
}