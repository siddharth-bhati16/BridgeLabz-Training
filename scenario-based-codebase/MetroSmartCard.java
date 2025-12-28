import java.util.Scanner;

public class MetroSmartCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double balance = 100.0; 
        
        System.out.println(" Welcome to Delhi Metro ");
        
        // Loop until balance is exhausted or user quits
        while (balance > 0) {
            System.out.println("Current Balance" + balance);
            System.out.print("Enter distance in km (or enter -1 to quit): ");
            double distance = sc.nextDouble();

            // Check for quit condition
            if (distance == -1) {
                System.out.println("Exiting... Have a nice day!");
                break;
            }

            // Fare calculation using Ternary Operator
            // If distance <= 10km, fare is 20, else fare is 40
            double fare = (distance <= 10) ? 20.0 : 40.0;

            // Check for sufficient balance and deduct
            if (balance >= fare) {
                balance -= fare;
                System.out.println("Fare Deducted" + fare);
                System.out.println("Remaining Balance" + balance);
            } else {
                System.out.println("Insufficient balance for this journey. Please recharge!");
                break;
            }

            // Stop loop if balance is zero
            if (balance <= 0) {
                System.out.println("Balance exhausted. Please recharge your card.");
            }
        }
        input.close();
    }
}