/*************************************
 * File name: Main.java
 * Author: Maria Halvarsson, mahalv@kth.se
 * Date: 2020-09-08
 * Updated: 2020-09-08
 *
 * Compilation: javac Main.java
 * Execution: java main
 *************************************/

/**
 * This class contains the main method.
 * This class shows the insertion and deletion of elements in the
 * CircularLinkedList. After each insertion/deletion,
 * the content is printed out.
 */
public class Main {

    /**
     * This is the main method, all operations start from here.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CircularLinkedList<Character> list = new CircularLinkedList<>();
        System.out.println("Enqueue back: ");
        list.enqueueBack('B');
        System.out.println(list);
        System.out.println("Enqueue front: ");
        list.enqueueFront('1');
        System.out.println(list);
        System.out.println("Enqueue back: ");
        list.enqueueBack('A');
        System.out.println(list);
        System.out.println("Enqueue front: ");
        list.enqueueFront('2');
        System.out.println(list);

        System.out.println("Dequeue back: ");
        list.dequeueBack();
        System.out.println(list);
        System.out.println("Dequeue front: ");
        list.dequeueFront();
        System.out.println(list);
        System.out.println("Dequeue front: ");
        list.dequeueFront();
        System.out.println(list);
        System.out.println("Dequeue back: ");
        list.dequeueBack();
        System.out.println(list);
    }
}
