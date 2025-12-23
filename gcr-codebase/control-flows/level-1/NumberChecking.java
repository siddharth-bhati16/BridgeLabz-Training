import java.util.Scanner;

public class NumberChecking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number ");
        double number = sc.nextDouble();
        
        

        if (number>0) {
            System.out.println("the number is positive ");
        } else if(number==0){
            System.out.println("the number is zero");
        } else {
		    System.out.println("the number is negative");
        }

    }
}