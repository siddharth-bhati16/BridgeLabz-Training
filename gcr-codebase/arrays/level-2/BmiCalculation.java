import java.util.*;
public class BmiCalculation
{
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the number of people in the team");
		int number = sc.nextInt();
		
		double [] height= new double[number];
		double [] weight= new double[number];
		double [] bMI= new double[number];
		String [] status = new String[number];
		
		System.out.println("Enter the height of people in cm");
		for (int i=0; i<number; i++)
		{
			height[i]=sc.nextDouble();
			height[i]=height[i]/100.0;
		}
		
		System.out.println("Enter the weight of people in the team");
		for (int i=0; i<number; i++)
		{
			weight[i]=sc.nextDouble();
		}
		
		for (int i=0; i<number; i++)
		{
			bMI[i]= weight[i]/(height[i]*height[i]);
			if( bMI[i] >=40)
			{
				status[i] = " Obese";
			}
			else if( bMI[i] >= 25 && bMI[i] < 40)
			{
				status[i] =" Overweight";
			}
			else if( bMI[i] >= 18.5 && bMI[i] < 25)
			{
				status[i] = " Normal";
			}
			else if( bMI[i] <= 18.4)
			{
				status[i] = "Underweight";
			}
		}
		System.out.println("the result is below in format of  height, weight, BMI, and weight status");
		for (int i=0; i<number; i++)
		{
			System.out.println(height[i] + " "+weight[i]+" "+bMI[i]+" "+status[i]);
		}
	}
}