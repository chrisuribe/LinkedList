package com.chrisuribe;

import java.security.InvalidParameterException;
import java.util.NoSuchElementException;

public class LinkedList {
    private Node first;
    private Node last;
    private int size;

    public int size() {
        return size;
    }

    public void addLast(int value) {
        var node = new Node(value);
        if (isEmpty()) { // were starting a brand new LinkedList
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public void addFirst(int value) {
        var node = new Node(value);
        if (isEmpty()) { // were starting a brand new LinkedList
            first = last = node;
        } else {
            first = new Node(value, first);
        }
        size++;
    }

    private boolean isEmpty() {
        return first == null;
    }

    public int indexOf(int item) {
        int index = 0;
        var current = first;
        while (current != null) { // this would mean we reached the end
            if (current.value == item) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }


    public void removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last)
            first = last = null;
        else {
            var second = first.next;
            first.next = null; // so that garbage collector can purge node
            first = second;
        }
        size--;
    }

    public void removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();
        if (first == last)
            first = last = null;
        else {
            var previous = getPrevious(last);
            last = previous;
            last.next = null; // remove reference to node for garbage collection + so that it isn't searchable
        }
        size--;
    }

    private Node getPrevious(Node node) {
        var current = first;
        while (current != null) {
            if (current.next == node) return current;
            current = current.next;
        }
        return null;
    }

    public int[] toArray() {
        var array = new int[size];
        int index = 0;
        var current = first;

        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

    public void reverse() {

        var oldLast = last;
        last = first;
        first = oldLast;

        Node previous = null;
        var current = last;
        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

    }

    // Find the Kth node form the end
    // of a linked list in one pass
    public int findKthFromTheEnd(int k) {
        if (k < 1)
            throw new IllegalArgumentException("Enter number greater than zero.");
        if(isEmpty())
            throw new IllegalStateException();


        Node first = this.first;
        Node second = this.first;

        // move second pointer forward by offset
        int offset = k - 1;
        while (offset-- != 0) {
            second = second.next;
            if (second == null)
                throw new IllegalArgumentException("Enter a number smaller than the size of the list.");

        }

        // move both pointers to the end
        while (second != last) {
            first = first.next;
            second = second.next;
        }
        return first.value;
    }


    public void printMiddle() {
        Node middle = first;
        Node last = first;
        boolean isEven = false;

        if(first == null)
            throw new IllegalStateException("ERROR: Empty list.");

        // Move middle pointer to middle while moving last pointer to end
        while(last.next != null){
            if(isEven){
                middle = middle.next;
            }
            last = last.next;
            isEven = !isEven;
        }

        if(isEven)
            System.out.println("["+middle.value+","+middle.next.value+"]");
        else
            System.out.println("["+middle.value+"]");

    }

    private static class Node {

        private final int value;
        private Node next;


        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
