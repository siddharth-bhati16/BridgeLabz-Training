import java.util.*;
public class PowerFinderUsingWhile
{
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the number and the power");
		int number = sc.nextInt();
		int power = sc.nextInt();
		
		int result =1;
		
		while(power > 0)
		{
			result=number * result;
			power--;
		}
		System.out.println("The result is " + result);
		
	}
}