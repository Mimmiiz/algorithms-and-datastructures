/*************************************
 * File name: Main.java
 * Author: Maria Halvarsson, mahalv@kth.se
 * Date: 2020-09-03
 * Updated: 2020-09-08
 *
 * Compilation: javac Main.java
 * Execution: java Main
 *************************************/

/**
 * This class contains the the main method.
 * This class shows the insertion/deletion of elements
 * from the OrderedQueue.
 * After each insertion/deletion, the content of the
 * queue is printed out.
 */
public class Main {

    /**
     * This is the main method, operation starts from here.
     *
     * @param args the command-lie arguments
     */
    public static void main(String[] args) {
        OrderedQueue queue = new OrderedQueue();
        queue.enqueue(10);
        System.out.println(queue);
        queue.enqueue(9);
        System.out.println(queue);
        queue.enqueue(9);
        System.out.println(queue);
        queue.enqueue(20);
        System.out.println(queue);
        queue.enqueue(1);
        System.out.println(queue);
        queue.enqueue(3);
        System.out.println(queue);
        queue.enqueue(7);
        System.out.println(queue);

        queue.dequeue();
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
    }
}
