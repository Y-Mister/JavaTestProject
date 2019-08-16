package com.yuan.CollectionTest;

/**
 * Author:helloboy
 * Date:2019-07-21 22:01
 * Description:手写ArrayList
 */
public class MyCollection2<E> {
    private Object[] elementDate;
    private int size;
    static final int Default_CAPITICY=10;
    public MyCollection2(){
        elementDate = new Object[Default_CAPITICY];
    }

    public MyCollection2(int capicity){
        if (capicity<0){
            throw new RuntimeException("容器容量不能为负数");
        }else if (capicity==0){
            elementDate = new Object[Default_CAPITICY];
        }else{
            elementDate = new Object[capicity];
        }
    }



    public void add(E element){
        /*扩容操作*/
        //什么时候扩容呢，即数组当前的容量等于了数组初始化的长度
        if (size==elementDate.length){
            //如何扩容呢？即将原数组复制到一个更大容量的数组
            Object[] newArray = new Object[elementDate.length+(elementDate.length>>1)];//elementDate.length+elementDate.length>>这个操作存在优先级问题，+大于右移，最后等于没有进行扩容
            System.arraycopy(elementDate, 0, newArray, 0, elementDate.length);
            //完成扩容，将内容数组从新指向新的数组
            elementDate = newArray;
        }
        elementDate[size++]=element;
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

    public E get(int index){
        //index合法性判断
        checkIndex(index);
        return (E)elementDate[index];
    }



    public void set(E element,int index){
        checkIndex(index);
        elementDate[index]=element;
    }

    public void remove(E element){
        for (int i=0;i<size;i++){
            if(element.equals(elementDate[i])){
                //将当前位置这个元素移除，并跳出循环
                remove(i);
            }
        }
    }

    public void remove(int index){
        checkIndex(index);
        int MovedNum = elementDate.length-1-index;
        if (MovedNum>0){
            System.arraycopy(elementDate,index+1,elementDate,index,MovedNum);
        }
        elementDate[size--]=null;//size--与--size均可行
        System.out.println(size);
    }

    public void checkIndex(int index){
        if(index<0||index>size-1){
            //不合法
            throw new RuntimeException("索引越界:"+index);
        }
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        if (size==0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MyCollection2 m = new MyCollection2(20);

        for (int i=0;i<40;i++){
            m.add("yuan"+i);
        }
        m.set("ddd",11);
        System.out.println(m);
        System.out.println(m.get(39));
        m.remove(5);
        System.out.println(m);
    }

}
