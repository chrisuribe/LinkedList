package com.chrisuribe;

public class LinkedList {
    private Node first;
    private Node last;

    public void addLast(int value) {
        var node = new Node(value);
        if (isEmpty()) { // were starting a brand new LinkedList
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
    }

    public void addFirst(int value) {
        var node = new Node(value);
        if (isEmpty()) { // were starting a brand new LinkedList
            first = last = node;
        } else {
            first = new Node(value, first);
        }
    }

    private boolean isEmpty() {
        return first == null;
    }

    public int indexOf(int item) {
        int index = 0;
        var current = first;
        while (current != null) { // this would mean we reached the end
            if(current.value == item) return index;
            current = current.next;
            index++;
        }
            return -1;
    }


    public void deleteFirst() {
        if (first == null) // empty LinkedList
            return;
        else {
            Node newFirst = first.getNext();
            first.setNext(null); // so that garbage collector can purge node
            first = newFirst;
        }
    }

    public void deleteLast() {
        if (last == null) // empty LinkedList
            return;
        else {
            Node newLast = first;
            // move pointer until "next" is equal to "last"
            while (newLast.getNext() != last)
                newLast = newLast.getNext();
            last = newLast;
        }
    }

    public boolean contains(int value) {
        if (last == null)
            return false;
        else {
            Node targetNode = first;
            while (targetNode != last && targetNode.getValue() != value)
                targetNode = targetNode.getNext();
            return targetNode.getValue() == value;
        }
    }


    // just a test
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
