package com.study.reference.znt;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * @author znt
 * @description 软引用
 * 强引用：不进行垃圾回收，如Object obj = new Object
 * 软引用：有用非必须对象，在内存溢出前进行回收，SoftReference
 * 弱引用：非必须对象，只能生存到下次垃圾收集时，WeakReference
 * 虚引用：无用对象，垃圾收集时会收到系统通知，PhantomReference
 * @Date 2019/12/12
 */
public class SoftReferenceTest {

    public static ReferenceQueue softQueue;

    /***
     *  所有类都是继承Object
     *  @Override声明说明是重写Object中的finalize()和toString()方法
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        Reference<SoftReferenceTest> obj = null;
        try {
            obj = (Reference<SoftReferenceTest>) softQueue.remove();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(obj);
        if (obj != null) {
            System.out.println("Object for SoftReference is " + obj.get());
        }
        //只有当GC回收时才会输出
        System.out.println("SoftReferenceTest's finalize called");
    }

    @Override
    public String toString() {
        return "I am SoftReferenceTest";
    }

    /**
     * 如果一个对象只具有软引用，则内存空间足够，垃圾回收器就不会回收它；如果内存空间不足了，就会回收这些对象的内存。
     * 只要垃圾回收器没有回收它，该对象就可以被程序使用。软引用可用来实现内存敏感的高速缓存。
     * 软引用可以和一个引用队列（ReferenceQueue）联合使用，如果软引用所引用的对象被垃圾回收器回收，
     * Java虚拟机就会把这个软引用加入到与之关联的引用队列中。
     * 注意：-XX:SoftRefLRUPolicyMSPerMB=1
     */
    public static void main(String[] args) throws InterruptedException {
        SoftReferenceTest softReferenceTest = new SoftReferenceTest();
        softQueue = new ReferenceQueue<SoftReferenceTest>();
        SoftReference<SoftReferenceTest> softRef = new SoftReference<SoftReferenceTest>(softReferenceTest, softQueue);
        System.out.println(softReferenceTest);
        softReferenceTest = null;
        System.gc();
        System.out.println(softReferenceTest);
        System.out.println("After GC:Soft Get= " + softRef.get());
        System.out.println("分配大块内存");
        List<String> list = new ArrayList<>();
        for(int i=0;i<20000000;i++){
            list.add(""+i);
        }
        System.out.println("After new List: Soft Get= " + softRef.get());
        System.out.println(softReferenceTest);


    }
}
