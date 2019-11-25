package com.study.collection;

import java.lang.ref.SoftReference;

/**
 * 软引用是用来描述一些还有用但并非必须的对象。对于软引用关联着的对象，在系统将要发生内存溢出异常之前，将会把这些对象列进回收范围进行第二次
 * 回收。如果这次回收还没有足够的内存，才会抛出内存溢出异常。
 * @author zcp
 * 2019/11/24 上午11:22
 * Most is the gentleness which that one lowers the head,
 * looks like a water lotus flower extremely cool breeze charming.
 */
public class SoftReferenceTest {


    /**
     * 当前示例中就能看出，软引用关联的对象不会被GC回收。JVM在分配空间时，若果Heap空间不足，就会进行相应的GC，但是这次GC并不会收集软
     * 引用关联的对象，但是在JVM发现就算进行了一次回收后还是不足（Allocation Failure），JVM会尝试第二次GC，回收软引用关联的对象。
     * 像这种如果内存充足，GC时就保留，内存不够，GC再来收集的功能很适合用在缓存的引用场景中。在使用缓存时有一个原则，如果缓存中有就从缓存获
     * 取，如果没有就从数据库中获取，缓存的存在是为了加快计算速度，如果因为缓存导致了内存不足进而整个程序崩溃，那就得不偿失了。
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        //100M的缓存数据
        byte[] cacheData = new byte[100 * 1024 * 1024];
        //将缓存数据用软引用持有
        SoftReference<byte[]> cacheRef = new SoftReference<>(cacheData);
        //将缓存数据的强引用去除
        cacheData = null;
        System.out.println("第一次GC前" + cacheData);
        System.out.println("第一次GC前" + cacheRef.get());
        //进行一次GC后查看对象的回收情况
        System.gc();
        //等待GC
        Thread.sleep(500);
        System.out.println("第一次GC后" + cacheData);
        System.out.println("第一次GC后" + cacheRef.get());

        //在分配一个120M的对象，看看缓存对象的回收情况
        byte[] newData = new byte[120 * 1024 * 1024];
        System.out.println("分配后" + cacheData);
        System.out.println("分配后" + cacheRef.get());
    }
}
