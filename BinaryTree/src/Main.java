/* Anhkhoi Vu
 * Program 5 - Binary Tree
 * CECS 274
 * Professor Steve Gold
 */

import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{
			boolean inputLoop = true;
			boolean sameNode = false;
			boolean isEmpty = true;
			BinaryTree newBinaryTree = new BinaryTree();
			Scanner scan = new Scanner(System.in);
			System.out.println("Welcome to the Binary Tree Program!");
			while(inputLoop)
			{
				
				System.out.println("Please select an option from the following: " );
				System.out.println("1. Add item to tree");
				System.out.println("2. Delete item from tree");
				System.out.println("3. Find item");
				System.out.println("4. Balance tree");
				System.out.println("5. List contents of the tree");
				System.out.println("6. Display statistics of the tree");
				System.out.println("7. Exit");
				System.out.println();
				System.out.print("Selection: ");
				int menuInput = scan.nextInt();
				System.out.println();
				
				if (menuInput == 1)
				{
					System.out.print("Please add a number to the tree: ");
					int numberInput = scan.nextInt();
					System.out.println();
					
					if(newBinaryTree.duplicateNode(numberInput))
					{
						System.out.println("Please enter an integer not already on the list.");
					}
					
					else
					{
						newBinaryTree.addNode(numberInput);
						isEmpty = false;
					}
				}
				
				else if (menuInput == 2)
				{
					if(isEmpty)
					{
						System.out.println("Please add an item to the tree before removing an item.");
						System.out.println();
					}
					
					else
					{
						System.out.print("Please enter the number you wish to remove: ");
						int numberInput = scan.nextInt();
						System.out.println();
						newBinaryTree.removeNode(numberInput);
					}
				}
				
				else if (menuInput == 3)
				{
					if(isEmpty)
					{
						System.out.println("Please add an item to the tree before finding an item.");
						System.out.println();
					}
					
					else
					{
						System.out.print("Please type in the number you wish to find: ");
						int numberInput = scan.nextInt();
						System.out.println();
						System.out.println("The number " +numberInput+ " was found on level " +newBinaryTree.findNodeLevel(numberInput));
					}
				}
				
				else if (menuInput == 4)
				{
					if(isEmpty)
					{
						System.out.println("Please add an item to the tree before balancing a tree.");
						System.out.println();
					}	
					
					else
					{
						newBinaryTree.balanceTree();
		                System.out.println("The tree is now balanced!");
		                System.out.println("Left subtree:");
		                newBinaryTree.inOrderTraversal(newBinaryTree.root.leftChild);
		                System.out.println();
		                System.out.println("Right subtree:");
		                newBinaryTree.inOrderTraversal(newBinaryTree.root.rightChild);
						System.out.println();
						System.out.println();
					}
				}
				
				else if (menuInput == 5)
				{
					if(isEmpty)
					{
						System.out.println("Empty tree.");
						System.out.println();
					}
					else
					{
						System.out.print("The tree currently contains: ");
						newBinaryTree.inOrderTraversal(newBinaryTree.root);
						System.out.println();
					}
				}
				
				else if (menuInput == 6)
				{
					if(isEmpty)
					{
						System.out.println("Please add an item to the tree before displaying the statistics of the tree.");
						System.out.println();
					}
					
					else
					{
						System.out.println("Root value: " +newBinaryTree.root.number);
						System.out.println("Height of the tree: " +newBinaryTree.findHeightOfTree(newBinaryTree.root));
						System.out.println("Number of items in the tree: " +newBinaryTree.numberOfNodes(newBinaryTree.root));
						System.out.println();
					}
				}
				
				else if (menuInput == 7)
				{
					inputLoop = false;
					System.out.println("Thank you for using my program!");
				}
				
				else
				{
					System.out.println("Please enter an integer between 1 and 7.");
					System.out.println();
				}
			}
			scan.close();
			System.exit(0);
	}
}