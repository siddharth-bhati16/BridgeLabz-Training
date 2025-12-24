import java.util.*;
public class Factors
{
	
	//counting factors
	
	public  int[] findFactor(int number, int factor)
	{	
		int [] arrayFactor= new int[factor];
		int divisor = 1;
		for(int i=0; i< factor; i++)
		{
			if(number % divisor ==0)
			{
				arrayFactor[i]  = divisor;
				divisor++;
			}
			else
			{
				divisor++;
			}
		}
		return arrayFactor;
	}
	
	//method to find sum of factors
	public  int sumFactor(int [] arrayFactor )
	{
		int sum=0;
		for( int i=0; i<arrayFactor.length; i++)
		{
			sum+= arrayFactor[i];
		}
		return sum;
	}
	
	//method to find product of factors
	public  int productFactor(int [] arrayFactor )
	{
		int product=1;
		for( int i=0; i<arrayFactor.length; i++)
		{
			product *= arrayFactor[i];
		}
		return product;
	}
	
	
	//method to find sum of  square of factors
	public  int sumOfSquareFactor(int [] arrayFactor )
	{
		int sumSquare=0;
		for( int i=0; i<arrayFactor.length; i++)
		{
			sumSquare+= Math.pow(arrayFactor[i], 2);
		}
		return sumSquare;
	}
	
	
	
	public static void main(String args[])
	{
		
		Scanner sc= new Scanner (System.in);
			
		System.out.println("Enter the number");
		int number= sc.nextInt();
		int temp = number;
		int factor=0;
		
		//counting factors
		int start = 1;
		while(start <= temp)
		{
			if(temp % start ==0)
			{	
				factor++;
			}
			start++;
		}
		
		//creating factor class object
		
		Factor obj = new Factor();
		
		int [] factorArray= obj.findFactor(number, factor);
		int sumOfSquareOfFactor2 =obj. sumOfSquareFactor(factorArray);
		int sum2= obj.sumFactor(factorArray); 
		int product2= obj.productFactor(factorArray);
		
		for(int i=0; i<factor;i++)
		{
			System.out.println(factorArray[i]);
		}
		System.out.println("Sum of factors = " + sum2);
		System.out.println("Sum of square of factors = " + sumOfSquareOfFactor2);
		System.out.println("product of factors = " + product2);

	}
}