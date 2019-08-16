package com.yuan.CollectionTest;

/**
 * Author:helloboy
 * Date:2019-07-22 14:00
 * Description:手写HashMap
 */
public class MyHashMap {

    private Node2[] table;//核心存储结构，位桶数组

    private int size;

    private static int DEFAULT_CAPICITY=16;//一般定义为 2的整数次幂

    public MyHashMap() {
        table = new Node2[DEFAULT_CAPICITY];
    }

    public void put(Object key,Object value){//还需要考虑数组扩容的问题

        Node2 newNode = new Node2();
        newNode.hash=myHash(key.hashCode(),table.length);
        newNode.key=key;
        newNode.value=value;
        newNode.next=null;

        Node2 temp = table[newNode.hash];
        Node2 last = null;
        boolean keyReapet = false;
        if (temp==null){
            table[newNode.hash]=newNode;//该hash值的第一个元素
            size++;
        }else{//遍历链表并添加元素
            while (temp!=null){
                //key发生重复，直接替换
                if (temp.key.equals(key)){
                    temp.value=value;
                    keyReapet=true;
                    break;
                }
                last=temp;//保存一下上一个元素，为了在结尾添加铺垫
                temp=temp.next;

            }
            if (!keyReapet){
                last.next=newNode;
                size++;
            }
        }

    }

    public static int myHash(int v,int length){
        //System.out.println("hash1:"+(v&(length-1)));
        //System.out.println("hash1:"+(v%length));
        return v&(length-1);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i=0;i<table.length;i++ ){
            if (table[i]!=null){

                sb.append(table[i].key+":[");
                sb.append(table[i].value);
                Node2 temp = table[i].next;
                while (temp!=null){
                    sb.append(","+temp.value);
                    temp=temp.next;
                }
                sb.append("],");

            }

        }
            sb.setCharAt(sb.length()-1,'}');

        return sb.toString();

    }

    public Object get(Object key){
        int hash = myHash(key.hashCode(),table.length);
        Object value = null;
        if (table[hash]!=null){
            Node2 temp = table[hash];
            while(temp!=null){
                if (temp.key.equals(key)){
                    value=temp.value;
                    break;
                }
                temp=temp.next;
            }
        }
        return value;
    }

    public int size(){
        return size;
    }
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(10,"aa");
        map.put(20,"bb");
        map.put(30,"cc");
        map.put(53,"ee");
        map.put(69,"ff");
        map.put(85,"gg");
        System.out.println(map);
        System.out.println(map.size());
        System.out.println(map.get(69));
    }
}
