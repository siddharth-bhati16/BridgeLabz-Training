

import java.util.Scanner;
public class ResultGenerator 
{
    public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);

        double[] marks = new double[5];
        double total = 0.0;

        for (int i = 0; i < 5; i++) 
		{
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = sc.nextDouble();
            total += marks[i];
        }

        double average = total / 5;
		
        
        int band = (int) (average / 10);
        String grade;
        switch (band) 
		{
            case 10: // 100
            case 9:  // 90-99
                grade = "A";
                break;
            case 8:  // 80-89
                grade = "B";
                break;
            case 7:  // 70-79
                grade = "C";
                break;
            case 6:  // 60-69
                grade = "D";
                break;
            default: // <60
                grade = "F";
                break;
        }

        System.out.printf("Average: %.2f | Grade: %s\n", average, grade);
        for (int i = 0; i < 5; i++) 
		{
            System.out.println("Marks in subject " + (i + 1) + ": " + marks[i]);
        }
    }
}
