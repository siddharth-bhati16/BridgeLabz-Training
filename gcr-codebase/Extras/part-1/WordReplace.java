import java.util.*;
public class WordReplace {
    public static void main(String[] args) {
        String sentence = "I love Java. Java is powerful.";
        String oldWord = "Java";
        String newWord = "python";

        String result = sentence.replace(oldWord, newWord);

        System.out.println("Original: " + sentence);
        System.out.println("Modified: " + result);
    }
}
