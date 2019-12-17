package com.study.reference.znt;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * @author znt
 * @description 虚引用
 * 强引用：不进行垃圾回收，如Object obj = new Object
 * 软引用：有用非必须对象，在内存溢出前进行回收，SoftReference
 * 弱引用：非必须对象，只能生存到下次垃圾收集时，WeakReference
 * 虚引用：无用对象，垃圾收集时会收到系统通知，PhantomReference
 * @Date 2019/12/17
 */
public class PhantomReferenceTest {

    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        ReferenceQueue<Object> refQueue = new ReferenceQueue<>();
        PhantomReference<Object>  phanRef = new PhantomReference<>(obj,refQueue);
        //phanRef里面有元素但是一直返回null
        //因为PhantomReference重写了Reference的get方法，写死了返回null
        System.out.println(phanRef.get());
        System.out.println(refQueue.poll());
        obj = null;
        System.gc();
        System.gc();
        System.gc();
        //phanRef里面仍然有元素，referent并没有像弱引用软引用那样置空
        System.out.println(phanRef.get());
        //虚引用里面的对象没有强引用时候，开始回收，加入到队列去，队列有值
        System.out.println(refQueue.poll());

    }
}
