package org.example.ClassRelations.Composition.OneHasOne;

public class A {
    private B bObj;

    public A(B bObj) {
        this.bObj = bObj;
    }

    public B getbObj() {
        return bObj;
    }

    public static void example() {
        C c = new C();
        B b = new B(c);
        A a = new A(b);

        // composition
        C composedWithA = a.getbObj().getcObj();
    }
}
