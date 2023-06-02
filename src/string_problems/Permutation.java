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


