import java.util.Scanner;
public class GradeCalculator
{
	public static void main(String []args)
	{
		Scanner sc=new Scanner(System.in);
		
        System.out.println("Enter the marks of physics, chemistry, and maths");
        int physics= sc.nextInt();
        int chemistry = sc.nextInt();
        int maths = sc.nextInt();
		
		
		double average=((physics + chemistry + maths)/300.0)*100;
        if (average >= 80) 
			{
				System.out.println("Average marks = " + average );
				System.out.println("Level 4, above agency-normalized standards");
			}
        else if (average>=70 && average<=79) 
			{
				System.out.println("Average marks = " + average );
				System.out.println("Level 3, at agency-normalized standards");
			}
		else if(average>=60 && average<=69)
			{
				System.out.println("Average marks = " + average );
				System.out.println("Level 2, below, but approaching agency-normalized standards");
			}
        else if (average>=50 && average<=59) 
			{
				System.out.println("Average marks = " + average );
				System.out.println("Level 1, well below agency-normalized standards");
			}
	    else if (average>=40 && average<=49) 
			{
				System.out.println("Average marks = " + average );
				System.out.println("Level 1-, too below agency-normalized standards");
			}
		else 
		{
			System.out.println("Average marks = " + average );
            System.out.println("Remedial standards");
		}
		
	}
}