import java.util.Scanner;

public class HeightConvert {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // taking height from user
        System.out.print("Enter  height in centimeter ");
        double cm = sc.nextDouble();

        // converting complete centimeter to inches
        double totalInches = cm / 2.54;

       
        int feet = (int) (totalInches / 12);
        double inches = totalInches % 12;

        System.out.printf("%.2f cm is equivalent to %d feet and %.2f inches.%n", cm, feet, inches);

     
    }
}