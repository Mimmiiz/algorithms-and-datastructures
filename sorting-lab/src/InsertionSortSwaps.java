/********************************
 * Filename: InsertionSortSwaps.java
 * Author: Maria Halvarsson, mahalv@kth.se
 * Date: 2020-09-15
 * Updated: 2020-09-21
 *
 * Compilation: javac InsertionSortSwaps.java
 * Execution: java InsertionSortSwaps < input.txt
 * Dependencies: none
 * Data files: sorting-lab/src/test/test2.txt
 *             sorting-lab/src/test/test3.txt
 *
 * This code document is a part of the sorting lab for the course ID1020
 * at kth.se. This code solves Assignment 2 and 3.
 *
 * Sorts a sequence of integer values from standard input using insertion sort.
 * The number of swaps and the number of inversions is printed to standard output.
 ********************************/


import java.util.Scanner;

/**
 * This class implements a method that sorts integer values in
 * ascending order using insertion sort.
 * The number of swaps is printed to standard output.
 *
 * @author Maria Halvarsson
 */
public class InsertionSortSwaps {

    /**
     * Sorts integer values in ascending order.
     * The content of the array and the number of swaps is printed to stdout.
     *
     * @param array an integer array that stores the values to be sorted.
     */
    public static void sort(int[] array) {
        int swaps = 0;

        for (int i = 1; i < array.length; i++) {
            int element = array[i];
            int j = i - 1;
            while (j >= 0 && element < array[j]) {
                array[j + 1] = array[j];
                swaps++;
                j--;
            }
            array[j + 1] = element;
            printArray(array);
        }
        System.out.println("Number of swaps: " + swaps);
    }

    /*
    prints the content of the array to standard output.
 */
    private static void printArray(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]).append(", ");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }

    /**
     * Counts the number of inversions of the input array.
     * The inversions is printed out on the format [i,a[i]], [j, a[j]],
     * where i and j are indices and a[i], a[j] are the values of the elements.
     *
     * @param array an integer array to calculate the number of inversions from.
     */
    public static void inversions(int[] array) {
        int noInversions = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    System.out.println("[" + i + ", " + array[i] + "], " + "[" + j + ", " + array[j] + "]");
                    noInversions++;
                }
            }
        }
        System.out.println("Number of inversions: " + noInversions);
    }

    /**
     * A unit test for the InsertionSortSwaps class.
     * The test takes an integer value from standard input
     * that defines the size of the array.
     * Then the user can input integers to the array to be sorted.
     * The number of inversions of the array content of the array is
     * printed to standard output.
     *
     * @param args the command line arguments.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array;
        int size;

        System.out.println("Enter array size: ");
        size = scanner.nextInt();
        System.out.println("Enter " + size + " numbers to the array: ");
        array = new int[size];

        for (int i = 0; i < array.length; i++)
            array[i] = scanner.nextInt();
        InsertionSortSwaps.inversions(array);
        InsertionSortSwaps.sort(array);
    }
}
