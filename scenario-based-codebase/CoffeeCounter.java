import java.util.Scanner;

public class CoffeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final double GST_RATE = 0.18; // 18% GST

        while (true) {
            System.out.println("\n--- Coffee Menu ---");
            System.out.println("1. Espresso - $3.00");
            System.out.println("2. Latte - $4.00");
            System.out.println("3. Cappuccino - $4.50");
            System.out.println("Type 'exit' to close the counter.");
            System.out.print("Enter coffee type (or 'exit'): ");
            
            String choice = sc.next().toLowerCase();

            if (choice.equals("exit")) {
                System.out.println("Closing counter. Have a great day!");
                break;
            }

            double price = 0;
            boolean validChoice = true;

            // Switch statement to determine price
            switch (choice) {
                case "espresso":
                    price = 3.00;
                    break;
                case "latte":
                    price = 4.00;
                    break;
                case "cappuccino":
                    price = 4.50;
                    break;
                default:
                    System.out.println("Invalid coffee type. Please try again.");
                    validChoice = false;
            }

            if (validChoice) {
                System.out.print("Enter quantity: ");
                int quantity = sc.nextInt();

                // Arithmetic operations
                double subtotal = price * quantity;
                double gstAmount = subtotal * GST_RATE;
                double totalBill = subtotal + gstAmount;

                System.out.printf("Subtotal: $%.2f\n", subtotal);
                System.out.printf("GST (18%%): $%.2f\n", gstAmount);
                System.out.printf("Total Bill: $%.2f\n", totalBill);
            }
        }
        sc.close();
    }
}
