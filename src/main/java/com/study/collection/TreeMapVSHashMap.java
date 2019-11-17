package com.study.collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author zcp
 * 2019/11/17 下午5:40
 * Most is the gentleness which that one lowers the head,
 * looks like a water lotus flower extremely cool breeze charming.
 *
 * TreeMap<K,V>的Key值是要求实现java.lang.Comparable，所以迭代的时候TreeMap默认是按照Key值升序排序的；TreeMap的实现是基于红黑树结构。
 * 适用于按自然顺序或自定义顺序遍历键（key）。
 * HashMap<K,V>的Key值实现散列hashCode()，分布是散列的、均匀的，不支持排序；数据结构主要是桶(数组)，链表或红黑树。适用于在Map中插入、
 * 删除和定位元素。
 * 如果需要得到一个有序的结果时就应该使用TreeMap（因为HashMap中元素的排列顺序是不固定的）。除此之外，由于HashMap有更好的性能，所以大多不
 * 需要排序的时候我们会使用HashMap。
 */
public class TreeMapVSHashMap {

    /**
     * TreeMap中默认是按照升序进行排序的，如何想让她实现降序，需要自定义一个比较器，并将比较器作为TreeMap的构造参数。其他的排序效果一样。
     * @param args
     */
    public static void main(String[] args) {
        //初始化自定义比较器
        MyComparator comparator = new MyComparator();
        //初始化一个map集合
        Map<String,String> map = new TreeMap<String,String>(comparator);
        //存入数据
        map.put("a", "a");
        map.put("b", "b");
        map.put("f", "f");
        map.put("d", "d");
        map.put("c", "c");
        map.put("g", "g");
        map.put("e", "e");
        //遍历输出
        for (String key : map.keySet()) {
            System.out.println(map.get(key));
        }
    }

    static class MyComparator implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            // TODO Auto-generated method stub
            String param1 = (String)o1;
            String param2 = (String)o2;
            return -param1.compareTo(param2);
        }

    }

}
