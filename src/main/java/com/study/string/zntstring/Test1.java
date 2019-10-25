package com.study.string.zntstring;

import com.study.string.zntstring.calobject.ClassIntrospector;

/**
 * @author  znt
 * @description
 * （1）String对象
 * （2）String拼接
 * （3）String中substring()使用
 * @Date 2019/10/12
 */

public class Test1 {

    public static void main(String[] args){

        /**
         * String对象创建
         */
        String str1="abc";
        String str2 = "abc";
        String str3 = new String("abc");
        String str4 =str1;
        String str5= str1.substring(1,2);


        /**
         * String对象内存大小比较
         */
        System.out.println("String对象内存大小比较：");
        try {
            final ClassIntrospector ci = new ClassIntrospector();
            char[] ch={};
            String str="";
            StringBuilder strbuilder =new StringBuilder();
            StringBuffer strbuffer =new StringBuffer();
            System.out.println("ch:" + ci.introspect(ch).getDeepSize());
            System.out.println("String:" + ci.introspect("").getDeepSize());
            System.out.println("String str:" + ci.introspect(str).getDeepSize());
            System.out.println("StringBuilder:" + ci.introspect(strbuilder).getDeepSize());
            System.out.println("StringBuffer:" + ci.introspect(strbuffer).getDeepSize());
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println();

        /**
         * String对象equal和==
         */
        System.out.println("string中equal和==比较：");
        System.out.println(str1==str2);
        System.out.println(str1==str3);
        System.out.println(str1==str4);
        System.out.println(str1.equals(str2));
        System.out.println(str1.equals(str3));
        System.out.println(str1.equals(str4));
        System.out.println();

        /**
         * String对象的hashcode
         */
        System.out.println("hashcode值：");
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
        System.out.println(str3.hashCode());
        System.out.println(str4.hashCode());
        System.out.println(str5.hashCode());
        System.out.println();


        /**
         * String对象拼接方式比较
         */
        System.out.println("String对象拼接方式比较:");
        StringAppendTest test = new StringAppendTest();
        test.testPlus();
        test.testConcat();
        test.testStringBuffer();
        test.testStringBuilder();
    }
}
