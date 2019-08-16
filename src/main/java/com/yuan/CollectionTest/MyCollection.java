package com.yuan.CollectionTest;

/**
 * Author:helloboy
 * Date:2019-07-21 21:40
 * Description:手写ArrayList
 */
public class MyCollection {

    private Object[] elementDate;
    private int size;
    static final int Default_CAPITICY=10;
    public MyCollection(){
        elementDate = new Object[Default_CAPITICY];
    }

    public MyCollection(int capicity){
        elementDate = new Object[capicity];
    }

    public void add(Object obj){
        elementDate[size++]=obj;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i=0;i<size;i++){
            sb.append(elementDate[i]+",");
        }
        sb.setCharAt(sb.length()-1,']');//针对最后一位后仍然存在逗号的处理
        return sb.toString();
    }

    public static void main(String[] args) {
        MyCollection m = new MyCollection(20);
        m.add("aa");
        m.add("bb");
        System.out.println(m);
    }



}
