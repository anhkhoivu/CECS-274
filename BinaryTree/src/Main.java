import java.util.*;

public class Main 
{
	public static void main(String[] args) 
	{
		boolean inputLoop = true;
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
			
			if (menuInput == 1)
			{
				inputLoop = true;
			}
			
			else if (menuInput == 2)
			{
				inputLoop = true;
			}
			
			else if (menuInput == 3)
			{
				inputLoop = true;
			}
			
			else if (menuInput == 4)
			{
				inputLoop = true;
			}
			
			else if (menuInput == 5)
			{
				inputLoop = true;
			}
			
			else if (menuInput == 6)
			{
				inputLoop = true;
			}
			
			else if (menuInput == 7)
			{
				inputLoop = false;
				System.out.println("Goodbye!");
			}
			
			else
			{
				System.out.println("Please enter an integer between 1 and 7.");
				System.out.println();
			}
		}

	}

}
