package org.example.ClassRelations.TwoWayAssociation;

// Creation of A requires B. But creation of B requires A. Stuck.
// That's why you don't use two-way association, kids.
public class A {
    private B bObj;

    public A(B bObj) {
        this.bObj = bObj;
    }
}
