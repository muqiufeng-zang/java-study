package com.study.string;

/**
 * @author  zcp
 * @description  String、 StringBuffer 和 StringBuilder 效率对比
 * @Date 2019/10/25
 */
public class StringBufferWithStringBuilder {

    /**
     * 1.使用String类的场景：在字符串不经常变化的场景中可以使用String类，例如常量的声明、少量的变量运算。
     */
    public static void testString() {
        long start = System.currentTimeMillis();
        String str = null;
        for (int i = 0; i < 200000; i++) {
            str = str + i + "-";
        }
        System.out.println("String:" + (System.currentTimeMillis() - start));
    }

    /**
     * 2.使用StringBuffer类的场景：在频繁进行字符串运算（如拼接、替换、删除等），并且运行在多线程环境中，
     * 则可以考虑使用StringBuffer，例如XML解析、HTTP参数解析和封装。
     */
    public static void testStringBuffer() {
        long start = System.currentTimeMillis();
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < 200000; i++) {
            sbuf.append(i + "-");
        }
        System.out.println("StringBuffer:" + (System.currentTimeMillis() - start));
    }

    /**
     * 3.使用StringBuilder类的场景：在频繁进行字符串运算（如拼接、替换、和删除等），并且运行在单线程的环境中，
     * 则可以考虑使用StringBuilder，如SQL语句的拼装、JSON封装等。
     */
    public static void testStringBuilder() {
        long start = System.currentTimeMillis();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 200000; i++) {
            builder.append(i + "-");
        }
        System.out.println("StringBuilder:" + (System.currentTimeMillis() - start));
    }

    /**
     * StringBuffer是线程安全的，有加锁开销，效率略低。StringBuilder非线程安全，不用加锁，效率更高。一般字符串相加不会有多线程操作，
     * 所以推荐使用StringBuilder。StringBuilder是jdk1.5之后引入的，之前只能使用StringBuffer。另外，事实上我们在java里写的字符串
     * 相加的操作被编译后都是通过new一个StringBuffer或StringBuilder对象来操作的，所以不会产生大量的String对象
     * @param args
     */
    public static void main(String args[]) {
        testString();
        testStringBuffer();
        testStringBuilder();
    }
}
