package com.study.object.znt;


/**
 * @author  znt
 * @description  Object.clone
 * @Date 2019/10/31
 */

public class CloneTest1 {

    private static final int COUNT = 10000 * 1000;

    public static void main(String[] args) {

        /**
         * 浅拷贝
         */
        ShadowClone c1= new ShadowClone();
        c1.setA(100);
        c1.setB(new int[]{1000});

        System.out.println("克隆前c1:  a="+c1.getA()+" b[0]="+c1.getB()[0]);
        ShadowClone c2 = c1.clone();
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
        DeepClone d2 = d1.clone();
        d2.setC(50) ;
        int []d = d2.getD() ;
        d[0]=5 ;
        c2.setB(d);
        System.out.println("克隆前d1:  c="+d1.getC()+" d[0]="+d1.getD()[0]);
        System.out.println("克隆后d2:  c="+d2.getC()+ " d[0]="+d2.getD()[0]);
        System.out.println();

        /**
         * 1.原型设计模式的思路：采用clone方式实现
         * 2.clone应用场景：
         * （1）对象之间相同或相似，即只是个别的几个属性不同的时候
         * （2）对象的创建过程比较麻烦，但复制比较简单的时候
         * 3.clone和new方式的效率上各有利弊吧，视需要复制的Object复制而定。
         * 4.个人觉得采用clone去实现，效率恐怕不是第一位考虑的，重要的是方便
         */
        long startTime;
        long endTime;

        System.out.println("=======使用无参构造函数======");
        startTime = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            ShadowClone shadow = new ShadowClone();
            shadow.setB(new int[]{1000});
        }
        endTime = System.currentTimeMillis();
        System.out.println("new1  = " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        ShadowClone shadow = new ShadowClone();
        shadow.setB(new int[]{1000});
        for (int i = 0; i < COUNT; i++) {
            ShadowClone shadow2 = shadow.clone();
        }
        endTime = System.currentTimeMillis();
        System.out.println("shadowClone1 = " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        DeepClone deep = new DeepClone();
        deep.setD(new int[]{1000});
        for (int i = 0; i < COUNT; i++) {
            DeepClone deep2 = deep.clone();
        }
        endTime = System.currentTimeMillis();
        System.out.println("deepClone1 = " + (endTime - startTime));


        System.out.println("=======使用有参构造函数======");
        int[] ch=new int[]{1000};
        startTime = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            ShadowClone shadow2 = new ShadowClone(50,1000);
        }
        endTime = System.currentTimeMillis();
        System.out.println("new2  = " + (endTime - startTime));


        startTime = System.currentTimeMillis();
        ShadowClone shadow2 = new ShadowClone(50,1000);
        for (int i = 0; i < COUNT; i++) {
            ShadowClone shadow3 = shadow2.clone();
        }
        endTime = System.currentTimeMillis();
        System.out.println("shadowClone2 = " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        DeepClone deep2 = new DeepClone(50,1000);
        for (int i = 0; i < COUNT; i++) {
            DeepClone deep3 = deep2.clone();
        }
        endTime = System.currentTimeMillis();
        System.out.println("deepClone2 = " + (endTime - startTime));


    }
}
