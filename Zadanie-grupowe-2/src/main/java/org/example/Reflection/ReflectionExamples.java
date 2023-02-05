package org.example.Reflection;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Optional;

// Object.class - get the Class<?> information object from class itself (static)
// obj.getClass() - get the Class<?> information object from an object (non-static)

// Some common use cases of Reflection methods
public class ReflectionExamples {

    // Write out class's name (full and simple)
    public static void getClassName(Class<?> clazz) {
        System.out.println(clazz.getSimpleName()); // just the class's name
        System.out.println(clazz.getName()); // full name with package
    }

    // Write out information about class's fields
    public static void getClassFields(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields(); // get an array with fields' information
        // (declared means only fields declared in this class, it won't include fields from the superclass)

        for (Field field : fields) {
            // Display the fields' names and types
            System.out.println(field.getName() + " " + field.getType().getSimpleName());
        }
    }

    // Write out information about class's methods
    public static void getClassMethods(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods(); // get an array with methods' information

        for (Method method : methods) {
            // Display method's name and return type
            System.out.println(method.getName());
            System.out.println("Return type: " + method.getReturnType().getSimpleName());

            // If the method has any parameters, display their information
            for (Parameter parameter : method.getParameters()) {
                // Display parameter's name (if unable to retrieve the name, is will use arg0, etc.
                // and parameter's type
                System.out.println("Parameter: " + parameter.getName() + " " + parameter.getType().getSimpleName());
            }
            System.out.println();
        }
    }

    // Write out information about class's constructors
    public static void getClassConstructors(Class<?> clazz) {
        Constructor<?>[] ctors = clazz.getConstructors(); // get an array with class's Constructors information

        for (Constructor<?> ctor : ctors) {
            // Constructors can only be distinguished by their parameters, so write out their information
            for (Parameter parameter : ctor.getParameters()) {
                System.out.println("Parameter: " + parameter.getName() + " " + parameter.getType().getSimpleName());
            }
            System.out.println();
        }
    }

    // Get information on class's superclass (if there's one)
    public static void getClassSuperclass(Class<?> clazz) {
        Class<?> superclazz = clazz.getSuperclass(); // get information on class's superclass

        if (superclazz == null) {
            System.out.println("No superclass found");
        }
        else {
            // Analyze the superclass with the above methods
            System.out.println(superclazz.getSimpleName());
            getClassFields(superclazz);
            getClassMethods(superclazz);
            getClassConstructors(superclazz);
        }
    }

    // Get information about class's implemented interfaces
    public static void getClassInterfaces(Class<?> clazz) {
        Class<?>[] interfaces = clazz.getInterfaces(); // get an array of interface information

        for (Class<?> interfaze : interfaces) {
            // Write out interface's name and methods information
            System.out.println(interfaze.getSimpleName());
            getClassMethods(interfaze);
        }
    }

    // Read value of a private field from given object (field of given name and type)
    public static void getValueOfAPrivateField(Object obj, String fieldName, Class<?> fieldType) {
        Class<?> clazz = obj.getClass();
        try {
            Optional<Field> optionalField = Arrays.stream(clazz.getDeclaredFields())
                    .filter(f -> f.getName().equals(fieldName) && f.getType().equals(fieldType))
                    .findFirst();

            if (optionalField.isPresent()) {
                Field field = optionalField.get();
                field.setAccessible(true);
                Object value = field.get(obj);
                System.out.println(value.toString());
            }
            else {
                System.out.println("FIELD NOT FOUND!!!");
            }
        }
        catch (IllegalAccessException e) {
            System.out.println("ACCESS DENIED!!!");
        }
    }

    // Set value to a private field in given object (field of given name and type)
    public static void setValueOfAPrivateField(Object obj, String fieldName, Object newValue) {
        Class<?> clazz = obj.getClass();
        try {
            Optional<Field> optionalField = Arrays.stream(clazz.getDeclaredFields())
                    .filter(f -> f.getName().equals(fieldName) && f.getType().equals(newValue.getClass()))
                    .findFirst();

            if (optionalField.isPresent()) {
                Field field = optionalField.get();
                field.setAccessible(true);
                field.set(obj, newValue);
            }
            else {
                System.out.println("FIELD NOT FOUND!!!");
            }
        }
        catch (IllegalAccessException e) {
            System.out.println("ACCESS DENIED!!!");
        }
    }
}
