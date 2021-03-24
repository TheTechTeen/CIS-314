// AccountRecord is a user defined data type
// maintains information for one account

public class AccountRecord
{
	// class variables
	private int account;
	private String firstName;
	private String lastName;
	private double balance;

	// no argument constructor calls other constructor with default values
	// just to show off - make sure that in the event that values are not available
	// an object can still be built, kind of a fail-safe
	public AccountRecord()
	{
		this(0, "", "", 0.0);
	} // end of constructor

	// four argument constructor
	public AccountRecord( int acct, String first, String last, double bal)
	{
		account = acct;
		firstName = first;
		lastName = last;
		balance = bal;
	}

	public void setAccount( int acct )
	{
		account = acct;
	}

	public int getAccount()
	{
		return account;
	}

	public void setFirstName( String first )
	{
		firstName = first;
	}

	public String getFirstName ()
	{
		return firstName;
	}

	public void setLastName ( String last )
	{
		lastName = last;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setBalance( double bal)
	{
		balance = bal;
	}

	public double getBalance()
	{
		return balance;
	}

}// end of class AccountRecordsSerializable
