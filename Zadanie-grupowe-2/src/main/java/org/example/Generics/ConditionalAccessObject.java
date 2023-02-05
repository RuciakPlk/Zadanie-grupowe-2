package org.example.Generics;

public interface ConditionalAccessObject<TKey, TValue> {
    TValue tryGetValue(TKey key) throws InvalidKeyException;
}
