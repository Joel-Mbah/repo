/**
 * Joel Mbah
 * CMSC 203
 * LAB 6
 */
public class CheckingAccount extends BankAccount {
	private static final double FEE = 0.15;
	public CheckingAccount(String name, double amount)
	{
		super(name, amount);
		
		String newAccountNumber = getAccountNumber() + "-10";
		setAccountNumber(newAccountNumber);
		
		
	}
	@Override//overriden method to return true or false if the customer can withdraw money or not 
	public boolean withdraw (double amount)
	{
		amount += FEE;
		return super.withdraw(amount);
	}
	

}
