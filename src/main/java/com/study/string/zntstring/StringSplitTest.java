package com.study.string.zntstring;

import com.study.string.zntstring.calobject.ClassIntrospector;

import java.util.StringTokenizer;

/**
 * @author  znt
 * @description  字符串分割性能比较
 * @Date 2019/10/16
 */
public class StringSplitTest {

    private StringBuffer buffer = new StringBuffer();
    private static int MAX_NUM=10000000;
    private String  append = "abcd";
    private String regex=",,,&&&";

    public StringSplitTest(){
        for(int i=0;i<MAX_NUM;i++){
            buffer.append(append);
            buffer.append(regex);
        }
    }

    public void getSize(){
        try {
            final ClassIntrospector ci = new ClassIntrospector();
            System.out.println("查找字符串的内存大小为："+ci.introspect(buffer.toString()).getDeepSize()/1024+"KB");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void splitTest(){
        long startTime = System.currentTimeMillis();

        String[] str =buffer.toString().split(regex);

        long endTime =System.currentTimeMillis();
        System.out.println("split: "+(endTime-startTime)+"ms");
    }

    public void stringTokenizerTest(){
        long startTime = System.currentTimeMillis();

        //str的StringTokenizer对象，并提供一个指定的分隔符，同时，指定是否返回分隔符
        StringTokenizer st = new StringTokenizer(buffer.toString(),regex);
        while(st.hasMoreElements()){
            String x = st.nextToken();
        }

        long endTime =System.currentTimeMillis();
        System.out.println("StringTokenizerTest: "+(endTime-startTime)+"ms");
    }

    public void subStringTest(){
        long startTime = System.currentTimeMillis();

        int strLen = regex.length();
        int count=0;
        int k=0;
        String str = buffer.toString();
        for(int i=0;i+strLen<str.length();i++){
            if(str.substring(i,i+strLen).equals(regex)){
                if(count==0){
                   str.substring(0,i);
                }else{
                    str.substring(k,i);
                }
                count++;
                i=i+strLen;
                k=i;
            }
        }

        long endTime =System.currentTimeMillis();
        System.out.println("subStringTest: "+(endTime-startTime)+"ms");

    }
}
