package org.example.Streams;

public class Item {
    private final String name;
    private final Integer price;
    private final Integer quantity;

    public Item(String name, Integer price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Cloning constructor
    public Item(Item originalItem) {
        this.name = originalItem.name;
        this.price = originalItem.price;
        this.quantity = originalItem.quantity;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }
}

