package service;

//-----------------------------------------------------
// Assignment 3 - COMP 249
// Written by: Rebecca Messier (40338041) and Taminda Ait Ouazzou (40344517)
//
// Repository is a generic class used to manage collections of objects.
// It provides reusable operations such as adding items, finding an item
// by its ID, filtering items based on a condition, and sorting them
// using their natural order.
//-----------------------------------------------------

import java.util.*;
import java.util.function.Predicate;
import exceptions.EntityNotFoundException;
import interfaces.*;

public class Repository<T extends Identifiable & Comparable<? super T>> {
    
    private List<T> items = new ArrayList<>();

    // 1. add
    public void add(T item) {
        items.add(item);
    }

    // 2. findById
    public T findById(String id) throws EntityNotFoundException {
        for (T item : items) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        throw new EntityNotFoundException("Item not found: " + id);
    }

    // 3. filter
    public List<T> filter(Predicate<T> predicate) {
        List<T> result = new ArrayList<>();

        for (T item : items) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }

        return result;
    }

    // 4. getSorted
    public List<T> getSorted() {
        List<T> sorted = new ArrayList<>(items);
        Collections.sort(sorted);
        return sorted;
    }
}



