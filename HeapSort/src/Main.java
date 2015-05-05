import java.util.Scanner;


public class Main 
{
	public static void main(String[] args)
	{
		BinaryTree bst = new BinaryTree();
		
		
		System.out.print("************************************************************************************\n");
		System.out.print("*                    Welcome to the Heap Sort Program!                             *\n");
		System.out.print("************************************************************************************\n");
		System.out.println();
		System.out.println();
			
		bst.createBinaryTree();
		bst.getRandomNumbers();
		bst.displayTree();
		
		System.out.println();
		System.out.println("Press Enter to continue...");
		Scanner keyboard = new Scanner(System.in);
		keyboard.nextLine();
		
		System.out.println(" Start building a Heap.... \n");
		bst.heapSort(); 
	
			
		
		
		System.exit(0);
	

	}
}
