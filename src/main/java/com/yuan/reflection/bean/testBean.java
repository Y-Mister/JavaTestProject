package com.yuan.reflection.bean;

/**
 * Created by 朱承才 on 2019/8/18.
 */
public class testBean {
    private String name;
    private int id;
    private int age;

    public String getName() {
        return name;
    }

    public testBean(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    private testBean(String name){
        this.name=name;

    }

    public testBean(){

    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
