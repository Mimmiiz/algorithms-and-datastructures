/*****************************************
 * Filename: Stopwatch.java
 * Author: Maria Halvarsson, mahalv@kth.se
 * Date: 2020-09-17
 * Updated: 2020-09-17
 *
 * Compilation: javac Stopwatch.java
 * Dependencies: none
 *
 * A utility class to measure the running time of a program.
 *****************************************/

package utilities;

/**
 * This class implements a stopwatch for measuring
 * the time that elapses between the start and end
 * of a programming execution. The execution time is
 * measured in milliseconds.
 */
public class Stopwatch {
    private final long start;

    /**
     * Initializes a new stopwatch.
     *
     * @author Maria Halvarsson
     */
    public Stopwatch() {
        start = System.nanoTime();
    }

    /**
     * Calculates the elapsed time since the stopwatch was created
     * and returns the result (in milliseconds).
     *
     * @return the elapsed time (in milliseconds) since the stopwatch was created.
     */
    public double elapsedTime() {
        long now = System.nanoTime();
        return (now - start) / 1000000.0;
    }
}
