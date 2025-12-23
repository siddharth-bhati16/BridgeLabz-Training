import java.util.*;
public class MultiplesOfNumberUsingFor
{
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the number");
		int number = sc.nextInt();
		
		if (number>0 && number<100)
		{
			for(int i=100; i>0; i--)
			{
				//checking if it is the multiples
				if(i%number == 0)
				{
					System.out.println(i);
				}
			}
		}
	}
}