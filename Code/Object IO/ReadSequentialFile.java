// ReadSequentialFile
// Reading a file of objects sequentially with ObjectInputStream
// and displaying each record

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadSequentialFile
{
	private ObjectInputStream input;

	// enable user to select file to open
	public void openFile()
	{
		try
		{
			input = new ObjectInputStream( new FileInputStream( "clients.ser" ) );
		}// end of try
		catch (IOException ioException )
		{
			System.err.println( "Error opening file." );
		}// end catch
	} // end of openFile method

	// read record from file
	public void readRecords()
	{
		AccountRecordSerializable record;
		System.out.printf( "%-10s%-12s%-12s%10s\n", "Account", "First Name", "Last Name", "Balance" );

		try
		{
			while(true)
			{
				record = ( AccountRecordSerializable) input.readObject();

				// display record contents
				System.out.printf( "%-10d%-12s%-12s%10.2f\n",
						record.getAccount(), record.getFirstName(),
						record.getLastName(), record.getBalance() );

			}// end of while
		}// end of try
		catch( EOFException eofException )
		{
			return; // end of file was reached
		}
		catch( ClassNotFoundException classNotFoundException)
		{
			System.err.println( "Unable to create object." );
		}
		catch( IOException ioException  )
		{
			System.err.println( "Error during read from file." );
		}
	}// end of readRecords method

	public void closeFile()
	{
		try
		{
			if ( input != null )
			input.close();
		}// end of try
		catch ( IOException ioException  )
		{
			System.err.println("Error closing file.");
			System.exit(1);
		}
	} // end of closeFile method
}// end of ReadSequentialFile