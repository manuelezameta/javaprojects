package org.example;

import java.util.HashMap;
import java.util.Map;

public class ShoppingBag<T extends PricedItem<Integer>> {
    private final Map<T, Integer> shoppingBag;

    public ShoppingBag() {
        this.shoppingBag = new HashMap<>();
    }

    public void addItem(T item) {
//        this.shoppingBag.merge(item, 1, Integer::sum);
        if (this.shoppingBag.get(item) != null) {
            this.shoppingBag.put(item, this.shoppingBag.get(item) + 1);
        } else {
            this.shoppingBag.put(item, 1);
        }
    }

    public Integer getTotalPrice() {
        int sumTotal = 0;
        for (T key : shoppingBag.keySet()) {
            sumTotal += key.getPrice() * shoppingBag.get(key);
        }

        return sumTotal;
    }
}
