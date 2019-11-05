package com.study.object.znt;

/**
 * @author  znt
 * @description  提取重复部分，如果能将重复部分提至循环体外，尽量提取
 * @Date 2019/11/5
 */
public class Test3 {

    private static final int COUNT = 10000 * 10000;

    public static void  main(String[] args){
        long startTime,endTime;
        double a1 = Math.random();
        double a2 = Math.random();
        double a3 = Math.random();
        double a4 = Math.random();
        double b1,b2;
        startTime = System.currentTimeMillis();
        for(int i=0;i<COUNT;i++){
            b1 = a1*a2*a3*a4*4;
            b2 = a1*a2*a3*a4*3;
        }
        endTime = System.currentTimeMillis();
        System.out.println("不提取重复部分："+(endTime-startTime)+"ms");

        startTime = System.currentTimeMillis();
        double a5 = a1*a2*a3*a4;
        for(int i=0;i<COUNT;i++){
            b1 = a5*4;
            b2 = a5*3;
        }
        endTime = System.currentTimeMillis();
        System.out.println("提取重复部分："+(endTime-startTime)+"ms");
    }

}
