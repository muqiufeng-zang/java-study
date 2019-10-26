package com.study.string.zntstring;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author znt
 * @description 正则表达式优化
 * @Date 2019/10/26
 */
public class Test4 {

    public static void main(String[] args) {

        String str = "北京市(海淀区)(朝阳区)";
        int count = 100000;

        long startTime2 = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            str.matches(".*(?=\\()");
        }
        long endTime2 = System.currentTimeMillis();
        System.out.println("直接使用matches：" + (endTime2 - startTime2) + "ms");

        long startTime1 = System.currentTimeMillis();
        String paternStr = ".*(?=\\()";
        Pattern pattern = Pattern.compile(paternStr);
        for (int i = 0; i < count; i++) {
            Matcher m = pattern.matcher(str);
            m.matches();
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("采用compile1：" + (endTime1 - startTime1) + "ms");

        long startTime3 = System.currentTimeMillis();
        String paternStr3 = ".*(?=\\()";
        Pattern pattern3 = Pattern.compile(paternStr3);
        for (int i = 0; i < count; i++) {
            Matcher m3 = pattern3.matcher(str);
            m3.matches();
        }
        long endTime3 = System.currentTimeMillis();
        System.out.println("采用compile2：" + (endTime3 - startTime3) + "ms");

    }
}
