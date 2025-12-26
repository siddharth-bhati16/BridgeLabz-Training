import java.util.Scanner;
public class VowelAndConsonantCount
{
	
	public static void main(String[] args) 
	{
        
        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();
        int[] result = getCount(text);

        System.out.println("Vowels " + result[0]);
        System.out.println("Consonants " + result[1]);

        
        sc.close();
    }
	
	
	
    // check if a character is vowel or consonant
    public static String isVowelOrConsonant(char c)
	{
		
        if ('A' <= c && c <= 'Z')
			{
            c = (char)(c + ' ');
			}
			

        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        if ('a' <= c && c <= 'z') 
		{
            for (char vowel: vowels) 
			{
                if (vowel == c)
					{
                    return "Vowel";
					}
            }
            return "Consonant";
        } 
		else
			{
            return "Not a Letter";
			}
    }

    // counting vowels and consonants
    public static int[] getCount(String text) 
	{
		
        int vowels = 0, consonants = 0;

        for (int i=0; i < text.length(); i++) 
		{
            char c = text.charAt(i);
            String result = VowelAndConsonantCount.isVowelOrConsonant(c);
            if (result == "Vowel") 
			{
                vowels++;
            } 
			else if (result == "Consonant") 
			{
                consonants++;
            }
        }

        return new int[]{vowels,consonants};
    }

    
}