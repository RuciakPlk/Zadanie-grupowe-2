package org.example.ClassRelations.Composition.OneHasMany.TypeTwo;

// B associates with C
public class B {
    private C cObj;

    public C getcObj() {
        return cObj;
    }

    public B(C cObj) {
        this.cObj = cObj;
    }
}
