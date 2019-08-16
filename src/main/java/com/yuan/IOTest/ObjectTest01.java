package com.yuan.IOTest;

import java.io.*;
import java.util.Date;

/**
 * Author:helloboy
 * Date:2019-07-28 15:11
 * Description:
 * 对象流
 * 先写出后读取
 * 不是所有对象都可以序列化，必须实现serializable接口
 *
 * DataInputStream
 * DataOutputStream
 */
public class ObjectTest01 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //写出
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(bos));
        //操作基本数据类型+数据
        oos.writeUTF("编码辛酸泪");
        oos.writeBoolean(true);
        oos.writeInt(155);
        oos.writeChar('C');
        //加入对象 序列化
        oos.writeObject("编码辛酸泪，谁解其中味");
        oos.writeObject(new Date());
        Employee employee = new Employee(101,"张三");
        oos.writeObject(employee);
        oos.flush();
        byte[] bytes = bos.toByteArray();
        //读取 对象数据还原反序列化
        ObjectInputStream ois = new ObjectInputStream(
                                new BufferedInputStream(
                                    new ByteArrayInputStream(bytes)));
        String s = ois.readUTF();
        boolean b = ois.readBoolean();
        int i = ois.readInt();
        char c = ois.readChar();
        Object str = ois.readObject();
        Object date = ois.readObject();
        Object emp = ois.readObject();
        System.out.println(s+" "+b+" "+i+" "+c);
        //读取时的顺序一定要与写入是相一致，否则将报错
        if (str instanceof String){
            System.out.println((String)str);
        }
        if (date instanceof Date){
            System.out.println((Date)date);
        }
        if (emp instanceof Employee){
            System.out.println((Employee)emp);
        }
        oos.close();
        ois.close();
    }
}

class Employee implements Serializable{
    private transient int id;//若数据不需要序列化，可加transient关键字
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}