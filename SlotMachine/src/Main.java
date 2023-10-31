/*
 * Venancio L. Sevilla
 * 10/16/23
 * SLOT MACHINE
 * 
 * This program is a basic simulation of a typical slot machine
 * in casino's. 
 * 
 * The user will deposit money into their wallet, bet on each roll,
 *  roll the slot machine, and receive more funds if they have successful matches.
 *  
 * */


import java.util.*;
import javax.swing.JOptionPane;

//Imported Princeton library to display images
import edu.princeton.cs.algs4.*;

public class Main 
{
	/*
	 * @Param
	 * 
	 * This method asks how much the user wants to deposit into their wallet before playing
	 * and puts it in.
	 * */
	public static String depositMoney(String startingAmount)
	{
		
		startingAmount = JOptionPane.showInputDialog("How much money would you like to deposit?");
		
		//Validate deposit input
		while(!startingAmount.matches("[0-9]+"))
		{
			startingAmount = JOptionPane.showInputDialog("Invalid input.\nPlease enter a valid number\n" + 
							"How much money would you like to deposit?");
		}
		
		return startingAmount;
		
	}
	
	/*
	 * @Param
	 * This method asks how much the user wants to bet per roll and takes away from wallet
	 * slot machine is played and displays the users roll visually with fruit images
	 * if three of the same fruits are rolled, user gets 3x their initial bet.
	 * 
	 * */
	public static double roll(double wallet) 
	{
				//get bet amount
				String betAmount;
				betAmount = JOptionPane.showInputDialog("How much money would you like to bet?");
				double bet = 0;
				
				//validate bet input. Checks if user inputs a valid number or if the 
				//bet is less than or at least equal to what the user has in their wallet.
				if(!betAmount.matches("[0-9]+"))
				{
					while(!betAmount.matches("[0-9]+"))
					{
						betAmount = JOptionPane.showInputDialog("Invalid input.\nPlease enter a valid bet amount.\n" +
								"How much money would you like to bet?");
					}
					bet = Double.parseDouble(betAmount);
				}
				
				bet = Double.parseDouble(betAmount);	
				if (wallet < bet)
				{
					while(wallet<bet)
					{
						betAmount = JOptionPane.showInputDialog("Invalid input.\nPlease enter a valid bet amount.\n" +
								"How much money would you like to bet?");
						bet = Double.parseDouble(betAmount);
					}
				}

				//take away bet amount from wallet
				wallet = wallet-bet;

			   	//declare random object for rolls
				Random rand = new Random();
				
			
				int slots;
				
				//correlating the fruits to a number in a queue
				//also generates the 3 random numbers for the slots
				Queue<String> q = new Queue<String>();
				for(int i = 0; i < 3; i++)
				{
					slots = rand.nextInt(4);
					if(slots == 0)
					{
						q.enqueue("cherry");
					}
					else if (slots == 1)
					{
						q.enqueue("lemon");
					}
					else if (slots == 2)
					{
						q.enqueue("orange");
					}
					else if (slots == 3)
					{
						q.enqueue("watermelon");
					}
				}
				
				//setting the window tab size of the slot machine
				StdDraw.setCanvasSize(500,100);
				
		        //declare number of matches
				int numCherry = 0;
				int numLemon = 0;
				int numOrange = 0;
				int numWatermelon = 0;
				
				//display images and checks for matches
				// ***MAKE SURE FILE PATH IS CORRECT FOR YOUR SPECEFIC MACHINE***
			    for(int i = 0; i < 3; i ++)
			    {
			    	if (q.peek().equals("cherry"))
			    	{
			    		StdDraw.picture(.2*(i+1), 0.5, "/Users/vinsevilla/eclipse-workspace/SlotMachine/img/Cherry.jpg");
			    		numCherry++;
			    	}
			    	else if(q.peek().equals("lemon"))
			    	{
			    		StdDraw.picture(0.2*(i+1), 0.5, "/Users/vinsevilla/eclipse-workspace/SlotMachine/img/Lemon.jpg");
			    		numLemon++;
			    	}
			    	else if(q.peek().equals("orange"))
			    	{
			    		StdDraw.picture(0.2*(i+1), 0.5, "/Users/vinsevilla/eclipse-workspace/SlotMachine/img/Orange.jpg");
			    		numOrange++;
			    	}
			    	else if(q.peek().equals("watermelon"))
			    	{
			    		StdDraw.picture(0.2*(i+1), 0.5, "/Users/vinsevilla/eclipse-workspace/SlotMachine/img/Watermelon.jpg");
			    		numWatermelon++;
			    	}
			    	q.dequeue();
			    }
			    StdDraw.show();
			    
			    //add 3x the bet into the wallet if there are 3 matching fruits
			    if(numCherry == 3 || numLemon == 3 || numOrange == 3 || numWatermelon == 3)
			    {
			    JOptionPane.showMessageDialog(null, "JACKPOT!");
			    	wallet = wallet + (bet*3);
			    }
			    else 
			    {
			    	JOptionPane.showMessageDialog(null, "No Luck");
			    }
			    
			    return wallet;
	}

	public static void main(String[] args)
	{
	
		//Get users name & capitalize first letter;
		String name;
		name = JOptionPane.showInputDialog("Enter your name.");
		//makes the first letter of the user-inputted name capital
		//regardless of how they typed it
		name = name.substring(0, 1).toUpperCase() + name.substring(1);
		
		//Receive starting wallet amount to begin slots with
		String startingAmount = "";
		double wallet = 0;
		startingAmount = depositMoney(startingAmount);
		wallet = Double.parseDouble(startingAmount);
		
		
		JOptionPane.showMessageDialog(null, "Name: " + name + "\nWallet: " + wallet );
		JOptionPane.showMessageDialog(null, "Let's begin");
		String playAgain = "";
		
		
		//user attempts
		int rollCount = 0;
	
		do {
				wallet = roll(wallet);
				rollCount++;
				//prompt to deposit more if funds are 0.
				if (wallet == 0)
				{
					String depositMore = JOptionPane.showInputDialog(null, "No more funds available.\nWould you like to deposit more? (Y/N)");
					while (!depositMore.equalsIgnoreCase("y") && !depositMore.equalsIgnoreCase("n"))
					{
		    			depositMore = JOptionPane.showInputDialog("Invalid Input.\nPlease enter a vailid number\nHow much money would you like to deposit?");
					}
		    	   
					if (depositMore.equalsIgnoreCase("y"))
					{
						startingAmount = depositMoney(startingAmount);
						wallet = Double.parseDouble(startingAmount);
						
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "Final Result\nRolls: " + rollCount + "\nName: " + name + "\nWallet: $" + wallet );
					}	
		    	
				}
		
					//validate input
					playAgain = JOptionPane.showInputDialog(name + "\nWallet: $" + wallet + "\nWould you like to roll again? (Y/N)");
					while (!playAgain.equalsIgnoreCase("y") && !playAgain.equalsIgnoreCase("n"))
					{
						playAgain = JOptionPane.showInputDialog("Invalid Input.\nPlease enter either \"Y\" or \"N.\"\nWould you like to play again? (Y/N)");
					}
				
		    	
		  }while(playAgain.equalsIgnoreCase("y"));
		
		//Print final result
		JOptionPane.showMessageDialog(null, "Final Result\nRolls: " + rollCount + "\nName: " + name + "\nWallet: $" + wallet );
			
		//Close JOptionPane
		//System.exit(0);

	}

}
