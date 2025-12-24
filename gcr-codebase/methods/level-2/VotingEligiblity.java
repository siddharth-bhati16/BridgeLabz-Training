import java.util.*;
public class VotingEligiblity
{
	
	public static boolean canStudentVote(int age)
	{
		if(age>=18)
		{
			return true;
		}
		return false;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int [] age = new int[10];
		for(int i =0;i<10;i++)
		{
			age[i] = sc.nextInt();
		}
		
		for(int i=0; i<10; i++)
		{
			if(canStudentVote(age[i]))
			{
				System.out.println("The student can vote");
			}else
			{
				System.out.println("The student can not vote");
			}
		}
	}
}