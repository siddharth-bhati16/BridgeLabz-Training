import java.util.Scanner;

public class TriangleArea {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // taking input from user as height and base 
        System.out.println("Enter the base of the triangle (inches) ");
        double baseInches = sc.nextDouble();

        System.out.println("Enter the height of the triangle (inches) ");
        double heightInches = sc.nextDouble();

        // Calculating th area
        double areaInches = 0.5 * baseInches * heightInches;

        // we know 1 sq inches = 6.4516 sq cm)
        double areaCm = areaInches * 6.4516;

        // Display results
        System.out.println("Area in square inches" + areaInches  + "Area in square centimeters " + areaCm);

    }
}