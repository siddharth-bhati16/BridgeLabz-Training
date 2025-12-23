import java.util.*;
public class FactorialUsingForLoop
{
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the number");
		int number = sc.nextInt();
		
		if(number > 0)
		{	
			int factorial = 1;
			for(int i=1; i<=number; i++)
			{
			factorial = factorial *i;
			}
	
			System.out.println("The factorial is " + factorial);
		}
	}
}