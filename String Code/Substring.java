// CIS 314
// String class substring methods

public class Substring
{
   public static void main( String[] args )
   {
      String letters = "abcdefghijklmabcdefghijklm";

	  // test substring methods
	  System.out.printf("Substring from indes 20 to end is \"%s\"\n", letters.substring( 20 ) );

	  System.out.printf( "Substring from index up to but not including 6 is \"%s\"\n", letters.substring( 3, 6 ));

   } // end main
} // end class StringIndexMethods
