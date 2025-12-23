//calculating discount on an university fees 
import java.util.Scanner;

public class DiscountFees
{
	public static void main (String []args){
	Scanner sc=new Scanner(System.in);
	
		System.out.println("fees of the university");
		double fees=sc.nextDouble();

        System.out.println("discount of the university");
        double discount=sc.nextDouble();
		
		double Discountfees=fees-((fees*discount)/100);

		
		System.out.println("final discounted fees is equal to   " + Discountfees);
		
		
	}
}