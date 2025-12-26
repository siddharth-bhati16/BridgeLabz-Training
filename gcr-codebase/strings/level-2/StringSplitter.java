import java.util.*;
public class StringSplitterStringSplitter
{
		public static void main( String args[])
		{
			Scanner sc = new Scanner( System.in);
			String input = sc. nextLine();
			int length = findLengthOfString(input);
			int size = wordsCount(input);
			String [] result = new String [size];
			result = splitString(input, size, length	);
			String [][] lenArray = new String [size][2];
			lenArray = countWordLength( result);
			
			for(int i=0; i<size; i++)
			{
				System.out.println(result[i]);
			}
			
			int resultArray[] = new int[2];
			resultArray = findLongestAndShortestWord(lenArray, size);
			System.out.println("The length of longest and shortest words are as follows");
			for(int i=0; i<2; i++)
			{
				System.out.println(resultArray[i]);
			}
			
			
			
		}
		
		//method to split string into words
		public static String [] splitString(String str, int size, int length)
		{
			
			//here we split the string string int words based on spaces
			
			int j=0;
			String [] arrayOfWords = new String[size];
			
			int start =0;
			for(int i=0; i< length; i++)
			{
				if(str.charAt(i)== ' ')
				{
					arrayOfWords[j] = str.substring(start, i);
					start= i+1;
					j++;
				}
			}
			arrayOfWords[j] = str.substring(start);
			
			return arrayOfWords;
		}
		
		//method to find the length of the string
		public static int findLengthOfString(String str)
		{
			int i=0;
			try
			{
				while(true)
				{
					str.charAt(i);
					i++;
				}
			}
			catch (Exception exc)
			{
				return i;
			}
			
			
		}
		
		//method to count number of words
			public static int wordsCount(String str)
			{	
				int words=1;
				for(int i=0; i < str.length(); i++)
				{
					if (str.charAt(i) == ' ')
					{
						words++;
					}
				}
				return words;
			}
			
			
			//2D array to store words and find  length of each words
			public static String [][] countWordLength(String [] arr)
			{
				String [][] individualWordLengthArray = new String [arr.length][2];
				
				for(int i=0; i<arr.length; i++)
				{
					
						
							individualWordLengthArray[i][0] = arr[i];
						
						
						
							individualWordLengthArray[i][1]= Integer.toString((arr[i].length()));;
						
					}
				
				
				return individualWordLengthArray;
			}
			
			//method to find longest and shortest string
			
			public static int[] findLongestAndShortestWord( String [][] lenArray, int size)
			{
				int longest, shortest =0;
				longest = Integer.parseInt(lenArray[0][1]);
				shortest = Integer.parseInt(lenArray[0][1]);
				
				for(int i=1; i<size; i++)
				{
					if((Integer.parseInt(lenArray[i][1])) > longest )
					{
						longest = (Integer.parseInt(lenArray[i][1]));
					}
					else if((Integer.parseInt(lenArray[i][1])) < shortest )
					{
						shortest = (Integer.parseInt(lenArray[i][1]));
					}
				}
				
				int [] longestShortestLength = new int[2];
				longestShortestLength[0]=longest;
				longestShortestLength[1]= shortest;
				return longestShortestLength;
			}

			
}