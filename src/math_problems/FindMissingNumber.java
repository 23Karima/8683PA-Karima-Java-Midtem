package math_problems;
import java.util.Arrays;
public class FindMissingNumber {

    /** INSTRUCTIONS
     * Write a method to find the missing number from the array .
     */

    public static void main(String[] args) {
        int[] array = new int[] {10, 2, 1, 4, 5, 3, 7, 8, 6};

        int missingNumber = findMissingNumber(array);
        System.out.println("The missing number is: " + missingNumber);
    }

    // Method to find the missing number in the array
    public static int findMissingNumber(int[] array) {
        // Sort the array in ascending order
        Arrays.sort(array);

        // Check if the first element is not 1
        if (array[0] != 1) {
            return 1; // 1 is the missing number
        }

        // Iterate through the array to find the missing number
        for (int i = 0; i < array.length - 1; i++) {
            int current = array[i];
            int next = array[i + 1];

            if (next - current > 1) {
                return current + 1; // Found the missing number
            }
        }

        // If no missing number is found, the missing number is the last element + 1
        return array[array.length - 1] + 1;
    }
}
