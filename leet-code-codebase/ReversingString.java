import java.util.*;
public class ReversingString {
    public static void main(String[] args) {
        String original = "Hello World";
        // Convert to StringBuilder, reverse it, and convert back to String
        String reversed = new StringBuilder(original).reverse().toString();
        
        System.out.println("Original: " + original);
        System.out.println("Reversed: " + reversed);
    }
}
