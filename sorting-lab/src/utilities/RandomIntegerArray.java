/*****************************************
 * Filename: RandomIntegerArray.java
 * Author: Maria Halvarsson, mahalv@kth.se
 * Date: 2020-09-17
 * Updated: 2020-09-31
 *
 * Compilation: javac RandomIntegerArray.java
 * Dependencies: none
 *
 * Creates a random integer array of desired size.
 *****************************************/
package utilities;
import java.util.Random;
import java.util.Scanner;

/**
 * This class creates a random integer array with the specified size.
 *
 * @author Maria Halvarsson
 */
public class RandomIntegerArray {
    private int[] array;
    private final Random random = new Random();

    /**
     * Initializes a new RandomIntegerArray.
     *
     * @param size the size of the array.
     */
    public RandomIntegerArray(int size) {
        array = new int[size];
    }

    /**
     * Returns a random integer array where the integer values
     * are between min and max value, 0 - 1000.
     *
     * @return the random integer array.
     */
    public int[] getRandomIntegerArray() {
        int max = 1000;
        int min = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }
        return array;
    }

    /**
     * A simple unit tests to check if a random integer array is returned.
     * The user an enter the size of the random integer array through stdin.
     * The result is printed to stdout.
     *
     * @param args the command line arguments
     */
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array;
        System.out.println("Enter size of the array: ");
        RandomIntegerArray randomArray = new RandomIntegerArray(scanner.nextInt());
        array = randomArray.getRandomIntegerArray();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]).append(", ");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }
}