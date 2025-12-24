import java.util.*;
public class GradesCalculation
{
	public static void main(String args[])
	{
		//creating object of scanner
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the number of students");
		int students = sc.nextInt();
		
		// getting input of the subjects
		
		int [] physics= new int[students];
        int [] chemistry = new int[students];
        int [] maths = new int[students];
		double [] percentage= new double [students];
		String [] remarks= new String [students];
		
        System.out.println("Enter the marks of physics");
		for(int i=0 ; i< students; i++)
		{
			physics [i] = sc.nextInt();
			if(physics[i]<0)
			{
				System.out.println("invalid input enter correct marks again");
				i--;
			}
				
		}
    
		System.out.println("Enter the marks of chemistry");
		for(int i=0 ; i< students; i++)
		{
			physics [i] = sc.nextInt();
			if(chemistry[i]<0)
			{
				System.out.println("invalid input enter correct marks again");
				i--;
			}
				
		}
		 
		System.out.println("Enter the marks of maths");
		for(int i=0 ; i< students; i++)
		{
			physics [i] = sc.nextInt();
			if(maths[i]<0)
			{
				System.out.println("invalid input enter correct marks again");
				i--;
			}
				
		}
		  
