import java.util.*;
public class PrintTable
{
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the number");
		int number = sc.nextInt();
		
		for(int table=6; table <=9; table++)
		{
			System.out.println( number  + " * " + table + " = " + number * table);
		}
	}
}