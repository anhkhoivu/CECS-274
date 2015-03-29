public class Card {
	
	private char suit;  //instance variables
	private char rank;
	
	public Card(char r, char s)  //constructor, the card object
	{
	
		suit = s;
		rank = r;
		
	}
	
	public int getValue()
	{
		int value = 0;
		switch(rank)
		{
		
		case 'A':
			value = 11;
			break;
			
		case '2':
			value = 2;
			break;
			
		case '3':
			value = 3;
			break;
			
		case '4':
			value = 4;
			break;
			
		case '5':
			value = 5;
			break;
			
		case '6':
			value = 6;
			break;
			
		case '7':
			value = 7;
			break;
			
		case '8':
			value = 8;
			break;
			
		case '9':
			value = 9;
			break;
			
		case 'T':
			value = 10;
			break;
			
		case 'J':
			value = 10;
			break;
			
		case 'Q':
			value = 10;
			break;
			
		case 'K':
			value = 10;
		}
			return value;
		}
	
	
	public void displayCard()
	{
			System.out.println("[ "+ rank + " of " + suit + " ]");
	}


}