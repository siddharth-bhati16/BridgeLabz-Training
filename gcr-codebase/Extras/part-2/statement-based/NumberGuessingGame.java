import java.util.Scanner;
import java.util.Random;
public class NumberGuessingGame 
{
    public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);
        Random randomNum = new Random();
        
        System.out.println("Think of a number between 1 and 100.");
        System.out.println("I will try to guess it!");
        
        int low = 1;
        int high = 100;
        String feedback = "";
        
        while (!feedback.equals("correct")) 
		{
            int guess = takeAGuess(low, high, randomNum);
            System.out.println("Is your number " + guess + "? (high/low/correct)");
            feedback = sc.nextLine().toLowerCase();
            
            if (feedback.equals("high")) 
			{
                high = guess - 1;
            }
			else if (feedback.equals("low")) 
			{
                low = guess + 1;
            } 
			else if (!feedback.equals("correct")) 
			{
                System.out.println("Please provide valid feedback: high, low, or correct.");
            }
        }
        
        System.out.println("Yay! I guessed your number!");
        sc.close();
    }
    
    public static int takeAGuess(int low, int high, Random randomNum) 
	{
        return randomNum.nextInt(high - low + 1) + low;
    }
}