
public class Node 
{
	private int number;
	private Node leftChild;
	private Node rightChild;
	
	public Node(int newNumber)
	{
		number = newNumber;
		leftChild = null;
		rightChild = null;
	}
	
	public void setNumber(int newNumber)
	{
		number = newNumber;
	}
	
	public int getNumber()
	{
		return number;
	}
	
	public Node getLeftChild()
	{
		return leftChild;
	}
	
	public Node getRightChild()
	{
		return rightChild;
	}
	
	public int addNumber()
	{
		
	}
}
