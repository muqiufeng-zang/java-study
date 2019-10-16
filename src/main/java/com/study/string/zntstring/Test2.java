package com.study.string.zntstring;

/**
 * @author  znt
 * @description
 * （1）查找单个字符
 * （2）"" 和 '' 区别
 * （3）分割字符串 Split StringTokenizer subString
 * @Date 2019/10/16
 */
public class Test2 {

    public static void main(String[] args){
        String str = "";
        for(int i=0;i<1000;i++){
            str = str+String.valueOf(i);
        }
        /**
         * startsWith用于检测字符串是否以指定的前缀开始
         * 如果前缀只是单个字符时，可以使用charAt替代，速度更快（从实现就可以区分）
         */
        if(str.charAt(0)=='0'){
            System.out.println("charAt");
        }
        if(str.startsWith("0")){
            System.out.println("startsWith");
        }
        System.out.println();

        /**
         * 如果处理单个字符，建议用单引号
         * （1）单引号引的数据 是char类型的，但是只能引一个字符
         * （2）双引号引的数据 是String类型的
         * char作为基本类型，速度更快
         */
        char ch='C';
        String s =str+'C';

        /**
         * 分割字符串
         * Split StringTokenizer subString
         * （1）数据量较少的时候，用split会更快点，但是相差不多
         * （2）大数据量的时候，StringTokenizer比split快很多，相差比较明显
         * （3）采用subString的方式速度比spilt快，比StringTokenizer慢点，但是实现起来比较复杂
         * （4）源码了解
         * 1.split中regex是以下2种情况，则直接处理（直接处理时，会更快一些）
         * 单字符情况下regex不等于正则表达式的元字符(meta character)：.$|()[{^?*+\\
         * 双字符情况下regex第一个字符是反斜杠，第二个字符不是Unicode编码中的数字或字母
         * 非以上情况则调用正则表达式的spilt
         * 参考链接：https://blog.csdn.net/gcola007/article/details/82977139
         * 2.StringTokenizer则采用逐字分裂字符的方式
         */

        StringSplitTest test = new StringSplitTest();
        test.getSize();
        test.splitTest();
        test.stringTokenizerTest();
        test.subStringTest();


    }
}
