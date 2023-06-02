package string_problems;
import java.util.HashMap;
import java.util.Map;
public class DuplicateWord {

    /** INSTRUCTIONS
     * Write a java program to find duplicate words and the number of occurrences of those words in the given string.
     * Also, find the average length of all the words
     */

    public static void main(String[] args) {
        // given the sentence.
        String st = "Java is a programming Language. Java is also an Island of Indonesia. Java is widely used language";

        //first remove punctuation marks from the sentence using the replaceAll() method with a regular expression pattern [^a-zA-Z ]
        // and convert the sentence to lowercase using the toLowerCase() method
        st = st.replaceAll("[^a-zA-Z ]", "").toLowerCase();

        // Split the sentence into words,
        String[] words = st.split(" ");//here,the space character " " is used as the delimiter to separate the sentence into individual words.

        // Create a map to store words and their occurrences
        Map<String, Integer> wordOccurrences = new HashMap<>();

        // Iterate over the words and count their occurrences.
        for (String word : words) {
            if (wordOccurrences.containsKey(word)) {
                wordOccurrences.put(word, wordOccurrences.get(word) + 1);
            } else {
                wordOccurrences.put(word, 1);
            }
        }
        // Print duplicate words and their occurrences
        System.out.println("Duplicate words and their occurrences:");
        for (Map.Entry<String, Integer> entry : wordOccurrences.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
        // Calculate the average length of all words
        int totalLength = 0;//declare an integer variable totalLength and initialize it to 0.
        for (String word : words) {
            totalLength += word.length();
        }
        //we divide the totalLength by the number of words
        double averageLength = (double) totalLength / words.length;
        //print the calculated average length of words
        System.out.println("Average length of words: " + averageLength);
    }
}




