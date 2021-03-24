// now another user defined data type to create a text file
// Writing text file sequentially with class Formatter

// notice all the different places that exceptions come from

import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateTextFile
{
	private Formatter output; // outputs the text to a file

	// allow user to specify file name
	public void openFile()
	{
		try
		{
			output = new Formatter( "clients.txt" );
		}
		catch ( SecurityException securityException )
		{
			System.err.println( "You do not have write access to this file." );
			System.exit(1); // terminate the program
		}
		catch ( FileNotFoundException fileNotFoundException )
		{
			System.err.println( "Error opening or creating file." );
			System.exit(1); // terminate the program
		}
	}// end method openFile

	// add records to file
	public void addRecords()
	{
		AccountRecord record = new AccountRecord();

		Scanner input = new Scanner(System.in);

		System.out.printf("%s\n%s\n%s\n%s\n\n",
			"To terminate input type end of file indicator",
			"when you are prompted to enter input.",
			"On UNIX/LINUX/Mac OS X type <ctrl> d then press Enter",
			"On Windows type <ctrl> z then press Enter." );
		System.out.printf("%s\n%s",
			"Enter account number (>0), first name, last name, and balance.",
			"? ");

		while( input.hasNext() ) //loop until end of file indicator
		{
			try
			{
				record.setAccount( input.nextInt() ); 		// read account number
				record.setFirstName( input.next() );		// read first name
				record.setLastName( input.next() );			// read last name
				record.setBalance( input.nextDouble() );

				if ( record.getAccount() > 0 )			// create new record
				{
					output.format( "%d %s %s %.2f\n",
						record.getAccount(),
						record.getFirstName(),
						record.getLastName(),
						record.getBalance() );
				}
				else
				{
					System.out.println("Account number must be greater than 0." );
				}
			} // end try
			catch ( FormatterClosedException formatterClosedException )
			{
				System.err.println( "Error writing to file." );
				return;
			}
			catch ( NoSuchElementException elementException )
			{
				System.err.println( "Invalid input. Please try again." );
				input.nextLine(); // discard input so user can try again
			}

			System.out.printf("%s %s\n%s", "Enter account number (>0),",
				"first name, last name, and balance.", "? " );
		} // end of while
	}// end of addRecords method

	// close file and terminate application
	public void closeFile()
	{
		if ( output != null )
		output.close();
	}// end method closeFile
}// end of class CreateSequentialFile