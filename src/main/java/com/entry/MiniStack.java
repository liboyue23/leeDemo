package com.entry;

/**
 * Created by lee on 16/2/10.
 */
public class MiniStack<T> {
    private int size;
    private Object[] array=new Object[4];

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

    public void expandCapacity(){
        //1.新建一个比较大的新数组
        Object[] newArray=new Object[size*2];
        System.arraycopy(array,0,newArray,0,size);
        array=newArray;
    }

    public void push(T t){
        array[size]=t;
        size++;
        if(size==array.length){
            expandCapacity();
        }
    }

    public T peek(){
        if(isEmpty()){
            return null;
        }else {
            return (T) array[size-1];
        }
    }

    public T pop(){
        if(isEmpty()){
            return null;
        }else {
            T t=peek();
            array[size-1]=null;
            size--;
            return t;
        }
    }
}
