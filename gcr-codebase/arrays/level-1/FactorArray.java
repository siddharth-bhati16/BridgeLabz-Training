import java.util.*;
public class FactorArray
{
	public static void main(String args[])
	{
		//creating object of scanner
		Scanner input= new Scanner(System.in);
		
		//asking for input
		System.out.println("Enter the number");
		int number = input.nextInt();
		
		//declaring array
		int [] array = new int[10];
	    int [] temp;
		
		//variables to iterate
		int j =1;
		int index=0;
		while(j<=number)
		{
			if(number%j==0)
			{
				array[index]=j;
				index++;
			}
			if(index==array.length-1)
			{
				temp = array;
				array = new int[temp.length*2];
				
				for(int k =0;k<=index; k++)
				{
					array[k] = temp[k];
				}
			}
			j++;
		}
		System.out.println("The factors of the "+number);
		for(int m=0; m<array.length; m++)
		{	
		if(array[m]==0)
			{break;}
			System.out.println(array[m]);
			
		}
	}
}