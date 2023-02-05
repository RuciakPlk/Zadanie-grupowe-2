package org.example.ClassRelations.Composition.OneHasMany.TypeOne;

// A associates with B
// which in turn, aggregates C
// Therefore, through composition,
// A aggregates C
public class A {
    private B bObj;

    public A(B bObj) {
        this.bObj = bObj;
    }

    public B getbObj() {
        return bObj;
    }
}
