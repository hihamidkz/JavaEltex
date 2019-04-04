package ru.eltex.shoppingcustomer;

import ru.eltex.shoppingitems.*;

import java.io.Serializable;
import java.util.*;

public class ShoppingCart<T extends Drink> implements Serializable {
    private List<T> arrayList;
    private Set<UUID> idSet;

    public ShoppingCart() {
        arrayList = new ArrayList<>();
        idSet = new HashSet<>();
    }

    public List<T> getArrayList()
    {
        return arrayList;
    }

    public void add(T object) {
        arrayList.add(object);
        idSet.add(object.getId());
    }

    public void delete(T object) {
        int idx = arrayList.indexOf(object);
        arrayList.remove(idx);
        idSet.remove(object.getId());
    }

    public T find(UUID id) {
        if (idSet.contains(id)) {
            Iterator<T> iterator = arrayList.iterator();
            while (iterator.hasNext()) {
                T current = iterator.next();
                if (current.getId().equals(id)) {
                    return current;
                }
            }
        }
        return null;
    }

    public void showObjects() {
        Iterator<T> iterator = arrayList.iterator();

        //System.out.println("----------------------------------------------");
        System.out.println("Purchases:");
        while (iterator.hasNext()) {
            T current = iterator.next();
            current.read();
        }
    }
}
