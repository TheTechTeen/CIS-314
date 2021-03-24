// CIS 314, Tokenizing Strings

import java.util.Scanner;
import java.util.StringTokenizer;

public class TokenTest
{
	public static void main(String[] args)
	{
		// get a scanner
		Scanner input = new Scanner( System.in );
		System.out.println("Enter a sentence and press Enter.");

		String sentence = input.nextLine();

		// process sentence
		String[] tokens = sentence.split( " " );

		System.out.printf("Number of elements: %d\nThe tokens are:\n", tokens.length);

		for( String token : tokens )
			System.out.println( token );
	}
}// end of class
