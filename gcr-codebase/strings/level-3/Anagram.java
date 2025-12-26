public class Anagram 
{

	 public static void main(String[] args) 
	{
        Anagram object = new Anagram();
        boolean result = object.isAnagram("Helol","eHlol"); 
        System.out.println(result);
    }
	
	
    public boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        int []frequency = new int[256];

        for (int j = 0; j < str1.length(); j++) {
            frequency[str1.charAt(j)]++;
            frequency[str2.charAt(j)]--;
        }

        for (int freq : frequency) 
		{
            if (freq != 0) 
			{
                return false;
            }
        }

        return true;
    }
   
}