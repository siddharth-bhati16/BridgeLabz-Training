import java.util.Scanner;

public class MaximumRounds
 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
		
        System.out.print("Enter the length of side of triangle in kilometers  ");
        double side = sc.nextDouble(); 
       
	     

        double maximumrounds = (side*3)/5;
		
        
        System.out.println("The total number of rounds are " + maximumrounds );
  
       
     
    }
}