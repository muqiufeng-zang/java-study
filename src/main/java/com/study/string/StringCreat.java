package com.study.string;

/**
 * @author  zcp
 * @description  String的创建
 * @Date 2019/10/13
 */
public class StringCreat {

    /**
     * 构建java string 对象有两种方式 1. 直接通过 = "" 进行赋值   2. 通过 new String()对象的方式 实例化一个 String 对象
     * 通过1 的方式进行创建 String 对象时，首先会去 维护 String 池的去查找 是否存在该 string ,如果不存在 直接创建一个新的string ，否
     * 则的话直接返回已存在字符串的内存地址，不再创建新string
     * 通过2 的方式进行创建 String 对象时，首先会在堆栈区创建一个对象，然后去 维护 String 池的去查找 是否存在该 string ,如果不存在直接
     * 创建一个新的string ，否则的话直接返回已存在字符串的内存地址，不再创建新string
     */
    public static void main(String[] args){
        String str1 = "abc";
        String str2 = "abc";
        String str3 = new String("abc");
        String str4 = str1;

        //检查str1 和 str2 是否使用相同地址
        System.out.println("检查str1 和 str2 是否使用相同地址 ? " + (str1 == str2));
        //检查str1 和 str3 是否使用相同地址
        System.out.println("检查str1 和 str3 是否使用相同地址 ? " + (str1 == str3));
        //检查str1 和 str3 的内容是否相同
        System.out.println("检查str1 和 str3 的内容是否相同 ? " + (str1.intern() == str2.intern()));
        //检查str1 和 str4 是否使用相同地址
        System.out.println("检查str1 和 str4 是否使用相同地址 ? " + (str1 == str4));
        //检查str3 和 str4 是否使用相同地址
        System.out.println("检查str3 和 str4 的内容是否相同 ? " + (str3.intern() == str4.intern()));
    }

}