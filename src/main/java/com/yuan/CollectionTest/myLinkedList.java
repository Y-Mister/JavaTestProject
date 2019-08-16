package com.yuan.CollectionTest;

/**
 * Author:helloboy
 * Date:2019-07-22 9:49
 * Description:手写LinkedList
 */
public class myLinkedList<E> {

    private Node first;
    private Node last;
    private int size;

    public void add(E element){

        Node node = new Node(element);

        if (first==null){
            first=node;
            last=node;
            size++;
        }else{
            node.previous=last;
            node.next=null;
            last.next=node;
            last=node;
            size++;
        }

    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node node = first;
        for (;node.next!=null;node=node.next){
            sb.append(node.element+",");
        }
        sb.append(node.element+"]");

        return sb.toString();
    }

    public int size(){
        return size;
    }


    public E get(int index){
        checkIndex(index);

        Node temp = getNode(index);

        return temp!=null?(E)temp.element:null;

    }

    public Node getNode(int index){
        Node temp=null;
        if (index<(size>>1)){
            temp = first;
            for (int i=1;i<index;i++){
                temp = temp.next;
            }
        }else{
            temp = last;
            for (int i=size;i>index;i--){
                temp = temp.previous;
            }
        }
        return temp;
    }

    public void remove(int index){
        Node temp = getNode(index);

        if (temp!=null){
            Node up = temp.previous;
            Node down = temp.next;
            if (up!=null){
                up.next=down;
            }

            if (down!=null){
                down.previous=up;
            }
            //删除第一个元素
            if (index==1){
                first=down;
            }
            //删除最后一个元素
            if (index==size){
                last=up;
            }

            size--;
        }

    }


    //插入节点
    public void add(int index,E element){

        if (index-1==size){
            add(element);
        }else{
            checkIndex(index);
            Node newNode = new Node(element);
            Node temp = getNode(index);

            if(temp!=null){
                Node up = temp.previous;
                if (up==null) {//说明在第一个节点出插入
                    temp.previous=newNode;
                    newNode.next=temp;
                    first=newNode;

                }else{


                up.next = newNode;
                newNode.previous=up;
                newNode.next=temp;
                temp.previous=newNode;
            }
        }




        }

    }

    public void checkIndex(int index){
        if (index<=0||index>size){
            throw new RuntimeException("索引越界："+index);
        }
    }

    public static void main(String[] args) {
        myLinkedList<String> list = new myLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        System.out.println(list);
        list.add(7, "yuan");
        System.out.println(list);
        System.out.println(list.get(2));

    }
}
