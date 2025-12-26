import java.util.*;
public class Exceptionn
{
	public static void main(String[] args)
	{
	 try{
			stringMethod();
			
		}
		catch(NullPointerException exc)
		{
			System.out.println(exc.toString());
		}
		
	
	}
	
	
	public static void stringMethod() throws NullPointerException
	{
		String str = null;
		char[] array = str.toCharArray();
		
	}

	
}