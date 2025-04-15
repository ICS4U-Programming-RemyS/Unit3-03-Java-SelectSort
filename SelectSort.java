import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;


/**.
* This program will read an array of integers from a file,
* sort it using the selection sort algorithm
*
* @author Remy Skelton
* @version 1.0
* @since 2025-04-10
*/

final class SelectionSort {

    /**
     * This is a constant for the array size.
     */
    public static final int ARRAY_SIZE = 10;

    /**
     * This is a constant for the maximum random number.
     */
    public static final int MAX_RANDOM_NUMBER = 100;

    /**
     * This is a constant for the minimum random number.
     */
    public static final int MIN_RANDOM_NUMBER = 1;

    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
    */
    private SelectionSort() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */

    public static void main(final String[] args) throws Exception {

        System.out.println("Welcome to the Selection Sort program!");
        System.out.print("This program generates a random array,");
        System.out.print("writes it to input.txt, sorts it,");
        System.out.println("and writes the result to output.txt.");

        // Read the array back from input.txt
        File inputFile = new File("input.txt");
        Scanner scanner = new Scanner(inputFile);

        // Write unsorted array to output.txt
        FileWriter outputWriter = new FileWriter("output.txt");

        // Array to hold the integers from input.txt
        int[] inputArray = new int[ARRAY_SIZE];

        // While loop to read integers from input.txt
        while (scanner.hasNextInt()) {
            // Read integers from input.txt
            for (int index = 0; index < ARRAY_SIZE; index++) {
                // Add the integers to the array
                inputArray[index] = scanner.nextInt();
            }

            // Sort the array using insertion sort
            int[] sortedArray = selectionSort(inputArray);

            // Write unsorted array to output.txt
            outputWriter.write("Sorted array: ");

            // Print the unsorted array to input.txt
            for (int index = 0; index < ARRAY_SIZE; index++) {
                outputWriter.write(sortedArray[index] + " ");
            }

            // Skip line output.txt
            outputWriter.write("\n");
        }
        // Print the unsorted array to the console
        System.out.println("Sorted array written to output.txt.");
        // Close the scanner
        scanner.close();

        // Close the output writer
        outputWriter.close();
    }

    /**
     * This method sorts an array using the selection sort algorithm.
     *
     * @param unsortedArray The array to be sorted.
     * @return The sorted array.
     */
    public static int[] selectionSort(final int[] unsortedArray) {
        // Copy the input array to avoid modifying the original
        int[] sortedArray = new int[unsortedArray.length];
        for (int index = 0; index < unsortedArray.length; index++) {
            sortedArray[index] = unsortedArray[index];
        }

        // Selection sort algorithm
        for (int currentIndex = 0;
                currentIndex < sortedArray.length - 1;
        currentIndex++) {
            // Set the current index as the minimum
            int minIndex = currentIndex;

            // Find the index of the smallest element in the unsorted part
            for (int comparisonIndex = currentIndex + 1;
                    comparisonIndex < sortedArray.length;
            comparisonIndex++) {
                // Compare the current minimum with the next element
                if (sortedArray[comparisonIndex] < sortedArray[minIndex]) {
                    // Change the minimum index if a smaller element is found
                    minIndex = comparisonIndex;
                }
            }

            // Swap the elements
            int temp = sortedArray[minIndex];
            sortedArray[minIndex] = sortedArray[currentIndex];
            sortedArray[currentIndex] = temp;
        }

        return sortedArray;
    }

}
