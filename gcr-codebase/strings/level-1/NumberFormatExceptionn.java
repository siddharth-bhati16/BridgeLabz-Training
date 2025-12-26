import java.util.*;
public class NumberFormatExceptionn
{

	public static void generator(String str)
	{
		int a = Integer.parseInt(str);
	}
	
	
	public static void main(String[] args)
	{
	
		//creating scanner object
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		//using try catch block for exception
		
		try{
			generator(s);
		}
		catch(Exception exc)
		{
			System.out.println(exc);
		}
	}
	
	
}