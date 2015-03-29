import java.util.*;

public class Main 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		boolean loop = true;
		boolean inputLoop = false;
		boolean Happy = false;
		Scanner scan = new Scanner(System.in);
		int inputNumber = 0;
		ArrayList<Integer> number = new ArrayList<Integer>();
		while(loop)
		{
			while (!inputLoop)
			{
				System.out.print("Enter a positive integer: ");
				inputNumber = scan.nextInt();
				if (inputNumber > 0)
				{	
					System.out.println("Input: " +inputNumber);
					System.out.print("Output: " +inputNumber);
					
					number.add(inputNumber);
					int recursiveResult = recursiveProcess(inputNumber);
					
					while(!Happy)
					{
						System.out.print(", " + recursiveResult);
						for (int i = 0; i < number.size(); i++)
						{
							if (number.contains(recursiveResult) && recursiveResult != 1)
							{
								System.out.println();
								System.out.println(+inputNumber + " is NOT a happy number.");
								Happy = true;
								inputLoop = true;
								loop = false;
								break;
							}
						}
						
						if (recursiveResult == 1)
						{
							System.out.println();
							System.out.println(+inputNumber + " is a happy number.");
							Happy = true;
							inputLoop = true;
							loop = false;
							break;
						}
						
						
						number.add(recursiveResult);
						recursiveResult = recursiveProcess(recursiveResult);
						
					}	
				}
				
				else
				{
					System.out.println("Please enter a positive integer.");
					inputLoop = false;
				}
			}
		}
		scan.close();
		System.exit(0);
	}

	public static int recursiveProcess(int x)
	{
		if (x == 0)
		{
			return 0;
		}
		
		else
		{
			int remainder = x % 10;
			return ((remainder * remainder) + recursiveProcess(x/10));
		}
	}
}
