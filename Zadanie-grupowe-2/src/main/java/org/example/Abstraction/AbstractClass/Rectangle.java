package org.example.Abstraction.AbstractClass;

public class Rectangle extends Figure {
    protected Double a;
    protected Double b;

    public Rectangle(Double a, Double b) {
        super();
        this.a = a;
        this.b = b;
    }

    @Override
    public Double getArea() {
        return a*b;
    }

    @Override
    public Double getCircumference() {
        return 2*a + 2*b;
    }

    @Override
    public String getFigureName() {
        return "Rectangle";
    }
}
