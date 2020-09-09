/*****************************************
 * File name: Main.java
 * Author: Maria Halvarsson, mahalv@kth.se
 * Date: 2020-08-31
 * Updated: 2020-09-08
 *
 * Compilation: javac LinkedStack.java
 * Execution: java LinkedStack
 *
 ******************************************/

import java.io.IOException;

/**
 * This class contains the main method.
 * The main method executes the the two implementations of a method that reads
 * characters from standard input and prints them in reverse to standard output.
 * First, the iterative implementation is executed, then the recursive implementation.
 */
public class Main {

    /**
     * This is the main method, all operations start from here.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IterativeReverseOperation iterativeOp = new IterativeReverseOperation();
        System.out.println("Enter some characters (iterative): ");
        try {
            iterativeOp.iterativeReverse();
        } catch (IOException e) {
            System.out.println("I/O error");
            e.printStackTrace();
        }

        RecursiveReverseOperation recursiveOp = new RecursiveReverseOperation();
        System.out.println("Enter some characters (recursive)");
        try {
            recursiveOp.recursiveReverse();
        } catch (IOException e) {
            System.out.println("I/O error");
            e.printStackTrace();
        }
    }
}
