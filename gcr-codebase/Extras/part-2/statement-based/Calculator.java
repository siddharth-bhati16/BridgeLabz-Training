import java.util.Scanner;
public class Calculator
{
	public static void main(String []args)
	{
		// Create a Scanner Object
		Scanner sc=new Scanner(System.in);
		
		//taking input
		System.out.println("Enter the inputs");
		double first = sc.nextDouble();
		double second = sc.nextDouble();
		
		System.out.println("Enter the operation to perform ");
		String op= sc.next();
		
		//performing operation and displaying the results
		
		switch(op)
		{
			case "+":
				System.out.println(first+second);
				break;
			case "-":
				System.out.println(first-second);
				break;
			case "*":
				System.out.println(first*second);
				break;
			case "/":
				System.out.println(first/second);
				break;
			default:
				System.out.println("Invalid Operator");
				break;
		}
	}
}
