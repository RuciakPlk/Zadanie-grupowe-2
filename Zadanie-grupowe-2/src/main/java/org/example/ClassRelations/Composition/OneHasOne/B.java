package org.example.ClassRelations.Composition.OneHasOne;

public class B {
    private C cObj;

    public B(C cObj) {
        this.cObj = cObj;
    }

    public C getcObj() {
        return cObj;
    }
}
