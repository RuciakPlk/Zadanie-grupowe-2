package org.example.FunctionalProgramming.FunctionChaining;

public class CalculatingObject {
    private Double value;

    public CalculatingObject(Double initialValue) {
        this.value = initialValue;
    }

    public static CalculatingObject getNew(Double initialValue) {
        return new CalculatingObject(initialValue);
    }

    public CalculatingObject add(Double value) {
        this.value += value;
        return this;
    }

    public CalculatingObject sub(Double value) {
        this.value -= value;
        return this;
    }

    public CalculatingObject mul(Double value) {
        this.value *= value;
        return this;
    }

    public CalculatingObject div(Double value) {
        this.value /= value;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public static void example() {
        // Imperative approach
        /*
        CalculatingObject cObj = new CalculatingObject(100.0);
        cObj.sub(15.0);
        cObj.mul(2.0);
        cObj.add(20.0);
        cObj.div(70.0);
        Double result = cObj.getValue();
        System.out.println(result);
        */

        // Functional approach
        System.out.println(CalculatingObject
                        .getNew(100.0)
                        .sub(15.0).mul(2.0)
                        .add(20.0).div(70.0)
                        .getValue());
    }
}
