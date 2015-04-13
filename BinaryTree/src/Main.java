import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{
			boolean inputLoop = true;
			boolean sameNode = false;
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
					
					newBinaryTree.addNode(numberInput);
				}
				
				else if (menuInput == 2)
				{
					System.out.print("Please enter the number you wish to remove: ");
					int numberInput = scan.nextInt();
					System.out.println();
					newBinaryTree.removeNode(numberInput);
				}
				
				else if (menuInput == 3)
				{
					System.out.print("Please type in the number you wish to find: ");
					int numberInput = scan.nextInt();
					System.out.println();
					System.out.println("The number " +numberInput+ " was found on level " +newBinaryTree.findNodeLevel(numberInput));
				}
				
				else if (menuInput == 4)
				{
					System.out.print("Tree: [ ");
					//newBinaryTree.fromBinaryTreeToArray(newBinaryTree, newBinaryTree.root);
					System.out.print(" ]");
					System.out.println();
					System.out.println();
				}
				
				else if (menuInput == 5)
				{
					System.out.print("The tree currently contains: ");
					newBinaryTree.inOrderTraversal(newBinaryTree.root);
					System.out.println();
				}
				
				else if (menuInput == 6)
				{
					System.out.println("Root value: " +newBinaryTree.root.number);
					System.out.println("Height of the tree: " +newBinaryTree.findHeightOfTree(newBinaryTree.root));
					System.out.println("Number of items in the tree: " +newBinaryTree.numberOfNodes(newBinaryTree.root));
					System.out.println();
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
	}

}