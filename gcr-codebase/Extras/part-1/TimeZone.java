import java.time.ZonedDateTime;
import java.time.ZoneId;

public class TimeZone
 {
    public static void main(String[] args) 
	{
        // Getting current time in GMT
		
        ZonedDateTime timeInGMT = ZonedDateTime.now(ZoneId.of("GMT"));
        System.out.println("Current time in GMT: " + timeInGMT);

        // Get the current time in IST
		
        ZonedDateTime timeInIST = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("Current time in IST: " + timeInIST);

        // Get the current time in PST
		
        ZonedDateTime timeInPST = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
        System.out.println("Current time in PST: " + timeInPST);
    }
}