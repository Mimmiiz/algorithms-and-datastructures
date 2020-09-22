/********************************
 * Filename: TestAlmostSorted.java
 * Author: Maria Halvarsson, mahalv@kth.se
 * Date: 2020-09-17
 * Updated: 2020-09-21
 *
 * Compilation: javac TestAlmostSorted.java
 * Execution: java TestAlmostSorted < input.txt
 * Dependencies: Stopwatch.java
 *               InsertionSort.java
 *               MergeSort.java
 *               AlmostSortedIntegerArray.java
 *
 * This code document is a part of the sorting lab for the course ID1020
 * at kth.se.
 *
 * Test for calculating average execution times of different sorting algorithms.
 ********************************/

import utilities.AlmostSortedIntegerArray;
import utilities.Stopwatch;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class implements a test for comparing the execution times of insertion sort
 * and merge sort. A partially sorted array (half of it is sorted) is used as input for sorting.
 * The execution time is calculated in milliseconds.
 *
 * @author Maria Halvarsson
 */
public class TestAlmostSorted {
    private final Scanner scanner = new Scanner(System.in);
    private final AlmostSortedIntegerArray almostSorted = new AlmostSortedIntegerArray();

    public void testInsertionSort() {
        int[] array;
        int n;
        double insertionSortAverage = 0;

        System.out.println("-- INSERTION SORT AVERAGE TIME TEST (almost sorted array) --");
        System.out.println("Enter size of the array: ");
        array = new int[scanner.nextInt()];
        System.out.println("Enter number of times to run the algorithm:");
        n = scanner.nextInt();

        System.out.println("Run insertion sort:");
        for (int i = 0; i < n; i++) {
            almostSorted.getAlmostSortedArray(array);
            Stopwatch stopwatch = new Stopwatch();
            InsertionSort.sort(array);
            insertionSortAverage = insertionSortAverage + stopwatch.elapsedTime();
        }
        System.out.println("Average elapsed time (ms): " + insertionSortAverage / n);
    }

    public void testMergeSort() {
        int[] array;
        int n;
        double mergeSortAverage = 0;

        System.out.println("-- MERGE SORT AVERAGE TIME TEST (almost sorted array) --");
        System.out.println("Enter size of the array: ");
        array = new int[scanner.nextInt()];
        System.out.println("Enter number of times to run the algorithm:");
        n = scanner.nextInt();

        System.out.println("Run merge sort:");
        for (int i = 0; i < n; i++) {
            almostSorted.getAlmostSortedArray(array);
            Stopwatch stopwatch = new Stopwatch();
            MergeSort.sort(array);
            mergeSortAverage = mergeSortAverage + stopwatch.elapsedTime();
        }
        System.out.println("Average elapsed time (ms): " + mergeSortAverage / n);
    }

    /**
     * This is a method for testing the execution times of insertion sort
     * and merge sort when the half of the array is sorted.
     * The size of the array is taken from standard input.
     *
     * @param args the command line arguments.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TestAlmostSorted test = new TestAlmostSorted();
        int n;
        System.out.println("Enter which algorithm to test: ");
        System.out.println("Enter 1: Merge sort");
        System.out.println("Enter 2: Insertion sort");

        do {
            try {
                n = scanner.nextInt();
                if (n == 1 || n == 2)
                    break;
            } catch (InputMismatchException e) {
            } finally {
                scanner.nextLine();
            }
            System.out.println("Input must be a number between 1-2.");
        } while(true);

        switch(n) {
            case 1:
                test.testMergeSort();
                break;
            case 2:
                test.testInsertionSort();
                break;
            default:
                break;
        }
    }
}
