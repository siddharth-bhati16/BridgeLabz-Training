import java.util.*;
public class NumberCheckerOne 
{
    // count digits in a number 
    public static int getDigitCount(int number)
	{
        int digitCount = 0;
        while (number > 0)
		{
            digitCount++;
            number/=10;
        }
        return digitCount;
    }

    // get digit array using a number
    public static int[] getDigitArray(int number)
	{
        int countDigits = getDigitCount(number);
        int []digits = new int[countDigits];
        for (int i = countDigits - 1; i >= 0; i--)
		{
            digits[i] = number%10;
            number/=10;
        }
        return digits;
    }

    

    // to check if a number is armstrong number or not
    public static boolean isArmstrongNumber(int digits[])
	{
        int sum = 0;
        for (int digit : digits) 
		{
            sum += Math.pow(digit, digits.length);
        }

        for (int j = digits.length - 1; j >= 0; j--)
		{
            if (digits[counter] != sum % 10)
			{
                return false;
            }
            sum /=10;
        }
        return true;
    }
	
	// to check if a number is duck or not 
    public static boolean isDuckNumber(int []digits)
	{
        for (int digit : digits) 
		{
            if (digit == 0)
			{
                return true;
            }
        }
        return false;
    }
	
	
    // finding largest and second largest
    public static int[] getTwoLargest(int []array) 
	{
        int firstLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int number : array)
		{
            if (number > firstLargest) {
                secondLargest = firstLargest;
                firstLargest = number;
            } else if (number > secondLargest && number != firstLargest) 
			{
                secondLargest = number;
            }
        }

        return new int[]{firstLargest,secondLargest};
    }

    // to get smallest and second smallest
    public static int[] getTwoSmallest(int []array)
	{
        int firstSmallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int number : array)
		{
            if (number < firstSmallest) 
			
			{
                secondSmallest = firstSmallest;
                firstSmallest = number;
            } else if (number < secondSmallest && number != firstSmallest)
			{
                secondSmallest = number;
            }
        }

        return new int[]{firstSmallest,secondSmallest};
    }

    public static void main(String[] args) 
	{
        int number = 153;

        int digitCount = getDigitCount(number);
        int[] digits = getDigitArray(number);

        System.out.println("Digit count of " + number + ": " + digitCount);
        System.out.print("Digits: ");
        for (int digit : digits) 
		{
            System.out.print(digit + " ");
        }
        System.out.println();

        System.out.println("Is Duck Number: " + isDuckNumber(digits));
        System.out.println("Is Armstrong Number: " + isArmstrongNumber(digits));

        int[] largest = getTwoLargest(digits);
        System.out.println("Largest: " + largest[0]);
        System.out.println("Second Largest: " + largest[1]);

        int[] smallest = getTwoSmallest(digits);
        System.out.println("Smallest: " + smallest[0]);
        System.out.println("Second Smallest: " + smallest[1]);
    }
}