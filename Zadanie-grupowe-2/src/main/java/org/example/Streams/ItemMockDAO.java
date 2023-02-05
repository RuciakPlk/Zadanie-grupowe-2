package org.example.Streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ItemMockDAO implements DataAccessObject<Item> {
    private final List<Item> fakeDataBase;

    public ItemMockDAO() {
        this.fakeDataBase = new ArrayList<>();
    }

    @Override
    public Boolean create(Item newObject) {
        if (this.fakeDataBase.contains(newObject)) {
            return false;
        }
        else {
            this.fakeDataBase.add(newObject);
            return true;
        }
    }

    @Override
    public Optional<Item> read(Integer id) {
        if (id >= 0 && id < this.fakeDataBase.size()) {
            return Optional.of(this.fakeDataBase.get(id));
        }
        else {
            return Optional.empty();
        }
    }

    @Override
    public List<Item> read() {
        return new ArrayList<>(this.fakeDataBase);
    }

    @Override
    public Boolean update(Integer id, Item updatedObject) {
        if (this.fakeDataBase.contains(updatedObject)) {
            return false;
        }
        else if (id >= 0 && id < this.fakeDataBase.size()) {
            this.fakeDataBase.set(id, updatedObject);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Boolean delete(Integer id) {
        Optional<Item> itemToDelete = read(id);
        if (itemToDelete.isPresent()) {
            this.fakeDataBase.remove(itemToDelete.get());
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Boolean delete(Item objectToDelete) {
        if (this.fakeDataBase.contains(objectToDelete)) {
            this.fakeDataBase.remove(objectToDelete);
            return true;
        }
        else {
            return false;
        }
    }

    public static void example() {
        ItemMockDAO dao = new ItemMockDAO();

        dao.create(new Item("Assasin's Creed", 30, 10));
        dao.create(new Item("The Witcher", 40, 20));
        dao.create(new Item("Watch Dogs", 15, 5));
        dao.create(new Item("Super Mario Galaxy", 10, 2));
        dao.create(new Item("Crysis", 50, 60));

        // filtering - selecting data that fits a criteria
        // sorting - ordering data by a rule
        // count - counting the amount of data that fits a criteria
        // transforming - producing new/changed results based on a function

        Optional<Item> mostExpensive = dao.getMostExpensiveItem();
        mostExpensive.ifPresent(item -> System.out.println("Most expensive item is: " + item.getName()));

        Integer totalQuantity = dao.getTotalQuantityOfAvailableItems();
        System.out.println("Total quantity of items is: " + totalQuantity);

        List<Item> itemsWithinPriceRange = dao.getItemsWithinPriceRange(20, 40);
        System.out.println("Items within the 20-40 price range:");
        itemsWithinPriceRange.forEach(item -> System.out.println(item.getName()));
    }

    public Optional<Item> getMostExpensiveItem() {
        // For each possible pair of items, compare their prices from getPrice() function

        /*
        Optional<Item> mostExpensiveItem = Optional.empty();
        for (Item item : this.fakeDataBase) {
            if (mostExpensiveItem.isEmpty()) {
                mostExpensiveItem = Optional.of(item);
            }
            else if (mostExpensiveItem.get().getPrice() < item.getPrice()) {
                mostExpensiveItem = Optional.of(item);
            }
        }
        return mostExpensiveItem;
        */

        // return this.fakeDataBase.stream().max(Comparator.comparing(Item::getPrice));
        return this.fakeDataBase.stream().max((itemA, itemB) -> itemA.getPrice().compareTo(itemB.getPrice()));
    }

    public Integer getTotalQuantityOfAvailableItems() {
        /*
        // For each item in the list, map its quantity to an integer collection, and then return the sum of that collection
        List<Integer> quantities = new ArrayList<>();
        for (Item item : this.fakeDataBase) {
            // Map item's quantity to an integer list
            quantities.add(item.getQuantity());
        }
        // Sum the quantities into a single integer value
        Integer sum = 0;
        for (Integer quantity : quantities) {
            sum += quantity;
        }
        return sum;
        */

        return this.fakeDataBase.stream().mapToInt(item -> item.getQuantity()).sum();
    }

    public List<Item> getItemsWithinPriceRange(Integer minimum, Integer maximum) {
        /*
        List<Item> itemsWithinRange = new ArrayList<>();
        for (Item item : this.fakeDataBase) {
            if (item.getPrice() >= minimum && item.getPrice() <= maximum) {
                itemsWithinRange.add(item);
            }
            // We filter out all items that do not fit into the price range
        }
        return itemsWithinRange;
        */
        
        // For reach item in the list, check whether its price is within the price range, and if it is, include it in the result collection
        return this.fakeDataBase.stream().filter(item -> item.getPrice() >= minimum && item.getPrice() <= maximum).collect(Collectors.toList());
    }
}
