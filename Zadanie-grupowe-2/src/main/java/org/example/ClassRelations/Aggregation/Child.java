package org.example.ClassRelations.Aggregation;

// Child associates with mother
// Child associates with father

// Since parent aggregates children, who associate with him
// Children have an inverted aggregation with parents
public class Child {
    private Parent mother;
    private Parent father;

    public Child(Parent mother, Parent father) {
        this.mother = mother;
        this.father = father;
    }

    public static void example() {
        Parent janusz = new Parent();
        Parent grazyna = new Parent();

        Child seba = new Child(grazyna, janusz);
        Child dzesika = new Child(grazyna, janusz);
    }
}
