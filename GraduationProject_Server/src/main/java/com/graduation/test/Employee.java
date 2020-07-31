package com.graduation.test;

public class Employee {
    private String name;
    private int age;
    private Double salary;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }

    public Employee(String name,int age,Double salary){
        this.salary = salary;
        this.age = age;
        this.name = name;
    }
}
