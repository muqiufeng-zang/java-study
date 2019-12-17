package com.study.reference.znt;

import java.util.*;

/**
 * @author znt
 * @description 虚引用
 * 强引用：不进行垃圾回收，如Object obj = new Object
 * 软引用：有用非必须对象，在内存溢出前进行回收，SoftReference
 * 弱引用：非必须对象，只能生存到下次垃圾收集时，WeakReference
 * 虚引用：无用对象，垃圾收集时会收到系统通知，PhantomReference
 * @Date 2019/12/13
 */
public class WeakHashMapVSHashMap {

    public static void main(String[] agrs){
        long start  = System.currentTimeMillis();
        Map map = new WeakHashMap();
        List list = new ArrayList();
        for(int i=0;i<100000;i++){
            Integer ii = new Integer(i);
            map.put(ii,new byte[i]);
        }
        System.out.println("WeakHashMap: "+(System.currentTimeMillis()-start)+"ms");

        start  = System.currentTimeMillis();
        map = new HashMap();
        list = new ArrayList();
        for(int i=0;i<100000;i++){
            Integer ii = new Integer(i);
            map.put(ii,new byte[i]);
        }
        System.out.println("HashMap: "+(System.currentTimeMillis()-start)+"ms");
    }
}
