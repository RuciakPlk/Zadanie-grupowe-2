package org.example.Classes;

public class Human {
    // fields should always be private!
    private String name;
    private String occupation;
    private Integer age;

    public Human(String name, String occupation, Integer age) {
        this.name = name;
        this.occupation = occupation;
        this.age = age;
    }

    public static void printExample() {
        Human human = new Human("Mateusz", "Developer", 23);
        System.out.println(human.getName());
        human.setOccupation("Software Developer");
        System.out.println(human.getOccupation());
        System.out.println(human.getAge());
    }

    // getter for the "name" field
    public String getName() {
        return this.name;
    }

    // setter for the "name" field
    public void setName(String value) {
        this.name = value;
    }

    public String getOccupation() {
        return this.occupation;
    }

    public void setOccupation(String value) {
        this.occupation = value;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
