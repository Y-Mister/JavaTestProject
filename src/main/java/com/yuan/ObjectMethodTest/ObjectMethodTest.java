package com.yuan.ObjectMethodTest;

/**
 * Author:袁航
 * Date:2019-08-23 11:19
 * Description:java Object类中的方法
 */
public class ObjectMethodTest implements Cloneable{

    private Person person;
    private String type;

    public ObjectMethodTest(Person person, String type) {
        this.person = person;
        this.type = type;
    }

    public static void main(String[] args) throws CloneNotSupportedException {

        ObjectMethodTest obt1 = new ObjectMethodTest(new Person("AA"),"father");
        System.out.println(obt1.toString());
        ObjectMethodTest obt2 = (ObjectMethodTest) obt1.clone();
        System.out.println("obt1:"+obt1.hashCode()+"   obt2:"+obt2.hashCode());
        System.out.println("obt1:" + obt1);
        System.out.println("obt2:"+obt2);
        obt2.getPerson().setName("BB");
        System.out.println("obt1:" + obt1);
        System.out.println("obt2:"+obt2);
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        ObjectMethodTest objectMethodTest = (ObjectMethodTest) super.clone();
        objectMethodTest.person = (Person) person.clone();
        return objectMethodTest;
    }

    @Override
    public String toString() {
        return "ObjectMethodTest{" +
                "person=" + person +
                ", type='" + type + '\'' +
                '}';
    }
}

class Person implements Cloneable{
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}