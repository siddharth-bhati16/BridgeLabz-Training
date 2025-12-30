
import java.util.*;
public class TrainReservation
{
	public static void main (String [] args)
	{
		Scanner sc = new Scanner (System.in);
		
		//total seats and capacity
		int totalSeats =10;
		int status = 0; //number of tickets booked initially
		
		
		System.out.println("WElcome to Indian Railways");
		System.out.println("\n Press 1 for booking tickets and 2 for cancelling tickets and 3 for exit");
		
		//taking input
		int input = sc.nextInt();
		
		
		//switch case to provide the dervices as asked
		switch (input)
		{
			case 1:
			bookticket(status);
			break;
			
			case 2:
			cancelticket(status);
			break;
			
			case 3:
			System.out.println("Exiting the program");
			System.exit(0);
			break;
			
			
			default :
			System.out.println("choose a correct option");
			
			
		}
		
	}
	
	//method to book tickets
	
	public static int bookticket( int status)
	{
		Scanner sc = new Scanner(System.in);
		
		//taking input the number of tickets one wants and checking it seats are available or not
		System.out.println("Enter the number of tickets you want");
			int tickets = sc.nextInt();
			
			//if seats available is less than the total seats wanted
			if(tickets > 10 - status )
			{
				System.out.println("There is only "+ (10 - status) +" seats available");
				System.out.println("Do you want to proceed? (y/n)");
				char ch = sc.next().charAt(1);
				if(ch == 'y')
				{
					for(int i=1; i<= tickets; i++)
					{
						System.out.println("Ticket booked for " + i + "st Person. \n Seat number : "+(status+1));
						status++;
					}
				}
				else
				{
					System.exit(0);
				}
				
				
			}
			else
			{
				for(int i=1; i<= tickets; i++)
					{
						System.out.println("Ticket booked for " + i + "st Person. \n Seat number : "+(status+1));
						status++;
					}
			}
		return status;
	}
	
	//method to cancel tickets
	
	public static int cancelticket( int status)
	{
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the number of tickets you want to cancel");
			int canceltickets = sc.nextInt();
			if(canceltickets > status )
			{
				System.out.println("There is only "+ status +" seats");
				System.out.println("Enter the correct number");
			}
			else
			{
				System.out.println("your all seats were cancelled\nRefund will transferred to your account in three working days");
				status -= canceltickets;
			}
			
		return status;
	}
}
	
	
	