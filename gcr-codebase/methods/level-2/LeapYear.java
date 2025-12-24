import java.util.*;
public class LeapYear
{
	//method to check leap year
	public static void checkLeapYear(int n)
	{
		if(n>=1582)
		{
			if((n%400==0)||((n%4==0)&&(n%100!=0)))
			{
				System.out.println("It is a leap year");
			}
			else
			{
				System.out.println("It is not a leap year");
			}
		}
		else
		{
			System.out.println("It is not a leap year");
		}
	}
	
	public static void main(String[] args)
	{
		
		//taking input and calling method
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		isLeap(n);
	}
	
}