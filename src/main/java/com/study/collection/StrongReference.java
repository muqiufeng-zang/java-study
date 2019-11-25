package com.study.collection;

import java.util.ArrayList;

/**
 * @author zcp
 * 2019/11/17 下午6:56
 * Most is the gentleness which that one lowers the head,
 * looks like a water lotus flower extremely cool breeze charming.
 */
public class StrongReference {

    private static void test() {
        Object strongReference = new Object();
        // 省略其他操作
    }

    public static void main(String[] args){
        test();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
