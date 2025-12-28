import java.util.Scanner;

public class BmiTracker {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner sc= new Scanner(System.in);

        System.out.println(" Maya's BMI Fitness Tracker ");

        // Step 1: Input weight in kilograms
        System.out.print("Enter weight (kg): ");
        double weight = sc.nextDouble();

        // Step 2: Input height in meters (e.g., 1.75)
        System.out.print("Enter height (meters): ");
        double height = sc.nextDouble();

        // Step 3: Calculate BMI using the formula: weight / (height * height)
        // BMI values are standard across global health organizations
        double bmiValue = weight / (height * height);

        // Step 4: Print the calculated BMI value formatted to 2 decimal places
        System.out.println("Calculated BMI: %.2f", bmiValue);

        // Step 5: Determine BMI category using if-else conditions
        if (bmiValue < 18.5) {
            System.out.println("Category: Underweight");
        } else if (bmiValue >= 18.5 && bmiValue < 25) {
            System.out.println("Category: Normal");
        } else if (bmiValue >= 25 && bmiValue < 30) {
            System.out.println("Category: Overweight");
        } else {
            // BMIs of 30 or higher are typically classified as Obese
            System.out.println("Category: Obese");
        }

        // Close the scanner resource
    }
}