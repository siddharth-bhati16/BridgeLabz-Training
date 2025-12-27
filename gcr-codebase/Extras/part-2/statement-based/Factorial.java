import java.util.*;
public class Factorial
{
	public static void main(String args[])
	{
		//creating object of scanner
		Scanner input= new Scanner(System.in);
		
		//asking for input
		System.out.println("Enter the number");
		int number = input.nextInt();
		
		//checking if the number is a positive integer
		if(number > 0)
		{	
			//finding factorial
			int factorial = 1;
			while(number >0)
			{
			factorial = factorial * number;
			number--;
			}
			
			//display output
			System.out.println("The factorial is " + factorial);
		}
	}
}
			