import java.util.Scanner;

public class FrequencyOfDigits
 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number ");
        String number = sc.nextLine(); 
       
        int[] frequency = new int[10];

        
       for(int i = 0; i < number.length(); i++) 
       {
            char ch = number.charAt(i);
            if (Character.isDigit(ch)) {
                int digit = ch - '0';
                frequency[digit]++;
            }
        }
        System.out.println("Digit Frequency:");
        for (int i = 0; i < frequency.length; i++) 
        {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + ": " + frequency[i]);
            }
        }
     
    }
}