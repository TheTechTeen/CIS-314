// CIS 314 StringMiscellaneous.java
// This application demonstrates the length, charAt and getChars
// methods of the String class.

public class StringMiscellaneous
{
   public static void main( String[] args )
   {
      String s1 = "hello there";
      char[] charArray = new char[ 5 ];

      System.out.printf( "s1: %s", s1 );

      // test length method
      System.out.printf( "\nLength of s1: %d", s1.length() );

      // loop through characters in s1 with charAt and display reversed
      System.out.print( "\nThe string reversed is: " );

      for ( int count = s1.length() - 1; count >= 0; count-- )
         System.out.printf( "%c ", s1.charAt( count ) );
         // notice here that .length() is a method, unlike array.length
         // print the letters in s1 in reverse order and separated by spaces

      // copy characters from string into charArray
      s1.getChars( 0, 5, charArray, 0 );
      System.out.print( "\nThe character array is: " );
      // the first argument is the starting index from which the characters are to be copied
      // the second argument is the index that's one past the last character to be copied
      // the third argument is the character array into which the characters are to be copied
      // the fourth argument is the starting index where the copied characters are to be placed in the array

      for ( char character : charArray )
         System.out.print( character );

      System.out.println();
   } // end main
} // end class StringMiscellaneous
