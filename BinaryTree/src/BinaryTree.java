public class BinaryTree 
{
	Node root;
	
	public void addNode(int number)
	{
		Node newNode = new Node(number);
		if (root == null) 
		{
			root = newNode;
		} 
		
		else 
		{
			Node focusNode = root;
			Node parent;
			boolean rootComparison = true;
			
			while (rootComparison) 
			{
				parent = focusNode;

				if (number < focusNode.number) 
				{
					focusNode = focusNode.leftChild;
					if (focusNode == null) 
					{
						parent.leftChild = newNode;
						return;
					}
				} 
				
				else 
				{
					focusNode = focusNode.rightChild;
					if (focusNode == null) 
					{
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}
	
	public void inOrderTraversal(Node focusNode)
	{
		if(focusNode != null)
		{
			inOrderTraversal(focusNode.leftChild);
			System.out.print(focusNode.number + " ");
			inOrderTraversal(focusNode.rightChild);
		}
	} 
	
	public Node findNode(int number)
	{
		Node focusNode = root;
		while (focusNode.number != number)
		{
			if(number < focusNode.number)
			{
				focusNode = focusNode.leftChild;
			}
			
			else
			{
				focusNode = focusNode.rightChild;
			}
			
			if(focusNode == null)
			{
				System.out.println("Please enter a valid integer in the tree.");
				return null;
			}
		}
		
		return focusNode;
	}
	
	public int findNodeLevel(int number)
	{
		int level = 0;
		Node focusNode = root;
		while (focusNode.number != number)
		{
			if(number < focusNode.number)
			{
				focusNode = focusNode.leftChild;
				level++;
			}
			
			else
			{
				focusNode = focusNode.rightChild;
				level++;
			}
		}
		
		return level;
	}
	
	public int numberOfNodes(Node focusNode)
	{
		if(focusNode == null)
		{
			return 0;
		}
		
		else
		{
			int number = 1;
			number += numberOfNodes(focusNode.leftChild);
			number += numberOfNodes(focusNode.rightChild);
			return number;
		}
	}
	
	public int findHeightOfTree(Node focusNode)
	{
		int height = 0;
		int leftNodeHeight = 0;
		int rightNodeHeight = 0; 
		
		
		if(focusNode == null)
		{
			return 0;
		}
		
		else
		{
			leftNodeHeight += numberOfNodes(focusNode.leftChild);
			leftNodeHeight++;
			rightNodeHeight += numberOfNodes(focusNode.rightChild);
			rightNodeHeight++;
			
		}
		
		if (leftNodeHeight > rightNodeHeight)
		{
			height = leftNodeHeight;
		}
		
		else if (leftNodeHeight < rightNodeHeight)
		{
			height = rightNodeHeight;
		}
		
		else
		{
			height = rightNodeHeight;
		}
		
		return height;
	}
	
	public boolean removeNode(int number)
	{
		Node parent = root;
		Node focusNode = root;
		
		boolean isItALeftChild = true;

		while (focusNode.number != number)
		{
			parent = focusNode;
			
			if(number < focusNode.number)
			{
				isItALeftChild = true;
				focusNode = focusNode.leftChild;
			}
			
			else
			{
				isItALeftChild = false;
				focusNode = focusNode.rightChild;
			}
			
			if(focusNode == null)
			{
				return false;
			}
			
			if(focusNode.leftChild == null && focusNode.rightChild == null)
			{
				if(focusNode == root)
				{
					root = null;
				}
				
				else if(isItALeftChild)
				{
					parent.leftChild = null;
				}
				
				else 
				{
					parent.rightChild = null;
				}
			}
			
			else if (focusNode.rightChild == null)
			{
				if(focusNode == root)
				{
					root = focusNode.leftChild;
				}
				
				else if(isItALeftChild)
				{
					parent.leftChild = focusNode.leftChild;
				}
				
				else
				{
					parent.rightChild = focusNode.leftChild;
				}
			}
			
			else if (focusNode.leftChild == null)
			{
				if(focusNode == root)
				{
					root = focusNode.rightChild;
				}
				
				else if(isItALeftChild)
				{
					parent.leftChild = focusNode.rightChild;
				}
				
				else
				{
					parent.rightChild = focusNode.rightChild;
				}
			}
			
			else
			{
				Node replacementNode = getReplacementNode(focusNode);
				if(focusNode == root)
				{
					root = replacementNode;
				}
				
				else if(isItALeftChild)
				{
					parent.leftChild = replacementNode;
				}
				
				else
				{
					parent.rightChild = replacementNode;
				}
				
				replacementNode.leftChild = focusNode.leftChild;
				
			}	
		}
		
		return true;
	}
	
	public Node getReplacementNode(Node newNode)
	{
		Node replacedParent = newNode;
		Node replacedNode = newNode;
		
		Node focusNode = newNode.rightChild;
		
		while(focusNode != null)
		{
			replacedParent = replacedNode;
			replacedNode = focusNode;
			focusNode = focusNode.leftChild;
		}
		
		if(replacedNode != replacedNode.rightChild)
		{
			replacedParent.leftChild = replacedNode.rightChild;
			replacedNode.rightChild = newNode.rightChild;
		}
		
		return replacedNode;
	}
	
}