package math_problems;

public class LowestNumber {

    /** INSTRUCTIONS
     * Write a method to find the lowest number from this array.
     */

    public static void main(String[] args) {

        int[] array = new int[] {211, 110, 99, 34, 67, 89, 67, 456, 321, 456, 78, 90, 45, 32, 56, 78, 90, 54, 32, 123,
                67, 5, 679, 54, 32, 65};
        // Find the lowest number in the array
        int lowestNumber = findLowestNumber(array);

        // Print the lowest number
        System.out.println("The lowest number is: " + lowestNumber);
    }

    /**
     * Finds the lowest number in the given array.
     *
     * @param array the array of numbers
     * @return the lowest number in the array.
     */
    public static int findLowestNumber(int[] array) {
        int lowest = array[0]; // Assume the first element is the lowest

        // Iterate through the array starting from the second element
        for (int i = 1; i < array.length; i++) {
            if (array[i] < lowest) {
                lowest = array[i]; // Update the lowest number if a smaller number is found
            }
        }

        return lowest;
    }
}

