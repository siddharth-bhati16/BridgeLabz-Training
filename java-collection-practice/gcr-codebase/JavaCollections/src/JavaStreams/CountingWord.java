package JavaStreams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CountingWord{

    public static void main(String[] args) {

        String filePath = "input.txt";
        HashMap<String, Integer> wordCountMap = new HashMap<>();

        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = br.readLine()) != null) {
                line = line.toLowerCase().replaceAll("[^a-z0-9 ]", "");
                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }

            List<Map.Entry<String, Integer>> list =
                    new ArrayList<>(wordCountMap.entrySet());

            list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

            System.out.println("Top 5 most frequent words:");
            for (int i = 0; i < Math.min(5, list.size()); i++) {
                System.out.println(list.get(i).getKey() + " : " + list.get(i).getValue());
            }

        } catch (IOException e) {
            System.out.println("Error reading the file.");
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                System.out.println("Error closing the file.");
            }
        }
    }
}
