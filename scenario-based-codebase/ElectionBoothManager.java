import java.util.Scanner;

public class ElectionBoothManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Vote counters for candidates
        int cand1 = 0, cand2 = 0, cand3 = 0;
        final int EXIT_CODE = 0; // Special code to stop the system

        System.out.println(" Welcome to the Polling Booth ");

        while (true) {
            System.out.print("Enter your age (or enter " + EXIT_CODE + " to close booth) ");
            int age = sc.nextInt();

            // Check for exit code first
            if (age == EXIT_CODE) {
                break;
            }

            // Eligibility check using 'if'
            if (age >= 18) {
                System.out.println("Eligible to vote.");
                System.out.println("Choose Candidate: 1. Ram | 2. Shyam | 3. Sita");
                System.out.println("Enter your vote (1, 2, or 3): ");
                int vote = sc.nextInt();

                // Record vote based on candidate choice
                if (vote == 1) {
                    cand1++;
                    System.out.println("Vote recorded for ram");
                } else if (vote == 2) {
                    cand2++;
                    System.out.println("Vote recorded for shyam");
                } else if (vote == 3) {
                    cand3++;
                    System.out.println("Vote recorded for sita");
                } else {
                    System.out.println("Invalid candidate selection.");
                }
            } else {
                System.out.println("Not eligible to vote. Minimum age is 18.");
            }
        }

        // Display final tally after exiting the loop
        System.out.println(" Final Election Results ");
        System.out.println("ram " + cand1 + " votes");
        System.out.println("shyam " + cand2 + " votes");
        System.out.println("sita " + cand3 + " votes");
        System.out.println("Booth Closed.");
        
    }
}