import java.util.*;
public class GreatestFactorUsingFor
{
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the number");
		int number = sc.nextInt();
		
		if (number>0)
		{

		for(int current = number - 1; current>0; current--)
		{
			if(number % current ==0)
			{System.out.println("The greatest factor is " + current);
			break;
			}
		
		}
		}
	}
}