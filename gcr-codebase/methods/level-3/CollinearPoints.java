import java.util.Scanner;
public class CollinearPoints 
{
    // checking if points are Collinear usng slope comparison
    public boolean areCollinearUsingSlope(double []x, double []y) 
	{
        double slopePoint1To2 = (y[1] - y[0]) / (x[1] - x[0]);
        double slopePoint2To3 = (y[2] - y[1]) / (x[2] - x[1]);
        double slopePoint1To3 = (y[2] - y[0]) / (x[2] - x[0]);

        return slopePoint1To2 == slopePoint2To3 && slopePoint2To3 == slopePoint1To3;
    }

    // checking if points are Collinear by checking if area made by them is 0 or not
    public boolean areCollinearUsingArea(double []x, double []y) 
	{
        double area = .5 * ((x[0] - x[1]) * (y[1] - y[2]) - (y[0] - y[1]) * (x[1] - x[2]));
        return area == 0;
    }
    
	
	public static void main(String[] args) 
	{
        // Create a Scanner object
        Scanner sc = new Scanner(System.in);
        Collinear obj = new CollinearPoints();


        double[] x = new double[3], y = new double[3];
        for (int i = 0; i < 3; i++) 
		{
            System.out.printf("Enter x%d y%d: ",i+1,i+1);
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        System.out.println("Collinearity using Slope : " + obj.areCollinearUsingSlope(x,y));
        System.out.println("Collinearity using area : " + obj.areCollinearUsingArea(x,y));

    }
}