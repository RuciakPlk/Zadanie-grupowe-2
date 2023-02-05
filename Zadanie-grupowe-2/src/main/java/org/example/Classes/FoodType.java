package org.example.Classes;

import java.util.ArrayList;
import java.util.List;

public enum FoodType {
    BREAD(5),
    EGGS(10),
    SALAD(20),
    CARROT(5),
    PORK(50),
    BEEF(200),
    CHICKEN_BREAST(25);

    private Integer price;

    FoodType(Integer price) {
        this.price = price;
    }

    public static void printExample() {
        List<FoodType> groceries = new ArrayList<>();
        groceries.add(FoodType.BEEF);
        groceries.add(FoodType.EGGS);
        groceries.add(FoodType.SALAD);

        Integer sum = 0;

        for (FoodType food : groceries) {
            if (food.isVegetarian()) {
                sum += food.getPrice();
            }
        }

        System.out.println("Vegetarian foods in total cost: " + sum);
    }

    public Boolean isVegan() {
        return this.equals(BREAD) || this.equals(SALAD) || this.equals(CARROT);
    }

    public Boolean isVegetarian() {
        return this.isVegan() || this.equals(EGGS);
    }

    public Boolean isCarnivore() {
        return !this.isVegan();
    }

    public Integer getPrice() {
        return price;
    }
}
