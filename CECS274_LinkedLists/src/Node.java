
public class Node 
{
	private String word;
	private Node next;
	
	/*char [] letters = 
		{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 
			'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	*/
	
	public Node(String newWord)
	{
		next = null;
		word = newWord;
	}
	
	public Node getNext()
	{
		return next;
	}
	

	public void setNext(Node nextNode)
	{
		next = nextNode;
	}
	
	public String getWord()
	{
		return word;
	}
}
