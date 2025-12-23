import java.util.*;
public class ContinueSum
{
	public static void main(String args[])
	{
		
		Scanner sc= new Scanner(System.in);
		
		//asking for input
		System.out.println("Enter the numbers to be added");
		
		
		//creating variable for initializing loop an sum
		int current=1 , sum=0;
		
		//taking input in while loop and adding
		while (current !=0)
		{
		int number= sc. nextInt();
		current=number;
		sum= sum + current;
		}
		
		System.out.println("Total sum is " + sum);
	}
}