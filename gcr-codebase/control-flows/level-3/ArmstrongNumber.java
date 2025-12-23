import java.util.Scanner;
public class ArmstrongNumber
{
	public static void main(String []args)
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the number");
		int number = sc.nextInt();
		int copy1 = number;
		int copy2 = number;
		int digit=0;
		int calculatedsum=0;
		
		
		
		while(copy1 > 0)
		{
			copy1=copy1/10;
			digit ++;
		}
		
		while(number >0)
		{
			int answer = 1;
			for(int i=digit; i>0; i--)
			{
				answer= answer * (number % 10);
			}
			calculatedsum = calculatedsum + answer;
			number = number / 10;
		}
		
		
		if( calculatedsum == copy2)
		{
			System.out.println("Its an Armstrong number.");
		}
		else 
		{
			System.out.println("Its not an Armstrong number.");
		}
		
		

	}
}