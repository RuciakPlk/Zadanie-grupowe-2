package org.example.ClassRelations.Composition.Circular;

public class C {
    private A aObj;

    public C(A aObj) {
        this.aObj = aObj;
    }

    public A getaObj() {
        return aObj;
    }
}
