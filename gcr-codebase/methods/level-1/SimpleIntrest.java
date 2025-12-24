import java.util.Scanner;

public class SimpleIntrest
 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
		
        System.out.print("Enter the principal ");
        double principal = sc.nextDouble(); 
       
	    System.out.print("Enter the rate ");
        double rate = sc.nextDouble(); 
		
		System.out.print("Enter the time ");
        double time = sc.nextDouble(); 

        double simpleintrest = (principal*rate*time)/100;
		
        
        System.out.println("The Simple Interest is" + simpleintrest + " for Principal" + principal+" Rate of Interest" + rate + "and Time" + time);
  
       
     
    }
}