import java.util.Scanner;


public class MovieDriverTask2 
{


	public static void main(String[] args)
	{
		boolean counter = true; // to loop if the user enters y for yes or n for no
		String movieName; // to hold the name of the movie the user enters
		String movieRating;// to hold the rating of the movie the user enters
		String response;;// to hold the users response if they want to enter another movie
		int movieTickets; // to hold the number of tickets sold
		Scanner keyboard = new Scanner(System.in);


		while(counter)
		{


			Movie movieOne = new Movie();

			System.out.println("Enter the name of a movie ");
			movieName = keyboard.nextLine();
			movieOne.setTitle(movieName);

			System.out.println("Enter the rating of the movie ");
			movieRating = keyboard.nextLine();
			movieOne.setRating(movieRating);

			System.out.println("Enter the number of tickets sold for this movie ");
			movieTickets = keyboard.nextInt();
			keyboard.nextLine();
			movieOne.setSoldTickets(movieTickets);


			movieOne.toString();
			System.out.println(movieOne.toString());

			System.out.println("Do you want to enter another? (y or n)");
			response = keyboard.nextLine();
			if (response.equals("y"))
			{
				counter = true;
			}
			else if(!(response.equals("y")))
				counter = false;


		}

		System.out.println("Goodbye");



	}

}
