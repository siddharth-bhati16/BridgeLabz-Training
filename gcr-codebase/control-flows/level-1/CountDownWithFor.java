import java.util.*;
public class CountDownWithFor
{	
	public static void main( String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the current start ");
		int time= sc.nextInt();
		
		for(int count=time; count >=0; count--)
		{
			System.out.println(count);
		
		}
	}
}