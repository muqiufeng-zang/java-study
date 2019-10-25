package com.study.object;

/**
 * @author  zcp
 * @description 对象创建方式new 和 clone 的效率对比
 * @Date 2019/10/25
 */
public class NewObject {

    private static final int COUNT = 10000 * 1000;

    /**
     * 1.对于没有自定义构造函数的类来说，new 比 clone 要快
     * 2.对于在构造函数内有逻辑的类来书，clone 比 new 效率要高很对
     * 3.clone只是一个浅拷贝，可以对对象内的变量进行拷贝，不能对对象内引用的对象进行拷贝
     * @param args
     * @throws CloneNotSupportedException
     */
    public static void main(String[] args) throws CloneNotSupportedException {

        long s1 = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            Bean bean = new Bean("ylWang");
        }

        long s2 = System.currentTimeMillis();
        Bean bean = new Bean("ylWang");
        for (int i = 0; i < COUNT; i++) {
            Bean b = bean.clone();
        }

        long s3 = System.currentTimeMillis();
        System.out.println("new  = " + (s2 - s1));
        System.out.println("clone = " + (s3 - s2));
    }

}
