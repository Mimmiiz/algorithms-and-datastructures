/*************************************
 * File name: DoublyLinkedCircularQueue.java
 * Author: Maria Halvarsson, mahalv@kth.se
 * Date: 2020-09-03
 * Updated: 2020-09-08
 *
 * Compilation: javac DoublyLinkedCircularQueue.java
 * Execution: java DoublyLinkedCircularQueue < input.txt
 * Data files: /the-fundamentals-lab/task3/src/doubly-test.txt
 *
 * Implements an iterable FIFO queue/stack
 *************************************/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Iterator;

/**
 * This class implements a generic iterable first in, first out (FIFO) queue
 * that is based on a double linked circular list. The first node of the queue
 * is a sentinel and does not contain any data. The sentinel only indicates the
 * beginning and end of the queue.
 *
 * @param <Item> a generic item that can be stored inside the list.
 */
public class DoublyLinkedCircularQueue<Item> implements Iterable<Item> {
    private int size;
    private final Node sentinel;

    // represents a node in the list
    private class Node {
        private Item item;
        private Node next;
        private Node prev;
    }

    /**
     * Initializes an empty queue.
     */
    public DoublyLinkedCircularQueue() {
        sentinel = new Node();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /**
     * Adds a new item to the queue. The new item is put in the back of the queue.
     *
     * @param item the specified generic item that will be added to the queue.
     */
    public void enqueue(Item item) {
        Node node = new Node();
        node.item = item;
        sentinel.prev.next = node;
        node.prev = sentinel.prev;
        sentinel.prev = node;
        node.next = sentinel;
        size++;
    }

    /**
     * Removes the first item from the queue,
     * which is the item that was first added to the queue.
     *
     * @return the generic item that will be removed from the queue.
     */
    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("The queue is empty.");
        Item item = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size--;
        return item;
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
     * Checks if the queue is empty or not.
     *
     * @return true if the queue is empty, else return false.
     */
    public boolean isEmpty() {
        return getSize() == 0;
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
            return sb.append("[]").toString();
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

    // an iterator, does not implement remove since it is optional and not needed here
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
     * If the character read is "-", then a character is removed from the queue.
     * After each iteration, the queue and the size of the queue is printed out.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        DoublyLinkedCircularQueue<Character> queue = new DoublyLinkedCircularQueue<>();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int c;

        System.out.println("This is a test for the class DoublyLinkedCircularQueue");
        System.out.println("**********");
        System.out.println(queue);
        System.out.println("Queue size: " + queue.getSize());
        try {
            while ((c = input.read()) != '\n') {
                if (c != '-') {
                    System.out.println("**********");
                    System.out.println("Item to enqueue: " + (char) c);
                    queue.enqueue((char) c);
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

