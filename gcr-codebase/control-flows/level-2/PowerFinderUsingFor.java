import java.util.*;
public class PowerFinderUsingFor
{
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the number and the power");
		int number = sc.nextInt();
		int power = sc.nextInt();
		
		int result =1;
		
		for(int i =1; i<=power; i++)
		{
			result=number * result;
		}
		System.out.println("The result is " + result);
		
	}
}