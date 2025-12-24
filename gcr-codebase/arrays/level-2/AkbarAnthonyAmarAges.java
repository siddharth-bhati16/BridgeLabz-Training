import java.util.*;
public class AkbarAnthonyAmarAges
{
	public static void main(String args[])
	{
		Scanner input= new Scanner(System.in);
		
		double [] age = new double[3];
		double [] height = new double[3];
		
		System.out.println("Enter the ages one by one");
			for(int i=0; i<3; i++)
			{
				age[i] = input.nextDouble();
			}
		
		
		System.out.println("Enter the height one by one in same order");	
		for(int i=0; i<3; i++)
			{
				height[i] = input.nextDouble();
			}
		
		if ((age[0] < age[1]) && (age[0] < age[2]) )
			{	
				System.out.println("Amar is the youngest");
			}
			
		else if(
			(age[1] < age[0]) && (age[1] < age[2]) )
			{	
				System.out.println("Akbar is the youngest");
			}
			
		else if(
			(age[2] < age[0]) && (age[2] < age[1]) )
			{	
				System.out.println("Anthony is the youngest");
			}
			
			
		if (
			(height[0] > height[1]) && (height[0] > height[1]) )
			{	
				System.out.println("Amar is the tallest");
			}
		else if (
			(height[1] > height[0]) && (height[1] > height[2]) )
			{	
				System.out.println("Akbar is the tallest");
			}
		else if (
			(height[2] > height[0]) && (height[2] > height[1]) )
			{	
				System.out.println("Anthony is the tallest");
			}
	}
}