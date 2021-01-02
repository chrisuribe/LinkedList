package com.chrisuribe;

public class Array {

    private int[] items;
    private int count = 0;

    public Array(int length) {
        items = new int[length];
    }

    public void insert(int item) {
        if (items.length == count) {
            int[] newItems = new int[items.length * 2];
            for (int i = 0; i < count; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }
        items[count++] = item;
    }

    public void insertAt(int item, int index) {
        int newItemsSize = count;
        if (items.length < count+1)
                newItemsSize = items.length * 2;

        int[] newItems = new int[newItemsSize];

        for (int i = 0; i < index; i++) {
            newItems[i] = items[i];
        }

        newItems[index] = item;

        final int shiftedIndex = index+1;
        final int newCount = count+1;
        for (int i = shiftedIndex; i < newCount; i++) {
            newItems[i] = items[i-1];
        }

        count++;
        items = newItems;
    }


    public void reverse() {
            int[] reversedItems = new int[count];
            for (int i = 0; i < count; i++)
                    reversedItems[i] = items[count-1-i];
            items = reversedItems;
        }


    public void removeAt(int index) {
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();

        for (int i = index; i < count; i++)
            items[i] = items[i + 1];

        count--;
    }

    public void print() {
        final int lastIndex = count - 1;
        System.out.print("[");
        for (int i = 0; i <= lastIndex; i++) {
            System.out.print(items[i]);
            if (i != lastIndex) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    public int[] toIntArray() {
        int[] finalArray = new int[count + 1];
        for (int validItem = 0; validItem < count; validItem++) {
            //System.out.println("item: " + items[validItem]);
            finalArray[validItem] = items[validItem];
        }
        return finalArray;
    }

    // O(n) complexity
    public int indexOf(int item) {
        for (int index = 0; index < count; index++) {
            if (items[index] == item)
                return index;
        }
        return -1;
    }

    public int max() {
        // O(n)
        if (count > 0) {
            int maxNumber = items[0];

            for (int item : items) {
                if (item > maxNumber)
                    maxNumber = item;
            }
            return maxNumber;
        }
        return -1;
    }

    public Array intersect(Array samples) {
        if (count < 1 && samples.getCount() < 1)
            throw new IllegalArgumentException();

        Array intersectingNumbers = new Array(samples.getCount());

        for (int item : items)
            if (samples.indexOf(item) >= 0)
                intersectingNumbers.insert(item);

        return intersectingNumbers;

    }

    public int getCount() {
        return count;
    }
}
