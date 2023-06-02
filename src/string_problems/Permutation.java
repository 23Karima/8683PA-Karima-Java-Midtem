package string_problems;
import java.util.ArrayList;
import java.util.List;
public class Permutation {

    /**
     * INSTRUCTIONS
     * Create a Java program to compute all permutations of any given string
     * <p>
     * e.g. -  "ABC" = "ABC" "ACB" "BAC" "BCA" "CAB" "CBA"
     */

    public static void main(String[] args) {
        String input = "ABC";
        List<String> permutations = computePermutations(input);

        // Print the computed permutations
        for (String permutation : permutations) {
            System.out.println(permutation);
        }
    }
    public static List<String> computePermutations(String input) {
        List<String> permutations = new ArrayList<>();
        computePermutationsHelper(input.toCharArray(), 0, permutations);
        return permutations;
    }

    private static void computePermutationsHelper(char[] inputArray, int currentIndex, List<String> permutations) {
        if (currentIndex == inputArray.length - 1) {
            permutations.add(String.valueOf(inputArray));
        } else {
            for (int i = currentIndex; i < inputArray.length; i++) {
                swap(inputArray, currentIndex, i);
                computePermutationsHelper(inputArray, currentIndex + 1, permutations);
                swap(inputArray, currentIndex, i);
            }
        }
    }

    private static void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}


