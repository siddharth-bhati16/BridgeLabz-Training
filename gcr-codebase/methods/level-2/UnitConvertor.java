import java.util.*;
public class UnitConvertor
{
	
	
	//method to convert km to mile
	public static double convertKmToMiles(double km)
	{
		return km * 0.621371;
	
	}
	
	//method to convert mile to km
	public static double convertMilesToKm(double miles)
	{
		return miles * 1.60934;
	
	}
	
	//method to convert meter to feet
	public static double convertMeterToFeet(double meter)
	{
		return meter * 3.28084;
	
	}
	
	//method to convert feet to meter
	public static double convertFeetToMeter(double feet)
	{
		return f * 0.3048;
	
	}
	
	public static void main(String[] args)
	{
		//creating object of scanner class and taking input
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the distances to be converted");
		double km = sc.nextDouble();
		double miles = sc.nextDouble();
		double meter = sc.nextDouble();
		double feet = sc.nextDouble();
		
		System.out.println("km to miles "+convertKmToMiles(km));
		System.out.println("miles to km "+convertMilesToKm(miles));
		System.out.println("meter to feet "+convertMeterToFeet(meter));
		System.out.println("feet to meter "+convertFeetToMeter(feet));
		
	}
}