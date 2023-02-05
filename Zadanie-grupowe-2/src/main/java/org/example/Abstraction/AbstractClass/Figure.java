package org.example.Abstraction.AbstractClass;

import java.util.ArrayList;
import java.util.List;

// Abstract classes cannot be instantiated!
// They are only templates for their subclasses
public abstract class Figure {
    protected Figure() {
        // This constructor is never used in a "new" call
        // it's only a template for their subclasses' constructors
    }

    // Abstract methods don't have defined bodies in the abstract class
    // and they MUST be overriden in their subclasses

    public static void example() {
        List<Figure> figures = new ArrayList<>();
        figures.add(new Rectangle(5.0, 10.0));
        figures.add(new Square(15.0));
        figures.add(new Triangle(5.0, 7.0, 6.0));

        for (Figure figure : figures) {
            System.out.println(figure.getFigureName() + " " + figure.getCircumference());
        }
    }

    public abstract Double getArea();
    public abstract Double getCircumference();
    public abstract String getFigureName();
}
