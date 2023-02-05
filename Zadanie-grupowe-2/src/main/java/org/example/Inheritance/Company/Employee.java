package org.example.Inheritance.Company;

public class Employee extends Person {
    protected String jobTitle;
    protected Department department;

    public Employee(String name, Integer age, String jobTitle) {
        super(name, age);
        this.jobTitle = jobTitle;
    }

    public void introduce() {
        System.out.println("Hello, I'm " + this.name + " and I work in " + this.department.getName());
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
