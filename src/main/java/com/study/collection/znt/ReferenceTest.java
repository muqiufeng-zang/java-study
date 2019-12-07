package com.study.collection.znt;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  znt
 * @description  强引用
 * 强引用：不进行垃圾回收，如Object obj = new Object
 * 软引用：有用非必须对象，在内存溢出前进行回收，SoftReference
 * 弱引用：非必须对象，只能生存到下次垃圾收集时，WeakReference
 * 虚引用：无用对象，垃圾收集时会收到系统通知，PhantomReference
 * @Date 2019/12/07
 */
public class ReferenceTest {

    public static void main(String[] args) throws InterruptedException {

        /**
         * 1.强引用的情况下，对象不会被清理
         * 2.强引用情况下，对象显示地被置为null，GC才会清理该对象
         */
        List<String> list = new ArrayList<>();
        List<String> list1=list;
        for(int i=0;i<10;i++){
            list.add("abc"+i);
        }
        System.out.println("GC前："+list);
        System.out.println("GC前："+list1);
        /**
         * 虚拟机参数：-verbose:gc
         * （1）当我们直接调用System.gc()只会把这次gc请求记录下来，等到runFinalization=true的时候才会先去执行GC
         * 所以有时候，第一次调用gc和第二次调用gc，都会有内存变化，一般到达第三次的时候，gc才能完成
         * （2）日志的开头“GC”、“Full GC”表示这次垃圾收集的停顿类型
         * 如果有Full，则说明本次GC停止了其他所有工作线程(Stop-The-World)
         * Full GC的写法是“Full GC(System)”，这说明是调用System.gc()方法所触发的GC
         * （3） 3941K->816K(251392K)表示该区域已使用的容量->GC后该内存区域已使用的容量(该内存区总容量)
         * （4）0.0010877 secs 表示该内存区域GC所占用的时间，单位是秒
         */
        System.gc();
        System.gc();
        System.gc();

        System.out.println("GC后："+list);
        System.out.println("GC后："+list1);
        //将数组和list对象置为null，以便GC进行清理
        list.clear();
        list = null;
        System.gc();
        System.gc();
        System.gc();
        System.out.println("再次GC后："+list);
        System.out.println("再次GC后："+list1);

    }







}
