package service;

//-----------------------------------------------------
// Assignment 3 - COMP 249
// Written by: Rebecca Messier (40338041) and Taminda Ait Ouazzou (40344517)
//
// RecentList is a generic class that keeps track of the most recent items.
// It uses a LinkedList to efficiently add new elements at the beginning
// and remove the oldest ones when the list exceeds its maximum size.
//-----------------------------------------------------

import java.util.LinkedList;

public class RecentList<T> {
    
    private LinkedList<T> list = new LinkedList<>();
    private final int MAX_SIZE = 10;

    //add item to front 
    public void addRecent(T item) {
        list.addFirst(item);

        if (list.size() > MAX_SIZE) {
            list.removeLast();
        }    

    }

    // print up to maxToShow items
    public void printRecent(int maxToShow) {
        int count = 0;

        for (T item : list) {
            if (count >= maxToShow) break;
            System.out.println(item);
            count++;
        }
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }



}