/********************************
 * Filename: MergeSort.java
 * Author: Maria Halvarsson, mahalv@kth.se
 * Date: 2020-09-16
 * Updated: 2020-09-21
 *
 * Compilation: javac MergeSort.java
 * Execution: java MergeSort < input.txt
 * Dependencies: none
 * Data files: sorting-lab/src/test/test5.txt
 *
 * This code document is a part of the sorting lab for the course ID1020
 * at kth.se. This code solves Assignment 5.
 *
 * Sorts a sequence of integer values from standard input using merge sort.
 *
 * Based on code from Princeton: https://algs4.cs.princeton.edu/22mergesort/Merge.java.html
 ********************************/

import java.util.Scanner;

/**
 * This class implements merge sort that sorts integer values in ascending order.
 *
 * @author Maria Halvarsson
 */
public class MergeSort {

    // merge sorts the array a[lo,..,hi] using aux[lo,..,hi]
    private static void mergeSort(int[] a, int[]aux, int lo, int hi) {
        if (hi <= lo)
            return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(a, aux, lo, mid);
        mergeSort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    /**
     * Merge sorts an integer array.
     *
     * @param a the array to be sorted.
     */
    public static void sort(int[] a) {
        int[] aux = new int[a.length];
        mergeSort(a, aux, 0, a.length - 1);
    }

    // merges the array a[lo,..,mid] and a[mid + 1,..,hi] using aux[lo,..,hi]
    private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (j > hi) { a[k] = aux[i++]; }
            else if (i > mid) { a[k] = aux[j++]; }
            else if (aux[i] < aux[j]) { a[k] = aux[i++]; }
            else { a[k] = aux[j++]; }
        }
    }

    /**
     * Prints the content of an integer array to standard output in ascending order.
     *
     * @param array the array to be printed out.
     */
    public static void printArray(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]).append(", ");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }

    /**
     * This is a unit test method for the MergeSort class.
     * The test takes an integer value from standard input
     * that defines the size of the array.
     * Then the user can input integers to the array to be sorted.
     * The content of the array is printed to standard output.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array;
        int size;

        System.out.println("Enter array size: ");
        size = scanner.nextInt();
        array = new int[size];

        System.out.println("Enter " + size + " integer numbers to the array.");
        for (int i = 0; i < array.length; i++)
            array[i] = scanner.nextInt();

        MergeSort.sort(array);
        MergeSort.printArray(array);
    }
}
