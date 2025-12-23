import java.util.Scanner;

public class TriangleArea {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // taking input from user as height and base 
        System.out.println("Enter the base of the triangle (centimeter) ");
        double basecentimeter = sc.nextDouble();

        System.out.println("Enter the height of the triangle (centimeter) ");
        double heightcertimeter = sc.nextDouble();

        // Calculating the area
        double areacentimeter = 0.5 * basecentimeter * heightcertimeter;

        // we know 1 cm in inches =  2.54inches)
        double areainches  = areacentimeter *2.54 ;

        // Display results
        System.out.println("Area in square centimeter" + areacentimeter );
		System.out.println("Area in square inches  " + areainches );

    }
}