package string_problems;
import java.util.Arrays;
public class Anagram {

    /**
     * INSTRUCTIONS
     * Write a Java Program, `isAnagram`, to check if any two strings are anagrams
     * <p>
     * An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, using all of this.
     * original letters exactly once.
     * <p>
     * Ex: "CAT" & "ACT",
     * "ARMY" & "MARY",
     * "FART" & "RAFT"
     */

    // Implement Here

        public static boolean isAnagram(String word1, String word2) {
            // Convert the strings to lowercase and remove all non-alphabetic characters
            word1 = word1.replaceAll("[^a-zA-Z]", "").toLowerCase();
            word2 = word2.replaceAll("[^a-zA-Z]", "").toLowerCase();

            // Check if the lengths of the strings are equals.
            if (word1.length() != word2.length()) {
                return false;
            }

            // Convert the strings to character arrays and sort them
            char[] charArray1 = word1.toCharArray();
            char[] charArray2 = word2.toCharArray();
            Arrays.sort(charArray1);
            Arrays.sort(charArray2);

            // Compare the sorted character arrays .
            return Arrays.equals(charArray1, charArray2);
        }

        public static void main(String[] args) {
            String word1 = "CAT";
            String word2 = "ACT";
            boolean isAnagram = isAnagram(word1, word2);
            System.out.println(word1 + " and " + word2 + " are anagrams: " + isAnagram);
        }
}
