/*****************************************
 * File name: LinkedStack.java
 * Author: Maria Halvarsson, mahalv@kth.se
 * Date: 2020-08-31
 * Updated: 2020-09-08
 *
 * Compilation: javac LinkedStack.java
 * Execution: java LinkedStack < input.txt
 * Data files: the-fundamentals-lab/task2/src/linked-stack.txt
 *
 * Implements a stack ADT.
 ******************************************/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class implements a last in, first out (LIFO) queue, also known as a stack.
 * The LIFO queue is implemented using a linked list.
 *
 * @param <Item> the generic item that can be saved in the list.
 */
public class LinkedStack<Item> implements Iterable<Item> {
    private Node head = null;
    private int size = 0;

    /**
     * Represents a node in the LIFO queue that carries the item added to the queue.
     */
    private class Node {
        private final Item item;
        private Node next;

        private Node(Item item) {
            this.item = item;
        }
    }

    /**
     * Creates a String representation of the queue.
     *
     * @return the String representation of the queue.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (size == 0)
            return sb.append("[]").toString();
        for (Item item : this) {
            sb.append("[").append(item).append("],");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    /**
     * Checks if the LIFO queue is empty (no added elements) or not.
     *
     * @return a boolean a boolean value that is true if the queue is empty,
     * and false if it is not.
     */
    public boolean isEmpty() {
        return getSize() == 0;
    }

    /**
     * Adds an integer number to the LIFO queue/stack.
     * Push operation.
     *
     * @param item the integer number that will be added to the LIFO queue/stack.
     */
    public void push(Item item) {
        Node node = new Node(item);
        node.next = head;
        head = node;
        size++;
    }

    /**
     * Removes the last item that was added to the LIFO queue/stack.
     * Pull operation.
     *
     * @return the integer number that was added last to the queue.
     */
    public Item pop() {
        if (isEmpty())
            throw new IllegalStateException("The stack is empty.");
        else {
            Item element = this.head.item;
            head = this.head.next;
            size--;
            return element;
        }
    }

    /**
     * Returns the size (number of elements) of LIFO queue.
     *
     * @return the integer representing the size.
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns and iterator for the queue that iterates through the elements in LIFO order.
     *
     * @return the iterator for the queue that iterates through the elements in LIFO order.
     */
    public Iterator<Item> iterator() {
        return new LinkedIterator();
    }

    // an iterator that does not implement remove since it is optional
    private class LinkedIterator implements Iterator<Item> {
        private Node current = head;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    /**
     * Simple unit test that pushes characters to the stack from standard input
     * if the character read is "-", a character will be popped instead.
     * After each push and pop, the size of the stack and the stack will be printed out.
     *
     * @param args the command line arguments.
     */
    public static void main(String[] args) {
        System.out.println("This is a unit test method.");
        LinkedStack<Character> stack = new LinkedStack<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int c;

        System.out.println(stack);
        System.out.println("Stack size: " + stack.getSize());
        System.out.println("**********");
        try {
            while ((c = reader.read()) != '\n') {
                if (c != '-') {
                    System.out.println("**********");
                    System.out.println("Item to push: " + (char) c);
                    stack.push((char) c);
                    System.out.println(stack);
                    System.out.println("Stack size: " + stack.getSize());
                } else if (!stack.isEmpty()) {
                    System.out.println("**********");
                    System.out.println("Item to pop: " + stack.pop());
                    System.out.println(stack);
                    System.out.println("Stack size: " + stack.getSize());
                }
            }
        } catch (IOException e) {
            System.out.println("The test did not execute properly.");
            e.printStackTrace();
        }
    }
}
