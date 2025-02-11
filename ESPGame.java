/*
 * Class: CMSC203 
 * Instructor: Professor Monshi
 * Description: This is a user interactive program that gets info from a file and displays it, interacts with the user and save result in another file 
 * Due: 02/10/2025
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: _Joel Mbah_________
*/


package Project1;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Random;

public class ESPGame {

	public static void main(String[] args)
	{
		System.out.println("CMSC203 Assignment1: Test your ESP skills!");
		System.out.println("Welcome to ESP - extrasensory perception!");
		System.out.println("Would you please choose one of the 4 options from the menu:");

		final String COLOR_BLACK = "black";
		final String COLOR_WHITE = "white";
		final String COLOR_GRAY = "gray";
		final String COLOR_SILVER = "silver";
		final String COLOR_MAROON = "maroon";
		final String COLOR_RED = "red";
		final String COLOR_PURPLE = "purple";
		final String COLOR_FUCHSIA = "fuchsia";
		final String COLOR_GREEN = "green";
		final String COLOR_LIME = "lime";
		final String COLOR_OLIVE = "olive";
		final String COLOR_YELLOW = "yellow";
		final String COLOR_NAVY = "navy";
		final String COLOR_BLUE = "blue";
		final String COLOR_TEAL = "teal";
		final String COLOR_AQUA = "aqua";

		String dueDate; //to hold info for the due date
		String userName;//to hold the user name
		String description;//to hold info about the users description
		int check = 0;
		String choice = "yes"; // holds yes so it controls the iteration of the first while loop
		String name = "";
		String guess; // to hold the guess of the users choice
		String smallGuess;// to convert the input in guess to lower case
		String comColor = "";// to hold the random color   not really needed anymore
		int option;
		int increment; // to control  and increment in loops
		int correctColors = 0; //to hold the number of times the user gets the correct color
		int gamecolors = 3; // to hold the max number of times the user has to guess the colors in a game session

		int rounds;//to increment and hold the number of rounds
		Scanner keyboard = new Scanner(System.in);

		while (choice.equals("yes"))
		{
			correctColors = 0;
			increment = 0;
			System.out.println("1-	read and display on the screen first 16 names of"
					+ " colors from a file colors.txt, so the player can select one of them names of colors.");
			System.out.println("2-	read and display on the screen first 10 names of "
					+ "colors from a file colors.txt, so the player can select one of them names of colors.");
			System.out.println("3-	read and display on the screen first 5 names of "
					+ "colors from a file colors.txt, so the player can select one of them names of colors. ");
			System.out.println("4-	Exit from a program");
			System.out.println("Enter the option: ");
			option = keyboard.nextInt();
			keyboard.nextLine();

			if(option != 4) {
				System.out.println("Enter the filename: ");
				name = keyboard.nextLine();
			}



			if (option == 1)
			{

				try
				{
					File file = new File(name);
					Scanner fileScanner = new Scanner(file);
					System.out.println("There are sixteen colors from this file");

					while (fileScanner.hasNextLine())
					{
						increment++;

						if (increment <= 16)
							System.out.println(increment + " "+ fileScanner.nextLine());

					}
					fileScanner.close();
				}
				catch (FileNotFoundException e)
				{
					System.out.println("File not found");
					check = 1;

				}

			}

			if (option == 2)
			{

				try
				{
					File file = new File(name);
					Scanner fileScanner = new Scanner(file);
					System.out.println("There are sixteen colors from this file");

					while (fileScanner.hasNextLine())
					{
						increment++;

						if (increment <= 10)
							System.out.println(increment + " "+ fileScanner.nextLine());
						else
							fileScanner.next();
					}
					fileScanner.close();

					increment -= 6;
				}
				catch (FileNotFoundException e)
				{
					System.out.println("File not found");
					check = 1;

				}

			}

			if (option == 3)
			{

				try
				{
					File file = new File(name);
					Scanner fileScanner = new Scanner(file);
					System.out.println("There are sixteen colors from this file");

					while (fileScanner.hasNextLine())
					{
						increment++;

						if (increment <= 5)
							System.out.println(increment + " "+ fileScanner.nextLine());
						else
							fileScanner.next();

					}
					fileScanner.close();

					increment -= 11;
				}
				catch (FileNotFoundException e)
				{
					System.out.println("File not found");
					check = 1;

				}

			}

			if(option == 4)
			{
				choice = "no";
			}

			if (check != 1 && option != 4)
			{
				for(rounds = 0; rounds <3; rounds++)
				{
					System.out.println(" ");
					System.out.println("Round " + (rounds + 1));
					System.out.println("I am thinking of a color.");
					System.out.println("Is it one of list of colors above?");					


					Random random = new Random();
					int randomInt = 1 + random.nextInt(increment);
					System.out.println(randomInt);
					System.out.println("Enter your guess: ");

					guess = keyboard.nextLine();
					smallGuess = guess.toLowerCase();


					String selectedColor = "";


					switch(randomInt)
					{
					case 0:
					case 1:
					{
						selectedColor = COLOR_BLACK;
						break;
					}
					case 2:
					{
						selectedColor = COLOR_WHITE;
						break;
					}
					case 3:
					{	selectedColor = COLOR_GRAY;
					break;
					}
					case 4:
					{
						selectedColor = COLOR_SILVER;
						break;
					}
					case 5:
					{
						selectedColor = COLOR_MAROON;
						break;
					}
					case 6:
					{
						selectedColor = COLOR_RED;
						break;
					}
					case 7:
					{
						selectedColor = COLOR_PURPLE;
						break;
					}
					case 8:
					{
						selectedColor = COLOR_FUCHSIA;
						break;
					}
					case 9:
					{
						selectedColor = COLOR_GREEN;
						break;
					}
					case 10:
					{
						selectedColor = COLOR_LIME;
						break;
					}
					case 11:
					{
						selectedColor = COLOR_OLIVE;

						break;
					}
					case 12:
					{
						selectedColor = COLOR_YELLOW;
						break;
					}
					case 13:
					{
						selectedColor = COLOR_NAVY;
						break;
					}
					case 14:
					{
						selectedColor = COLOR_BLUE;
						break;
					}
					case 15:
					{
						selectedColor = COLOR_TEAL;
						break;
					}
					case 16:
					{
						selectedColor = COLOR_AQUA;
						break;
					}




					}
					System.out.println("I was thinking of " + selectedColor);

					if (selectedColor.equals(smallGuess))
					{
						correctColors += 1;
						System.out.println("You guessed right");
					}


				}
			}

			if(option != 4) {
				System.out.println("Game Over");
				System.out.println("You guessed "  + correctColors + " out of " + gamecolors + " colors correctly.");
				System.out.println("Would you like to continue game? Yes/No");
				choice = keyboard.nextLine();
			}


		}


		try {

			PrintWriter info = new PrintWriter("EspGameResults.txt");

			System.out.println("Enter your name: ");
			userName = keyboard.nextLine();
			System.out.println("Describe yourself: ");
			description = keyboard.nextLine();
			System.out.println("Due Date: ");
			dueDate = keyboard.nextLine();

			info.println("Game Over");
			info.println("You guessed "  + correctColors + " out of " + gamecolors + " colors correctly.");
			info.println("Username: " + userName);
			info.println("User Description: " + description);
			info.println("Date: " + dueDate);

			info.close();

		}catch(FileNotFoundException e) {

		}




	}
}
