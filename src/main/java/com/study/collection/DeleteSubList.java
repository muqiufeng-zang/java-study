package com.study.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  zcp
 * @description 快速删除List数据
 * @Date 2019/11/03
 */
public class DeleteSubList {


    /**
     * List接口有一个实例方法List<E> subList(int fromIndex, int toIndex)，其作用是返回一个以fromIndex为起始索引（包含），
     * 以toIndex为终止索引（不包含）的子列表（List）,两个列表具有关联关系。
     * 如果对父列表或子列表进行非结构性修改，对另一方都会产生影响。
     * 如果对父列表进行结构性修改，之前产生的子列表将会时效，调用时会产生一个ConcurrentModificationException异常。
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> test = new ArrayList<Integer>();
        //init list
        for (int i = 0; i < 5; i++) {
            test.add(i);    //auto boxing
        }
        //display the list
        System.out.print("原始 list: ");
        for (int i = 0; i < test.size(); i++) {
            System.out.print(test.get(i) + " ");
        }
        System.out.println();

        //sub list
        List<Integer> sub = test.subList(1, 3);       //sub list contains elements: 1, 2
        sub.remove(1);      //remove element “2” from sub list

        //display the list again
        System.out.print("通过修改子list后，原始list的值: ");
        for (int i = 0; i < test.size(); i++) {
            System.out.print(test.get(i) + " ");
        }
        System.out.println();

        //sub3 list
        List<Integer> sub3 = test.subList(0, 3);
        sub3.add(9);
        System.out.print("通过修改子list后，原始list的值: ");
        for (int i = 0; i < test.size(); i++) {
            System.out.print(test.get(i) + " ");
        }
        System.out.println();

        //sub2 list
        List<Integer> sub2 = test.subList(0, 3);
        test.add(9);
        System.out.print("通过修改原始list后，子list的值: ");
        for (int i = 0; i < sub2.size(); i++) {
            System.out.print(sub2.get(i) + " ");
        }

    }
}
