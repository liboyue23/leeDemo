package com.entry;

/**
 * Created by lee on 16/2/10.
 */
public class MiniQueue<T> {
    private int size;
    private Node<T> head;
    private Node<T> last;
    public boolean isEmpty(){
        if(size==0){
            return true;
        }else {
            return false;
        }
    }

    public int size(){
        return size;
    }

    public MiniQueue() {
        super();
        head=new Node<T>(null,null);
        last=head;
    }

    public void offer(T t){
        Node<T> node=new Node<T>(t,null);
        last.next=node;
        last=node;
        size++;
    }

    public T peek(){
        if(isEmpty()){
            return null;
        }else {
            return head.next.val;
        }
    }

    public T poll(){
        if(isEmpty()){
            return null;
        }else {
            Node<T> p=head.next;
            head.next=p.next;
            size--;
            if(size==0){
                last=head;
            }
            return p.val;
        }
    }
}

class Node<T>{
    T val;
    Node<T> next;

    public Node(T val, Node<T> next) {
        this.val = val;
        this.next = next;
    }
}
