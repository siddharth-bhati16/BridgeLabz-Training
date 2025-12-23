import java.util.*;
public class DimensionChange
{
    public static void main(String args[])
	{
		//creating object of scanner
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the number of rows and columns");
		int rows=sc.nextInt();
		int columns=sc.nextInt();
		
		//taking input into array
		System.out.println("Enter the elements");
		int [][] array= new int[rows][columns];
		for(int i=0; i<rows; i++)
		{
			for(int j=0; j< columns; j++)
			{
				array[i][j]=sc.nextInt();
			}
		}
		
		//1D array
		int sizeOfArray= rows*columns;
		int[] oneDarray = new int[sizeOfArray];
		int index=0;
		
		//storing the elements in 1 d array and displaying
		System.out.println("The elements are");
		for(int i=0; i<rows; i++)
		{
			for(int j=0; j< columns; j++)
			{
					oneDarray[index]=array[i][j];
					System.out.println(oneDarray[index]);
					index++;
			}
		}
	}
}