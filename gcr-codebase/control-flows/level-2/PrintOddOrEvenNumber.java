import java.util.*;
public class PrintOddOrEvenNumber
{
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the number");
		int number = sc.nextInt();
		
		int even=0, odd=0;
		for(int i=1; i<=number; i++)
		{
			if((i%2)==0)
			{ System.out.println( i + " is even");}
			else
			{ System.out.println( i + " is odd");}
		}
		
		
	}
}