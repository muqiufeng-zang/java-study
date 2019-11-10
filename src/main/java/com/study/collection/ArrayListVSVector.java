package com.study.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * @author zcp
 * 2019/11/10 下午9:13
 * Most is the gentleness which that one lowers the head,
 * looks like a water lotus flower extremely cool breeze charming.
 */
public class ArrayListVSVector {

    /**
     * ArrayList和Vector都是java中比较重要的容器，他们都可以存储各种对象，它们有相同的继承结构，提供大致相同的功能，主要的差异点如下：
     *
     * Vector是线程安全的容易，可以在并发环境中安全地使用，而ArrayList是非线程安全的
     * ArrayList进行扩容时增加50%，Vector提供了扩容时的增量设置，但通常将容量扩大1倍
     * Vector可以使用Enumeration和Iterator进行元素遍历，ArrayList只提供了Iterator的方式
     * 由于使用的线程同步，Vector的效率比ArrayList低
     */
    public static void main(String[] args){
        runArrayList();
        runVector();
    }

    private static void runVector(){
        Vector sVector = new Vector();
        long start = System.currentTimeMillis();
        for (int i = 0 ; i < 500000 ; i++) {
            sVector.add("qiwoo_test_add" + i);
        }
        long end = System.currentTimeMillis();
        System.out.println("vector add time consuming:" + (end - start));

        Iterator<String> iterator = sVector.iterator();
        long visitStart = System.currentTimeMillis();
        while (iterator.hasNext()) {
            String str = iterator.next();
        }
        long visitEnd = System.currentTimeMillis();
        System.out.println("vector visit time consuming:" + (visitEnd -visitStart));

        long randAccessStart = System.currentTimeMillis();
        for (int i = 0 ; i < 500000 ; i++) {
            sVector.get(i);
        }
        long randAccessend = System.currentTimeMillis();
        System.out.println("vector random access time consuming:" +(randAccessend - randAccessStart));
    };

    private static void runArrayList(){
        List sArray = new ArrayList();
        long start = System.currentTimeMillis();
        for (int i = 0 ; i < 500000 ; i++) {
            sArray.add("qiwoo_test_add" + i);
        }
        long end = System.currentTimeMillis();
        System.out.println("array add time consuming:" + (end - start));



        Iterator<String> iterator = sArray.iterator();
        long visitStart = System.currentTimeMillis();
        while (iterator.hasNext()) {
            String str = iterator.next();
        }
        long visitEnd = System.currentTimeMillis();
        System.out.println("array visit time consuming:" + (visitEnd -visitStart));

        long randAccessStart = System.currentTimeMillis();
        for (int i = 0 ; i < 500000 ; i++) {
            sArray.get(i);
        }
        long randAccessend = System.currentTimeMillis();
        System.out.println("array random access time consuming:" +(randAccessend - randAccessStart));
    };

}
