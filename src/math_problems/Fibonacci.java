package math_problems;

public class Fibonacci {

    /** INSTRUCTIONS
     * Write a method that will print or return at least 40 Fibonacci number
     * e.g. - 0,1,1,2,3,5,8,13
     **/

    public static void main(String[] args) {
        // Call the method to print Fibonacci numbers with a count of 40 Fibonnacci number
        printFibonacciNumbers(40);
    }

    /**
     * Prints the specified number of Fibonacci numbers.
     * @param count The number of Fibonacci numbers to print.
     */
    public static void printFibonacciNumbers(int count) {
        int[] fibonacci = new int[count]; // Create an array to store Fibonacci numbers
        fibonacci[0] = 0; // First Fibonacci number is 0
        fibonacci[1] = 1; // Second Fibonacci number is 1

        // Generate Fibonacci numbers starting from the third position
        for (int i = 2; i < count; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }

        // Print the Fibonacci numbers
        for (int i = 0; i < count; i++) {
            System.out.print(fibonacci[i] + " ");
        }
    }
}

