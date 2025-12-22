//calculating profit and loss 
import java.util.Scanner;

public class ProfitAndLoss
{
	public static void main (String []args){
	
		
		System.out.println("Enter the costprice");
		int costprice= 129;
		
		System.out.println("Enter the sellingprice");
		int sellingprice =191 ;
		
		int Profit=sellingprice-costprice;
		System.out.println("profit is " +Profit);
		
		
		int ProfitPercentage= ((sellingprice-costprice)/costprice)*100;
		System.out.println("profit percentage is" + ProfitPercentage);
	}
}