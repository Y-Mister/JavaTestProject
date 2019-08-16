package com.yuan.CollectionTest;

/**
 * Author:helloboy
 * Date:2019-07-22 14:53
 * Description:<描述>
 */
public class MyHashMap2<K,V> {

    private Node3[] table;//核心存储结构，位桶数组

    private int size;

    private static int DEFAULT_CAPICITY=16;//一般定义为 2的整数次幂

    public MyHashMap2() {
        table = new Node3[DEFAULT_CAPICITY];
    }

    public void put(K key,V value){//还需要考虑数组扩容的问题

        Node3 newNode = new Node3();
        newNode.hash=myHash(key.hashCode(),table.length);
        newNode.key=key;
        newNode.value=value;
        newNode.next=null;

        Node3 temp = table[newNode.hash];
        Node3 last = null;
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
                Node3 temp = table[i].next;
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

    public V get(K key){
        int hash = myHash(key.hashCode(),table.length);
        V value = null;
        if (table[hash]!=null){
            Node3 temp = table[hash];
            while(temp!=null){
                if (temp.key.equals(key)){
                    value=(V)temp.value;
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
        MyHashMap2<Integer,String> map = new MyHashMap2<>();
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
