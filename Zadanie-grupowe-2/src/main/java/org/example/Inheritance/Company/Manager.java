package org.example.Inheritance.Company;

public class Manager extends Employee {
    public Manager(String name, Integer age, String jobTitle) {
        super(name, age, jobTitle);
    }

    @Override
    public void introduce() {
        System.out.println("Good morning, my name is " + this.name + " and I manage " + this.department.getName());
    }
}
