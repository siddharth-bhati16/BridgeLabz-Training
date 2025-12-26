import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        String str = "programming";
        
        Set<Character> set = new LinkedHashSet<>();
        for (char c : str.toCharArray()) {
            set.add(c);
        }
        
        StringBuilder sb = new StringBuilder();
        for (Character c : set) {
            sb.append(c);
        }
        
        System.out.println(sb.toString()); // Output: progamin
    }
}
