package org.example.Optionals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public static void example() {
        DataAccessObject<Item> dao = new ItemMockDAO();

        Optional<Item> optionalItem = dao.read(5);

        /*
        This is the same logic as the line below!
        Optional<Item> optionalItem = dao.read(5);
        if (optionalItem.isPresent()) {
            System.out.println(optionalItem.get().getName());
        }
        else {
            System.out.println("Not found!");
        }
        */
        dao.read(5).ifPresentOrElse(item -> System.out.println(item.getName()), () -> System.out.println("Not found!"));
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
}
