package com.entry;

/**
 * Created by lee on 16/2/4.
 */
public class Singleton {
//    private static Singleton singleton=new Singleton();
//
//    private Singleton() {
//
//    }
//
//    public static Singleton getInstance(){
//        return singleton;
//    }


    static class SingletonHolder{
        private  static Singleton singleton=new Singleton();

    }

    public static Singleton get(){
        return SingletonHolder.singleton;
    }

}
