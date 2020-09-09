/*********************************************************
 * File name: IterativeReverseOperation.java
 * Author: Maria Halvarsson, mahalv@kth.se
 * Date: 2020-08-31
 * Updated: 2020-09-08
 *
 * Compilation: javac IterativeReverseOperation.java
 * Execution: java IterativeReverseOperation < test-input.txt
 * Dependencies: LinkedStack.java
 * Data files: the-fundamentals-lab/task2/src/test-input.txt
 *
 * Implements a method that reads characters from stdin and
 * prints them in reverse to stdout.
 **********************************************************/

import java.io.*;

/**
 * This class implements an iterative method that reads characters from
 * standard input and prints them in reverse order to standard output.
 * The method is implemented using a stack ADT.
 */
public class IterativeReverseOperation {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /**
     * An iterative method that reads characters from standard input and
     * prints them in reverse order to standard output.
     *
     * @throws IOException if an I/O error occurs.
     */
    public void iterativeReverse() throws IOException {
        LinkedStack<Character> queue = new LinkedStack<>();
        int c;
        while ((c = reader.read()) != '\n') {
            queue.push((char)c);
        }
        System.out.println(queue);
    }

    /**
     * This is a simple unit test for the class IterativeReverseOperation.
     * The unit test tests if the input generates the expected output.
     *
     * @param args the command line arguments
     */
    public static void main (String[] args) {
        System.out.println("This is a unit test for IterativeReverseOperation class.");
        System.out.println("Test if the input generates the expected output.");
        IterativeReverseOperation reverse = new IterativeReverseOperation();
        LinkedStack<Character> stack = new LinkedStack<>();
        System.out.println("Input: ");
        System.out.println("123ABC");

        stack.push('1');
        stack.push('2');
        stack.push('3');
        stack.push('A');
        stack.push('B');
        stack.push('C');

        System.out.println("Expected output: ");
        System.out.println(stack);
        System.out.println("Output: ");
        try {
            reverse.iterativeReverse();
        } catch (IOException e) {
            System.out.println("The test did not execute correctly.");
            e.printStackTrace();
        }
    }
}
