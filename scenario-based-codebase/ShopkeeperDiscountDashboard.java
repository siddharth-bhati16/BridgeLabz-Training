
//Shopkeeper’s Discount Dashboard 

import java.util.Scanner;
public class ShopkeeperDiscountDashboard 
{
    // Constant for minimum discount 
    private static final double DISCOUNT_ABOVE = 1000.0;
    // Constant for discount rate
    private static final double DISCOUNT_RATE = 0.10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalBill = 0.0;
        int numberOfItems;

        // Prompt user for number of items
        System.out.print("Enter the number of items: ");
        numberOfItems = scanner.nextInt();

        // Loop to input item prices
        for (int i = 1; i <= numberOfItems; i++) 
		{
            System.out.print("Enter price of item " + i + ": ");
            double itemPrice = scanner.nextDouble();
            totalBill += itemPrice;
        }

        // Calculate discount if applicable
        double discount = 0.0;
        if (totalBill > DISCOUNT_ABOVE) {
            discount = totalBill * DISCOUNT_RATE;
        }

        // Calculate final amount after discount
        double finalAmount = totalBill - discount;

        // Display results
        System.out.printf("Total Bill: $%.2f%n", totalBill);
        System.out.printf("Discount: $%.2f%n", discount);
        System.out.printf("Final Amount to Pay: $%.2f%n", finalAmount);

        scanner.close(); // Close the scanner
    }
}
