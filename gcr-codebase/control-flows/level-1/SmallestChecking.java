import java.util.Scanner;

public class SmallestChecking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first number ");
        double first = sc.nextDouble();
        
		System.out.println("Enter second number ");
        double second = sc.nextDouble();
        
		System.out.println("Enter third number: ");
        double third = sc.nextDouble();

        if (first < second && first < third) {
            System.out.println("The first number is the smallest");
        } else {
            System.out.println("The first number is not the smallest.");
        }

    }
}