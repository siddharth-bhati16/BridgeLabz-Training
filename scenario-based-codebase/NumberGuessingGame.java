
// Number guessing game

import java.util.*;
public class NumberGuessingGame
{
	public static void main (String args[])
	{
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to number guessing game");
		
		//keeping a number to be guessed
		Random random = new Random();
		 int  luckyNumber = random.nextInt(100) + 1;
		 
		 //initialize a variable that count number of guesses
		int count =5;
		
		System.out.println("guess a number between 1 and 100");
		 
		 do 
		{
			
			int guess = sc.nextInt();
		
			
			
			if( guess == luckyNumber)
			{
				System.out.println("You guessed the correct number");
				break;
			}
			else if(count >1)
			{
				System.out.println("Guess it again");
			}
		
		count --;
		if(count ==0)
		{
			System.out.println("No more chances left");
		}
		
		}
		while(count >0);
	}
}		
