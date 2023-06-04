package math_problems;

public class PrimeNumber {

    /** INSTRUCTIONS
     * Write a method to print a list of all prime numbers from 2 to 1,000.
     *  Print out the prime numbers in the given range.
     *  -------------------------------------------------
     * BONUS: Figure out how to improve algorithmic efficiency
     */


    public static void main(String[] args) {
        printPrimeNumbers(2, 1_000);
    }

    /**
     * Prints all prime numbers in the given range.
     *
     * @param start the starting number of the range
     * @param end   the ending number of the range
     */
    public static void printPrimeNumbers(int start, int end) {
        for (int number = start; number <= end; number++) {
            if (isPrime(number)) {
                System.out.println(number);
            }
        }
    }

    /**
     * Checks if a given number is prime .
     *
     * @param number the number to check for primality
     * @return true if the number is prime, false otherwise
     */
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int divisor = 2; divisor <= Math.sqrt(number); divisor++) {
            if (number % divisor == 0) {
                return false;
            }
        }
        return true;
    }
}