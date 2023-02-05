package org.example.Abstraction.AbstractClass;

public class Triangle extends Figure {
    protected Double a;
    protected Double b;
    protected Double c;

    public Triangle(Double a, Double b, Double c) {
        super();
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public Double getArea() {
        return null;
    }

    @Override
    public Double getCircumference() {
        return a + b + c;
    }

    @Override
    public String getFigureName() {
        return "Triangle";
    }
}
