package Week2;
import java.util.*;

public class Program{
	
	public static String CleanseAndInvert(String word) {
		String cleaned=word.replaceAll("\\s+","").toLowerCase();
	   return  new StringBuilder(cleaned).reverse().toString();
	}
	
	

	 public static String removeEvenAscii(String cleaned) {
	    StringBuilder filtered = new StringBuilder(cleaned);
	        
	        for (int i = 0; i < cleaned.length(); i++) {
	            char currentChar = cleaned.charAt(i);
	            if (currentChar % 2 != 0) {
	                filtered.append(currentChar);
	            }
	        }
	        
	       return filtered.toString();
	    }
	public static void main(String [] args) {
		Scanner sc =new Scanner(System.in);
		System.out.println("enter the word :");
		String word=sc.next();
		String reversed=CleanseAndInvert(word);
		String finalString=removeEvenAscii(reversed);

		
		int n=word.length();
		if(n<=6) {
			System.out.println("string length is less than 6:");
		}else {
		}
		System.out.println("generated key :" + finalString);	
	}

}
