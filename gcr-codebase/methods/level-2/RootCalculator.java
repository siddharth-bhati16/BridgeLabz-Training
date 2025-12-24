import java.util.*;
public class RootCalculator
{
	
	public static int[] findTheRoot(int a, int b, int c)
	{
		int delta = (b*b)-4*a*c;
		int [] arr =new int[2];
		if(delta>0){
			arr[0]=(-b+((int)Math.sqrt(delta)))/(2*a);
			arr[1]=(-b-((int)Math.sqrt(delta)))/(2*a);
		}else if(delta==0){
			arr[0]=(-b/(2*a));
		}
		return arr;
	}
	
	
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		System.out.println("The roots are "+Arrays.toString(findTheRoot(a,b,c)));
	}
	
}