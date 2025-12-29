import java.util.Scanner; 
import java.time.LocalDate;      
public class DateArithmetics
{
    public static void main(String[] args) 
	{
        Scanner scanner = new Scanner(System.in);
		
        System.out.print("Enter a date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        
        LocalDate date = LocalDate.parse(date);
        
        // Add 7 days, 1 month, and 2 years
        LocalDate changedDate = date.plusDays(7).plusMonths(1).plusYears(2);
        
        // Subtract 3 weeks
        changedDate = changedDate.minusWeeks(3);
        
        System.out.println("Modified date: " + changedDate);
        
        
    }
}