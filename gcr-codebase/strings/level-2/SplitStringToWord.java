import java.util.Scanner;
public class SplitStringToWord
{
    // counting the number of words in string
    public static int countWords(String text) 
	{
        boolean isWord = false;
        int count = 0;

        for (int i=0; i<text.length();i++)
		{
            char c = text.charAt(i);
            if (c == ' ' && isWord) 
			{
                isWord = false;
            } 
			else if (c != ' ' && !isWord) 
			{
                isWord = true;
                count++;
            }
        }

        return count;
    }

    // getting positions of all spaces in string
    public static int[] getPosition(String text) 
	{
        int spaces[] = new int[countWords(text)];
        spaces[0] = -1;
        int index = 1;
        for (int i = 1; i < text.length(); i++) 
		{
            if (text.charAt(i) == ' ') 
			{
                spaces[index] = i;
                index++;
            }
        }
        return spaces;
    }

    //splitting string into words
    public static String[] splitString(String text)
	{
        int[] spaces = getPosition(text);
        int countOfWords = spaces.length;
        String []words = new String[countOfWords];

        for (int i = 0; i < countOfWords - 1; i++) 
		{
            words[i] = text.substring(spaces[i]+1,spaces[i+1]);
        }

        words[countOfWords-1] = text.substring(spaces[countOfWords-1] + 1);

        return words;
    }

    // finding length of strings
    public static int getLength(String str)
	{
        int length = 0;
        try {
            while (true) 
			{
                str.charAt(length);
                length++;
            }
        } catch (StringIndexOutOfBoundsException e) 
		{}
		finally 
		{
            return length;
        }
    }

    public static String[][] words&Length(String[] array)
	{
        String[][] array&Length = new String[array.length][2];

        for (int i = 0; i<array.length;i++) 
		{
            array&Length[i][0] = array[i];
            array&Length[i][1] = Integer.toString(getLength(array[i]));
        }

        return array&Length;
    }

    public static void main(String[] args)
	{
	
        Scanner input = new Scanner(System.in);
        String text = input.nextLine().trim();
        String[] words = splitString(text);
        String[][] result = words&Length(words);
        System.out.printf("| %10s | %6s |%n","word","length");
       
        for (String[] array : result) {
            System.out.printf("| %10s | %6d |%n", array[0] ,Integer.parseInt(array[1]) );
        }
    }
}