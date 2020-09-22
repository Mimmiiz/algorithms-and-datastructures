/********************************
 * Filename: InsertionSort.java
 * Author: Maria Halvarsson, mahalv@kth.se
 * Date: 2020-09-15
 * Updated: 2020-09-21
 *
 * Compilation: javac InsertionSort.java
 * Execution: java InsertionSort < input.txt
 * Dependencies: none
 * Data files: sorting-lab/src/test/test1.txt
 *
 * This code document is a part of the sorting lab for the course ID1020
 * at kth.se. This code solves Assignment 1.
 *
 * Sorts a sequence of integer values from standard input using insertion sort.
 ********************************/

import java.util.Scanner;

/**
 * This class implements a method that sorts integer values in
 * ascending order using insertion sort.
 *
 * @author Maria Halvarsson
 */
public class InsertionSort {

    /**
     * Sorts integer values in ascending order.
     *
     * @param array an integer array that stores the values to be sorted.
     */
    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int element = array[i];
            int j = i - 1;
            while (j >= 0 && element < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = element;
            //printArray(array);
        }
    }

    /*
        prints the content of the array to the standard output.
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
     * A unit test for the InsertionSort class.
     * The test takes an integer value from standard input
     * that defines the size of the array.
     * Then the user can input integers to the array to be sorted.
     * The content of the array is printed to standard output.
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
        InsertionSort.sort(array);
    }
}
