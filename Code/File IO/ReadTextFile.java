// ReadTextFile
// Reading a text file
// and displaying each record

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadTextFile
{
	private Scanner input;

	// enable user to select file to open
	public void openFile()
	{
		try
		{
			input = new Scanner( new File( "clients.txt") );
		}// end of try
		catch ( FileNotFoundException fileNotFoundException )
		{
			System.err.println( "Error opening file." );
			System.exit(1);
		}// end catch
	} // end of openFile method

	// read record from file
	public void readRecords()
	{
		AccountRecord record = new AccountRecord();
		System.out.printf( "%-10s%-12s%-12s%10s\n", "Account", "First Name", "Last Name", "Balance" );

		try
		{
			while(input.hasNext() )
			{
				record.setAccount( input.nextInt() ); // read account number
				record.setFirstName( input.next() );
				record.setLastName( input.next() );
				record.setBalance( input.nextDouble() );

				// display record contents
				System.out.printf( "%-10d%-12s%-12s%10.2f\n",
						record.getAccount(), record.getFirstName(),
						record.getLastName(), record.getBalance() );

			}// end of while
		}// end of try
		catch( NoSuchElementException elementException )
		{
			System.err.println( "File improperly formed." );
			input.close();
			System.exit( 1 );
		}
		catch( IllegalStateException stateException)
		{
			System.err.println( "Error reading from file." );
			System.exit( 1 );
		}
	}// end of readRecords method

	public void closeFile()
	{
		if ( input != null )
		input.close();
	} // end of closeFile method
}// end of ReadSequentialFile