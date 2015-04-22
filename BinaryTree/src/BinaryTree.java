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
			return 1 + Math.max(findHeightOfTree(focusNode.leftChild), findHeightOfTree(focusNode.rightChild));
		}

	}
	
	public boolean removeNode(int number)
	{
		Node currentNode = root;
		Node parentNode = root;
		
		while(currentNode.number != number)
		{
			parentNode = currentNode;
			
			if(number < currentNode.number)
			{
				currentNode = currentNode.leftChild;
			}
			else
			{
				currentNode = currentNode.rightChild;
			}
			
			if(currentNode == null)
			{
				return false;
			}
		}//end while
		
		//no children
		if (currentNode.leftChild == null && currentNode.rightChild == null)
		{
			if(currentNode == root)//if is a root
			{
					root = null;
			}
			else if (currentNode == parentNode.leftChild)
			{
				parentNode.leftChild = null; //delete node
			}
			else
			{
				parentNode.rightChild = null;
			}
		}
		
		//no right child
		else if (currentNode.rightChild ==null)
		{
			//delete node is root and root does  not have right child
			//then root's left child becomes root
			if(currentNode == root)
			{
				root = currentNode.leftChild;
			}
			else if(currentNode == parentNode.leftChild)
			{
				parentNode.leftChild = currentNode.leftChild;
			}
			else
			{
				parentNode.rightChild = currentNode.rightChild;
			}
		}
		else if (currentNode.leftChild == null)
		{
			if(currentNode == root)
			{
				root = currentNode.rightChild;
			}
			else if(currentNode == parentNode.leftChild)
			{
				parentNode.leftChild = currentNode.rightChild;
			}
			else
			{
				parentNode.rightChild = currentNode.leftChild;
			}
			
		}
	
		//has 2 children
		else  
		{
			Node replaceNode = getReplacementNode(currentNode);
			
			if(currentNode == root)
			{
				root = replaceNode;
			}
			else if (currentNode == parentNode.leftChild)
			{
				parentNode.leftChild = replaceNode;
			}
			else
			{
				parentNode.rightChild = replaceNode;
			}
			
			replaceNode.leftChild = currentNode.leftChild;
		}
		
		return true;	
	}	

	public Node getReplacementNode(Node replacedNode)
	{
		Node currentNode = replacedNode.rightChild;
		Node replacement = replacedNode;
		Node replaceParent = replacedNode;
		
		while (currentNode !=null)
		{
			replaceParent =replacement;
			replacement = currentNode;
			currentNode = currentNode.leftChild;
		}
		
		if(replacement !=replacedNode.rightChild)
		{
			replaceParent.leftChild= replacement.rightChild;
			replacement.rightChild = replacedNode.rightChild;
		}
		return replacement;
	}
	
	public void balanceTree(int min, int max, ArrayList<Node> nodeArray)
	{
		if(min <= max)
		{
			int median = (int) Math.ceil( ( (double) min + max) / 2);
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