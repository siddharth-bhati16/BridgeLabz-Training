import java.util.*;


public class PlayersHeight 
{
    // create an array of random values in a range 
    public int[] getRandomArray(int startRange, int endRange, int size) 
	{
        int []array = new int[size];
        for (int i = 0; i < size; i++)
		{
            array[i] = (int)(Math.random()*(endRange - startRange)) + startRange;
        }
        return array;
    }

    

    // finding minimim number in array
    public int getArrayMin(int []array) {
        int min = array[0];

        for (int number : array) {
            min = Math.min(min,number);
        }

        return min;
    }
	
	//sum of all the elements in array
    public int getArraySum(int []array) 
	{
        int sum = 0;

        for (int number : array)
		{
            sum += number;
        }

        return sum;
    }

    // to finding maximum number in random
    public int getArrayMax(int []array) {
        int max = array[0];

        for (int number : array) 
		{
            max = Math.max(max,number);
        }

        return max;
    }

    // to find the mean or average for the number in array
    public double getMean(int []array) 
	{
        double sum = getArraySum(array);
        double mean = sum / array.length;

        return mean;
    }
    public static void main(String[] args) 
	{
        // create an object of Height class
        Height height = new Height();

        // Generate random array
        int[] heights = height.getRandomArray(150, 250, 11);

        // Print the array
        System.out.println("Generated heights:");
        for (int h : heights) {
            System.out.print(h + " ");
        }
        System.out.println();

        int sum = height.getArraySum(heights);
        int min = height.getArrayMin(heights);
        int max = height.getArrayMax(heights);
        double mean = height.getMean(heights);

        System.out.println("Sum: " + sum);
        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
        System.out.println("Mean: " + mean);
    }
}