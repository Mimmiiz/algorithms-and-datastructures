/*************************************
 * File name: CircularLinkedList.java
 * Author: Maria Halvarsson, mahalv@kth.se
 * Date: 2020-09-05
 * Updated: 2020-09-08
 *
 * Compilation: javac CircularLinkedList.java
 * Execution: java CircularLinkedList < input.txt
 * Data files: the-fundamentals-lab/task4/src/test.txt
 *
 * Implements a circular linked list where elements
 * can be inserted/removed from the front and back.
 *************************************/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class implements a doubly circular linked list that can
 * insert and remove elements from the front and the back end of the queue.
 *
 * @param <Item> the generic object that can be stored inside the list.
 */
public class CircularLinkedList<Item> implements Iterable<Item> {
    private final Node sentinel;
    private int size;

    // represents a node in the list
    private class Node {
        private Item item;
        private Node next;
        private Node prev;

    }

    /**
     * Initializes and empty circular linked list
     */
    public CircularLinkedList() {
        size = 0;
        sentinel = new Node();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    /**
     * Adds a new element to the back end of the queue.
     *
     * @param item the generic object that can be stored in the queue.
     */
    public void enqueueBack(Item item) {
        Node node = new Node();
        node.item = item;
        node.next = sentinel;
        node.prev = sentinel.prev;
        sentinel.prev.next = node;
        sentinel.prev = node;
        size++;
    }

    /**
     * Adds a new element to the front end of the queue.
     *
     * @param item the generic object that can be stored in the queue.
     */
    public void enqueueFront(Item item) {
        Node node = new Node();
        node.item = item;
        node.prev = sentinel;
        node.next = sentinel.next;
        sentinel.next.prev = node;
        sentinel.next = node;
        size++;
    }

    /**
     * Removes an object from the back end of the queue.
     *
     * @return the generic object that was removed from the queue.
     */
    public Item dequeueBack() {
        if (isEmpty())
            throw new NoSuchElementException("The list is empty.");
        Item item = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;
        return item;
    }

    /**
     * Removes an object from the front end of the queue.
     *
     * @return the generic object that was removed from the queue.
     */
    public Item dequeueFront() {
        if (isEmpty())
            throw new NoSuchElementException("The list is empty.");
        Item item = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return item;
    }

    /**
     * Get the size of the queue which is the total number of
     * objects stored in the queue.
     *
     * @return the size of the queue.
     */
    public int getSize() {
        return size;
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
     * Creates a string representation of the queue.
     *
     * @return the sequence of the queue in FIFO order. The elements of the queue are
     * placed inside brackets "[X]" and separated by a comma ",". If the queue is empty,
     * it is represented by an empty box "[]".
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
     * Returns an iterator to the queue that iterates though the items in FIFO order.
     *
     * @return an iterator to the queue that iterates through the items in FIFO order.
     */
    public Iterator<Item> iterator() {
        return new DoubleLinkedIterator();
    }

    // an iterator, does not implement remove since its optional
    private class DoubleLinkedIterator implements Iterator<Item> {
        private Node current = sentinel.next;

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public boolean hasNext() {
            return (current != sentinel);
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
     * If the character is '*', it is inserted at the front of the queue, other characters
     * are inserted at the back of the queue.
     * If the character read is "-", then an element is removed from the back end of the queue.
     * If the character read is "$", then an element is removed from the front end of the queue.
     * After each iteration, the queue and the size of the queue is printed out.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        CircularLinkedList<Character> queue = new CircularLinkedList<>();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int c;

        System.out.println("This is a test for the class CircularLinkedList.");
        System.out.println("**********");
        System.out.println(queue);
        System.out.println("Queue size: " + queue.getSize());
        try {
            while ((c = input.read()) != '\n') {
                if (c != '-' && c != '*' && c != '$') {
                    System.out.println("**********");
                    System.out.println("Item to enqueue: " + (char) c);
                    queue.enqueueBack((char) c);
                    System.out.println(queue);
                    System.out.println("Queue size: " + queue.getSize());
                }
                else if (c == '*') {
                    System.out.println("**********");
                    System.out.println("Item to enqueue: " + (char) c);
                    queue.enqueueFront((char) c);
                    System.out.println(queue);
                    System.out.println("Queue size: " + queue.getSize());
                }
                else if (!queue.isEmpty() && c == '-') {
                    System.out.println("**********");
                    System.out.println("Item to dequeue: " + queue.dequeueBack());
                    System.out.println(queue);
                    System.out.println("Queue size: " + queue.getSize());
                }
                else if (!queue.isEmpty() && c == '$') {
                    System.out.println("**********");
                    System.out.println("Item to dequeue: " + queue.dequeueFront());
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
