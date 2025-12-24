import java.util.Scanner;

public class SpringSeason1
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter the month number from 1-12");
        double month = sc.nextDouble();
		
		System.out.println("enter the date number from 1-30");
        double date = sc.nextDouble();
        
		System.out.println( findingSpringSeason(month,date));
		
        

        
    }
	public static String findingSpringSeason(double month, double date)
	{
		String str;
		
	if ((month==3&& date>=20) && (month==3 && date<=30)|| 
            (month==4&& date>=1)  && (month==4 && date<=30)||
            (month==5&& date>=1)  && (month==5 && date<=30)||
	        (month==6&& date>=1)  && (month==5 && date<=20))
		{
             str = "it is a spring season "; 
        }
		else 
		{
             str = "it is not a spring season "; 
        }
			return str;
	}
}