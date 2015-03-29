import java.util.Random;

public class LinkedList 
{
	private CardNode head;
	private int size;
	
	public LinkedList()
	{
		head = new CardNode(null, false);
		size = 0;
	}
	
	public void add(String card, boolean show)
	// post: appends the specified element to the end of this list.
	{
		CardNode temp = new CardNode(card, show);
		CardNode current = head;
		while(current.getNext() != null)
		{
			current = current.getNext();
		}
		// the last node's "next" reference set to our new node
		current.setNext(temp);
		size++;
	}
	
	public void add(String card, boolean show, int index)
	// post: inserts the specified element at the specified position in this list.
	{
		CardNode temp = new CardNode(card, false);
		CardNode current = head;
		for(int i = 1; i < index && current.getNext() != null; i++)
		{
			current = current.getNext();
		}
		
		// set the new node's next-node reference to this node's next-node reference
		temp.setNext(current.getNext());
		// now set this node's next-node reference to the new node
		current.setNext(temp);
		size++;
	}
	
	public String returnCard(int index)
	// post: returns the element at the specified position in this list.
	{
		// index must be 1 or higher
		if(index <= 0)
			return null;
		
		CardNode current = head.getNext();
		for(int i = 1; i < index; i++)
		{
			if(current.getNext() == null)
				return null;
			
			current = current.getNext();
		}
		return current.getCard();
	}
	
	public boolean returnShow(int index)
	// post: returns the element at the specified position in this list.
	{
		// index must be 1 or higher
		if(index <= 0)
			return false;
		
		CardNode current = head.getNext();
		for(int i = 1; i < index; i++)
		{
			if(current.getNext() == null)
				return false;
			
			current = current.getNext();
		}
		return current.getShow();
	}
	
	public boolean remove(int index)
	// post: removes the element at the specified position in this list.
	{
		if(index < 1 || index > getSize())
		{
			return false;
		}
		
		CardNode current = head;
		for(int i = 1; i < index; i++)
		{
			if(current.getNext() == null)
			{
				return false;
			}
			
			current = current.getNext();	
		}
		current.setNext(current.getNext().getNext());
		size--;
		return true;
	}
	
	public int getSize()
	{
		return size;
	}
	
	public int getNodeIndex(String cardInput)
	{
		int index = 0;		// index must be 1 or greater.
		if (cardInput != null)
		{
			CardNode current = head.getNext();
			for(int i = 1; i <= size; i++)
			{
				if (current.getCard().equals(cardInput))
				{
					index = i;
					return index;
				}
				
				else if(current.getNext() == null)
				{
					index = -1; 
					return index;
				}
				
				else 
				{
					current = current.getNext();
				}
			}
		}
		
		return index;
	}
}
	/*
	public Card[] fromLinkedListToArrays (LinkedList l)
	{
	
		if (l!= null)
		{		
			Card[] pileArray = new Card[l.getSize()];
			for (int i = 0; i<l.getSize(); i++)
			{
				pileArray[i] = l.getNode(i+1);
			}
			
		return pileArray;
		}
		
		else 
			return null;
	}
	
	public void fromArraysToLinkedList (Card[] cardArray)
	{   
		if (cardArray !=null)
		{
			for (int j= 0; j < cardArray.length; j++)
			{
				addNode(cardArray[j]);
			}
			
		}
	}
}*/
