/********************************
 * Filename: MergeSortCutOff.java
 * Author: Maria Halvarsson, mahalv@kth.se
 * Date: 2020-09-17
 * Updated: 2020-09-21
 *
 * Compilation: javac MergeSortCutOff.java
 * Execution: java MergeSortCutOff < input.txt
 * Dependencies: none
 * Datafiles: sorting-lab/src/tests/test6.txt
 *
 * This code document is a part of the sorting lab for the course ID1020
 * at kth.se. This code is part of Assignment 6.
 *
 * Sorts a sequence of integer values from standard input using
 * merge sort with cut-off to insertion sort.
 *
 * Based on code from Princeton: https://algs4.cs.princeton.edu/22mergesort/Merge.java.html
 ********************************/

import java.util.Scanner;

/**
 * This class implements merge sort that sorts integer values in ascending order.
 * The value of cut-off to insertion sort is entered when creating a new
 * instance of this class.
 *
 * @author Maria Halvarsson
 */
public class MergeSortCutoff {
    private static final int CUTOFF = 10;

    // merge sorts the array a[lo,..,hi] using aux[lo,..,hi]
    private static void mergeSort(int[] a, int[] aux, int lo, int hi) {
        if (hi <= lo + CUTOFF - 1) {
            insertionSort(a, lo, hi);
            return;
        }
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
            if (j > hi) {
                a[k] = aux[i++];
            } else if (i > mid) {
                a[k] = aux[j++];
            } else if (aux[i] < aux[j]) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }
        }
    }

    /*
     * Sorts integer values in ascending order with insertion sort
     * from array[lo] to array[hi].
     */
    private static void insertionSort(int[] array, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            int element = array[i];
            int j = i - 1;
            while (j >= lo && element < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = element;
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
     * This is a unit test method for the MergeSortCutOff class.
     * The test takes an integer value from standard input
     * that defines the size of the array to be sorted.
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

        MergeSortCutoff.sort(array);
        MergeSortCutoff.printArray(array);
    }
}