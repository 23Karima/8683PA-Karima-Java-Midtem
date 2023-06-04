package math_problems;

public class UnitTestingMath {

    /**
     * Use this class to unit test all of the classes within this package
     */

    public static void main(String[] args) {
        // Test the Factorial class
        testFactorial();

        // Test the Fibonacci class
        testFibonacci();

        // Test the FindLowestDifference class
        testFindLowestDifference();

        // Test the FindMissingNumber class
        testFindMissingNumber();

        // Test the LowestNumber class
        testLowestNumber();

        // Test the Pattern class
        testPattern();

        // Test the PrimeNumber class
        testPrimeNumber();
    }

    /**
     * Test the Factorial class.
     */
    public static void testFactorial() {
        int number = 5;
        int recursiveFactorial = Factorial.factorialRecursive(number);
        int iterativeFactorial = Factorial.factorialIterative(number);

        System.out.println("Factorial of " + number + " (Recursive): " + recursiveFactorial);
        System.out.println("Factorial of " + number + " (Iterative): " + iterativeFactorial);
    }

    /**
     * Test the Fibonacci class.
     */
    public static void testFibonacci() {
        int count = 40;
        int[] fibonacciSequence = Fibonacci.generateFibonacciSequence(count);

        System.out.print("Fibonacci Sequence:");
        for (int number : fibonacciSequence) {
            System.out.print(" " + number);
        }
        System.out.println();
    }

    /**
     * Test the FindLowestDifference class.
     */
    public static void testFindLowestDifference() {
        int[] array1 = {30, 12, 5, 9, 2, 20, 33, 1, -15};
        int[] array2 = {18, 25, 41, 47, 17, 36, 14, 19, -15};

        int lowestDifference = FindLowestDifference.findLowestDifference(array1, array2);
        System.out.println("Lowest Difference: " + lowestDifference);
    }

    /**
     * Test the FindMissingNumber class.
     */
    public static void testFindMissingNumber() {
        int[] array = new int[] {10, 2, 1, 4, 5, 3, 7, 8, 6};
        int missingNumber = FindMissingNumber.findMissingNumber(array);
        System.out.println("Missing Number: " + missingNumber);
    }

    /**
     * Test the LowestNumber class.
     */
    public static void testLowestNumber() {
        int[] array = new int[] {211, 110, 99, 34, 67, 89, 67, 456, 321, 456, 78, 90, 45, 32, 56, 78, 90, 54, 32, 123,
                67, 5, 679, 54, 32, 65};
        int lowestNumber = LowestNumber.findLowestNumber(array);
        System.out.println("Lowest Number: " + lowestNumber);
    }

    /**
     * Test the Pattern class .
     */
    public static void testPattern() {
        System.out.println("Pattern:");
        Pattern.generatePattern();
    }

    /**
     * Test the PrimeNumber class .
     */
    public static void testPrimeNumber() {
        System.out.println("Prime Numbers:");
        PrimeNumber.printPrimeNumbers(2, 1_000);
    }

}
