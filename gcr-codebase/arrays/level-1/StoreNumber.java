import java.util.*;
public class StoreNumber
{
    public static void main(String args[])
	{
		//creating object of scanner
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the numbers");
		int [] numberArray = new int[10];
		
		for(int i=0; i<10; i++)
		{
			numberArray[i]= sc.nextInt();
			if(numberArray[i] <= 0)
			{break;}
		}
		 //displaying all the numbers and sum
		 int sum=0;
		 for(int i=0; i<numberArray.length; i++)
		 {
			System.out.println(numberArray[i]);
			sum+=numberArray[i];
		 }
		 System.out.println("Total sum is " + sum);
	}
}