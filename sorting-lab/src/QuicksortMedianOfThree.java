/********************************
 * Filename: QuicksortMedianOfThree.java
 * Author: Maria Halvarsson, mahalv@kth.se
 * Date: 2020-09-20
 * Updated: 2020-09-21
 *
 * Compilation: javac QuicksortMedianOfThree.java
 * Execution: java QuicksortMedianOfThree < input.txt
 * Dependencies: ShuffleArray.java
 * Data files: sorting-lab/src/tests/testH3.txt
 *
 * This code document is a part of the sorting lab for the course ID1020
 * at kth.se. This code is part of higher grade assignment 3.
 *
 * A quicksort algorithm that sorts integer arrays in ascending order.
 ********************************/

import utilities.ShuffleArray;

import java.util.Scanner;

/**
 * Implements a quick sort algorithm where the the array is partitioned
 * through choosing the median of three elements from the array.
 *
 * @author Maria Halvarsson
 */
public class QuicksortMedianOfThree {

    public static void sort(int[] array) {
        ShuffleArray.shuffle(array);
        quicksort(array, 0, array.length - 1);
    }

    /*
     sorts integer arrays from array[lo] to array[hi].
     The pivot element is calculated using median of three.
     */
    private static void quicksort(int[] array, int lo, int hi) {
        if (hi <= lo)
            return;
        int m = medianOfThree(array, lo, (hi - lo)/2, hi);
        swap(array, lo, m);

        int j = partition(array, lo, hi);
        quicksort(array, lo, j - 1);
        quicksort(array, j + 1, hi);
    }

    /*
    Partitions the array from array[lo] to array[hi]
    in two parts using a partitioning element v = array[hi].
    Elements smaller than v is placed on the left and elements
    bigger than v is placed on the right.
     */
    private static int partition(int[] array, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int v = array[lo];

        while(true) {
            while (v > array[++i]) {
                if (i == hi)
                    break;
            }
            while (v < array[--j]) {
                if (j == lo)
                    break;
            }
            if (j <= i)
                break;

            swap(array, i, j);
        }

        swap(array, lo, j);
        return j;
    }

    // swaps elements array[i] and array[j] in the array
    private static void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    // returns the index of the median of three values array[i], array[j] and array[k]
    private static int medianOfThree(int[] array, int i, int j, int k) {
        if ((array[i] > array[j]) != (array[i] > array[k]))
            return i;
        else if ((array[j] > array[i]) != (array[j] > array[k]))
            return j;
        else
            return k;
    }

    /**
     * A basic unit test for the QuicksortMedianOfThree class that takes input from stdin and
     * output the result to stdout. The user can enter the size and elements
     * of the integer array to be sorted. The result after sorting is printed out.
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
        QuicksortMedianOfThree.sort(array);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]).append(", ");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());

        System.out.println("Test median of threes");
        System.out.println("Enter 3 integers to find median:");
        int[] mArray = new int[3];
        for (int i = 0; i < mArray.length; i++) {
            mArray[i] = scanner.nextInt();
        }
        System.out.println("Median: " + mArray[QuicksortMedianOfThree.medianOfThree(mArray,0,1,2)]);
    }
}
