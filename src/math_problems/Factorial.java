package math_problems;

public class Factorial {

    /**
     * INSTRUCTIONS
     * <p>
     * Write a method to return the Factorial of any given number using Recursion, and also another way, using iteration
     * I have not taught you recursion. Your job is to look it up, learn about it, and use it to find a solution.
     * <p>
     * HINT: Factorial of 5! = 5 x 4 X 3 X 2 X 1 = 120.
     */

    public static void main(String[] args) {
        int number = 5;
        System.out.println("Factorial using recursion: " + factorialRecursive(number));
        System.out.println("Factorial using iteration: " + factorialIterative(number));
    }

    // Method to calculate factorial using recursion
    public static int factorialRecursive(int number) {
        if (number == 0 || number == 1) {
            return 1;
        } else {
            return number * factorialRecursive(number - 1);
        }
    }

    // Method to calculate factorial using iteration
    public static int factorialIterative(int number) {
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}

