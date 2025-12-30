

import java.util.Scanner;

public class MetroSmartCard 
{
    private double balance;

    public MetroSmartCard(int balance) 
	{
        this.balance = balance;
		
		
    }

    public void travel()
	{
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Bhopal Metro.");

        while(true)
		{
            if (balance < 11) 
			{
                System.out.println("Cannot travel. Balance too low");
                break;
            }

            System.out.printf("Current Balance is %.2f%n",balance);
            System.out.println("For platform ticket enter 0.");
            System.out.print("Enter distance in km for your ride (-1 to exit): ");
            double distance = sc.nextDouble();

            if (distance < 0) 
			{
                System.out.println("Program Exited");
                break;
            }

            double fare = getFare(distance);
            if (fare > balance) 
			{
                System.out.println(fare);
                System.out.printf(
                        "Not enough balance to travel distance of %.2f km%n",
                        distance
                );
                continue;
            }

            balance -=fare;
            System.out.printf("The fare for %.2f km is %.2f%n",distance,fare);
        }
    }

    private double getFare(double distance) 
	{
        double fare = distance < 2 ? 11 : (distance < 5 ? 21 : (distance < 12 ? 32 : (distance < 21 ? 43 : (distance < 32 ? 54 : 64))));

        return fare;
    }
    public static void main(String[] args) 
	{
        MetroSmartCard object = new MetroSmartCard(200);

        object.travel();
    }
}
