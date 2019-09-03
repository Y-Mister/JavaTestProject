package com.algorithm.test1;

/**
 * Author:yuanhang
 * Date:2019-09-03 19:21
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class No21 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode temp = l1;
        temp.next=new ListNode(2);
        temp=l1.next;
        temp.next= new ListNode(4);
        ListNode l2 = new ListNode(1);
        temp=l2;
        temp.next=new ListNode(3);
        temp=l2.next;
        temp.next= new ListNode(4);
        temp = mergeTwoLists2(l1,l2);

        while (temp!=null){
            System.out.print(temp.val+"->");
            temp=temp.next;
        }
    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head;
        ListNode tail;
        head = new ListNode(0);
        tail = head;

        while (l1!=null||l2!=null){
            int intVal_1 = l1!=null?l1.val:999999;
            int intVal_2 = l2!=null?l2.val:999999;
            if (intVal_1<=intVal_2){
                tail.next = new ListNode(intVal_1);
                tail=tail.next;
                l1 = l1.next;
            }else{
                tail.next = new ListNode(intVal_2);
                tail=tail.next;
                l2=l2.next;
            }
        }
        if (l1==null)
            tail.next=l2;
        if (l2==null)
            tail.next=l1;

        return head.next;
    }

    /*他人递归写法*/

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

}

class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }
