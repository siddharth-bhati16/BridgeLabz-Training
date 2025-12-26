import java.util.Scanner;
public class LongestWord
{
    public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String str = sc.nextLine();
        
        String longestWord = getLongestWord(str);
        System.out.println("The longest word is: " );
		System.out.println(longestWord);
        
        sc.close();
    }
    
    public static String getLongestWord(String str) 
	{
        String[] words = str.split(" ");
        String longestWord = "";
        
        for (String word : words) 
		{
            if (word.length() > longestWord.length()) 
			{
                longestWord = word;
            }
        }
        
        return longestWord;
    }
}