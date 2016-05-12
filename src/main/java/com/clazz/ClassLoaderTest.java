package com.clazz;

/**
 * Created by lee on 16/2/15.
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader loader=Thread.currentThread().getContextClassLoader();
        System.out.println("current loader:"+loader);
        System.out.println("current loader parent:"+loader.getParent());
        System.out.println("current loader gradparent:"+loader.getParent().getParent());

    }
}
