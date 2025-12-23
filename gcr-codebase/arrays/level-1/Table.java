import java.util.*;
public class Table
{
    public static void main(String args[])
	{
		//creating object of scanner
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter a number");
		int number = sc.nextInt();
		int [] tableArray= new int[10];
		
		//stroing table
		for(int i=0; i<10; i++)
		{
			tableArray[i]=number *(i+1);
		}
		//displayig table
		for(int i=0; i<10; i++)
		{
			System.out.println(number + "* " + (i+1) + " = " + tableArray[i]);
		}
	}
}
	