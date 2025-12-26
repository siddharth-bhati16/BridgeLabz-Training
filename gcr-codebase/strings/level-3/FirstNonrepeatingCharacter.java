import java.util.Scanner;

public class FirstNonrepeatingCharacter 
{ 



	 public static void main(String[] args) 
	{
        Scanner input = new Scanner(System.in);

        String text = input.next();
        System.out.println("The first unique char is " + getFirstNonrepeatingCharacter(text));
    }
	
	
    // to find first non repeating 
    public static char getFirstNonrepeatingCharacter(String text) 
	{
        int[] frequency = new int[256];

        for (int i = 0; i < text.length(); i++)
		{
            frequency[text.charAt(i)]++;
        }

        for (int i = 0; i < text.length(); i++) 
		
		{
            if (frequency[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }

        return ' ';
    }
   
}