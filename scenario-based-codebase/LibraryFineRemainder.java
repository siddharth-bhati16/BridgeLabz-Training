
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
public class LibraryFineRemainder
{
	public static void main (String args[])
	{
		for(int i=0; i<5; i++)
		{
			findFine();
		}
		
	}
	
	//method to calculate fine
	public static void findFine()
	{
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter the return date (dd-mm-yyyy): ");
		String returnDate = sc.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date1 = LocalDate .parse(returnDate, formatter);
		
			
			System.out.println("Enter the due date (dd-mm-yyyy): ");
		String dueDate = sc.nextLine();
		LocalDate dueDate2 = LocalDate.parse(dueDate, formatter);
		
		long totalDays = ChronoUnit.DAYS.between(date1, dueDate2);
		
		//calculating and displaying fine
		System.out.println("Total fine is Rs: " + totalDays*5);
	}
}
