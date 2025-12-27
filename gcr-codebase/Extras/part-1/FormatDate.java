import java.time.LocalDate;
import java.time.format.DateTimeFormatter;      
public class FormatDate
{
    public static void main(String[] args) 
	{
        LocalDate todaysDate = LocalDate.now();

        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy");

        System.out.println("Current date in dd/MM/yyyy format: " + todaysDate.format(format1));
        System.out.println("Current date in yyyy-MM-dd format: " + todaysDate.format(format2));
        System.out.println("Current date in EEE, MMM dd, yyyy format: " + todaysDate.format(format3));
    }
}