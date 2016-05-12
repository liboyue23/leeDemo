package com.entry;

import org.junit.Test;

/**
 * Created by lee on 16/2/8.
 */
public class RemoveNthNodeFromEndOfList<T> {
    public ListNode remove(ListNode head, int n) {
        if (head == null) {
            return head;
        } else {
            ListNode pre = head;
            ListNode p2 = head;
            for (int i = 1; i <= n; i++) {
                if (p2 == null) {
                    return head.next;
                }
                p2 = p2.next;
            }
            while (p2 != null) {
                p2 = p2.next;
                pre = pre.next;
            }
            pre.next = pre.next.next;
            return pre;
        }
    }

    public ListNode removeElements(ListNode head, T val) {
        if (head == null) {
            return head;
        } else {
            ListNode newHead = new ListNode(0);
            newHead.next = head;
            ListNode pre = newHead;
            ListNode p = head;
            while (p != null) {
                if (p.val == val) {
                    pre.next = p.next;
                    p = p.next;
                } else {
                    pre = p;
                    p = p.next;
                }
            }
            return newHead.next;
        }
    }


    public ListNode removeRepeat(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        } else {
            ListNode pre = head;
            ListNode p = head.next;
            while (p != null) {
                if (pre.val == p.val) {
                    while (p != null && pre.val == p.val) {
                        p = p.next;
                    }
                    pre.next = p;
                } else {
                    pre = p;
                    p = p.next;
                }
            }
            return head;
        }

    }

    public ListNode removeDuplicate2(ListNode head){
        if(head==null||head.next==null){
            return head;
        }else {
            ListNode newHead=new ListNode(0);
            newHead.next=head;
            ListNode pre=newHead;
            ListNode p=head;
            ListNode next=null;
            while(p!=null&&p.next!=null){
                next=p.next;
                if(p.val==next.val){
                    while(next!=null&&next.val==p.val){
                        next=next.next;
                    }
                    pre.next=next;
                    p=next;
                }else {
                    pre=p;
                    p=p.next;
                }
            }
            return newHead.next;
        }
    }

    @Test
    public void testRemoveElements() {
        MiniList<Integer> list = new MiniList();
        Integer[] array = {1, 2, 3, 4, 5, 6, 7};
        ListNode<Integer> head = list.arrayToList(array);
        head = removeElements(head, (T) new Integer(6));
        System.out.println(head.toString());
    }

    @Test
    public void testRemoveRepeat() {
        MiniList<Integer> list = new MiniList();
        Integer[] array = {1, 1, 2, 3, 3, 3, 4, 3, 5, 6, 7};
        ListNode<Integer> head = list.arrayToList(array);
        System.out.println(removeRepeat(head).toString());
    }

    @Test
    public void testRemoveDumplicate2(){
        MiniList<Integer> list = new MiniList();
        Integer[] array = {1, 1, 2, 3, 3, 3, 4, 3, 5, 6, 7};
        ListNode<Integer> head = list.arrayToList(array);
        System.out.println(removeDuplicate2(head).toString());
    }
}
