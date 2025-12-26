import java.util.*;
public class PalindromeCheck {
    public static void main(String[] args) {
        String str = "Radar";
        // Reverse the string using StringBuilder
        String reversedStr = new StringBuilder(str).reverse().toString();

        // Compare original and reversed strings (ignoring case)
        if (str.equalsIgnoreCase(reversedStr)) {
            System.out.println(str + " is a Palindrome.");
        } else {
            System.out.println(str + " is not a Palindrome.");
        }
    }
}
