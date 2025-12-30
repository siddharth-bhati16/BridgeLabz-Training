
import java.util.*;
public class TemperatureLogger
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner (System.in );
		
		//array to store the temperature
		double []temperatureArray= new double[7];
		
		
		//loop to take temperature in input and show min max and average temperatures
		for(int i=0; i<7; i++)
		{
			System.out.println("\nEnter the temperature of Day  "+ (i+1));
			temperatureArray[i] = sc.nextDouble();
			
			//displaying min max and average temperature
			
			System.out.println("\nMaximum temperature :  " + findMaxTemperature(temperatureArray) +"^C");
			System.out.println("\nMinimum temperature :  " + findMinTemperature(temperatureArray)+"^C");
			System.out.println("\nAverage temperature :  " + findAvgTemperature(temperatureArray)+"^C");
			
			
			
		}
	}
	
	
	


	//method to find max temperature
	public static double findMaxTemperature(double temperatureArray[])
	{
		double max=0.0;
		for(int i=0; i<temperatureArray.length; i++)
		{
			if(temperatureArray[i]> max)
			{
				max = temperatureArray[i];
			}
		}
		
		return max;
	}
	
	////method to find min temperature
	public static double findMinTemperature(double temperatureArray[])
	{
		double min=temperatureArray[0];
		for(int i=0; i<temperatureArray.length; i++)
		{
			if(temperatureArray[i]< min)
			{
				min = temperatureArray[i];
			}
		}
		
		return min;
	}
	
	////method to find average temperature
	public static double findAvgTemperature(double temperatureArray[])
	{
		double avg=0.0;
		double sum= 0.0;
	
		for(int i=0; i<temperatureArray.length; i++)
		{
			sum += temperatureArray[i];
		
		}
		
		avg = sum / i;
		return avg;
	}
	
}
