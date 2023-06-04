package math_problems;

import java.util.HashSet;
public class FindLowestDifference {

    /** INSTRUCTIONS
     * Write a method to return the lowest number, that is not shared between the 2 arrays below
     * HINT: The lowest number that isn't shared between these arrays is 1.
     */

    public static void main(String[] args) {
        int[] array1 = {30, 12, 5, 9, 2, 20, 33, 1, -15};
        int[] array2 = {18, 25, 41, 47, 17, 36, 14, 19, -15};
        int lowestNumber = findLowestDifference(array1, array2);
        System.out.println("The lowest number between the 2 arrays is: " + lowestNumber);
    }

    public static int findLowestDifference(int[] array1, int[] array2) {
        HashSet<Integer> set = new HashSet<>();

        // Add all elements from array1 to the set
        for (int num : array1) {
            set.add(num);
        }

        // Remove elements from array2 that are already in the set
        for (int num : array2) {
            if (set.contains(num)) {
                set.remove(num);
            }
        }

        // Find the minimum number in the set
        int lowestNumber = Integer.MAX_VALUE;
        for (int num : set) {
            if (num < lowestNumber) {
                lowestNumber = num;
            }
        }

        return lowestNumber;
    }
}

