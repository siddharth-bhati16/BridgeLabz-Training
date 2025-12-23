import java.util.Scanner;
public class PrimeNumber
{
	public static void main(String []args)
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the number");
		int number = sc.nextInt();
		int count =0;
		
		for(int i=2; i<number; i++)
		{
			if(number%i==0)
			{
				count++;
				break;
			}
		}
		if(count >0)
		{
				System.out.println("It is not a prime number");
		}
		else
		{
			System.out.println("It is a prime number");
		}
			
		

	}
}