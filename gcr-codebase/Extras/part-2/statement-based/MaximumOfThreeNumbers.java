import java.util.*;
public class MaximumOfThreeNumbers
{	
	public static void main (String args[])
	{	
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter three numbers");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		
		System.out.println("The maximum of three is  " + findMax(num1, num2, num3));
		
	}


	public static int findMax(int num1, int num2, int num3)
	{
		int max=Math.max(Math.max(num1, num2) ,num3);
		return max;
	}
}