public class CardNode 
{
	// reference to the next node in the chain,
	// or null if there isn't one.
		
	CardNode next;
		
	// data carried by this node.
	// could be of any type you need.
	String card; //node will contain our string variable called card
	boolean show; //node will contain boolean variable that will be used to show cardnode or not
	
	public CardNode(String newCard, boolean newShow)
	{
		next = null;
		card = newCard;
		show = newShow; 
	}
	
	public CardNode(String newCard, boolean newShow, CardNode newNext)
	{
		next = newNext;
		card = newCard;
		show = newShow;
	}
	
	public boolean getShow()
	{
		return show;
	}
	
	public void setNext(CardNode newNext)
	{
		next = newNext;
	}
	
	public CardNode getNext()
	{
		return next;
	}
	
	public void setCard(String newCard)
	{
		card = newCard;
	}
	
	public String getCard()
	{
		return card;
	}

	
}
