import java.util.*;
public class LargestandSecondLargest
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number");
		long number = sc.nextLong();
		
		int length =10;
		long temp =number;
		long [] digit = new long[10];
		
		//storing digits in array
		while(length>0)
		{
			digit[length-1] = temp%10;
			temp/=10;
			length--;
		}

		//variable to store largest and second largest
		long max = 0;
		long secondMax =0;
		for(int i =0; i<digit.length;i++){
			if(digit[i]>max)
			{
				secondMax = max;
				max = digit[i];
			}
			else if(digit[i]>secondMax && digit[i]!=max)
			{
				secondMax = digit[i];
			}
		}
		//print the largest and second largest digit
		System.out.println("The Largest digit is :"+max);
		System.out.println("The second Largest digit is :"+secondMax);
		
	}
}