package string_problems;

public class UnitTestingStringProblem {

    /**
     Use this class to unit test all of the classes contained within this package
     */



    public static void main(String[] args) {
        // Unit tests for StringReversal class
        testStringReversal();

        // Unit tests for PalindromeChecker class
        testPalindromeChecker();

        // Add more unit tests for other classes in this package
    }

    private static void testStringReversal() {
        StringReversal stringReversal = new StringReversal();

        // Test case 1: Reverse a normal string
        String input1 = "Hello, world!";
        String expected1 = "!dlrow ,olleH";
        String result1 = stringReversal.reverseString(input1);
        System.out.println("Input: " + input1);
        System.out.println("Expected: " + expected1);
        System.out.println("Result: " + result1);
        System.out.println("Test passed? " + (result1.equals(expected1) ? "Yes" : "No"));
        System.out.println();

        // Test case 2: Reverse an empty string
        String input2 = "";
        String expected2 = "";
        String result2 = stringReversal.reverseString(input2);
        System.out.println("Input: " + input2);
        System.out.println("Expected: " + expected2);
        System.out.println("Result: " + result2);
        System.out.println("Test passed? " + (result2.equals(expected2) ? "Yes" : "No"));
        System.out.println();
    }

    private static void testPalindromeChecker() {
        PalindromeChecker palindromeChecker = new PalindromeChecker();

        // Test case 1: Check a palindrome string
        String input1 = "racecar";
        boolean expected1 = true;
        boolean result1 = palindromeChecker.isPalindrome(input1);
        System.out.println("Input: " + input1);
        System.out.println("Expected: " + expected1);
        System.out.println("Result: " + result1);
        System.out.println("Test passed? " + (result1 == expected1 ? "Yes" : "No"));
        System.out.println();

        // Test case 2: Check a non-palindrome string
        String input2 = "hello";
        boolean expected2 = false;
        boolean result2 = palindromeChecker.isPalindrome(input2);
        System.out.println("Input: " + input2);
        System.out.println("Expected: " + expected2);
        System.out.println("Result: " + result2);
        System.out.println("Test passed? " + (result2 == expected2 ? "Yes" : "No"));
        System.out.println();
    }
}

class StringReversal {
    public String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}

class PalindromeChecker {
    public boolean isPalindrome(String input) {
        String reversed = new StringBuilder(input).reverse().toString();
        return input.equalsIgnoreCase(reversed);
    }
}
