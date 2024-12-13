package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FoodMenu {
    private List<Food> menu;

    public FoodMenu() {
        Food food1 = new Food("Taco", "Tasty Taco", 10);
        Food food2 = new Food("Ceviche", "Tasty Ceviche", 15);
        Food food3 = new Food("Burger", "Big Burger", 5);

        menu = new ArrayList<>();
        menu.add(food1);
        menu.add(food2);
        menu.add(food3);
    }

    public Food getFood(int index) {
        int realIndex = index - 1;

        if (realIndex < menu.size()) {
            return menu.get(realIndex);
        }

        return null;
    }

    public Food getLowestCostFood() {
        Food lowestFood = null;
        for (int i = 0; i < menu.size(); i++) {
            lowestFood = menu.get(i);
            for (int j = 1; j < menu.size() - 1; j++) {
                if (lowestFood.getPrice() > menu.get(j).getPrice()) {
                    System.out.println("Food's name: " + menu.get(j).getName());
                    lowestFood = menu.get(j);
                }
            }
        }

        return lowestFood;
    }

    @Override
    public String toString() {
        StringBuilder all = new StringBuilder();
        for (int i = 0; i < menu.size(); i++) {
            all.append(i++).append(". ").append(menu.get(i));
        }

        return all.toString();
    }
}
