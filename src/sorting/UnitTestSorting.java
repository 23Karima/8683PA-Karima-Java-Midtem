package sorting;

import org.testng.Assert;

public class UnitTestSorting {

    /**
     * This class is used to help with unit testing of sorting algorithms from the Sort class
     */

    public static void main(String[] args) {
        // You will use these arrays to validate whether your sorting algorithm functions as expected
        int[] unSortedArray = {6, 9, 2, 5, 1, 0, 4};
        int[] sortedArray = {0, 1, 2, 4, 5, 6, 9};

        // Create instance of Sort class
        SortingAlgorithms sorting = new SortingAlgorithms();

        // Pass the unsorted array to selectionSort() method (or any method you want to unit test) from Sort class
        unSortedArray = sorting.selectionSort(unSortedArray);

        // Verify if the unsorted array is sorted by the desired method
        Assert.assertEquals(unSortedArray, sortedArray, "ARRAY IS NOT SORTED... YET!");

        //check if the bubble sort woks as expected
        unSortedArray = sorting.bubbleSort(unSortedArray);
        System.out.println("Sorted array using bubble sort: ");
        for (int num : unSortedArray) {
            System.out.println(num + " ");
            Assert.assertEquals(unSortedArray, sortedArray, "ARRAY IS NOT SORTED... YET!");
        }

        //check if the bucket sort works as expected
        unSortedArray = sorting.bucketSort(unSortedArray);
        System.out.println("Sorted array using bucket sort: ");
        for (int num : unSortedArray) {
            System.out.println(num + " ");
            Assert.assertEquals(unSortedArray, sortedArray, "ARRAY IS NOT SORTED... YET!");
        }

        //Check if the quick sorting work
        unSortedArray = sorting.quickSort(unSortedArray);
        System.out.println("Sorted array using quick sort : ");
        for (int num : unSortedArray) {
            System.out.println(num + " ");
            Assert.assertEquals(unSortedArray, sortedArray, "ARRAY IS NOT SORTED... YET!");

        }

        //Check if the shell sort works as expected
        unSortedArray = sorting.shellSort(unSortedArray);
        System.out.println("Sorted array using shell sort: ");
        for (int num : unSortedArray) {
            System.out.println(num + " ");
            Assert.assertEquals(unSortedArray, sortedArray, "ARRAY IS NOT SORTED... YET!");
        }
        // Check if the heap sort works as expected
        unSortedArray = sorting.heapSort(unSortedArray);
        System.out.println("Sorted array using heap sort: ");
        for (int num : unSortedArray) {
            System.out.println(num + " ");
            Assert.assertEquals(unSortedArray, sortedArray, "ARRAY IS NOT SORTED... YET!");
        }

        // Check if the merge sort works as expected

        unSortedArray = sorting.mergeSort(unSortedArray);
        System.out.println("Sorted array using merge sort: ");
        for (int num : unSortedArray) {
            System.out.println(num + " ");
            Assert.assertEquals(unSortedArray, sortedArray, "ARRAY IS NOT SORTED... YET!");
        }
    }
}