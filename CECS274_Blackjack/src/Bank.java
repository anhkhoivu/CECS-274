public class Bank 
{
	int balance;
	
	public Bank(int money)
	{
		balance = money;
	}
	
	public int getBalance()
	{
		return balance;
	}
	
	public void winBet(int bet)
	{
		balance = balance + bet;
	}
	
	public void loseBet(int bet)
	{
		balance = balance - bet;
	}
	
	public int endGame(int noBalance)
	{
		if (balance <= 0)
		{
		 	noBalance = 6;
		 	noMoreMoney();
		}	
		return noBalance;
	}
	
	public void noMoreMoney()
	{
		if (balance <= 0)
		{
			System.out.println("You have a balance less than zero.\nNo more money to bet. \nRestart game to play again.");
		}
		
	}
}