import java.util.*;
public class ArrayIndexOutOfBoundsExceptionn
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String[] str = new String[num];
		for(int j=0; j<num; j++)
		{
			str[j] = sc.next();
		}
		
		try{
			generateExc(str,num);
		}
		catch(Exception exc)
		{
			System.out.println(exc);
		}
	}
	
	public static void generateExc(String[] str, int num){
		String str = str[n+1];
	}
}