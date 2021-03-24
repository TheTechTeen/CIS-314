// CIS 314, StringBuilderConstructors.java
// StringBuilder constructors.
// StringBuilder objects are like String objects, except that they can be modified
// They can be treated like variable length arrays.
// generally use Strings, except when string bulder provide simpler code or better performance
// for example, if you need to concatinate a large number of strings, appending to a string builder object is more efficient

public class StringBuilderConstructors
{
   public static void main( String[] args )
   {
      StringBuilder buffer1 = new StringBuilder();
      StringBuilder buffer2 = new StringBuilder( 10 );
      StringBuilder buffer3 = new StringBuilder( "hello" );

      System.out.printf( "buffer1 = \"%s\"\n", buffer1.toString() );
      System.out.printf( "buffer2 = \"%s\"\n", buffer2.toString() );
      System.out.printf( "buffer3 = \"%s\"\n", buffer3.toString() );
   } // end main
} // end class StringBuilderConstructors

