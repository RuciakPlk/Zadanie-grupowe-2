package org.example.Encapsulation;

public class VeryEncapsulatedClass {
    // ENCAPSULATION OF FIELDS

    // Can only be read and set by this class
    private Integer privateFieldWithoutAccessors;

    // Can be read by anyone, set only by this class
    private Integer privateFieldWithPublicGetter;

    public Integer getPrivateFieldWithPublicGetter() {
        return this.privateFieldWithPublicGetter;
    }

    // Anyone can read or set this field
    private Integer privateFieldWithPublicGetterAndSetter;

    public Integer getPrivateFieldWithPublicGetterAndSetter() {
        return this.privateFieldWithPublicGetterAndSetter;
    }

    public void setPrivateFieldWithPublicGetterAndSetter(Integer value) {
        this.privateFieldWithPublicGetterAndSetter = value;
    }

    // ENCAPSULATION OF METHODS
    private void privateNonStaticMethod() {
        // This can only be executed in this class, and we need an object!
    }

    private static void privateStaticMethod() {
        // This can only be executed in this class
    }

    protected void protectedNonStaticMethod() {
        // This can only be executed in this class, or in an inheriting class, and we need an object!
    }

    protected static void protectedStaticMethod() {
        // This can only be executed in this class, or in an inheriting class
    }

    void defaultNonStaticMethod() {
        // This can only be executed in this package, and we need an object!
    }

    static void defaultStaticMethod() {
        // This can only be executed in this package
    }

    public void publicNonStaticMethod() {
        // This can be executed by anyone, but we need an object!
    }

    public static void publicStaticMethod() {
        // This can be executed by anyone!
    }
}
