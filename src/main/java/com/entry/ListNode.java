package com.entry;

/**
 * Created by lee on 16/2/4.
 */
public class ListNode<T> {
    T val;
    ListNode<T> next;

    public ListNode(T val) {
        this.val = val;
    }

    public ListNode(T val, ListNode<T> next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    public static <T> ListNode createCycle(T[] array,int index){
        ListNode head=new ListNode(0);
        ListNode p=head;
        int n=array.length;
        ListNode startNode=null;
        for(int i=0;i<n;i++){
            p.next=new ListNode(array[i]);
            p=p.next;
            if(i==index-1){
                startNode=p;
            }
        }
        p.next=startNode;
        return head.next;
    }

    public static <T> ListNode<T> arrayToList(T[] array) {
        ListNode<T> head = new ListNode<T>(null, null);
        ListNode<T> p = head;
        for (T t : array) {
            ListNode<T> node = new ListNode<T>(t, null);
            p.next = node;
            p = node;
        }
        return head;
    }

}
