package Week2;

public class FitnessTracker {

    public static void main(String[] args) {

        String[] users = {
                "ram", "gopal", "ravi", "vedansh",
                "ishan", "shruti", "sita", "riya"
        };

        int[] steps = {
                8500, 12000, 9800, 15000,
                7600, 11000, 9200, 14000
        };

        System.out.println("=== STEPS BEFORE SYNC ===");
        printLeaderboard(users, steps);

        
        steps[0] += 2000; 
        steps[4] += 3000; 
        System.out.println("\n=== AFTER LAST-MINUTE SYNC ===");
        printLeaderboard(users, steps);

        bubbleSort(users, steps);

        System.out.println("\n=== DAILY LEADERBOARD ===");
        printLeaderboard(users, steps);
    }

    private static void bubbleSort(String[] users, int[] steps) {

        int n = steps.length;

        for (int i = 0; i < n - 1; i++) {

            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {

                if (steps[j] < steps[j + 1]) {

                    int tempSteps = steps[j];
                    steps[j] = steps[j + 1];
                    steps[j + 1] = tempSteps;

                    String tempUser = users[j];
                    users[j] = users[j + 1];
                    users[j + 1] = tempUser;

                    swapped = true;
                }
            }

            if (!swapped) break;
        }
    }

    private static void printLeaderboard(String[] users, int[] steps) {
        for (int i = 0; i < users.length; i++) {
            System.out.println((i + 1) + ". " +
                    users[i] + " → " + steps[i] + " steps");
        }
    }
}
