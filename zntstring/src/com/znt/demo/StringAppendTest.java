package com.znt.demo;

/**
 * @author  znt
 * @description  String拼接比较
 * @Date 2019/10/12
 */
public class StringAppendTest {

    public void  testPlus(){
        String str = "";
        long startTime = System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            str = str+String.valueOf(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("+ 拼接方式费时："+(endTime-startTime)+"ms");
    }

    public void  testConcat(){
        String str = "";
        long startTime = System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            str = str.concat(String.valueOf(i));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("concat 拼接方式费时："+(endTime-startTime)+"ms");
    }

    public void  testStringBuffer(){
        StringBuffer str = new StringBuffer();
        long startTime = System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            str.append(String.valueOf(i));
        }
        str.toString();
        long endTime = System.currentTimeMillis();
        System.out.println("StringBuffer 拼接方式费时："+(endTime-startTime)+"ms");
    }

    public void  testStringBuilder(){
        StringBuilder str =new StringBuilder();
        long startTime = System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            str.append(String.valueOf(i));
        }
        str.toString();
        long endTime = System.currentTimeMillis();
        System.out.println("StringBuilder 拼接方式费时："+(endTime-startTime)+"ms");
    }


}
