package org.example.ClassRelations.Composition.OneHasMany.TypeThree;

// B aggregates C
public class B {
    private C[] cObjs;

    public C[] getcObjs() {
        return cObjs;
    }

    public B(C[] cObjs) {
        this.cObjs = cObjs;
    }
}
