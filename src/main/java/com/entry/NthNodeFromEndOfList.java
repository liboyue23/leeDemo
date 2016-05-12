package com.entry;

/**
 * Created by lee on 16/2/8.
 */
public class NthNodeFromEndOfList {
    public int lengthOfList(ListNode head){
        int m=0;
        ListNode p=head;
        while(p!=null){
            m++;
            p=p.next;
        }
        return m;
    }

    /**
     * 找到倒数第N个节点
     * @param head
     * @param n
     * @return
     */
    public ListNode find01(ListNode head,int n){
        if(head==null){
            return head;
        }else {
            int m=lengthOfList(head);
            ListNode p =head;
            for(int i=1;i<=m-n;i++){
                p=p.next;
            }
            return p;
        }
    }

    /**
     * 通过2个指针找到倒数第N个节点
     * @param head
     * @param n
     * @return
     */
    public ListNode find02(ListNode head,int n){
        if(head==null){
            return head;
        }else {
            ListNode p=head;
            ListNode next=head;
            for(int i=1;i<=n;i++){
                if(next!=null){
                    next=next.next;
                }
            }
            while(next!=null){
                p=p.next;
                next=next.next;
            }
            return p;
        }
    }
}
