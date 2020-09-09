/*************************************
 * File name: GeneralizedQueue.java
 * Author: Maria Halvarsson, mahalv@kth.se
 * Date: 2020-09-05
 * Updated: 2020-09-09
 *
 * Compilation: javac OrderedQueue.java
 * Execution: java OrderedQueue < input.txt
 * Data files: /the-fundamentals-lab/task6/src/test.txt
 *
 * Implements an ordered queue.
 *************************************/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class implements an ordered queue that is ordered on insertion.
 * The queue takes an integer value and sorts them in ascending order.
 * When an element is removed from the queue. It will be the first element,
 * which has the lowest integer value. This queue is similar to a
 * priority queue.
 */
public class OrderedQueue implements Iterable<Integer> {
    private final Node sentinel;
    private int size;

    // represents a node in the queue
    private static class Node {
        private int value;
        private Node next;
        private Node prev;
    }

    /**
     * Initializes an empty queue.
     */
    public OrderedQueue() {
        sentinel = new Node();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /**
     * Checks if the queue is empty or not.
     *
     * @return true if the queue is empty, else return false.
     */
    public boolean isEmpty() {
        return getSize() == 0;
    }

    /**
     * Adds a new element to the queue.
     * When a new element is added, the queue will be sorted in ascending order.
     *
     * @param value the integer value of the element to add.
     */
    public void enqueue(int value) {
        Node temp = sentinel.next;
        Node toAdd = new Node();
        toAdd.value = value;
        sort(toAdd, temp);
        size++;
    }

    // this is a recursive sorting algorithm that sorts the elements in ascending order
    private void sort(Node toAdd, Node temp) {
        if (temp == sentinel)
            addNode(toAdd, temp);
        else if (toAdd.value <= temp.value)
            addNode(toAdd, temp);
        else {
            temp = temp.next;
            sort(toAdd, temp);
        }
    }

    // adds a new node to the queue
    private void addNode(Node toAdd, Node temp) {
        toAdd.next = temp;
        toAdd.prev = temp.prev;
        temp.prev.next = toAdd;
        temp.prev = toAdd;
    }

    /**
     * Dequeues the first element from the queue.
     *
     * @return the value of the removed element.
     */
    public int dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("The queue is empty.");
        Node node = sentinel.next;
        sentinel.next = node.next;
        node.next.prev = sentinel;
        size--;
        return node.value;
    }

    /**
     * Returns the size of the queue which is the total number of elements in the queue.
     *
     * @return the size of the queue.
     */
    public int getSize() {
        return size;
    }

    /**
     * Creates a string representation of the queue.
     *
     * @return the sequence of the queue in ascending order.
     * The elements of the queue are placed inside brackets "[X]" and separated by a comma ",".
     * If the queue is empty, it is represented by an empty box "[]".
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (size == 0)
            return sb.append("[]").toString();
        for (Integer value : this)
            sb.append("[").append(value).append("],");
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /**
     * Returns an iterator to the queue that iterates though the queue in ascending order.
     *
     * @return an iterator to the queue that iterates through the queue in ascending order.
     */
    public Iterator<Integer> iterator() {
        return new DoubleLinkedIterator();
    }

    // an iterator, does not implement remove since it is optional and not needed here
    private class DoubleLinkedIterator implements Iterator<Integer> {
        private Node current = sentinel.next;

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public boolean hasNext() {
            return (current != sentinel);
        }

        public Integer next() {
            if (!hasNext())
                throw new NoSuchElementException();
            int value = current.value;
            current = current.next;
            return value;
        }
    }

    /**
     * Unit test for the class that reads characters from standard input.
     * If the character read is a number (0-9), the number is added to the queue.
     * If the character is any other character apart from a number, it will
     * dequeue an element from the queue.
     * After each iteration, the queue and the size of the queue is printed out.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        OrderedQueue queue = new OrderedQueue();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int c;

        System.out.println("This is a test for the class OrderedQueue.");
        System.out.println("**********");
        System.out.println(queue);
        System.out.println("Queue size: " + queue.getSize());
        try {
            while ((c = input.read()) != '\n') {
                if (47 < c && c < 58) {
                    System.out.println("**********");
                    System.out.println("Item to enqueue: " + (c - 48));
                    queue.enqueue(c - 48);
                    System.out.println(queue);
                    System.out.println("Queue size: " + queue.getSize());
                }
                else if (!queue.isEmpty()) {
                    System.out.println("**********");
                    System.out.println("Item to dequeue: " + queue.dequeue());
                    System.out.println(queue);
                    System.out.println("Queue size: " + queue.getSize());
                }
            }
        } catch (IOException e) {
            System.out.println("The test did not execute properly.");
            e.printStackTrace();
        }
    }
}

