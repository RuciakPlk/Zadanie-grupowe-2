package org.example.FunctionalProgramming.FunctionChaining;

public class LambdaCalculatingObject {
    private Double value;

    public LambdaCalculatingObject(Double initialValue) {
        this.value = initialValue;
    }

    public static LambdaCalculatingObject getNew(Double initialValue) {
        return new LambdaCalculatingObject(initialValue);
    }

    public LambdaCalculatingObject calc(Calculation calculation) {
        this.value = calculation.calc(this.value);
        return this;
    }

    public Double getValue() {
        return this.value;
    }

    public static void example() {
        System.out.println(LambdaCalculatingObject
                .getNew(100.0)
                .calc(x -> x - 15.0) // 100 - 15 = 85
                .calc(x -> x * 2.0) // 85 * 2 = 170
                .calc(x -> x + 40.0) // 170 + 40 = 210
                .calc(x -> x / 70.0) // 210 / 70
                .getValue()); // 3
    }
}
