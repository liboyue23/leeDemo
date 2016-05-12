package com.entry;

import java.util.Comparator;
import java.util.Stack;

/**
 * Created by lee on 16/2/4.
 */
public class MiniList<T> {
    private ListNode<T> head = new ListNode<T>(null, null);

    public Comparator<T> comp;

    public int compare(T a, T b) {
        if (comp != null) {
            return comp.compare(a, b);
        } else {
            Comparable<T> c = (Comparable<T>) a;
            return c.compareTo(b);
        }
    }

    /**
     * 数组转换成链表
     *
     * @param array
     */
    public ListNode<T> arrayToList(T[] array) {
        ListNode<T> p = head;
        for (T t : array) {
            ListNode<T> node = new ListNode<T>(t, null);
            p.next = node;
            p = node;
        }
        return head;
    }

    public void printList() {
        ListNode<T> p = head.next;
        while (p != null) {
            System.out.print(p.val + "  ");
            p = p.next;
        }
        System.out.println();
    }


    public void insert(int index, T value) {
        ListNode<T> p = head;
        for (int i = 0; i <= index; i++) {
            p = p.next;
        }

        ListNode<T> node = new ListNode<T>(value, null);
        node.next = p.next;
        p.next = node;
    }

    public T remove(int index) {
        ListNode<T> pre = head;

        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        ListNode<T> p = pre.next;
        pre.next = p.next;
        return p.val;
    }

    public T get(int index) {
        ListNode<T> p = head;
        for (int i = 0; i <= index; i++) {
            p = p.next;
        }
        return p.val;
    }

    public void set(int index, T value) {
        ListNode<T> p = head;
        for (int i = 0; i <= index; i++) {
            p = p.next;
        }
        p.val = value;
    }

    /**
     * 利用压栈方式实现链表翻转
     */
    public void printInverse() {
        if (head == null) {
            return;
        }
        Stack<T> stack = new Stack<T>();
        ListNode<T> p = head.next;
        while (p != null) {
            stack.push(p.val);
            p = p.next;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + "  ");
        }
        System.out.println();
    }

    /**
     * 递归实现链表翻转
     *
     * @param p
     */
    public void recursive(ListNode<T> p) {
        if (p != null) {
            recursive(p.next);
            System.out.print(p.val + "  ");
        }
    }

    public void printInverseRecursive() {
        if (head == null) {
            return;
        }
        recursive(head.next);
    }

    public T getMax() {
        if (head.next == null) {
            return null;
        }
        ListNode<T> p = head.next;
        T max = p.val;
        while (p != null) {
            if (compare(p.val, max) > 0) {
                max = p.val;
            }
            p = p.next;
        }
        return max;
    }

    /**
     * 翻转链表
     * @param head
     * @return
     */
    public ListNode<T> reverseNode(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode<T> pre=head;
        ListNode<T> p=head.next;
        ListNode<T> next=null;
        while(p!=null){
            next=p.next;
            p.next=pre;
            pre=p;
            p=next;
        }
        return pre;
    }


    public ListNode<T> recursiveListNode(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode tail =recursiveNode(head);
        head.next=null;
        return tail;
    }
    private ListNode<T> recursiveNode(ListNode head){
        if(head==null||head.next==null){
            return head;
        }

        ListNode next=head.next;
        ListNode<T> tail = recursiveNode(next);
        next.next=head;
        return tail;
    }
}
