package org.example.ClassRelations.Composition.OneHasMany.TypeOne;

import java.util.List;

// B aggregates C
public class B {
    private C[] cObjs;

    public B(C[] cObjs) {
        this.cObjs = cObjs;
    }

    public C[] getcObjs() {
        return cObjs;
    }
}
