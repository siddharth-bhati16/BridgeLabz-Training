
import java.util.*;
public class MovieTicketBooking
{
	public static void bookMovie()
	{
		String snacks = "";
		int totalsnacks=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the genre of movie you want (Horror/animated/scifi)");
		String movie = sc.next();
		
		int ticketOfGold = 225;
		int ticketOfSilver = 170;
		int totalamount = 0;
		double totalTicketPrice=0.0;
		//switch to switch between movies types
		switch (movie)
		{
			case "horror":
			System.out.println("Enter the type of seat you want (Gold/silver)");
			String seatType = sc.next();
			if(seatType.equals("gold"))
			{
				System.out.println("Enter the number of tickets");
				int numberOfTicket = sc.nextInt();
				ticketOfGold *= numberOfTicket;
				totalamount = ticketOfGold;
			}
			else
			{
				System.out.println("Enter the number of tickets");
				int numberOfTicket = sc.nextInt();
				ticketOfSilver *= numberOfTicket;
				totalamount = ticketOfSilver;
			}
			System.out.println("Do you want snacks?");
			snacks = sc.next();
			if(snacks.equals("yes"))
			{
				System.out.println("Enter the number of Snacks");
				int numberOfSnacks = sc.nextInt();
				totalsnacks = numberOfSnacks * 175;
				totalamount = totalamount + totalsnacks;
			}
			
			System.out.println("Total bill : Rs " + totalamount);
			break;
			
			case "animated":
			System.out.println("Enter the type of seat you want (gold/silver)");
			 seatType = sc.next();
			if(seatType.equals("gold"))
			{
				System.out.println("Enter the number of tickets");
				int numberOfTicket = sc.nextInt();
				ticketOfGold *= numberOfTicket;
				totalamount = ticketOfGold;
			}
			else
			{
				System.out.println("Enter the number of tickets");
				int numberOfTicket = sc.nextInt();
				ticketOfSilver *= numberOfTicket;
				totalamount = ticketOfSilver;
			}
			System.out.println("Do you want snacks?");
			snacks = sc.next();
			if(snacks.equals("yes"))
			{
				System.out.println("Enter the number of Snacks");
				int numberOfSnacks = sc.nextInt();
				 totalsnacks = numberOfSnacks * 175;
				totalamount = totalamount + totalsnacks;
			}
			
			System.out.println("Total bill : Rs " + totalamount);
			break;
			
			case "scifi":
			System.out.println("Enter the type of seat you want (gold/silver)");
			 seatType = sc.next();
			if(seatType.equals("gold"))
			{
				System.out.println("Enter the number of tickets");
				int numberOfTicket = sc.nextInt();
				ticketOfGold *= numberOfTicket;
				totalamount = ticketOfGold;
			}
			else
			{
				System.out.println("Enter the number of tickets");
				int numberOfTicket = sc.nextInt();
				ticketOfSilver *= numberOfTicket;
				totalamount = ticketOfSilver;
			}
			System.out.println("Do you want snacks?");
			 snacks = sc.next();
			if(snacks.equals("yes"))
			{
				System.out.println("Enter the number of Snacks");
				int numberOfSnacks = sc.nextInt();
				totalsnacks = numberOfSnacks * 175;
				totalamount = totalamount + totalsnacks;
			}
			
			System.out.println("Total bill : Rs " + totalamount);
			break;
			
			default:
			System.out.println("Choose the genre from given options" );
		}
			
			
				
				
	}


	public static void main(String [] args)
	{
		System.out.println("Enter the number of customers in the queue");
		Scanner sc = new Scanner (System.in);
		int numberOfCustomers = sc.nextInt();
		for(int i=1; i <= numberOfCustomers; i++)
		{
			bookMovie();
		}


	}	
}
		
			
			
	
		
	
