package com.study.string.zntstring;

import java.io.UnsupportedEncodingException;

/**
 * @author  znt
 * @description 字符串重编码
 * @Date 2019/10/21
 */
public class Test3 {

    /**
     * 常见的编码格式
     * 1.ASCII 码
     * 2.ISO-8859-1
     * 3.GB2312
     * 4.GBK
     * 5.GB18030
     * 6.UTF-16
     * 7.UTF-8
     * 常见的编码场景
     * 1.内存操作
     * （字串到字节的数据类型转换，
     * Java 中用 String 表示字符串，所以 String 类就提供转换到字节的方法，也支持将字节转换为字符串的构造函数
     * ）
     * 2.I/O操作（磁盘 I/O --数据库、文件等读取和存储 和网络 I/O--web应用）
     * （
     * 注意指定统一的编解码 Charset 字符集，一般不会出现乱码问题，
     * 有些应用程序如果不注意指定字符编码，中文环境中取操作系统默认编码，
     * 如果编解码都在中文环境中，通常也没问题，
     * 但是还是强烈的不建议使用操作系统的默认编码，因为这样，
     * 你的应用程序的编码格式就和运行环境绑定起来了，在跨环境下很可能出现乱码问题
     * ）
     * 如何进行编码和解码
     *
     */

    public static void main(String[] args) throws UnsupportedEncodingException {

        /**
         * 内存操作
         * String类型的默认编码方式是和本地编码方式相关，默认本地编码为UTF-8
         * 正确转码方式：转码之后用该码重新构建一个字符串
         */
        System.out.println("转码前，输入Java系统属性如下：");
        System.out.println("user.country: "+System.getProperty("user.country"));
        System.out.println("user.language: "+System.getProperty("user.language"));
        System.out.println("sun.jnu.encoding: "+System.getProperty("sun.jnu.encoding"));
        System.out.println("file.encoding: "+System.getProperty("file.encoding"));

        System.out.println("转码之后的输出： ");
        // 使用String的有参构造方法
        String str = "hello,我要进行转码之旅了~##@#@#￥￥￥";
        String s1 = new String(str.getBytes(),"UTF-8");
        String s2 = new String(str.getBytes("UTF-8"),"UTF-8");
        String s3 = new String(str.getBytes("UTF-8"));
        String s4 = new String(str.getBytes(),"GBK");
        //如果转码之后，又用该码来构建一个字符串，是绝对不会出现乱码的
        String s5 = new String(str.getBytes("GBK"),"GBK");
        String s6 = new String(str.getBytes("GBK"));
        //输出正确，因为系统编码为UTF-8
        System.out.println(s1);
        //输出正确，采用正确的方式进行转码
        System.out.println(s2);
        //输出正确，因为系统编码为UTF-8
        System.out.println(s3);
        //输出乱码
        System.out.println(s4);
        //输出正确，采用正确的方式进行转码
        System.out.println(s5);
        //输出乱码
        System.out.println(s6);
        System.out.println();


        byte[] b = str.getBytes();
        for(int i=0;i<b.length;i++){
            System.out.print(b[i]);
        }
        System.out.println();
        myEncode(str,"UTF-8");
        myEncode(str,"GBK");
        myEncode(str,"UTF-16");
        myEncode(str,"GB18030");
        myEncode(str,"ASCII");


    }

    public static void myEncode(String str,String charset){
        try {
            //转码
            byte[] b = str.getBytes(charset);
            for (int i = 0; i < b.length; i++) {
                System.out.print(b[i]);
            }
            System.out.println();
            String result = new String(b, charset);
            System.out.println(result);
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
    }
}
