import java.util.*;
public class VotingEligibility
{
    public static void main(String args[])
	{
		//creating object of scanner
		Scanner sc= new Scanner(System.in);
		
		int [] age = new int[10];
		System.out.println("Enter the age of 10 students :");
		
		for( int i =0;i<10;i++)
		{
			age[i] = sc.nextInt();
		}
		
		//checking voting eligiblity
		for(int i =0; i<age.length; i++)
		{
			if(age[i]<=0)
			{
				System.out.println("Invalid age");
				continue;
			}
			if(age[i]>=18)
			{
				System.out.println("The student with the age "+age[i]+" can vote");
			}else
			{
				System.out.println("The student with the age "+age[i]+" cannot vote");
			}
		}
	}
}