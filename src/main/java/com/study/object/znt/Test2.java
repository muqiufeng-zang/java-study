package com.study.object.znt;


/**
 * @author  znt
 * @description
 * 多使用局部变量，而非静态变量
 * (差别不大，尽量减少静态变量，更多的地是从回收考虑，gc不会在程序运行期间回收静态变量)
 * @Date 2019/11/5
 */

public class Test2 {
    private static final int COUNT = 10000 * 10000;
    public static int b=0;

    public static void main(String[] agrs){

        int a=0;
        long startTime,endTime;
        startTime = System.currentTimeMillis();
        for(int i=0;i<COUNT;i++){
            a++;
        }
        endTime = System.currentTimeMillis();
        System.out.println("使用局部变量a："+(endTime-startTime)+"ms");

        startTime = System.currentTimeMillis();
        for (int i=0;i<COUNT;i++){
            b++;
        }
        endTime = System.currentTimeMillis();
        System.out.println("使用静态变量b: "+(endTime-startTime)+"ms");

    }


}
