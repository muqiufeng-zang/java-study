package com.study.string;

/**
 * @author  zcp
 * @description  String字符串拼接
 * @Date 2019/10/13
 */
public class StringAppend {

    /**
     * String 拼接有3种方式 1. + 号方式  2. concat方法 3. append方法
     * 使用方法 1 它会使用StringBuilder的append方法进行追加，而它最终通过toString方法转换成String字符串，每一个 + 循环一次
     * 使用方法 2 他会在内存中进行数组拷贝，速度比较快，但是在最后还是会 new 一个 string 对象
     * 使用方法 3 会持续对原字符数组进行拷贝加长，最后通过toString返回，过程中没有创建新对象
     * 处理结果对比 append方法最快、concat次之、+号最慢
     * @param args
     */
    public static void main(String[] args) {

        String str = "a";
        long time = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            str += "c";
        }
        System.out.println("加号所花费的时间：");
        System.out.println(System.currentTimeMillis()-time);
        String str2 = "a";
        time = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            str2.concat("c");
        }
        System.out.println("cancat方法所花费的时间：");
        System.out.println(System.currentTimeMillis()-time);
        time = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder("a");
        for (int i = 0; i < 50000; i++) {
            stringBuilder.append("c");
        }
        String str3 = stringBuilder.toString();
        System.out.println("StringBuilder的append方法：");
        System.out.println(System.currentTimeMillis()-time);

    }

}
