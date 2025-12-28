import.java.util.*;
public class RemoveCharacter {
    public static void main(String[] args) {
        String str = "java programming";
        char charToRemove = 'a';
        
        String result = str.replace(String.valueOf(charToRemove), "");
        
        System.out.println("Result: " + result); 
		}
		}	