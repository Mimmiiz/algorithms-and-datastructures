/*************************************
 * File name: GeneralizedQueue.java
 * Author: Maria Halvarsson, mahalv@kth.se
 * Date: 2020-09-05
 * Updated: 2020-09-08
 *
 * Compilation: javac GeneralizedQueue.java
 * Execution: java GeneralizedQueue < input.txt
 * Data files: /the-fundamentals-lab/task5/src/test.txt
 *
 * Implements a generalized queue.
 *************************************/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class implements a generalized queue which allows for removing
 * the k:th element from the queue. The most recently added element has
 * index 1 in the queue. The generalized queue is implemented using a
 * singly linked circular list.
 *
 * @param <Item> the generic item that can be inserted to the queue.
 */
public class GeneralizedQueue<Item> implements Iterable<Item> {
    private final Node sentinel;
    private int size;

    // represents a node in the queue
    private class Node {
        Item item;
        private Node next;
    }

    /**
     * Initializes an empty queue.
     */
    public GeneralizedQueue() {
        sentinel = new Node();
        size = 0;
    }

    /**
     * Adds a new element to the queue. The element is added to the top of the queue,
     * which means it is inserted at index 1. The elements that were already present in
     * the queue will move to index + 1.
     *
     * @param item the generic item to be added to the queue.
     */
    public void enqueue(Item item) {
        Node node = new Node();
        node.item = item;
        node.next = sentinel.next;
        sentinel.next = node;
        size++;
    }

    /**
     * Removes an element from the queue according to the specified index.
     * The first index starts at 1.
     *
     * @param index the index of the element to be removed from the queue.
     * @return the item from the removed element.
     */
    public Item dequeue(int index) {
        if (isEmpty())
            throw new NoSuchElementException("The queue is empty.");
        if (index > size)
            throw new IndexOutOfBoundsException("The index entered is too big.");
        if (index <= 0)
            throw new IllegalArgumentException("The index must be a positive integer value.");
        Node temp = sentinel.next;
        Node beforeTemp = sentinel;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
            beforeTemp = beforeTemp.next;
        }
        beforeTemp.next = temp.next;
        size--;
        return temp.item;
    }

    /**
     * Checks if the queue is empty or not.
     *
     * @return true if the queue is empty, else return false.
     */
    public boolean isEmpty() {
        return (getSize() == 0);
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
     * @return the sequence of the queue, the first element is the element on index 1.
     * The elements of the queue are placed inside brackets "[X]" and separated by a comma ",".
     * If the queue is empty, it is represented by an empty box "[]".
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (size == 0)
            return (sb.append("[]").toString());
        for (Item item : this)
            sb.append("[").append(item).append("],");
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /**
     * Returns an iterator to the queue that iterates though the items in index order.
     *
     * @return an iterator to the queue that iterates through the items in index order.
     */
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    // an iterator, does not implement remove since it is optional and not needed here
    private class QueueIterator implements Iterator<Item> {
        private Node current = sentinel.next;

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public boolean hasNext() {
            return (current != null);
        }

        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    /**
     * Unit test for the class that takes characters as inputs and adds them to the queue.
     * If the character read is a number (1-9), then a character is removed from that specified index.
     * After each iteration, the queue and the size of the queue is printed out.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        GeneralizedQueue<Character> queue = new GeneralizedQueue<>();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int c;

        System.out.println("This is a test for the class GeneralizedQueue.");
        System.out.println("**********");
        System.out.println(queue);
        System.out.println("Queue size: " + queue.getSize());
        try {
            while ((c = input.read()) != '\n') {
                if (48 < c && c < 58 && !queue.isEmpty()) {
                    System.out.println("**********");
                    System.out.println("Dequeue at index: " + (c - 48));
                    queue.dequeue(c - 48);
                    System.out.println(queue);
                    System.out.println("Queue size: " + queue.getSize());
                }
                else {
                    System.out.println("**********");
                    System.out.println("Item to enqueue: " + (char) c);
                    queue.enqueue((char) c);
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
