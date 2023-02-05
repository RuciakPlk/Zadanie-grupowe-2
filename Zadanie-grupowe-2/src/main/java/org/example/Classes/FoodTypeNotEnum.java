package org.example.Classes;

public class FoodTypeNotEnum {
    public static FoodTypeNotEnum BREAD = new FoodTypeNotEnum(5);
    public static FoodTypeNotEnum EGGS = new FoodTypeNotEnum(10);
    public static FoodTypeNotEnum SALAD = new FoodTypeNotEnum(20);
    public static FoodTypeNotEnum CARROT = new FoodTypeNotEnum(5);
    public static FoodTypeNotEnum PORK = new FoodTypeNotEnum(50);
    public static FoodTypeNotEnum BEEF = new FoodTypeNotEnum(200);
    public static FoodTypeNotEnum CHICKEN_BREAST = new FoodTypeNotEnum(25);

    private Integer price;

    FoodTypeNotEnum(Integer price) {
        this.price = price;
    }

    public Boolean isVegan() {
        return this.equals(BREAD) || this.equals(SALAD) || this.equals(CARROT);
    }

    public Integer getPrice() {
        return price;
    }
}
