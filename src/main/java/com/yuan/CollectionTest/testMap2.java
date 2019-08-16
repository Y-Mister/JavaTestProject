package com.yuan.CollectionTest;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:helloboy
 * Date:2019-07-22 12:24
 * Description:<描述>
 */
public class testMap2 {

    public static void main(String[] args) {
        Employee el = new Employee(1001,"jkad",50000);
        Employee e2 = new Employee(1002,"jkad2",50000);
        Employee e3 = new Employee(1003,"jkad3",50000);
        Employee e4 = new Employee(1001,"jkad4",50000);

        Map<Integer,Employee> map = new HashMap<>();
        map.put(1001,el);
        map.put(1002,e2);
        map.put(1003,e3);

        Employee employee = map.get(1001);
        System.out.println(employee.getName());

        map.put(1001, e4);
        Employee employee2 = map.get(1001);
        System.out.println(employee2.getName());


    }
}

class Employee{
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
