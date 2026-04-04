package service;

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