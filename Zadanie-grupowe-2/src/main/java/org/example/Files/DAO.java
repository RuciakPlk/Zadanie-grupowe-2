package org.example.Files;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    Boolean create(T newObj);
    Optional<T> read(Integer id);
    List<Optional<T>> readAll();
}
