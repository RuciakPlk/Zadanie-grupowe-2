package org.example.ClassRelations.Composition.Circular;

import org.example.ClassRelations.Composition.OneHasOne.B;
import org.example.ClassRelations.Composition.OneHasOne.C;

// Circular composition prevents from using any of these classes:
// A requires B, B requires C, C requires A, A requires B, B requires C, etc.
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
        org.example.ClassRelations.Composition.OneHasOne.A a = new org.example.ClassRelations.Composition.OneHasOne.A(b);

        // composition
        C composedWithA = a.getbObj().getcObj();
    }
}
