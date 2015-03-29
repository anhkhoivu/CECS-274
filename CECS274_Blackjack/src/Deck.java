import java.util.Random;

public class Deck 
{	
	private  Card[] deck = new Card[52]; //deck is a 52 element array filled with the object card
										 //want to make deck filled with the object 'Card'
	private int index = 0;

	public Deck() 
	{
		char [] suits = {'D','S', 'C', 'H'};

		char [] ranks = {'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};

		for (int s = 0; s < 4; s++) {

			for (int r = 0; r < 13; r++) {

				 deck[index] = new Card (ranks[r], suits[s]);  //deck is array of card object with suit and rank

				index++;
			}
		}

	}
	
	public Card deal(int cardsRemaining)
	{
		return deck[cardsRemaining];
	}
	
	public void shuffle() 
	{  //shuffling the deck
		Card temp;
		Random rnd = new Random();
		int x, y;
		for (int i = 0; i < 1000000; i++) 
		{	
			x = rnd.nextInt(52);
			y = rnd.nextInt(52);
			temp = deck[x];
			deck[x] = deck[y];
			deck[y] = temp;
			
		}
	}
	
	public void shuffleRemaining(int cardsRemaining)
	{
		for (int i = 0; i < 1000; i++)
		{
			Random r = new Random();
			int alpha = r.nextInt(cardsRemaining);
			Card temp = deck[alpha];
			int beta = r.nextInt(cardsRemaining);
			deck[alpha] = deck[beta];
			deck[beta] = temp;
					
		}
	}
	
	public void displayRemaining(int cardsRemaining)
	{
		for(int i = 0; i < cardsRemaining + 1 ; i++)
		{
			deck[i].displayCard();
		}
	}
}