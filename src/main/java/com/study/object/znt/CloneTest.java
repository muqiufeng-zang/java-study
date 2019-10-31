package com.study.object.znt;


import com.study.object.Bean;

import java.net.Socket;

/**
 * @author  znt
 * @description  Object.clone
 * @Date 2019/10/31
 */

public class CloneTest {

    private static final int COUNT = 10000 * 1000;

    public static void main(String[] args) {

        /**
         * 浅拷贝
         */
        ShadowClone c1= new ShadowClone();
        c1.setA(100);
        c1.setB(new int[]{1000});

        System.out.println("克隆前c1:  a="+c1.getA()+" b[0]="+c1.getB()[0]);
        ShadowClone c2 = (ShadowClone) c1.clone();
        c2.setA(50) ;
        int []b = c2.getB() ;
        b[0]=5 ;
        c2.setB(b);
        System.out.println("克隆前c1:  a="+c1.getA()+" b[0]="+c1.getB()[0]);
        System.out.println("克隆后c2:  a="+c2.getA()+ " b[0]="+c2.getB()[0]);
        System.out.println();

        /**
         * 深拷贝
         */
        DeepClone d1= new DeepClone();
        d1.setC(100);
        d1.setD(new int[]{1000});

        System.out.println("克隆前d1:  c="+d1.getC()+" d[0]="+d1.getD()[0]);
        DeepClone d2 = (DeepClone) d1.clone();
        d2.setC(50) ;
        int []d = d2.getD() ;
        d[0]=5 ;
        c2.setB(d);
        System.out.println("克隆前d1:  c="+d1.getC()+" d[0]="+d1.getD()[0]);
        System.out.println("克隆后d2:  c="+d2.getC()+ " d[0]="+d2.getD()[0]);
        System.out.println();

        /**
         * 深拷贝、浅拷贝和new 效率对比
         */
        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            ShadowClone shadow = new ShadowClone();
        }
        endTime = System.currentTimeMillis();
        System.out.println("new  = " + (endTime - startTime));


        startTime = System.currentTimeMillis();
        ShadowClone shadow = new ShadowClone();
        for (int i = 0; i < COUNT; i++) {
            ShadowClone shadow2 = (ShadowClone)shadow.clone();
        }
        endTime = System.currentTimeMillis();
        System.out.println("shadowClone = " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        DeepClone deep = new DeepClone();

        for (int i = 0; i < COUNT; i++) {
            DeepClone deep2 = (DeepClone)deep.clone();
        }
        endTime = System.currentTimeMillis();
        System.out.println("deepClone = " + (endTime - startTime));

        Socket s = new Socket();


    }
}
