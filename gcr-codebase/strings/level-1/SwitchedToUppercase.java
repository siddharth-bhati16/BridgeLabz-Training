import java.util.*;
public class SwitchedToUppercase
{
	
	public static String toUpper(String str2)
	{
		String str ="";
		for(int i =0;i<str2.length();i++)
		{
			if(str2.charAt(i)==' ')
			{
				str+=""+str2.charAt(i);
			}
			else
			{
				int a = (int)str2.charAt(i)-'a';
				char n = (char)(a+65);
				str+=""+n;
			}
		}
		return str;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String str2 = sc.nextLine();
		System.out.println(str2+" converted to upper case in manual way  "+toUpper(str2));
		System.out.println(str2+" converted to upper case in built in way  "+str2.toUpperCase());
	}
}