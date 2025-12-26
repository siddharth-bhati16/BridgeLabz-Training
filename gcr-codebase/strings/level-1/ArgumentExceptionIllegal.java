import java.util.*;
public class ArgumentExceptionIllegal
{

	public static void illegalArg(String str)
	{
		 subString(str.length()-2,0);
	}
	public static void subString(int start, int end)
	{
		if(end<start)
		{
			throw new IllegalArgumentException();
		}
	}
	
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		try{
			illegalArg(str);
		}
		catch(IllegalArgumentException exc)
		{
			System.out.println(exc);
		}
	}
	
}