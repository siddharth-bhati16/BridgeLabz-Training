import java.util.Scanner;
public class Palindrome
{
	 public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        Palindrome object = new Palindrome();

        System.out.println("Check " + object.check(text));
        System.out.println("Check using recursion " + object.checkWithRecursion(text));
        System.out.println("Check using array " + object.checkUsingArray(text));
    }




    // checking using double pointer
	
    public boolean check(String text) 
	{
        int begin = 0, end = text.length()-1;

        while (begin <= end) 
		{
            if (text.charAt(begin) != text.charAt(end)) 
			{
                return false;
            }
            begin++;
            end--;
        }

        return true;
    }

    // checking  using recursion
	
    public boolean checkWithRecursion(String text, int begin, int end) 
	{
        if (begin >= end) 
		{
            return true;
        }

        if (text.charAt(begin) != text.charAt(end)) 
		{
            return false;
        }

        return checkWithRecursion(text,begin+1,end-1);
    }

    public boolean checkWithRecursion(String text) 
	{
        return checkWithRecursion(text, 0, text.length()-1);
    }

    public String reverse(String text){
        String newString = "";
        for (int i = text.length()-1; i >= 0 ; i--) 
		{
            newString += text.charAt(i);
        }

        return newString;
    }
	
    // check using array
	
    public boolean checkUsingArray(String text) 
	{
        char[] array1 = text.toCharArray();
        char[] array2 = reverse(text).toCharArray();

        for (int i = 0; i < array1.length; i++) 
		{
            if (array1[i] != array2[i]) 
			{
                return false;
            }
        }
        return true;
    }
   
}