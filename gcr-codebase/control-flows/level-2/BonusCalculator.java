import java.util.*;
public class BonusCalculator
{
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the salary  and year of service");
		double salary = sc.nextDouble();
		double serviceYear = sc.nextDouble();
		double bonus =0;
		
		if(serviceYear>5)
		{
			bonus = salary * 0.05;
		}
		
		System.out.println(bonus) ;
	}
}