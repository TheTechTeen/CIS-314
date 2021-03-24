// now another user defined data type to create a serializable file/object
// Writing object sequentially to a file with class ObjectOutputStream

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateSequentialFile
{
	private ObjectOutputStream output; // outputs the data to a file

	// allow user to specify file name
	public void openFile()
	{
		try
		{
			// initializing stream objects with other stream objects is called wrapping
			output = new ObjectOutputStream( new FileOutputStream( "clients.ser" ) );
		}
		catch ( IOException ioException )
		{
			System.err.println( "error opening file" );
		}
	}// end method openFile

	// add records to file
	public void addRecords()
	{
		AccountRecordSerializable record; // object to be written to the file
		int accountNumber = 0;
		String firstName;
		String lastName;
		double balance;

		Scanner input = new Scanner( System.in );

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
				accountNumber = input.nextInt(); 	// read account number
				firstName = input.next();			// read first name
				lastName = input.next();			// read last name
				balance = input.nextDouble();

				if ( accountNumber > 0 )			// create new record
				{
					record = new AccountRecordSerializable (accountNumber, firstName, lastName, balance);
					output.writeObject( record );
				}
				else
				{
					System.out.println("Account number must be greater than 0." );
				}
			} // end try
			catch ( IOException ioException )
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
		try
		{
			if ( output != null )
			output.close();
		}// end try
		catch ( IOException ioException )
		{
			System.out.println( "Error closing file." );
			System.exit(1);
		}// end catch
	}// end method closeFile
}// end of class CreateSequentialFile