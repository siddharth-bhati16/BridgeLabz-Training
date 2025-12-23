import java.util.Scanner;
public class BMIcalculator
{
	public static void main(String []args)
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the weight in kg");
		double weight = sc.nextDouble();
		System.out.println("Enter the height in cm");
		double height = sc.nextDouble();
		
		height=height/100.0;
		
		
		double bmi= weight / (height * height);
		
		if( bmi >=40)
		{
			System.out.println("Status : Obese");
		}
		else if( bmi >= 25 && bmi < 40)
		{
			System.out.println("Status : Overweight");
		}
		else if( bmi >= 18.5 && bmi < 25)
		{
			System.out.println("Status : Normal");
		}
		else if( bmi >= 18.4)
		{
			System.out.println("Status : Underweight");
		}
	}
}