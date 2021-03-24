// the ReadSequentialFileTest app
// testing class ReadSequentialFile

public class ReadSequentialFileTest
{
	public static void main (String[] args )
	{
		ReadSequentialFile application = new ReadSequentialFile();

		application.openFile();
		application.readRecords();
		application.closeFile();
	}// end of main method
}// end of ReadSequentialFileTest
