import java.util.*;
public class MinMaxNumber
{
	//method to find smallest and largest
	public String findMinMax(int number1, int number2, int number3)
		{
			// find smallest and largest
			String output;
			int min=Math.min(Math.min(number1,number2),number3);
			int max=Math.max(Math.max(number1,number2),number3);
			
			output = min + " is the smallest and " + max +
							" is the largest";
	
			
			return output;
		}
		
		public static void main(String[] args) 
		{
			// Create Scanner object
			Scanner sc = new Scanner(System.in);

			// Take input for number1, number2, number3
			System.out.print("Enter number1, number2, number3 :  ");
			int number1 = sc.nextInt();
			int number2 = sc.nextInt();
			int number3 = sc.nextInt();
			
			//creating object of MinMaxNumber and calling the method
			
			MinMaxNumber objMinMax= new MinMaxNumber();
			String result = objMinMax.findMinMax(number1,number2,number3);
			
			//display result
			System.out.println( result);
		}
	}