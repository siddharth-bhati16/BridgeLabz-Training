import java.util.Scanner;

public class StringEqualityChecker 
{
    public boolean isStringEqual(String str1, String str2)
	{
        if (str1.length() != str2.length())
		{
            return false;
        }

        for (int i = 0; i < str1.length(); i++)
		{
            if(str1.charAt(i) != str2.charAt(i))
			{
                return false;
            }
        }

        return true;
    }

    // compare two strings using built-in methods 
	
	
    public boolean equals(String str1, String str2) 
	{
        return str1.equals(str2);
    }

    public static void main(String[] args)
	{
        // Create Scanner and StringEqualityChecker class object
		
        Scanner sc = new Scanner(System.in);
        StringEqualityChecker obj = new StringEqualityChecker();

        String str1 = sc.next();
        String str2 = sc.next();

        boolean resultByCharAt = obj.isStringEqual(str1, str2);
        boolean result = obj.equals(str1, str2);

        System.out.println("The result with charAt method is " + resultByCharAt);
        System.out.println("The result with inbuilt method is " + result);

        if (resultByCharAt == result) {
            System.out.println("Both are equal");
        }

    }
}