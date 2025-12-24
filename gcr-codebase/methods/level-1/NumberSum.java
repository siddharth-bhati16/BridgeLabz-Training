import java.util.*;
public class NumberSum
{

    // Method To find sum
    public int addNum(int number) 
	{
		int sum=0;
		for(int i=1 ; i<=number; i++)
		{
			sum+=i;
		}
		return sum;
	}
	
	public static void main (String [] args)
	{
		// Create a Scanner object
        Scanner sc = new Scanner(System.in);

        // Take input for number
        System.out.print("Enter the number ");
        int number = sc.nextInt();
		
		//creating object of NumberSum
		NumberSum numsum = new NumberSum();
		
		//calling the method
		int result = numsum.addNum(number);
		
		System.out.println("The sum is  " + result);
	}
}
	