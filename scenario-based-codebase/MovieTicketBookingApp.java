import java.util.Scanner;

public class MovieTicketBookingApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean moreCustomers = true;

        while (moreCustomers) {

            int totalCost = 0;

            // Movie Type
            System.out.println("Select Movie Type:");
            System.out.println("1. Action");
            System.out.println("2. Comedy");
            System.out.println("3. Horror");
            int movieChoice = sc.nextInt();

            switch (movieChoice) {
                case 1:
                    totalCost += 200;
                    System.out.println("Action movie selected.");
                    break;
                case 2:
                    totalCost += 180;
                    System.out.println("Comedy movie selected.");
                    break;
                case 3:
                    totalCost += 220;
                    System.out.println("Horror movie selected.");
                    break;
                default:
                    System.out.println("Invalid movie choice.");
                    continue;
            }

            // Seat Type
            System.out.println("Select Seat Type (Gold/Silver):");
            String seatType = scanner.next();

            if (seatType.equalsIgnoreCase("Gold")) {
                totalCost += 150;
            } else if (seatType.equalsIgnoreCase("Silver")) {
                totalCost += 100;
            } else {
                System.out.println("Invalid seat type.");
                continue;
            }

            // Snacks
            System.out.println("Do you want snacks? (yes/no):");
            String wantsSnacks = scanner.next();

            if (wantsSnacks.equalsIgnoreCase("yes")) {
                totalCost += 80;
            }

            // Final Bill
            System.out.println("Total Ticket Price: ₹" + totalCost);

            // Another customer
            System.out.println("Book ticket for another customer? (yes/no):");
            String choice = scanner.next();

            if (!choice.equalsIgnoreCase("yes")) {
                moreCustomers = false;
            }

            System.out.println("----------------------------");
        }

        scanner.close();
        System.out.println("Thank you for using Movie Ticket Booking App 🎬");
    }
}
