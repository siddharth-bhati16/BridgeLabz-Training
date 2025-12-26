import java.util.Scanner;

public class CaseToggler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (Character.isUpperCase(ch)) {
                result.append(Character.toLowerCase(ch));
            } else if (Character.isLowerCase(ch)) {
                result.append(Character.toUpperCase(ch));
            } else {
                // Keep digits, spaces, and symbols unchanged
                result.append(ch);
            }
        }

        System.out.println("converted  String: " + result.toString());
        sc.close();
    }
}
