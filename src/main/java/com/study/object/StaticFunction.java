package com.study.object;

/**
 * @author  zcp
 * @description 静态方法与普通实例方法 的效率对比
 * @Date 2019/11/03
 */
public class StaticFunction {


    public static void staticFunction(){
    }

    public void instanceFunction(){
    }

    /**
     * 目前执行 一千万次  都没有看出明显差距
     * @param args
     */
    public static void main(String[] args){
        long s1 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            staticFunction();
        }
        StaticFunction staticFunction = new StaticFunction();
        long s2 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            staticFunction.instanceFunction();
        }
        long s3 = System.currentTimeMillis();
        System.out.println("static  = " + (s2 - s1));
        System.out.println("instance = " + (s3 - s2));
    }
}
