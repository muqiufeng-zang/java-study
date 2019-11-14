package com.study.collection.znt;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  znt
 * @description  subList方法
 * @Date 2019/11/13
 */
public class SubList1 {

    public static void main(String[] args){

        /**
         * 除了ArrayList，还要注意LinkedList\Vector都存在该问题
         * (PS:类似功能String.subString则是生成新的子串，因此不存在该问题)
         * 使用建议：
         * 1.如果是通过subList来修改父List的目的，则切记要修改操作完成后，才能操作父类
         * 2.如果是通过subList方式来获取字串，建议获取完后，生成新的list，避免关联导致的异常
         */
        List<String> name = new ArrayList<>();
        name.add("Elsa");
        name.add("Lily");
        name.add("Shirley");

        System.out.println("直接使用subList：");
        List<String>  subList1 = name.subList(1,2);
        subList1.add("Bob");
        for(String s:subList1){ System.out.print(s+" "); }
        System.out.println();
        for(String s:name){ System.out.print(s+" "); }
        System.out.println();

        System.out.println("获取subList后生成一个新对象：");
        List<String>  subList2 = new ArrayList<>(name.subList(1,2));
        subList2.add("Linda");
        for(String s:subList2){ System.out.print(s+" "); }
        System.out.println();
        for(String s:name){ System.out.print(s+" "); }
        System.out.println();

        System.out.println("获取subList后使用addAll方式添加到新的对象中:");
        List<String>  subList3 = new ArrayList<>();
        subList3.addAll(name.subList(1,2));
        subList3.add("Mary");
        for(String s:subList3){ System.out.print(s+" "); }
        System.out.println();
        for(String s:name){ System.out.print(s+" "); }








    }

}
