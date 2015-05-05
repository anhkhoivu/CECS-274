import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BinaryTree 
{

	TreeNode root;
	int max = 99;
	int min = 10;
	TreeNode[] nodeArray = new TreeNode[32];	
	int N = nodeArray.length-1;
	
	public void createBinaryTree()
	{
		for (int i = 1; i<32; i++)
		{
			TreeNode newNode = new TreeNode(0);	
			nodeArray[i] = newNode;
		}					
	}
	
	public void getRandomNumbers()
	{
		Random rand = new Random();
		boolean done = false;
		ArrayList<Integer> intList = new ArrayList<Integer>();
		int arraysize = 0;
		
		while(done == false)
		{	
			boolean isDuplicated = false;
			
			if(intList.size() ==0)
			{
				int randomNumber = rand.nextInt(max- min +1) + min;
				
				intList.add(randomNumber);
				System.out.println("First number: "+ randomNumber);
			}

			int randomNumber = rand.nextInt(max - min +1) + min;

			for (int i=0; i<intList.size(); i++)
			{
				if(intList.get(i).intValue()==randomNumber)
				{
					isDuplicated = true;
					break;
				}
			}
			
			if (isDuplicated == false)
			{
				intList.add(randomNumber);		
				System.out.println("New number: "+ randomNumber);
			}
			
			arraysize = intList.size();
		
			if (arraysize  == 31)
			{
					done = true;
			}
			
		}

		for (int j = 0; j<intList.size(); j++)
		{
			nodeArray[j+1].value = intList.get(j);			
		}
	}
	
	public void displayTree()
	{
		System.out.println();
		System.out.println("                                                         "+ nodeArray[1].value);
		System.out.println("                                                          |");
		System.out.println("                                  "+ nodeArray[2].value + "----------------------^----------------------" + nodeArray[3].value);      
		System.out.println("                                  |                                               |");
		System.out.println("                      "+ nodeArray[4].value + "----------^----------" + nodeArray[5].value+"                        "+ nodeArray[6].value + "----------^----------" + nodeArray[7].value);
		System.out.println("                      |                       |                         |                      |");
		System.out.println("               "+ nodeArray[8].value + "-----^-----" + nodeArray[9].value+"         "+ nodeArray[10].value + "-----^-----" + nodeArray[11].value +"           "+ nodeArray[12].value + "-----^-----" + nodeArray[13].value+ "        " +nodeArray[14].value + "-----^-----" + nodeArray[15].value);
		System.out.println("               |            |          |            |            |            |          |            |");
		System.out.println("           "+ nodeArray[16].value + "--^--" + nodeArray[17].value+"    "+ nodeArray[18].value + "--^--" + nodeArray[19].value+"  "+ nodeArray[20].value + "--^--"+nodeArray[21].value+"    "+
										+nodeArray[22].value + "--^--" + nodeArray[23].value+"    "+ nodeArray[24].value + "--^--" + nodeArray[25].value+"    "+ nodeArray[26].value + "--^--"+nodeArray[27].value+"  "+
										+nodeArray[28].value + "--^--" + nodeArray[29].value+"    "+ nodeArray[30].value + "--^--" + nodeArray[31].value);
										
	}
	
    public void swap(TreeNode ni, TreeNode nj)
    {
    	if (ni.value !=0)
        {
    		TreeNode temp = new TreeNode(0);

    		temp.value= nj.value; 
    		nj.value = ni.value;
    		ni.value = temp.value;
    		
    		//switch between nodes
    		temp = nj;
    		nj = ni;
    		ni = temp;
    		
        }            
    }    
    
	public void heapSort()
    {      
        heapify();  
        
        System.out.println();
		System.out.println("Press Enter to continue...");
		Scanner keyboard = new Scanner(System.in);
		keyboard.nextLine();
		
        for (int i = N; i > 1; i--)
         {
            swap(nodeArray[1], nodeArray[i]);
            displayTree();
            N = N-1;
            maxHeap(1);
           
        }
        
        System.out.println();
        System.out.println("Here is the sorted heap: \n");
        
        for (int i = 1; i<nodeArray.length; i++)
        {
        	System.out.print(nodeArray[i].value + " ");
        }
      
    }     

    public void heapify()
    {
        for (int j = N/2; j >0; j--) // j starts from index 15 of the nodeArray
        {   
        	maxHeap(j);    
        }
        
        System.out.println();
        System.out.println("This is a heap!");
        
    }
    
    /* Function to swap largest element in  between a node and its left and right children. */        
    public void maxHeap(int  i)
    { 
    	int left = 2*i ; 
        int right = 2*i + 1; 
        
        int maxIndex = i;  // this is just a default for maxIndex
        
        if (left <= N && nodeArray[left].value > nodeArray[i].value)
        {   
        	maxIndex = left; 
        }
        
        //similar for right node child
        if (right <= N && nodeArray[right].value > nodeArray[maxIndex].value)        
        {
        	maxIndex = right;
        }
        
        if (maxIndex != i)
        {
            
            swap(nodeArray[i], nodeArray[maxIndex]);
            displayTree();
            
            maxHeap(maxIndex); 
        }
    }    
	
	
	public class TreeNode
	{
		int value;
		TreeNode lelfChild;
		TreeNode rightChild;
		
		public TreeNode (int v)
		{
			value = v;
		}	
	}
}
