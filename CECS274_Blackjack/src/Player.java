public class Player 
{
		private int maxHandCards= 12;
		private Card[] myHand;
		private int numCards = 0;
		private int totalValue = 0;
		
		public Player(int size) 
		{		
			myHand = new Card[maxHandCards];
		}
		
		public int getTotalValue()
		{
			return totalValue;	
		}
		
		public void setTotalValue(int value)
		{
			totalValue = value;
		}
		
		public int getNumCards()
		{
			return numCards;
			
		}
		
		public void setNumCards(int value)
		{
			numCards = value;
		}

		public void defaultHand() 
		{
			for (int i = 0; i < maxHandCards; i++) 
			{
				myHand[i] = null;
			}
			numCards = 0;	
		}
		
		public void addCard(Card newCard)
		{
			
			if (numCards < maxHandCards) 
			{
				myHand[numCards++] = newCard;	
		    }
		}
		
		public int getCardsValue() 
		{
			
			int totalCardsValue = 0;
			int value;
			int numberOfAces = 0;
		
			for (int i = 0; i < numCards; i++) 
			{
				
				value = myHand[i].getValue();
				
				if (value == 11) // is Ace
				{ 
					numberOfAces++;
					totalCardsValue = totalCardsValue+11;
				} 
				else if(value > 10) //is face card
				{ 
					totalCardsValue = totalCardsValue + 10;
				} 
				else 
				{
					totalCardsValue= totalCardsValue+ value;
				}
			}
			
			// if we have aces and our sum is > 21, set some/all of them to value 1 
			// instead
			while (totalCardsValue > 21 && numberOfAces > 0) 
			{
				totalCardsValue = totalCardsValue - 10;
				numberOfAces = numberOfAces - 1;
			}
			
			return totalCardsValue;
			
		}
		
		public void displayHand() 
		{			
			for (int i = 0; i < numCards; i++)
			{
				myHand[i].displayCard();
			}
		}
		
		public void dealerDisplayHand()
		{
			myHand[1].displayCard();
		}
		
		
	}
