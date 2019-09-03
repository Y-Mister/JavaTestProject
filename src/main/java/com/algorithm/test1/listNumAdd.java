package com.algorithm.test1;

/**
 * Author:袁航
 * Date:2019-08-15 18:58
 * Description:2.两数相加 时间5ms 94.62% 空间47.4MB 91.70%
 */

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 0 -> 8
 原因：342 + 465 = 807
 */
public class listNumAdd {

    public static void main(String[] args) {
        ListNode L1 = new ListNode(9);
        L1.next = new ListNode(9);
        ListNode L2 =  new ListNode(1);
        listNumAdd listNumAdd = new listNumAdd();
        ListNode temp = listNumAdd.addTwoNumbers(L1,L2);
        while (temp!=null){
            System.out.print(temp.val + "->");
            temp=temp.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 =l2;
        ListNode head = new ListNode(0);
        ListNode result = null;
        ListNode node = null;
        head.next = null;
        result=head;
        int carry=0,out=0,deep=0;
        for (;temp1!=null&&temp2!=null;temp1=temp1.next,temp2=temp2.next){
            if (deep==0||carry==0){
                out = (temp1.val+temp2.val)%10;
                carry = (temp1.val+temp2.val)/10;
                deep++;

            }else{
                out = (temp1.val+temp2.val+carry)%10;//((int)Math.pow(10,deep)*(temp1.val+temp2.val)+carry)%10;
                carry =(temp1.val+temp2.val+carry)/10; //((int)Math.pow(10,deep)*(temp1.val+temp2.val)+carry)/10;
            }

           node = new ListNode(out);
            result.next = node;
            result=result.next;
        }


        if (temp1==null&&temp2!=null){
            while (carry!=0){
                if (temp2!=null){
                    out = (temp2.val+carry)%10;
                    carry =(temp2.val+carry)/10;
                    node = new ListNode(out);
                    result.next=node;
                    result=result.next;
                    temp2 = temp2.next;
                }else {
                    node = new ListNode(carry);
                    result.next=node;
                    result = result.next;

                }

            }
            if (temp2!=null)
                result.next=temp2;
        }else if (temp1!=null&&temp2==null){
            while (carry!=0){
                if (temp1!=null){
                    out = (temp1.val+carry)%10;
                    carry =(temp1.val+carry)/10;
                    node = new ListNode(out);
                    result.next=node;
                    result=result.next;
                    temp1 = temp1.next;
                }else {
                    node = new ListNode(carry);
                    result.next=node;
                    result = result.next;
                    carry=0;
                }
            }
            if (temp1!=null)
                result.next=temp1;
        }else if (carry!=0){
            node = new ListNode(carry);
            result.next = node;
            result=result.next;
        }

        return head.next;
    }



    /*他人答案，拿来学习*/

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + carry;
            carry = sumVal / 10;

            ListNode sumNode = new ListNode(sumVal % 10);
            cursor.next = sumNode;
            cursor = sumNode;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        return root.next;
    }

}




class ListNode2 {
    int val;
    ListNode next;
    ListNode2(int x) { val = x; }
}