package com.entry;

import org.junit.Test;

/**
 * Created by lee on 16/2/4.
 */
public class TestList {
    @Test
    public void test01(){
        ListNode<Integer> p4=new ListNode<Integer>(4,null);
        ListNode<Integer> p3=new ListNode<Integer>(3,p4);
        ListNode<Integer> p2=new ListNode<Integer>(2,p3);
        ListNode<Integer> p1=new ListNode<Integer>(1,p2);
    }

    @Test
    public void testNode02(){
        MiniList<Integer> list= new MiniList<Integer>();
        Integer[] array={0,1,2,3,4};
        list.arrayToList(array);
        list.printList();

        list.insert(2,10);
        list.printList();
        list.remove(2);
        list.printList();

        System.out.println(list.get(2));
        list.set(2,12);
        list.printList();

        list.printInverse();

        list.printInverseRecursive();
    }

    @Test
    public void testReverse(){
        MiniList<Integer> list= new MiniList<Integer>();
        Integer[] array={0,1,2,3,4};
        list.arrayToList(array);

        list.printInverseRecursive();
    }


    @Test
    public void testMax(){
        MiniList<Integer> list= new MiniList<Integer>();
        Integer[] array={1,0,6,2,3,4};
        list.arrayToList(array);

        System.out.println(list.getMax());
    }


    @Test
    public void testReverseNode(){
        MiniList list=new MiniList();
        Integer[] array={1,2};
        ListNode node=list.arrayToList(array);

        ListNode reverseNode = list.reverseNode(node);
        System.out.println(reverseNode);
    }

    @Test
    public void testRecursiveNode(){
        MiniList list=new MiniList();
        Integer[] array={1,0,6,2,3,4};
        ListNode node=list.arrayToList(array);

        ListNode reverseNode = list.recursiveListNode(node);
        System.out.println(reverseNode);
    }

    @Test
    public void testEndOfList(){
        MiniList list=new MiniList();
        Integer[] array={1,2,3,4,5,6};
        ListNode<Integer> head=list.arrayToList(array);

        NthNodeFromEndOfList nthNodeFromEndOfList=new NthNodeFromEndOfList();
        System.out.println(nthNodeFromEndOfList.find01(head,4).val);
    }

    @Test
    public void testEndOfListForTwoPoint(){
        MiniList list=new MiniList();
        Integer[] array={1,2,3,4,5,6};
        ListNode<Integer> head=list.arrayToList(array);

        NthNodeFromEndOfList nthNodeFromEndOfList=new NthNodeFromEndOfList();
        System.out.println(nthNodeFromEndOfList.find02(head,4).val);
    }


}
