/*****************************************
 * Filename: AlmostSortedIntegerArray.java
 * Author: Maria Halvarsson, mahalv@kth.se
 * Date: 2020-09-21
 * Updated: 2020-09-21
 *
 * Compilation: javac AlmostSortedIntegerArray.java
 * Execution: java AlmostSortedIntegerArray < input.txt
 * Dependencies: none
 *
 * Returns an array where half of it is already sorted.
 *****************************************/

package utilities;

import java.util.Random;
import java.util.Scanner;

/**
 * This class returns an almost sorted integer array where half of the array
 * is already sorted, and the other half contains randomized integers.
 *
 * @author Maria Halvarsson
 */
public class AlmostSortedIntegerArray {
    private final Random random = new Random();

    // adds sorted elements to half of the array
    private void sorted(int[] array, int n) {
        for (int i = 0; i <= n; i++) {
            array[i] = i + 1;
        }
    }

    // adds unsorted elements to half of the array
    private void unsorted(int[] array, int n) {
        for (int i = n; i < array.length; i++) {
            array[i] = getRandomInt(n, array.length);
        }
    }

    // get a random integer between a min and max value
    private int getRandomInt(int min, int max){
        return random.nextInt(max - min + 1) + min;
    }

    // returns an array where half of the elements are sorted, and the other half is unsorted.
    public void getAlmostSortedArray(int[] array) {
        int n = array.length/2 - 1;
        sorted(array, n);
        unsorted(array, n + 1);
    }

    /**
     * Basic unit test to test if the array returned is an almost sorted array.
     * The user enters the size of the array through standard input.
     * The almost sorted array is printed out to standard output.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AlmostSortedIntegerArray almostSortedIntegerArray = new AlmostSortedIntegerArray();
        int[] array;
        System.out.println("Enter size of the array: ");
        array = new int[scanner.nextInt()];

        almostSortedIntegerArray.getAlmostSortedArray(array);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]).append(", ");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }
}
