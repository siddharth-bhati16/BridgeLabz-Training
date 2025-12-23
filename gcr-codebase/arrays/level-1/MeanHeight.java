import java.util.*;
public class MeanHeight
{
    public static void main(String args[])
	{
		//creating object of scanner
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the height of players");
		double [] height = new double[11];
		
		//variable to store sum of height
		double sum=0;
		
		for(int i=0; i<11; i++)
		{
			height[i]=sc.nextDouble();
			sum+=height[i];
		}
		
		//mean of height storing in same variable sum
		sum=sum/11;
		
		System.out.println("Mean height of football team is " + sum);
	}
}
	