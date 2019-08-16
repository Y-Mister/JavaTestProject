package com.yuan.CollectionTest;

/**
 * Author:helloboy
 * Date:2019-07-22 9:53
 * Description:<描述>
 */
public class Node {

    Node previous;
    Node next;
    Object element;


    public Node(Node previous, Node next, Object element) {
        this.previous = previous;
        this.next = next;
        this.element = element;
    }

    public Node(Object element) {
        this.element = element;
    }
}
