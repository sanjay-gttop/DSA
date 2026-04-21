/**
 * This program implements the Selection Sort algorithm to sort an array of integers
 * in ascending order. Selection Sort works by repeatedly finding the minimum element
 * from the unsorted part of the array and placing it at the beginning.
 * 
 * - In-place sorting 
 * - Simple and easy to understand
 * - Includes a method to print the array before and after sorting
 * 
 * Time Complexity:
 * - Best Case: O(n^2)  -> Even if the array is sorted, comparisons are made
 * - Worst Case: O(n^2) -> Array in reverse order
 * - Average Case: O(n^2) -> Random order array
 */

public class SelectionSort {

    // Method to perform selection sort on an array
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Method to print the array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] numbers = {64, 25, 12, 22, 11};
        System.out.println("Original array:");
        printArray(numbers);

        selectionSort(numbers);

        System.out.println("Sorted array:");
        printArray(numbers);
    }
}
