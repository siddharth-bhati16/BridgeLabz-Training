import java.time.LocalDate;
import java.util.Scanner;
public class DateCheck
{
    public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);
		

        System.out.print("Enter the first date to compare (YYYY-MM-DD): ");
		
        String firstDateInput = sc.nextLine();
        LocalDate Date1 = LocalDate.parse(firstDateInput);

        System.out.print("Enter the second date to compare (YYYY-MM-DD): ");
		
       String secondDateInput = sc.nextLine();
        LocalDate Date2 = LocalDate.parse(secondDateInput);

       
        if (Date1.isBefore(Date2)) 
		{
            System.out.println("The first date is before the second date.");
        } 
		else if (Date1.isAfter(Date2))
			{
				System.out.println("The first date is after the second date.");
			} 
			else if (Date1.isEqual(Date2)) 
			{
				System.out.println("Both the dates are same.");
			}

        sc.close();
    }
}     