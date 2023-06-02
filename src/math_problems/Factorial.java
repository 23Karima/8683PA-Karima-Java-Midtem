package math_problems;

public class Factorial {

    /**
     * INSTRUCTIONS
     * <p>
     * Write a method to return the Factorial of any given number using Recursion, and also another way, using iteration
     * I have not taught you recursion. Your job is to look it up, learn about it, and use it to find a solution.
     * <p>
     * HINT: Factorial of 5! = 5 x 4 X 3 X 2 X 1 = 120
     */

    public static void main(String[] args) {

        int number = 5;

        //  recursion
        long factorialRecursive = calculateFactorialRecursive(number);
        System.out.println("Factorial (Recursive): " + factorialRecursive);

        //  iteration
        long factorialIterative = calculateFactorialIterative(number);
        System.out.println("Factorial (Iterative): " + factorialIterative);
    }

    //  calculate factorial
    public static long calculateFactorialRecursive(int number) {
        if (number == 0 || number == 1) {
            return 1;
        }
        return number * calculateFactorialRecursive(number - 1);
    }
    // Iterative method to calculate factorial
    public static long calculateFactorialIterative(int number) {
        long factorial = 1;
        for (int i = 2; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }
}

