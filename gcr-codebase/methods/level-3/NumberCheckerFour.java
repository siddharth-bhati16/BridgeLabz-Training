import java.util.*;
public class NumberCheckerFour
{
    // to check if a number is prime or not 
    public static boolean isPrime(int number)
	{
        if (number <= 1) 
		{
            return false;
        }

        for (int counter = 2; counter < number; counter++) 
		{
            if (number % counter == 0) 
			{
                return false;
            }
        }
        return true;
    }

    

    // to check if a number is spy number or not
    public static boolean isSpyNumber(int number) 
	{
        int sumOfDigits = 0;
        int productOfDigits = 1;

        while (number > 0) {
            int lastDigit = number % 10;
            sumOfDigits += lastDigit;
            productOfDigits *= lastDigit;
            number /= 10;
        }

        return sumOfDigits == productOfDigits;
    }
	
	// to check if a number is Neon number or not
    public static boolean isNeonNumber(int number)
	{
        int squareOfNumber  = number*number;
        int sum = 0;

        while (squareOfNumber > 0) 
		{
            int lastDigit = squareOfNumber % 10;
            sum += lastDigit;
            squareOfNumber /= 10;
        }

        return number == sum;
    }

    // to check if a number is automorphic number or not
    public static boolean isAutomorphicNumber(int number)
	{
        int squareOfNumber = number*number;

        while (number > 0) {
            if (squareOfNumber % 10 != number % 10)
			{
                return false;
            }

            squareOfNumber /= 10;
            number /= 10;
        }

        return true;
    }

    // to check if a number is Buzz number or not
    public static boolean isBuzzNumber(int number) 
	{
        if (number % 7 == 0 || number % 10 == 7)
		{
            return true;
        } else 
		{
            return false;
        }
    }


    public static void main(String[] args) 
	{
        int number = 7;
        System.out.println("Number: " + number);
        System.out.println("Is Prime Number: " + isPrime(number));
        System.out.println("Is Neon Number: " + isNeonNumber(number));
        System.out.println("Is Spy Number: " + isSpyNumber(number));
        System.out.println("Is Automorphic Number: " + isAutomorphicNumber(number));
        System.out.println("Is Buzz Number: " + isBuzzNumber(number));
    }
}