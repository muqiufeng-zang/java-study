package com.study.object.znt;

/**
 * @author  znt
 * @description  移位运算符
 * @Date 2019/11/7
 */

public class Test4 {
    private static final int COUNT = 10000 * 10000;

    public static void main(String[] args){

        int num1 = 15/2;
        int num2=  15>>1;
        int num3 = 15>>>1;
        System.out.println(num1+" "+num2+" "+num3);

        int num4 = -15/2;
        int num5=  -15>>1;
        int num6 = -15>>>1;
        System.out.println(num4+" "+num5+" "+num6);

        /**
         * 0表示正数  1表示负数
         * 2147483640是在-15的基础上右移补0
         * -8是在-15的基础上右移补1
         */
        System.out.println(Integer.toBinaryString(15));
        System.out.println(Integer.toBinaryString(-15));
        System.out.println(Integer.toBinaryString(-8));
        System.out.println(Integer.toBinaryString(2147483640));

        int num7 = 15*2;
        int num8 = 15<<1;
        int num9 = -15*2;
        int num10 = -15<<1;
        System.out.println(num7+" "+num8+" "+num9+" "+num10);

        /**
         * 对于乘法（*）、%这些因为JVM进行了优化，直接使用即可。
         * 而对于除法（/），利用按位右移的方式还是很有必要的，速度上可以省不少时间
         */
        long startTime,endTime;
        int result=COUNT;
        startTime=System.currentTimeMillis();
        for(int i=0;i<COUNT;i++){
            result*=2;
        }
        endTime = System.currentTimeMillis();
        System.out.println("通过* 乘的方式："+(endTime-startTime)+"ms");

        startTime=System.currentTimeMillis();
        for(int i=0;i<COUNT;i++){
            result <<= 1;
        }
        endTime = System.currentTimeMillis();
        System.out.println("通过<<左移的方式："+(endTime-startTime)+"ms");


        startTime=System.currentTimeMillis();
        for(int i=0;i<COUNT;i++){
           result/=2;
        }
        endTime = System.currentTimeMillis();
        System.out.println("通过/ 除的方式："+(endTime-startTime)+"ms");

        startTime=System.currentTimeMillis();
        for(int i=0;i<COUNT;i++){
            result >>= 1;
        }
        endTime = System.currentTimeMillis();
        System.out.println("通过>>右移的方式："+(endTime-startTime)+"ms");


    }
}
