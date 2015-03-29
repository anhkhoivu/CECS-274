import java.util.*;
import java.text.*;
import java.util.Scanner;


public class Main 
{

	public static void main(String[] args) 
	{
		int bet = 0;
		int cardsRemaining = 51;
		String wantCard = "N";
		
		Scanner scan = new Scanner(System.in);
		Deck deck = new Deck();
		Bank bank = new Bank(10);
		Player player = new Player(12);
		Player dealer = new Player(12);
		DecimalFormat df = new DecimalFormat("#.00");
		
		System.out.println("Welcome to the Blackjack Menu \n" + 
						"1. New Deck. \n" + 
						"2. Shuffle cards in Deck. \n" +
						"3. Display all cards remaining in the deck. \n" + 
						"4. Play Blackjack. \n" + 
						"5. Exit");
			
		System.out.println("Please enter the number associated with your option.");
		String response = scan.nextLine();			
		int choice = Integer.parseInt(response);
		
		
		while (choice > 0 && choice <= 5)
		{
			if (choice == 1)
			{
				System.out.println("New Deck!");
				deck = new Deck();
				cardsRemaining = 51;
				deck.displayRemaining(cardsRemaining);
			}
			
			else if (choice == 2)
			{
				System.out.println("Shuffling Deck!");
				deck.shuffleRemaining(cardsRemaining);
				deck.displayRemaining(cardsRemaining);
			}
			
			else if (choice == 3)
			{
				System.out.println("Displaying Deck!");
				deck.displayRemaining(cardsRemaining);
			}
			
			else if (choice == 4)
			{
				System.out.println("You have " +(bank.getBalance())+ " dollars.");
				System.out.println("How much would you like to bet?");
				bet = scan.nextInt();
				
				while (bet > bank.getBalance() || bet <= 0)
				{
					System.out.print("Please enter a valid bet: ");
					bet = scan.nextInt();
				}
				
				while (cardsRemaining <= 10)
				{
					System.out.println("You don't have enough cards to play. Please create a new deck to start again.");
					System.out.println("1. New Deck");
					System.out.println("2. Shuffle cards in deck.");
					System.out.println("3. Display all cards remaining in the deck.");
					System.out.println("4. Play Blackjack");
					System.out.println("5. Exit");
					choice = scan.nextInt();
					choice = bank.endGame(choice);
				}
				
				System.out.println("Dealer's cards");
				System.out.println("[XXXX of XXXX]");
				dealer.addCard(deck.deal(cardsRemaining));
				cardsRemaining--;


				dealer.addCard(deck.deal(cardsRemaining));
			
				dealer.dealerDisplayHand();
				cardsRemaining--;
				
				System.out.println("Your cards.");
				player.addCard(deck.deal(cardsRemaining));
				cardsRemaining--;
				
				player.addCard(deck.deal(cardsRemaining));
				cardsRemaining--;
				
				player.displayHand();
				
				System.out.println(player.getCardsValue() + " points");


				System.out.println("Do you want another card? [Y/N]");
				wantCard = scan.next();
				
				while ( wantCard.equalsIgnoreCase("Y") && player.getCardsValue() < 21)
				{
					player.addCard(deck.deal(cardsRemaining));
					
					cardsRemaining--;
					player.displayHand();
					if(player.getCardsValue() > 21)
					{
						System.out.println("You busted!");
						bank.loseBet(bet);
						System.out.println("Your balance is $"  +df.format(bank.getBalance()));
						System.out.println("");
						wantCard = "N";
					}
					
					if(player.getCardsValue() == 21)
					{
						System.out.println("Blackjack! You won!");
						bank.winBet(bet);
						System.out.println("Your balance is $"  +df.format(bank.getBalance()));
						System.out.println("");
						wantCard = "N";
					}
					
					if (player.getCardsValue() < 21)
					{
					System.out.println("Do you want another card? [Y/N]");
					wantCard = scan.next();
					}
					
				}
				
				if ( player.getCardsValue() == 21)
				{
					System.out.println("Dealer's hand is...");
					dealer.dealerDisplayHand();
					
					System.out.println("Your hand is...");
					player.displayHand();
					
					System.out.println(player.getCardsValue() + " points" + "You win!!");
					bank.winBet(bet);
					System.out.println("Your balance is $" + df.format(bank.getBalance()));
					wantCard = "N";
					
					System.out.println("");
				}
				
				if (dealer.getCardsValue() < 17){


					while (dealer.getCardsValue() < 17)
					{
						dealer.addCard(deck.deal(cardsRemaining));
						cardsRemaining--;
					}
				}
				

				if(dealer.getCardsValue() > 21)
				{
					System.out.println("Dealer's hand is...");
					dealer.displayHand();
					System.out.println("Your hand is...");
					player.displayHand();
					
					System.out.println("Dealer loses with " + dealer.getCardsValue() + " points.");
					System.out.print("You win with ");
					System.out.print(player.getCardsValue() + " points.");
					bank.winBet(bet);
					System.out.println("Your balance is $" +df.format(bank.getBalance()));
					System.out.println(" ");
				}
				
				if(dealer.getCardsValue() > player.getCardsValue()  && dealer.getCardsValue() < 22)
				{
					System.out.println("Dealer's hand is...");
					dealer.displayHand();
					System.out.println("Your hand is...");
					player.displayHand();
					System.out.println("Dealer wins with " + dealer.getCardsValue() + " points");
					System.out.println("You lose with " + player.getCardsValue() + " points");
					bank.loseBet(bet);
					System.out.println("Your balance is $" +df.format(bank.getBalance()));
					System.out.println(" ");
					
				}
				if ( player.getCardsValue() > dealer.getCardsValue()  && player.getCardsValue() < 22)
				{
					System.out.println("Dealer's hand is...");
					dealer.displayHand();
					System.out.println("Your hand is...");
					player.displayHand();
					
					System.out.println("You win with " + player.getCardsValue() + " points." );
					System.out.println("Dealer loses with " + dealer.getCardsValue() + " points.");
					bank.winBet(bet);
					System.out.println("Your balance is $" + df.format(bank.getBalance()));
					System.out.println(" ");
				}
				else
				{
					if ( player.getCardsValue() == dealer.getCardsValue())
					{
					System.out.println("My hand is...");
					dealer.displayHand();
					System.out.println("Your hand is...");
					player.displayHand();
					System.out.println("Its a tie.");
					System.out.println("You have " + player.getCardsValue() + " points." );
					System.out.println("Dealer has " + dealer.getCardsValue() + " points.");
					System.out.println("Your balance is $" +df.format(bank.getBalance()));
					System.out.println(" ");
					}
				}
			}

		player = new Player(12);
		dealer = new Player(12);
		
		System.out.println("Blackjack Menu");
		System.out.println("1. New Deck");
		System.out.println("2. Shuffle cards in deck.");
		System.out.println("3. Display all cards remaining in the deck.");
		System.out.println("4. Play Blackjack");
		System.out.println("5. Exit");
		System.out.println("Please enter the number associated with your option.");
		choice = scan.nextInt();
		choice = bank.endGame(choice);
		}

			
		if (choice == 5)
		{
				System.out.println("Exiting Blackjack.");
				System.exit(0);
		}
		
	}
}