package org.example.ClassRelations.Association;

// A has one B
public class A {
    private B bObj;

    public A(B bObj) {
        this.bObj = bObj;
    }
}
