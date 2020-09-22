/*****************************************
 * Filename: ShuffleArray.java
 * Author: Maria Halvarsson, mahalv@kth.se
 * Date: 2020-09-21
 * Updated: 2020-09-21
 *
 * Compilation: javac ShuffleArray.java
 * Execution: java ShuffleArray < input.txt
 * Dependencies: none
 *
 * Shuffles an integer array in random order.
 *****************************************/


package utilities;

import java.util.Random;
import java.util.Scanner;

/**
 * This class implements a method for shuffling an integer array
 * using java.util.Random.
 *
 * @author Maria Halvarsson
 */
public class ShuffleArray {

    // swaps elements array[i] and array[j] in the array
    private static void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    /**
     * Shuffles the elements of an integer array.
     *
     * @param array the integer array to shuffle.
     */
    public static void shuffle(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            int randomIndex = random.nextInt(array.length);
            swap(array, randomIndex, i);
        }
    }

    /**
     * Simple unit test that test if the array is shuffled.
     * The size of the array and the elements in the array
     * is entered through standard input.
     * The result is printed to standard output.
     *
     * @param args the command line arguments.
     */
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of the array: ");
        int[] shuffleArray = new int[scanner.nextInt()];
        ShuffleArray.shuffle(shuffleArray);

        System.out.println("Enter integers to the array: ");
        for (int i = 0; i < shuffleArray.length; i++)
            shuffleArray[i] = scanner.nextInt();

        ShuffleArray.shuffle(shuffleArray);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shuffleArray.length; i++) {
            sb.append(shuffleArray[i]).append(", ");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        System.out.println("Shuffled array: " + sb.toString());
    }
}
