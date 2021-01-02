package com.chrisuribe;

public class Main {

    public static void main(String[] args) {


        LinkedList myList = new LinkedList();

        myList.addFirst(10);
        myList.addLast(50);
        myList.addLast(100);
        myList.addLast(200);
        System.out.println("Contains: 10 " + myList.contains(10));
        System.out.println(myList.indexOf(10));
        System.out.println("Contains: 50 " + myList.contains(50));
        System.out.println(myList.indexOf(50));
        System.out.println("Contains: 100 " + myList.contains(100));
        System.out.println(myList.indexOf(100));
        System.out.println("Contains: 200 " + myList.contains(200));
        System.out.println(myList.indexOf(200));

        myList.deleteFirst();
        myList.deleteLast();

        System.out.println("Contains: 10 " + myList.contains(10));
        System.out.println(myList.indexOf(10));
        System.out.println("Contains: 50 " + myList.contains(50));
        System.out.println(myList.indexOf(50));
        System.out.println("Contains: 100 " + myList.contains(100));
        System.out.println(myList.indexOf(100));
        System.out.println("Contains: 200 " + myList.contains(200));
        System.out.println(myList.indexOf(200));

//        LinkedList list = new LinkedList();
//        list.add(10);list.add(20);list.add(30);
//        list.addFirst(5);
//        list.removeLast();
//        System.out.println("list contains 20: " + list.contains(20));
//        System.out.println(list);


    }
}
