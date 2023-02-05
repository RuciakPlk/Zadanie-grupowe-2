package org.example.Streams;

import java.util.List;
import java.util.Optional;

public interface DataAccessObject<TData> {
    // CRUD
    // Create
    // Read
    // Update
    // Delete

    Boolean create(TData newObject);
    Optional<TData> read(Integer id);
    List<TData> read();
    Boolean update(Integer id, TData updatedObject);
    Boolean delete(Integer id);
    Boolean delete(TData objectToDelete);
}
