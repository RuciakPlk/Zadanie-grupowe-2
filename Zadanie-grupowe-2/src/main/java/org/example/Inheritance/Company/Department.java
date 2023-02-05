package org.example.Inheritance.Company;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> employees;
    private Manager manager;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public static void example() {
        Department department = new Department("IT");

        Employee a = new Employee("Mateusz", 23, "IT Trainer");
        Employee b = new Employee("Karol", 35, "Lead Programmer");
        Employee c = new Employee("Tomasz", 30, "Backend Engineer");
        Employee d = new Employee("Ewelina", 25, "Frontend Developer");
        Manager m = new Manager("Wincenty", 40, "Product Manager");

        department.enrollEmployee(a);
        department.enrollEmployee(b);
        department.enrollEmployee(c);
        department.enrollEmployee(d);
        department.enrollManager(m);

        department.everyoneSayHello();
    }

    public void everyoneSayHello() {
        for (Employee employee : employees) {
            employee.introduce();
        }
    }

    public void enrollManager(Manager manager) {
        if (this.manager != null)
            return;

        this.manager = manager;
        this.employees.add(manager);
        manager.setDepartment(this);
    }

    public void enrollEmployee(Employee employee) {
        if (this.employees.contains(employee))
            return;

        this.employees.add(employee);
        employee.setDepartment(this);
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Manager getManager() {
        return manager;
    }
}
