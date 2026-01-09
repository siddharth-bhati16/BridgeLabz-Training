package src.LinearBinarySearch;

public class FirstWordInSentence {

    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence; 
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {
            "Java is a powerful programming language",
            "Linear search is simple to implement",
            "Searching words in sentences is useful",
            "Data structures are important"
        };

        String wordToSearch = "search";

        String result = findSentenceWithWord(sentences, wordToSearch);

        System.out.println("Result: " + result);
    }
}

