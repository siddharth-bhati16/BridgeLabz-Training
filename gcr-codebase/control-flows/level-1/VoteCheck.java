import java.util.Scanner;

public class VoteCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your age  ");
        double age = sc.nextDouble();
        
        

        if (age>=18) {
            System.out.println("the person can vote ");
        } else {
            System.out.println("the person cannot vote");
        }

    }
}