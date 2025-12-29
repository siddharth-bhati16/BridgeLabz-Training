import java.util.Scanner;
public classm Palindrome
{
	 public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);
        String text = sc.next();

        
        System.out.println("Check using array " + object.checkUsingArray(text));
    }
	public static boolean checkUsingArray(String text) 
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