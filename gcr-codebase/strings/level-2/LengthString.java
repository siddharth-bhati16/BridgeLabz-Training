import java.util.Scanner;
public class LengthString
{
    
    public static int getLength(String str)
	{
        int length = 0;
        try {
            while (true)
			{
                str.charAt(length);
                length++;
            }
        } catch (StringIndexOutOfBoundsException e) {
        } finally 
		{
            return length;
        }
    }
	
    public static void main(String[] args)
	{
        Scanner input = new Scanner(System.in);

        String s = input.nextLine();

        System.out.println("Manual length method: " + getLength(s));
        System.out.println("In built length method: " + text.length()); 
    }
}