/* Anhkhoi Vu
 * CECS 274
 * Program 2 - Linked Lists
 * February 24, 2015
 */
import java.util.*;

public class Main 
{
	public static void main(String[] args) 
	{
		boolean inputLoop = false;
		boolean exit = false;
		Scanner scan = new Scanner(System.in);
		while (!exit)
		{
			System.out.print("************************************************************************************\n");
			System.out.print("*                                                                                  *\n");
			System.out.print("*                   WELCOME TO THE WORDS GENERATOR PROGRAM                         *\n");
			System.out.print("*        This program will generate a number of 5-characters words randomly        * \n");
			System.out.print("*                                                                                  *\n");
			System.out.print("************************************************************************************\n");
			System.out.println();
		while (inputLoop == false)
		{
			System.out.println("Please input how many words, between 15 and 240 words, that you would like to see.");
			int numberOfWords = scan.nextInt();
			
			if (numberOfWords < 15 || numberOfWords > 240)
			{
				System.out.println("Please input a valid integer.");
				System.out.println(" ");
				inputLoop = false;
			}
			
			else
			{
				LinkedList linkedList = new LinkedList();
				String [] arrayOfWords = linkedList.wordGenerator(numberOfWords);
				Arrays.sort(arrayOfWords);
				
				//put sorted words to linked list	
				linkedList.fromArraysToLinkedList(arrayOfWords);
			 
				linkedList.displayWords(null);
				
				boolean selection = false;
				while (!selection)
				{
					System.out.println();
					System.out.println("Please enter one of the 3 options below by entering its letter");
					System.out.println("A(Add)\t" + "D(Delete)\t"+ "Q(Quit)");
					String inputSelection = scan.next();
					
					if( inputSelection.equalsIgnoreCase("A") )
					{
						String[] newWord = linkedList.wordGenerator(1);
						
						//add new node with new word in the list
						linkedList.addNode(newWord [0]);
						
						//copy unsorted linked list with new node into array
						String[] updatedArray = linkedList.fromLinkedListToArrays(linkedList);
							
						//sort array
						Arrays.sort(updatedArray);
						
						//copy sorted array to a new linked list with new word
						linkedList = new LinkedList();
	
						
						linkedList.fromArraysToLinkedList(updatedArray);
						
					    //display new word
					    System.out.println("The new word is indicated in the list by the asterik. (*)");
					 
					    //display words
					    linkedList.displayWords(newWord[0]);
																
					}
					
					else if( inputSelection.equalsIgnoreCase("D") ) 				
					{
						boolean deleteInput = false;
						while (!deleteInput)
						{
							System.out.println("Please enter the word you want to delete. If it is the newly added word, do NOT enter the asterick(*) with it.\n");
							String deleteWord = scan.next();
							
							int nodeIndex = linkedList.getNodeIndex(deleteWord);
							if(nodeIndex>0)
							{
								linkedList.removeNode(nodeIndex);
								linkedList.displayWords(null);
								deleteInput = true;
								selection = false;
							}
							
							else
							{
								System.out.println("The word is NOT in the list.");
								deleteInput = false;
							}	
						}								
					}
			
			
					else if( inputSelection.equalsIgnoreCase("Q") )
					{
						exit = true;
						System.out.println("Thank you for using my program! Goodbye!");
						System.exit(0);
								
					}
					else // error message if user does not selection A,D, or Q
					{
						System.out.print("Your selection is incorrect. \n");
						selection = false;
					}								
				
			}
			}
			
			
							
			}//while selection	

		}// input in the range
		scan.close();

		
		//System.out.println("Input: " +numberOfWords);
	}
		
}

