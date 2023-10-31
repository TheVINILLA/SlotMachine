/*
 * Venancio L. Sevilla
 * 3/23/2023
 * 
 * This program consist of 3 games that revolve around
 * using the random object and generating random numbers
 * 
 * There is the option to play a High or Low guessing game
 * where the user guesses a randomly generated number within a
 * limited amount of guesses
 * 
 * Another option is a Coin Flip game where the user
 * guesses heads or tails
 * 
 * The final game is Rock, Paper, Scissors
 * the user will pick rock paper scissors against an AI
 * whose choice in randomly generated through a random number
 */

import java.util.*;
public class RandomGames 
{

	public static void main(String[] args) 
	{
		//Acquire user name & 
		//Prompt user for which game they want to play
		Scanner scan = new Scanner(System.in);
		System.out.printf("Hello user! please enter your name: ");
		
		//Capitalizes first letter of user name regardless of input
		String nameLowercase = scan.nextLine();
		String firstLetter = nameLowercase.substring(0, 1).toUpperCase();
		String restOfName = nameLowercase.substring(1);
		String name = firstLetter + restOfName;
		mainMenu(name);
		scan.close();
	}
	
	/*
	 * @param Main Menu Method
	 * This method navigates the user to  
	 * the game of their choice
	 */
	public static void mainMenu(String name)
	{	
		System.out.println("");
		Scanner scan = new Scanner(System.in);
		System.out.printf("Welcome %s! Please choose which "
				+ "game you would like to play.\n",name);
		System.out.printf("Enter the number corresponding "
				+ "with the desired game:\n");
		System.out.printf("1: High or Low Guessing Game\n"
				+ "2: Coin Flip\n3: Rock, Paper, Scissors!\n%s: ", name);
		String userInput = scan.nextLine();
		
		//validate user choice. Checks if user selects the options given. 
		//If not, re-prompts user to provide a valid response.
		do 
		{
			
			while (!userInput.equals("1") && !userInput.equals("2")
					&& !userInput.equals("3"))
			{
				System.out.printf("Ivalid response. Please enter "
						+ "either 1, 2, or 3 to select a game.\n");
				System.out.printf("%s: ", name);
				userInput = scan.nextLine();
			}
			//initiate correct method corresponding to game from user choice
			if (userInput.equals("1")) 
			{
				highOrLow(name);
			}
			else if (userInput.equals("2")) 
			{
				coinFlip(name);
			}
			else if (userInput.equals("3"))
			{
				rockPaperScissors(name);
			}
				
		}while(!userInput.equals("1") && !userInput.equals("2") 
				&& !userInput.equals("3"));
	
		scan.close();
		
	}
	
	
	/*
	 * @param High Or Low Game
	 * This method contains all statements that allows the player to 
	 * play High or Low
	 */
	public static void highOrLow(String name)
	{
		
		String dash = "---------------";
		String highOrLowHeader = "High or Low";
		
		//give brief instructions & prompt to return to menu
		System.out.printf("You chose: High or Low.\n\n%45s\n"
				+ "%47s\n",highOrLowHeader,dash);
		System.out.printf("Tutorial:\nDecide which diffulty to"
				+ " play on from either easy, medium, or hard.\n");
		System.out.printf("Your choice of difficulty will impact"
				+ " the amount of guesses you have.\n\nEasy: 12. "
				+ "Medium: 8. Hard: 5.\n\n");
		System.out.printf("The AI will pick a number between 1-100."
				+ "\nYou will then try to find that number within that "
				+ "limited number of guesses.\n");
		System.out.printf("Score will be tracked for every successful "
				+ "guess within your number of attempts.\nEnding the "
				+ "game will display the score.\n");
		System.out.printf("%47s\n\n",dash);
		System.out.printf("Press \"s\" to start or \"r\" to "
				+ "return to game selection view.\n");
		System.out.printf("%s: ", name);
		Scanner scan = new Scanner(System.in);
		String choice = scan.nextLine().toLowerCase();
		System.out.println("");
		
		//validate response
		while(!choice.equals("s"))
		{
			if(choice.equals("r"))
			{
				mainMenu(name);
			}
			System.out.printf("Invalid response. Please enter \"s\" to "
					+ "start or \"r\" to return to game selection view.\n");
			System.out.printf("%s: ", name);
			choice = scan.nextLine().toLowerCase();
			System.out.println("");
		}
		
	
		//prompt user for difficulty
		System.out.printf("Please select a difficluty.\nEnter the "
				+ "corresponding letter with the desired difficulty.\n");
		System.out.printf("E: Easy (12 guesses)\nM: Medium (8 Guesses)"
				+ "\nH: Hard (5 Guesses)\n%s: ", name);
		int guessAttempts = 0;
		String difficulty = scan.nextLine().toLowerCase();
		
		// validate user difficulty choice & assign number of guesses depending on difficulty
		if(difficulty.equals("e"))
		{
			guessAttempts = 12;
		}
		else if(difficulty.equals("m"))
		{
			guessAttempts = 8;
		}
		else if(difficulty.equals("h"))
		{
			guessAttempts = 5;
		}
		
		while(guessAttempts == 0)
		{
			if(difficulty.equals("e"))
			{
				guessAttempts = 12;
			}
			else if(difficulty.equals("m"))
			{
				guessAttempts = 8;
			}
			else if(difficulty.equals("h"))
			{
				guessAttempts = 5;
			}
			
			System.out.printf("Ivalid response. Please enter either \"e\", "
					+ "\"m\", or \"h\" to select a difficulty.\n");
			System.out.printf("%s: ", name);
			difficulty = scan.nextLine().toLowerCase();
		}
		
		// generate random number between 1-100 for AI
		Random rand = new Random();
		int aiNumber = rand.nextInt(101);
		
		//game structure
		int numberOfGames = 0;
		int userPoints = 0; 
		int aiPoints = 0;
		String continuePlaying = "";
		
		//do-while loop to repeat game
		do
		{
			aiNumber = rand.nextInt(101);
			System.out.println("");
			System.out.printf("...AI number generated.\n");
			
			System.out.printf("Please enter a guess number 1.\n");
			System.out.printf("%s: ", name);
			int guess = scan.nextInt();
			//For loop to track user attempts
			for (int i = 2; i <= guessAttempts; i++)
			{
				
				
				//if-else statements to show user guess accuracy and 
				//assign points if correct or max attempt reached 
				if (guess < aiNumber)
				{
					System.out.printf("Too low!\n");
					System.out.printf("\nPlease enter guess number %d.\n", i);
					System.out.printf("%s: ", name);
					guess = scan.nextInt();
				
				}
				else if (guess > aiNumber)
				{
					System.out.printf("Too High!\n ");
					System.out.printf("\nPlease enter guess number %d.\n", i);
					System.out.printf("%s: ", name);
					guess = scan.nextInt();
				
				}
				else
				{
					System.out.printf("\nPerfect! Great Job %s!\n", name);
					System.out.printf("You found the number in %d guesses!\n", i);
					System.out.printf("%s's score +1\n", name );
					userPoints++;
				}
				
				if (i == guessAttempts && guess != aiNumber)
				{
					System.out.printf("\nMax attempts reach. Sorry the "
							+ "number was: %d.\n" ,aiNumber );
					System.out.printf("AI score +1\n" );
					aiPoints++;
				}
			 }
			
			
			numberOfGames++;
	
			//Prompt user if they would like to play again
			System.out.printf("\nWould you like to play again? (Y/N?)\n");
			System.out.printf("%s: ", name);
			
			//for some reason if I don't prompt twice, it will not prompt at all
			continuePlaying = scan.nextLine().toLowerCase();
			continuePlaying = scan.nextLine().toLowerCase();
			
			if (continuePlaying.equals("n"))
			{
				System.out.println("");
				//display score and who won
				if(userPoints > aiPoints)
				{
					System.out.printf("Congrats %s! Overall, you beat the AI!\n", name);
				}
				else if (aiPoints > userPoints)
				{
					System.out.printf("The AI got the best of you this time.\n");
					System.out.printf("Feel free to try again!\n");
				}
				else
				{
					System.out.printf("It's a tie! What a game!\n");
				}
				
				String totalGamesHeader = "TOTAL GAMES";
				String userScoreHeader = name + " Points";
				String aiScoreHeader = "AI Points";
				System.out.printf("%s%20s's%18s\n",totalGamesHeader,
						userScoreHeader,aiScoreHeader);
				System.out.printf("%6d%19d%20d\n",numberOfGames,
						userPoints,aiPoints);
				
				//give the option to return to the main menu or change difficulty
				System.out.printf("\n\nGame ended.\n");
				System.out.printf("\nPlease enter the corresponding number "
						+ "with the action you would like to perform.\n");
				System.out.printf("1. Return to main menu\n2. Restart "
						+ "and change difficulty.");
				System.out.printf("\n%s: ", name);
				String highOrLowPostChoice = scan.nextLine();
				
				//validate user input
				do 
				{
					
					while (!highOrLowPostChoice.equals("1") && 
							!highOrLowPostChoice.equals("2") )
					{
						System.out.printf("Ivalid response. Please enter "
								+ "either 1 or 2.\n");
						System.out.printf("%s: ", name);
						highOrLowPostChoice = scan.nextLine();
					}
					//initiate correct method corresponding to game from user choice
					if (highOrLowPostChoice.equals("1")) 
					{
						mainMenu(name);
					}
					else if (highOrLowPostChoice.equals("2")) 
					{
						highOrLow(name);
					}
				
				}while(!highOrLowPostChoice.equals("1") && !highOrLowPostChoice.equals("2"));
				
			}
			else
			{
				while(!continuePlaying.equals("y"))
				{
					System.out.printf("Ivalid response. Please enter either "
							+ "\"y\" to continue playing or \"n\" to move on.\n"); 
					System.out.printf("%s: ", name); 
					continuePlaying = scan.nextLine().toLowerCase(); 
				}
			
			}
			
			
		}while(continuePlaying.equals("y"));
		scan.close();
	}
	
	/*
	 * @param CoinFlip Game
	 * This method contains all statements that allows the player to 
	 * play Coin Flip
	 */
	public static void coinFlip(String name)
	{
		String dash = "---------------";
		String coinFlipHeader = "Coin Flip";
		
	    //give brief instructions & prompt to return to menu
		System.out.printf("You chose: Coin Flip.\n\n%44s\n"
				+ "%47s\n",coinFlipHeader,dash);
		System.out.printf("Tutorial:\nYou will select "
				+ "either heads or tails.\n");
		System.out.printf("Every correct call you make "
				+ "you will be given a point.\n");
		System.out.printf("Incorrect calls will result "
				+ "in the AI being given points.\n");
		System.out.printf("You will be prompted if you would "
				+ "like to continue playing after every flip.\n");
		System.out.printf("The game ends when you finish and "
				+ "the results will be displayed.\n");
		
		System.out.printf("%47s\n\n",dash);
		System.out.printf("Press \"s\" to start or \"r\" to"
				+ " return to game selection view.\n");
		System.out.printf("%s: ", name);
		Scanner scan = new Scanner(System.in);
		String choice = scan.nextLine().toLowerCase();
		System.out.println("");
		
		//validate acceptable response
		while(!choice.equals("s"))
		{
			if(choice.equals("r"))
			{
				mainMenu(name);
			}
			System.out.printf("Invalid response. Please enter \"s\" "
					+ "to start or \"r\" to return to game selection view.\n");
			System.out.printf("%s: ", name);
			choice = scan.nextLine().toLowerCase();
			System.out.println("");
		}
		
		//game structure declarations
		Random rand = new Random();
		int coinFlip = rand.nextInt(2);
		int userPoints = 0;
		int aiPoints = 0;
		String playAgain = "";
		String userChoice = "0";
		int headsOrTails = 0;
		int numberOfGames = 0;
		
		//do while loop to repeat the game
		do
		{
			coinFlip = rand.nextInt(2);
			System.out.printf("...Coin flipped.\nHeads or tails?");
			System.out.println(" Press \"h\" for heads or \"t\" for tails.");
			System.out.printf("%s: ", name);
			userChoice = scan.nextLine().toLowerCase();
			System.out.println("");
			
			/*
			 * do while loop to validate an acceptable response
			 * also assign the value of heads and tails to the user input
			 */
			do
			{
				if (userChoice.equals("h"))
				{
					headsOrTails = 0;
				}
				else if (userChoice.equals("t")) 
				{
					headsOrTails = 1;
				}
				else
				{
					System.out.printf("Invalid response. Please enter "
							+ "\"h\" for heads or \"t\" for tails.\n");
					System.out.printf("%s: ", name);
					userChoice = scan.nextLine().toLowerCase();
					System.out.println("");
				}
			}while(!userChoice.equals("h") && !userChoice.equals("t"));
			
			
			//if else statements to display coin flip value and user guess accuracy 
			if (coinFlip == 0)
			{
				System.out.printf("...heads.\n");
			}
			else
			{
				System.out.println("...tails.\n");
			}
			
			if(headsOrTails == coinFlip)
			{
				System.out.printf("Good call!\n%s's points +1\n\n", name);
				userPoints++;
			}
			else
			{
				System.out.printf("Wrong call.\nAI points +1\n\n");
				aiPoints++;
			}
			numberOfGames++;
			
			System.out.println("Play/Flip again? (Y/N).\n");
			System.out.printf("%s: ", name);
			playAgain = scan.nextLine().toLowerCase();
			System.out.println("");
			
			//end game post-action options
			if (playAgain.equals("n"))
			{
				//display who won
				if(userPoints > aiPoints)
				{
					System.out.printf("Congrats %s! Overall, you beat the AI!\n", name);
				}
				else if (aiPoints > userPoints)
				{
					System.out.printf("The AI got the best of you this time.\n");
					System.out.printf("Feel free to try again!\n");
				}
				else
				{
					System.out.printf("It's a tie! What a game!\n");
				}
				
				//display score
				String totalGamesHeader = "TOTAL GAMES";
				String userScoreHeader = name + " Points";
				String aiScoreHeader = "AI Points";
				System.out.printf("%s%20s%20s\n",totalGamesHeader,
						userScoreHeader,aiScoreHeader);
				System.out.printf("%6d%19d%20d\n",numberOfGames,
						userPoints,aiPoints);
				
				//give the option to return to the main menu or restart game
				System.out.printf("\n\nGame ended.\n");
				System.out.printf("\nPlease enter the corresponding number"
						+ " with the action you would like to perform.\n");
				System.out.printf("1. Return to main menu\n2. Restart game.");
				System.out.printf("\n%s: ", name);
				String coinFlipPostChoice = scan.nextLine();
				
				// do while to validate acceptable response
				do 
				{
					
					while (!coinFlipPostChoice.equals("1") && !coinFlipPostChoice.equals("2") )
					{
						System.out.printf("Ivalid response. Please enter the "
								+ "corresponding number with the action you would like to perform.\n");
						System.out.printf("%s: ", name);
						coinFlipPostChoice = scan.nextLine();
					}
					//initiate correct method action corresponding to user choice
					if (coinFlipPostChoice.equals("1")) 
					{
						mainMenu(name);
					}
					else if (coinFlipPostChoice.equals("2")) 
					{
						coinFlip(name);
					}
				
				}while(!coinFlipPostChoice.equals("1") && !coinFlipPostChoice.equals("2"));
			}
			else
			{
				//vallidate an acceptable response of either y or n
				while(!playAgain.equals("y"))
				{
					System.out.printf("Ivalid response. Please enter either "
							+ "\"y\" to continue playing or \"n\" to move on.\n"); 
					System.out.printf("%s: ", name); 
					playAgain = scan.nextLine().toLowerCase(); 
					System.out.println("");
				}
			}
				
 		}while(playAgain.equals("y"));
		scan.close();
	}
	  
	/*
	 * @param Rock, Paper, Scissor Game
	 * This method contains all statements that allows the player to 
	 * play rock paper scissors
	 */
	public static void rockPaperScissors(String name)
	{
		String dash = "---------------";
		String rpcHeader = "Rock, Paper, Scissors!";
		
	    //give brief instructions & prompt to return to menu
		System.out.printf("You chose: Rock, Paper.\n\n%44s\n"
				+ "%43s\n",rpcHeader,dash);
		System.out.printf("Tutorial:\nYou will select out of how "
				+ "many games you will play the AI in.\n");
		System.out.printf("S: Short (best of 3)\nM: Medium (best of 5)\n"
				+ "L: Long (best of 7)\n");
		System.out.printf("You will then input \"r\" for rock, \"p\" "
				+ "for paper, or \"s\" for scissors respectively.\n\n");
		System.out.printf("Possible win conditions:\n1. Rock > Scissors\n"
				+ "2. Scissors > Paper\n3. Paper > Rock.\n\n");
		System.out.printf("You will get a set point if you sucessfully "
				+ "choose a winning option that defeats the AI.\n");
		System.out.printf("You will get a overall score point if you sucessfully "
				+ "win more than half the set points within your selected set.\n");
		System.out.printf("Vice-versa, the AI will be awarded a point "
				+ "if they win the larger portion of full set games .\n");
		System.out.printf("%47s\n\n",dash);
		System.out.printf("Press \"s\" to start or \"r\" to "
				+ "return to game selection view.\n");
		System.out.printf("%s: ", name);
		Scanner scan = new Scanner(System.in);
		String choice = scan.nextLine().toLowerCase();
		System.out.println("");
		
		//validate acceptable response
		while(!choice.equals("s"))
		{
			if(choice.equals("r"))
			{
				mainMenu(name);
			}
			System.out.printf("Invalid response. Please enter \"s\" "
					+ "to start or \"r\" to return to game selection view.\n");
			System.out.printf("%s: ", name);
			choice = scan.nextLine().toLowerCase();
			System.out.println("");
		}
		
		Random rand = new Random();
		int aiRPS = rand.nextInt(3);
		//Game structure declarations
		String playAgain = "";
		int userPoints = 0;
		int aiPoints = 0;
		int userSetPoints = 0;
		int aiSetPoints = 0;
		
		int userRPS = 0;
		int numberOfGames = 0;
		int setLength = 0;
		
		//do while to repeat overall game
		do 
		{
			aiSetPoints = 0;
			userSetPoints = 0;
			System.out.printf("Out of how many games would you"
					+ " like to play in the set?\n");
			System.out.printf("Please select the corresponding letter"
					+ " with desired set length.\n");
			System.out.printf("S (Short): Best of 3\nM (Medium): "
					+ "Best of 5\nL (Long): Best of 7\n");
			System.out.printf("%s: ", name);
			String setChoice = scan.nextLine().toLowerCase();
			
			//do while to validate acceptable response for set length
			do
			{
				
				if (setChoice.equals("s"))
				{
					setLength = 3;
				}
				else if (setChoice.equals("m"))
				{
					setLength = 5;
				}
				else if (setChoice.equals("l"))
				{
					setLength = 7;
				}
				else
				{
					System.out.printf("\nInvalid response. Please enter "
							+ "\"s\" for best of 3, \"m\" for best of 5, ");
					System.out.printf("or \"l\" for best of 7.\n");
					System.out.printf("%s: ", name);
					setChoice = scan.nextLine().toLowerCase();
				}
			}while(!setChoice.equals("s") && !setChoice.equals("m") && !setChoice.equals("l"));
			

			
			System.out.printf("\n...Game created\n");
			System.out.printf("Remember to input \"r\" for rock, \"p\" "
					+ "for paper, or \"s\" for scissors.\n\n");
			String userChoice = "";
			
			
			//for loop that plays rock paper scissor within desired set length
			for (int i = 1; i <= setLength; i++)
			{
				System.out.printf("%s's Set Points: %d     AI Set Points: %d\n",
						name, userSetPoints,aiSetPoints);
				System.out.printf("Game %d: \n", i);
				System.out.printf("Rock, paper, or scissors?\n");
				System.out.printf("%s: ", name);
				userChoice = scan.nextLine().toLowerCase();
				System.out.println("");
				
				//do-while loop to validate acceptable response of rock paper or scissors
				do
				{
					//if-else to assign appropriate value to 
					//users choice of rock paper scissors
					if(userChoice.equals("r"))
					{
						userRPS = 0;
						System.out.printf("%s: Rock!\n", name);
					}
					else if (userChoice.equals("p"))
					{
						userRPS = 1;
						System.out.printf("%s: Paper!\n", name);
					}
					else if (userChoice.equals("s"))
					{
						userRPS = 2;
						System.out.printf("%s: Scissors!\n", name);
					}
					else
					{
						System.out.printf("Invalid response. Please enter "
								+ "\"r\" for rock, \"p\" for paper, ");
						System.out.printf("or \"s\" for scissors\n");
						System.out.printf("%s: ", name);
						userChoice = scan.nextLine().toLowerCase();
						System.out.println("");
						//users choice of rock paper scissors
						if(userChoice.equals("r"))
						{
							userRPS = 0;
							System.out.printf("%s: Rock!\n", name);
						}
						else if (userChoice.equals("p"))
						{
							userRPS = 1;
							System.out.printf("%s: Paper!\n", name);
						}
						else if (userChoice.equals("s"))
						{
							userRPS = 2;
							System.out.printf("%s: Scissors!\n", name);
						}
						
					}
				
				}while(!userChoice.equals("r") && !userChoice.equals("p") 
						&& !userChoice.equals("s"));
				
			
				
				//if else to display AI rock, paper, scissor choice.
				aiRPS = rand.nextInt(3);
				if(aiRPS == 0)
				{
					System.out.printf("AI: Rock!\n");
				}
				else if (aiRPS == 1)
				{
					System.out.printf("AI: Paper!\n");
				}
				else
				{
					System.out.printf("AI: Scissors!\n");
				}
				
				//if else to determine winner of set
				if ((userRPS == 0 && aiRPS == 0) || (userRPS == 1 && aiRPS == 1)
						|| (userRPS == 2 && aiRPS == 2))
				{
					System.out.printf("Tie! no points awarded.\n\n");
					i--;
				}
				else if ((userRPS == 0 && aiRPS == 2) || (userRPS == 1 && aiRPS == 0)
						|| (userRPS == 2 && aiRPS == 1))
				{
					System.out.printf("You Win! %s's set point +1\n\n", name);
					userSetPoints++;
				}
				else
				{
					System.out.printf("You lost! AI set point +1\n\n");
					aiSetPoints++;
				}
				
				//if else to awards score point for winning an entire set
				if (userSetPoints > (setLength/2))
				{
					System.out.printf("You Won the set!\n%s's SCORE point +1\n\n", name);
					userPoints++;
					i = setLength;
				}
				else if (aiSetPoints > (setLength/2))
				{
					System.out.printf("AI has won the set!\nAI SCORE point +1\n\n", name);
					aiPoints++;
					i = setLength;
				}
				
			}
			
			numberOfGames++;
			
			System.out.println("Play another set? (Y/N).\n");
			System.out.printf("%s: ", name);
			playAgain = scan.nextLine().toLowerCase();
			System.out.println("");
			
			//end game post-action options
			if (playAgain.equals("n"))
			{
				//display who won
				if(userPoints > aiPoints)
				{
					System.out.printf("Congrats %s! Overall, you beat the AI!\n", name);
				}
				else if (aiPoints > userPoints)
				{
					System.out.printf("The AI got the best of you this time.\n");
					System.out.printf("Feel free to try again!\n");
				}
				else
				{
					System.out.printf("It's a tie! What a game!\n");
				}
				
				//display score
				String totalGamesHeader = "TOTAL GAMES";
				String userScoreHeader = name + " Points";
				String aiScoreHeader = "AI Points";
				System.out.printf("%s%20s%20s\n",totalGamesHeader,
						userScoreHeader,aiScoreHeader);
				System.out.printf("%6d%19d%20d\n",numberOfGames,
						userPoints,aiPoints);
				
				//give the option to return to the main menu or restart game
				System.out.printf("\n\nGame ended.\n");
				System.out.printf("\nPlease enter the corresponding number "
						+ "with the action you would like to perform.\n");
				System.out.printf("1. Return to main menu\n2. Restart "
						+ "game and score points.");
				System.out.printf("\n%s: ", name);
				String rpsPostChoice = scan.nextLine();
				
				// do while to validate acceptable response
				do 
				{
					
					while (!rpsPostChoice.equals("1") && !rpsPostChoice.equals("2") )
					{
						System.out.printf("Ivalid response. Please enter the "
								+ "corresponding number with the action you would like to perform.\n");
						System.out.printf("%s: ", name);
						rpsPostChoice = scan.nextLine();
					}
					//initiate correct method action corresponding to user choice
					if (rpsPostChoice.equals("1")) 
					{
						mainMenu(name);
					}
					else if (rpsPostChoice.equals("2")) 
					{
						rockPaperScissors(name);
					}
				
				}while(!rpsPostChoice.equals("1") && !rpsPostChoice.equals("2"));
			}
			else
			{
				//Validate an acceptable response of either y or n
				while(!playAgain.equals("y"))
				{
					System.out.printf("Ivalid response. Please enter either "
							+ "\"y\" to continue playing or \"n\" to move on.\n"); 
					System.out.printf("%s: ", name); 
					playAgain = scan.nextLine().toLowerCase(); 
					System.out.println("");
				}
			}
			
		}while(playAgain.equals("y"));
		
		scan.close();
	}

}
