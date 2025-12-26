import java.util.Scanner;
public class CharacterFrequencyUsingLoop
{
    public static void main(String[] args)
	{
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
       

        // Calculating length
		
		 int length = 0;
        for (char c : str.toCharArray()) 
		{
            length++;
        }

        boolean[] visitedOrNot = new boolean[length];

        System.out.println("Character frequencies:");
        for (int i = 0; i < length; i++) 
		{
            if (visitedOrNot[i]) 
			{
                continue;
            }
            char currentChar = str.charAt(i);
            int count = 1;

            for (int j = i + 1; j < length; j++) 
			{
                if (str.charAt(j) == currentChar) 
				{
                    count++;
                    visitedOrNot[j] = true;
                }
            }
            System.out.println(currentChar + ": " + count);
        }
        sc.close();
    }
}