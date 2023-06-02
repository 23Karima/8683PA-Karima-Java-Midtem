package string_problems;

import java.util.HashMap;
import java.util.Map;

public class DetermineLargestWord {

    /** INSTRUCTIONS
     * Implement a solution to find the length of the longest word in the given sentence below
     * Your solution should return a map containing the length of the word as the key & the word itself as the value
     * "10: biological"
     */

    public static void main(String[] args) {
        String s = "Human brain is a biological learning machine"; // given the sentence.
        // Call the findTheLargestWord method and store the result in wordNLength map
        Map<Integer, String> wordNLength = findTheLargestWord(s);

        // Iterate over the entries in the map and print them
        for (Map.Entry<Integer, String> entry : wordNLength.entrySet()) {
            System.out.println("The longest word in this given sentence is the word: "+ entry.getValue() + "\n Whose length :" + entry.getKey());
        }
    }

    public static Map<Integer, String> findTheLargestWord(String sentence) {
        // Create a map to store the length of the word as key and the word itself as value
        Map<Integer, String> map = new HashMap<>();

        // Split the sentence into an array of words using space as the delimiter
        String[] words = sentence.split(" ");

        // Variable to keep track of the maximum length of a word
        int maxLength = 0;

        // Iterate over each word in the words array
        for (String word : words) {
            int length = word.length(); // Get the length of the current word

            // Check if the length is greater than the current maximum length
            if (length > maxLength) {
                // Update the maximum length
                maxLength = length;
            }
        }

        // Iterate over the words array again
        for (String word : words) {
            // Get the length of the current word
            int length = word.length();

            // Check if the length is equal to the maximum length
            if (length == maxLength) {
                // Add the word to the map with its length as the key
                map.put(length, word);
            }
        }

        // Return the map containing the length of the longest word and the word itself
        return map;
    }
}
