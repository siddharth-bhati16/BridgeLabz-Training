import java.util.Scanner;
public class BonusCalculator 
{
    
	// get an array of random values in a range 
	
    public double[] getRandomArray(int startRange, int endRange, int size) 
	{
        endRange++;
        double []array = new double[size];

        for (int i = 0; i < size; i++) 
		{
            int randomValue = (int) ((endRange - startRange) * Math.random() + startRange);
            array[i] = randomValue;
        }

        return array;
    }

    // calculating new salary and Bonus using salary and years of service 
	//using 2D array
	
    public double[][] getNewSalary&Bonus(double []salary, double []yearsOfService)
	{
        int size = Math.min(salary.length, yearsOfService.length);
        double [][]newSalaryAndBonus = new double[2][size];

        for (int j = 0; j < size; j++) 
		{
            double bonus;
            if (yearsOfService[j] < 5) 
			{
                bonus = salary[j] * .02;
            } else 
			{
                bonus = salary[j] * .05;
            }

            newSalaryAndBonus[0][j] = salary[j] + bonus;
            newSalaryAndBonus[1][j] = bonus;
        }
        return newSalaryAndBonus;
    }

    // to get sum of array elements
    public double getArraySum(double []array)
	
	{
        double sum = 0;
        for (double element : array)
		{
            sum+=element;
        }
        return sum;
    }

    public static void main(String[] args) 
	{
        BonusCalculator object = new BonusCalculator();

        double []salary = object.getRandomArray(10000, 99999, 10);
        double []yearsOfService = object.getRandomArray(0,10, 10);
        double [][]newSalaryAndBonus = object.getNewSalary&Bonus(salary,yearsOfService);
        
        
        System.out.printf("| %9s | %9s | %9s | %9s |%n","salary","YearofSer","newSalary","bonus");
        
        for (int k = 0; k < 10; k++) 
		{
            System.out.printf("| %9.2f | %9.0f | %9.2f | %9.2f |%n",salary[k],yearsOfService[k],newSalaryAndBonus[0][k],newSalaryAndBonus[1][k]);
        }
        

        System.out.println("Total old salary is " + object.getArraySum(salary));
        System.out.println("Total new salary is " + object.getArraySum(newSalaryAndBonus[0]));
        System.out.println("Total bonus is "+object.getArraySum(newSalaryAndBonus[1]));
    }
}