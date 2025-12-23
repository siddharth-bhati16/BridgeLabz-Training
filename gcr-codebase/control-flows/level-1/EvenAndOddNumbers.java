import java.util.*;
public class EvenAndOddNumbers
{
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the number");
		int i = sc.nextInt();
		
		for(int j=0;j<=i;i++){
		    if(i%2==0){
		    System.out.println("even numbers are " + i );
		   }else{
		    System.out.println("odd numbers are " + i );
           }
		} 	
	}
}