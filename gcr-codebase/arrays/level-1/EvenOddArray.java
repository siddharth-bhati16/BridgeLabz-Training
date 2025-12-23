
import java.util.*;
public class EvenOddArray
{
    public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter a number");
		int number = sc.nextInt();
		
		
		int [] even = new int[number%2 ==0? number/2 : number/2];
		int [] odd = new int[number%2 ==0? number/2 : number/2 +1];
		
		int evenVariable=0;
		int oddVariable =0;
		
		for(int i=1; i<= number; i++)
		{
			if(i%2==0)
			{	
				even [evenVariable] = i;
				evenVariable ++;
			}
			else
			{
				odd [oddVariable] = i;
				oddVariable++;
			}
		}
		System.out.println("Even numbers are");
		for(int j=0; j<even.length; j++)
		{
			System.out.println(even[j]);
		}
			System.out.println("Odd numbers are");
		for(int k=0; k<odd.length; k++)
		{
			System.out.println(odd[k]);
		}
	}
}