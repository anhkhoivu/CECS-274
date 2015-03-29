/* Anhkhoi Vu
 * Professor Steve Gold
 * Project 4 - Clock Solitaire
 * CECS 274
 * March 24, 2015
 */

import java.util.*;

public class Main 
{
	public static void main(String[] args) 
	{
		boolean inputLoop = true;
		Scanner scan = new Scanner(System.in);
		String temp;
		String[] deckString = new String [52];
		boolean deckCreation = false;
		boolean deckDealt = false;
		
		LinkedList Deck = new LinkedList();
		LinkedList ace = new LinkedList();
		LinkedList two = new LinkedList();
		LinkedList three = new LinkedList();
		LinkedList four = new LinkedList();
		LinkedList five = new LinkedList();
		LinkedList six = new LinkedList();
		LinkedList seven = new LinkedList();
		LinkedList eight = new LinkedList();
		LinkedList nine = new LinkedList();
		LinkedList ten = new LinkedList();
		LinkedList jack = new LinkedList();
		LinkedList queen = new LinkedList();
		LinkedList king = new LinkedList();
		
		System.out.println("Welcome to Clock Solitaire!");
		System.out.println();
		while(inputLoop)
		{
			System.out.println("Please select from the following menu: ");
			System.out.println("1. Create New Deck");
			System.out.println("2. Shuffle");
			System.out.println("3. Show Deck");
			System.out.println("4. Deal");
			System.out.println("5. Show Piles");
			System.out.println("6. Play Game");
			System.out.println("7. Exit");
			System.out.println();
			System.out.print("Selection: ");
			int option = scan.nextInt();
			
			if(option == 1)
			{	
				Deck = new LinkedList();
				
				String [] suits = {"D","S", "C", "H"};
				String [] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K"};

				int i = 0;
				for (int s = 0; s < 4; s++) 
				{
					for (int r = 0; r < 13; r++)
					{
						temp = ranks[r];
						StringBuffer cb = new StringBuffer(temp);
						cb.append(suits[s]);
						temp = cb.toString();
						Deck.add(temp, false);
						deckString[i++] = temp;
					}
				}
				
				System.out.println("New deck has been created!");
				System.out.println();
				
				ace = new LinkedList();
				two = new LinkedList();
				three = new LinkedList();
				four = new LinkedList();
				five = new LinkedList();
				six = new LinkedList();
				seven = new LinkedList();
				eight = new LinkedList();
				nine = new LinkedList();
				ten = new LinkedList();
				jack = new LinkedList();
				queen = new LinkedList();
				king = new LinkedList();
				
				deckCreation = true;
			}
			
			else if (option == 2)
			{
				if(deckCreation)
				{
				for (int i = 0; i < 1000; i++)
				{
					Random r = new Random();
					int whatever = r.nextInt(deckString.length);
					String tempCard = deckString[whatever];
					int yolo = r.nextInt(deckString.length);
					deckString[whatever] = deckString[yolo];
					deckString[yolo] = tempCard;
							
				}
				System.out.println("Deck has been shuffled!");
				System.out.println();
				
				Deck = new LinkedList(); //erases previous Deck to create new shuffled one
				
				for (int i = 0; i < 52; i++ )
				{  
					Deck.add(deckString[i], false);
				}
				}
				
				else
				{
					System.out.println("Please create a new deck before shuffling.");
					System.out.println();
				}
			}
			
			else if (option == 3)
			{
				if(deckCreation)
				{
				System.out.println();
				for(int i = 1; i < Deck.getSize() + 1; i++)
				{
					System.out.println("[ " +Deck.returnCard(i)+ " ]");
				}
				System.out.println();
				System.out.println("Deck has been displayed!");
				System.out.println();
				}
				
				else
				{
					System.out.println("Please create a new deck before displaying.");
					System.out.println();
				}
			}
			
			else if (option == 4)
			{
				if(deckCreation)
				{
				int cardIndex = 1;
				for (int i = 0; i < 4; i++)
				{
					ace.add(Deck.returnCard(cardIndex++), false);
					two.add(Deck.returnCard(cardIndex++), false);
					three.add(Deck.returnCard(cardIndex++), false);
					four.add(Deck.returnCard(cardIndex++), false);
					five.add(Deck.returnCard(cardIndex++), false);
					six.add(Deck.returnCard(cardIndex++), false);
					seven.add(Deck.returnCard(cardIndex++), false);
					eight.add(Deck.returnCard(cardIndex++), false);
					nine.add(Deck.returnCard(cardIndex++), false);
					ten.add(Deck.returnCard(cardIndex++), false);
					jack.add(Deck.returnCard(cardIndex++), false);
					queen.add(Deck.returnCard(cardIndex++), false);
					king.add(Deck.returnCard(cardIndex++), false);
				}
				
				System.out.println("Deck has been dealt.");
				System.out.println();
				deckDealt = true;
				}
				
				else
				{
					System.out.println("Please create a new deck before dealing.");
					System.out.println();
				}
			}
			
			else if (option == 5)
			{
				if(deckCreation && deckDealt)
				{
				System.out.print("Pile 1 : ");
				for (int i = 1; i < ace.getSize() + 1; i++)
				{
					System.out.print("[ " +ace.returnCard(i) + " ] " );
				}
				
				System.out.print("\nPile 2 : ");
				for (int i = 1; i < two.getSize() + 1; i++)
				{
					System.out.print("[ " +two.returnCard(i) + " ] " );
				}
				
				System.out.print("\nPile 3 : ");
				for (int i = 1; i < three.getSize() + 1; i++)
				{
					System.out.print("[ " +three.returnCard(i) + " ] " );
				}
				
				System.out.print("\nPile 4 : ");
				for (int i = 1; i < four.getSize() + 1; i++)
				{
					System.out.print("[ " +four.returnCard(i) + " ] " );
				}
				
				System.out.print("\nPile 5 : ");
				for (int i = 1; i < five.getSize() + 1; i++)
				{
					System.out.print("[ " +five.returnCard(i) + " ] " );
				}
				
				System.out.print("\nPile 6 : ");
				
				for (int i = 1; i < six.getSize() + 1; i++)
				{
					System.out.print("[ " +six.returnCard(i) + " ] " );
				}
				
				System.out.print("\nPile 7 : ");
				for (int i = 1; i < seven.getSize() + 1; i++)
				{
					System.out.print("[ " +seven.returnCard(i) + " ] " );
				}
				
				System.out.print("\nPile 8 : ");
				for (int i = 1; i < eight.getSize() + 1; i++)
				{
					System.out.print("[ " +eight.returnCard(i) + " ] " );
				}
				
				System.out.print("\nPile 9 : ");
				for (int i = 1; i < nine.getSize() + 1; i++)
				{
					System.out.print("[ " +nine.returnCard(i) + " ] " );
				}
				
				System.out.print("\nPile 10: ");
				for (int i = 1; i < ten.getSize() + 1; i++)
				{
					System.out.print("[ " +ten.returnCard(i) + " ] " );
				}
				
				System.out.print("\nPile 11: ");
				for (int i = 1; i < jack.getSize() + 1; i++)
				{
					System.out.print("[ " +jack.returnCard(i) + " ] " );
				}
				
				System.out.print("\nPile 12: ");
				for (int i = 1; i < queen.getSize() + 1; i++)
				{
					System.out.print("[ " +queen.returnCard(i) + " ] " );
				}
				
				System.out.print("\nPile 13: ");
				for (int i = 1; i < king.getSize() + 1; i++)
				{
					System.out.print("[ " +king.returnCard(i) + " ] " );
				}
				System.out.println();
				System.out.println();
				}
				
				else
				{
					System.out.println("Please create a new deck and deal the deck before displaying the piles. ");
					System.out.println();
				}
			}
			
			else if (option == 6)
			{
				if(deckCreation && deckDealt)
				{
				System.out.print("Pile 1 : ");
				for (int i = 1; i < ace.getSize() + 1; i++)
				{
					System.out.print("[ " + "**" + " ]" + "\t");
				}
				
				System.out.print("\nPile 2 : ");
				for (int i = 1; i < two.getSize() + 1; i++)
				{
					System.out.print("[ " + "**" + " ]" + "\t");
				}
				
				System.out.print("\nPile 3 : ");
				for (int i = 1; i < three.getSize() + 1; i++)
				{
					System.out.print("[ " + "**" + " ]" + "\t");
				}
				System.out.print("\nPile 4 : ");
				for (int i = 1; i < four.getSize() + 1; i++)
				{
					System.out.print("[ " + "**" + " ]" + "\t");
				}
				System.out.print("\nPile 5 : ");
				for (int i = 1; i < five.getSize() + 1; i++)
				{
					System.out.print("[ " + "**" + " ]" + "\t");
				}
				System.out.print("\nPile 6 : ");
				for (int i = 1; i < six.getSize() + 1; i++)
				{
					System.out.print("[ " + "**" + " ]" + "\t");
				}
				System.out.print("\nPile 7 : ");
				for (int i = 1; i < seven.getSize() + 1; i++)
				{
					System.out.print("[ " + "**" + " ]" + "\t");
				}
				System.out.print("\nPile 8 : ");
				for (int i = 1; i < eight.getSize() + 1; i++)
				{
					System.out.print("[ " + "**" + " ]" + "\t");
				}
				System.out.print("\nPile 9 : ");
				for (int i = 1; i < nine.getSize() + 1; i++)
				{
					System.out.print("[ " + "**" + " ]" + "\t");
				}
				System.out.print("\nPile 10: ");
				for (int i = 1; i < ten.getSize() + 1; i++){
					System.out.print("[ " + "**" + " ]" + "\t");
				}
				System.out.print("\nPile 11: ");
				for (int i = 1; i < jack.getSize() + 1; i++){
					System.out.print("[ " + "**" + " ]" + "\t");
				}
				System.out.print("\nPile 12: ");
				for (int i = 1; i < queen.getSize() + 1; i++)
				{
					System.out.print("[ " + "**" + " ]" + "\t");
				}
				
				System.out.print("\nPile 13: ");
				for (int i = 1; i < king.getSize() + 1; i++)
				{
					System.out.print("[ " + "**" + " ]" + "\t");
				}
				
				System.out.println(" ");
				
				boolean run = true;
				
				boolean acesPileVisible = false;
				boolean twosPileVisible = false;
				boolean threesPileVisible = false;
				boolean foursPileVisible = false;
				boolean fivesPileVisible = false;
				boolean sixesPileVisible = false;
				boolean sevensPileVisible = false;
				boolean eightsPileVisible = false;
				boolean ninesPileVisible = false;
				boolean tensPileVisible = false;
				boolean jacksPileVisible = false;
				boolean queensPileVisible = false;
				boolean kingsPileVisible = false;
				
				String movingCard;
				movingCard = king.returnCard(4);
				while(run)
				{		
					if (movingCard.startsWith("A"))
					{
						ace.add(movingCard, true);
						movingCard = ace.returnCard(1);
						ace.remove(1);
					}
					
					else if (movingCard.startsWith("2"))
					{
						two.add(movingCard, true);
						movingCard = two.returnCard(1);
						two.remove(1);
					}
					
					else if (movingCard.startsWith("3"))
					{
						three.add(movingCard, true);
						movingCard = three.returnCard(1);
						three.remove(1);
					}
					
					else if (movingCard.startsWith("4"))
					{
						four.add(movingCard, true);
						movingCard = four.returnCard(1);
						four.remove(1);
					}
					
					else if (movingCard.startsWith("5"))
					{
						five.add(movingCard, true);
						movingCard = five.returnCard(1);
						five.remove(1);
					}
					
					else if (movingCard.startsWith("6"))
					{
						six.add(movingCard, true);
						movingCard = six.returnCard(1);
						six.remove(1);
					}
					
					else if (movingCard.startsWith("7"))
					{
						seven.add(movingCard, true);
						movingCard = seven.returnCard(1);
						seven.remove(1);
					}
					
					else if (movingCard.startsWith("8"))
					{
						eight.add(movingCard, true);
						movingCard = eight.returnCard(1);
						eight.remove(1);
					}
					
					else if (movingCard.startsWith("9"))
					{
						nine.add(movingCard, true);
						movingCard = nine.returnCard(1);
						nine.remove(1);
					}
					
					else if (movingCard.startsWith("T"))
					{
						ten.add(movingCard, true);
						movingCard = ten.returnCard(1);
						ten.remove(1);
					}
					
					else if (movingCard.startsWith("J"))
					{
						jack.add(movingCard, true);
						movingCard = jack.returnCard(1);
						jack.remove(1);
					}
					
					else if (movingCard.startsWith("Q"))
					{
						queen.add(movingCard, true);
						movingCard = queen.returnCard(1);
						queen.remove(1);
					}
					
					else if (movingCard.startsWith("K"))
					{
						king.add(movingCard, true);
						movingCard = king.returnCard(1);
						king.remove(1);
					}
					
					boolean printLoop = true;
					
					System.out.println(" ");
					System.out.print("Pile 1 : ");
					while(printLoop)
					{
						for (int i = 1; i < ace.getSize() + 1; i++)
						{
							if (ace.returnShow(i) == true)
							{
								System.out.print("[ " + ace.returnCard(i) + " ]" + "\t" );
							}
							
							else
							{
								System.out.print("[ " + "**" + " ]" + "\t");
							}
						}
						
						System.out.print("\nPile 2 : ");
						for (int i = 1; i < two.getSize() + 1; i++)
						{
							if (two.returnShow(i) == true)
							{
								System.out.print("[ " +two.returnCard(i)+ " ]" + "\t" );
							}
							
							else
							{
								System.out.print("[ " + "**" + " ]" + "\t");
							}
						}
					
						System.out.print("\nPile 3 : ");
						for (int i = 1; i < three.getSize() + 1; i++)
						{
							if (three.returnShow(i) == true)
							{
								System.out.print("[ " +three.returnCard(i)+ " ]" + "\t" );
							}
							
							else
							{
								System.out.print("[ " + "**" + " ]" + "\t");
							}
						}
					
						System.out.print("\nPile 4 : ");
						for (int i = 1; i < four.getSize() + 1; i++)
						{
							if (four.returnShow(i) == true)
							{
								System.out.print("[ " +four.returnCard(i)+ " ]" + "\t" );
							}
							
							else
							{
								System.out.print("[ " + "**" + " ]" + "\t");
							}
						}
					
						System.out.print("\nPile 5 : ");
						for (int i = 1; i < five.getSize() + 1; i++)
						{
							if (five.returnShow(i) == true)
							{
								System.out.print("[ " +five.returnCard(i)+ " ]" + "\t" );
							}
							
							else
							{
								System.out.print("[ " + "**" + " ]" + "\t");
							}
						}
						
						System.out.print("\nPile 6 : ");
						for (int i = 1; i < six.getSize() + 1; i++)
						{
							if (six.returnShow(i) == true)
							{
								System.out.print("[ " +six.returnCard(i)+ " ]" + "\t" );
							}
							else
							{
								System.out.print("[ " + "**" + " ]" + "\t");
							}
						}
						
						System.out.print("\nPile 7 : ");
						for (int i = 1; i < seven.getSize() + 1; i++)
						{
							if (seven.returnShow(i) == true)
							{
								System.out.print("[ " +seven.returnCard(i)+ " ]" + "\t" );
							}
							else
							{
								System.out.print("[ " + "**" + " ]" + "\t");
							}
						}
					
						System.out.print("\nPile 8 : ");
						for (int i = 1; i < eight.getSize() + 1; i++)
						{
							if (eight.returnShow(i) == true)
							{
								System.out.print("[ " +eight.returnCard(i)+ " ]"  + "\t" );
							}
							
							else
							{
								System.out.print("[ " + "**" + " ]" + "\t");
							}
						}
						
						System.out.print("\nPile 9 : ");
						for (int i = 1; i < nine.getSize() + 1; i++)
						{
							if (nine.returnShow(i) == true)
							{
								System.out.print("[ " +nine.returnCard(i)+ " ]"  + "\t" );
							}
							else
							{
								System.out.print("[ " + "**" + " ]" + "\t");
							}
						}
						
						System.out.print("\nPile 10: ");
						for (int i = 1; i < ten.getSize() + 1; i++)
						{
							if (ten.returnShow(i) == true)
							{
								System.out.print("[ " +ten.returnCard(i)+ " ]" + "\t" );
							}
							
							else
							{
								System.out.print("[ " + "**" + " ]" + "\t");
							}
						}
	
						System.out.print("\nPile 11: ");
						for (int i = 1; i < jack.getSize() + 1; i++)
						{
							if (jack.returnShow(i) == true)
							{
								System.out.print("[ " +jack.returnCard(i)+ " ]" + "\t" );
							}
							else
							{
								System.out.print("[ " + "**" + " ]" + "\t");
							}
						}
						
						System.out.print("\nPile 12: ");
						for (int i = 1; i < queen.getSize() + 1; i++)
						{
							if (queen.returnShow(i) == true)
							{
								System.out.print("[ " +queen.returnCard(i)+ " ]" + "\t" );
							}
							else
							{
								System.out.print("[ " + "**" + " ]" + "\t");
							}
						}
						
						System.out.print("\nPile 13: ");
						for (int i = 1; i < king.getSize() + 1; i++)
						{
							if (king.returnShow(i) == true)
							{
								System.out.print("[ " +king.returnCard(i)+ " ]" + "\t" );
							}
							else
							{
								System.out.print("[ " + "**" + " ]" + "\t");
							}
						}
						printLoop =  false;
					}
				
				
					String aceCard = ace.returnCard(1);
					String aceCard2 = ace.returnCard(2);
					String aceCard3 = ace.returnCard(3);
					String aceCard4 = ace.returnCard(4);
					
					if ((ace.returnShow(1) == true && aceCard.startsWith("A")) && 
						(ace.returnShow(2) == true && aceCard2.startsWith("A")) && 
						(ace.returnShow(3) == true && aceCard3.startsWith("A")) && 
						(ace.returnShow(4) == true && aceCard4.startsWith("A")))
					{
						acesPileVisible = true;
					}
					

					String twoCard = two.returnCard(1);
					String twoCard2 = two.returnCard(2);
					String twoCard3 = two.returnCard(3);
					String twoCard4 = two.returnCard(4);
					
					if ((two.returnShow(1) == true && twoCard.startsWith("2")) && 
						(two.returnShow(2) == true && twoCard2.startsWith("2")) && 
						(two.returnShow(3) == true && twoCard3.startsWith("2")) && 
						(two.returnShow(4) == true && twoCard4.startsWith("2")))
					{
						twosPileVisible = true;
					}
					
					String threeCard = three.returnCard(1);
					String threeCard2 = three.returnCard(2);
					String threeCard3 = three.returnCard(3);
					String threeCard4 = three.returnCard(4);
					
					if ((three.returnShow(1) == true && threeCard.startsWith("3")) && 
						(three.returnShow(2) == true && threeCard2.startsWith("3")) && 
						(three.returnShow(3) == true && threeCard3.startsWith("3")) && 
						(three.returnShow(4) == true && threeCard4.startsWith("3")))
					{
						threesPileVisible = true;
					}
					
					
					String fourCard = four.returnCard(1);
					String fourCard2 = four.returnCard(2);
					String fourCard3 = four.returnCard(3);
					String fourCard4 = four.returnCard(4);
					
					if ((four.returnShow(1) == true && fourCard.startsWith("4")) && 
						(four.returnShow(2) == true && fourCard2.startsWith("4")) && 
						(four.returnShow(3) == true && fourCard3.startsWith("4")) && 
						(four.returnShow(4) == true && fourCard4.startsWith("4")))
					{
						foursPileVisible = true;
					}
					
					
					String fiveCard = five.returnCard(1);
					String fiveCard2 = five.returnCard(2);
					String fiveCard3 = five.returnCard(3);
					String fiveCard4 = five.returnCard(4);
					
					if ((five.returnShow(1) == true && fiveCard.startsWith("5")) && 
						(five.returnShow(2) == true && fiveCard2.startsWith("5")) && 
						(five.returnShow(3) == true && fiveCard3.startsWith("5")) && 
						(five.returnShow(4) == true && fiveCard4.startsWith("5")))
					{
						fivesPileVisible = true;
					}
					
					String sixCard = six.returnCard(1);
					String sixCard2 = six.returnCard(2);
					String sixCard3 = six.returnCard(3);
					String sixCard4 = six.returnCard(4);
					
					if ((six.returnShow(1) == true && sixCard.startsWith("6")) && 
						(six.returnShow(2) == true && sixCard2.startsWith("6")) && 
						(six.returnShow(3) == true && sixCard3.startsWith("6")) && 
						(six.returnShow(4) == true && sixCard4.startsWith("6")))
					{
						sixesPileVisible = true;
					}
					
					String sevenCard = seven.returnCard(1);
					String sevenCard2 = seven.returnCard(2);
					String sevenCard3 = seven.returnCard(3);
					String sevenCard4 = seven.returnCard(4);
					
					if ((seven.returnShow(1) == true && sevenCard.startsWith("7")) && 
						(seven.returnShow(2) == true && sevenCard2.startsWith("7")) && 
						(seven.returnShow(3) == true && sevenCard3.startsWith("7")) && 
						(seven.returnShow(4) == true && sevenCard4.startsWith("7")))
					{
						sevensPileVisible = true;
					}
					
					String eightCard = eight.returnCard(1);
					String eightCard2 = eight.returnCard(2);
					String eightCard3 = eight.returnCard(3);
					String eightCard4 = eight.returnCard(4);
					
					if ((eight.returnShow(1) == true && eightCard.startsWith("8")) && 
						(eight.returnShow(2) == true && eightCard2.startsWith("8")) && 
						(eight.returnShow(3) == true && eightCard3.startsWith("8")) && 
						(eight.returnShow(4) == true && eightCard4.startsWith("8")))
					{
						eightsPileVisible = true;
					}
					
					String nineCard = nine.returnCard(1);
					String nineCard2 = nine.returnCard(2);
					String nineCard3 = nine.returnCard(3);
					String nineCard4 = nine.returnCard(4);
					
					if ((nine.returnShow(1) == true && nineCard.startsWith("9")) && 
						(nine.returnShow(2) == true && nineCard2.startsWith("9")) && 
						(nine.returnShow(3) == true && nineCard3.startsWith("9")) && 
						(nine.returnShow(4) == true && nineCard4.startsWith("9")))
					{
						ninesPileVisible = true;
					}
					
					String tensCard = ten.returnCard(1);
					String tensCard2 = ten.returnCard(2);
					String tensCard3 = ten.returnCard(3);
					String tensCard4 = ten.returnCard(4);
					
					if ((ten.returnShow(1) == true && tensCard.startsWith("T")) && 
						(ten.returnShow(2) == true && tensCard2.startsWith("T")) && 
						(ten.returnShow(3) == true && tensCard3.startsWith("T")) && 
						(ten.returnShow(4) == true && tensCard4.startsWith("T")))
					{
						tensPileVisible = true;
					}
					
					
					String jackCard = jack.returnCard(1);
					String jackCard2 = jack.returnCard(2);
					String jackCard3 = jack.returnCard(3);
					String jackCard4 = jack.returnCard(4);
					
					if ((jack.returnShow(1) == true && jackCard.startsWith("J")) && 
						(jack.returnShow(2) == true && jackCard2.startsWith("J")) && 
						(jack.returnShow(3) == true && jackCard3.startsWith("J")) && 
						(jack.returnShow(4) == true && jackCard4.startsWith("J")))
					{
						jacksPileVisible = true;
					}
					
					
					String queenCard = queen.returnCard(1);
					String queenCard2 = queen.returnCard(2);
					String queenCard3 = queen.returnCard(3);
					String queenCard4 = queen.returnCard(4);
					
					if ((queen.returnShow(1) == true && queenCard.startsWith("Q")) && 
						(queen.returnShow(2) == true && queenCard2.startsWith("Q")) && 
						(queen.returnShow(3) == true && queenCard3.startsWith("Q")) && 
						(queen.returnShow(4) == true && queenCard4.startsWith("Q")))
					{
						queensPileVisible = true;
					}
					
					String kingCard = king.returnCard(1);
					String kingCard2 = king.returnCard(2);
					String kingCard3 = king.returnCard(3);
					String kingCard4 = king.returnCard(4);
					
					if ((king.returnShow(1) == true && kingCard.startsWith("K")) && 
						(king.returnShow(2) == true && kingCard2.startsWith("K")) && 
						(king.returnShow(3) == true && kingCard3.startsWith("K")) && 
						(king.returnShow(4) == true && kingCard4.startsWith("K")))
					{
						kingsPileVisible = true;
					}
					
					if (acesPileVisible && twosPileVisible  && threesPileVisible  && foursPileVisible &&
					   fivesPileVisible && sixesPileVisible && sevensPileVisible && eightsPileVisible && 
					   ninesPileVisible && tensPileVisible  && jacksPileVisible  && queensPileVisible && kingsPileVisible)
					{
						System.out.println();
						System.out.println();
						System.out.println("You win!");
						run = false;
					}
					
					else if (kingsPileVisible && run)
					{
						System.out.println();
						System.out.println();
						System.out.println("You lost!");
						run = false;
					}
			
				
					System.out.println(" ");
				}
				}
				else
				{
					System.out.println("Please create a new deck and deal the deck before playing.");
					System.out.println();
				}
			}
			
			else if (option == 7)
			{
				inputLoop = false;
				System.out.println("Goodbye! Thank you for playing Clock Solitaire!");
				scan.close();
			}
			
			else
			{
				System.out.println("Invalid option. Please enter a number between 1 and 7.");
				inputLoop = true;
			}
		}	
		
	}
}
