/**
 * Joel Mbah
 * CMSC 203
 * LAB 6
 */
public class SavingsAccount extends BankAccount {
	private double rate = 0.025;
	private int savingsNumber = 0;
	private String accountNumber;
	
	public SavingsAccount(String name, double amount)
	{
		super(name, amount);
		this.accountNumber = super.getAccountNumber() + "-" + this.savingsNumber;
	}
	
	public void postInterest()
	{
		double  monthlyInterest = super.getBalance() * (rate/12.0); // divides the annually interest rate by 12 to get the monthly interest rate
		deposit(monthlyInterest); // call the deposit method and passs the monthly interest rate as an arguement to depposit the interest
		
		
	}
	
	@Override //overriden method for account number
	public String getAccountNumber()
	{
		return this.accountNumber;
	}
	
	public SavingsAccount(SavingsAccount oldAccount, double amount) // second constructor
	{
		super(oldAccount, amount);
		this.savingsNumber = oldAccount.savingsNumber + 1;
		this.accountNumber = super.getAccountNumber() + "-" + this.savingsNumber;
	}
	

}
