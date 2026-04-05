package service;

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



