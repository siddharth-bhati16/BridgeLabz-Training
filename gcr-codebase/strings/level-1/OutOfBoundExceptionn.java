import java.util.*;
public class OutOfBoundExceptionn
{

	public static void stringMethod() throws StringIndexOutOfBoundsException
	{
		String str="gcr codebase";
		int count =1;

		str = ""+str.charAt(str.length()+1);
		
	}
	
	
	public static void main(String[] args)
	{
			try { stringMethod();
			}
			catch(StringIndexOutOfBoundsException exc)
			{
			System.out.println(exc.toString());
			}
	}
	
	
}