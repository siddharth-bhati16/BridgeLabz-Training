
//school bus attendance system

import java.util.*;
public class SchoolBusAttendanceSystem
{
	
	public static void main (String args[])
	{
		
		Scanner sc = new Scanner(System.in);
		
		//creating array to store the name of students
		String [] name = new String[10];
		
		System.out.println("enter the name of the students");
		for(int i=0; i<10; i++)
		{
			name[i] = sc.next();
		}
		
		int present=0, absent =0;
		//lets mark the attendence
		for(int i=0; i<10; i++)
		{
			System.out.println("Is " + name[i] + " absent or present today?");
			String status= sc.next();
			if(status.equals("present"))
			{	present++	;}
		
			else
				absent++;
			
		}
		
		//displaying total strength of students in the bus
		System.out.println("Present: "+present + "\nAbsent: "+ absent);
	}
	
}
