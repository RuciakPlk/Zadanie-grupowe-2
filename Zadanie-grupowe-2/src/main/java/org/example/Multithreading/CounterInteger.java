package org.example.Multithreading;

// The purpose of this class is to hold an integer inside a reference-typed object
// so that it can be used for thread synchronization
public class CounterInteger {
    private Integer value;

    public CounterInteger(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
