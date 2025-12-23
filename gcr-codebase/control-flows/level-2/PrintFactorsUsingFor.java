import java.util.*;
public class PrintFactorsUsingFor
{
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the number");
		int number = sc.nextInt();
		
		if (number>0)
		{
		
		System.out.println("The number is divible by ");
		
		for(int i=1; i<= number; i++)
		{
			if(number%i ==0)
			{System.out.println(i);}
		}
		}
	}
}