//calculating current age 
import java.util.Scanner;

public class CurrentAge
{
	public static void main (String []args){
	
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the bornyear");
		int bornyear= sc.nextInt();
		
		int CurrentAge= 2024-bornyear;
		
		System.out.println("currentage of the member is  "+ CurrentAge) ;
	}
}