
import java.util.*;
public class  FactorTask
{
    // factor array
    public static int[] getFactorArray(int number) 
	{
        int count = 0;
        for (int i = 1; i <= number; i++) 
		{
            if (number % i == 0) 
			{
                count++;
            }
        }
        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= number; i++) 
		{
            if (number % i == 0) 
			{
                factors[index] = i;
                index++;
            }
        }
        return factors;
    }
	
	 // product of cube of factors
    public static double getArrayCubeProduct(int[] factors) 
	{
        double product = 1;
        for (int factor : factors) 
		{
            product *= Math.pow(factor, 3);
        }
        return product;
    }
	
	
    //  the product of factors in array
    public static long getArrayProduct(int[] factors) 
	{
        long product = 1;
        for (int factor : factors) 
		{
            product *= factor;
        }
        return product;
    }

	 // to get the sum of numbers in array
    public static int getArraySum(int[] numbers) 
	{
        int sum = 0;
        for (int number : numbers) 
		{
            sum += number;
        }
        return sum;
    }
	
	
    // to find the maximum number in array
    public static int getMax(int[] numbers) 
	{
        int max = numbers[0];
        for (int number : numbers)
		{
            max = Math.max(max,number);
        }
        return max;
    }

   

   

    // main method to test all functions
    public static void main(String[] args) 
	{
        int number = 6;
        int[] factors = getFactorArray(number);
        System.out.println("Greatest Factor: " + getMax(factors));
        System.out.println("Sum of Factors: " + getArraySum(factors));
        System.out.println("Product of Factors: " + getArrayProduct(factors));
        System.out.println("Product of Cube of Factors: " + getArrayCubeProduct(factors));
    }
}