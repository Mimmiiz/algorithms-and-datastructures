/********************************
 * Filename: TestSortingTime.java
 * Author: Maria Halvarsson, mahalv@kth.se
 * Date: 2020-09-18
 * Updated: 2020-09-21
 *
 * Compilation: javac TestSortingTime.java
 * Execution: java TestSoringTime < input.txt
 * Dependencies: RandomIntegerArray.java
 *               Stopwatch.java
 *               InsertionSort.java
 *               MergeSort.java
 *               MergeSortCutoff.java
 *               Quicksort.java
 *               QuicksortMedianOfThree
 *
 * This code document is a part of the sorting lab for the course ID1020
 * at kth.se. This class is for the tests in assignment 5 and 6.
 *
 * Test for calculating average execution time for merge sort, insertion sort,
 * merge sort with cut-off, quicksort and quicksort with median of three.
 ********************************/
import utilities.RandomIntegerArray;
import utilities.Stopwatch;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class implements tests for calculating the average execution times of
 * merge sort, insertion sort, and merge sort with cut-off by inputting
 * random integer arrays of different sizes. The user can choose the size
 * of the input arrays and how many times to run the sorting algorithm to
 * calculate an average sorting time. The result is printed to standard output.
 * The average execution time is calculated by adding all sorting times for each iteration together
 * and dividing with the total number of iterations (total time/number of iterations).
 *
 * @author Maria Halvarsson
 */
public class TestSortingTime {
    private final Scanner scanner = new Scanner(System.in);

    /**
     * A test that calculates average execution time for merge sort.
     * The user can enter the size of the random integer array to input
     * and how many times to run the sorting algorithm to calculate the average
     * execution time.
     */
    public void testMergeSort() {
        int n;
        double mergeAverage = 0;
        int[] array;
        Stopwatch stopwatch;


        System.out.println("-- MERGE SORT AVERAGE TIME TEST --");
        System.out.println("Enter size of the array to input: ");
        RandomIntegerArray randomIntArr = new RandomIntegerArray(scanner.nextInt());
        System.out.println("Enter number of times to run the sorting algorithms: ");
        n = scanner.nextInt();

        System.out.println("Run merge sort: ");
        for (int i = 0; i < n; i++) {
            array = randomIntArr.getRandomIntegerArray();
            stopwatch = new Stopwatch();
            MergeSort.sort(array);
            mergeAverage = mergeAverage + stopwatch.elapsedTime();
        }
        System.out.println("Average sorting time (ms) out of " + n + " iterations: ");
        System.out.println(mergeAverage/n);
    }

    /**
     * A test that calculates the average execution time for insertion sort.
     * The user can enter the size of the random integer array to input
     * and how many times to run the sorting algorithm to calculate the average
     * execution time.
     */
    public void testInsertionSort () {
        int n;
        double insertionAverage = 0;
        int[] array;

        System.out.println("-- INSERTION SORT AVERAGE TIME TEST --");
        System.out.println("Enter size of the array to input: ");
        RandomIntegerArray randomIntArr = new RandomIntegerArray(scanner.nextInt());
        System.out.println("Enter number of times to run the sorting algorithms: ");
        n = scanner.nextInt();

        System.out.println("Run insertion sort: ");
        for (int i = 0; i < n; i++) {
            array = randomIntArr.getRandomIntegerArray();
            Stopwatch stopwatch = new Stopwatch();
            InsertionSort.sort(array);
            insertionAverage = insertionAverage + stopwatch.elapsedTime();
        }
        System.out.println("Average sorting time (ms) out of " + n + " iterations: ");
        System.out.println(insertionAverage/n);
    }

    /**
     * A test that calculates average execution time for merge sort with cut-off.
     * The user can enter the size of the random integer array to input, the
     * size of cut-off and how many times to run the sorting algorithm to calculate
     * the average execution time.
     */
    public void testMergeSortCutoff() {
        int n;
        double mergeAverage = 0;
        int[] array;

        System.out.println("-- MERGE SORT CUT-OFF AVERAGE TIME TEST --");
        System.out.println("Enter size of the array to input: ");
        RandomIntegerArray randomIntArr = new RandomIntegerArray(scanner.nextInt());
        System.out.println("Enter number of times to run the sorting algorithms: ");
        n = scanner.nextInt();

        System.out.println("Run merge sort with cut-off: ");
        for (int i = 0; i < n; i++) {
            array = randomIntArr.getRandomIntegerArray();
            Stopwatch stopwatch = new Stopwatch();
            MergeSortCutoff.sort(array);
            mergeAverage = mergeAverage + stopwatch.elapsedTime();
        }
        System.out.println("Average sorting time (ms) out of " + n + " iterations: ");
        System.out.println(mergeAverage / n);
    }

    /**
     * A test that calculates average execution time for quicksort.
     * The user can enter the size of the random integer array to input
     * and how many times to run the sorting algorithm to calculate the average
     * execution time.
     */
    public void testQuicksort() {
        int n;
        double quicksortAverage = 0;
        int[] array;

        System.out.println("-- QUICKSORT AVERAGE TIME TEST --");
        System.out.println("Enter size of the array to input: ");
        RandomIntegerArray randomIntArr = new RandomIntegerArray(scanner.nextInt());
        System.out.println("Enter number of times to run the sorting algorithms: ");
        n = scanner.nextInt();

        System.out.println("Run quicksort:");
        for (int i = 0; i < n; i++) {
            array = randomIntArr.getRandomIntegerArray();
            Stopwatch stopwatch = new Stopwatch();
            Quicksort.sort(array);
            quicksortAverage = quicksortAverage + stopwatch.elapsedTime();
        }
        System.out.println("Average sorting time (ms) out of " + n + " iterations: ");
        System.out.println(quicksortAverage / n);
    }

    public void testQuicksortMedian3() {
        int n;
        double quicksortAverage = 0;
        int[] array;

        System.out.println("-- QUICKSORT WITH MEDIAN OF THREE AVERAGE TIME TEST --");
        System.out.println("Enter size of the array to input: ");
        RandomIntegerArray randomIntArr = new RandomIntegerArray(scanner.nextInt());
        System.out.println("Enter number of times to run the sorting algorithms: ");
        n = scanner.nextInt();

        System.out.println("Run quicksort with median of three:");
        for (int i = 0; i < n; i++) {
            array = randomIntArr.getRandomIntegerArray();
            Stopwatch stopwatch = new Stopwatch();
            QuicksortMedianOfThree.sort(array);
            quicksortAverage = quicksortAverage + stopwatch.elapsedTime();
        }
        System.out.println("Average sorting time (ms) out of " + n + " iterations: ");
        System.out.println(quicksortAverage / n);
    }

    /**
     * This is a method that implements a test for calculating average sorting time
     * for different sorting algorithms (merge sort, insertion sort, merge sort with cut-off,
     * quicksort and quicksort with median of three).
     * The user can choose which algorithm to to test through standard input.
     * The user can also enter how big the random integer array to sort should be,
     * and how many times to run the sorting algorithm to calculate the average elapsed time.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TestSortingTime test = new TestSortingTime();
        int n;
        System.out.println("Enter which algorithm to test: ");
        System.out.println("Enter 1: Merge sort");
        System.out.println("Enter 2: Insertion sort");
        System.out.println("Enter 3: Merge sort with cut-off");
        System.out.println("Enter 4: Quicksort");
        System.out.println("Enter 5: Quicksort with median of three");

        do {
            try {
                n = scanner.nextInt();
                if (n == 1 || n == 2 || n == 3 || n == 4 || n == 5)
                    break;
            } catch (InputMismatchException e) {
            } finally {
                scanner.nextLine();
            }
            System.out.println("Input must be a number between 1-5.");
        } while(true);

        switch(n) {
            case 1:
                test.testMergeSort();
                break;
            case 2:
                test.testInsertionSort();
                break;
            case 3:
                test.testMergeSortCutoff();
                break;
            case 4:
                test.testQuicksort();
                break;
            case 5:
                test.testQuicksortMedian3();
                break;
            default:
                break;
        }
    }
}
