import java.util.*;
public class AgeAndHeight
{
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		
		
		System.out.println("Enter the ages one by one");	
		double ageOfAmar = sc.nextDouble();
		double ageOfAkbar = sc.nextDouble();
		double ageOfAnthony = sc.nextDouble();
		
		System.out.println("Enter the height one by one in same order");	
		double heightOfAmar = sc.nextDouble();
		double heightOfAkbar = sc.nextDouble();
		double heightOfAnthony = sc.nextDouble();
		
		//comparing who is youngest
		if ((ageOfAmar < ageOfAkbar) && (ageOfAkbar <= ageOfAnthony) )
			{	
				System.out.println("Amar is the youngest");
			}
			
		else if(
			(ageOfAkbar < ageOfAmar) && (ageOfAmar <= ageOfAnthony) )
			{	
				System.out.println("Akbar is the youngest");
			}
			
		else if(
			(ageOfAnthony < ageOfAmar) && (ageOfAmar <= ageOfAkbar) )
			{	
				System.out.println("Anthony is the youngest");
			}
			
			
		//comparing how is the tallest
		if (
			(heightOfAmar > heightOfAkbar) && (heightOfAkbar >= heightOfAnthony) )
			{	
				System.out.println("Amar is the tallest");
			}
		else if (
			(heightOfAnthony > heightOfAkbar) && (heightOfAkbar >= heightOfAmar) )
			{	
				System.out.println("Anthony is the tallest");
			}
		else if (
			(heightOfAkbar > heightOfAnthony) && (heightOfAnthony >= heightOfAmar) )
			{	
				System.out.println("Anthony is the tallest");
			}
	}
}