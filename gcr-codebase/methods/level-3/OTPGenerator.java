
import java.util.*;
public class OTPGenerator
{
    // to generate OTP array of random number 
    public int[] getOTPArray()
	{
        int []array = new int[10];

        for (int l = 0; l < 10; l++) 
		{
            double OTP = Math.random() * 900000 + 100000;
            array[l] = (int)OTP;
        }

        return array;
    }

    // check an array for duplicates 
    public boolean hasDuplicates(int []array) 
	{
        for (int i = 0; i < array.length; i++) 
		{
            for (int j = i+1; j < array.length; j++) 
			{
                if (array[j] == array[i]) 
				{
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) 
	{
        OTPGenerator object = new OTPGenerator();
        int array[] = object.getOTPArray();
        if (object.hasDuplicates(array)) 
		{
            System.out.println(" It contains duplicates");
        } 
		else 
		{
            System.out.println("It has no duplicates");
        }
    }
}