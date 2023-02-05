package org.example.ClassRelations.Aggregation;

import java.util.ArrayList;
import java.util.List;

// Parent aggregates children
public class Parent {
    private List<Child> children;

    public Parent() {
        this.children = new ArrayList<>();
    }

    public void addChild(Child child) {
        this.children.add(child);
    }
}
