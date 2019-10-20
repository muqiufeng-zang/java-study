package com.study.string;

/**
 * @author  zcp
 * @description  String内字符串查找性能对比
 * @Date 2019/10/18
 */
public class StringFindChar {


    /**
     * charAt 方式是直接通过索引返回指定字符，而startsWith
     * @param args
     */
    public static void main(String[] args) {
        int size = 1000000;
        String str = "hello world !";
        long time = System.currentTimeMillis();
        for (int i = 0; i < size; i++){
            str.startsWith("h");
        }

        System.out.println(System.currentTimeMillis() - time);

        time = System.currentTimeMillis();

        for (int i = 0; i < size; i++){
            str.charAt(0);
        }
        System.out.println(System.currentTimeMillis() - time);
    }
}
