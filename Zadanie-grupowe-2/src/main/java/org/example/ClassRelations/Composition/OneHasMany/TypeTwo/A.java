package org.example.ClassRelations.Composition.OneHasMany.TypeTwo;

// A aggregates B
// which in turn, associates with C
// Therefore, through composition
// A aggregates C
public class A {
    private B[] bObjs;

    public B[] getbObjs() {
        return bObjs;
    }

    public A(B[] bObjs) {
        this.bObjs = bObjs;
    }
}
