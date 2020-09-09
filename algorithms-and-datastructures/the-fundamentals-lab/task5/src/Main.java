/*************************************
 * File name: Main.java
 * Author: Maria Halvarsson, mahalv@kth.se
 * Date: 2020-09-08
 * Updated: 2020-09-09
 *
 * Compilation: javac Main.java
 * Execution: java Main
 *
 *************************************/

/**
 * This class contains the main method. The class shows the enqueue
 * and dequeue of the GeneralizedQueue. After each insertion and deletion
 * of an element in the queue, the content is printed out.
 */
public class Main {

    /**
     * This is the main method, all operations start from here.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneralizedQueue<Character> queue = new GeneralizedQueue<>();
        queue.enqueue('1');
        System.out.println(queue);
        queue.enqueue('2');
        System.out.println(queue);
        queue.enqueue('3');
        System.out.println(queue);
        queue.enqueue('a');
        System.out.println(queue);
        queue.enqueue('b');
        System.out.println(queue);
        queue.enqueue('c');
        System.out.println(queue);

        System.out.println("Remove from index 6:");
        queue.dequeue(6);
        System.out.println(queue);
        System.out.println("Remove from index 1:");
        queue.dequeue(1);
        System.out.println(queue);
        System.out.println("Remove from index 3:");
        queue.dequeue(3);
        System.out.println(queue);
        System.out.println("Remove from index 2:");
        queue.dequeue(2);
        System.out.println(queue);
        System.out.println("Remove from index 2:");
        queue.dequeue(2);
        System.out.println(queue);
        System.out.println("Remove from index 1:");
        queue.dequeue(1);
        System.out.println(queue);
    }
}
