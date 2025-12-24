import java.util.*;
public class FindingNumberStatus{

    // Method To check number is positive negative or zero
    public String checkNumber(int number) 
	{
		String output;
        if(number>0)
			{
				output ="The number is positive";
			}
		else if(number<0)
			{
				output ="The number is negative";
			}
		else
			{
				output ="The number is zero";
			}
		return output;
		
		
    }

    public static void main(String[] args)
	{
	
        // Create a Scanner object
        Scanner sc = new Scanner(System.in);

        // Take input for people
        System.out.print("Enter the number ");
        int number = sc.nextInt();
		
		//create  a NumberStatus object
		NumberStatus num = new NumberStatus();
		
		//call the method
		String result= num.checkNumber(number);
		
		//display result
		System.out.println( result);
	}
}