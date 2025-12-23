import java.util.*;
public class ReverseDigit 
{
    public static void main(String args[])
    {
        //creating scanner object
        Scanner sc= new Scanner(System.in);
        
        System.out.println("Enter a number: ");
        int number= sc.nextInt();
        int digit=0, temp=number;
        while(temp>0)
        {
            digit++;
            temp=temp/10;
        }
        int array[]= new int[digit];
        for(int i=0; i<digit; i++)
        {
            array[i]= number % 10;
            number= number / 10;
        }
        //displaying array in reverse order
        for(int j=0; j<digit; j++)
        {
            System.out.print(array[j]);
        }
    }
}