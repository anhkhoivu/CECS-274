import java.util.*;

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
	
	public boolean duplicateNode(int number)
	{
		boolean sameNode = false;
		boolean rootComparison = true;
		
		if (root == null) 
		{
			sameNode = false;
		} 
		
		else 
		{
			Node focusNode = root;
			
			while(rootComparison)
			{
				if (number < focusNode.number)
				{
					sameNode = false;
					focusNode = focusNode.leftChild;
					if (focusNode == null) 
					{
						sameNode = false;
						rootComparison = false;
					}
				}
				
				else if (number > focusNode.number)
				{
					sameNode = false;
					focusNode = focusNode.rightChild;
					if (focusNode == null)
					{
						sameNode = false;
						rootComparison = false;
					}
				}
				
				else 
				{
					sameNode = true;
					rootComparison = false;
				}
			}
		}
		
		return sameNode;
	}
	
	public int[] fromBinaryTreeToArray(BinaryTree tree, Node focusNode)
	{
		int [] intArray = new int[tree.numberOfNodes(focusNode)];
		if(focusNode != null)
		{
			inOrderTraversal(focusNode.leftChild);
			inOrderTraversal(focusNode.rightChild);
		}
		
		for(int i = 0; i<tree.numberOfNodes(focusNode); i++)
		{
			while(focusNode.leftChild != null)
			{
				intArray[i] = tree.findNodeNumber(focusNode.leftChild.number); 	
			}
			
			while(focusNode.rightChild != null)
			{
				intArray[i] = tree.findNodeNumber(focusNode.rightChild.number); 
			}
		}
		
		return intArray;
	}
	
	public void inOrderTraversal(Node focusNode)
	{
		if(focusNode != null)
		{
			if(focusNode.leftChild != null)
			{
				inOrderTraversal(focusNode.leftChild);
			}
			
			System.out.print(focusNode.number + " ");
			
			if(focusNode.rightChild != null)
			{
				inOrderTraversal(focusNode.rightChild);
			}
		}
	} 
	
	public int findNodeNumber(int number)
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
		}
		
		return focusNode.number;
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
		
		if(focusNode == null)
		{
			return 0;
		}
		
		else
		{
			return Math.max(findHeightOfTree(focusNode.leftChild), findHeightOfTree(focusNode.rightChild));
		}

	}
	
	public boolean removeNode(int number)
	{
		Node parent = root;
		Node focusNode = root;
		
		boolean isItALeftChild = true;
		boolean numberFound = false;

		while (!numberFound)
		{
			parent = focusNode;
			
			if(number < focusNode.number)
			{
				isItALeftChild = true;
				focusNode = focusNode.leftChild;
			}
			
			else if (number > focusNode.number)
			{
				isItALeftChild = false;
				focusNode = focusNode.rightChild;
			}
			
			else
			{
				isItALeftChild = false;
				focusNode = root;
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
					numberFound = true;
				}
				
				else if(isItALeftChild)
				{
					parent.leftChild = null;
					numberFound = true;
				}
				
				else 
				{
					parent.rightChild = null;
					numberFound = true;
				}
			}
			
			else if (focusNode.rightChild == null)
			{
				if(focusNode == root)
				{
					root = focusNode.leftChild;
					numberFound = true;
				}
				
				else if(isItALeftChild)
				{
					parent.leftChild = focusNode.leftChild;
					numberFound = true;
				}
				
				else
				{
					parent.rightChild = focusNode.leftChild;
					numberFound = true;
				}
			}
			
			else if (focusNode.leftChild == null)
			{
				if(focusNode == root)
				{
					root = focusNode.rightChild;
					numberFound = true;
				}
				
				else if(isItALeftChild)
				{
					parent.leftChild = focusNode.rightChild;
					numberFound = true;
				}
				
				else
				{
					parent.rightChild = focusNode.rightChild;
					numberFound = true;
				}
			}
			
			else
			{
				Node replacementNode = getReplacementNode(focusNode);
				if(focusNode == root)
				{
					root = replacementNode;
					numberFound = true;
				}
				
				else if(isItALeftChild)
				{
					parent.leftChild = replacementNode;
					numberFound = true;
				}
				
				else
				{
					parent.rightChild = replacementNode;
					numberFound = true;
				}
				
				replacementNode.leftChild = focusNode.leftChild;
				
			}	
		}
		
		return numberFound;
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
	
	public  void balanceTree(int min, int max, ArrayList<Node> nodeArray)
	{
		if(min <= max)
		{
			int median = (int) Math.ceil(((double) min +max) /2);
			addNode(nodeArray.get(median).number);
			balanceTree(min, median -1, nodeArray);
			balanceTree( median+1,max,  nodeArray);
		}
	}
	
	public void fromTreeToArray (Node focusNode, ArrayList<Node> nodeArray)
	{
		if(focusNode != null)
		{
			fromTreeToArray(focusNode.leftChild, nodeArray);
			nodeArray.add(focusNode);
			fromTreeToArray(focusNode.rightChild, nodeArray);			
		}	
	}
	
	public void balanceTree()
	{
		ArrayList<Node> nodeArray = new ArrayList<>();
		fromTreeToArray(root, nodeArray);
		
		//empty the tree
		for(Node focusNode: nodeArray)
		{
			focusNode.leftChild = null;
			focusNode.rightChild = null;
		}
		
		root = null;
		balanceTree(0, nodeArray.size()-1, nodeArray);		
	}
}