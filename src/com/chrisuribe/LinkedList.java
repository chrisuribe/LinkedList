package com.chrisuribe;

public class LinkedList {
    private Node first;
    private Node last;

    public void startLinkedList(int value){
        first = new Node(value);
        last = first;
    }

    public void addFirst(int value) {
        if (first==null) { // were starting a brand new LinkedList
            startLinkedList(value);
        }
        else {
            first = new Node(value, first);
        }
    }

    public void addLast(int value){
        if (last==null) { // were starting a brand new LinkedList
            startLinkedList(value);
        }
        else {
            var newLast = new Node(value);
            last.setNext(newLast);
            last = newLast;
        }
    }

    public void deleteFirst(){
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
            while(newLast.getNext() != last)
                newLast = newLast.getNext();
            last = newLast;
        }
    }

    public boolean contains (int value) {
        if(last == null)
            return false;
        else {
            Node targetNode = first;
            while (targetNode != last && targetNode.getValue() != value)
                targetNode = targetNode.getNext();
            return targetNode.getValue() == value;
        }
    }


    public int indexOf (int value){
        int index = 0;
        if(last == null)
            return -1;
        else {
            Node targetNode = first;
            while (targetNode != last && targetNode.getValue() != value) {
                index++;
                targetNode = targetNode.getNext();
            }
            if (targetNode.getValue() == value)
                return index;
            else
                return -1;
        }
    }

}
