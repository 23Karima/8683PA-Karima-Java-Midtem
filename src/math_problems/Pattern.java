package math_problems;

public class Pattern {

    /** INSTRUCTIONS
     * Read the numbers below, identify the pattern, and then implement the logic from this pattern.
     * Once done, you should test to see if you get the same output as below:
     * 100,99,98,97,96,95,94,93,92,91,90,88,86,84,82,80,78,76,74,72,70,67,64,61,58,55,52,49,46,43,40,36,32...
     *
     */

    public static void main(String[] args) {
        int start = 100;    // Starting number
        int decrement = 1;  // Initial decrement value

        for (int i = 0; i < 34; i++) {
            System.out.print(start + ", ");  // Print the current number

            // Update the current number based on the pattern
            if (i % 11 == 10) {
                start -= 10;      // Decrease by 10 if at the end of each block
                decrement++;     // Increment the decrement value
            } else {
                start -= decrement;  // Decrease by the current decrement value
            }
        }
    }
}