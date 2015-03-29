import java.util.Random;

public class LinkedList 
{
	private Node head;
	private int size;
	
	public LinkedList()
	{
		head = new Node(null);
		size = 0;
	}
	
	public void addNode(String letter)
	// post: appends the specified element to the end of this list.
	{
		Node temp = new Node(letter);
		Node current = head;
		while(current.getNext() != null)
		{
			current = current.getNext();
		}
		// the last node's "next" reference set to our new node
		current.setNext(temp);
		size++;
	}
	
	public void addNode(String data, int index)
	// post: inserts the specified element at the specified position in this list.
	{
		Node temp = new Node(data);
		Node current = head;
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
	
	public String getNode(int index)
	// post: returns the element at the specified position in this list.
	{
		// index must be 1 or higher
		if(index <= 0)
			return null;
		
		Node current = head.getNext();
		for(int i = 1; i < index; i++)
		{
			if(current.getNext() == null)
				return null;
			
			current = current.getNext();
		}
		return current.getWord();
	}
	
	public boolean removeNode(int index)
	// post: removes the element at the specified position in this list.
	{
		if(index < 1 || index > getSize())
		{
			return false;
		}
		
		Node current = head;
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

	public String [] wordGenerator(int numberOfLetters)
	{
		if(numberOfLetters > 0)
		{
			String [] randomWord = new String [numberOfLetters];
			Random rnd = new Random ();
			for (int i = 0; i < numberOfLetters; i++ )
			{
				randomWord[i] = "" + (char) (rnd.nextInt(26) + 'a') +
						(char) (rnd.nextInt(26) + 'a') +
						(char) (rnd.nextInt(26) + 'a') +
						(char) (rnd.nextInt(26) + 'a') +
						(char) (rnd.nextInt(26) + 'a');
			}
			return randomWord;
		}
		return null;
	}
	
	public int getNodeIndex(String wordInput)
	{
		int index = 0;		// index must be 1 or greater.
		if (wordInput != null)
		{
			Node current = head.getNext();
			for(int i = 1; i <= size; i++)
			{
				if (current.getWord().equals(wordInput))
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
	
	public String[] fromLinkedListToArrays (LinkedList l)
	{
	
		if (l!= null)
		{		
			String[] strArray = new String[l.getSize()];
			for (int i = 0; i<l.getSize(); i++)
			{
				strArray[i] = l.getNode(i+1);
			}
			
		return strArray;
		}
		
		else 
			return null;
	}
	
	public void fromArraysToLinkedList (String[] strings)
	{   
		if (strings !=null)
		{
			for (int j= 0; j < strings.length; j++)
			{
				addNode(strings[j]);
			}
			
		}
	}
			
	public void displayWords(String newWord)
	{
		System.out.println("The list of sorted words are: \n");
		Node n = head;
		
		while (n.getNext() != null)
		{
			for (int i = 0; i < 12; i++)
			{
				if(n.getNext() != null)
				{
					if (n.getNext().getWord() != newWord)
					{
	            		System.out.format("%9s", n.getNext().getWord());
	            	}
	            	else
	            	{
	            		System.out.format("%9s", "*" +n.getNext().getWord());
	            	}
	                n = n.getNext();
	            }
	           
	        }
	        System.out.print("\n");
	    }
	}
}