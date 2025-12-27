import java.util.*;
public class FibonacciSeries
{
	
	public static int[] fibonacciSeries(int idx)
	{
		int [] arr = new int[idx+1];
		 arr[0]=0;
		 arr[1]=1;
		 for(int i =2;i<=idx;i++)
		 {
			 arr[i] = arr[i-1]+arr[i-2];
		 }
		 
		 
		 return arr;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		
		
		System.out.println(Arrays.toString(fibonacciSeries(n)));
	}
}
