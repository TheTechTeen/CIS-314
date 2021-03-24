// CIS 314, StaticCharMethods.java
// Character static methods for testing characters and converting case.
// Character is a "wrapper class" for the primitive data type char.
// An object of type Character contains a single field whose type is char.
// the Character class contains a number of useful static methods for manipulating characters

import java.util.Scanner;

public class StaticCharMethods
{
   public static void main( String[] args )
   {
      Scanner scanner = new Scanner( System.in ); // create scanner
      System.out.println("Enter a character and press Enter" );
      String input = scanner.next();
      char c = input.charAt( 0 ); // get input character - why am I thinking arrays here?

      // display character info
      System.out.printf("is defined: %b\n", Character.isDefined( c ) ); // is defined in Unicode
      System.out.printf("is digit: %b\n", Character.isDigit( c ) );

		// can this char be the first character in a Java identifier
      System.out.printf("is first character in a Java identifier: %b\n", Character.isJavaIdentifierStart( c ) );

		// can this char be part of a java identifier
      System.out.printf("is part of a Java identifier: %b\n", Character.isJavaIdentifierPart( c ) );

      System.out.printf("is letter: %b\n", Character.isLetter( c ) );
      System.out.printf("is letter or digit: %b\n", Character.isLetterOrDigit( c ) );
      System.out.printf("is lower case: %b\n", Character.isLowerCase( c ) );
      System.out.printf("is upper case: %b\n", Character.isUpperCase( c ) );
      System.out.printf("to upper case: %s\n", Character.toUpperCase( c ) );
      System.out.printf("to lower case: %s\n", Character.toLowerCase( c ) );
   } // end main
} // end class StaticCharMethods
