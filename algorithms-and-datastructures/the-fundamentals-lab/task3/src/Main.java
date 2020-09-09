/*************************************
 * File name: Main.java
 * Author: Maria Halvarsson, mahalv@kth.se
 * Date: 2020-08-03
 * Updated: 2020-09-08
 *
 * Compilation: javac Main.java
 * Execution: java Main
 *************************************/

/**
 * This class contains the main method where the execution starts.
 * This class will show the enqueue and dequeue of the
 * DoublyLinkedCircularQueue. The content of the queue is printed
 * after each insertion/deletion of an element.
 */
public class Main {

    /**
     * This is the main method, execution starts from here.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DoublyLinkedCircularQueue<Integer> queue = new DoublyLinkedCircularQueue<>();
        System.out.println("Enqueue: 1");
        queue.enqueue(1);
        System.out.println(queue);
        System.out.println("Enqueue: 2");
        queue.enqueue(2);
        System.out.println(queue);
        System.out.println("Enqueue: 3");
        queue.enqueue(3);
        System.out.println(queue);

        System.out.println("Dequeue: ");
        queue.dequeue();
        System.out.println(queue);
        System.out.println("Dequeue: ");
        queue.dequeue();
        System.out.println(queue);
        System.out.println("Dequeue: ");
        queue.dequeue();
        System.out.println(queue);
    }
}

