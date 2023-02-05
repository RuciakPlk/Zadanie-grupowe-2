package org.example.Abstraction.AbstractClass;

public class Square extends Rectangle {
    public Square(Double a) {
        super(a, a);
    }

    @Override
    public String getFigureName() {
        return "Square";
    }
}
