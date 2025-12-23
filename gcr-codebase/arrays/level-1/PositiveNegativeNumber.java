import java.util.*;
public class PositiveNegativeNumber
{
    public static void main(String args[])
	{
		//creating object of scanner
		Scanner sc= new Scanner(System.in);
		
		//taking inputs
		int [] number = new int[5];
		System.out.println("Enter 5 numbers");
		
		for( int i =0;i<5;i++)
		{
			number[i] = sc.nextInt();
		}
		
		//checking even or odd
		for(int i=0; i < number.length; i++)
		{
				if(number[i] < 0)
				{
					System.out.println(number[i]+" is negative");
				}
				else if(number[i] == 0)
				{
					System.out.println(number[i]+" is zero");
				}
				else if(number[i] % 2==0)
				{
					System.out.println(number[i]+" is positive and even");
				}
				else
				{
					System.out.println(number[i]+" is positive and odd");
				}
				
		}
	}
}