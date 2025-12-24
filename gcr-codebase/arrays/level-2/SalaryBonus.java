import java.util.*;
public class  SalaryBonus
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		double[] salary = new double[10];
		double[] year = new double[10];
		double[] bonus = new double[10];
		double[] newSalary = new double[10];
		
		System.out.println("Enter the salary and year of experience pairwise");
		
		for(int i =0;i<10;i++)
		{
			salary[i] = sc.nextDouble();
			year[i] = sc.nextDouble();
		}
		
		for(int i =0;i<salary.length;i++)
		{
			if(year[i]>=5)
			{
			 bonus[i] = (salary[i]/100)*5;
			}
			else
			{
			 bonus[i] = (salary[i]/100)*2;
			}
			newSalary[i] = salary[i]+bonus[i];
		}
		double bonusSum =0;
		for(int j=0; j<bonus.length; j++)
		{
			bonusSum+=bonus[j];
		}
		for(int k =0;k<10;k++)
		{
			System.out.println("The old salary is "+salary[k]+" and the new salary is "+newSalary[k]);
		}
		System.out.println("Total amount to pay in bonus "+ bonusSum);
	}
}